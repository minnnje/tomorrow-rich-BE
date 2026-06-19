# CheckLoginIdException

API 분류 태그: API Exception
태그: [인증] 아이디 중복 확인

1. 아이디 미입력

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "아이디 미입력",
  "message": "400 BAD_REQUEST \"아이디를 입력해 주세요.\"",
  "details": "uri=/api/auth/check-login-id",
  "errorCode": "EMPTY_LOGIN_ID"
}
```