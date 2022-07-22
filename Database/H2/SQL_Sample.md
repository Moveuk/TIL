# H2 db 에서 사용할 수 있는 SQL 문 정리

 - MYSQL도 사용 가능할 듯.



``` sql
# 테이블 생성
CREATE TABLE IF NOT EXISTS courses (
    id bigint(5) NOT NULL AUTO_INCREMENT, 
    title varchar(255) NOT NULL,
    tutor varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# 데이터 삽입
INSERT INTO courses (title, tutor) VALUES
    ('제목1', '강사1'), ('제목2', '강사2');
    
# 데이터 조회
SELECT * FROM courses;

```

