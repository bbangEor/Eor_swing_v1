package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch02.MyDrawFrame.MyDrawPanel;

// 내부클래스 를 활용해서 코드를 완성해 주세요! 
public class PaintFrame extends JFrame {

	PaintPanel paintPanel;

	public PaintFrame() {

		initData();
		setInitLayout();

	}

	private void initData() {
		setTitle("푸바오 눈사람 만들기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paintPanel = new PaintPanel();

	}

	private void setInitLayout() {
		add(paintPanel);
		setVisible(true);
	}

	// 내부클래스
	class PaintPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawOval(230, 150, 150, 130);// 머리
			
			g.drawOval(230, 280, 150, 110);// 몸
			g.drawString("♥", 300, 330); // 단추 위
			g.drawString("♥", 300, 370); // 단추 아래
			
			//얼굴
			g.drawOval(270, 210, 20, 20); // 왼쪽 눈
			g.drawOval(273, 211, 17, 17); // 왼쪽 눈알
			g.drawOval(330, 210, 20, 20); // 오른쪽 눈
			g.drawOval(330, 211, 17, 17); // 오른쪽 눈알
			g.drawArc(270, 170, 70, 70, 238, 75); // 스마일
			
			//귀
			g.drawOval(360, 150, 40, 40);// 오른쪽 귀
			g.drawOval(360, 155, 25, 25);// 오른쪽 귀 세부
			g.drawOval(210, 150, 40, 40);// 왼쪽 귀
			g.drawOval(225, 155, 25, 25);// 왼쪽 귀 세부
			
			//발
			g.drawOval(200, 370, 70, 70);// 왼발
			g.drawOval(340, 370, 70, 70);// 오른발
			
			// snow 
			g.drawOval(500, 150, 7, 7);
			g.drawOval(200, 250, 6, 6);
			g.drawOval(100, 180, 7, 7);
			g.drawOval(170, 200, 10, 10);
			g.drawOval(570, 570, 10, 10);
			g.drawOval(170, 200, 10, 10);
			g.drawOval(450, 50, 15, 15);
			g.drawOval(250, 50, 15, 15);
			g.drawOval(100, 30, 15, 15);
			g.drawOval(250, 50, 15, 15);
			g.drawOval(300, 100, 5, 5);
			g.drawOval(300, 100, 5, 5);
		}// end of inner class
	}
}
