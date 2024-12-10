import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchHandler implements ActionListener {
    private JTextArea textArea;
    private JFrame parentFrame;
    private int lastSearchIndex = -1;
    private String lastSearchTerm = "";
    private boolean searchForward = true;

    public SearchHandler(JTextArea textArea, JFrame parentFrame) {
        this.textArea = textArea;
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Find":
                showSearchDialog();
                break;
            case "Replace":
                replaceDialog();
                break;
        }
    }

    public void showSearchDialog() {
        JDialog searchDialog = new JDialog(parentFrame, "Search", false);
        searchDialog.setLayout(new BorderLayout());
        
        JTextField searchField = new JTextField(20);
        JCheckBox caseSensitiveCheck = new JCheckBox("Case Sensitive");
        JButton findNextButton = new JButton("Find Next");
        JButton findPreviousButton = new JButton("Find Previous");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Search: "));
        inputPanel.add(searchField);
        inputPanel.add(caseSensitiveCheck);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(findNextButton);
        buttonPanel.add(findPreviousButton);

        searchDialog.add(inputPanel, BorderLayout.NORTH);
        searchDialog.add(buttonPanel, BorderLayout.SOUTH);

        findNextButton.addActionListener(e -> {
            searchForward = true;
            performSearch(searchField.getText(), caseSensitiveCheck.isSelected(), true);
        });

        findPreviousButton.addActionListener(e -> {
            searchForward = false;
            performSearch(searchField.getText(), caseSensitiveCheck.isSelected(), false);
        });

        searchField.addActionListener(e -> {
            searchForward = true;
            performSearch(searchField.getText(), caseSensitiveCheck.isSelected(), true);
        });

        searchDialog.pack();
        searchDialog.setLocationRelativeTo(parentFrame);
        searchDialog.setVisible(true);
    }



    private void performSearch(String searchTerm, boolean caseSensitive, boolean forward) {
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "Please enter a search term", 
                "Search", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String text = caseSensitive ? textArea.getText() : textArea.getText().toLowerCase();
        searchTerm = caseSensitive ? searchTerm : searchTerm.toLowerCase();

        int startIndex = lastSearchIndex;
        
        if (forward) {
            startIndex = (startIndex == -1) ? 0 : startIndex + 1;
            if (startIndex >= text.length()) {
                startIndex = 0;
            }
            
            int foundIndex = text.indexOf(searchTerm, startIndex);
            
            if (foundIndex == -1 && startIndex > 0) {
                foundIndex = text.indexOf(searchTerm, 0);
            }
            
            if (foundIndex != -1) {
                textArea.setSelectionStart(foundIndex);
                textArea.setSelectionEnd(foundIndex + searchTerm.length());
                textArea.requestFocusInWindow();
                lastSearchIndex = foundIndex;
                lastSearchTerm = searchTerm;
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Text not found", 
                    "Search", JOptionPane.INFORMATION_MESSAGE);
                lastSearchIndex = -1;
            }
        } else {
            startIndex = (startIndex == -1) ? text.length() - 1 : startIndex - 1;
            if (startIndex < 0) {
                startIndex = text.length() - 1;
            }
            
            int foundIndex = text.lastIndexOf(searchTerm, startIndex);
            
            if (foundIndex == -1 && startIndex < text.length() - 1) {
                foundIndex = text.lastIndexOf(searchTerm, text.length() - 1);
            }
            
            if (foundIndex != -1) {
                textArea.setSelectionStart(foundIndex);
                textArea.setSelectionEnd(foundIndex + searchTerm.length());
                textArea.requestFocusInWindow();
                lastSearchIndex = foundIndex;
                lastSearchTerm = searchTerm;
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Text not found", 
                    "Search", JOptionPane.INFORMATION_MESSAGE);
                lastSearchIndex = -1;
            }
        }
    }

    public void replaceDialog() {
        JDialog replaceDialog = new JDialog(parentFrame, "Replace", false);
        replaceDialog.setLayout(new BorderLayout());

        JTextField findField = new JTextField(20);
        JTextField replaceField = new JTextField(20);
        JCheckBox caseSensitiveCheck = new JCheckBox("Case Sensitive");
        JButton replaceButton = new JButton("Replace");
        JButton replaceAllButton = new JButton("Replace All");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Find: "));
        inputPanel.add(findField);
        inputPanel.add(new JLabel("Replace with: "));
        inputPanel.add(replaceField);
        inputPanel.add(caseSensitiveCheck);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(replaceButton);
        buttonPanel.add(replaceAllButton);

        replaceDialog.add(inputPanel, BorderLayout.CENTER);
        replaceDialog.add(buttonPanel, BorderLayout.SOUTH);

        replaceButton.addActionListener(e -> {
            String findText = findField.getText();
            String replaceText = replaceField.getText();
            boolean caseSensitive = caseSensitiveCheck.isSelected();

            if (!findText.isEmpty()) {
                String currentText = textArea.getSelectedText();
                if (currentText != null && 
                    (caseSensitive ? currentText.equals(findText) : 
                     currentText.equalsIgnoreCase(findText))) {
                    textArea.replaceSelection(replaceText);
                } else {
                    performSearch(findText, caseSensitive, true);
                }
            }
        });

        replaceAllButton.addActionListener(e -> {
            String findText = findField.getText();
            String replaceText = replaceField.getText();
            boolean caseSensitive = caseSensitiveCheck.isSelected();

            if (!findText.isEmpty()) {
                String text = textArea.getText();
                String replacedText;
                
                if (caseSensitive) {
                    replacedText = text.replace(findText, replaceText);
                } else {
                    replacedText = text.replaceAll("(?i)" + findText, replaceText);
                }
                
                textArea.setText(replacedText);
            }
        });

        replaceDialog.pack();
        replaceDialog.setLocationRelativeTo(parentFrame);
        replaceDialog.setVisible(true);
    }
}