package nui.honest.notebook.common;

import java.awt.*;

/**
 * Created by Lenovo on 2019/11/7.
 */
public class FormatConversion {

    public static int conversion(String str) {
        int style = 0;
        switch (str) {
            case "常规":
                style = Font.PLAIN;
                break;
            case "倾斜":
                style = Font.ITALIC;
                break;
            case "粗体":
                style = Font.BOLD;
                break;
            case "粗体 倾斜":
                style = Font.BOLD + Font.ITALIC;
                break;
            default:
                break;
        }
        return style;
    }
}
