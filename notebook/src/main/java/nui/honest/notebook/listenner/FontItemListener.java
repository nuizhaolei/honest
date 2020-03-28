package nui.honest.notebook.listenner;

import nui.honest.notebook.common.FileAreaSelect;
import nui.honest.notebook.common.FormatConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class FontItemListener implements ActionListener, ItemListener {

    private JTextField fontKindText;

    private JTextField fontShapeText;

    private JTextField fontSizeText;

    private JTextArea example;

    private FileAreaSelect fileAreaSelect = FileAreaSelect.singleton();

    private JDialog fontDialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "confirm":
                confirm();
                break;
            case "cancel":
                cancel();
                break;
            default:
                break;
        }
    }

    private void cancel() {
        fontDialog.dispose();
    }

    private void confirm() {
        String name = fontKindText.getText();
        int style = FormatConversion.conversion(fontShapeText.getText().toString());
        int size = Integer.parseInt(fontSizeText.getText());
        fileAreaSelect.getTextArea().setFont(new Font(name, style, size));
        fontDialog.dispose();
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        List list = (List) e.getSource();
        String name = list.getName();
        switch (name) {
            case "fontKindList":
                setFontKind(list);
                break;
            case "fontShapeList":
                setFontShape(list);
                break;
            case "fontSizeList":
                setFontSize(list);
                break;
            default:
                break;
        }
    }

    private void setFontShape(List list) {
        fontShapeText.setText(list.getSelectedItem());
        Font font = example.getFont();
        example.setFont(new Font(font.getName(), FormatConversion.conversion(list.getSelectedItem()), font.getSize()));
    }

    private void setFontKind(List list) {
        fontKindText.setText(list.getSelectedItem());
        Font font = example.getFont();
        example.setFont(new Font(list.getSelectedItem(), font.getStyle(), font.getSize()));
    }

    private void setFontSize(List list) {
        fontSizeText.setText(list.getSelectedItem());
        Font font = example.getFont();
        example.setFont(new Font(font.getName(), font.getStyle(), Integer.parseInt(list.getSelectedItem())));
    }

    public JTextField getFontKindText() {
        return fontKindText;
    }

    public void setFontKindText(JTextField fontKindText) {
        this.fontKindText = fontKindText;
    }

    public JTextField getFontShapeText() {
        return fontShapeText;
    }

    public void setFontShapeText(JTextField fontShapeText) {
        this.fontShapeText = fontShapeText;
    }

    public JTextField getFontSizeText() {
        return fontSizeText;
    }

    public void setFontSizeText(JTextField fontSizeText) {
        this.fontSizeText = fontSizeText;
    }

    public JTextArea getExample() {
        return example;
    }

    public void setExample(JTextArea example) {
        this.example = example;
    }

    public JDialog getFontDialog() {
        return fontDialog;
    }

    public void setFontDialog(JDialog fontDialog) {
        this.fontDialog = fontDialog;
    }
}
