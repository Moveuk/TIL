- 어떤 Transactional 어노테이션을 사용해야 할까?

  간단 정리

  

  스프링을 하다보면 `@Transactional` 어노테이션이 2가지가 있다.

  

  1. javax.transaction의 @Transactional
  2. org.springframework.transaction.annotation의 @Transactional

  

  ##  javax.transaction의 @Transactional

  

   패키지 이름 그대로 자바 표준 확장 패키지를 의미한다. 즉, 자바에서 기본 제공한다는 뜻이다.

  

  아래는 코드이다. 

  코드길이를 줄이기 위해 주석은 삭제하고 필드와 메소드명만 명시하였다.

  ```java
  @Inherited
  @InterceptorBinding
  @Target({ElementType.TYPE, ElementType.METHOD})
  @Retention(value = RetentionPolicy.RUNTIME)
  public @interface Transactional {
  
      TxType value() default TxType.REQUIRED;
  
      public enum TxType {
  
          REQUIRED,
  
          REQUIRES_NEW,
  
          MANDATORY,
  
          SUPPORTS,
  
          NOT_SUPPORTED,
  
          NEVER
      }
  
      @Nonbinding
      public Class[] rollbackOn() default {};
  
      @Nonbinding
      public Class[] dontRollbackOn() default {};
  
  }
  ```

  

  ##  org.springframework.transaction.annotation의 @Transactional

  

  패키지 이름대로 springframework 에서 제공하는 것이다. 고로 Container가 관리를 하게 된다.

  

  코드길이를 줄이기 위해 주석은 삭제하고 필드와 메소드명만 명시하였다.

  ```java
  @Target({ElementType.TYPE, ElementType.METHOD})
  @Retention(RetentionPolicy.RUNTIME)
  @Inherited
  @Documented
  public @interface Transactional {
  
  	@AliasFor("transactionManager")
  	String value() default "";
  
  	@AliasFor("value")
  	String transactionManager() default "";
  
  	String[] label() default {};
  
  	Propagation propagation() default Propagation.REQUIRED;
  
  	Isolation isolation() default Isolation.DEFAULT;
  
  	int timeout() default TransactionDefinition.TIMEOUT_DEFAULT;
  
  	String timeoutString() default "";
  
  	boolean readOnly() default false;
  
  	Class<? extends Throwable>[] rollbackFor() default {};
  
  	String[] rollbackForClassName() default {};
  
  	Class<? extends Throwable>[] noRollbackFor() default {};
  
  	String[] noRollbackForClassName() default {};
  
  }
  
  ```

  

  ## 차이점?!?

  실제로 실행해보면 어떤 어노테이션이든 잘 작동하는 것을 알 수 있다.

  다만 위의 코드처럼 실제로 구성되어 있는 기능이 다르다. `@javax.transaction.Transactional`은 `TransactionType`, `rollback` 정도로 구현되어 있는 반면, `@org.springframework.transaction.annotation.Transactional`은 `propagation`, `isolation`, `timeout`, `readOnly`, `rollback`으로 구성되어 있는 것을 알 수 있다. 

  

    또한, 버전 호환에 대한 차이점이 존재한다고 하는데, 딱히 주석에는 보이지 않고 spring doc에는 1.2 버전부터 지원되었다고 하니 상당히 오래된 듯 보인다. javax는 JTA 기준 1.2 버전 부터이고 검색을 해보니 스프링 4.0 이전에는 지원을 안한다고 한다.

  

  ## 결론

   스프링 프레임워크 `@Transactional`어노테이션의 구성의 요소들을 사용할 것이라면 옛날 버전부터 지원하는 프레임워크 `@Transactional`어노테이션을 사용하자! 다만, 단순히 `@Transactional`어노테이션을 사용만 한다면 어떤 어노테이션을 사용하던 크게 상관이 없다.

  

  

  참고 문서

  - [spring Transactional doc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
  - [javax Transactional doc](https://javaee.github.io/javaee-spec/a/javax/transaction/Transactional.html)