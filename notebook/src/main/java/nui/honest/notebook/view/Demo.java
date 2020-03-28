package nui.honest.notebook.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class Demo extends  JFrame{
    public Demo() {
        super("Title");
        NewPanel p = new NewPanel();
        this.getContentPane().add(p); // 将面板添加到JFrame上
        this.setSize(596, 298); // 初始窗口的大小
        this.setLocationRelativeTo(null); // 设置窗口居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }

    class NewPanel extends JPanel {
        public NewPanel() {

        }

        public void paintComponent(Graphics g) {
            int x = 0, y = 0;
            ImageIcon icon = new ImageIcon("notebook/icon/meinv.jpg");// 003.jpg是测试图片在项目的根目录下
            g.drawImage(icon.getImage(), x, y, getSize().width,
                    getSize().height, this);// 图片会自动缩放
//    g.drawImage(icon.getImage(), x, y,this);//图片不会自动缩放
        }
    }
}
