class C 
{
	/*void m0(){
		for(int i=4; i>=0; i--)
			System.out.println("i: "+i);
	}
	void m00(){
		System.out.println("2^31-1: "+ Integer.MAX_VALUE);
		System.out.println("-2^31: "+ Integer.MIN_VALUE);
	}*/
	void m1(){ //1~10 ���� ����Ͻÿ�
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum = sum + i;
		}
		System.out.println("sum: "+ sum);
	}

	void m2(){ //1~100 ¦���հ� Ȧ������ ����Ͻÿ�
		int sum = 0;
		for (int i=0; i<=100; i+=2){
			sum = sum + i;
		}
		System.out.println("even_sum: "+sum);
	
		int sum1 = 0;
		for (int i=1; i<=100; i+=2){
			sum1 = sum1 + i;
		}
		System.out.println("odd_sum: "+sum1);
	}

	/*void �ΰ���ڵ�(){ // ¦���հ� Ȧ���� ��
		for (int i=1; i<101; i++){
        if(i % 2 == 0){
            evensum +=i;
         }else {
            oddsum +=i;
         }
      }System.out.println("¦���� ���� "+ evensum + " �̰�, Ȧ���� ���� "+ oddsum + "�̴�");
   }*/

	public static void main(String[] args) 
	{
		C c = new C();
		//c.m0();
		//c.m00();
		c.m1();
		c.m2();

	}
}
