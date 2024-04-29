package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 중첩 클래스 --> 외부 , 내부 클래스로 내부 클래스로 -> 인스턴스 클래스 , static 클래스
 */
public class MyImageFrame extends JFrame {

	private MyImagePanel myImagePanel; // 내부클래스

	public MyImageFrame() {
		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myImagePanel = new MyImagePanel(); // 내부클래스 생성자로 실행흐름

	}

	private void setInitLayout() {
		add(myImagePanel); // 이미지 붙여야함!
		setVisible(true); // 화면에 보이기 하기!
	}

	// 내부 클래스 -> static 키워드 활용가능!
	// 정적 (static) 내부클래스라고함
	static class MyImagePanel extends JPanel {
		private Image image1; // 변수 선언 , 값은 넣지않은 상태
		private Image image2; // 변수 선언 , 값은 넣지않은 상태

		public MyImagePanel() {
			// ImageIcon() 이라는 데이터타입안에서 getImage() 라는 메서드를 호출하면
			// image 라는 데이터타입을 만들어낼수있다.
			image1 = new ImageIcon("image1.png").getImage();
			image2 = new ImageIcon("image2.png").getImage();
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image1,100, 100, // int x, int y
					300, 300, // int width, int height,
					null); // ImageObserver observe

		g.drawImage(image2,400, 100, // int x, int y
				250, 250, // int width, int height,
				null); // ImageObserver observer
	}
	
	}
}
