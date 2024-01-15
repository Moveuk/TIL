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

## 35. 오랜 기간 보호한 동물(2) - INNER JOIN, WHERE

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

## 36. 조건에 맞는 도서와 저자 리스트 출력하기 - DATE_FORMAT, INNER JOIN, WHERE

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