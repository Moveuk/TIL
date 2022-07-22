# 스프링 시작시 코드를 실행 시키는 3가지 방법


 캠프 강의를 듣다가 스프링 부트를 시작하는 main메소드가 들어있는 OOOApplication.java 내부에 새로운 메소드를 만들어 테스트를 진행하는 것을 보고 정리해두면 좋을 것 같아 적는다.



 스프링 부트가 시작되고 각 빈들이 만들어지게 되는데 이 때 초기화를 하고 필요한 로직을 끼워 넣는 방법이다. 사용할 일이 있을 것 같긴 하나 구체적으로는 모르겠어서 일단 정리해둔다.



## 0. 스프링 부트 애플리케이션 main 메소드 내부에  코드 넣기

![180455533-5bf72377-28c9-49b3-b684-392b359e5073](https://user-images.githubusercontent.com/84966961/180463178-0ce09c1e-ab51-49c7-b87d-4bd2d5ce0d76.png)

 제일 쉬운 방법이다. 스프링을 시작하려면 이 main method를 거쳐가게 되고, 그 이후에 어떤 코드를 넣는다면 스프링 부트가 초기화되고 난 이후에 바로 실행이 가능하다.



 다만, 보통의 경우에는 스프링을 통해 생성된 빈(Service, Repository 등)을 주입받아 사용하고 싶을텐데 각 빈들을 주입받기가 어렵다.



## 1. CommandLineRunner

![180451883-0f7c0b17-7463-47bc-8975-ffef3a8cc84e](https://user-images.githubusercontent.com/84966961/180463250-c8febd72-6f63-4996-9562-692e8abbb886.png)

스프링이 구동이 끝나고 `CommandLineRunner` 인터페이스로 구현한 클래스에 컴포넌트 혹은 빈 등록이 되어있다면 스캔하여 내부 run 메소드를 실행시켜준다.



### 1-1. CommandLineRunner을 구현한 클래스를 컴포넌트 스캔 받기.

  jar로 패키징되어있는 애플리케이션을 실행시킬때, String값을 받아 표시할 수 있다.

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner Args: " + Arrays.toString(args));
    }

}
```



jar 패키징을 실행할때 `abc`와 `123`을 같이 넣으면 아래처럼 run 메소드가 받아 args 값을 보여준다.

```
$ java -jar target/demo-0.0.1-SNAPSHOT.jar abc 123
```

Spring Console

```
s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
CommandLineRunner Args: [abc, 123]
```



### 1-2. CommandLineRunner 구현체 클래스를 만들어 사용하기

![180453026-e7a5968d-433b-4efa-a7e9-1dab6493cc14](https://user-images.githubusercontent.com/84966961/180463302-0271e6d5-4bf3-48a3-87e6-d0c330da5b7f.png)

 위의 코드와 같이 클래스를 따로 구현해주고 Application 내부에 Bean 등록 혹은 컴포넌트 스캔을 통해 사용해주면 된다. 하지만 다음 방법은 람다식으로 더 간단해진다.



### 1-3. CommandLineRunner 구현 객체를 바로 람다식으로 리턴하기

![image-20220722224356316](https://user-images.githubusercontent.com/84966961/180463384-fb50edec-87e5-4c05-9d99-1b860302d6d8.png)


  위처럼 어플리케이션 내부에 메소드를 만들어 사용하면 된다. 메소드 리턴은 `CommandLineRunner` 타입이고 args를 파라미터로 받아 람다식을 이용하여 로직을 짜주면 된다. 



 본인은 Spring을 Service와 Repository를 완벽 구현하기 전에 더미 데이터를 넣어 테스트해보기 위해 사용해 보았다.



### 1-4. `@Bean` 추가 정보

`@Bean` 어노테이션은 원래 `@Configuration`  어노테이션이 지정되어 있는 클래스의 내부에서 2개 이상의 `@Bean` 메소드를 선언하여 "완전한" 모드로 사용가능하게 하는데 만약 `@Configuration`  어노테이션이 없는 클래스에서 작동하게 되면 "가벼운" 모드로 사용할 수 있다고 한다.



## 2. ApplicationRunner

![180454989-b09ad0a3-0e40-46b1-a299-a2c2df4fba5c](https://user-images.githubusercontent.com/84966961/180463438-7fdd9629-13d7-4100-a060-30fcebf5b504.png)


`ApplicationRunner` 인터페이스도 앞서 말한 `CommandLineRunner`와 크게 다르지 않다. 다만 받는 파라미터가 `ApplicationArguments` 타입으로 좀 더 추상화된 타입을 받는다.



## 3. @EventListener 어노테이션

 3가지 방법 중 가장 최신에 나온 방법으로 Spring 4.2 버전부터 시작되었다.

```java
@SpringBootApplication
public class SpringBasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringinitApplication.class, args);
    }

    @EventListener(MyCustomEvent.class,ApplicationReadyEvent.class)
    public void SpringReady(){
        System.out.println("ApplicationReadyEvent.class가 작동하면 내가 작동!");
    }
}
```



 아주 간단하다. `@EventListener` 어노테이션과 어떤 class를 감지할 것인지만 적어주면 그 class가 실행되었을 때 메소드가 알아서 작동한다. 



 이런 이벤트 방식의 장점으로는 각 `@Bean` 들간의 관계를 느슨하게 해줄 수 있다. 회원 가입을 해야하고 다른 빈들 A, B, C가 인식하여 어떤 로직을 처리해야한다면 기존에는 각 `@Bean`을 주입하여 호출한 후 로직을 짰을 것이다. 하지만 `@EventListener` 어노테이션을 사용하게 되면 그런 결합들을 끊어낼 수 있다. 미래에 있을 확장이나 축소에 조금 더 유연하게 반응할 수 있다는 것이다. 단, `@EventListener` 어노테이션은 위에서도 언급했든 Spring 4.2 버전 이상에서만 가능하다.



 또한, 위 코드의 `MyCustomEvent.class`처럼 내가 만든 클래스를 ApplicationContext의 `void addApplicationListener(ApplicationListener<?> listener);`를 통해 리스너를 구현하여 추가할 수 있다.



### 3-1. ApplicationEvent의 종류

 스프링의 생명주기에 따라서 다음 이벤트들을 사용할 수 있을 것이다.

- ApplicationContextInitializedEvent
- ApplicationEnvironmentPreparedEvent
- ApplicationPreparedEvent
- ApplicationReadyEvent
- ApplicationStartedEvent
- ApplicationFailedEvent
- ApplicationStartingEvent



 위의 이벤트들을 부르는 각 메소드들이다.

![180460325-694ca0c9-d376-4c18-8ca0-94a78ddf2a81](https://user-images.githubusercontent.com/84966961/180463496-6c5a763f-606e-4c56-9c51-7c75d8678fd1.png)



SpringApplication의 run method를 통해 스프링이 실행될 때 어떤 일들을 하는지 볼 수 있다.

```java
public ConfigurableApplicationContext run(String... args) {
		long startTime = System.nanoTime();
		DefaultBootstrapContext bootstrapContext = createBootstrapContext();
		ConfigurableApplicationContext context = null;
		configureHeadlessProperty();
		SpringApplicationRunListeners listeners = getRunListeners(args);
		listeners.starting(bootstrapContext, this.mainApplicationClass);
		try {
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
			ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments);
			configureIgnoreBeanInfo(environment);
			Banner printedBanner = printBanner(environment);
			context = createApplicationContext();
			context.setApplicationStartup(this.applicationStartup);
			prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
			refreshContext(context);
			afterRefresh(context, applicationArguments);
			Duration timeTakenToStartup = Duration.ofNanos(System.nanoTime() - startTime);
			if (this.logStartupInfo) {
				new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), timeTakenToStartup);
			}
			listeners.started(context, timeTakenToStartup);
			callRunners(context, applicationArguments);
		}
...
	}
```



 마지막쯤을 보면 `listeners.started(context, timeTakenToStartup);`에서 위 사진의 started 메소드를 실행 시키는 것을 알 수 있다. 그렇게 되면 `ApplicationStartedEvent`를 `@EventListener`가 보고 있는 메소드들이 실행되는 것 같다.



## 4. Runner의 순서

 그 다음줄에서는 `callRunners(context, applicationArguments);` 우리가 위에서 알아봤던 러너를 불러오는 것을 알 수 있는데 이 때 이 메소드 안에서는 각 러너 타입별로 호출되는 순서를 확인할 수 있다.

```java
	private void callRunners(ApplicationContext context, ApplicationArguments args) {
		List<Object> runners = new ArrayList<>();
		runners.addAll(context.getBeansOfType(ApplicationRunner.class).values());
		runners.addAll(context.getBeansOfType(CommandLineRunner.class).values());
		AnnotationAwareOrderComparator.sort(runners);
		for (Object runner : new LinkedHashSet<>(runners)) {
			if (runner instanceof ApplicationRunner) {
				callRunner((ApplicationRunner) runner, args);
			}
			if (runner instanceof CommandLineRunner) {
				callRunner((CommandLineRunner) runner, args);
			}
		}
	}
```



 코드를 보면 List를 만들어 runner를 담을 공간을 만들고, ApplicationRunner, CommandLineRunner 순으로 담는 것을 확인할 수 있다. 따라서 ApplicationRunner가 스프링 시작시 먼저 호출될 것으로 예상된다.



그 다음으로는 Order에 따라 sort 하는 것을 확인할 수 있는데 이는 각 러너에 `@Order(n)` 어노테이션으로 순서를 매길 수 있다.

```java
@Order(1)
@Component
public class DemoCommandLineRunner implements CommandLineRunner { ...

@Order(2)
@Component
public class DemoApplicationRunner implements ApplicationRunner { ...
```



만약 순서를 매길 일이 필요하다면 `@Order(n)` 어노테이션을 통해 정렬하도록 유도하면 좋을 것 같다.



## 정리

 스프링의 구동 시점에서 어떤 로직을 실행하고 싶을 때에 어떻게 해야하는지 알아보았다. 이번 기회에 SpringApplication의 run() 메소드도 뜯어보면서 실제로 Spring이 어떤 과정으로 부팅? 시작되는지 확인했던 재밌는 시간이었다. Spring 및 개발 초보로써 정확치 않은 단어나 정의를 썼을 것 같아 조금 걱정이다.























참고 글 

- [스프링 부트 구동 시점에 특정 코드 실행 시키기 (CommandLineRunner & ApplicationRunner)](https://www.daleseo.com/spring-boot-runners/#:~:text=%EC%A0%9C%EA%B3%B5%ED%95%98%EA%B3%A0%20%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4.-,CommandLineRunner,%EC%9E%88%EB%8A%94%20%EA%B2%BD%EC%9A%B0%EC%97%90%20%EC%82%AC%EC%9A%A9%ED%95%A9%EB%8B%88%EB%8B%A4.)
- [유튜브 : 토비의 스프링 부트 1 - 스프링 부트 앱에 초기화 코드를 넣는 방법 3가지](https://www.youtube.com/watch?v=f017PD5BIEc&ab_channel=TobyLee)

- [스프링 부트 앱에 초기화 코드를 넣는 방법 3가지](https://jeong-pro.tistory.com/206)

