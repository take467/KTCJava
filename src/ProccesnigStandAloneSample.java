import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

public class ProccesnigStandAloneSample {

	public static void main(String args[]) {
		// Create the frame this applet will run in
		Frame appletFrame = new Frame("Processing");

		// The frame needs a layout manager, use the GridLayout to maximize
		// the applet size to the frame.
		appletFrame.setLayout(new GridLayout(1, 0));


		// Create an instance of the applet
		Applet myApplet = null ; // new sketch_jan04a();

		// Add the applet to the frame
		appletFrame.add(myApplet);

		// Initialize and start the applet
		myApplet.init();
		appletFrame.add(myApplet,BorderLayout.CENTER);
		appletFrame.pack();
		appletFrame.setVisible(true);
		myApplet.start();

	}
}
