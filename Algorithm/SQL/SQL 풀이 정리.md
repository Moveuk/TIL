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

### 링크
https://school.programmers.co.kr/learn/courses/30/lessons/59408

### 답
```sql
SELECT count(DISTINCT NAME) FROM ANIMAL_INS
```
