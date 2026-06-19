# CalendarDayDetailResponseDTO

API 분류 태그: API Response
태그: [캘린더] 날짜 상세 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| date | String | Y | 조회 날짜 |
| totalExpenseAmount | Integer | Y | 해당 날짜 총 소비 금액 |
| expenses | List<ExpenseDTO> | Y | 소비 기록 목록 |
| missions | List<MissionDTO> | Y | 미션 요약 목록 |

### body

```json
{
  "date": "2026-06-18",
  "totalExpenseAmount": 4500,
  "expenses": [
    {
      "expenseId": 1,
      "categoryCode": "CAFE",
      "categoryName": "카페",
      "amount": 4500,
      "memo": "아이스 아메리카노"
    }
  ],
  "missions": [
    {
      "missionId": 1,
      "title": "오늘의 소비 기록하기",
      "rewardPoint": 200,
      "status": "COMPLETED"
    }
  ]
}
```