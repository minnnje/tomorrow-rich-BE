# ItemPurchaseResponseDTO

API 분류 태그: API Response
태그: [상점] 아이템 구매

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| itemId | Long | Y | 구매한 아이템 ID |
| name | String | Y | 아이템 이름 |
| price | Integer | Y | 사용 포인트 |
| currentPoint | Integer | Y | 구매 후 보유 포인트 |
| owned | Boolean | Y | 보유 여부 |

### body

```json
{
  "itemId": 1,
  "name": "원목 책상",
  "price": 5000,
  "currentPoint": 7800,
  "owned": true
}
```