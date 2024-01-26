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