package ComputerDrill3.H26;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFile02 extends FileIOBase{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		WriteFile02 wf = new WriteFile02();
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
		try {		
		    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw  = new BufferedWriter(fw);
		
			System.out.println("なにか入力して下さい");
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.write("\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("保存しました．");
		System.exit(1);
	}
}
