# NicknameUpdateException

API 분류 태그: API Exception
태그: [마이페이지] 닉네임 수정

1. 닉네임 미입력

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "닉네임 미입력",
  "message": "400 BAD_REQUEST \"닉네임을 입력해 주세요.\"",
  "details": "uri=/api/users/me/nickname",
  "errorCode": "EMPTY_NICKNAME"
}
```