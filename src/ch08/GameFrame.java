package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;
	int enemyX = 250;
	int enemyY = 420;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	// 클래스 안에 클래스를 작성하기 -> 중첩클래스 -> 외부클래스 , 내부클래스 생김
	private class ImagePanel extends JPanel implements Runnable {

		// paintComponent ( O ) , paintComponents ( X )
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);// (x,y, 크기,크기,null)
			g.drawImage(player1, playerX, playerY, 50, 50, null);// (x,y, 크기,크기,null)
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);// (x,y, 크기,크기,null)

			// Todo
			// 플레이어, 적군 그림을 그려야함!
			// 스레드 활용 예정!
		}

		@Override
		public void run() {
			// true = 왼쪽으로 향함
			// false = 오른쪽으로 향함
			boolean direction = true;
			boolean stop = true;

			while (true) {
				System.out.println("진행중");

				if (direction) {
					enemyX -= 10;
				} else {
					enemyX += 10;
				}
				// 방향 바꾸는 개념은 enemy 의 x 좌표값이
				if (enemyX <= 50) {
					direction = false;
				}

				if (enemyX >= 500) {
					direction = true;
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}

				repaint();

			}

		}

	}

	private void initData() {
		setTitle("Thread 를 활용한 미니 예제");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try { // 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임시킨다.
		Thread thread = new Thread(imagePanel);
		thread.start();

	}

	private void setInitLayout() {
		// setLayout(null);
		// setResizable(false); // 프레임 크기조절 불가!
		setVisible(true); // 화면에 나타나도록 설계!
		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너를 등록하는 방법! 중 익명구현클래스로 만들어보기!
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("이곳이 동작합니다");
				int code = e.getKeyCode(); // 제어문
				if (code == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (code == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (code == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (code == KeyEvent.VK_SPACE) {
					pause();
					// 1. 스페이스바 눌렀을때 적군을 멈출 수 있도록 코드 수정
				}

				// 2. player 가 적군과 만났다면 player 그림을 없애주세요

				repaint();
			} //
		});
	}

	public static  void pause() {
		 try {
		      System.in.read();
		    } catch (IOException e) { }
		  
		
	}

}
