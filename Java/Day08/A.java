class A {

	/*
	int is[]; //(1)����
	A(){
		is = new int[4]; //(2)����
	}
	*/

	/*
	int is[] = new int[4]; //���� �� ����

	void in(){
		is[0] = 10; //(3)�ʱ�ȭ
		is[1] = 20;
		is[2] = 30;
		is[3] = 40;
	}
	*/
	int is[] = {10, 20, 30, 40}; // ����, ���� �� �ʱ�ȭ

	void out(){ //(4)���
		for (int i=0; i<4; i++){
		System.out.println("is["+i+"]: "+is[i]);
		}
	}
	public static void main(String[] args) 
	{
		A a = new A();
		a.in();
		a.out();
	}
}
