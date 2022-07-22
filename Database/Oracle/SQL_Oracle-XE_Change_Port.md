# Oracle XE - 8080 포트 변경하기

 오래 전 사용했던 Oracle DB 포트를 이 기회에 변경하려고 찾아봤다.



CMD로 SQLPLUS 에 접속할 때 관리자로 접속하는 것 부터 까먹어서 정리를 해두려고 한다.





## CMD로 ORACLE DB(SQLPLUS) 관리자 접속하기



1. cmd 창을 키고 sqlplus 입력
2. 입력하면 Enter user-name: 이 나오고 system 입력
3. 설정했었던 관리자 비밀번호 입력
4. 접속 성공. (나는 너무 오래되서 expired 되었다는 창이 나와 비밀번호를 변경하게 되었다.)
   - 접속 성공하면 `SQL >` 로 변경되어 접속됨을 확인할 수 있다. 



![image](SQL_Oracle-XE_Change_Port/180383031-27636c56-7f60-4ec1-bf2c-6460e94e0a6c.png)



## 8080 포트 변경하기



1. 현재 포트가 궁금하다면 다음 명령어를 쳐보자.
   - `SELECT DBMS_XDB.GETHTTPPORT() FROM DUAL;`
   - ![image](SQL_Oracle-XE_Change_Port/180383339-e07f1334-aabf-4ac1-b39c-c951ca614c16.png)
2. 포트 변경하기
   - `EXEC DBMS_XDB.SETHTTPPORT(9000);`
   - 위 명령어를 실행하면 포트가 9000번으로 바뀐다.
3. 포트 변경 확인하기
   - `SELECT DBMS_XDB.GETHTTPPORT() FROM DUAL;`
   - ![image-20220722160817448](SQL_Oracle-XE_Change_Port/image-20220722160817448.png)