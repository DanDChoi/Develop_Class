import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A extends JFrame {
	JButton b;
	void init(){
		b = new JButton("�ڹ��� ��ư");
		/*ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("�̺�Ʈ�߻�!! Ŭ���ϼ̳׿�^^");
			}
		};*/
		ActionListener listener = (e) -> {
			b.setText("���ٽ����� �̺�Ʈ ó����");
		};
		b.addActionListener(listener);
		add(b);

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		A a = new A();
		a.init();
	}
}
