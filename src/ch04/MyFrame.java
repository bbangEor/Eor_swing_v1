package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *  JLabel 을 이용해서 이미지를 다룰 수있다. 
 *  JLabel.add();  메서드를 통해서 이미지를 겹칠 수 있다.
 *  좌표 기준으로 이미지를 세팅하려면 
 *  배치관리자를 null 값으로 세팅해야한다.
 */
public class MyFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;
	

	public MyFrame() {

		initData();
		SetinitLayout();

	}

	private void initData() {
		setTitle("JLable 을 활용한 이미지 사용연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon icon = new ImageIcon("images/background1.jpg");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);

		player = new JLabel(new ImageIcon("image3.png"));
		player.setSize(300,300);
		player.setLocation(200,100);
		
	}

	private void SetinitLayout() {
		// 좌표값으로 세팅하기 위해서는, 배치관리를 null값으로 만들어주어야한다
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
	}

}
