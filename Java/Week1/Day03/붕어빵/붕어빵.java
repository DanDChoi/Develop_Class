class �ؾ {
	String �Ӳ�;
	�ؾ(){
		�Ӳ� = "��";
	}
	�ؾ(String �Ӳ�){
		this.�Ӳ� = �Ӳ�;
	}
	void ��θ����Ѵ�(){
		System.out.println("��θ����Ѵ�");
	}
}
class ���� {
	int ����;
	�ؾ ��1, ��2;
	����(){
		���� = 50;
	}
	����(int ����){
		this.���� = ����;
	}
    void �����(){
		��1 = new �ؾ("����");
		��2 = new �ؾ("����");
		System.out.println("�ؾ�� ����� �ִ�");
	}
	void �Ǵ�(){
		System.out.println("�Ӳ��� " + ��1.�Ӳ� + "�� �ؾ�� �Ǵ�");
		System.out.println("�Ӳ��� " + ��2.�Ӳ� + "�� �ؾ�� �Ǵ�");
	}
}
class �մ� {
	int ��;
	int ����;
	�մ�(int ����, int ��){
		this.���� = ����;
		this.�� = ��;
	}
	void ���(){
		System.out.println("�մ��� ���");
	}
	void �Դ´�(){
		System.out.println("�մ��� �Դ´�");
	}
}
class �� {
	public static void main(String args[]){
		���� ���� = new ����(45);
		System.out.print("���̰� "+����.����+"���� ������� ");
		����.�����();
		����.�Ǵ�();
		System.out.print("�� ���� �մԵ��� ");
		����.��1.��θ����Ѵ�();
		System.out.println("�ι�° ����� �Ӳ��� "+ ����.��2.�Ӳ� + "�̴�");

		�մ� �� = new �մ�(8, 1000);
		System.out.print("���̰� "+��.����+"���̰�, ���� "+��.��+"���� ���� ");
		��.���();
	}
}

