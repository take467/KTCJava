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


public class SwingJankenApp extends JFrame implements ActionListener {
	private static final long serialVersionUID= 1L;
	JButton b1,b2;
	JTextArea ta;
	
	public SwingJankenApp(){
		this.setSize(300,200);
		ta = new JTextArea();
		JScrollPane scroll = new JScrollPane(ta);
		this.add(scroll,BorderLayout.CENTER);
		b1 = new JButton("Load");
		b1.addActionListener(this);
		b2 = new JButton("Save");
		b2.addActionListener(this);
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		
		this.add(p,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SwingJankenApp();

	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if( ev.getSource() == b1 )
			this.load();
		else
			this.save();
	}
	
	String targetFile = "/Users/fujisawa/work/sample.txt";

	private void load() {
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(targetFile);
			br = new BufferedReader(fr);
			String str = "";
			String rstr = "";
			while( (rstr = br.readLine())  != null ){
				str += rstr + "\r\n";
			}
			ta.setText(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				br.close();
			}catch(Exception ex2){
				ex2.printStackTrace();
			}
		}
		
	}
	private void save() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
			fw = new FileWriter(targetFile);
			bw = new BufferedWriter(fw);
			
			bw.write(ta.getText());
			bw.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				bw.close();
			}catch(Exception ex2){
				ex2.printStackTrace();
			}
		}
		
	}

}
