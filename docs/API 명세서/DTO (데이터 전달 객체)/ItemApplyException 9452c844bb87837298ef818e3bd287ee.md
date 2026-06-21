# ItemApplyException

API 분류 태그: API Exception
태그: [방] 아이템 적용

1. 보유하지 않은 아이템

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "보유하지 않은 아이템",
  "message": "404 NOT_FOUND \"보유하지 않은 아이템입니다.\"",
  "details": "uri=/api/room/items/{itemId}/apply",
  "errorCode": "ITEM_NOT_OWNED"
}
```

1. 아이템 없음

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "아이템 없음",
  "message": "404 NOT_FOUND \"아이템을 찾을 수 없습니다.\"",
  "details": "uri=/api/room/items/{itemId}/apply",
  "errorCode": "ITEM_NOT_FOUND"
}
```