# Java Naming Convention



자바 네이밍 컨벤션은 사용자가 class, pacakage, variable 등과 같은 식별자들을 이름지을 때 따라야 하는 규칙이다.



이 규칙이 강제성을 띄지 않기에 협약(Convention)으로 불리며 Sun Microsystems and Netscape. 등의 커뮤니티에 의해 제안되었다고 한다.



## 장점 

-> 자바 프로그램에서 가독성은 아주 중요한 요소인데 이 네이밍 약속을 따르면 가독성이 증가한다!



## 각 식별자들에 따른 협약



| **Identifiers Type** | Naming Rules                                                 | Examples                                                     |
| -------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Class                | - 대문자로 시작.<br />- 하나의 명사일 것.<br />- 줄임말이 아닌 적절한 단어일 것. | public class **Employee**<br/>{<br/>//code snippet<br/>}     |
| Interface            | - 대문자로 시작.<br />- 하나의 형용사일 것.<br />- 줄임말이 아닌 적절한 단어일 것. | interface **Printable**<br/>{<br/>//code snippet<br/>}       |
| Method               | - 소문자로 시작할 것.<br />- 하나의 동사일 것. : ex) main(), print()<br />- 여러 단어일 경우 Camel 표기법을 따를 것.<br />- ex ) actionPerformed() | class Employee<br/>{<br/>// method<br/>void **draw()**<br/>{<br/>//code snippet<br/>}<br/>} |
| Variable             | - 소문자로 시작할 것.<br />- 특수문자로 시작하지 말 것 .<br />- ex) & (ampersand), $ (dollar), _ (underscore).<br />- 여러 단어일 경우 Camel 표기법을 따를 것.<br />- ex ) fileName<br />- x, y, z 같은 한단어 문자를 기피할 것. | class Employee<br/>{<br/>// variable<br/>int **id**;<br/>//code snippet<br/>} |
| Package              | - 소문자로 시작할 것.<br />- 하나의 동사일 것. : ex) main(), print()<br />- 여러 단어일 경우 dots(.)로 쪼갤 것.<br />- ex ) java.lang. | //package<br/>package **com.javatpoint;**<br/>class Employee<br/>{<br/>//code snippet<br/>} |
| Constant             | - 대문자로 작성할 것.<br />- ex ) RED, YELLOW<br />- 여러 단어일 경우 underscore(_)를 사용할 것.<br />- ex ) MAX_PRIORITY<br />- 필요하다면 첫문자 빼고는 숫자 사용 가능. | class Employee<br/>{<br/>//constant<br/>static final int **MIN_AGE** = 18;<br/>//code snippet<br/>} |



## 생각.

자바에서는 CamelCase를 사용하자!







