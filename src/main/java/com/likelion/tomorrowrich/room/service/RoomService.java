package com.likelion.tomorrowrich.room.service;

import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.room.dto.InventoryItemListResponseDTO;
import com.likelion.tomorrowrich.room.dto.ItemApplyResponseDTO;
import com.likelion.tomorrowrich.room.dto.ItemUnapplyResponseDTO;
import com.likelion.tomorrowrich.room.dto.RoomResponseDTO;
import com.likelion.tomorrowrich.room.entity.Room;
import com.likelion.tomorrowrich.room.repository.RoomRepository;
import com.likelion.tomorrowrich.shop.entity.Item;
import com.likelion.tomorrowrich.shop.entity.ItemType;
import com.likelion.tomorrowrich.shop.entity.UserItem;
import com.likelion.tomorrowrich.shop.repository.ItemRepository;
import com.likelion.tomorrowrich.shop.repository.UserItemRepository;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoomService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    public RoomService(
            UserRepository userRepository,
            RoomRepository roomRepository,
            ItemRepository itemRepository,
            UserItemRepository userItemRepository
    ) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.itemRepository = itemRepository;
        this.userItemRepository = userItemRepository;
    }

    public RoomResponseDTO getRoom(Long userId) {
        User user = findUser(userId);
        Room room = findRoom(user);

        List<RoomResponseDTO.ItemDTO> appliedItems = getAppliedItemDTOs(user);

        return new RoomResponseDTO(
                room.getId(),
                defaultString(user.getCharacterName()),
                user.getCurrentPoint(),
                appliedItems
        );
    }

    public List<InventoryItemListResponseDTO> getInventoryItems(
            Long userId,
            String type
    ) {
        User user = findUser(userId);
        ItemType itemType = parseItemType(type);

        List<UserItem> userItems = findInventoryItems(user, itemType);

        return userItems.stream()
                .map(this::toInventoryItemDTO)
                .toList();
    }

    @Transactional
    public ItemApplyResponseDTO applyItem(Long userId, Long itemId) {
        User user = findUser(userId);
        findRoom(user);

        Item item = findItem(itemId);
        UserItem userItem = userItemRepository.findByUserAndItem(user, item)
                .orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_OWNED));

        userItem.apply();

        List<RoomResponseDTO.ItemDTO> appliedItems = getAppliedItemDTOs(user);

        return new ItemApplyResponseDTO(
                item.getId(),
                userItem.getApplied(),
                new ItemApplyResponseDTO.RoomDTO(appliedItems)
        );
    }

    @Transactional
    public ItemUnapplyResponseDTO unapplyItem(Long userId, Long itemId) {
        User user = findUser(userId);

        UserItem userItem = userItemRepository.findByUserAndItem_Id(user, itemId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_APPLIED));

        if (!Boolean.TRUE.equals(userItem.getApplied())) {
            throw new BusinessException(ErrorCode.ITEM_NOT_APPLIED);
        }

        userItem.unapply();

        return new ItemUnapplyResponseDTO(
                itemId,
                userItem.getApplied()
        );
    }

    private List<UserItem> findInventoryItems(User user, ItemType itemType) {
        if (itemType == null) {
            return userItemRepository.findAllByUserOrderByIdAsc(user);
        }

        return userItemRepository.findAllByUserAndItem_ItemTypeOrderByIdAsc(user, itemType);
    }

    private List<RoomResponseDTO.ItemDTO> getAppliedItemDTOs(User user) {
        return userItemRepository.findAllByUserAndAppliedTrue(user)
                .stream()
                .map(this::toRoomItemDTO)
                .toList();
    }

    private RoomResponseDTO.ItemDTO toRoomItemDTO(UserItem userItem) {
        Item item = userItem.getItem();

        return new RoomResponseDTO.ItemDTO(
                item.getId(),
                item.getName(),
                item.getItemType().name(),
                item.getImageUrl()
        );
    }

    private InventoryItemListResponseDTO toInventoryItemDTO(UserItem userItem) {
        Item item = userItem.getItem();

        return new InventoryItemListResponseDTO(
                item.getId(),
                item.getName(),
                item.getItemType().name(),
                item.getImageUrl(),
                userItem.getApplied()
        );
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

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    }

    private Room findRoom(User user) {
        return roomRepository.findByUser(user)
                .orElseThrow(() -> new BusinessException(ErrorCode.ROOM_NOT_FOUND));
    }

    private Item findItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));
    }

    private String defaultString(String value) {
        return value == null ? "" : value;
    }
}