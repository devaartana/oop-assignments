import javax.swing.*;
import java.awt.event.*;

public class HelpMenuHandler implements ActionListener {
    private JFrame parentFrame;

    public HelpMenuHandler(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("About Notepad".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(parentFrame, 
                "Notepad - A Simple Text Editor", 
                "About Notepad", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}