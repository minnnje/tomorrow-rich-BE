# CalendarDayException

API 분류 태그: API Exception
태그: [캘린더] 날짜 상세 조회

1. 날짜 형식 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "날짜 형식 오류",
  "message": "400 BAD_REQUEST \"날짜 형식이 올바르지 않습니다.\"",
  "details": "uri=/api/calendar/days/{date}",
  "errorCode": "INVALID_DATE_FORMAT"
}
```

1. 미래 날짜 조회 제한

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "미래 날짜 조회 제한",
  "message": "400 BAD_REQUEST \"아직 기록할 수 없는 날짜입니다.\"",
  "details": "uri=/api/calendar/days/{date}",
  "errorCode": "FUTURE_DATE_NOT_ALLOWED"
}
```