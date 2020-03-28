package nui.honest.notebook.listenner;

import nui.honest.notebook.view.HelpJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class HeplListener implements ActionListener {

    private HelpJDialog helpJDialog;

    public HeplListener(HelpJDialog helpJDialog) {
        this.helpJDialog = helpJDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "s":
                JOptionPane.showMessageDialog(null,"你真好","提示",3);
                helpJDialog.dispose();
                break;
            case "f":
                JOptionPane.showMessageDialog(null,"你丑，你走开","提示",3);
                this.helpJDialog.dispose();
                break;
            case "cancel":
                JOptionPane.showMessageDialog(null,"虚伪","提示",3);
                this.helpJDialog.dispose();
                break;
            default:
                break;
        }
    }
}
