package nui.honest.notebook.common;

import nui.honest.notebook.handle.BaseMenuAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class MenuStyle {

    public static void common(JMenuItem item, JFrame frame, JTextArea textArea, JMenu menu, Class clazz) {
        try {
            BaseMenuAction action = (BaseMenuAction) clazz.newInstance();
            action.setFrame(frame);
            action.setTextArea(textArea);
            item.addActionListener(action);
            item.setBorder(new EmptyBorder(5, 20, 5, 0));
            item.setUI(new MyMenuItemUI(new Color(200, 200, 200), new Color(240, 240, 240)));
            menu.add(item);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class MyMenuItemUI extends BasicMenuItemUI {
        public MyMenuItemUI(Color bgColor, Color fgColor) {
            super.selectionBackground = bgColor;
            super.selectionForeground = fgColor;
        }
    }
}
