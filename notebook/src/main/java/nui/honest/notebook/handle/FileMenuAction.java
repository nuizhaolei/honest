package nui.honest.notebook.handle;

import nui.honest.notebook.common.MenuCommand;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class FileMenuAction extends BaseMenuAction implements ActionListener {

    private static String dir;

    private static String name;

    private FileDialog file;

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case MenuCommand.NEW_MENU:
                create();
                break;
            case MenuCommand.OPEN_MENU:
                open();
                break;
            case MenuCommand.ASSAVE_MENU:
                saveAndasSave(MenuCommand.ASSAVE_MENU_CH);
                break;
            case MenuCommand.SAVE_MENU:
                saveAndasSave(MenuCommand.SAVE_MENU_CH);
                break;
            case MenuCommand.EXIT_MENU:
                exit();
                break;
            default:
                break;
        }
    }

    /**
     * 新建
     */
    public void create() {
        frame.setTitle("无标题- 记事本");
        textArea.setText("");
    }

    /**
     * 退出
     */
    public void exit() {
        String textAreaContent = solveWrap();
        String fileContent = readFile();
        if (textAreaContent.equals(fileContent)) {
            return;
        }
        String[] buttons = {"保存", "不保存", "取消"};
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        String filePath = null;
        if (dir != null && name != null) {
            filePath = "是否将更改保存到" + dir + File.separator + name + "?";
        } else {
            filePath = "是否将更改保存?";
        }
        JLabel label = new JLabel(filePath);
        label.setFont(new Font("宋体", Font.BOLD, 16));
        label.setForeground(new Color(95, 122, 180));
        panel.setBorder(new EmptyBorder(0, 10, 10, 10));
        panel.add(label, BorderLayout.WEST);

        JOptionPane myOptionPane = new JOptionPane(panel,
                JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, null, buttons,
                buttons[2]) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(350, 100);
            }
        };
        myOptionPane.setSize(new Dimension(200, 50));
        //myOptionPane.setBackground(Color.white);
        myOptionPane.setBorder(new EmptyBorder(0, 0, 10, 0));
        JDialog myDialog = myOptionPane.createDialog(null, "记事本");
        myDialog.setModal(true);

        inactivateOption(myDialog, buttons[1]);

        myDialog.setVisible(true);
        String result = (String) myOptionPane.getValue();
        switch (result) {
            case "保存":
                saveAndasSave(MenuCommand.SAVE_MENU_CH);
                break;
            case "不保存":
                System.exit(0);
                break;
            case "取消":
                break;
            default:
                break;
        }

    }

    private static void inactivateOption(Container container, String text) {
        Component[] comps = container.getComponents();
        for (Component comp : comps) {
            if (comp instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) comp;
                if (btn.getActionCommand().equals(text)) {
                    btn.setEnabled(true);
                    return;
                }
            } else if (comp instanceof Container) {
                inactivateOption((Container) comp, text);
            }
        }
    }

    public String readFile() {
        StringBuilder sb = new StringBuilder();
        if (dir == null || name == null) {
            return null;
        }
        readFile(sb);
        return sb.toString();
    }

    private void readFile(StringBuilder sb) {
        if (dir == null || name == null) {
            System.out.println("no choose file");
            return;
        }
        File temp = new File(dir, name);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(temp);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null) {
                if (sb != null) {
                    sb.append(str + "\n");
                } else {
                    textArea.append(str + "\n");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 保存和另存为
     */
    public void saveAndasSave(String condition) {
        if (dir == null || name == null || MenuCommand.ASSAVE_MENU_CH.equals(condition)) {
            String title = MenuCommand.ASSAVE_MENU_CH.equals(condition) ? MenuCommand.ASSAVE_MENU_CH : MenuCommand.SAVE_MENU_CH;
            file = new FileDialog(frame, title, FileDialog.SAVE);
            file.setFile("*.txt");
            file.setVisible(true);
            // 得到现在的目录
            dir = file.getDirectory();
            // 得到选择文件的文件名
            name = file.getFile();
        }
        File newFile = new File(dir, name);
        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            fos = new FileOutputStream(newFile);
            pw = new PrintWriter(fos);
            String content = solveWrap();
            pw.write(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 解决在Windows系统下或其他系统下的记事本无法显示换行问题
    public String solveWrap() {
        JTextArea content = new JTextArea();
        // 以换行符为分隔符
        String a[] = textArea.getText().split("[\n]");
        for (int x = 0; x < a.length; x++) {
            content.append(a[x]);
            // 添加系统换行符，形成换行效果
            content.append(System.getProperty("line.separator"));
        }
        return content.getText();
    }

    /**
     * 打开文件
     */
    public void open() {
        textArea.setText("");
        file = new FileDialog(frame, "打开", FileDialog.LOAD);
        file.setFile("*.txt");
        file.setVisible(true);
        // 得到现在的目录
        dir = file.getDirectory();
        // 得到选择文件的文件名
        name = file.getFile();
        frame.setTitle(name + "- 记事本");
        readFile(null);
    }
}
