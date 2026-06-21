# ExpenseUpdateException

API 분류 태그: API Exception
태그: [소비] 소비 기록 수정

1. 소비 기록 없음

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "소비 기록 없음",
  "message": "404 NOT_FOUND \"소비 기록을 찾을 수 없습니다.\"",
  "details": "uri=/api/expenses/{expenseId}",
  "errorCode": "EXPENSE_NOT_FOUND"
}
```

1. 소비 금액 오류

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "잘못된 소비 금액",
  "message": "400 BAD_REQUEST \"올바른 금액을 입력해 주세요.\"",
  "details": "uri=/api/expenses/{expenseId}",
  "errorCode": "INVALID_EXPENSE_AMOUNT"
}
```

1. 카테고리 미선택

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "카테고리 미선택",
  "message": "400 BAD_REQUEST \"카테고리를 선택해 주세요.\"",
  "details": "uri=/api/expenses/{expenseId}",
  "errorCode": "CATEGORY_REQUIRED"
}
```

4. 미래 날짜 등록 불가

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "미래 날짜 등록 불가",
  "message": "400 BAD_REQUEST \"아직 기록할 수 없는 날짜입니다.\"",
  "details": "uri=/api/expenses/{expenseId}",
  "errorCode": "FUTURE_DATE_NOT_ALLOWED"
}
```