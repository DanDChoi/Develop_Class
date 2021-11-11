1. HW ( OS + JVM + App1, App2, ... )
   (1) CPU, GPU : �γ� 
   (2) RAM(�޸�) : å�� 
   (3) HDD/SSD : å����
   (4) MainBoard : ��
   (5) Card : Sound, Video, Ran, WLRan, .. 
   (6) �ֺ����: Ű����, �����, ���콺, ������, ��ü.. 

2. ȯ�� ���� 
   (1) JDK (file) ��ġ 
	   - jdk ( Java Development Kit )
	   - jre (Java Runtime Environment )
   (2) ȯ�溯�� 
	   - JAVA_HOME => C:\Program Files\Java\jdk-11.0.13 
	   - Path => %C:\Program Files\Java\jdk-11.0.13%\bin
	   - classpath => .
   (3) Editer
       - Editplus 
	   - Eclipse
	   - VSCode
	   - IntelliJ

   (4) API
       - jdk-11.0.13_doc-all.zip �������� / ���ã�� 

3. ���� ���� 
   (1) �ۼ�(.java) -> ������(javac.exe) -> Ŭ�������ϻ���(.class) -> ����(java.exe)
   (2) .java ( for Man) -> .class ( for Com )

4. ����Ǵ� Ŭ���� 
    public static void main(String args[]){}

	ex) day01/A.java 

5. Ŭ���� ���� 
   (1) ��Ű�� ���� 
   (2) ����Ʈ ���� 
   (3) Ŭ���� ���� {
		(4) ������� 
		(5) ������(Constructor)
		(6) �޼ҵ�(Method) 
    }

	ex) day02/A.java, AUser.java 

6. ��Ű�� ������ / ���� 
   > javac -d . *.java 
   > java AUser 
   > java aa.bb.AUser //AUser.java �� ��Ű���� ����� ���

7. �ּ� ( Comment )
   (1) 1���� //
   (2) N���� 
       /*
	      ����1
		  ����2 .... 
	   */
   (3) ����ȭ�ּ� 
       /**
	      ����1
		  ����2 .... 
	   */

	ex) day02/B.java 

8. ��ü����( OOP: Object Oriented Programming ) ���   
	(1) Ŭ���� ( Class ) : '��ü'�� ����� Ʋ
	    ex) �ؾƲ 

	(2) ��ü ( Object ) : Ŭ������ ���� ���� ������, ��� �� 
        ex) �ؾ 

	(3) ������ ( Constructor ) : '��ü'�� ������ �� �ϴ� ��(����)
	   
	(4) �޼ҵ� ( Method ) : '��ü'�� �� �� �ִ� ��(����)

	(5) �Ӽ� ( Attribute == Member == Field ) : '��ü'�� Ư�� 
	    ( �پ��� ��ü�� ǥ���ϱ� ���ؼ� ���� )  
	    ex) �Ӳ�, ����  

		ex) day02/D.java 

9. Ŭ���� ���� 
/*
    �ϻ��� � ������ ����ؼ�.. 
    Ŭ���� ���踦 �ϰ�, ��ü�� �����Ͽ� ǥ��(�޼ҵ�/�Ӽ�)�Ͻÿ�
	
*/
    //���ɽĻ� �Ŀ� ��ǥ! 

   ex) day03/���.java 

10. ����( Variable )
	(1) ��ȿ���� 
		1) ���(==����) 
			<1> Ŭ����(�Ҽ�) 
			<2> ��ü(�Ҽ�) ( == �ν��Ͻ� ) 
		2) ���� 
			<1> �Ķ����(==�Ű�==�ƱԸ�Ʈ)
			<2> �����ʱ�ȭ 

		ex) day04/A.java, B.java
		   

	(2) �޸� 
		1) �⺻��(primitive==���õ�����) : 8���� 
			<1> call by value 
			<2> ���� : ��� �ҹ��� 
			<3> ���� 
			    byte �� short �� int �� long �� float �� double 
                        char ��

				boolean 
		    <4> ���� �� �ִ� ���� ����
			    1> byte(1) : -2^7 ~ 2^7-1 (����Ǽ�: 2^8)
				2> short(2) : -2^15 ~ 2^15-1(����Ǽ�: 2^16)
				3> char(2) : 0 ~ 2^16-1 (����Ǽ�: 2^16)
				4> int(4) : -2^31 ~ 2^31-1 (����Ǽ�: 2^32)
				5> long(8) : -2^63 ~ 2^63-1 (����Ǽ�: 2^64)
				6> float(4) : ���Ѵ� (����Ǽ�: 2^32)
				7> double(8) : ���Ѵ� (����Ǽ�: 2^64) 
				8> boolean(1) : false / true 

				ex) day04/C.java, D.java,  

		    <5> ����ȯ( Type Casting )
				1> �ڵ�����ȯ(�Ͻ���/Implicit) by JVM
				   - ���� ���� Type -> ū Type 

				2> ��������ȯ(�����/Explicit) by ������ 
				   - ���� ū Type -> ���� Type 
				 
				ex) day04/E.java

			<6> ���� ����ȯ 
			   ������(byte, short, char, int)������ ������ ����� int 

			    ex) day04/E.java

			<7> ��ǻ�� �Ҽ� ���� ���� 
			   float ������ double ���� ŭ 

			<8> ����Ʈ �ʱⰪ by JVM
			   ����(0, 0L), �Ǽ�(0.0f, 0.0), �Ҹ�(false)
			    ex) day04/F.java

		    <9> �������� 
			   ������ ȿ���� 

			   cf) Wrapper class 
			   Byte, Short, Character, Integer, Long, Float, Double, Boolean 
			   
		2) ������(reference==���۷���) : ���Ѵ�
			<1> call by reference  
			<2> ����: (���ʻ�)ù���� �빮�� 
			<3> ����Ʈ�ʱⰪ: null
            <4> ����ȯ
			      //���߿�... 

			ex) day04/G.java

	(3) ���� 
		1) Ŭ����(==����)
			static ������ Ŭ���� ���� 
		2) ��ü(==����)
		    static ���� ������ ��ü ����

           ex) day04/A.java 

	(4) final 
		1) ���( Constant )
		    final ������ '�ʱ�'���� �� �ٲ� 

		2) ����( Variable ) 

		    ex) day04/H.java 
	
11. ����
    � ���α׷��� ����ǰ� ���� ��.. 
	��� �� ������ (CPU/GPU)������ � Ư�� �ڵ�κ��� �����ϰ� ���� ���̴�
	�� �ڵ� �κ��� '������'�̶�� �ϰ�, �� ���������� ������ '����'�� �Ѵ�
	��, "���α׷��� ���� �帧(line)"

	JVM  -> main() -> ..... main() -> JVM

	cf) ����: '�θ޶�'

	ex) day05/A.java 

12. ��� 
    (1) ���ǹ� 
		1) if(boolean��){}
		2) if(boolean��){}.. else if(boolean��){} .. else{}
		3) switch(������){ case: .... default: } �� 
		   => ������+String, break, default��ġX, case�ȿ� ���� ��������

		   ex) day05/B.java, C.java //���ɽĻ������� 1���� Ÿ����

	(2) �ݺ��� 
	    �ʱ��(��), ���ǽ�(��), ������(��)�� ���߾�� '���ѷ���'�� �� 

		1) while(boolean��){} //�Ż� 

		2) do{} while(boolean��); //���� 

		3) for (�ʱ��; ���ǽ�; ������){} //�Ż� 
		   ex) day06/A.java, B.java, C.java 

13. ����(�̵�) ����� 
	(1) break
	    1) switch�� or loop�ȿ��� ���� �� ���� 
        2) �ڽ��� �ѷ��� ù��° ���� '������'
		3) labled break

	    ex) day07/A.java

	(2) continue
		1) loop�ȿ��� ���� �� ���� 
		2) (���ǿ� ������)'�ǳʶڴ�'
		3) labled continue

        ex) day07/B.java

	(3) return 
		1) �����ڳ� �޼ҵ� �ȿ����� ��𼭳� ���� �� ���� 
		2) ȣ���� �� or ������ '�ǵ�����'  

	    ex) day07/C.java, D.java 


14. ������( Operator )			
	(1) (�����͵���) �����ϰ� �ϴ� '��ȣ'

	(2) ���� 
	     1) ��� ex) +, -, *, /, %
		 2) ���� ex) ++, -- 
		 3) ���� ex) = 
		 4) ������� ex) +=, -=, *=, /=, %=
		 5) ��Ʈ ex) &, |, ^, ~, ����Ʈ(<<, >>, >>>)
		 6) �� ex) ==, !=, <, <=, >, >=
		 7) �� ex) &, &&, |, ||
		 8) ������ ex) &=, |=
		 9) ���� ex) A? B:C
		 10) instanceof  ex) ��ü instanceof Ŭ����

		 ex) day07/E.java 

15. �迭(Array) ( ����: ����� )
	���� Ÿ���� ������ '�����'�ν�, ������ �� �� ũ�Ⱑ �����Ǵ� '��ü'

	(1) ���� 
	     type �迭����[];
		 ( ��: int is[]; String strs[]; .. )
	     
	(2) ����
		 �迭���� = new type[ũ��];
		 ( ��: is = new int[4];  strs = new String[4]; .. )

	(3) �ʱ�ȭ
	     �迭����[�ε���] = ������;
	     ( ��: is[0]=10; strs[0]="��"; .. )

	(4) ���� �� ����
	    type �迭����[] = new type[ũ��];
		( ��: int is[]=new int[4]; String strs[]=new String[4]; .. ) 

	(5) ���� �� ���� �� �ʱ�ȭ
	    type �迭����[] = {������1, ������2, ������3, .. };
		( ��: int is[]={10, 20, 30, 40}; String strs[]={"��", "����"}; .. )

		ex) day08/A.java

    (6) �и� ���� ���� 
	    '����'�� '���� �� �ʱ�ȭ'�� �и��� �� ����
		
		ex) day08/B.java

	(7) �迭���� default �� ( by JVM )
		byte, short, char, int : 0
		long : 0L
		float : 0.0f
		double : 0.0
		boolean : false
		������ : null

		ex) day08/C.java

	(8) ����ȯ 
	    �ڵ�����ȯ�� ������ �����Ͷ�� ��ȯ�Ǿ����� �����
	    ( ��: int is[] = {b, s, c, i, (int)f}; )

		ex) day08/D.java

	(9) length �Ӽ� 
		�迭���� ũ�⸦ ���� 

		ex) day08/E.java 

	(10) 2���� 
		1���� �迭�� ������(element)�� ���� �迭 

	    ex) day08/F.java 	
		
	(11) n���� 
		(n-1)���� �迭�� ������(element)�� ���� �迭 

		ex) day08/G.java


16. �÷���( Collection ) �迭  ( Data Structure , �����迭 )
	���� Ÿ���� '������'������ '�����'�ν� �� ũ�Ⱑ ���ϴ� '��ü'
