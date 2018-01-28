package com.sickenberg.heart;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    private boolean addPeriod = true;
    private int loop = 300;
    private String emoji = "heart";

    public static void main(String[] args) throws AWTException{
        heart.init(this.loop, this.emoji, this.addPeriod); // Insert emoji name ❤️
    }

}