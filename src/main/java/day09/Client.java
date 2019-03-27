package day09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener {
    public Client() {
        initComponent();
    }

    private void initComponent() { // initComponent初始化
        setTitle("MySQL Client"); //左上角名称
        setExtendedState(MAXIMIZED_BOTH); // 窗口最大化
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕尺寸对象
        Font font = new Font("consolas", Font.PLAIN, 24); // 字体

        JPanel main = new JPanel(); // jpanel 面板
        main.setLayout(new BorderLayout()); // 设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
        //若没有指定方位，将添加到中间，上下左右都可以扩展。


        TextArea sqlTextArea = new TextArea();
        sqlTextArea.setPreferredSize(new Dimension(dimension.width, dimension.height / 2));
        sqlTextArea.setFont(font); //字体
        sqlTextArea.setForeground(Color.WHITE); // 字体颜色
        sqlTextArea.setBackground(Color.darkGray); // 背景色

        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(dimension.width, (int) (dimension.getHeight() / 2)));

        north.add(sqlTextArea);

        TextArea outputTextArea = new TextArea();
        outputTextArea.setBackground(Color.WHITE); // 背景色
        outputTextArea.setPreferredSize(new Dimension(dimension.width / 2, dimension.height / 2));
        outputTextArea.setEditable(false); // 文本格式但是不允许写入

    String[] columnNames = {"ID", "USERNAME", "PASSWORD"};
    Object[][] rowData = {
            {1, "Tom", "123"},
            {2, "Jerry", "abc"}
    };

    JTable resultTable = new JTable(rowData, columnNames);
        resultTable.setBackground(Color.RED); // 背景色
        resultTable.setPreferredSize(new Dimension(dimension.width / 2, dimension.height / 2));


    JPanel south = new JPanel();
        south.setLayout(new BorderLayout()); // 设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
        //若没有指定方位，将添加到中间，上下左右都可以扩展。
        south.setBackground(Color.WHITE); // 背景色
        south.setPreferredSize(new Dimension(dimension.width, (int) (dimension.getHeight() / 2)));

        south.add(outputTextArea, BorderLayout.WEST);
        south.add(resultTable, BorderLayout.EAST);

        main.add(north, BorderLayout.NORTH);
        main.add(south, BorderLayout.SOUTH);
    add(main);
    setVisible(true); // 数据模型已经构造好了，允许JVM可以根据数据模型执行paint方法开始画图并显示到屏幕上了，并不是显示图形，而是可以运行开始画图了
}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Client();
    }
}
