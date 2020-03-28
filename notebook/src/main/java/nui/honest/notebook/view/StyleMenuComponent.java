package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.handle.StyleMenuAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Lenovo on 2019/11/6.
 */
public class StyleMenuComponent {

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    private JMenu styleMenu;

    public JMenu init() {
        styleMenu = new JMenu("格式(O)");
        final JCheckBox autoWrap = new JCheckBox("自动换行(W)");
        autoWrap.setBorder(new EmptyBorder(5, 5, 5, 0));
        autoWrap.setActionCommand("autoWrap");
        autoWrap.addActionListener(new StyleMenuAction());
        fileAreaSelect.setAutoWrap(autoWrap);
        styleMenu.add(autoWrap);

        JMenuItem font = new JMenuItem("字体(F)...");
        font.setBorder(new EmptyBorder(5, 20, 5, 0));
        font.addActionListener(new StyleMenuAction());
        font.setActionCommand("font");
        styleMenu.add(font);
        return styleMenu;
    }
}
