package nui.honest.notebook.view;

import nui.honest.notebook.listenner.HeplListener;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class HelpJDialog extends javax.swing.JDialog {


    private javax.swing.JButton cancel;
    private javax.swing.JButton f;
    private javax.swing.JPanel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton s;

    /**
     * Creates new form HelpJDialog
     */
    public HelpJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JPanel();
        s = new javax.swing.JButton();
        f = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setText("我是大美妞？");

        image.setName("image"); // NOI18N

        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
        image.setLayout(imageLayout);
        imageLayout.setHorizontalGroup(
                imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 280, Short.MAX_VALUE)
        );
        imageLayout.setVerticalGroup(
                imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 140, Short.MAX_VALUE)
        );

        image.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                paintComponent(image);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });

        s.setName("s"); // NOI18N
        s.setText("是");
        s.setActionCommand("s");
        s.addActionListener(new HeplListener(this));

        f.setName("f"); // NOI18N
        f.setText("否");
        f.setActionCommand("f");
        f.addActionListener(new HeplListener(this));

        cancel.setName("cancel"); // NOI18N
        cancel.setText("取消");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(new HeplListener(this));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(s)
                                                        .addGap(14, 14, 14)
                                                        .addComponent(f)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cancel))
                                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel)
                                        .addComponent(s)
                                        .addComponent(f))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    public void paintComponent(JPanel panel) {
        int x = 0, y = 0;
        // 003.jpg是测试图片在项目的根目录下
        ImageIcon icon = new ImageIcon("notebook/icon/meinv.jpg");
        // 图片会自动缩放
        panel.getGraphics().drawImage(icon.getImage(), x, y, panel.getSize().width,
                panel.getSize().height, panel);
    }


}
