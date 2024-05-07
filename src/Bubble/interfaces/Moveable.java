package Bubble.interfaces;

public interface Moveable {
	
	// public abstract 생략 가능 
	public abstract void left();
	public abstract void right();
	public abstract void up();
	// 인터페이스 추가기능 default 사용해보기 ! 
	// 인터페이스의 모든 메서드는 추상 메서드여야한다! 
	//단, default 메서드는 제외한다.
	default void down() {};
	//마지막에 디폴트는 세미콜론; 추가해야한다!
}
