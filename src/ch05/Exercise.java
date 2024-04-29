package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;

	// 생성자
	public Exercise() {

		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("패널추가 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		panel1 = new JPanel();
		panel2 = new JPanel();

		panel1.setBackground(Color.gray);
		panel2.setBackground(Color.LIGHT_GRAY);

		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");

	}

	private void setInitLayout() {

		add(panel1, BorderLayout.CENTER);

		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.setLayout(new FlowLayout());
		panel2.add(button2);
		panel2.setLayout(new FlowLayout());
		panel2.add(button3);
		panel2.setLayout(new FlowLayout());

		setVisible(true);
	}

	private void addEventListener() {

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton seletedButton = (JButton) e.getSource();
		if (seletedButton == this.button1) {
			System.out.println("button1 객체가 눌러졌다 ! 라고 판명가능");
			panel1.setBackground(Color.PINK);
		}
		if (seletedButton == this.button2) {
			System.out.println("button2 객체가 눌러졌다 ! 라고 판명가능");
			panel1.setBackground(Color.black);
		}
		if (seletedButton == this.button3) {
			System.out.println("button3 객체가 눌러졌다 ! 라고 판명가능");
			panel1.setBackground(Color.cyan);
		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		new Exercise();
	}

}
