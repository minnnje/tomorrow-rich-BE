# SignupResponseDTO

API 분류 태그: API Response
태그: [인증] 회원가입

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| userId | Long | Y | 사용자 ID |
| loginId | String | Y | 로그인 아이디 |
| onboardingCompleted | Boolean | Y | 온보딩 완료 여부 |

### body

```json
{
  "userId": 1,
  "loginId": "user123",
  "onboardingCompleted": false
}
```