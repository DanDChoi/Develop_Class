class D 
{
	int a = 5;
	int b = 2;
		 
	void m1(){
		int i = a/b; //��
		int j = a%b; //������
		System.out.println("i : " + i  + ", j: " + j);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
	}
}
