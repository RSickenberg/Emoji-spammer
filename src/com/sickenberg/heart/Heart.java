package com.sickenberg.heart;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Heart {

    private Robot bot = new Robot();

    public static void init(String message, int loop, boolean addPeriods, boolean autoSend) throws AWTException {
        new Heart(message, loop, addPeriods, autoSend);
    }

    private Heart(String message, int loop, boolean addPeriods, boolean autoSend) throws AWTException {
        bot.setAutoDelay(20);
        bot.setAutoWaitForIdle(true);
        bot.delay(1000);

        for (int nbloop = 0; nbloop <= loop; nbloop++) {

            if (addPeriods) {
                bot.keyPress(KeyEvent.VK_SHIFT);
                type(KeyEvent.VK_PERIOD);
                bot.keyRelease(KeyEvent.VK_SHIFT);
            }

            type(message);

            if (addPeriods) {
                type(KeyEvent.VK_TAB);
                type(KeyEvent.VK_SPACE);
            }

            bot.delay(20);

            if (autoSend) {
                bot.delay(20);
                bot.keyPress(KeyEvent.VK_ENTER);
                bot.keyRelease(KeyEvent.VK_ENTER);
            }

        }
    }

    private void type(int i) {
        bot.delay(2);
        bot.keyPress(i);
        bot.keyRelease(i);
    }

    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            bot.delay(2);
            bot.keyPress(code);
            bot.keyRelease(code);
        }
    }
}
