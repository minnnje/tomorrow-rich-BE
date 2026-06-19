# ItemPurchaseException

API 분류 태그: API Exception
태그: [상점] 아이템 구매

1. 아이템 없음

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "아이템 없음",
  "message": "404 NOT_FOUND \"아이템을 찾을 수 없습니다.\"",
  "details": "uri=/api/shop/items/{itemId}/purchase",
  "errorCode": "ITEM_NOT_FOUND"
}
```

1. 포인트 부족

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "포인트 부족",
  "message": "400 BAD_REQUEST \"포인트가 부족합니다.\"",
  "details": "uri=/api/shop/items/{itemId}/purchase",
  "errorCode": "NOT_ENOUGH_POINT"
}
```

1. 이미 구매한 아이템

```json
{
  "timestamp": "시간",
  "statusCode": 409,
  "error": "이미 구매한 아이템",
  "message": "409 CONFLICT \"이미 구매한 아이템입니다.\"",
  "details": "uri=/api/shop/items/{itemId}/purchase",
  "errorCode": "ITEM_ALREADY_OWNED"
}
```