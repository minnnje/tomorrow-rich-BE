# ItemUnapplyResponseDTO

API 분류 태그: API Response
태그: [방] 아이템 적용 해제

| **필드** | **타입** | **필수** | **설명** |
| --- | --- | --- | --- |
| itemId | Long | Y | 적용 해제한 아이템 ID |
| applied | Boolean | Y | 적용 여부 |

### body

```json
{
  "itemId": 1,
  "applied": false
}
```