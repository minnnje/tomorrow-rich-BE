# ItemApplyResponseDTO

API 분류 태그: API Response
태그: [방] 아이템 적용

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| itemId | Long | Y | 적용한 아이템 ID |
| applied | Boolean | Y | 적용 여부 |
| room | Object | Y | 적용 후 방 정보 |

### body

```json
{
  "itemId": 1,
  "applied": true,
  "room": {
    "appliedItems": [
      {
        "itemId": 1,
        "name": "원목 책상",
        "itemType": "FURNITURE",
        "imageUrl": "/items/desk.png"
      }
    ]
  }
}
```