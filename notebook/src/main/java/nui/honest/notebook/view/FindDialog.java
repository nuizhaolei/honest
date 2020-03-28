package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FindDialog extends JDialog implements ActionListener {

    private JButton cancelBtn;
    private JCheckBox distinguish;
    private JRadioButton down;
    private JButton findBtn;
    private JEditorPane jEditorPane1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JRadioButton up;
    private ButtonGroup group;

    public FindDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(false);
        this.setTitle("查找");
        this.setLocationRelativeTo(FileAreaSelect.singleton().getFrame());
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel("查找内容(N)");
        jScrollPane1 = new JScrollPane();
        jEditorPane1 = new JEditorPane();
        jEditorPane1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String input = jEditorPane1.getText();
                if (null != input && input.trim().length() > 0) {
                    findBtn.setEnabled(true);
                }
            }
        });
        findBtn = new JButton("查找下一个(F)");
        findBtn.setEnabled(false);
        distinguish = new JCheckBox("区分大小写(C)");
        jLabel2 = new JLabel("方向");
        down = new JRadioButton("向下(D)");
        up = new JRadioButton("向上(U)");
        cancelBtn = new JButton("取消");
        group = new ButtonGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jEditorPane1.setName("jEditorPane1"); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        findBtn.setName("findBtn"); // NOI18N
        findBtn.setActionCommand("find");
        findBtn.addActionListener(this);

        distinguish.setName("distinguish"); // NOI18N

        jLabel2.setName("jLabel2"); // NOI18N

        down.setName("down"); // NOI18N
        down.setSelected(true);

        up.setName("up"); // NOI18N

        group.add(down);
        group.add(up);

        cancelBtn.setName("cancelBtn"); // NOI18N
        cancelBtn.setActionCommand("cancel");
        cancelBtn.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(distinguish)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(up)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(down))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addComponent(jLabel2)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(findBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(findBtn)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(up)
                                                        .addComponent(distinguish)))
                                        .addComponent(cancelBtn))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "find":
                find();
                break;
            case "cancel":
                this.dispose();
                break;
            default:
                break;
        }
    }

    private void find() {
        String input = jEditorPane1.getText();
        FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();
        fileAreaSelect.setFindInput(input);
        String textArea = fileAreaSelect.getTextArea().getText();
        int selectEnd = fileAreaSelect.getTextArea().getSelectionEnd();
        if (!distinguish.isSelected()) {
            input = input.toLowerCase();
            textArea = textArea.toLowerCase();
        }
        if (up.isSelected()) {
            int x = textArea.lastIndexOf(input, selectEnd - input.length() - 1);
            if (x == -1) {
                JOptionPane.showMessageDialog(null, "找不到 " + input, "记事本", 1);
            } else {
                fileAreaSelect.getTextArea().setSelectionStart(x);
                fileAreaSelect.getTextArea().setSelectionEnd(x + input.length());
            }
        } else {
            int x = textArea.indexOf(input, selectEnd);
            if (x == -1) {
                JOptionPane.showMessageDialog(null, "找不到 " + input, "记事本", 1);
            } else {
                fileAreaSelect.getTextArea().setSelectionStart(x);
                fileAreaSelect.getTextArea().setSelectionEnd(x + input.length());
            }
        }
    }
}
