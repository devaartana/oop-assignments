import javax.swing.*;
import java.awt.event.*;

public class EditMenuHandler implements ActionListener {
    private JTextArea textArea;

    public EditMenuHandler(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cut":
                textArea.cut();
                break;
            case "Copy":
                textArea.copy();
                break;
            case "Paste":
                textArea.paste();
                break;
        }
    }
}
