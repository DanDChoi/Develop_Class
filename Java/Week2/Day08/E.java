class E {

	String strs[] = {"��", "����", "����", "�ܿ�", "1", "2"};
	void out(){
		for (int i=0; i<strs.length; i++){
			System.out.println("strs["+i+"]: "+strs[i]);
		}
	}
	public static void main(String[] args) 
	{
		new E().out();
	}
}
