# ExpenseUpdateRequestDTO

API 분류 태그: API Request
태그: [소비] 소비 기록 수정

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| amount | Integer | Y | 수정할 소비 금액 |
| categoryCode | String | Y | 수정할 카테고리 코드 |
| memo | String | N | 수정할 메모 |
| expenseDate | String | Y | 수정할 소비 날짜 |

### body

```json
{
  "amount": 5000,
  "categoryCode": "CAFE",
  "memo": "커피",
  "expenseDate": "2026-06-18"
}
```