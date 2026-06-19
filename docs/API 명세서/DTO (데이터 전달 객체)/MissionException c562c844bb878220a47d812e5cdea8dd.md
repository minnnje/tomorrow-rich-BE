# MissionException

API 분류 태그: API Exception
태그: [미션] 날짜별 미션 조회

1. 날짜 형식 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
		  "error": "날짜 형식 오류",
  "message": "400 BAD_REQUEST \"날짜 형식이 올바르지 않습니다.\"",
  "details": "uri=/api/missions",
  "errorCode": "INVALID_DATE_FORMAT"
}
```