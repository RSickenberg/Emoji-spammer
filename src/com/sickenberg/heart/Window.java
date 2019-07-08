package com.sickenberg.heart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame implements ActionListener
{

    // Connexion with Heart
    private JLabel emojiLabel, periodLabel, autoSendLabel, loopLabel, emojiPedia;
    private JSpinner loopField;
    private JCheckBox addPeriodButton, autoSendButton;
    private JTextField emojiResult;
    private JButton runRobot;

    Window() throws AWTException
    {
        this.initview();
    }

    private void initview() throws AWTException
    {
        this.setTitle("Emoji-spammer");
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        emojiLabel = new JLabel("With emoji ?");
        contentPane.add(emojiLabel);

        emojiResult = new JTextField(7);
        contentPane.add(emojiResult);

        loopLabel = new JLabel("Number of loops :");
        contentPane.add(loopLabel);

        loopField = new JSpinner();
        loopField.setSize(50, 10);
        contentPane.add(loopField);

        periodLabel = new JLabel("Add \":\" ?");
        contentPane.add(periodLabel);

        addPeriodButton = new JCheckBox();
        contentPane.add(addPeriodButton);

        autoSendLabel = new JLabel("Auto send the message after an emoji ?");
        contentPane.add(autoSendLabel);

        autoSendButton = new JCheckBox();
        contentPane.add(autoSendButton);

        runRobot = new JButton("Start");
        runRobot.addActionListener(this);
        contentPane.add(runRobot);

        emojiPedia = new JLabel("You can check emoji's name: https://emojipedia.org");
        contentPane.add(emojiPedia);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String emojiName;
        int loopRepetitions;
        boolean addPeriodButtonValue, autoSendButtonValue;

        if (e.getSource() == runRobot)
        {
            try {
                if (!emojiResult.getText().equals("")) {
                    emojiName = emojiResult.getText();
                } else {
                    JOptionPane.showMessageDialog(this, "No emoji has been given.");
                    throw new RuntimeException("[Exception] : No Emoji");
                }
                if (!loopField.getValue().equals(0) || loopField.getValue().hashCode() > 0) {
                    loopRepetitions = loopField.getValue().hashCode();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Not valid value for loop.");
                    throw new RuntimeException("[Exception] : Negative int or null");
                }
                addPeriodButtonValue = addPeriodButton.isSelected();
                autoSendButtonValue = autoSendButton.isSelected();

                JOptionPane.showMessageDialog(this, "Ok, you have 5 seconds to select a text field after the OK. \nBe aware, this soft run well for WhatsApp for now.");
                TimeUnit.SECONDS.sleep(5);

                Thread bot = new Thread(() -> {
                    try {
                        Heart.init(emojiName, loopRepetitions, addPeriodButtonValue, autoSendButtonValue);
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                });

                TimeUnit.SECONDS.sleep(5);
                bot.start();
            } catch (Exception l) {
                System.out.println(l.getMessage());
            }
        }
    }
}
