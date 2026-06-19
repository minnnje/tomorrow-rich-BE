# SignupRequestDTO

API 분류 태그: API Request
태그: [인증] 회원가입

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| loginId | String | Y | 로그인 아이디 |
| password | String | Y | 비밀번호 |
| passwordConfirm | String | Y | 비밀번호 확인 |

### body

```json
{
  "loginId": "user123",
  "password": "password1234",
  "passwordConfirm": "password1234"
}
```