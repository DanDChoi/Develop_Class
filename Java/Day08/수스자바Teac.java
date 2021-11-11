1. HW ( OS + JVM + App1, App2, ... )
   (1) CPU, GPU : 두뇌 
   (2) RAM(메모리) : 책상 
   (3) HDD/SSD : 책꽃이
   (4) MainBoard : 방
   (5) Card : Sound, Video, Ran, WLRan, .. 
   (6) 주변기기: 키보드, 모니터, 마우스, 프린터, 본체.. 

2. 환경 설정 
   (1) JDK (file) 설치 
	   - jdk ( Java Development Kit )
	   - jre (Java Runtime Environment )
   (2) 환경변수 
	   - JAVA_HOME => C:\Program Files\Java\jdk-11.0.13 
	   - Path => %C:\Program Files\Java\jdk-11.0.13%\bin
	   - classpath => .
   (3) Editer
       - Editplus 
	   - Eclipse
	   - VSCode
	   - IntelliJ

   (4) API
       - jdk-11.0.13_doc-all.zip 압축해제 / 즐겨찾기 

3. 실행 원리 
   (1) 작성(.java) -> 컴파일(javac.exe) -> 클래스파일생성(.class) -> 실행(java.exe)
   (2) .java ( for Man) -> .class ( for Com )

4. 실행되는 클래스 
    public static void main(String args[]){}

	ex) day01/A.java 

5. 클래스 구조 
   (1) 패키지 선언 
   (2) 임포트 구문 
   (3) 클래스 선언 {
		(4) 멤버변수 
		(5) 생성자(Constructor)
		(6) 메소드(Method) 
    }

	ex) day02/A.java, AUser.java 

6. 패키지 컴파일 / 실행 
   > javac -d . *.java 
   > java AUser 
   > java aa.bb.AUser //AUser.java 에 패키지가 선언된 경우

7. 주석 ( Comment )
   (1) 1라인 //
   (2) N라인 
       /*
	      라인1
		  라인2 .... 
	   */
   (3) 문서화주석 
       /**
	      라인1
		  라인2 .... 
	   */

	ex) day02/B.java 

8. 객체지향( OOP: Object Oriented Programming ) 용어   
	(1) 클래스 ( Class ) : '객체'를 만드는 틀
	    ex) 붕어빵틀 

	(2) 객체 ( Object ) : 클래스를 통해 나온 구현물, 모든 것 
        ex) 붕어빵 

	(3) 생성자 ( Constructor ) : '객체'가 생성될 때 하는 일(행위)
	   
	(4) 메소드 ( Method ) : '객체'가 할 수 있는 일(행위)

	(5) 속성 ( Attribute == Member == Field ) : '객체'의 특성 
	    ( 다양한 객체를 표현하기 위해서 존재 )  
	    ex) 앙꼬, 가격  

		ex) day02/D.java 

9. 클래스 설계 
/*
    일상의 어떤 현상을 상상해서.. 
    클래스 설계를 하고, 객체를 생성하여 표현(메소드/속성)하시오
	
*/
    //점심식사 후에 발표! 

   ex) day03/빵어빵.java 

10. 변수( Variable )
	(1) 유효범위 
		1) 멤버(==전역) 
			<1> 클래스(소속) 
			<2> 객체(소속) ( == 인스턴스 ) 
		2) 지역 
			<1> 파라미터(==매개==아규먼트)
			<2> 선언초기화 

		ex) day04/A.java, B.java
		   

	(2) 메모리 
		1) 기본형(primitive==원시데이터) : 8가지 
			<1> call by value 
			<2> 형태 : 모두 소문자 
			<3> 종류 
			    byte ▶ short ▶ int ▶ long ▶ float ▶ double 
                        char ▶

				boolean 
		    <4> 담을 수 있는 값의 범위
			    1> byte(1) : -2^7 ~ 2^7-1 (경우의수: 2^8)
				2> short(2) : -2^15 ~ 2^15-1(경우의수: 2^16)
				3> char(2) : 0 ~ 2^16-1 (경우의수: 2^16)
				4> int(4) : -2^31 ~ 2^31-1 (경우의수: 2^32)
				5> long(8) : -2^63 ~ 2^63-1 (경우의수: 2^64)
				6> float(4) : 무한대 (경우의수: 2^32)
				7> double(8) : 무한대 (경우의수: 2^64) 
				8> boolean(1) : false / true 

				ex) day04/C.java, D.java,  

		    <5> 형변환( Type Casting )
				1> 자동형변환(암시적/Implicit) by JVM
				   - 범위 작은 Type -> 큰 Type 

				2> 강제형변환(명시적/Explicit) by 개발자 
				   - 범위 큰 Type -> 작은 Type 
				 
				ex) day04/E.java

			<6> 예외 형변환 
			   정수형(byte, short, char, int)끼리의 연산의 결과는 int 

			    ex) day04/E.java

			<7> 컴퓨터 소수 연산 오차 
			   float 오차가 double 보다 큼 

			<8> 디폴트 초기값 by JVM
			   정수(0, 0L), 실수(0.0f, 0.0), 불린(false)
			    ex) day04/F.java

		    <9> 존재이유 
			   실행의 효율성 

			   cf) Wrapper class 
			   Byte, Short, Character, Integer, Long, Float, Double, Boolean 
			   
		2) 참조형(reference==레퍼런스) : 무한대
			<1> call by reference  
			<2> 형태: (관례상)첫문자 대문자 
			<3> 디폴트초기값: null
            <4> 형변환
			      //나중에... 

			ex) day04/G.java

	(3) 소유 
		1) 클래스(==정적)
			static 붙으면 클래스 소유 
		2) 객체(==동적)
		    static 붙지 않으면 객체 소유

           ex) day04/A.java 

	(4) final 
		1) 상수( Constant )
		    final 붙으면 '초기'값을 못 바꿈 

		2) 변수( Variable ) 

		    ex) day04/H.java 
	
11. 제어
    어떤 프로그램이 실행되고 있을 때.. 
	어느 한 시점의 (CPU/GPU)연산은 어떤 특정 코드부분을 실행하고 있을 것이다
	그 코드 부분을 '제어점'이라고 하고, 그 제어점들의 집합을 '제어'라 한다
	즉, "프로그램의 실행 흐름(line)"

	JVM  -> main() -> ..... main() -> JVM

	cf) 비유: '부메랑'

	ex) day05/A.java 

12. 제어문 
    (1) 조건문 
		1) if(boolean형){}
		2) if(boolean형){}.. else if(boolean형){} .. else{}
		3) switch(정수형){ case: .... default: } 문 
		   => 정수형+String, break, default위치X, case안에 블럭을 생략가능

		   ex) day05/B.java, C.java //점심식사전까지 1번씩 타이핑

	(2) 반복문 
	    초기식(밖), 조건식(안), 증감식(안)을 갖추어야 '유한루프'가 됨 

		1) while(boolean형){} //신사 

		2) do{} while(boolean형); //조폭 

		3) for (초기식; 조건식; 증감식){} //신사 
		   ex) day06/A.java, B.java, C.java 

13. 제어(이동) 예약어 
	(1) break
	    1) switch블럭 or loop안에만 나올 수 있음 
        2) 자신을 둘러싼 첫번째 블럭을 '나간다'
		3) labled break

	    ex) day07/A.java

	(2) continue
		1) loop안에만 나올 수 있음 
		2) (조건에 맞으면)'건너뛴다'
		3) labled continue

        ex) day07/B.java

	(3) return 
		1) 생성자나 메소드 안에서는 어디서나 나올 수 있음 
		2) 호출한 곳 or 놈으로 '되돌린다'  

	    ex) day07/C.java, D.java 


14. 연산자( Operator )			
	(1) (데이터들을) 연산하게 하는 '기호'

	(2) 종류 
	     1) 산술 ex) +, -, *, /, %
		 2) 증감 ex) ++, -- 
		 3) 대입 ex) = 
		 4) 산술대입 ex) +=, -=, *=, /=, %=
		 5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
		 6) 비교 ex) ==, !=, <, <=, >, >=
		 7) 논리 ex) &, &&, |, ||
		 8) 논리대입 ex) &=, |=
		 9) 조건 ex) A? B:C
		 10) instanceof  ex) 객체 instanceof 클래스

		 ex) day07/E.java 

15. 배열(Array) ( 비유: 냉장고 )
	같은 타입의 데이터 '저장소'로써, 생성될 때 그 크기가 고정되는 '객체'

	(1) 선언 
	     type 배열변수[];
		 ( 예: int is[]; String strs[]; .. )
	     
	(2) 생성
		 배열변수 = new type[크기];
		 ( 예: is = new int[4];  strs = new String[4]; .. )

	(3) 초기화
	     배열변수[인덱스] = 데이터;
	     ( 예: is[0]=10; strs[0]="봄"; .. )

	(4) 선언 및 생성
	    type 배열변수[] = new type[크기];
		( 예: int is[]=new int[4]; String strs[]=new String[4]; .. ) 

	(5) 선언 및 생성 및 초기화
	    type 배열변수[] = {데이터1, 데이터2, 데이터3, .. };
		( 예: int is[]={10, 20, 30, 40}; String strs[]={"봄", "여름"}; .. )

		ex) day08/A.java

    (6) 분리 주의 사항 
	    '선언'과 '생성 및 초기화'는 분리될 수 없음
		
		ex) day08/B.java

	(7) 배열방의 default 값 ( by JVM )
		byte, short, char, int : 0
		long : 0L
		float : 0.0f
		double : 0.0
		boolean : false
		참조형 : null

		ex) day08/C.java

	(8) 형변환 
	    자동형변환이 가능한 데이터라면 변환되어져서 저장됨
	    ( 예: int is[] = {b, s, c, i, (int)f}; )

		ex) day08/D.java

	(9) length 속성 
		배열방의 크기를 리턴 

		ex) day08/E.java 

	(10) 2차원 
		1차원 배열을 데이터(element)로 갖는 배열 

	    ex) day08/F.java 	
		
	(11) n차원 
		(n-1)차원 배열을 데이터(element)로 갖는 배열 

		ex) day08/G.java


16. 컬렉션( Collection ) 계열  ( Data Structure , 가변배열 )
	같은 타입의 '참조형'데이터 '저장소'로써 그 크기가 변하는 '객체'
