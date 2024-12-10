import javax.swing.*;
import javax.swing.event.*;

public class LineNumberManager {
    private JTextArea textArea;
    private JTextArea lineNumbers;

    public LineNumberManager(JTextArea textArea, JTextArea lineNumbers) {
        this.textArea = textArea;
        this.lineNumbers = lineNumbers;

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });
    }

    public void updateLineNumbers() {
        try {
            int totalLines = textArea.getLineCount();
            StringBuilder lineNumbersText = new StringBuilder();
            
            for (int i = 1; i <= totalLines; i++) {
                lineNumbersText.append(i).append("\n");
            }
            
            lineNumbers.setText(lineNumbersText.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
