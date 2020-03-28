package nui.honest.notebook.handle;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.common.MenuCommand;
import nui.honest.notebook.view.FindDialog;
import nui.honest.notebook.view.ReplaceDialog;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class EditMenuAction extends BaseMenuAction {

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    private UndoManager undo;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case MenuCommand.CANCEL_MENU_EN:
                cancel(e);
                break;
            case MenuCommand.COPY_MENU_EN:
                copy();
                break;
            case MenuCommand.PASTE_MENU_EN:
                paste();
                break;
            case MenuCommand.CUTTING_MENU_EN:
                cutting();
                break;
            case MenuCommand.DELETE_MENU_EN:
                delete();
                break;
            case MenuCommand.DATE_MENU_EN:
                date();
                break;
            case MenuCommand.SELECTALL_MENU_EN:
                selectAll();
                break;
            case MenuCommand.FING_MENU_EN:
                find();
            case MenuCommand.FINGONE_MENU_EN:
                findOne();
                break;
            case MenuCommand.REPLACE_MENU_EN:
                replace();
                break;
            default:
                break;
        }
    }

    public void date() {
        //19:02 2019/11/6
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm YYYY/MM/dd");
        int pos = fileAreaSelect.getTextArea().getCaretPosition();
        String date = sdf.format(new Date());
        fileAreaSelect.getTextArea().insert(date, pos);
    }

    public void selectAll() {
        int start = 0;
        int end = fileAreaSelect.getTextArea().getText().length();
        fileAreaSelect.getTextArea().setSelectionStart(start);
        fileAreaSelect.getTextArea().setSelectionEnd(end);
    }

    /**
     * 替换
     * ReplaceDialog
     */
    public void replace() {
        ReplaceDialog replaceDialog = new ReplaceDialog(frame, false);
        replaceDialog.setVisible(true);
    }

    /**
     * 查找下一个
     */
    public void findOne() {
        int select = fileAreaSelect.getTextArea().getSelectionEnd();
        if (null == fileAreaSelect.getFindInput() || fileAreaSelect.getFindInput().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "找不到 ", "记事本", 1);
        }
        int x = fileAreaSelect.getTextArea().getText().indexOf(fileAreaSelect.getFindInput(), select);
        if (x != -1) {
            fileAreaSelect.getTextArea().setSelectionStart(x);
            fileAreaSelect.getTextArea().setSelectionEnd(x + fileAreaSelect.getFindInput().length());
        } else {
            JOptionPane.showMessageDialog(null, "找不到 " + fileAreaSelect.getFindInput(), "记事本", 1);
        }
    }

    /**
     * 查找
     */
    public void find() {
        Dialog findDialog = new FindDialog(frame, false);
        findDialog.setVisible(true);
    }

    /**
     * 删除
     */
    public void delete() {
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        textArea.replaceRange("", start, end);
    }

    /**
     * 黏贴
     */
    public void paste() {
        textArea.paste();
    }

    /**
     * 拷贝
     */
    public void copy() {
        textArea.copy();
    }

    /**
     * 剪切
     */
    public void cutting() {
        textArea.cut();
    }

    /**
     * 撤销
     */
    public void cancel(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        undo = fileAreaSelect.getUndo();

        if (undo.canUndo()) {
            item.setEnabled(true);
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            if (!undo.canUndo()) {
                item.setEnabled(false);
            }
        }
    }

}
