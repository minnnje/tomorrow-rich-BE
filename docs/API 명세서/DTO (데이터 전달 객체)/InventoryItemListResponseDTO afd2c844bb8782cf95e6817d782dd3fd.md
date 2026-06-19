# InventoryItemListResponseDTO

API 분류 태그: API Response
태그: [방] 보유 아이템 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| itemId | Long | Y | 아이템 ID |
| name | String | Y | 아이템 이름 |
| itemType | String | Y | 아이템 타입 |
| imageUrl | String | Y | 이미지 URL |
| applied | Boolean | Y | 현재 적용 여부 |

### body

```json
[
  {
    "itemId": 1,
    "name": "원목 책상",
    "itemType": "FURNITURE",
    "imageUrl": "/items/desk.png",
    "applied": true
  }
]
```