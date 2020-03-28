package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceDialog extends JDialog implements ActionListener {

    private JButton cancel;
    private JCheckBox distinguish;
    private JEditorPane findEdit;
    private JLabel findInput;
    private JButton findNext;
    private JScrollPane findScrollPane;
    private JButton replace;
    private JButton replaceAll;
    private JEditorPane replaceEdit;
    private JLabel replaceInput;
    private JScrollPane replaceScrollPane;

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    public ReplaceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(false);
        this.setTitle("替换");
        this.setLocationRelativeTo(FileAreaSelect.singleton().getFrame());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        findInput = new javax.swing.JLabel();
        replaceInput = new javax.swing.JLabel();
        findScrollPane = new javax.swing.JScrollPane();
        findEdit = new javax.swing.JEditorPane();
        replaceScrollPane = new javax.swing.JScrollPane();
        replaceEdit = new javax.swing.JEditorPane();
        findNext = new javax.swing.JButton();
        replace = new javax.swing.JButton();
        replaceAll = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        distinguish = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        findInput.setName("findInput"); // NOI18N
        findInput.setText("查找内容(N)");

        replaceInput.setName("replaceInput"); // NOI18N
        replaceInput.setText("替换为(P)");

        findScrollPane.setName("findScrollPane"); // NOI18N

        findEdit.setName("findEdit"); // NOI18N
        findScrollPane.setViewportView(findEdit);

        replaceScrollPane.setName("replaceScrollPane"); // NOI18N

        replaceEdit.setName("replaceEdit"); // NOI18N
        replaceScrollPane.setViewportView(replaceEdit);

        findNext.setName("findNext"); // NOI18N
        findNext.setText("查找下一个(N)");
        findNext.setActionCommand("findNext");
        findNext.addActionListener(this);

        replace.setName("replace"); // NOI18N
        replace.setText("替换(R)");
        replace.setActionCommand("replace");
        replace.addActionListener(this);

        replaceAll.setName("replaceAll"); // NOI18N
        replaceAll.setText("全部替换(A)");
        replaceAll.setActionCommand("replaceAll");
        replaceAll.addActionListener(this);

        cancel.setName("cancel"); // NOI18N
        cancel.setText("取消");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);

        distinguish.setName("distinguish"); // NOI18N
        distinguish.setText("区分大小写");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(replaceInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(findInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(replaceScrollPane)
                                                        .addComponent(findScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(distinguish, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(replaceAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(replace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(findNext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(findNext)
                                        .addComponent(findScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(findInput))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(replace)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(replaceAll)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cancel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(replaceInput)
                                                        .addComponent(replaceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(distinguish)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ReplaceDialog dialog = new ReplaceDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "findNext":
                findNext();
                break;
            case "replace":
                replace();
                break;
            case "replaceAll":
                replaceALL();
                break;
            case "cancel":
                break;
            default:
                break;
        }
    }

    public void replaceALL() {
        String findInput = findEdit.getText();
        String replaceInput = replaceEdit.getText();
        String areaStr = fileAreaSelect.getTextArea().getText();
        int index = areaStr.indexOf(findInput);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "找不到 " + findInput, "记事本", 1);
            return;
        }
        areaStr = areaStr.replace(findInput, replaceInput);
        fileAreaSelect.getTextArea().setText(areaStr);
    }

    public void replace() {
        String findInput = findEdit.getText();
        String replaceInput = replaceEdit.getText();
        int index = findNext();
        if (index == -1) {
            return;
        }
        fileAreaSelect.getTextArea().replaceRange(replaceInput, index, index + findInput.length());
    }

    public int findNext() {
        String findInput = findEdit.getText();
        String areaStr = fileAreaSelect.getTextArea().getText();
        int position = fileAreaSelect.getTextArea().getSelectionEnd();
        int index = areaStr.indexOf(findInput, position);
        if (index != -1) {
            fileAreaSelect.getTextArea().setSelectionStart(index);
            fileAreaSelect.getTextArea().setSelectionEnd(index + findInput.length());
        } else {
            JOptionPane.showMessageDialog(null, "找不到 " + findInput, "记事本", 1);
        }
        return index;
    }

}
