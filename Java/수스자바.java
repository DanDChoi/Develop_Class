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
	�� �ڵ� �κ��� '������'�̶�� �ϰ�, �� ���������� ������ '����'��� �Ѵ�
	��, "���α׷��� ���� �帧(line)"

	JVM -> main() ..... main() -> JVM

	cf ���� : '�θ޶�'

	ex) Day05/A.java

12. ���
	(1) ���ǹ�
		1)if(boolean��){}
		2)if(boolean��){}.. else if(boolean��){}.. else{}
		3)switch(������){case: .... default: } ��
			=>������+String, break, default��ġX, case�ȿ� ���� ��������

			ex) day05/B.java, C.java //���ɽð����� 1���� Ÿ����

	(2) �ݺ���
		�ʱ��(���� �ۿ�), ���ǽ�(���� �ȿ�), ������(���� �ȿ�)�� ���߾�� '���ѷ���'�� ��
		
		1) while(boolean��){} //�Ż�
			//ex) Day06/A.java

		2) for (�ʱ��; ���ǽ�; ������){} //�Ż� (while�� 100%ȣȯ����)
			//ex) Day06/A.java, B.java
		
		3) do{} while(boolean��); //����
			//ex) Day06/A.java

		