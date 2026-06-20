package com.likelion.tomorrowrich.shop.service;

import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.point.entity.PointHistory;
import com.likelion.tomorrowrich.point.entity.PointHistoryType;
import com.likelion.tomorrowrich.point.repository.PointHistoryRepository;
import com.likelion.tomorrowrich.shop.dto.ItemPurchaseResponseDTO;
import com.likelion.tomorrowrich.shop.dto.ShopItemDTO;
import com.likelion.tomorrowrich.shop.dto.ShopItemListResponseDTO;
import com.likelion.tomorrowrich.shop.entity.Item;
import com.likelion.tomorrowrich.shop.entity.ItemType;
import com.likelion.tomorrowrich.shop.entity.UserItem;
import com.likelion.tomorrowrich.shop.repository.ItemRepository;
import com.likelion.tomorrowrich.shop.repository.UserItemRepository;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ShopService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;
    private final PointHistoryRepository pointHistoryRepository;

    public ShopService(
            UserRepository userRepository,
            ItemRepository itemRepository,
            UserItemRepository userItemRepository,
            PointHistoryRepository pointHistoryRepository
    ) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.userItemRepository = userItemRepository;
        this.pointHistoryRepository = pointHistoryRepository;
    }

    public ShopItemListResponseDTO getShopItems(
            Long userId,
            String type,
            Boolean owned
    ) {
        User user = findUser(userId);
        ItemType itemType = parseItemType(type);

        List<Item> items = findItems(itemType);

        Map<Long, UserItem> userItemMap = userItemRepository.findAllByUser(user)
                .stream()
                .collect(Collectors.toMap(
                        userItem -> userItem.getItem().getId(),
                        userItem -> userItem
                ));

        List<ShopItemDTO> itemDTOs = items.stream()
                .map(item -> toShopItemDTO(item, userItemMap.get(item.getId())))
                .filter(item -> filterByOwned(item, owned))
                .toList();

        return new ShopItemListResponseDTO(
                user.getCurrentPoint(),
                itemDTOs
        );
    }

    @Transactional
    public ItemPurchaseResponseDTO purchaseItem(Long userId, Long itemId) {
        User user = findUser(userId);
        Item item = findItem(itemId);

        validateNotOwned(user, item);
        validateEnoughPoint(user, item);

        user.spendPoint(item.getPrice());

        UserItem userItem = new UserItem(user, item);
        userItemRepository.save(userItem);

        pointHistoryRepository.save(new PointHistory(
                user,
                PointHistoryType.SPEND,
                item.getPrice(),
                item.getName() + " 아이템 구매"
        ));

        return new ItemPurchaseResponseDTO(
                item.getId(),
                item.getName(),
                item.getPrice(),
                user.getCurrentPoint(),
                true
        );
    }

    private List<Item> findItems(ItemType itemType) {
        if (itemType == null) {
            return itemRepository.findAllByOrderByIdAsc();
        }

        return itemRepository.findAllByItemTypeOrderByIdAsc(itemType);
    }

    private ShopItemDTO toShopItemDTO(Item item, UserItem userItem) {
        boolean owned = userItem != null;
        boolean applied = userItem != null && Boolean.TRUE.equals(userItem.getApplied());

        return new ShopItemDTO(
                item.getId(),
                item.getName(),
                item.getItemType().name(),
                item.getPrice(),
                item.getImageUrl(),
                owned,
                applied
        );
    }

    private boolean filterByOwned(ShopItemDTO item, Boolean owned) {
        if (owned == null) {
            return true;
        }

        return item.owned().equals(owned);
    }

    private ItemType parseItemType(String type) {
        if (type == null || type.isBlank()) {
            return null;
        }

        try {
            return ItemType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new BusinessException(ErrorCode.INVALID_ITEM_TYPE);
        }
    }

    private void validateNotOwned(User user, Item item) {
        if (userItemRepository.existsByUserAndItem(user, item)) {
            throw new BusinessException(ErrorCode.ITEM_ALREADY_OWNED);
        }
    }

    private void validateEnoughPoint(User user, Item item) {
        if (user.getCurrentPoint() < item.getPrice()) {
            throw new BusinessException(ErrorCode.NOT_ENOUGH_POINT);
        }
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    }

    private Item findItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));
    }
}