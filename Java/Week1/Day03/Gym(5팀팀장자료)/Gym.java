class Body {
	String part;
	Body(){
		part = "��";
	}
	Body(String part){
		this.part = part;
	}
	void Proud(){
		System.out.println(part + "������ �ڶ������� �Ѵ�");
	}
}

class Trainer {
	String sex;
	Body muscle1,muscle2;
	int age;
	Trainer(){
		sex = "����";
		age = 25;
	}
	Trainer(String sex, int age){
		this.sex = sex;
		this.age = age;
	}
	void Trainning(){
		System.out.println("��� ��Ų��");
	}
	void Care(){
		System.out.println("�Ĵ��� �����Ѵ�");
	}
	void Exercise(){
		muscle1 = new Body("����");
		muscle2 = new Body("���");
		System.out.println("Ʈ���̳ʰ� "+ muscle1.part +"���� ��� �Ѵ�");
	}
}

class Customer {
	String Csex;
	int weight;
	Customer(){
		Csex = "����";
		weight = 40;
	}
	Customer(String Csex, int weight){
		this.Csex = Csex;
		this.weight = weight;
	}
	void Minus(){
		System.out.println("���� ����");
	}
}

class Gym	
{
	public static void main(String[] args) 
	{
		Trainer tra = new Trainer();
		System.out.print("������ " + tra.sex +"�̰� ���̰� " + tra.age + "���� Ʈ���̳ʰ� ");
		tra.Trainning();

		Trainer tra1 = new Trainer("����",28);
		System.out.print("������ " + tra1.sex +"�̰� ���̰� " + tra1.age + "���� Ʈ���̳ʰ� ");
		tra.Care();
		
		Body b = new Body();
		System.out.print("������ " + tra1.sex +"�̰� ���̰� " + tra1.age + "���� Ʈ���̳ʰ� " + b.part + "������ ");
		b.Proud();

		tra.Exercise();

		Customer cus = new Customer();
		System.out.print("������ " + cus.Csex + "�̰� �����԰� " + cus.weight + "kg�� ���� ");
		cus.Minus();
		Customer cus1 = new Customer("����",75);
		System.out.print("������ " + cus1.Csex + "�̰� �����԰� " + cus1.weight + "kg�� ���� ");
		cus.Minus();

		System.out.print("Ʈ���̳ʴ� ");
		tra.muscle1.Proud();

	}
}
