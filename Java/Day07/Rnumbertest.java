import java.io.*;		//������ȣ���� Test �ڵ�
import java.util.*;

class Rnumbertest{
	
	Random r = new Random();

	void m1(){
		int i = r.nextInt(30);
		for(int j=0; j<30; j++){
			if(j==i){
			System.out.println("i: "+i);
			break;
			}
		}
	}

	public static void main(String[] args) 
	{
		Rnumbertest Rl = new Rnumbertest();
		Rl.m1();
	}
}
