package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx2 extends JFrame {

	final int WIDTH = 600;
	final int HEIGHT = 600;
	JButton[] buttons;
	String[] directions = {BorderLayout.EAST, BorderLayout.WEST,BorderLayout.NORTH
			,BorderLayout.SOUTH,BorderLayout.CENTER};
	
	
	// 생성자
	public BorderLayoutEx2() {

		initData();
		setInitLayout();

	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize( WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 누르면 프로그램 종료해
		buttons = new JButton[directions.length];
		
	}
	

	private void setInitLayout() {
		// 배치관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트 들을 동서남북 가운데로 배치시켜주는레이아웃
		setLayout(new BorderLayout());
		
		//반복문을 활용해서 코드를 완성하세요.
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(directions[i]),directions[i]);
		}
	}

	public static void main(String[] args) {
		// 코드 테스트
		new BorderLayoutEx2();

	}
}
