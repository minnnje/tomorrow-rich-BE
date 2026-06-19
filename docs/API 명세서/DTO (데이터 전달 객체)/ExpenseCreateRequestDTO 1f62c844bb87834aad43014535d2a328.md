# ExpenseCreateRequestDTO

API 분류 태그: API Request
태그: [소비] 소비 등록

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| amount | Integer | Y | 소비 금액 |
| categoryCode | String | Y | 소비 카테고리 코드 |
| memo | String | N | 소비 메모 |
| expenseDate | String | Y | 소비 날짜, yyyy-MM-dd |

### body

```json
{
  "amount": 4500,
  "categoryCode": "CAFE",
  "memo": "아이스 아메리카노",
  "expenseDate": "2026-06-18"
}
```