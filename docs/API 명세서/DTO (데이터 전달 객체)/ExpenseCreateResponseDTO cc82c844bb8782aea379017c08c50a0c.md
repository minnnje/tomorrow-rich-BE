# ExpenseCreateResponseDTO

API 분류 태그: API Response
태그: [소비] 소비 등록

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| expenseId | Long | Y | 소비 기록 ID |
| amount | Integer | Y | 소비 금액 |
| categoryCode | String | Y | 카테고리 코드 |
| categoryName | String | Y | 카테고리 이름 |
| expenseDate | String | Y | 소비 날짜 |
| monthlyExpenseAmount | Integer | Y | 이번 달 누적 소비 금액 |
| remainingBudget | Integer | Y | 이번 달 남은 예산 |
| todayAvailableAmount | Integer | Y | 갱신된 오늘 사용 가능 금액 |
| updatedMissionIds | List<Long> | Y | 소비 등록으로 진행률이 바뀐 미션 ID 목록 |

### body

```json
{
  "expenseId": 1,
  "amount": 4500,
  "categoryCode": "CAFE",
  "categoryName": "카페",
  "expenseDate": "2026-06-18",
  "monthlyExpenseAmount": 247500,
  "remainingBudget": 352500,
  "todayAvailableAmount": 8000,
  "updatedMissionIds": [1]
}
```