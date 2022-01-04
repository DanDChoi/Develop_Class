import java.sql.*;

class B 
{
	String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
	Connection con;
	Statement stmt;
	B(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement();
			pln("stmt 생성 단계까지 성공");
		}catch(ClassNotFoundException cnfe){
			pln("드라이버로딩 실패(클래스를 못 찾음)");
		}catch(SQLException se){
            pln("Oracle과 연결 실패 or stmt 생성 실패");
		}

		//createT();
        //createTnoExist(); //나중에.. 미션!
		//dropT();

		//insertD(10, "홍길동");
		//insertD(20, "이순신");
		//insertD(30, "강감찬");

		//updateD(20, "신병철");

		deleteD(10); // 쉬는 시간 갖으면서.. 각자 시도해보세요
	}

    //DDL 
	String tname = "JDBCT";
    void createT(){
		String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar(10), RDATE date)";
		try{
			stmt.execute(sql);
			pln(tname+"테이블 생성 성공");
		}catch(SQLException se){
            pln(tname+"테이블 생성 실패: " + se);
		}
	}
	void dropT(){
		String sql = "drop table "+tname;
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln(tname+"테이블 드랍 성공");
		}catch(SQLException se){
            pln(tname+"테이블 드랍 실패: " + se);
		}
	}

    //DML
	void insertD(int no, String name){
		String sql = "insert into "+tname+" values("+no+", '"+name+"', SYSDATE)";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"개의 row 입력 성공");
			}else{
			    pln("입력되지 않음");
			}
		}catch(SQLException se){
			pln("입력 실패: " + se);
		}
	}
	void updateD(int no, String name){
		String sql = "update "+tname+" set name='"+name+"' where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"개의 row 수정 성공");
			}else{
			    pln("수정되지 않음");
			}
		}catch(SQLException se){
			pln("수정 실패: " + se);
		}
	}
	void deleteD(int no){ //구현!!

	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		B b = new B();
	}
}
