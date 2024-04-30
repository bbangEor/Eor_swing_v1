package ch06;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyKeyEvent extends JFrame implements KeyListener {

	private JTextArea textArea;

	public MyKeyEvent() {
		initData();
		setInintLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 프레임 사이즈 조절 불가!

		textArea = new JTextArea();

	}

	private void setInintLayout() {
		// 좌표 기준으로 세팅 -> null 대입!
		setLayout(new BorderLayout());
		add(textArea);
		setVisible(true);
	}

	private void addEventListener() {
		// textArea 위에서 사용자가 키보드를 누르면 감지해서 
		// 코드에게 알려주는 기능.
		textArea.addKeyListener(this);
	}

	

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("keyPressed :" + e.getKeyCode());
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 문제 1
		// 제어문을 활용해서 방향키 위 아래 왼쪽 오른쪽을 눌렀다 떼면,
		// 콘솔창에 한글로 " 위 아래 왼쪽 오른쪽 " 글자를 표기하세요.
		//System.out.println("keyPressed :" + e.getKeyCode());
		//  e.getKeyCode -> 위 38 아래 40 왼 37 오 39  
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("위");
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("아래");
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("왼쪽");
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("오른쪽");
		}
	}

}
