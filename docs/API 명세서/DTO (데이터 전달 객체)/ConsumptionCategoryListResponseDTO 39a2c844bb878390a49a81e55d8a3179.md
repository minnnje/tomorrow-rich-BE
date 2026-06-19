# ConsumptionCategoryListResponseDTO

API 분류 태그: API Response
태그: [온보딩] 소비 카테고리 조회

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| code | String | Y | 카테고리 코드 |
| name | String | Y | 카테고리 이름 |
|  |  |  |  |

### body

```json
{
  "categories": [
    {
      "code": "FOOD",
      "name": "식비"
    }
  ]
}
```