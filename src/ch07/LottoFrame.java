package ch07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton button;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private int NUMBER_DISTANCE = 50;
	

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	public void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game Start");
		lottoRandomNumber = new LottoRandomNumber(); // 포함관계가 됨.
	}

	public void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
	}

	public void addEventListener() {
		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("그림을 그려라!");
		isStart = false;
		repaint();
		// 이 구간에서 이벤트가 일어나면 그림을 다시 그려라 < 라는 명령어 F5
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Font f = new Font(" 돋음체 " , Font.BOLD, 20);
		g.setFont(f);
		
		if(isStart) {
			g.drawString(" 로또 번호를 클릭하세요 ", 180, 200); // 클릭하면 글자가 깜빡거림.
		} else {
			int[] getNumbers = lottoRandomNumber.creteNumber();
			
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString( getNumbers[i] + "",180 + ( i *NUMBER_DISTANCE) , 200);
			}
//			g.drawString( getNumbers[0] + "", 100 , 300);
//			g.drawString( getNumbers[1] + "", 120 , 300);
//			g.drawString( getNumbers[2] + "", 140 , 300);
//			g.drawString( getNumbers[3] + "", 160 , 300);
//			g.drawString( getNumbers[4] + "", 180 , 300);
//			g.drawString( getNumbers[5] + "", 200 , 300);
		}
	}

	// 메인함수
	public static void main(String[] args) {
		new LottoFrame();

	}//
}//
