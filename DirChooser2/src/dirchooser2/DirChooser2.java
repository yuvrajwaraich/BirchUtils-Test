/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dirchooser2;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brian Fristensky, Dept. of Plant Science, Univ. of Manitoba
 */
public class DirChooser2 {
    
    /**
     * TEST OF GIT IN NETBEANS
     * Opens a file chooser, and prints the fully-qualified path of the selected directory.
     * DirChooser2 is designed as a platform-independent way for scripts to
     * open a popup window to choose a directory.<br>
     * Usage:<br>
     * java -jar DirChooser2.jar  &#91;<i>title</i>&#93;
     * <p>
     * Example:<br>
     * java -jar DirChooser2.jar "Choose the directory in which you wish to work"
     * <p>
     * pops up a window with the message in the title line. If the user selects
     * the directory "/home/psgendb/demo" and presses Open, DirChooser2.jar will print the line
     * <p>
     * /home/psgendb/demo
     * @throws InvocationTargetException 
     */
    public static void main(final String[] args) throws InvocationTargetException {
        try {
            
            /** MacOSX - Swing components such as the FileChooser sometimes
             * don't popup on the screen. To fix this, the code
             * has to be wrapped in a Runnable through EventQueue.
             * see http://stackoverflow.com/questions/33599014/jfilechooser-not-showing
             */
            EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
            		    File choice = null;
		    JFileChooser fc = new JFileChooser ();

		    if (args.length >= 1) {
			    fc.setDialogTitle(args[0]);
		    } else {
			    fc.setDialogTitle("Set directory");
		    }

		    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    fc.setMultiSelectionEnabled(false);

		    if (args.length >= 2) {
			    fc.showDialog(null, args[1]);
		    } else {
			    fc.showOpenDialog(null);
		    }

		    choice = fc.getSelectedFile();

		    try {
			    if (choice != null) {
				    System.out.println(choice.getCanonicalPath());
			    }
			    System.exit(1);
		    } catch (IOException ioe) {
			    ioe.printStackTrace(System.err);
		    }
            }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(DirChooser2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}