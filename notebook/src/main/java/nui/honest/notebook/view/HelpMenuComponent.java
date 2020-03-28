package nui.honest.notebook.view;

import nui.honest.notebook.common.MenuStyle;
import nui.honest.notebook.handle.HelpMenuAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.PublicKey;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class HelpMenuComponent {

    public JMenu init(String name) {
        JMenu menu = new JMenu(name);

        JMenuItem help = new JMenuItem("关于帮助");
        MenuStyle.common(help, null, null, menu, HelpMenuAction.class);

        JMenuItem notebook = new JMenuItem("关于记事本");
        MenuStyle.common(notebook, null, null, menu, HelpMenuAction.class);
        notebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        return menu;
    }

    public void open() {
        Runtime rt=Runtime.getRuntime();
        try {
            Process proc=rt.exec("C:\\Users\\Lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe www.baidu.com");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
