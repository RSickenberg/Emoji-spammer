package com.sickenberg.heart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener {

    // Connexion with heart
    private JLabel emojiLabel, periodLabel;
    private JSpinner loopField;
    private JCheckBox addPeriodButton;
    private JTextField emojiResult;
    private JButton runRobot;

    window() throws AWTException {
        this.initview();
    }

    private void initview() throws AWTException {
        this.setTitle("Emoji-spammer");
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        emojiLabel = new JLabel("With emoji ?");
        contentPane.add(emojiLabel);

        emojiResult = new JTextField(7);
        contentPane.add(emojiResult);

        loopField = new JSpinner();
        loopField.setSize(50, 10);
        contentPane.add(loopField);

        periodLabel = new JLabel("Add \":\" ?");
        contentPane.add(periodLabel);

        addPeriodButton = new JCheckBox();
        contentPane.add(addPeriodButton);

        runRobot = new JButton("Start");
        runRobot.addActionListener(this);
        contentPane.add(runRobot);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String emojiName;
        int loopRepetitions;
        boolean addPeriodButtonValue;

        if (e.getSource() == runRobot) {
            try {
                if (!emojiResult.getText().equals(""))
                {
                    emojiName = emojiResult.getText();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No emoji has been given");
                    System.out.println("No emoji -> Exception");
                    throw new RuntimeException("No emoji has been given");
                }
                if (!loopField.getValue().equals(0) || loopField.getValue().hashCode() > 0) {
                    loopRepetitions = loopField.getValue().hashCode();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not valid value for loop");
                    System.out.println("Not valid int loop -> Exception");
                    throw new RuntimeException("Not valid int loop");
                }
                addPeriodButtonValue = addPeriodButton.isSelected();

                JOptionPane.showMessageDialog(this, "Ok, you have 4 seconds to select a text field");
                heart.init(emojiName, loopRepetitions, addPeriodButtonValue);
            }
            catch (Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
    }
}
