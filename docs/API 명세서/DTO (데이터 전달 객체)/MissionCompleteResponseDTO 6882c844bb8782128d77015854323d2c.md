# MissionCompleteResponseDTO

API 분류 태그: API Response
태그: [미션] 미션 완료

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| missionId | Long | Y | 완료한 미션 ID |
| status | String | Y | 변경된 미션 상태 |
| rewardPoint | Integer | Y | 지급 포인트 |
| currentPoint | Integer | Y | 지급 후 보유 포인트 |
| pointReceived | Boolean | Y | 포인트 지급 여부 |

### body

```json
{
  "missionId": 2,
  "status": "COMPLETED",
  "rewardPoint": 300,
  "currentPoint": 12800,
  "pointReceived": true
}
```