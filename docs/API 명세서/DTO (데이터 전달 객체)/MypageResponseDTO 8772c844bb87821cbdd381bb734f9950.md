# MypageResponseDTO

API 분류 태그: API Response
태그: [마이페이지] 마이페이지 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| userId | Long | Y | 사용자 ID |
| nickname | String | Y | 닉네임 |
| characterName | String | Y | 말랑이 이름 |
| currentPoint | Integer | Y | 현재 보유 포인트 |
| monthlyBudget | Integer | Y | 월 예산 |
| monthlySavingGoal | Integer | Y | 월간 절약 목표 |
| notificationSettings | Object | Y | 알림 설정 |
| fixedExpense | Integer | Y | 고정비 |

### body

```json
{
  "userId": 1,
  "nickname": "민지",
  "characterName": "말랑이",
  "currentPoint": 7800,
  "monthlyBudget": 600000,
  "monthlySavingGoal": 100000,
  "fixedExpense": 150000,
  "notificationSettings": {
    "missionNotification": true,
    "expenseRecordNotification": true
  }
}
```