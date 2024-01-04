# ToDo APP

## 개발 계획
0. UseCase Diagram, API 명세, ERD 작성
1. MVP
    - [x] Sprint 1 : 할 일 카드에 대한 CRUD 기능
    - [x] Sprint 2 : 할 일 카드의 완료 상태 수정 기능, 댓글 CRUD 기능
2. 2차 기능
    - [x] 할 일 목록 api에 작성일을 기준으로 오름차순, 내림차순 정렬하는 기능을 추가
    - [x] 할 일 목록 api에 작성자를 기준으로 필터하는 기능을 추가
    - [x] 할 일 작성, 수정 api에 validation을 추가하기
    - [x] ResponseEntity를 사용하여 api의 응답으로 적절한 코드를 반환
3. 추가 기능
    - [x] 할 일 목록 받아올시 발생하는 n + 1 문제 해결
    - [x] User 회원가입, 로그인 기능 추가
    - [ ] 할 일 카드 CUD시 회원 정보 확인
    - [ ] OAuth 기능 추가
    - [x] 카드 목록 Pagination 기능
    - [ ] 할 일 카드를 공통 관리 가능하도록 그룹 기능 추가

## UseCase Diagram
![image](https://github.com/Moveuk/Moveuk/assets/84966961/5f10009e-410b-4cc4-a6f2-04e22ac249d7)

`옳게 그려진 것인지 모르겠다. 너무 문어발식 그림인 것 같아서 케이스별로 따로 그리는게 좋은지 확신이 서지 않는다.`

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
3. 2차 기능
   - 할 일 목록 api에 작성일을 기준으로 오름차순, 내림차순 정렬하는 기능을 추가
     - dummydata
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/ae989f1e-0456-4173-9fd5-07dd5bbc801e)
     - query parameter 옵션
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/6943b5d0-fb42-480a-9544-3d19e7358d22)
     - 작성일 기준 오름차순 옵션
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/d5810188-822f-4ef7-8681-c5c4b486a60f)
     - 작성일 기준 내림차순 옵션
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/ea62c0be-c71e-4c37-93b8-7eb5bc947854)
   - 할 일 목록 api에 작성자를 기준으로 필터하는 기능을 추가 
     - Author : 2 필터
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/2b818c58-8e9e-4db6-ba9d-e272090c4b96)
   - sort, filter 동적 쿼리 -> 개선 필요
     - Author : 1 필터와 작성일 기준 내림차순 총 3개의 할 일 카드
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/2ddb26ca-e44b-44fe-945d-63582b848783)
   - 할 일 작성, 수정 api에 validation을 추가하기
     - 제목과 본문 값을 아무것도 넣지 않았을 때 validation 작동. (조건: 제목 1~200자, 본문 1~1000자)
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/08aeb051-45ab-4934-9bcd-d17fa7e63a73)
   - ResponseEntity를 사용하여 api의 응답으로 적절한 코드를 반환
     - 기존에 실수로 Step1부터 작성해둠.
4. 추가 기능
   - 할 일 목록 받아올시 발생하는 n + 1 문제 해결
     - n + 1 문제 발견 : toDoCard 목록 불러올시 목록 사이즈(n) 만큼 reply id 값으로 n 번 쿼리가 나감
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/2af2fd77-6e4d-4d71-bf8b-8298f67c5d84)
     - fetch Join을 사용하여 테스트시 1개의 쿼리만 나갔으나 댓글이 존재하지 않으면 목록 자체가 불러져오지 않았음
       - ![image](https://github.com/Moveuk/TIL/assets/84966961/aea3a478-cfc3-4b9b-850b-c17436eaa628)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/92e2ddc8-1fdb-408a-b234-c8c62708c5bd)
     - 댓글이 존재해야지만 들어옴.
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/caede0d1-85c7-494e-87f7-71077d02799f)
     - 이 문제를 해결하기 위해 구글링을 함.
       - 보통 다대일, 일대일의 경우에는 fetch join을 사용하여 해결하고, 일대다의 경우에는 batchSize를 조절하여 쿼리를 한번에 날릴 수 있도록 도와준다고 한다.
       - batchSize란 sql문에서 in절에 들어갈 수 있는 최대 갯수를 size에 담아준다고 한다.
       - 보통 댓글의 경우 30개를 넘지 않는 경우가 많으니 넉넉히 잡아 100개로 설정해주었다.
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/bd9b914b-21df-4a7c-8dcc-994b69a17d3a)
       - 설정해준 후 테스트를 해보니 쿼리는 두 개가 나갔다. 한 개는 할 일 카드, 다른 한 개는 댓글이다.
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/651cf312-f643-42a1-a65f-80b85275dca0)
       - 이로써 n+1문제를 해결하여 2개의 쿼리만으로 모든 데이터를 받을 수 있게 되었다.
         - 참고로 뱃치 사이즈를 사용하게 되면 hibernate의 preparedStatement에 대한 캐싱 최적화 전략을 사용하므로 데이터가 많을 때는 1개의 쿼리가 아닌 4~5번이 나갈 수 있다.
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/8f795c33-e359-4f79-aa1c-2d04a5b12f94)
   - 카드 목록 Pagination 기능 추가
     - offset 기반 쿼리
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/0c8d9275-e659-455c-8c4e-5d4ae33a0d48)
       - ![image](https://github.com/Moveuk/Moveuk/assets/84966961/ac7c70ab-c319-404c-93f8-a3d679dd2401)
     - 요즘 sns들처럼 최신글에 더보기 기능이 추가된다면 cursor 기반 pagination을 지원해야함.
   - User 회원가입, 로그인 기능 추가
     - 회원가입
       - 정상 가입시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/404be41d-3a22-40d3-9f6f-7c6c97200c2e)
       - Email 형식 validation 실패시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/85585817-b663-4a48-8f2d-c0f191a66be2)
       - 같은 Email 사용시 : Http Status 409 - Conflict
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/510266c7-90fe-435b-8553-4423f5b9a6a4)
     - 로그인
       - 정상 로그인시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/f6982f40-5448-4f66-bd24-43ae22884cd9)
       - 이메일이 존재하지 않을시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/46bc12b8-1bac-485e-824d-e38a1bda0f8a)
       - 비밀번호가 일치하지 않을시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/aab95bb4-a76d-41cf-a448-c2ae20450338)
     - 로그아웃
       - 로그아웃 성공시
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/1f665092-2161-481f-9e7b-49c11a590db9)
   - 할 일 카드 CUD시 회원 정보 확인
     - 할 일 카드 생성시 로그인 상태 확인 
       - 로그인 상태 아니면 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/dc5b1907-4bfa-4b76-b467-fb5c14545568)
     - 할 일 카드 수정 기능 에러 처리
       - 로그인 상태 아니면 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/27127090-347c-43a4-8300-8566365993f2)
       - 수정 권한 없을시 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/8a64e0ee-2e97-42f1-a291-557884d8d9d0)
     - 할 일 카드 삭제 기능 에러 처리
       - 로그인 상태 아니면 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/1a90c4b8-9707-4f17-a8f4-e93fcd2f4d43)
       - 삭제 권한 없을시 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/be624064-6624-4569-a74e-a502eb65a9fa)
     - 할 일 카드 완료 상태 변경 기능 에러 처리
       - 로그인 상태 아니면 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/86c5754f-7b75-4382-86a4-d902050b8b56)
       -  권한 없을시 에러
         - ![image](https://github.com/Moveuk/TIL/assets/84966961/fd4c78c7-1387-471a-9dbd-872a81ca3eec)