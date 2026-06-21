# PointHistoryException

API 분류 태그: API Exception
태그: [포인트] 포인트 내역 조회

1. 월 형식 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "월 형식 오류",
  "message": "400 BAD_REQUEST \"월 형식이 올바르지 않습니다.\"",
  "details": "uri=/api/points/history",
  "errorCode": "INVALID_MONTH_FORMAT"
}
```