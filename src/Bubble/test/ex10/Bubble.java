package Bubble.test.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable {

	private BubbleFrame mContext;

	// 의존성 컴포지션관계
	private Player player;
	private BackgroundBubbleService backgroundBubbleService;

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
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();
		// 객체 생성시 무조건 스레드 시작!

	}

	// get set
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
		backgroundBubbleService = new BackgroundBubbleService(this);

		left = false;
		right = false;
		up = false;
		state = 0;

	}

	private void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);

	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);

			// 왼쪽 벽에 부딪혔다면 -> Up 하도록!
			if (backgroundBubbleService.leftWall()) {
				// true = 부딪힘
				break; // 반복문 멈추기
			}

			// 현재 버블의 x , y 좌표값을 알고있다.
			System.out.println("적군 x 좌표 위치 : " + mContext.getEnemy().getX());
			System.out.println("적군 y 좌표 위치 : " + mContext.getEnemy().getY());

			// x 절대 값만 확인해보기!
			int absX = Math.abs(x - mContext.getEnemy().getX());
			int absY = Math.abs(y - mContext.getEnemy().getY());
			if (absX < 10 && absY < 50) {
				// 단, 적군이 살아있을때 crash() 메서드 호출!
				if (mContext.getEnemy().getState() == 0) {
					crash();
				}

			}

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
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);

			if (backgroundBubbleService.rightWall()) {
				break;
			}
			// 적군 감지
			System.out.println("적군 x 좌표 위치 : " + mContext.getEnemy().getX());
			System.out.println("적군 y 좌표 위치 : " + mContext.getEnemy().getY());

			// x 절대 값만 확인해보기!
			int absX = Math.abs(x - mContext.getEnemy().getX());
			int absY = Math.abs(y - mContext.getEnemy().getY());
			if (absX < 10 && absY < 50) {
				// 단, 적군이 살아있을때 crash() 메서드 호출!
				if (mContext.getEnemy().getState() == 0) {
					crash();
				}
			}

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
		while (true) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearBubble(); // 버블이 최상단에 올라간 이후
	}

	// 외부호출 불가능 메서드
	private void clearBubble() {
		// 천장에 부딪히고 3초 뒤에 버블 터짐
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			// 메모리에서 해제 처리

			Thread.sleep(500);
			// 테스트 필요!
			setIcon(null);
			// JFrame 안에 remove 라는 메서드 존재함.

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void crash() {
		mContext.getEnemy().setState(1);
		state = 1;
		setIcon(bubbled);
		// 적군이 살아있는 상태에서 부딪히면
		// 버블에 갇힌 상태로 변경
		mContext.getEnemy().setIcon(null);
		mContext.remove(mContext.getEnemy());
		// mContext.getEnemy() 가비지 컬렉터의 제거대상이된다.
		mContext.repaint();
		// 버블 이미지 변경처리!

	}

}
