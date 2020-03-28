package nui.honest.notebook.view;

import nui.honest.notebook.common.MenuCommand;
import nui.honest.notebook.common.MenuStyle;
import nui.honest.notebook.handle.FileMenuAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class FileMenuComponent {

    private String name;

    private JFrame frame;

    private JMenu fileMenu;

    private JTextArea textArea;

    public JMenu init() {
        fileMenu = new JMenu("文件(F)");

        JMenuItem newItem = new JMenuItem("新建(N)", KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newItem.setActionCommand(MenuCommand.NEW_MENU);
        MenuStyle.common(newItem, frame, textArea, fileMenu, FileMenuAction.class);

        JMenuItem openItem = new JMenuItem("打开(O)", KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openItem.setActionCommand(MenuCommand.OPEN_MENU);
        MenuStyle.common(openItem, frame, textArea, fileMenu, FileMenuAction.class);

        JMenuItem saveItem = new JMenuItem("保存(S)", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.setActionCommand(MenuCommand.SAVE_MENU);
        MenuStyle.common(saveItem, frame, textArea, fileMenu, FileMenuAction.class);

        JMenuItem asSaveItem = new JMenuItem("另存为(A)", KeyEvent.VK_S);
        asSaveItem.setActionCommand(MenuCommand.ASSAVE_MENU);
        MenuStyle.common(asSaveItem, frame, textArea, fileMenu, FileMenuAction.class);

        fileMenu.addSeparator();

        JMenuItem item1 = new JMenuItem("页面设置(U)", KeyEvent.VK_S);
        MenuStyle.common(item1, frame, textArea, fileMenu, FileMenuAction.class);

        JMenuItem item2 = new JMenuItem("打印(P)", KeyEvent.VK_P);
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        MenuStyle.common(item2, frame, textArea, fileMenu, FileMenuAction.class);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("退出(X)", KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        exitItem.setActionCommand(MenuCommand.EXIT_MENU);
        MenuStyle.common(exitItem, frame, textArea, fileMenu, FileMenuAction.class);

        return fileMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
