# HomeResponseDTO

API 분류 태그: API Response
태그: [홈] 홈 화면 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| nickname | String | Y | 사용자 닉네임 |
| characterName | String | Y | 말랑이 이름 |
| monthlyBudget | Integer | Y | 이번 달 예산 |
| monthlySavingGoal | Integer | Y | 이번 달 절약 목표 |
| monthlyExpenseAmount | Integer | Y | 이번 달 누적 소비 금액 |
| remainingBudget | Integer | Y | 이번 달 남은 예산 |
| todayAvailableAmount | Integer | Y | 오늘 사용 가능 금액 |
| point | Integer | Y | 현재 보유 포인트 |
| budgetStatus | String | Y | 예산 상태 |
| speechBubble | Object | Y | 말랑이 말풍선 정보 |
| room | Object | Y | 현재 방 정보 |
| todayMissions | List<Object> | Y | 오늘 미션 일부 |

### body

```json
{
  "nickname": "민지",
  "characterName": "말랑이",
  "monthlyBudget": 600000,
  "monthlySavingGoal": 100000,
  "monthlyExpenseAmount": 243000,
  "remainingBudget": 357000,
  "todayAvailableAmount": 12500,
  "point": 12500,
  "budgetStatus": "NORMAL",
  "speechBubble": {
    "type": "NORMAL",
    "message": "오늘도 부자가 되는 연습을 해볼까요?",
    "level": "INFO"
  },
  "room": {
    "backgroundImageUrl": "/rooms/default-room.png",
    "appliedItems": [
      {
        "itemId": 1,
        "itemType": "WALLPAPER",
        "name": "기본 벽지",
        "imageUrl": "/items/wallpaper-default.png"
      }
    ]
  },
  "todayMissions": [
    {
      "missionId": 1,
      "title": "오늘의 소비 기록하기",
      "description": "오늘 소비를 한 번 기록해 주세요.",
      "progress": 0,
      "targetCount": 1,
      "rewardPoint": 200,
      "status": "IN_PROGRESS"
    }
  ]
}
```

- +) 알림 멘트 예시
    
    
    | **조건** | **type** | **level** | **message** |
    | --- | --- | --- | --- |
    | 정상 | NORMAL | INFO | 오늘도 부자가 되는 연습을 해볼까요? |
    | 오늘 사용 가능 금액 30% 이하 | DAILY_BUDGET_WARNING | WARNING | 오늘 사용할 수 있는 금액이 얼마 남지 않았어요. |
    | 오늘 사용 가능 금액 초과 | DAILY_BUDGET_OVER | DANGER | 오늘 예산을 초과했어요. 내일은 조금만 아껴봐요. |
    | 이번 달 남은 예산 20% 이하 | MONTHLY_BUDGET_WARNING | WARNING | 이번 달 예산이 얼마 남지 않았어요. |
    | 이번 달 예산 초과 | MONTHLY_BUDGET_OVER | DANGER | 이번 달 예산을 초과했어요. 소비를 한번 점검해봐요. |
    | 미션 미완료 | MISSION_REMINDER | INFO | 오늘의 미션을 완료하면 포인트를 받을 수 있어요. |