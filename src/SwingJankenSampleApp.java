import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 夏休みの宿題としてつくらせる課題の一つ
 * 
 * @author fujisawa
 *
 */

public class SwingJankenSampleApp extends JFrame implements ActionListener {
	private static final long serialVersionUID= 1L;
	JButton gu,choki,pa;
	JTextArea ta;
	
	public SwingJankenSampleApp(){
		this.setSize(300,200);
		ta = new JTextArea();
		JScrollPane scroll = new JScrollPane(ta);
		this.add(scroll,BorderLayout.CENTER);
		gu = new JButton("グー");
		gu.addActionListener(this);
		choki = new JButton("チョキ");
		choki.addActionListener(this);
		pa = new JButton("パー");
		pa.addActionListener(this);
		
		JPanel p = new JPanel();
		p.add(gu);
		p.add(choki);
		p.add(pa);
		
		this.add(p,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SwingJankenSampleApp();

	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		String[] label = new String[] { "グー", "チョキ", "パー" };
		
		int you = -1;
		if( ev.getSource() == gu ){
			you = 0;
		}else if( ev.getSource() == choki){
			you = 1;
		}else{
			you = 2;
		}
		int pc = getComputerHand();
		// 判定
		int result = judge(you,pc);
		
		// 結果表示
		String msg = "あなた：" + label[you] + " PC:" + label[pc] + " => ";
		
		switch (result) {
		case 1: 
			msg += "あなたの勝ち!";
			break; 
		case 0: 
			msg += "あなたの負け";
			break; 
		case 2: 
			msg += "あいこ";
			break; 
		}
		msg += "\n\n";
		
		ta.setText(msg);
	}
	public int getComputerHand(){
		int pc = (int) (Math.random() * 3);
		return pc;
	}
	public int judge(int you,int pc){
		// PCが負ける手を求める
		int lose = -1;
		switch (you) {
		case 0: /* グー */
			lose = 1;
			break; // チョキ
		case 1: /* チョキ */
			lose = 2;
			break; // パー
		case 2: /* パー */
			lose = 0;
			break; // グー
		}
		// 結果判定
		if (you == pc) {
			return 2;
		} else if (pc == lose) {
			return 1;
		} else {
			return 0;
		}
	}
}
