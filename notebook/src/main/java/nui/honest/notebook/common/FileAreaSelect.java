package nui.honest.notebook.common;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.io.PipedReader;
import java.io.Serializable;

/**
 * Created by Lenovo on 2019/11/6.
 */
public class FileAreaSelect implements Serializable {

    private UndoManager undo = new UndoManager();

    private JFrame frame;

    private JTextArea textArea;

    private JMenuItem cancel;

    private JMenuItem cutting;

    private JMenuItem copy;

    private JMenuItem paste;

    private  JMenuItem delete;

    private String findInput;

    private JCheckBox autoWrap;

    private static FileAreaSelect fileAreaSelect;

    private FileAreaSelect() {
    }

    public synchronized static FileAreaSelect singleton() {
        if (fileAreaSelect == null) {
            fileAreaSelect = new FileAreaSelect();
        }
        return fileAreaSelect;
    }

    public UndoManager getUndo() {
        return undo;
    }

    public JMenuItem getCancel() {
        return cancel;
    }

    public void setCancel(JMenuItem cancel) {
        this.cancel = cancel;
    }

    public JMenuItem getCutting() {
        return cutting;
    }

    public void setCutting(JMenuItem cutting) {
        this.cutting = cutting;
    }

    public JMenuItem getCopy() {
        return copy;
    }

    public void setCopy(JMenuItem copy) {
        this.copy = copy;
    }

    public JMenuItem getPaste() {
        return paste;
    }

    public void setPaste(JMenuItem paste) {
        this.paste = paste;
    }

    public JMenuItem getDelete() {
        return delete;
    }

    public void setDelete(JMenuItem delete) {
        this.delete = delete;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public String getFindInput() {
        return findInput;
    }

    public void setFindInput(String findInput) {
        this.findInput = findInput;
    }

    public JCheckBox getAutoWrap() {
        return autoWrap;
    }

    public void setAutoWrap(JCheckBox autoWrap) {
        this.autoWrap = autoWrap;
    }

}
