# OnboardingRequestDTO

API 분류 태그: API Request
태그: [온보딩] 온보딩 저장

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| nickname | String | Y | 앱에서 사용할 닉네임 |
| characterName | String | Y | 말랑이 이름 |
| monthlyBudget | Integer | Y | 월 예산 |
| monthlySavingGoal | Integer | Y | 월간 절약 목표 |
| fixedExpense | Integer | N | 고정비 |
| frequentConsumptionCategories | List<String> | Y | 자주 하는 소비 |
| targetSavingCategories | List<String> | Y | 줄이고 싶은 소비 |

### body

```json
{
  "nickname": "민지",
  "characterName": "말랑이",
  "monthlyBudget": 600000,
  "monthlySavingGoal": 100000,
  "fixedExpense": 150000,
  "frequentConsumptionCategories": ["DELIVERY", "CAFE", "SHOPPING"],
  "targetSavingCategories": ["DELIVERY", "CAFE"]
}
```