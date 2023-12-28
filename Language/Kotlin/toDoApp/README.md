# ToDo APP

## 개발 계획
1. MVP
    - [x] Sprint 1 : 할 일 카드에 대한 CRUD 기능
    - [x] Sprint 2 : 할 일 카드의 완료 상태 수정 기능, 댓글 CRUD 기능
2. 2차 기능
    - [ ] 할 일 목록 api에 작성일을 기준으로 오름차순, 내림차순 정렬하는 기능을 추가
    - [ ] 할 일 목록 api에 작성자를 기준으로 필터하는 기능을 추가
    - [ ] 할 일 작성, 수정 api에 validation을 추가하기
    - [ ] ResponseEntity를 사용하여 api의 응답으로 적절한 코드를 반환
3. 추가 기능
    - [ ] User 로그인 기능 추가
        - [ ] 할 일 카드 CRUD시 회원 정보 확인
    - [ ] OAuth 기능 추가
    - [ ] 카드 목록 Pagination 추가
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
- 현재는 댓글의 비밀번호에 대해 검사하는 로직을 Exception으로 처리했으나 찾아보니 이는 예외가 아니라 틀릴 수 있다는 로직이므로 if문을 통해 따로 분기 처리하는 것이 좋다는 글을 읽었다.
  - https://okky.kr/questions/1086159
  - 읽어보니 납득이 되지만 Service까지 진입한 상황에서 반환 타입은 정해져 있는데 어떻게 다른 응답이 가능할 수 있는 것인지 모르겠다.
  - Response DTO를 반환하기 때문에 에러 데이터를 위한 반환 값이 없기 때문인데 다른 처리 방법이 있는지 찾아봐야 할 것 같다.

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
2. MVP : Sprint 2 - 할 일 카드의 완료 상태 수정 기능, 댓글 CRUD 기능
   - 할 일 카드의 완료 상태 수정 기능(수정 전 후 사진)
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/990676bd-e5e2-437a-88f9-e1d86963f35b)
     - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/9159efcc-2f9b-4a80-b3f8-ff049c4c3654)
   - 댓글 CRUD 기능
     - 댓글을 위한 할 일 카드 세팅
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/4c698af3-dc01-40f8-9fe1-db769a58811e)
     - 댓글 추가
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/cfa3dd8d-a9a7-468b-8e6e-48c2c3cd9423)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/3b805aaf-0c9f-423c-bfc7-56c0671c9f74)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/5f21845a-b720-4ebe-9f37-61d133755bb6)
     - 댓글 수정 - 1번 댓글 수정
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/409362fe-36b8-47c2-88c7-771a7837eb65)
     - 댓글 삭제 - 3번 댓글 삭제
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/46cbf82b-86b8-42d2-9f9a-48376dba2127)
     - 할 일 카드 조회시 댓글 리스트 조회
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/9a1eee38-d1ea-40dc-ac63-39a5f6aa54c7)
       - Entity 자체를 반환하는 실수를 함.
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/7022efb3-2ece-4482-b865-ec4c8be2be3e)
       - Entity 자체를 반환하는 실수를 하였고 아래처럼 변경
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/bd76c858-dcb9-4b4e-bb9e-cfa4b7a6daaf)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/c402e2a8-2caf-4a62-bbd1-d6d255ba35e3)
       - 변경 후 최종 테스트 : 정상 작동
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/6ca626c7-1b66-4619-9fe5-e4cd2350fd10)
     - 할 일 카드 삭제시 고아 댓글 객체 연쇄 삭제 테스트
       - 위 1번글 삭제
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/241f335d-e4a9-417e-a8c6-3c5b3e1af650)
       - 고아 객체 1번 댓글 삭제 SQL문 확인
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/a91109a7-c471-49ed-b798-46fc5860b23f)
     - 각 기능에 대해 잘못된 id 입력시 혹은 옳지 않은 비밀번호, 작성자명 입력시 error response 출력
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/1a29ac49-740e-4b5a-b040-81d90ec1f2f5)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/40e152d0-e3dd-466e-8738-45d700a65cf2)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/42cd35eb-b927-4893-8fdc-a361f5563a17)