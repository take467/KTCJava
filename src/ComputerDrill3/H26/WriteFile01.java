package ComputerDrill3.H26;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile01 extends FileIOBase{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		WriteFile01 wf = new WriteFile01();
		wf.start();
	    wf.setBounds(10, 10, 300, 200);
	    wf.setTitle("タイトル");
	    wf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		super.ChooseFile();
		
		// ファイルパスがnullの場合は処理を中止します。
		if (path == null) {
			return;
		}
		int ch;
		try {		
			FileWriter fw = new FileWriter(path);
			System.out.println("なにか入力して下さい");
			while ((ch = System.in.read()) != -1) {
				fw.write(ch);
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
}
