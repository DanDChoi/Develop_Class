import java.io.*;

class OneTo100 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void input(){
		try{
			String line = br.readLine();
			int i = Integer.parseInt(line);
			if(i<0){
				System.out.println("������ ������ �� �� ����");
				input();
			}else if(i>100){
				System.out.println("������ 100�� ���� �� ����");
				input();
			}else{
				System.out.println("�������� ���� i : " +i);
			}
		}catch(Exception e){}
	}
	public static void main(String[] args) 
	{
		new OneTo100().input();
	}
}
