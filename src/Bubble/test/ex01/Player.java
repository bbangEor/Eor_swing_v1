package Bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x; // 플레이어의 x 좌표
	private int y; // 플레이어의 y 좌표
	private ImageIcon playerR, playerL;

	public Player() {

		initData();
		setInitLayout();

	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 첫 실행 시 초기값 세팅!
		x = 55;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		// 왼쪽 방향키 이벤트 발생 시
		// 왼쪽 방향으로 바라보는 이미지로 세팅.
		setIcon(playerL);
		x = x - 10;
		setLocation(x, y);
	}

	@Override
	public void right() {
		// 오른쪽 방향키 이벤트 발생 시
		// 오른쪽 방향으로 바라보는 이미지로 세팅.
		setIcon(playerR);
		x = x + 10;
		setLocation(x, y);

	}

	@Override
	public void up() {
		System.out.println("점프");
		setIcon(playerR);
	}

	@Override
	public void down() {
		System.out.println("다운");
		
	}

	

}
