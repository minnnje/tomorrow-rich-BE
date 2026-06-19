# API 명세서

> 단축키:
`[[ <페이지 이름>`: DTO(페이지 불러오기)
> 
> 
> 
> 1. DTO 표에서 페이지 정보 작성
> 2. Request, Response, Exception에서 `[[<페이지 이름>`을 통하여 작성한 DTO 불러오기

 

[API 명세서](API%20%EB%AA%85%EC%84%B8%EC%84%9C/API%20%EB%AA%85%EC%84%B8%EC%84%9C%20c362c844bb87828293418130efed9ce0.csv)

### DTO TABLE

[DTO (데이터 전달 객체)](API%20%EB%AA%85%EC%84%B8%EC%84%9C/DTO%20(%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%A0%84%EB%8B%AC%20%EA%B0%9D%EC%B2%B4)%20cb02c844bb878202ba7e01c4fb75253b.csv)

### Enum 정리

## **BudgetStatus**

| **값** | **설명** |
| --- | --- |
| NORMAL | 정상 |
| TODAY_OVER | 오늘 사용 가능 금액 초과 |
| MONTH_OVER | 월 예산 초과 |
| NO_BUDGET | 예산 미설정 |

## **MissionStatus**

| **값** | **설명** |
| --- | --- |
| SCHEDULED | 예정 |
| IN_PROGRESS | 진행 중 |
| COMPLETABLE | 완료 가능 |
| COMPLETED | 완료 |
| FAILED | 실패 |

## **MissionType**

| **값** | **설명** |
| --- | --- |
| EXPENSE_RECORD | 소비 기록하기 |
| AVOID_CATEGORY | 특정 카테고리 소비하지 않기 |
| UNDER_DAILY_BUDGET | 오늘 사용 가능 금액 이하로 쓰기 |
| UNDER_MONTHLY_BUDGET | 월 예산 지키기 |

## **ItemType**

| **값** | **설명** |
| --- | --- |
| WALLPAPER | 벽지 |
| FLOOR | 바닥 |
| FURNITURE | 가구 |
| PROP | 소품 |

## **PointHistoryType**

| **값** | **설명** |
| --- | --- |
| EARN | 포인트 적립 |
| SPEND | 포인트 사용 |