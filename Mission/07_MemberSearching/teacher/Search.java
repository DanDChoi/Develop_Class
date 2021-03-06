import java.io.*;
import java.util.*;

class Search {
	String fName = "우리반.txt";
	TreeSet<String> ts = new TreeSet<String>();

	void verifyF(){
		File f = new File(fName);
		if(f.exists()){
			//pln("파일("+fName+") 존재O");
			if(f.isDirectory()){
				//pln("디렉토리");
			}else{
				//pln("파일");
				readF(f);
			}
		}else{
			//pln("파일("+fName+") 존재X");
		}
	}
	void readF(File f){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null){
				line = line.trim();
				if(line.length() != 0){
					ts.add(line);
				}
			}

			//showResult();
			while(true) searchName();
		}catch(IOException ie){
		}
	}
	void showResult(){
		for(String name: ts) pln(name);
	}
	void searchName(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p("검색할 이름: ");
		try{
			String sName = br.readLine();
			sName = sName.trim();
			if(sName.equals("list")){
				showResult();
			}else if(sName.equals("exit")){
				System.exit(0);
			}else{
				for(String name: ts){
					if(name.equals(sName)){
						pln("존재하는 회원");
						return;
					}
				}
				pln("존재하지않는 회원");
			}
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		Search s = new Search();
		s.verifyF();
	}
}
