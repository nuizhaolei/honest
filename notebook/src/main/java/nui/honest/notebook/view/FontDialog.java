package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.common.FormatConversion;
import nui.honest.notebook.listenner.FontItemListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class FontDialog extends JDialog {


    private JTextArea example;
    private List fontKindList;
    private JTextField fontKindText;
    private List fontShapeList;
    private JTextField fontShapeText;
    private List fontSizeList;
    private JTextField fontSizeText;
    private JComboBox jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JButton confirm;
    private JButton cancel;

    private FontItemListener fontItemListener = new FontItemListener();

    /**
     * Creates new form FontDialog
     */
    public FontDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("字体");
        setResizable(false);
        setLocation(parent.getX() + 150, parent.getY() + 150);
        initComponents();
        fontItemListener.setFontDialog(this);
    }

    // 把系统内的字体名称放到字符数组里
    private static String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    public void fontInit() {
        // 添加字体种类列表
        for (int i = 0; i < fontNames.length; i++) {
            fontKindList.add(fontNames[fontNames.length - i - 1]);
        }
        fontKindList.select(0);// 设定开始的选定状态为第一个
        fontKindText.setText(fontKindList.getSelectedItem());

        // 添加字形列表
        fontShapeList.add("常规");
        fontShapeList.add("倾斜");
        fontShapeList.add("粗体");
        fontShapeList.add("粗体 倾斜");
        fontShapeList.select(0);
        fontShapeText.setText(fontShapeList.getSelectedItem());

        // 添加字体大小列表
        for (int i = 8; i < 73; i++) {
            fontSizeList.add(String.valueOf(i));
        }
        fontSizeList.select(4);
        fontSizeText.setText(fontSizeList.getSelectedItem());

        example.setFont(new Font(fontKindList.getSelectedItem(), FormatConversion.conversion(fontShapeList.getSelectedItem()), Integer.parseInt(fontSizeList.getSelectedItem())));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fontKindText = new javax.swing.JTextField();
        fontShapeText = new javax.swing.JTextField();
        fontSizeText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new JScrollPane();
        fontKindList = new List();
        jScrollPane3 = new javax.swing.JScrollPane();
        fontShapeList = new List();
        jScrollPane4 = new javax.swing.JScrollPane();
        fontSizeList = new List();
        jScrollPane5 = new javax.swing.JScrollPane();
        example = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        confirm = new JButton("确定");
        cancel = new JButton("取消");

        confirm.setActionCommand("confirm");
        cancel.setActionCommand("cancel");

        fontItemListener.setExample(example);
        fontItemListener.setFontKindText(fontKindText);
        fontItemListener.setFontShapeText(fontShapeText);
        fontItemListener.setFontSizeText(fontSizeText);

        confirm.addActionListener(fontItemListener);
        cancel.addActionListener(fontItemListener);

        fontInit();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModal(true);
        setName("Form"); // NOI18N

        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setText("字体(F):");

        fontKindText.setName("fontKindText"); // NOI18N

        fontShapeText.setName("fontShapeText"); // NOI18N

        fontSizeText.setName("fontSizeText"); // NOI18N

        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setText("字形(Y):");

        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setText("大小(S):");

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        fontKindList.setName("fontKindList"); // NOI18N
        fontKindList.addItemListener(fontItemListener);
        jScrollPane2.setViewportView(fontKindList);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        fontShapeList.setName("fontShapeList"); // NOI18N
        fontShapeList.addItemListener(fontItemListener);
        jScrollPane3.setViewportView(fontShapeList);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        fontSizeList.setName("fontSizeList"); // NOI18N
        fontSizeList.addItemListener(fontItemListener);
        jScrollPane4.setViewportView(fontSizeList);
        jScrollPane4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        example.setColumns(20);
        example.setRows(5);
        example.setName("example"); // NOI18N
        example.append("AAaaBBbbCCcc");
        example.setForeground(Color.BLACK);
//        example.setEnabled(false);
        jScrollPane5.setViewportView(example);
        jScrollPane5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        jLabel4.setName("jLabel4"); // NOI18N
        jLabel4.setText("示例");

        jLabel5.setName("jLabel5"); // NOI18N
        jLabel5.setText("脚本");

        jComboBox1.setModel(new DefaultComboBoxModel(new String[]{"微软雅黑", "中文"}));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setText("www.baidu.com");
        jLabel6.setFont(new Font("楷书", Font.BOLD + Font.ITALIC, +16));
        jLabel6.setForeground(Color.blue);
        jLabel6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Runtime rt=Runtime.getRuntime();
                try {
                    Process proc=rt.exec("C:\\Users\\Lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe www.baidu.com");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(fontKindText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane3)
                                                                        .addComponent(fontShapeText, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(fontSizeText, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane4)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel5)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(confirm)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancel)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(fontSizeText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(fontShapeText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(fontKindText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirm)
                                        .addComponent(cancel))
                                .addContainerGap()
                        )
        );
        pack();
    }// </editor-fold>

    private void fontKindTextActionPerformed(java.awt.event.ActionEvent evt) {

    }

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
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FontDialog dialog = new FontDialog(new javax.swing.JFrame(), true);
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
    // Variables declaration - do not modify

    // End of variables declaration
}
