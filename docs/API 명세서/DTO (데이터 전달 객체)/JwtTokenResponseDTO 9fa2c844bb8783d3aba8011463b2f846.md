# JwtTokenResponseDTO

API 분류 태그: API Response
태그: [인증] 로그인

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| accessToken | String | Y | JWT Access Token |
| userId | Long | Y | 사용자 ID |
| nickname | String | Y | 닉네임 |
| onboardingCompleted | Boolean | Y | 온보딩 완료 여부 |

### body

```json
{
  "accessToken": "jwt.access.token",
  "userId": 1,
  "nickname": "민지",
  "onboardingCompleted": true
}
```