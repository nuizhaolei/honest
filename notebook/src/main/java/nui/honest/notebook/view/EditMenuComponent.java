package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.common.MenuCommand;
import nui.honest.notebook.common.MenuStyle;
import nui.honest.notebook.handle.EditMenuAction;
import nui.honest.notebook.handle.FileMenuAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class EditMenuComponent {

    private JFrame frame;

    private String name;

    private JTextArea textArea;

    private JMenu editMenu;

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    public JMenu init() {
        editMenu = new JMenu(name);

        JMenuItem cancel = new JMenuItem(MenuCommand.CANCEL_MENU_CH, KeyEvent.VK_U);
        cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        cancel.setActionCommand(MenuCommand.CANCEL_MENU_EN);
        cancel.setEnabled(false);
        fileAreaSelect.setCancel(cancel);
        MenuStyle.common(cancel, frame, textArea, editMenu, EditMenuAction.class);

        editMenu.addSeparator();

        JMenuItem cutting = new JMenuItem(MenuCommand.CUTTING_MENU_CH, KeyEvent.VK_T);
        cutting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        cutting.setActionCommand(MenuCommand.CUTTING_MENU_EN);
        cutting.setEnabled(false);
        fileAreaSelect.setCutting(cutting);
        MenuStyle.common(cutting, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem copy = new JMenuItem(MenuCommand.COPY_MENU_CH, KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.setActionCommand(MenuCommand.COPY_MENU_EN);
        copy.setEnabled(false);
        fileAreaSelect.setCopy(copy);
        MenuStyle.common(copy, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem paste = new JMenuItem(MenuCommand.PASTE_MENU_CH, KeyEvent.VK_P);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        paste.setActionCommand(MenuCommand.PASTE_MENU_EN);
        fileAreaSelect.setPaste(paste);
        MenuStyle.common(paste, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem delete = new JMenuItem(MenuCommand.DELETE_MENU_CH, KeyEvent.VK_L);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        delete.setActionCommand(MenuCommand.DELETE_MENU_EN);
        delete.setEnabled(false);
        fileAreaSelect.setDelete(delete);
        MenuStyle.common(delete, frame, textArea, editMenu, EditMenuAction.class);

        editMenu.addSeparator();

        JMenuItem find = new JMenuItem(MenuCommand.FING_MENU_CH, KeyEvent.VK_F);
        find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        find.setActionCommand(MenuCommand.FING_MENU_EN);
        MenuStyle.common(find, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem findOne = new JMenuItem(MenuCommand.FINGONE_MENU_CH, KeyEvent.VK_F3);
        findOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
        findOne.setActionCommand(MenuCommand.FINGONE_MENU_EN);
        MenuStyle.common(findOne, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem replace = new JMenuItem(MenuCommand.REPLACE_MENU_CH, KeyEvent.VK_R);
        replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        replace.setActionCommand(MenuCommand.REPLACE_MENU_EN);
        MenuStyle.common(replace, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem jump = new JMenuItem(MenuCommand.JUMP_MENU_CH, KeyEvent.VK_G);
        jump.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        jump.setActionCommand(MenuCommand.JUMP_MENU_EN);
        MenuStyle.common(jump, frame, textArea, editMenu, EditMenuAction.class);

        editMenu.addSeparator();

        JMenuItem selectAll = new JMenuItem(MenuCommand.SELECTALL_MENU_CH, KeyEvent.VK_A);
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectAll.setActionCommand(MenuCommand.SELECTALL_MENU_EN);
        MenuStyle.common(selectAll, frame, textArea, editMenu, EditMenuAction.class);

        JMenuItem date = new JMenuItem(MenuCommand.DATE_MENU_CH, KeyEvent.VK_D);
        date.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        date.setActionCommand(MenuCommand.DATE_MENU_EN);
        MenuStyle.common(date, frame, textArea, editMenu, EditMenuAction.class);

        return editMenu;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
