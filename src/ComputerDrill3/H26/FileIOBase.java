package ComputerDrill3.H26;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class FileIOBase extends JFrame implements ActionListener {

	JLabel label;
	String path = null;
	
	public void start(){
	    JButton button = new JButton("file select");
	    button.addActionListener(this);

	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(button);

	    label = new JLabel();

	    JPanel labelPanel = new JPanel();
	    labelPanel.add(label);

	    getContentPane().add(labelPanel, BorderLayout.CENTER);
	    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


	public String getFilePath(){
		return path;
	}
	void ChooseFile() {
	    JFileChooser filechooser = new JFileChooser();

	    int selected = filechooser.showSaveDialog(this);
	    if (selected == JFileChooser.APPROVE_OPTION){
	      File file = filechooser.getSelectedFile();
	      label.setText(file.getName());
	      try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			label.setText("エラー又は取消しがありました");
			e.printStackTrace();
		}
	    }else if (selected == JFileChooser.CANCEL_OPTION){
	      label.setText("キャンセルされました");
	    }else if (selected == JFileChooser.ERROR_OPTION){
	      label.setText("エラー又は取消しがありました");
	    }
	}
}
