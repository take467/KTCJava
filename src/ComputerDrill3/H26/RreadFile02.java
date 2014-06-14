package ComputerDrill3.H26;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RreadFile02 extends FileIOBase{
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RreadFile02 rf = new RreadFile02();

		rf.start();
		
	    rf.setBounds(10, 10, 300, 200);
	    rf.setTitle("タイトル");
	    rf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		super.ChooseFile();
		
		// ファイルパスがnullの場合は処理を中止します。
		if (path == null) {
			return;
		}
		// ファイルから1文字づつ読み込みます。


		try {		
			
			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			System.exit(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
