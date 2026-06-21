# MissionListResponseDTO

API 분류 태그: API Response
태그: [미션] 날짜별 미션 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| date | String | Y | 조회 날짜 |
| isFuture | Boolean | Y | 미래 날짜 여부 |
| missions | List<MissionDTO> | Y | 미션 목록 |

### body

```json
{
  "date": "2026-06-19",
  "isFuture": false,
  "missions": [
    {
      "missionId": 1,
      "title": "오늘의 소비 기록하기",
      "description": "소비를 한 번 기록해 주세요.",
      "missionType": "EXPENSE_RECORD",
      "progress": 0,
      "targetCount": 1,
      "rewardPoint": 200,
      "status": "SCHEDULED",
      "pointReceived": false
    },
    {
      "missionId": 2,
      "title": "배달 시켜먹지 않기",
      "description": "해당 날짜에 배달 소비를 하지 않아요.",
      "missionType": "AVOID_CATEGORY",
      "progress": 0,
      "targetCount": 1,
      "rewardPoint": 300,
      "status": "SCHEDULED",
      "pointReceived": false
    }
  ]
}
```