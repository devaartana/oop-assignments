import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeHandler implements ActionListener {
    private JTextArea textArea;
    private JTextArea lineNumbers;
    private JScrollPane scrollPane;
    private boolean isDarkMode = false;

    public ThemeHandler(JTextArea textArea, JTextArea lineNumbers, JScrollPane scrollPane) {
        this.textArea = textArea;
        this.lineNumbers = lineNumbers;
        this.scrollPane = scrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Dark Mode":
                toggleDarkMode();
                break;
        }
    }

    public void toggleDarkMode() {
        isDarkMode = !isDarkMode;

        if (isDarkMode) {
            textArea.setBackground(Color.DARK_GRAY);
            textArea.setForeground(Color.WHITE);
            textArea.setCaretColor(Color.WHITE);

            lineNumbers.setBackground(Color.BLACK);
            lineNumbers.setForeground(Color.LIGHT_GRAY);

            scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        } else {
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            textArea.setCaretColor(Color.BLACK);

            lineNumbers.setBackground(Color.LIGHT_GRAY);
            lineNumbers.setForeground(Color.BLACK);

            scrollPane.getViewport().setBackground(Color.WHITE);
        }
    }


    public boolean isDarkMode() {
        return isDarkMode;
    }

}