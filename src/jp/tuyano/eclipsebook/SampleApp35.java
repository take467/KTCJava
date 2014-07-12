package jp.tuyano.eclipsebook;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleApp35 extends JFrame{
	public SampleApp35(){
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel("Hello");
		this.add(l1,BorderLayout.EAST);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SampleApp35();
	}

}
