# RoomResponseDTO

API 분류 태그: API Response
태그: [방] 내 방 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| roomId | Long | Y | 방 ID |
| characterName | String | Y | 말랑이 이름 |
| currentPoint | Integer | Y | 현재 보유 포인트 |
| appliedItems | List<ItemDTO> | Y | 현재 적용된 아이템 목록 |

### body

```json
{
  "roomId": 1,
  "characterName": "말랑이",
  "currentPoint": 7800,
  "appliedItems": [
    {
      "itemId": 1,
      "name": "원목 책상",
      "itemType": "FURNITURE",
      "imageUrl": "/items/desk.png"
    }
  ]
}
```