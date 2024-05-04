import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class SolverGUI {
    private static HashSet<String> words;
    private static JFrame frame;
    private static JTextField startWordField;
    private static JTextField endWordField;
    private static JTable resultTable;
    private static DefaultTableModel model;

    public static void run(HashSet<String> dictionary) {
        words = dictionary;
        SwingUtilities.invokeLater(SolverGUI::initializeGUI);
    }

    private static void initializeGUI() {
        frame = new JFrame("Word Ladder Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().setBackground(Color.WHITE);

        frame.add(createWordPanel("Enter start word: ", startWordField = new JTextField(15)));
        frame.add(createWordPanel("Enter end word: ", endWordField = new JTextField(15)));
        frame.add(createButtonsPanel());
        setupResultTable();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createWordPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    private static JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.add(createButton("Search A*", "ASTAR"));
        panel.add(createButton("Search UCS", "UCS"));
        panel.add(createButton("Search GBFS", "GBFS"));
        return panel;
    }

    private static JButton createButton(String buttonText, String method) {
        JButton button = new JButton(buttonText);
        button.addActionListener(e -> performSearch(method));
        styleButton(button);
        return button;
    }

    private static void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 156, 240));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.BLACK);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 156, 222));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 156, 240));
            }
        });
    }

    private static void setupResultTable() {
        model = new DefaultTableModel();
        model.addColumn("Step");
        model.addColumn("Word");
        resultTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        customizeTableLook();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setPreferredSize(new Dimension(580, 200));
        frame.add(scrollPane);
    }

    private static void customizeTableLook() {
        resultTable.setFont(new Font("Arial", Font.PLAIN, 12));
        resultTable.setRowHeight(20);
        resultTable.setFillsViewportHeight(true);
        resultTable.setBackground(Color.WHITE);
        resultTable.setGridColor(Color.WHITE);
        JTableHeader tableHeader = resultTable.getTableHeader();
        tableHeader.setBackground(Color.WHITE);
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        resultTable.setDefaultRenderer(Object.class, centerRenderer);
    }

    private static void performSearch(String algorithm) {
        String startWord = startWordField.getText().toLowerCase().strip();
        String endWord = endWordField.getText().toLowerCase().strip();
        if (startWord == "" || endWord == "") {
            JOptionPane.showMessageDialog(frame, "Error: Please fill the blanks before searching.");
            return;
        }

        if (!isValidWord(startWord) || !isValidWord(endWord)) {
            JOptionPane.showMessageDialog(frame, "Error: One or both words are not valid English words.");
            return;
        }

        if (startWord.length() != endWord.length()) {
            JOptionPane.showMessageDialog(frame, "Error: Words have different lengths");
            return;
        }

        AlgoResult searchResult = Algorithm.search(startWord, endWord, algorithm, words);
        updateResultTable(searchResult);
    }

    private static boolean isValidWord(String word) {
        return words.contains(word);
    }

    private static void updateResultTable(AlgoResult searchResult) {
        model.setRowCount(0);
        int step = 1;
        for (String word : searchResult.getPath()) {
            model.addRow(new Object[]{step++, word.toUpperCase()});
        }
        model.addRow(new Object[]{"Execution Time (ms)", searchResult.getExecutionTime()});
        model.addRow(new Object[]{"Words Checked", searchResult.getNodeVisited()});
        
        for (int i = 0; i < model.getColumnCount(); i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            resultTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}
