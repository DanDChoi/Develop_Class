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
			pln("stmt ���� �ܰ���� ����");
		}catch(ClassNotFoundException cnfe){
			pln("����̹��ε� ����(Ŭ������ �� ã��)");
		}catch(SQLException se){
            pln("Oracle�� ���� ���� or stmt ���� ����");
		}

		//createT();
        //createTnoExist(); //���߿�.. �̼�!
		//dropT();

		//insertD(10, "ȫ�浿");
		//insertD(20, "�̼���");
		//insertD(30, "������");

		//updateD(20, "�ź�ö");

		deleteD(10); // ���� �ð� �����鼭.. ���� �õ��غ�����
	}

    //DDL 
	String tname = "JDBCT";
    void createT(){
		String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar(10), RDATE date)";
		try{
			stmt.execute(sql);
			pln(tname+"���̺� ���� ����");
		}catch(SQLException se){
            pln(tname+"���̺� ���� ����: " + se);
		}
	}
	void dropT(){
		String sql = "drop table "+tname;
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln(tname+"���̺� ��� ����");
		}catch(SQLException se){
            pln(tname+"���̺� ��� ����: " + se);
		}
	}

    //DML
	void insertD(int no, String name){
		String sql = "insert into "+tname+" values("+no+", '"+name+"', SYSDATE)";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"���� row �Է� ����");
			}else{
			    pln("�Էµ��� ����");
			}
		}catch(SQLException se){
			pln("�Է� ����: " + se);
		}
	}
	void updateD(int no, String name){
		String sql = "update "+tname+" set name='"+name+"' where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0){
				pln(i+"���� row ���� ����");
			}else{
			    pln("�������� ����");
			}
		}catch(SQLException se){
			pln("���� ����: " + se);
		}
	}
	void deleteD(int no){ //����!!

	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		B b = new B();
	}
}
