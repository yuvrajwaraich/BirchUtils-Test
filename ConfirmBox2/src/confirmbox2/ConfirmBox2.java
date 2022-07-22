/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmbox2;

import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brian Fristensky, Dept. of Plant Science, Univ. of Manitoba
 */
public class ConfirmBox2 {

    /**
     * Opens a popup box with a question and Yes and No buttons. Prints
     * the choice (ie. Yes or No)
     * ConfirmBox2 is designed as a platform-independent way for scripts to
     * open a popup window to answer a question.<br>
     * java -jar ConfirmBox2.jar &#91;message&#93; &#91;title&#93;
     * <p> 
     * Example:
     * java -jar ConfirmBox2.jar "Do you wish to continue?"
     * <p>
     * pops up a window with the message "Do you wish to continue?".
     * If the user clicks the Yes button, the program prints the line
     * <p>
     * Yes
     *
     */
    public static void main(final String[] args) throws Exception {
                try {
		System.out.println("testing");
            
            /** MacOSX - Swing components such as the FileChooser sometimes
             * don't popup on the screen. To fix this, the code
             * has to be wrapped in a Runnable through EventQueue.
             * see http://stackoverflow.com/questions/33599014/jfilechooser-not-showing
             */
            EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
		JOptionPane vb = new JOptionPane ();
                String title;
                String message;

		if (args.length >= 1) {
			message = args[0];
		} else {
			message = " ";
		}

		if (args.length >= 2) {
			title = args[1];
		} else {
			title = "Confirm before proceeding";
		}


		int choice = vb.showConfirmDialog(null,message,title, JOptionPane.YES_NO_OPTION);

		try {
			if (choice == JOptionPane.YES_OPTION) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
                        }
			System.exit(1);
		} catch (Exception E) {
			System.out.println("Error");
		}
            }
            });
        } catch (Exception ex) {
            Logger.getLogger(ConfirmBox2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
