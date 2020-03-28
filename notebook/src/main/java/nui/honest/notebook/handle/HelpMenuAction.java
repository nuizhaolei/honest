package nui.honest.notebook.handle;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.view.HelpJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class HelpMenuAction extends BaseMenuAction {

    private HelpJDialog helpJDialog;

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    @Override
    public void actionPerformed(ActionEvent e) {
        //HelpJDialog
        JMenuItem item = (JMenuItem) e.getSource();
        String command = item.getText();
        switch (command) {
            case "关于帮助":
                help();
                break;
            case "关于记事本":
                break;
            default:
                break;
        }
    }

    private void help() {
        helpJDialog = new HelpJDialog(fileAreaSelect.getFrame(), false);
        helpJDialog.setVisible(true);
    }
}
