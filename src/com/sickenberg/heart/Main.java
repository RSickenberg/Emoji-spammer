package com.sickenberg.heart;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        try {
            window window = new window();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}