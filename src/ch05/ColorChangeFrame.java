package ch05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//이벤트 리스너를 사용하는방법 
//1. implements ActionListener  
//ActionListener -> 운영체제가 제어하는 이벤트를 등록할 수 있다.
public class ColorChangeFrame extends JFrame implements ActionListener {

	// 이벤트 리스너에 대한 개념을 이해하기!
	private JButton button1;

	public ColorChangeFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}

	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(button1);
		setVisible(true);

	}

	private void addEventListener() {
		// button1 이라는 이벤트가 눌러지는지 계속 지켜보고 있다.
		// 이벤트 등록!
		button1.addActionListener(this);

	}

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame();

	}

	// add + = 약속돼있던 추상메서드를 오버라이드했음.
	// 이벤트가 발생되면 이 메서드를 수행 해 ! > 라는 약속이 되어있음
	// 단, 어떤 이벤트가 할당 되었는지 컴포넌트가 우선적으로 등록을 해줘야함.
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("actionPerformed 메서드 호출()");
		System.out.println(e.toString());
		setBackground(Color.black);
	} //

} //
