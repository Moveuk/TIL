# ToDo APP

## 개발 계획
1. MVP
    - [x] Sprint 1 : 할 일 카드에 대한 CRUD 기능
    - [ ] Sprint 2 : 할 일 카드의 댓글 기능
2. 2차 기능
    - [ ] User 로그인 기능 추가
      - [ ] 할 일 카드 CRUD시 회원 정보 확인
    - [ ] OAuth 기능 추가
    - [ ] 카드 목록 Pagination 추가
3. 추가 기능
    - [ ] 할 일 카드를 공통 관리 가능하도록 그룹 기능 추가


## API
### MVP API 문서
- query Param 고민중
![image](https://github.com/Moveuk/TIL/assets/84966961/8f35f21f-60ee-4b36-b57e-1c618d14e864)

## ERD
![image](https://github.com/Moveuk/TIL/assets/84966961/6f35c93c-1809-4d44-95e2-504aedfbbcc4)

### 고민중인 사항
- ERD가 각 테이블이 서로 순환 구조로 묶여있어도 되는지 모르겠다.
  - 아키텍처에서는 순환구조가 좋지 않다고 읽었는데 그 사항이 DB에도 묶이는 것인지 모르겠다.
  - ERD는 DB를 위한 모델링이므로 DB에 관하여 작성하는 것이 맞는 것 같은데 객체 지향 프로그래밍적인 요소가 포함되는 것이 맞는지 모르겠다.

<details>
<summary>수정 과정 보러가기</summary>
<div markdown="1">

</div>
</details>

### 단위 테스트 진행
Swagger를 사용하여 수동 테스트 진행.
1. MVP : Sprint 1 - 할 일 카드에 대한 CRUD 기능
   - 할 일 카드 추가 기능
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/9a9c9562-08f2-475f-b10b-133639d12169)
   - 특정 할 일 카드 상세 내역 불러오기
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/9dd19ef4-ef97-459f-9754-fbcb54fc1aa8)
   - 할 일 카드 수정 기능
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/a4e00a0b-0bda-48fa-b12f-aa5dd3c87163)
   - 할 일 카드 삭제 기능
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/fb3ea547-cb06-406b-8b9d-83db9036ae3d)
   - 전체 할 일 카드 목록 불러오기
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/cdab9048-fb5d-4baf-981c-6710746957ce)
   - 각 기능에 대해 잘못된 id 입력시 error response 출력
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/da7d74d6-4bb8-410f-8ed7-88de6dfe9eae)
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/eda9315e-9b61-4b04-beb4-ed2d6a2648bf)