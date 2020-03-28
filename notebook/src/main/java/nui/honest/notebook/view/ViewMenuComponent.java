package nui.honest.notebook.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class ViewMenuComponent {


    public JMenu init(String name) {
        JMenu jMenu = new JMenu(name);
        JMenuItem item = new JMenuItem("状态栏(S)");
        item.setBorder(new EmptyBorder(5, 20, 5, 0));
        item.setUI(new MyMenuItemUI(new Color(200, 200, 200), new Color(240, 240, 240)));
        item.setEnabled(false);
        jMenu.add(item);
        return jMenu;
    }

    static class MyMenuItemUI extends BasicMenuItemUI {
        public MyMenuItemUI(Color bgColor, Color fgColor) {
            super.selectionBackground = bgColor;
            super.selectionForeground = fgColor;
        }
    }

}
