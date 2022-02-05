package join.mvc.model;

import static login.mvc.model.LoginConst.NO_ID;
import static login.mvc.model.LoginConst.NO_PWD;
import static login.mvc.model.LoginConst.YES_ID_PWD;

import mvc.domain.Member;

public class JoinService {
	private JoinDAO dao;
	
	private static final JoinService instance = new JoinService();
	private JoinService() {
		dao = new JoinDAO();
	}
	public static JoinService getInstance() {
		return instance;
	}
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd("");
		
		return m;
	}
	
	public int check(String email, String phone) {
		Member m = dao.getMember(email);
		if(m == null) {
			return NO_ID; //�׷� email�� ���� ȸ���� ����
		}else {
			String dbPwd = m.getPwd();
			if(dbPwd != null) dbPwd = dbPwd.trim();
			
			if(!dbPwd.equals(phone)) {
				return NO_PWD; //email�� ���������� ��й�ȣ�� �ٸ����
			}else {
				return YES_ID_PWD; //email �� pwd�� ����
			}
		}
	}
}