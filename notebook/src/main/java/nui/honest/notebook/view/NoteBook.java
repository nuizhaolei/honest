package nui.honest.notebook.view;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.listenner.EditKeyListenner;
import nui.honest.notebook.listenner.EditMouseListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * Created by Lenovo on 2019/11/5.
 */
public class NoteBook extends JFrame {

    private JTextArea textArea;

    public NoteBook() {
        //创建一个窗体
        setBounds(450, 150, 800, 600);
        setTitle("无标题- 记事本");
        // 设置窗口图标
        Toolkit tool = this.getToolkit();
        Image image = tool.getImage("notebook/icon/notebook.png");
        image.getSource();
        setIconImage(image);
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 初始化
     */
    public void init() {
        //创建文本域
        this.getContentPane().add(createTextArea());
        //创建菜单项
        this.setJMenuBar(createMenu());
        FileAreaSelect.singleton().setFrame(this);
    }

    public JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        FileMenuComponent fileMenuComponent = new FileMenuComponent();
        fileMenuComponent.setTextArea(textArea);
        fileMenuComponent.setName("文件(F)");
        fileMenuComponent.setFrame(this);
        JMenu fileMenu = fileMenuComponent.init();

        EditMenuComponent editMenuComponent = new EditMenuComponent();
        editMenuComponent.setFrame(this);
        editMenuComponent.setName("编辑(E)");
        editMenuComponent.setTextArea(textArea);
        JMenu editMenu = editMenuComponent.init();

        StyleMenuComponent styleMenu = new StyleMenuComponent();
        JMenu formatMenu = styleMenu.init();

        ViewMenuComponent viewMenuComponent = new ViewMenuComponent();
        JMenu viewMenu = viewMenuComponent.init("查看(V)");

        HelpMenuComponent helpMenuComponent = new HelpMenuComponent();
        JMenu helpMenu = helpMenuComponent.init("帮助(H)");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    /**
     * 创建文本域
     *
     * @return
     */
    public JScrollPane createTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();
        textArea.getDocument().addUndoableEditListener(fileAreaSelect.getUndo());
        EditKeyListenner editKeyListenner = new EditKeyListenner();
        textArea.addKeyListener(editKeyListenner);
        textArea.addMouseListener(new EditMouseListener());
        fileAreaSelect.setTextArea(textArea);
        //设置滚动条出现时机
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}
