import java.util.*;

class A3
{
	Vector<String> v = new Vector<String>(); //Generic
	
	void in(){
		v.add("��");v.add("����");v.add("����");v.add("�ܿ�");v.add("����");
	}
	void out(){
		for(String str: v) pln("str: " + str); //Enhanced Loop
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		A3 a = new A3();
		a.in();
		a.out();
	}
}