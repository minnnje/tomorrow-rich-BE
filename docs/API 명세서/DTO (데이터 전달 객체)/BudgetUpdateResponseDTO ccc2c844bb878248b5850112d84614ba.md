# BudgetUpdateResponseDTO

API 분류 태그: API Response
태그: [마이페이지] 예산 정보 수정

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| monthlyBudget | Integer | Y | 수정된 월 예산 |
| monthlySavingGoal | Integer | Y | 수정된 월간 절약 목표 |
| fixedExpense | Integer | N | 수정된 고정비 |

### body

```json
{
  "monthlyBudget": 700000,
  "monthlySavingGoal": 150000,
  "fixedExpense": 180000
}
```