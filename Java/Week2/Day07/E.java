class E 
{
	/*
	1) ��� ex) +, -, *, /, %
	2) ���� ex) ++, -- 
	3) ���� ex) = 
	4) ������� ex) +=, -=, *=, /=, %=
	5) ��Ʈ ex) &, |, ^, ~, ����Ʈ(<<, >>, >>>)
	6) �� ex) ==, !=, <, <=, >, >=
	7) �� ex) &, &&, |, ||
	8) ������ ex) &=, |=
	9) ���� ex) A? B:C
	10) instanceof  ex) ��ü instanceof Ŭ���� */

	void m1(){ //1) ��� ex) +, -, *, /, %
		int i = 1;
		int j = 2;
		int k = i%j;
        pln("k: " + k);
	}
	void m2(){ //2) ���� ex) ++, --
		int i = 0;
		int j = i++;//�����ڿ켱���� 
		pln("i: " + i + ", j: " + j);

		int k = (j++ + 1);
		pln("j: " + j + ", k: " + k);
	}
	void m3(){ //4) ������� ex) +=, -=, *=, /=, %=
		int i = 1;
		i %= 2;
		pln("i: " + i);
	}
	void m4(){ //5) ��Ʈ ex) &, |, ^, ~, ����Ʈ(<<, >>, >>>)
		int i = 8;
        i = i>>2;
		System.out.println("i: " + i);

		int j = 4;  //0100
		int k = 12; //1100
		int m = j&k;
        System.out.println("m: " + m);
	}
	void m5(){ //6) �� ex) ==, !=, <, <=, >, >=
		int i = 0;
		//boolean flag = i!=0;
		boolean flag = i>(i-1);
		System.out.println("flag: " + flag);
	}
	void m6(){ //7) �� ex) &, &&, |, ||
		int i = 0;
		int j = 2;
		boolean flag = (++i==1) | (i==j--); 
		System.out.println("j: " + j);
	}
	void m7(){ //8) ������ ex) &=, |=
		boolean b = false;
		b |= true;	
		System.out.println("b : " + b); 
	}
	void m8(){ //9) ���� ex) A? B:C
		int i = 1;
		int j = 2;
		String k = i>j? "����": "����";
		/*String k = "";
		if(i>j) {
			k = "����";
		}else {
			k = "����";
		}*/
		System.out.println("k: " +k);
	}
	void m9(){ //10) instanceof  ex) ��ü instanceof Ŭ����
        String str = "��ġ";
		boolean flag1 = str instanceof Object;
		System.out.println("flag1: " + flag1);

		Object obj = new Object();
		boolean flag2 = obj instanceof String;
		System.out.println("flag2: " + flag2);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		E e = new E();
		//e.m1();
		//e.m2();
		//e.m3();
		//e.m4();
		//e.m5();
		//e.m6();
		//e.m7();
		//e.m8();
		e.m9();
	}
}
