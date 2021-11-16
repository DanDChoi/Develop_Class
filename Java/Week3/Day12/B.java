class B 
{
	private int i = 20;
	private B(){
		System.out.println("B()");
	}
	private void m(){
		System.out.println("m()");
	}
	public static void main(String[] args) {
		B b = new B();
		System.out.println("b.i: " + b.i);
		b.m(); 
	}
}

class BUser{
	BUser(){
		//B b = new B(); //�Ұ�
		//System.out.println("b.i: " + b.i); //�Ұ�
		//b.m(); //�Ұ�
	}
	public static void main(String[] args) {
		new BUser();
	}
}
