package Bubble.test.ex07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bubble extends JLabel implements Moveable {

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
		// 객체 생성시 무조건 스레드 시작! 
		initThread();
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

	// 공통으로 사용하는 부분을 메서드로 만들어보자! 
	// 이 메서드내부에서만 사용할 예정
	private void initThread() {
		// 버블은 스레드가 하나면된다.
		// 익명클래스 
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				if(player.playerWay == PlayerWay.LEFT ) {
					left();
				}else {
					right();
				}
				
			}
		}).start();
	}
	
	@Override
	public void left() {
		left = true;
		for(int i = 0; i < 400; i++) {
			x--;
			setLocation(x,y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for(int i = 0; i < 400; i++) {
			x++;
			setLocation(x,y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	
	}

	@Override
	public void up() {

		up = true;
		while(true) {
			y--;
			setLocation(x,y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}