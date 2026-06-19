# LoginException

API 분류 태그: API Exception
태그: [인증] 로그인

1. 사용자 찾을 수 없음

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "사용자 찾을 수 없음",
  "message": "404 NOT_FOUND \"존재하지 않는 계정입니다.\"",
  "details": "uri=/api/auth/login",
  "errorCode": "MEMBER_NOT_FOUND"
}
```

1. 비밀번호 불일치

```json
{
  "timestamp": "시간",
  "statusCode": 401,
  "error": "비밀번호 불일치",
  "message": "401 UNAUTHORIZED \"비밀번호가 일치하지 않습니다.\"",
  "details": "uri=/api/auth/login",
  "errorCode": "INVALID_PASSWORD"
}
```