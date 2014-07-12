import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SwingInquirySampleApp extends JFrame implements ActionListener{
    final JTextField depField;
    final JTextField gradeField;
    final JTextField idField;
    final JTextField noField;
    final JTextField nameField;
    final JTextArea  textArea;
    final JButton button;
    
	public SwingInquirySampleApp(){
	    setTitle("問い合わせ");
	    setSize(300, 400);
	    setLayout(new GridLayout(7,2));
	    
	    depField = new JTextField();
	    gradeField = new JTextField();
	    idField = new JTextField();
	    noField = new JTextField();
	    nameField = new JTextField();
	    textArea  = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
	    button = new JButton("保存");
	    button.addActionListener(this);
	   
	    add(new JLabel("学科："));
	    add(depField);
	    add(new JLabel("学年："));
	    add(gradeField);
	    add(new JLabel("学籍番号："));
	    add(idField);
	    add(new JLabel("名列番号："));
	    add(noField);
	    add(new JLabel("氏名："));
	    add(nameField);
	    add(new JLabel("問い合わせ内容："));
	    add(scroll);    
	    add(button);

	    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	public static void main(String[] args){
		new SwingInquirySampleApp();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		File f = ChooseFile();
		save(f);
	}
	private void save(File f) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			String cr = System.getProperty("line.separator");
			bw.write("学科:" + depField.getText() + cr);
			bw.write("学年:" + gradeField.getText() + cr);
			bw.write("学籍番号:" + idField.getText() + cr);
			bw.write("名列番号:" + noField.getText() + cr);
			bw.write("氏名:"    + nameField.getText() + cr);
			bw.write("問い合わせ内容:" + cr + textArea.getText() + cr);

			bw.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				bw.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	private File ChooseFile() {
	    JFileChooser filechooser = new JFileChooser();
	    File file = null;
	    int selected = filechooser.showSaveDialog(this);
	    if (selected == JFileChooser.APPROVE_OPTION){
	      file = filechooser.getSelectedFile();
	    }
	    return file;
	}
}
