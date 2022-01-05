import java.sql.*;

class A 
{
	void init(){
		//(1) ����̹�(driver) �ε� 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pln("(1) ����̹��ε� ����");
		}catch(ClassNotFoundException cnfe){
			pln("(1) ����̹��ε� ����(Ŭ������ �� ã��): " + cnfe);
		}
		//(2) Connection ���� 
		String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, "scott", "tiger");
			pln("(2) Oracle�� ���� ����");
		}catch(SQLException se){
            pln("(2) Oracle�� ���� ����: " + se);
		}
		//(3) Statement ���� 
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			pln("(3) stmt ���� ����");
		}catch(SQLException se){
			pln("(3) stmt ���� ����");
		}

		//(4) SQL �ۼ�/����/����
		pln("(4) SQL�ۼ�/����/����");

		//(5) ���ᰴü�� �ݱ�
		try{
		    stmt.close();
			con.close();
			pln("(5) ���ᰴü�� �ݱ� ����");
		}catch(SQLException se){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new A().init();
	}
}

//set classpath=.;C:\Users\CHOI\Desktop\Dan\Develop\Develop_Class\Java\ojdbc8.jar
//javac A.java
//java A