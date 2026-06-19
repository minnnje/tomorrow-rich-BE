# NotificationUpdateRequestDTO

API 분류 태그: API Request
태그: [마이페이지] 알림 설정 수정

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| missionNotification | Boolean | Y | 미션 알림 여부 |
| expenseRecordNotification | Boolean | Y | 소비 기록 알림 여부 |

### body

```json
{
  "missionNotification": true,
  "expenseRecordNotification": false
}
```