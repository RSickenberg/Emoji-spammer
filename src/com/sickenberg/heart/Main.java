package com.sickenberg.heart;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) throws AWTException{
        boolean addPeriod = true; // Add : ?
        int loop = 300; // Number of repetitions
        String emoji = "heart"; // Emoji name


        heart.init(loop, emoji, addPeriod); // Insert emoji name ❤️
    }

}