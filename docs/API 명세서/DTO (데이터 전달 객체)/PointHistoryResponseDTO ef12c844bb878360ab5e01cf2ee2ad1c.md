# PointHistoryResponseDTO

API 분류 태그: API Response
태그: [포인트] 포인트 내역 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| currentPoint | Integer | Y | 현재 보유 포인트 |
| histories | List<PointHistoryDTO> | Y | 포인트 내역 |

### body

```json
{
  "currentPoint": 12800,
  "histories": [
    {
      "pointHistoryId": 1,
      "type": "EARN",
      "amount": 300,
      "reason": "배달 시켜먹지 않기 미션 완료",
      "createdAt": "2026-06-18T12:30:00"
    }
  ]
}
```