package Bubble.test.ex06;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bubble extends JLabel {

	private Player player;
	
	private int x;
	private int y;
	
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	
	// 적군을 버블로 공격한 상태 
	private int state; // 0. (기본 버블) 1.(적을 버블에 가둔 상태)
	
	private ImageIcon bubble; // 기본 버블
	private ImageIcon bubbled; // 적을 버블에 가둔 상태 
	private ImageIcon bomb; // 버블 터뜨리기
	
	
	
	// 연관관계 , 의존성 컴포지션 관계 , 생성자 의존 (DI)
	public Bubble(Player player) {
		this.player = player;
		initData();
		setInitLayout();
	}
	
	//get set
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	private void initData() {
		
		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");
		
		left = false;
		right = false;
		up = false;
		state = 0;
		
	}
	private void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50,50);
		setLocation(x,y);
		
	}
	
}
