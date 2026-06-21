# CalendarMonthResponseDTO

API 분류 태그: API Response
태그: [캘린더] 월별 캘린더 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| month | String | Y | 조회 월, yyyy-MM |
| summary | Object | Y | 월간 예산 요약 |
| days | List<Object> | Y | 날짜별 요약 목록 |

### body

```json
{
  "month": "2026-06",
  "summary": {
    "monthlyBudget": 600000,
    "monthlySavingGoal": 100000,
    "monthlyExpenseAmount": 243000,
    "remainingBudget": 357000,
    "todayAvailableAmount": 12500
  },
  "days": [
    {
      "date": "2026-06-18",
      "totalExpenseAmount": 4500,
      "missionTotalCount": 3,
      "missionCompletedCount": 2,
      "hasExpense": true,
      "hasCompletedMission": true,
      "isFuture": false
    }
  ]
}
```