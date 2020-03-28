package nui.honest.notebook.handle;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.view.FontDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PipedReader;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class StyleMenuAction implements ActionListener {

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "autoWrap":
                autoWrap();
                break;
            case "font":
                font();
                break;
            default:
                break;
        }
    }

    public void font() {
        FontDialog fontDialog = new FontDialog(fileAreaSelect.getFrame(), true);
        fontDialog.setVisible(true);
    }

    public void autoWrap() {
        if (fileAreaSelect.getAutoWrap().isSelected()) {
            fileAreaSelect.getTextArea().setLineWrap(true);
        } else {
            fileAreaSelect.getTextArea().setLineWrap(false);
        }
    }
}
