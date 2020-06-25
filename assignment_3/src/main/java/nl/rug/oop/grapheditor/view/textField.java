package nl.rug.oop.grapheditor.view;
import nl.rug.oop.grapheditor.model.GraphModel;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * textField class.
 */
public class textField extends JTextField {

   /**
    * Constructor.
    */
      public textField (int x, int y, GraphModel graphModel) {
         setBounds(x, y, 280, 50);
         setToolTipText("<html><b><font color=red>" + "Rename the selected node." + "</font></b></html>");
         addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               super.keyPressed(e);
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  graphModel.renameSelectedNode(getText());
                  setVisible(false);
               }
            }
         });
      }

}

