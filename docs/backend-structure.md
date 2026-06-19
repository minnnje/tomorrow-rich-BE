# Backend Structure

현재 API 명세 기준으로 백엔드 패키지를 기능 단위로 나눈다.

```text
com.likelion.tomorrowrich
├── global
│   ├── config
│   ├── exception
│   ├── response
│   └── security
├── auth
│   ├── controller
│   ├── dto
│   └── service
├── user
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── category
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── onboarding
│   ├── controller
│   ├── dto
│   └── service
├── home
│   ├── controller
│   ├── dto
│   └── service
├── expense
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── calendar
│   ├── controller
│   ├── dto
│   └── service
├── mission
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── point
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── shop
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── room
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
└── mypage
    ├── controller
    ├── dto
    └── service
```

## Package 기준

- `global`: 공통 설정, 보안, 예외, 응답 포맷
- `auth`: 회원가입, 로그인, 로그아웃, 아이디 중복 확인
- `user`: 사용자 엔티티, 사용자 설정 수정 API
- `category`: 소비 카테고리 조회
- `onboarding`: 온보딩 저장
- `home`: 홈 화면 조회
- `expense`: 소비 등록, 수정, 삭제
- `calendar`: 월별 캘린더, 날짜 상세 조회
- `mission`: 미션 조회, 미션 완료
- `point`: 포인트 내역
- `shop`: 아이템 목록, 아이템 구매
- `room`: 내 방 조회, 보유 아이템, 아이템 적용/해제
- `mypage`: 마이페이지 조회용 조합 응답

## MVP 메모

- 상점 구매가 MVP 범위이므로 `GET /api/shop/items`도 시작 전 범위에 포함한다.
- 방 꾸미기를 MVP 핵심으로 본다면 아이템 적용/해제도 후순위에서 시작 전으로 올리는 편이 좋다.
- 로그아웃은 서버에서 토큰 무효화를 하지 않으면 프론트 토큰 삭제로 처리 가능하다.
