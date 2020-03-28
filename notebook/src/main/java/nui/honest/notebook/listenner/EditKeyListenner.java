package nui.honest.notebook.listenner;

import nui.honest.notebook.common.FileAreaSelect;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Lenovo on 2019/11/6.
 */
public class EditKeyListenner implements KeyListener {

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        fileAreaSelect.getCancel().setEnabled(true);
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Z) {
            if (fileAreaSelect.getUndo().canUndo()) {
                fileAreaSelect.getUndo().undo();
            }
        }
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Y) {
            if (fileAreaSelect.getUndo().canRedo()) {
                fileAreaSelect.getUndo().redo();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        JCheckBox checkBox = fileAreaSelect.getCheckBox();
//        if (checkBox.isSelected()) {
//            int count = fileAreaSelect.getTextArea().getColumns();
//            int pos = fileAreaSelect.getTextArea().getCaretPosition();
//            if (count == pos) {
//                fileAreaSelect.getTextArea().append("\n");
//            }
//        }
    }
}
