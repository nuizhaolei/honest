package nui.honest.notebook.listenner;

import nui.honest.notebook.common.FileAreaSelect;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Lenovo on 2019/11/6.
 */
public class EditMouseListener implements MouseListener {

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    @Override
    public void mouseClicked(MouseEvent e) {
        //鼠标点击事件
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //鼠标按下
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //鼠标松开
        JTextArea textArea = (JTextArea) e.getSource();
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        if (start < end) {
            fileAreaSelect.getCopy().setEnabled(true);
            fileAreaSelect.getCutting().setEnabled(true);
            fileAreaSelect.getDelete().setEnabled(true);
            fileAreaSelect.getPaste().setEnabled(true);
        } else {
            fileAreaSelect.getCopy().setEnabled(false);
            fileAreaSelect.getCutting().setEnabled(false);
            fileAreaSelect.getDelete().setEnabled(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //鼠标进入组件
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //鼠标退出组件
    }
}
