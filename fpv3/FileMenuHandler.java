import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FileMenuHandler implements ActionListener {
    private JTextArea textArea;
    private JFrame parentFrame;
    private File currentFile;

    public FileMenuHandler(JTextArea textArea, JFrame parentFrame) {
        this.textArea = textArea;
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        switch (e.getActionCommand()) {
            case "New":
                handleNewFile();
                break;
            case "Open":
                handleOpenFile(fileChooser);
                break;
            case "Save":
                handleSaveFile(fileChooser);
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    private void handleNewFile() {
        textArea.setText("");
        parentFrame.setTitle("Untitled.txt - Notepad");
        currentFile = null;
    }

    private void handleOpenFile(JFileChooser fileChooser) {
        int openResult = fileChooser.showDialog(parentFrame, "Open");
        if (openResult == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                openFile(file.getAbsolutePath());
                parentFrame.setTitle(file.getName() + " - Notepad");
                currentFile = file;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error opening file: " + ex.getMessage());
            }
        }
    }

    private void handleSaveFile(JFileChooser fileChooser) {
        if (currentFile != null) {
            fileChooser.setSelectedFile(currentFile);
        } else {
            fileChooser.setSelectedFile(new File("Untitled.txt"));
        }

        int saveResult = fileChooser.showSaveDialog(parentFrame);
        if (saveResult == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                saveFile(file.getAbsolutePath());
                parentFrame.setTitle(file.getName() + " - Notepad");
                currentFile = file;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Error saving file: " + ex.getMessage());
            }
        }
    }

    private void openFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        }
    }

    private void saveFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(textArea.getText());
        }
    }
}
