class C 
{
	void m1(){
		int i = 20;
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: 
				System.out.println("20-1");  
				System.out.println("20-2"); 
				break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10 or 20 or 30�� �ƴϴ�");
		}
		System.out.println("switch��");
	}
	void m2(){
	    String str = "����";
		switch(str){
			case "����": System.out.println("��ö"); break;
		    case "����": System.out.println("����"); break;
			case "������": System.out.println("��ȯ"); break;
		}
	}
	void m3(){
		int i = 10;
		char c = 'B';
		switch(i){
			case 10: 
				System.out.println("10"); 
			    switch(c){
					case 'A': System.out.println("A"); break;
					default : System.out.println("A�� �ƴ�");
				}
				System.out.println("�� switch�� ����");
				break;
			case 20: System.out.println("30"); break;
			default: System.out.println("10 or 20�ƴϴ�");
		}
		System.out.println("�� switch�� ����");
	}
	void m4(){
		int i = 10;
		char c = 'B';
        if(i == 10){
			System.out.println("10"); 
			if(c == 'A'){
				System.out.println("A");
			}else{
				System.out.println("A�� �ƴ�");
			}
		}else if(i == 20){
			System.out.println("30"); 
		}else{
			System.out.println("10 or 20�ƴϴ�");
		}
	}
	public static void main(String[] args) 
	{
		C c = new C();
		//c.m1();
		//c.m2();
		//c.m3();
		c.m4();
	}
}
