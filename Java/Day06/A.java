class A 
{
	void m1(){ //�Ż� (�ʱ�� ���Ŀ� �ٷ� �ٵ�� �����ʰ� ���ǽ��� �� �� ����)
		int i = 0; //�ʱ��
		while(i<5){ //���ǽ�
			i = i + 1; // i+=1; , i++; ������
			System.out.println("i: "+ i);
		}
	}

	void m2(){ //�Ż� 
		for(int i=0; i<5; i++)
			System.out.println("i: "+i);
	}


	void m3(){ //����
		int i = 0; //�ʱ��
		do{
			System.out.println("i: "+i);
			i ++; //������
		}while(i<5);
	}

	
	public static void main(String[] args) 
	{
		A a = new A();
		//a.m1();
		//a.m2();
		a.m3();
	}
}
