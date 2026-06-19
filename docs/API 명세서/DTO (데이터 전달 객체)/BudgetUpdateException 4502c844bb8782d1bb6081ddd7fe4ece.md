# BudgetUpdateException

API 분류 태그: API Exception
태그: [마이페이지] 예산 정보 수정

1. 예산 입력 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "예산 입력 오류",
  "message": "400 BAD_REQUEST \"올바른 예산을 입력해 주세요.\"",
  "details": "uri=/api/users/me/budget",
  "errorCode": "INVALID_BUDGET"
}
```

1. 목표 금액 입력 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "목표 금액 입력 오류",
  "message": "400 BAD_REQUEST \"올바른 목표 금액을 입력해 주세요.\"",
  "details": "uri=/api/users/me/budget",
  "errorCode": "INVALID_SAVING_GOAL"
}
```