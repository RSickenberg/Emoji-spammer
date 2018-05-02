package com.sickenberg.heart;

import java.awt.*;

public class Main {

    public static void main(String[] args)
    {

        try {
            new Window();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}