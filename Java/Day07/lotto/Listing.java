import java.io.*;
import java.util.*;

class Listing 
{
	String fName = "�츮��";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader brFile;
	Random r = new Random();
	String name;

	void inputFName(){
		FileReader fr = null;
		p("#���� ���� �̸�: ");
		try{
			fName = br.readLine();
			if(fName != null) fName = fName.trim();
			fr = new FileReader(fName+".txt");
			brFile = new BufferedReader(fr);
		}catch(FileNotFoundException fe){
			System.out.println(fName+"������ ã�� �� ����");
			inputFName();
		}catch(IOException ie){
		}
	}
	void list(){
		try{
			int i = r.nextInt(30); 
			for (int j=1; j<=30; j++){
				String name = brFile.readLine();
				if(i==j) break;
			}
			pln("��÷��: " + name);
		}catch(IOException ie){
		}
	}
    void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Listing li = new Listing();
		li.inputFName();
		li.list();
	}
}
