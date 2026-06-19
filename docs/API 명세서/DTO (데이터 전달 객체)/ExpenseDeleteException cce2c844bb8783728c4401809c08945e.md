# ExpenseDeleteException

API 분류 태그: API Exception
태그: [소비] 소비 기록 삭제

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