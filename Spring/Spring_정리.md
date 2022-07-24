# Spring 정리









## Spring

![](https://i.imgur.com/STWEQ1C.png)



### Controller 

- Controller 는 제일 바깥 쪽에서 요청을 받고, 응답을 되돌려주는 역할을 한다.

- api를 통해 DTO를 주로 받으며 DTO를 Service 단까지 보내준다.

  

### Service 

- Service 는 중간에서 구체적인 작업 순서를 결정한다.
- 받은 DTO를 통해 Entity를 변경하면 자바 영속성이 이를 저장해 두었다가 flush 해버린다.



### Repository 

- Repository 는 DB와 직접 소통함으로써 자료를 생성하고, 조회하고, 변경하고, 삭제한다.





### DTO(Data Transfer Object)

 JPA에서 Entity의 값을 Repository를 통해 가져오면 Spring에ㅉ서 받아서 사용하는 것이 DTO이다.

![image](https://user-images.githubusercontent.com/84966961/180462808-f17c8cb1-72a3-412c-87bc-75a1b8337b92.png)

테이블의 값인 domain 자체 값을 변경하기엔 위험하므로 완충재 역할을 하는 DTO를 만들어 사용한다.



단순히 데이터만을 넣어 사용하는 객체로 getter, setter만을 가지고 있다. 이유는 데이터만 옴기는데 사용할 뿐 다른 로직은 필요없기 때문이다. 또한, 생성자를 통한 초기화를 통해 불변 객체로도 사용할 수 있다.



#### DTO(Data Transfer Object) vs VO(Value Object)



 항상 DTO와 VO의 차이를 헷갈렸던 것 같다. 

 DTO와 달리 VO는 Value Object 뜻 그대로 **값** 자체를 말하는 객체이다. 값을 뜻하므로 불변성을 가지며 생성자를 통해 초기화한다. 당연히 인스턴스를 여러 개 만들더라도 고유한 값이므로 Equals와 hashCode를 재정의하여 같은 필드를 가지고 있는 객체는 같은 값임을 보여야한다.

 DTO와는 달리 로직을 포함하고 있어도 된다.



DTO와 VO의 차이를 표로 정리해보면 다음과 같다.



|           |                DTO                |              VO              |
| :-------: | :-------------------------------: | :--------------------------: |
|   목적    | 계층간 데이터 전달.(완충재 역할)  |    데이터 값 자체를 표현.    |
|  동등성   | 필드값이 같아도 같은 객체가 아님. | 필드값이 같으면 같은 객체임. |
|  가변성   |    Setter를 통해 가변 가능함.     |      절대 변하지 않음.       |
| 내부 로직 |   오직 Getter / Setter만 가짐.    |      로직 가질 수 있음.      |



 







