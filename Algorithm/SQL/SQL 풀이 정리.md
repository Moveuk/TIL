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
