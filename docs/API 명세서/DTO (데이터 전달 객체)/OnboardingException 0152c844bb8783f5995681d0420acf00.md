# OnboardingException

API 분류 태그: API Exception
태그: [온보딩] 온보딩 저장

1. 닉네임 미입력

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "닉네임 미입력",
  "message": "400 BAD_REQUEST \"닉네임을 입력해 주세요.\"",
  "details": "uri=/api/onboarding",
  "errorCode": "EMPTY_NICKNAME"
}
```

1. 말랑이 이름 미입력

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "말랑이 이름 미입력",
  "message": "400 BAD_REQUEST \"말랑이 이름을 입력해 주세요.\"",
  "details": "uri=/api/onboarding",
  "errorCode": "EMPTY_CHARACTER_NAME"
}
```

1. 잘못된 예산

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "잘못된 예산",
  "message": "400 BAD_REQUEST \"올바른 예산을 입력해 주세요.\"",
  "details": "uri=/api/onboarding",
  "errorCode": "INVALID_BUDGET"
}
```

1. 이미 완료된 온보딩

```json
{
  "timestamp": "시간",
  "statusCode": 409,
  "error": "이미 완료된 온보딩",
  "message": "409 CONFLICT \"이미 온보딩을 완료했습니다.\"",
  "details": "uri=/api/onboarding",
  "errorCode": "ALREADY_ONBOARDED"
}
```