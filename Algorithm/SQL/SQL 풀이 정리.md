# SQL 풀이 정리

## 1. 이름이 있는 동물의 아이디 - IS NULL

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59407

### 답
```sql
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NOT NULL
```

## 2. 역순 정렬하기 - SELECT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59035

### 답
```sql
SELECT Name, datetime from ANIMAL_INS order by ANIMAL_ID DESC
```

## 3. 중복 제거하기 - DISTINCT, COUNT

### 링크ddd
https://school.programmers.co.kr/learn/courses/30/lessons/59408

### 답
```sql
SELECT count(DISTINCT NAME) FROM ANIMAL_INS
```

## 4. 동물의 아이디와 이름 - SELECT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59403

### 답
```sql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
```

## 5. 동물 수 구하기 - DISTINCT, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59406

### 답
```sql
SELECT COUNT(DISTINCT ANIMAL_ID) FROM ANIMAL_INS
```

## 6. 동물 수 구하기 - GROUP BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59041

### 답
```sql
SELECT NAME, COUNT(NAME) FROM ANIMAL_INS
GROUP BY NAME #이름으로 그룹
HAVING COUNT(NAME) > 1 #갯수가 1개 이상 조건
ORDER BY NAME #이름으로 정렬
```

## 7. 아픈 동물 찾기 - SELECT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59036

### 답
```sql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = "Sick"
```

## 8. 상위 n개 레코드 - SELECT, LIMIT, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59405

### 답
```sql
SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME ASC LIMIT 1
```

## 9. 최솟값 구하기 - MIN, SELECT, LIMIT, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59405

### 답
```sql
SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME ASC LIMIT 1
SELECT MIN(DATETIME) 시간 FROM ANIMAL_INS;
```

## 10. 어린 동물 찾기 - SELECT, WHERE, !=

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59037

### 답
```sql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION != "Aged"
```

## 11. 여러 기준으로 정렬하기 - SELECT, 다중 ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59404

### 답
```sql
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME ASC, DATETIME DESC
```

## 12. 이름에 el이 들어가는 동물 찾기 - SELECT, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59047

### 답
```sql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE '%el%' ORDER BY NAME
```

## 13. 나이 정보가 없는 회원 수 구하기 - IS NULL

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131528

### 답
```sql
SELECT count(*) USERS FROM USER_INFO WHERE AGE IS NULL
```

## 14. 가장 비싼 상품 구하기 - MAX

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131697

### 답
```sql
SELECT MAX(PRICE) MAX_PRICE FROM PRODUCT
```

## 15. NULL 처리하기 - IFNULL, COALESCE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59410

### 답
```sql
SELECT ANIMAL_TYPE, COALESCE(NAME , 'No name') , SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID
SELECT ANIMAL_TYPE, IFNULL(NAME , 'No name') , SEX_UPON_INTAKE FROM ANIMAL_INS ORDER BY ANIMAL_ID	
```

## 16. 경기도에 위치한 식품창고 목록 출력하기 - COALESCE, LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131114

### 답
```sql
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, COALESCE(FREEZER_YN, 'N') FREEZER_YN FROM FOOD_WAREHOUSE WHERE ADDRESS LIKE '%경기도%' ORDER BY WAREHOUSE_ID ASC
```

## 17. 강원도에 위치한 생산공장 목록 출력하기 - LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131112

### 답
```sql
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE '%강원도%' ORDER BY FACTORY_ID ASC
```

## 18. DATETIME에서 DATE로 형 변환 - DATE_FORMAT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59414

### 답
```sql
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') 날짜 FROM ANIMAL_INS ORDER BY ANIMAL_ID
```

## 19. 흉부외과 또는 일반외과 의사 목록 출력하기 - OR, DATE_FORMAT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132203

### 답
```sql
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') FROM DOCTOR WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' ORDER BY HIRE_YMD DESC
```

## 20. 가격이 제일 비싼 식품의 정보 출력하기 - LIMIT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131115

### 답
```sql
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE FROM FOOD_PRODUCT ORDER BY PRICE DESC LIMIT 1
```

## 21. 이름이 없는 동물의 아이디 - IS NULL

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131115

### 답
```sql
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL ORDER BY ANIMAL_ID
```

## 22. 조건에 맞는 회원수 구하기 - BETWEEN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131535

### 답
```sql
SELECT COUNT(USER_ID) USERS FROM USER_INFO WHERE JOINED BETWEEN '2021-01-01' AND '2021-12-31' AND 19 < AGE AND AGE < 30 
```

## 23. 중성화 여부 파악하기 - CASE, LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59409

### 답
```sql
SELECT
    ANIMAL_ID,
    NAME,
    CASE
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
        WHEN SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
        END AS 중성화
FROM ANIMAL_INS
```

## 24. 카테고리 별 상품 개수 구하기 - SUBSTR, COUNT, GROUP BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131529

### 답
```sql
SELECT
    SUBSTR(PRODUCT_CODE,1,2) CATEGORY,
    COUNT(PRODUCT_CODE) PRODUCTS
FROM PRODUCT
GROUP BY SUBSTR(PRODUCT_CODE,1,2)
ORDER BY PRODUCT_CODE
```

## 25. 고양이와 개는 몇 마리 있을까 - COUNT, GROUP BY, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59040

### 답
```sql
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) 'count' FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE
```

## 26. 입양 시각 구하기(1) - SUBSTR, COUNT, GROUP BY, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59412

### 답
```sql
SELECT
    SUBSTR(DATETIME,11,3) HOUR, COUNT(DATETIME) 'COUNT'
FROM ANIMAL_OUTS
WHERE SUBSTR(DATETIME,11,3) > 8 AND SUBSTR(DATETIME,11,3) < 20
GROUP BY SUBSTR(DATETIME,11,3)
ORDER BY SUBSTR(DATETIME,11,3)
```

## 27. 진료과별 총 예약 횟수 출력하기 - SUBSTR, COUNT, GROUP BY, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132202

### 답
```sql
SELECT
    MCDP_CD	'진료과코드', COUNT(MCDP_CD) '5월예약건수'
FROM APPOINTMENT
WHERE SUBSTR(APNT_YMD,6,2) > 4 AND SUBSTR(APNT_YMD,6,2) < 6
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD), MCDP_CD
```

## 28. 12세 이하인 여자 환자 목록 출력하기 - COALESCE, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132201

### 답
```sql
SELECT
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    COALESCE(TLNO, 'NONE')
FROM PATIENT
WHERE AGE < 13 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME
```

## 29. 인기있는 아이스크림 - ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/133024

### 답
```sql
SELECT
    FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID
```

## 30. 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기 - COUNT, LIKE, GROUP BY ,ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/151137

### 답
```sql
SELECT
    CAR_TYPE,
    COUNT(CAR_TYPE) CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
```

## 31. 오랜 기간 보호한 동물(1) - LEFT OUTER JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59044

### 답
```sql
SELECT A.NAME
     ,A.DATETIME
FROM ANIMAL_INS A
         LEFT OUTER JOIN ANIMAL_OUTS AS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME ASC
    LIMIT 3
```

## 32. 카테고리 별 도서 판매량 집계하기 - INNER JOIN, DATE_FORMAT, GROUP BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/144855

### 답
```sql
SELECT A.CATEGORY
     ,SUM(B.SALES) TOTAL_SALES
FROM BOOK A
         INNER JOIN BOOK_SALES AS B ON A.BOOK_ID = B.BOOK_ID
WHERE DATE_FORMAT(B.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY CATEGORY
ORDER BY A.CATEGORY ASC
```

## 33. 상품 별 오프라인 매출 구하기 - INNER JOIN, GROUP BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131533

### 답
```sql
SELECT
    A.PRODUCT_CODE,
    SUM(A.PRICE * B.SALES_AMOUNT) SALES
FROM PRODUCT A
        INNER JOIN OFFLINE_SALE AS B
        ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_ID
ORDER BY SUM(A.PRICE * B.SALES_AMOUNT) DESC, PRODUCT_CODE ASC
```

## 34. 있었는데요 없었습니다 - INNER JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59043

### 답
```sql
SELECT
    A.ANIMAL_ID,
    A.NAME
FROM ANIMAL_INS A
        INNER JOIN ANIMAL_OUTS AS B
        ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.DATETIME > B.DATETIME
ORDER BY A.DATETIME
```

## 35. 오랜 기간 보호한 동물(2) - INNER JOIN, LIMIT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59411

### 답
```sql
SELECT
    A.ANIMAL_ID,
    A.NAME
FROM ANIMAL_INS A
         INNER JOIN ANIMAL_OUTS AS B
                    ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY (B.DATETIME - A.DATETIME) DESC LIMIT 2
```

## 36. 보호소에서 중성화한 동물 - INNER JOIN, WHERE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59045

### 답
```sql
SELECT
    A.ANIMAL_ID,
    A.ANIMAL_TYPE,
    A.NAME
FROM ANIMAL_INS A
         INNER JOIN ANIMAL_OUTS AS B
                    ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE 'Intact%' AND B.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY B.ANIMAL_ID
```

## 37. 조건에 맞는 도서와 저자 리스트 출력하기 - DATE_FORMAT, INNER JOIN, WHERE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/144854

### 답
```sql
SELECT
    A.BOOK_ID,
    B.AUTHOR_NAME,
    DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d')
FROM BOOK A
         INNER JOIN AUTHOR AS B
                    ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE A.CATEGORY = '경제'
ORDER BY A.PUBLISHED_DATE ASC
```

## 38. 조건별로 분류하여 주문상태 출력하기 - DATE_FORMAT, CASE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131113

### 답
```sql
SELECT
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d'),
    CASE
        WHEN OUT_DATE IS NULL THEN '출고미정'
        WHEN OUT_DATE < DATE('2022-05-02 00:00:00') THEN '출고완료'
        ELSE '출고대기'
END AS 출고여부
FROM FOOD_ORDER A
ORDER BY A.ORDER_ID ASC
```

## 39. 성분으로 구분한 아이스크림 총 주문량 - SUM, INNER JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/133026

### 답
```sql
SELECT
    B.INGREDIENT_TYPE,
    SUM(A.TOTAL_ORDER) TOTAL_ORDER
FROM FIRST_HALF A
         INNER JOIN ICECREAM_INFO AS B
                    ON A.FLAVOR = B.FLAVOR
GROUP BY B.INGREDIENT_TYPE
ORDER BY SUM(A.TOTAL_ORDER) ASC
```

## 40. 루시와 엘라 찾기 - SELECT, IN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59046

### 답
```sql
SELECT
    A.ANIMAL_ID,
    A.NAME,
    A.SEX_UPON_INTAKE
FROM ANIMAL_INS A
WHERE A.NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID ASC
```

## 41. 조건에 맞는 도서 리스트 출력하기 - SELECT, DATE_FORMAT, IN, SUBSTR

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/144853

### 답
```sql
SELECT
    A.BOOK_ID,
    DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d')
FROM BOOK A
WHERE A.BOOK_ID IN ('3', '4')
  AND SUBSTR(A.PUBLISHED_DATE, 1,4) = 2021
  AND CATEGORY = '인문'
ORDER BY DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d') ASC
```

## 42. 평균 일일 대여 요금 구하기 - SELECT, ROUND, AVG

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/151136

### 답
```sql
SELECT
    ROUND(AVG(A.DAILY_FEE)) AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR A
WHERE A.CAR_TYPE = 'SUV'
```

## 43. 조건에 맞는 사용자와 총 거래금액 조회하기 - SELECT, SUM, INNER JOIN, WHERE, GROUP BY, HAVING, ORDER BY

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/164668

### 답
```sql
SELECT
    B.USER_ID,
    B.NICKNAME,
    SUM(A.PRICE) TOTAL_SALES
FROM USED_GOODS_BOARD A
         INNER JOIN USED_GOODS_USER AS B
                    ON A.WRITER_ID = B.USER_ID
WHERE A.STATUS = 'DONE'
GROUP BY B.USER_ID HAVING SUM(A.PRICE) >= 700000
ORDER BY SUM(A.PRICE) ASC
```

## 44. 가격대 별 상품 개수 구하기 - CASE, count

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131530

### 답
```sql
SELECT
    CASE
        WHEN (0 < PRICE) AND (PRICE < 10000) then 0
        WHEN (10000 <= PRICE) and (PRICE < 20000) then 10000
        WHEN (20000 <= PRICE) and (PRICE < 30000) then 20000
        WHEN (30000 <= PRICE) and (PRICE < 40000) then 30000
        WHEN (40000 <= PRICE) and (PRICE < 50000) then 40000
        WHEN (50000 <= PRICE) and (PRICE < 60000) then 50000
        WHEN (60000 <= PRICE) and (PRICE < 70000) then 60000
        WHEN (70000 <= PRICE) and (PRICE < 80000) then 70000
        WHEN (80000 <= PRICE) and (PRICE < 90000) then 80000
        END AS PRICE_GROUP,
    count(*) PRODUCTS
FROM  PRODUCT
GROUP BY  PRICE_GROUP
ORDER BY  PRICE_GROUP ASC
```

## 45. 3월에 태어난 여성 회원 목록 출력하기 - DATE_FORMAT, IS NOT NULL

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131120

### 답
```sql
SELECT
    A.MEMBER_ID,
    A.MEMBER_NAME,
    A.GENDER,
    DATE_FORMAT(A.DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
FROM MEMBER_PROFILE A
WHERE A.GENDER = 'W' AND DATE_FORMAT(A.DATE_OF_BIRTH, '%m') = '03' AND A.TLNO IS NOT NULL
ORDER BY A.MEMBER_ID ASC
```

## 46. 대여 기록이 존재하는 자동차 리스트 구하기 - DISTINCT, INNER JOIN, DATE_FORMAT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131120

### 답
```sql
SELECT
    DISTINCT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A
         INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B
                    ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE = '세단' AND DATE_FORMAT(B.START_DATE, '%m') = '10'
ORDER BY A.CAR_ID DESC
```

## 47. 모든 레코드 조회하기 - SELECT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131120

### 답
```sql
SELECT
    *
FROM ANIMAL_INS A
ORDER BY A.ANIMAL_ID
```

## 48. 즐겨찾기가 가장 많은 식당 정보 출력하기 - IN, INNER JOIN, GROUP BY, MAX

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131123

### 답
```sql
SELECT
    A.FOOD_TYPE,
    A.REST_ID,
    A.REST_NAME,
    A.FAVORITES
FROM REST_INFO A
WHERE (FOOD_TYPE, FAVORITES) IN (SELECT FOOD_TYPE, max(FAVORITES) FROM REST_INFO GROUP BY FOOD_TYPE)
ORDER BY A.FOOD_TYPE DESC
```

## 49. 식품분류별 가장 비싼 식품의 정보 조회하기 - IN, INNER JOIN, GROUP BY, MAX

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131116

### 답
```sql
SELECT
    A.CATEGORY,
    A.PRICE MAX_PRICE,
    A.PRODUCT_NAME
FROM FOOD_PRODUCT A
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, max(PRICE) FROM FOOD_PRODUCT GROUP BY CATEGORY) AND CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC
```

## 50. 5월 식품들의 총매출 조회하기 - INNER JOIN, GROUP BY, SUM

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131117

### 답
```sql
SELECT
    A.PRODUCT_ID,
    A.PRODUCT_NAME,
    SUM(A.PRICE * B.AMOUNT) TOTAL_SALES
FROM FOOD_PRODUCT A
         INNER JOIN FOOD_ORDER AS B
                    ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE DATE_FORMAT(B.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID
```

## 50. 5월 식품들의 총매출 조회하기 - INNER JOIN, GROUP BY, SUM

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131117

### 답
```sql
SELECT
    A.PRODUCT_ID,
    A.PRODUCT_NAME,
    SUM(A.PRICE * B.AMOUNT) TOTAL_SALES
FROM FOOD_PRODUCT A
         INNER JOIN FOOD_ORDER AS B
                    ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE DATE_FORMAT(B.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID
```

## 51. 없어진 기록 찾기 - RIGHT JOIN, NULL

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59042

### 답
```sql
SELECT
    B.ANIMAL_ID,
    B.NAME
FROM ANIMAL_INS A
         RIGHT JOIN ANIMAL_OUTS AS B
                    ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.ANIMAL_ID IS NULL AND B.ANIMAL_ID IS NOT NULL
ORDER BY A.ANIMAL_ID
```

## 52. 과일로 만든 아이스크림 고르기 - INNER JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/133025

### 답
```sql
SELECT
    B.FLAVOR
FROM FIRST_HALF A
         INNER JOIN ICECREAM_INFO AS B
                    ON A.FLAVOR = B.FLAVOR
WHERE A.TOTAL_ORDER >= 3000 AND B.INGREDIENT_TYPE = 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC
```

## 52. 재구매가 일어난 상품과 회원 리스트 구하기 - GROUP BY, HAVING, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131536

### 답
```sql
SELECT
    A.USER_ID,
    A.PRODUCT_ID
FROM ONLINE_SALE A
GROUP BY USER_ID, PRODUCT_ID HAVING COUNT(A.USER_ID) > 1
ORDER BY A.USER_ID, A.PRODUCT_ID DESC
```

## 53. 재구매가 일어난 상품과 회원 리스트 구하기 - GROUP BY, HAVING, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131536

### 답
```sql
SELECT
    A.USER_ID,
    A.PRODUCT_ID
FROM ONLINE_SALE A
GROUP BY USER_ID, PRODUCT_ID HAVING COUNT(A.USER_ID) > 1
ORDER BY A.USER_ID, A.PRODUCT_ID DESC
```

## 54. 최댓값 구하기 - MAX

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59415

### 답
```sql
SELECT
    MAX(A.DATETIME) 시간
FROM ANIMAL_INS A
```

## 55. 조건에 맞는 사용자 정보 조회하기 - CONCAT, CASE, INNER JOIN, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/164670

### 답
```sql
SELECT
    B.USER_ID,
    B.NICKNAME,
    CONCAT(B.CITY, " ", B.STREET_ADDRESS1," ", B.STREET_ADDRESS2) 전체주소,
    CASE LENGTH(B.TLNO)
        WHEN 11 THEN CONCAT(LEFT(B.TLNO, 3), '-', MID(B.TLNO, 4, 4), '-', RIGHT(B.TLNO, 4))
        WHEN 10 THEN CONCAT(LEFT(B.TLNO, 3), '-', MID(B.TLNO, 4, 3), '-', RIGHT(B.TLNO, 4))
        END AS 전화번호
FROM USED_GOODS_BOARD A
         INNER JOIN USED_GOODS_USER AS B
                    ON A.WRITER_ID = B.USER_ID
GROUP BY A.WRITER_ID HAVING COUNT(A.WRITER_ID) >= 3
ORDER BY B.USER_ID DESC
```

## 56. 특정 옵션이 포함된 자동차 리스트 구하기 - SELECT, LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/157343

### 답
```sql
SELECT
    A.CAR_ID,
    A.CAR_TYPE,
    A.DAILY_FEE,
    A.OPTIONS
FROM CAR_RENTAL_COMPANY_CAR A
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY A.CAR_ID DESC
```

## 57. 조건에 부합하는 중고거래 상태 조회하기 - SELECT, CASE, DATE_FORMAT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/164672

### 답
```sql
SELECT
    A.BOARD_ID,
    A.WRITER_ID,
    A.TITLE,
    A.PRICE,
    CASE (A.STATUS)
        WHEN 'DONE' THEN '거래완료'
        WHEN 'RESERVED' THEN '예약중'
        WHEN 'SALE' THEN '판매중'
        END
FROM USED_GOODS_BOARD A
WHERE DATE_FORMAT(A.CREATED_DATE,'%Y-%m-%d') = '2022-10-05'
ORDER BY A.BOARD_ID DESC
```

## 58. 취소되지 않은 진료 예약 조회하기 - SELECT, JOIN, LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132204

### 답
```sql
SELECT
    AP.APNT_NO,
    P.PT_NAME,
    AP.PT_NO,
    AP.MCDP_CD,
    D.DR_NAME,
    AP.APNT_YMD
FROM APPOINTMENT AP
         JOIN DOCTOR D ON D.DR_ID = AP.MDDR_ID
         JOIN PATIENT P ON P.PT_NO = AP.PT_NO
WHERE
    AP.APNT_CNCL_YMD IS NULL
  AND AP.MCDP_CD = 'CS'
  AND AP.APNT_YMD LIKE '2022-04-13%'
ORDER BY AP.APNT_YMD
```

## 59. 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기 - SELECT, MAX, CASE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/157340

### 답
```sql
SELECT
    A.CAR_ID,
    MAX(CASE WHEN '2022-10-16' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m-%d') AND DATE_FORMAT(END_DATE, '%Y-%m-%d')
                 THEN '대여중'
             ELSE '대여 가능'
        END) AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
GROUP BY CAR_ID
ORDER BY A.CAR_ID DESC
```

## 60. 년, 월, 성별 별 상품 구매 회원 수 구하기 - YEAR, MONTH, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131532

### 답
```sql
SELECT
    YEAR(B.SALES_DATE) YEAR,
    MONTH(B.SALES_DATE) MONTH,
    A.GENDER GENDER,
    COUNT(DISTINCT A.USER_ID) USERS
FROM USER_INFO A JOIN ONLINE_SALE B ON A.USER_ID = B.USER_ID
GROUP BY YEAR, MONTH, GENDER
HAVING GENDER IS NOT NULL
ORDER BY YEAR, MONTH, GENDER
```

## 61. 서울에 위치한 식당 목록 출력하기 - ROUND, AVG, JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131118

### 답
```sql
SELECT
    B.REST_ID,
    B.REST_NAME,
    B.FOOD_TYPE,
    B.FAVORITES,
    B.ADDRESS,
    ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE
FROM REST_REVIEW A
         INNER JOIN REST_INFO B ON A.REST_ID = B.REST_ID
GROUP BY A.REST_ID HAVING B.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, B.FAVORITES DESC
```

## 62. 자동차 대여 기록에서 장기/단기 대여 구분하기 - DATE_FORMAT, DATEDIFF, CASE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/151138

### 답
```sql
SELECT
    A.HISTORY_ID,
    A.CAR_ID,
    DATE_FORMAT(A.START_DATE, '%Y-%m-%d') START_DATE,
    DATE_FORMAT(A.END_DATE, '%Y-%m-%d') END_DATE,
    CASE
        WHEN DATEDIFF(END_DATE, START_DATE) < 29 THEN '단기 대여'
        ELSE '장기 대여'
        END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
WHERE START_DATE LIKE '2022-09%'
ORDER BY HISTORY_ID DESC
```

## 63. 자동차 평균 대여 기간 구하기 - ROUND, AVG, DATEDIFF

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/157342

### 답
```sql
SELECT
    A.CAR_ID,
    ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
GROUP BY CAR_ID HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC
```

## 64. 헤비 유저가 소유한 장소 - JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/77487

### 답
```sql
SELECT
    A.ID,
    A.NAME,
    B.HOST_ID
FROM PLACES as A
         JOIN (
    select
        HOST_ID,
        count(HOST_ID) as counts
    from PLACES
    group by HOST_ID) as B
              ON A.HOST_ID = B.HOST_ID
WHERE B.counts > 1
```

## 65. 우유와 요거트가 담긴 장바구니 - SELECT, IN, DISTINCT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/62284

### 답
```sql
SELECT
    CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID HAVING COUNT(DISTINCT NAME) = 2
ORDER BY CART_ID
```

## 66. 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기 - CONCAT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/164671

### 답
```sql
SELECT
    CONCAT("/home/grep/src/",BOARD_ID,"/",FILE_ID,FILE_NAME,FILE_EXT) FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC LIMIT 1)
ORDER BY FILE_ID DESC
```

## 67. 주문량이 많은 아이스크림들 조회하기 - JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/133027

### 답
```sql
SELECT
    A.FLAVOR
FROM
    FIRST_HALF A
        INNER JOIN (
        SELECT FLAVOR, SUM(TOTAL_ORDER) SUM_JLY
        FROM JULY
        GROUP BY FLAVOR) B
                   ON A.FLAVOR = B.FLAVOR
GROUP BY B.FLAVOR
ORDER BY A.TOTAL_ORDER + B.SUM_JLY DESC LIMIT 3
```

## 68. 저자 별 카테고리 별 매출액 집계하기 - SUM, JOIN, LIKE

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/144856

### 답
```sql
SELECT
    B.AUTHOR_ID,
    AUTHOR_NAME,
    CATEGORY,
    SUM(SALES*PRICE) AS TOTAL_SALES
FROM BOOK_SALES S
         JOIN BOOK B ON S.BOOK_ID = B.BOOK_ID
         JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE SALES_DATE LIKE ('2022-01%')
GROUP BY B.AUTHOR_ID, AUTHOR_NAME, CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY DESC
```

## 69. 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 - MONTH, IN, COUNT

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/151139

### 답
```sql
SELECT
    MONTH(START_DATE) MONTH,
    CAR_ID,
    COUNT(CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
  AND CAR_ID IN (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*)>= 5)
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC
```

## 70. 그룹별 조건에 맞는 식당 목록 출력하기 - WHERE SUBQUERY, DATE_FORMAT, JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131124

### 답
```sql
SELECT
    B.MEMBER_NAME,
    A.REVIEW_TEXT,
    DATE_FORMAT(A.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM REST_REVIEW A
         JOIN MEMBER_PROFILE B ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID = (SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(MEMBER_ID) DESC LIMIT 1)
ORDER BY A.REVIEW_DATE ASC, REVIEW_TEXT ASC
```

## 71. 오프라인/온라인 판매 데이터 통합하기 - UNION

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131537

### 답
```sql
SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE ('2022-03%')
UNION
SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID,
    SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE ('2022-03%')
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;
```

## 72. 조건에 부합하는 중고거래 댓글 조회하기 - JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/164673

### 답
```sql
SELECT
    A.TITLE,
    A.BOARD_ID,
    B.REPLY_ID,
    B.WRITER_ID,
    B.CONTENTS,
    DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM USED_GOODS_BOARD A
         JOIN USED_GOODS_REPLY B ON A.BOARD_ID = B.BOARD_ID
WHERE DATE_FORMAT(A.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY B.CREATED_DATE ASC, TITLE ASC 
```

## 73. 입양 시각 구하기(2) - WITH RECURSIVE, RIGHT JOIN

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59413

### 답
```sql
WITH RECURSIVE HOURS AS (
    SELECT 0 AS NUM
    UNION ALL
    SELECT NUM+1 FROM HOURS
    WHERE NUM < 23
)

SELECT
    HOURS.NUM AS HOUR,
    COUNT(A.ANIMAL_ID) AS COUNT
FROM ANIMAL_OUTS A
    RIGHT JOIN HOURS ON EXTRACT(HOUR FROM A.DATETIME) = HOURS.NUM
GROUP BY HOURS.NUM
ORDER BY HOUR ASC
```

## 74. 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기 - FLOOR, JOIN USING, HAVING

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/157339

### 답
```sql
SELECT CAR_ID, C.CAR_TYPE,
       FLOOR(30*DAILY_FEE*(1-DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
         JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN USING(CAR_TYPE)
WHERE C.CAR_TYPE IN ('세단', 'SUV')
  AND CAR_ID NOT IN (SELECT CAR_ID
                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                     WHERE END_DATE >= '2022-11-1'
                       AND START_DATE <= '2022-11-30')
  AND DURATION_TYPE = '30일 이상'
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC 
```

## 77. [leetcode-1757]Recyclable and Low Fat Products - SELECT

### 링크
https://leetcode.com/problems/recyclable-and-low-fat-products/description/

### 답
```sql
SELECT
    product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y'``
```

## 78. [leetcode-584]Find Customer Referee - IFNULL

### 링크
https://leetcode.com/problems/find-customer-referee/

### 답
```sql
select name from Customer where IFNULL(referee_id, 0) <> 2
```

## 79. [leetcode-595]Big Countries - where

### 링크
https://leetcode.com/problems/big-countries/

### 답
```sql
select
    name,
    population,
    area
from World
where area >= 3000000 or population >= 25000000
```

## 80. [leetcode-1148]Article Views I - where, order

### 링크
https://leetcode.com/problems/article-views-i/

### 답
```sql
select
    distinct viewer_id as id
from Views
where viewer_id = author_id
order by id
```

## 81. [leetcode-1683]Invalid Tweets - where

### 링크
https://leetcode.com/problems/invalid-tweets/

### 답
```sql
select
    tweet_id
from Tweets
where LENGTH(content) > 15
```

## 82. [leetcode-1378]Replace Employee ID With The Unique Identifier - left join

### 링크
https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/

### 답
```sql
select
    EU.unique_id,
    E.name
from Employees E
         left join EmployeeUNI EU on E.id = EU.id
```

## 83. [leetcode-1068]Product Sales Analysis I - left join

### 링크
https://leetcode.com/problems/product-sales-analysis-i/description/

### 답
```sql
select
    P.product_name,
    S.year,
    S.price
from Sales S
         left join Product P on S.product_id = P.product_id
```

## 84. [leetcode-1581]Customer Who Visited but Did Not Make Any Transactions - left join, COUNT

### 링크
https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/

### 답
```sql
select
    V.customer_id,
    COUNT(v.visit_id) AS count_no_trans
from Visits V
         left join Transactions T on V.visit_id = T.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id; 
```

## 85. [leetcode-197]Rising Temperature - left join, DATEDIFF

### 링크
https://leetcode.com/problems/rising-temperature/description/

### 답
```sql
select
    w2.id
from Weather W1
         join Weather w2
              ON DATEDIFF (w1.recordDate ,w2.recordDate ) = -1
                  AND w2.temperature>w1.temperature   
```

## 86. [leetcode-1661]Average Time of Process per Machine - round

### 링크
https://leetcode.com/problems/average-time-of-process-per-machine/description/

### 답
```sql
select a1.machine_id, round(avg(a2.timestamp-a1.timestamp), 3) as processing_time
from Activity a1
         join Activity a2
              on a1.machine_id=a2.machine_id and a1.process_id=a2.process_id
                  and a1.activity_type='start' and a2.activity_type='end'
group by a1.machine_id
```

## 87. [leetcode-577]Employee Bonus - left join

### 링크
https://leetcode.com/problems/employee-bonus/description/

### 답
```sql
select
    e.name,
    b.bonus
from Employee e
         left join Bonus b
                   on e.empId=b.empId
where b.bonus < 1000 or b.bonus is null
```

## 88. [leetcode-1280]Students and Examinations - left join, count

### 링크
https://leetcode.com/problems/students-and-examinations/description/

### 답
```sql
SELECT
    S.student_id,
    S.student_name,
    SUB.subject_name,
    count(E.subject_name) AS attended_exams
FROM Students S
         JOIN Subjects SUB
         LEFT OUTER JOIN Examinations E
                         ON S.student_id = E.student_id AND SUB.subject_name = E.subject_name
GROUP BY S.student_id, S.student_name, SUB.subject_name
ORDER BY S.student_id, SUB.subject_name
```

## 89. [leetcode-570]Managers with at Least 5 Direct Reports - join, GROUP BY

### 링크
https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/

### 답
```sql
SELECT
    e1.name
FROM
    Employee e1
        JOIN
    Employee e2
    ON
        e1.id = e2.managerId
GROUP BY
    e1.name,e1.id
HAVING
    COUNT(e2.id) >= 5;
```

## 90. [leetcode-1934]Confirmation Rate - left join, CASE, GROUP BY

### 링크
https://leetcode.com/problems/confirmation-rate/

### 답
```sql
SELECT
    s.user_id,
    CASE
        WHEN
            c.time_stamp IS NULL THEN 0.0
        ELSE ROUND(SUM(c.action = 'confirmed')/COUNT(*), 2)
        END AS confirmation_rate
FROM Signups s
         LEFT JOIN
     Confirmations c
     ON s.user_id = c.user_id
GROUP BY s.user_id;
```

## 91. [leetcode-620]Not Boring Movies - select

### 링크
https://leetcode.com/problems/not-boring-movies/description/

### 답
```sql
SELECT
    *
FROM Cinema c
WHERE c.id % 2 = 1 AND description != 'boring'
ORDER BY rating DESC
```

## 92. [leetcode-1251]Average Selling Price - select

### 링크
https://leetcode.com/problems/average-selling-price/description/

### 답
```sql
SELECT
    p.product_id,
    IFNULL(ROUND(SUM(units*price)/SUM(units),2),0) AS average_price
FROM Prices p LEFT JOIN UnitsSold u
                        ON p.product_id = u.product_id AND
                           u.purchase_date BETWEEN start_date AND end_date
group by product_id
```

## 93. [leetcode-1075]Project Employees I - select

### 링크
https://leetcode.com/problems/project-employees-i/description/

### 답
```sql
SELECT p.project_id, ROUND(AVG(e.experience_years),2) AS average_years
FROM Project p
         LEFT JOIN Employee e
                   ON p.employee_id = e.employee_id
GROUP BY p.project_id
```

## 94. [leetcode-1633]Percentage of Users Attended a Contest - select, subquery

### 링크
https://leetcode.com/problems/percentage-of-users-attended-a-contest/description/

### 답
```sql
select
    contest_id,
    round(count(distinct user_id) * 100 /(select count(user_id) from Users) ,2) as percentage
from  Register
group by contest_id
order by percentage desc,contest_id
```

## 95. [leetcode-1211]Queries Quality and Percentage - select, round

### 링크
https://leetcode.com/problems/queries-quality-and-percentage/description/

### 답
```sql
SELECT
    QUERY_NAME,
    ROUND(AVG(RATING/POSITION), 2) AS QUALITY,
    ROUND(AVG(IF(RATING<3,1,0))*100, 2) AS POOR_QUERY_PERCENTAGE
FROM QUERIES
WHERE query_name IS NOT NULL
GROUP BY QUERY_NAME
```

## 96. [leetcode-1193]Monthly Transactions I - select, SUBSTR

### 링크
https://leetcode.com/problems/monthly-transactions-i/description/

### 답
```sql
SELECT
    SUBSTR(trans_date,1,7) as month, 
    country, 
    count(id) as trans_count, 
    SUM(CASE WHEN state = 'approved' then 1 else 0 END) as approved_count, 
    SUM(amount) as trans_total_amount, 
    SUM(CASE WHEN state = 'approved' then amount else 0 END) as approved_total_amount
FROM Transactions
GROUP BY month, country
```

## 97. [leetcode-1174]Immediate Food Delivery II - select, round

### 링크
https://leetcode.com/problems/immediate-food-delivery-ii/description/

### 답
```sql
SELECT
    round(avg(order_date = customer_pref_delivery_date)*100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, min(order_date)
    FROM Delivery
    GROUP BY customer_id
);
```

## 98. [leetcode-550]Game Play Analysis IV - select, round

### 링크
https://leetcode.com/problems/game-play-analysis-iv/description/

### 답
```sql
SELECT ROUND(COUNT(DISTINCT player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) as fraction
FROM Activity
WHERE (player_id, DATE_SUB(event_date, INTERVAL 1 DAY))
          IN (SELECT player_id, MIN(event_date) AS first_login FROM ACTIVITY GROUP BY player_id)
```

## 99. [leetcode-2356]Number of Unique Subjects Taught by Each Teacher - select, DISTINCT

### 링크
https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/description/

### 답
```sql
SELECT
    DISTINCT teacher_id,
             COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id; 
```

## 100. [leetcode-1141]User Activity for the Past 30 Days I - select, COUNT, DISTINCT

### 링크
https://leetcode.com/problems/user-activity-for-the-past-30-days-i/description/

### 답
```sql
SELECT
    activity_date AS day, 
    COUNT(DISTINCT user_id) AS active_users
FROM activity
WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY activity_date;
```

## 101. [leetcode-1070]Product Sales Analysis III - JOIN, MIN

### 링크
https://leetcode.com/problems/product-sales-analysis-iii/description/

### 답
```sql
SELECT
    S.product_id,
    MinYear.first_year,
    S.quantity,
    S.price
FROM
    Sales S
        JOIN
    (
        SELECT
            product_id,
            MIN(year) AS first_year
        FROM
            Sales
        GROUP BY
            product_id
    ) AS MinYear ON S.product_id = MinYear.product_id AND S.year = MinYear.first_year;

```

## 102. [leetcode-596]Classes More Than 5 Students - COUNT

### 링크
https://leetcode.com/problems/classes-more-than-5-students/description/

### 답
```sql
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;
```

## 103. [leetcode-1729]Find Followers Count - COUNT

### 링크
https://leetcode.com/problems/find-followers-count/description/

### 답
```sql
select user_id , count(user_id) as followers_count
from followers
group by user_id
order by user_id asc , followers_count asc;
```

## 104. [leetcode-619]Biggest Single Number - MAX

### 링크
https://leetcode.com/problems/biggest-single-number/description/

### 답
```sql
SELECT MAX(num) AS num
FROM (
         SELECT num
         FROM MyNumbers
         GROUP BY num
         HAVING COUNT(num) = 1
     ) AS unique_numbers;
```

## 105. [leetcode-1045]Customers Who Bought All Products

### 링크
https://leetcode.com/problems/customers-who-bought-all-products/description/

### 답
```sql
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(distinct product_key) = (SELECT COUNT(product_key) FROM Product);
```

## 104. [leetcode-1045]Customers Who Bought All Products

### 링크
https://leetcode.com/problems/customers-who-bought-all-products/description/

### 답
```sql
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(distinct product_key) = (SELECT COUNT(product_key) FROM Product);
```

## 106. [leetcode-1731]The Number of Employees Which Report to Each Employee

### 링크
https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/description/

### 답
```sql
select m.employee_id ,m.name,COUNT(e.employee_id ) as reports_count,ROUND(AVG(e.age*1.0),0) as average_age
from Employees e
         join Employees m
              on e.reports_to =m.employee_id
group by m.employee_id ,m.name
ORDER BY employee_id
```

## 107. [leetcode-1789]Primary Department for Each Employee

### 링크
https://leetcode.com/problems/primary-department-for-each-employee/description/

### 답
```sql
select employee_id, department_id
from Employee
Where primary_flag = 'Y'
UNION
select employee_id, department_id
from Employee
group by employee_id
having count(employee_id) = 1
```

## 108. [leetcode-610]Triangle Judgement

### 링크
https://leetcode.com/problems/triangle-judgement/description/

### 답
```sql
SELECT x,y,z,
       case WHEN (x+y) > z AND (x+z) > y AND (y+z) > x THEN 'Yes' ELSE 'No' end AS triangle
FROM Triangle 
```

## 109. [leetcode-180]Consecutive Numbers

### 링크
https://leetcode.com/problems/consecutive-numbers/description/

### 답
```sql
SELECT distinct
    i1.num as ConsecutiveNums
FROM
    logs i1,
    logs i2,
    logs i3
WHERE
    i1.id=i2.id+1 AND
    i2.id=i3.id+1 AND
    i1.num=i2.num AND
    i2.num=i3.num
```

## 110. [leetcode-1164]Product Price at a Given Date

### 링크
https://leetcode.com/problems/product-price-at-a-given-date/description/

### 답
```sql
SELECT product_id, 10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16'
UNION
SELECT product_id, new_price AS price
FROM Products
WHERE (product_id, change_date)
          IN
      (SELECT product_id,
              MAX(change_date)
       FROM Products
       WHERE change_date <= '2019-08-16'
       GROUP BY product_id)
```

## 111. [leetcode-1204]Last Person to Fit in the Bus

### 링크
https://leetcode.com/problems/last-person-to-fit-in-the-bus/description/

### 답
```sql
SELECT person_name from (SELECT person_name,turn,
                                sum(weight) over (order by turn) AS cum FROM queue) p1
where cum<=1000 order by turn DESC limit 1;
```

## 112. [leetcode-1907]Count Salary Categories

### 링크
https://leetcode.com/problems/count-salary-categories/description/

### 답
```sql
(SELECT "Low Salary" AS category, COUNT(*) AS accounts_count FROM accounts WHERE income < 20000)
UNION
(SELECT "Average Salary" AS category, COUNT(*) AS accounts_count FROM accounts WHERE income BETWEEN 20000 AND 50000)
UNION
(SELECT "High Salary" AS category, COUNT(*) AS accounts_count FROM accounts WHERE income > 50000)
```

## 113. [leetcode-1978]Employees Whose Manager Left the Company

### 링크
https://leetcode.com/problems/employees-whose-manager-left-the-company/description/

### 답
```sql
SELECT DISTINCT e2.EMPLOYEE_ID
FROM EMPLOYEES e1,EMPLOYEES e2
WHERE e2.SALARY<30000 AND
    e2.MANAGER_ID NOT IN(SELECT EMPLOYEE_ID FROM EMPLOYEES)
ORDER BY EMPLOYEE_ID;
```

## 114. [leetcode-626]Exchange Seats

### 링크
https://leetcode.com/problems/exchange-seats/description/

### 답
```sql
select
    case
        when id=(select max(id) from seat) and id%2 <> 0 then id
        when id%2 = 0 then id-1
        when id%2 <> 0 then id+1
        end as id, student
from seat
order by id
```

## 115. [leetcode-1341]Movie Rating

### 링크
https://leetcode.com/problems/movie-rating/description/

### 답
```sql
(SELECT U.name as results
 FROM Users U LEFT JOIN MovieRating R using(user_id)
 GROUP BY U.name
 ORDER BY COUNT(R.movie_id) DESC, U.name LIMIT 1)
UNION ALL
(SELECT M.title as results
 FROM MovieRating R LEFT JOIN Movies M using(movie_id)
 WHERE R.created_at like "2020-02-%"
 GROUP BY M.title
 ORDER BY AVG(R.rating) DESC, M.title LIMIT 1)
```

## 127. [hackerrank]Revising the Select Query I

### 링크
https://www.hackerrank.com/challenges/revising-the-select-query/problem?isFullScreen=true

### 답
```sql
Select * From CITY WHERE population > 100000 AND CountryCode = 'USA'
```

## 128. [hackerrank]Revising the Select Query II

### 링크
https://www.hackerrank.com/challenges/revising-the-select-query-2/problem?isFullScreen=true

### 답
```sql
Select NAME From CITY WHERE population > 120000 AND CountryCode = 'USA'
```

## 129. [hackerrank]Select All

### 링크
https://www.hackerrank.com/challenges/select-all-sql/problem?isFullScreen=true

### 답
```sql
select * from CITY
```

## 130. [hackerrank]Select By ID

### 링크
https://www.hackerrank.com/challenges/select-by-id/problem?isFullScreen=true

### 답
```sql
select * from CITY where ID = 1661
```

## 131. [hackerrank]Japanese Cities' Attributes

### 링크
https://www.hackerrank.com/challenges/japanese-cities-attributes/problem?isFullScreen=true

### 답
```sql
SELECT * FROM CITY WHERE COUNTRYCODE ='JPN'
```

## 132. [hackerrank]Japanese Cities' Names

### 링크
https://www.hackerrank.com/challenges/japanese-cities-name/problem?isFullScreen=true

### 답
```sql
SELECT NAME FROM CITY WHERE COUNTRYCODE ='JPN'
```

## 133. [hackerrank]Weather Observation Station 1

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-1/problem?isFullScreen=true

### 답
```sql
SELECT CITY, STATE FROM STATION
```

## 134. [hackerrank]Weather Observation Station 2

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-2/problem?isFullScreen=true

### 답
```sql
SELECT ROUND(SUM(LAT_N),2), ROUND(SUM(LONG_W),2) FROM STATION
```

## 135. [hackerrank]Weather Observation Station 3

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-3/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY FROM STATION WHERE ID % 2 = 0
```

## 136. [hackerrank]Weather Observation Station 4

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-4/problem?isFullScreen=true

### 답
```sql
SELECT COUNT(CITY) - COUNT(DISTINCT CITY) FROM STATION
```

## 137. [hackerrank]Weather Observation Station 5

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-5/problem?isFullScreen=true

### 답
```sql
SELECT CITY, length(CITY) AS LEN FROM STATION ORDER BY LEN,CITY LIMIT 1;
SELECT CITY, length(CITY) AS LEN FROM STATION ORDER BY LEN DESC ,CITY DESC LIMIT 1;
```

## 138. [hackerrank]Weather Observation Station 6

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-6/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY from STATION where LOWER(LEFT(city, 1)) in ('a','e','i','o','u');
```

## 139. [hackerrank]Weather Observation Station 7

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-7/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY from STATION where LOWER(RIGHT(city, 1)) in ('a','e','i','o','u');
```

## 140. [hackerrank]Weather Observation Station 8

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-8/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY from STATION where LOWER(RIGHT(city, 1)) in ('a','e','i','o','u') AND LOWER(LEFT(city, 1)) in ('a','e','i','o','u');
```

## 141. [hackerrank]Weather Observation Station 9

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-9/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY FROM STATION WHERE NOT LEFT(CITY,1) IN ('A','E','I','O','U')
```

## 142. [hackerrank]Weather Observation Station 10

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-10/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY FROM STATION WHERE NOT CITY REGEXP '[A, E, I, O, U, a, e, i, o, u]$'
```

## 143. [hackerrank]Weather Observation Station 11

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-11/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '^[aeiouAEIOU]' or CITY NOT REGEXP '[aeiouAEIOU]$'
```

## 144. [hackerrank]Weather Observation Station 12

### 링크
https://www.hackerrank.com/challenges/weather-observation-station-12/problem?isFullScreen=true

### 답
```sql
SELECT DISTINCT city FROM station WHERE city REGEXP '^[^aeiouAEIOU]' and city REGEXP '[^aeiouAEIOU]$';
```

## 145. [hackerrank]Higher Than 75 Marks

### 링크
https://www.hackerrank.com/challenges/more-than-75-marks?isFullScreen=true

### 답
```sql
SELECT NAME FROM STUDENTS WHERE MARKS >75 ORDER BY SUBSTR(NAME,-3,3 ), ID ASC;
```

## 146. [hackerrank]Employee Names

### 링크
https://www.hackerrank.com/challenges/name-of-employees/problem?isFullScreen=true

### 답
```sql
SELECT NAME FROM EMPLOYEE ORDER BY NAME ASC
```

## 147. [hackerrank]Employee Salaries

### 링크
https://www.hackerrank.com/challenges/salary-of-employees/problem?isFullScreen=true

### 답
```sql
SELECT NAME FROM EMPLOYEE WHERE months < 10 AND salary >= 2000 ORDER BY employee_id ASC
```

## 148. [hackerrank]Type of Triangle

### 링크
https://www.hackerrank.com/challenges/what-type-of-triangle/problem?isFullScreen=true

### 답
```sql
Select
    Case
        When A + B <= C or A + C <= B or B + C <= A Then 'Not A Triangle'
        When A = B and B = C Then 'Equilateral'
        When A = B or A = C or B = C Then 'Isosceles'
        Else 'Scalene'
        End as type_of_triangle
From Triangles;
```

## 148. [hackerrank]The PADS

### 링크
https://www.hackerrank.com/challenges/the-pads/problem?isFullScreen=true

### 답
```sql
SELECT CONCAT(Name, '(', SUBSTRING(Occupation, 1, 1), ')') FROM OCCUPATIONS ORDER BY Name;

SELECT CONCAT('There are a total of ', COUNT(Occupation), ' ', LOWER(Occupation),"s",'.') FROM OCCUPATIONS GROUP BY Occupation ORDER BY COUNT(Occupation), Occupation;
```