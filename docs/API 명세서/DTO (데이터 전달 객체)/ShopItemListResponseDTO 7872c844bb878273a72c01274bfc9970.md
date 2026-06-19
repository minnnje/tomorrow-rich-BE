# ShopItemListResponseDTO

API 분류 태그: API Response
태그: [상점] 아이템 목록 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| currentPoint | Integer | Y | 현재 보유 포인트 |
| items | List<ShopItemDTO> | Y | 상점 아이템 목록 |

### body

```json
{
  "currentPoint": 12800,
  "items": [
    {
      "itemId": 1,
      "name": "원목 책상",
      "itemType": "FURNITURE",
      "price": 5000,
      "imageUrl": "/items/desk.png",
      "owned": false,
      "applied": false
    }
  ]
}
```