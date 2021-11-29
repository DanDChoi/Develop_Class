import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
class B extends JFrame {
	Container cp;
	JButton bE, bW, bS, bN, bC;
	JPanel pN;
	JButton bWpN;
	JButton bEpN;
	JPanel pC;
	JButton bCpC;

	void init(){
		pN = new JPanel();
		pN.setLayout(new BorderLayout());
		bWpN = new JButton("����at���г�");
		bEpN = new JButton("����at���г�");
		pN.add(bWpN, BorderLayout.WEST);
		pN.add(bEpN, BorderLayout.EAST);

		pC = new JPanel();
		pC.setLayout(new BorderLayout());
		bCpC = new JButton("�Է�â");
		pC.add(bCpC, BorderLayout.SOUTH);

		bE = new JButton("����");
		bW = new JButton("����");
		bS = new JButton("����");
		bN = new JButton("����");
		pN.add(bN);
		bC = new JButton("�����â");
		pC.add(bC);

		cp = getContentPane();
		cp.add(bE, BorderLayout.EAST);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bS, BorderLayout.SOUTH);
		//cp.add(bN, BorderLayout.NORTH);
		cp.add(pN, BorderLayout.NORTH);
		//cp.add(bC, BorderLayout.CENTER);
		cp.add(pC, BorderLayout.CENTER);

		setUI();
	}
	void setUI(){
		setTitle("BorderLayout Test");
		setSize(400, 300);
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		B b = new B();
		b.init();
	}
}
