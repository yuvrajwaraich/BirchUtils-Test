/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okaybox2;

import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brian Fristensky, Dept. of Plant Science, Univ. of Manitoba
 */
public class OkayBox2 {

    /**
     * Opens a popup box with a message and an Okay button. 
     * OkayBox2 is designed as a platform-independent way for scripts to
     * open a popup window with a notification.
     * java -jar OkayBox2.jar [message] [title]
     * <p> 
     * Example:
     * java -jar OkayBox2.jar "Your job has completed."
     * <p>
     * pops up an Okay window with the message "Your job has completed".
     * 
     * @param [message message to be printed in the box]
     * @param [title title for popup box]
     */
    public static void main(final String[] args) throws Exception {
                try {            
            /** MacOSX - Swing components such as the FileChooser sometimes
             * don't popup on the screen. To fix this, the code
             * has to be wrapped in a Runnable through EventQueue.
             * see http://stackoverflow.com/questions/33599014/jfilechooser-not-showing
             */
            EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
		JOptionPane ob = new JOptionPane ();
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
			title = "Notification";
		}


		ob.showConfirmDialog(null,message,title,JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
            }
            });
        } catch (Exception ex) {
            Logger.getLogger(OkayBox2.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
}
