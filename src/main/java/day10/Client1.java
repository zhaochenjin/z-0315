package day10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Client1 extends JFrame {

    private JTextArea sqlJTextArea, outputJTextArea;
    private JTable resultJTable;
    static DefaultTableModel defaultTableModel;
    private Server server;


    private Client1(){
    initComponent();
    initListener();
    server=new Server();
}

    private void initComponent() {
//        1. 全局设置
        setTitle("MySQL Client"); //名称
        setExtendedState(MAXIMIZED_BOTH); // 最大化窗口
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕尺寸对象
        int width = dimension.width;
        int height = dimension.height;
        Font font = new Font("consolas", Font.PLAIN, 24); // 字体

//        2. SQL    输入信息的
        sqlJTextArea = new JTextArea();
        sqlJTextArea.setBackground(Color.darkGray);
        sqlJTextArea.setForeground(Color.WHITE); // 字体颜色
        sqlJTextArea.setFont(font);
        sqlJTextArea.setCaretColor(Color.WHITE); // 光标颜色
        sqlJTextArea.setCaretPosition(sqlJTextArea.getDocument().getLength()); // 设置光标

        JScrollPane sqlJScrollPane = new JScrollPane(sqlJTextArea);
        sqlJScrollPane.setPreferredSize(new Dimension(width, height / 2));

//       3.output
        outputJTextArea = new JTextArea();
        outputJTextArea.setBackground(Color.WHITE);
        outputJTextArea.setFont(font);
        outputJTextArea.setEditable(false);// 不可输入信息

        JScrollPane outputJScrollPane = new JScrollPane(outputJTextArea);
        outputJScrollPane.setPreferredSize(new Dimension(width / 2, (int) (height / 2.5)));
//        4. result
        String[] columnsNames = {
                "ID",
                "USERNAME",
                "PASSWORD"
        };
        String[][] data = {
                {"1", "Tom", "123"},
                {"2", "Jerry", "abc"}
        };
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnsNames);

        JTable resultJTable = new JTable(defaultTableModel);
        resultJTable.setBackground(Color.WHITE);
        resultJTable.setFont(font);
        resultJTable.getTableHeader().setFont(font);
        resultJTable.setRowHeight(30);

        JScrollPane resultJScrollPane = new JScrollPane(resultJTable);
        resultJScrollPane.setPreferredSize(new Dimension(width / 2, (int) (height / 2.5)));

        JPanel southJPanel = new JPanel();
        southJPanel.setLayout(new BorderLayout());
        southJPanel.setPreferredSize(new Dimension(width, (int) (height / 2.5)));

        southJPanel.add(outputJScrollPane, BorderLayout.WEST);
        southJPanel.add(resultJScrollPane, BorderLayout.EAST);

        //5.main
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        main.add(sqlJScrollPane,BorderLayout.NORTH);
        main.add(southJPanel,BorderLayout.SOUTH);

        //6.show
        add(main);
        setVisible(true);
}

 // 初始化监听器
private void initListener(){
    // shortcut
    KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
    sqlJTextArea.getInputMap().put(keyStroke, "Execute");
    sqlJTextArea.getActionMap().put("Execute", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = sqlJTextArea.getSelectedText();
            String output = server.dispatch(sql);
            if (output != null) {
                outputJTextArea.append(output + "\n");
            }
            if (defaultTableModel != null) {
                resultJTable.setModel(defaultTableModel);
                TableColumnAdjuster tableColumnAdjuster = new TableColumnAdjuster(resultJTable);
                tableColumnAdjuster.adjustColumns();
            }
        }
    });
}

    public static void main(String[] args) {
        new Client1();

    }
}