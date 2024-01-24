import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.table.*;
public class FilterTableTest extends JFrame {
    private JTable table;
    private TableModel model;
    public FilterTableTest() {
        setTitle("FilterTable Test");
        Object rows[][] = {{"Tấm lòng son", "Thương cho tấm thân cơ hàn", "https://youtu.be/ZcZHva1NYSE"}, {"Thu cuối", "Cho bao nhiêu yêu thương nay bay xa\n" +
                "Hoen đôi mi khi thu đưa em qua\n" +
                "Đã từng ngọt ngào giờ nhận đắng cay vì anh\n" +
                "Huh oh\n" +
                "Thu vờn tóc em mơn man bên làn gió\n" +
                "Vương trên mi ai lá rụng con phố nhỏ\n" +
                "(Vương đâu đây chút hương hoa sữa)\n" +
                "Nhẹ nhàng đâu đây mùi hương hoa sữa đó hoh yeah","https://youtu.be/6KH8eqKlohA"},  {"Chaitanya", "Java Engineer", 45000}, {"Ramesh", "Scala Developer", 40000}, {"Ravi", "SAP  Consultant", 70000}};
        Object columns[] = {"Tên bài hát", "Lời bài hát", "Link"};
        model = new DefaultTableModel(rows, columns) {
            public Class getColumnClass(int column) {
                Class returnValue;
                if((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        table = new JTable(model);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Filter");
        panel.add(label, BorderLayout.WEST);
        final JTextField filterText = new JTextField("");
        panel.add(filterText, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        JButton button = new JButton("Filter");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if(text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch(PatternSyntaxException pse) {
                        System.out.println("Bad regex pattern");
                    }
                }
            }
        });
        add(button, BorderLayout.SOUTH);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[]) {
        new FilterTableTest();
    }
}

