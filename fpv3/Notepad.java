import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Notepad extends JFrame {
    private JTextArea jta;
    private JScrollPane scrollPane;
    private JTextArea lineNumbers;

    public Notepad() {
        Font font = new Font("Inter", Font.PLAIN, 15);
        Container container = getContentPane();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");
        JMenu searchMenu = new JMenu("Search");

        container.setLayout(new BorderLayout());

        // Text Area Setup
        jta = new JTextArea();
        jta.setFont(font);
        jta.setLineWrap(true);

        // Line Numbers Setup
        lineNumbers = new JTextArea("1\n");
        lineNumbers.setBackground(Color.LIGHT_GRAY);
        lineNumbers.setEditable(false);
        lineNumbers.setWrapStyleWord(true);
        lineNumbers.setFont(font);

        // Line Number Manager
        LineNumberManager lineNumberManager = new LineNumberManager(jta, lineNumbers);

        // Scroll Pane Setup
        scrollPane = new JScrollPane(jta);
        scrollPane.setRowHeaderView(lineNumbers);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        container.add(scrollPane);

        // File Menu
        FileMenuHandler fileMenuHandler = new FileMenuHandler(jta, this);
        createMenuItem(fileMenu, "New", fileMenuHandler);
        createMenuItem(fileMenu, "Open", fileMenuHandler);
        createMenuItem(fileMenu, "Save", fileMenuHandler);
        createMenuItem(fileMenu, "Exit", fileMenuHandler);

        // Edit Menu
        EditMenuHandler editMenuHandler = new EditMenuHandler(jta);
        createMenuItem(editMenu, "Cut", editMenuHandler);
        createMenuItem(editMenu, "Copy", editMenuHandler);
        createMenuItem(editMenu, "Paste", editMenuHandler);

        // Help Menu
        HelpMenuHandler helpMenuHandler = new HelpMenuHandler(this);
        createMenuItem(helpMenu, "About Notepad", helpMenuHandler);
        
        // View Menu
        ThemeHandler themeMenuHandler = new ThemeHandler(jta, lineNumbers, scrollPane);
        createMenuItem(viewMenu, "Dark Mode", themeMenuHandler);

        // Search Menu
        SearchHandler searchHandler = new SearchHandler(jta, this);
        createMenuItem(searchMenu, "Find", searchHandler);
        createMenuItem(searchMenu, "Replace", searchHandler);

        
        // Menu Bar Setup
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        menuBar.add(searchMenu);
        
        setJMenuBar(menuBar);
        setIconImage(Toolkit.getDefaultToolkit().getImage("notepad.gif"));
        setSize(500, 500);
        setTitle("Untitled.txt - Notepad");
        setVisible(true);
    }

    private void createMenuItem(JMenu menu, String text, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(listener);
        menu.add(menuItem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Notepad());
    }
}