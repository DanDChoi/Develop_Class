package login.mvc.model;

import mvc.domain.Member;
import static login.mvc.model.LoginConst.*;

public class LoginService {
	private LoginDAO dao;
	
	private static final LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd("");
		
		return m;
	}
	
	public int check(String email, String pwd) {
		Member m = dao.getMember(email);
		if(m == null) {
			return NO_ID; //�׷� email�� ���� ȸ���� ����
		}else {
			String dbPwd = m.getPwd();
			if(dbPwd != null) dbPwd = dbPwd.trim();
			
			if(!dbPwd.equals(pwd)) {
				return NO_PWD; //email�� ���������� ��й�ȣ�� �ٸ����
			}else {
				return YES_ID_PWD; //email �� pwd�� ����
			}
		}
	}
}