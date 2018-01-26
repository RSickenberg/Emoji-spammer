package com.sickenberg.heart;
import java.awt.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;

public class heart {

    private Robot bot = new Robot();

    public static void init(int loop, String message) throws AWTException {
        new heart(loop, message);
    }

    private heart(int loop, String message) throws AWTException {
        bot.setAutoDelay(20);
        bot.setAutoWaitForIdle(true);
        bot.delay(4000);

        for (int nbloop=0; nbloop <= loop; nbloop++) {
            bot.keyPress(KeyEvent.VK_SHIFT); // MAJ
            bot.keyPress(KeyEvent.VK_PERIOD); // :
            bot.keyRelease(KeyEvent.VK_SHIFT); // Release MAJ
            type(message); // Typed emoji
            bot.keyPress(KeyEvent.VK_SHIFT);
            bot.keyPress(KeyEvent.VK_PERIOD);
            bot.keyRelease(KeyEvent.VK_SHIFT);
            bot.keyPress(KeyEvent.VK_SPACE); // TODO : NEED IMPROVEMENTS
            bot.keyPress(KeyEvent.VK_ENTER); // SEND emoji from whatsaap
            type(KeyEvent.VK_ENTER); // SEND MESSAGE

        }
    }

    private void type(int i)
    {
        bot.delay(2);
        bot.keyPress(i);
        bot.keyRelease(i);
    }

    private void type(String s)
    {
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            bot.delay(2);
            bot.keyPress(code);
            bot.keyRelease(code);
        }
    }
}
