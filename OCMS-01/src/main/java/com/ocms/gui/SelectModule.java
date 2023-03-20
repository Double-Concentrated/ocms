/*
 * Created by JFormDesigner on Thu May 20 22:25:17 CST 2021
 */

package com.ocms.gui;

import com.ocms.gui.module.Check;
import com.ocms.gui.module.ConsumeManage;
import com.ocms.gui.module.StaffManage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Flat-White
 */
public class SelectModule extends JFrame {
    public SelectModule() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void consumeManage(MouseEvent e) {
        ConsumeManage consumeManage = new ConsumeManage();
        this.dispose();
    }

    private void consumeManage(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER) {
            ConsumeManage consumeManage = new ConsumeManage();
            this.dispose();
        }
    }

    private void staffManage(MouseEvent e) {
        StaffManage staffManage = new StaffManage();
        this.dispose();
    }

    private void staffManage(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER) {
            StaffManage staffManage = new StaffManage();
            staffManage.setVisible(true);
            this.dispose();
        }
    }

    private void exit(MouseEvent e) {
        System.exit(0);
    }

    private void exit(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
        System.exit(0);
        }
    }

    private void check(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER) {
            Check check = new Check();
            this.dispose();
        }
    }

    private void check(MouseEvent e) {
        Check check = new Check();
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("\u529e\u516c\u5ba4\u8017\u6750\u7ba1\u7406\u7cfb\u7edf-\u7ba1\u7406\u5458");
        Container contentPane = getContentPane();

        //---- label2 ----
        label2.setText("\u8bf7\u9009\u62e9\u529f\u80fd\u6a21\u5757");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- button1 ----
        button1.setText("\u5ba1\u6838");
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                check(e);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                check(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5458\u5de5\u7ba1\u7406");
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                staffManage(e);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                staffManage(e);
            }
        });

        //---- button3 ----
        button3.setText("\u8017\u6750\u7ba1\u7406");
        button3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                consumeManage(e);
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                consumeManage(e);
            }
        });

        //---- button4 ----
        button4.setText("\u9000\u51fa\u7cfb\u7edf");
        button4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                exit(e);
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGap(49, 49, 49))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
