/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorbox2;

import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 *
 * @author Brian Fristensky, Dept. of Plant Science, Univ. of Manitoba
 */
public class ErrorBox2 {

    /**
     * Opens a popup box with an error message and an Okay button. 
     * ErrorBox2 is designed as a platform-independent way for scripts to
     * open a popup window with an error message.
     * <p> 
     * Example:
     * java -jar ErrorBox2.jar "No can do, kimosabe."
     * <p>
     * pops up an Error window with the message "No can do, kimosabe".
     * 
     * @param [message message to be printed in the box]
     * @param [title title for popup box]
     * @throws Exception
     * 
     * 
     */
    public static void main(final String[] args) throws Exception  {
                        try {            
            /** MacOSX - Swing components such as the FileChooser sometimes
             * don't popup on the screen. To fix this, the code
             * has to be wrapped in a Runnable through EventQueue.
             * see http://stackoverflow.com/questions/33599014/jfilechooser-not-showing
             */
            EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
		JOptionPane eb = new JOptionPane ();
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
			title = "Error";
		}


		eb.showConfirmDialog(null,message,title,JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
            });
        } catch (Exception ex) {
            Logger.getLogger(ErrorBox2.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // TODO code application logic here
    }
    
}
