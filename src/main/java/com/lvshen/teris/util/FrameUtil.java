package com.lvshen.teris.util;

import javax.swing.*;
import java.awt.*;

public class FrameUtil {
    /**
     * 窗体居中
     *
     * @param jf
     */
    public static void setFrameCenter(JFrame jf) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width - jf.getWidth() >> 1;
        int y = (screen.height - jf.getHeight() >> 1) - 32;
        jf.setLocation(x, y);
    }

    public static void setFrameCenter(JFrame jf, int offset) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width - jf.getWidth() >> 1;
        int y = (screen.height - jf.getHeight() >> 1) - 32;
        jf.setLocation(x, y + offset);
    }
}
