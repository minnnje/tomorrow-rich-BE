# MissionCompleteException

API 분류 태그: API Exception
태그: [미션] 미션 완료

1. 미션 없음

```json
{
  "timestamp": "시간",
  "statusCode": 404,
  "error": "미션 없음",
  "message": "404 NOT_FOUND \"미션을 찾을 수 없습니다.\"",
  "details": "uri=/api/missions/{missionId}/complete",
  "errorCode": "MISSION_NOT_FOUND"
}
```

1. 미션 조건 미충족

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "미션 조건 미충족",
  "message": "400 BAD_REQUEST \"아직 미션 조건을 만족하지 못했어요.\"",
  "details": "uri=/api/missions/{missionId}/complete",
  "errorCode": "MISSION_NOT_COMPLETABLE"
}
```

1. 이미 완료한 미션

```json
{
  "timestamp": "시간",
  "statusCode": 409,
  "error": "이미 완료한 미션",
  "message": "409 CONFLICT \"이미 완료한 미션입니다.\"",
  "details": "uri=/api/missions/{missionId}/complete",
  "errorCode": "MISSION_ALREADY_COMPLETED"
}
```

1. 미래 미션 완료 불가

```json
{
  "timestamp": "시간",
  "statusCode": 400,
  "error": "미래 미션 완료 불가",
  "message": "400 BAD_REQUEST \"아직 완료할 수 없는 미션입니다.\"",
  "details": "uri=/api/missions/{missionId}/complete",
  "errorCode": "FUTURE_MISSION_NOT_ALLOWED"
}
```