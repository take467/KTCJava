package jp.tuyano.eclipsebook;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * 最初に教科書通り作らせた後、きれいなソースコードを見せたほうがいいか。
 * 
 */
public class SampleApp {

	public static void main(String[] args) {

		MyFrame f = new MyFrame();
		
		f.setSize(300,200);
		f.showJLabel1();
		f.setVisible(true); // should be called after  showJlabel method . 
	}
}

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void showJLabel1(){
		JLabel l1 = new JLabel("Hello");
		this.add(l1,BorderLayout.CENTER);
	}	
}