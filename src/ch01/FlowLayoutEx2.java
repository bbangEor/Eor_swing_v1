package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치관리자 : FlowLayout
// 컴포넌트들을 (버튼,라벨) 등을 수평, 수직으로 배치 해주는 클래스
public class FlowLayoutEx2 extends JFrame {

	//배열 활용
	private JButton[] buttons;

	//4개 더만들기
	
	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//생성자에서 메서드 호출가능
		initData();
		setInitLayout();
	}

	// 멤버변수 초기화하는기능 (값 넣다)
	public void initData() {
		buttons = new JButton[6]; // 공간만 선언한것 , 객체는 들어가있지않음.
		//반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("[ button" +( i + 1 ) + " ] ");
		} 
	
	
	}
	
	public void setInitLayout() {
		//배치관리자 ->  BorderLayout 이라는 배치관리자가 기본으로 활용된다.
		
		//FlowLayout flowLayout =new FlowLayout();
		//super.setLayout(flowLayout);
		
		//배치관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50)); // 배치관리자 --> FlowLayout
		
		//컴포넌트들을 붙이다
		//반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}
	
	}

	// 코드테스트
	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); > 부를수 있는 이름이있는상태
		new FlowLayoutEx2(); // <- 익명 클래스
		// 다시접근해서사용할 일없으면 new 라고 선언만 해도 가능.

	}

}//
