package com.likelion.tomorrowrich.shop.controller;

import com.likelion.tomorrowrich.global.security.SecurityUtil;
import com.likelion.tomorrowrich.shop.dto.ItemPurchaseResponseDTO;
import com.likelion.tomorrowrich.shop.dto.ShopItemListResponseDTO;
import com.likelion.tomorrowrich.shop.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;
    private final SecurityUtil securityUtil;

    public ShopController(
            ShopService shopService,
            SecurityUtil securityUtil
    ) {
        this.shopService = shopService;
        this.securityUtil = securityUtil;
    }

    @GetMapping("/items")
    public ResponseEntity<ShopItemListResponseDTO> getShopItems(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean owned
    ) {
        Long userId = securityUtil.getCurrentUserId();

        ShopItemListResponseDTO response = shopService.getShopItems(userId, type, owned);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/items/{itemId}/purchase")
    public ResponseEntity<ItemPurchaseResponseDTO> purchaseItem(
            @PathVariable Long itemId
    ) {
        Long userId = securityUtil.getCurrentUserId();

        ItemPurchaseResponseDTO response = shopService.purchaseItem(userId, itemId);

        return ResponseEntity.ok(response);
    }
}