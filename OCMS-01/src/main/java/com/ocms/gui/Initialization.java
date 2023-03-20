/*
 * Created by JFormDesigner on Fri May 21 18:28:29 CST 2021
 */

package com.ocms.gui;

import com.ocms.gui.dialog.TODO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Flat-White
 */
public class Initialization extends JFrame {

//        Metal风格(默认)
//        String lookAndFeel ="javax.swing.plaf.metal.MetalLookAndFeel";
//        Windows风格
//        String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//        Windows Classic风格
//        String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
//        Motif风格
//        String lookAndFeel ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//        Mac风格 (需要在相关的操作系统上方可实现)
//        String lookAndFeel ="com.apple.laf.AquaLookAndFeel";
//        GTK风格 (需要在相关的操作系统上方可实现)
//        String lookAndFeel ="com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
//        可跨平台的默认风格
        String lookAndFeel =UIManager.getCrossPlatformLookAndFeelClassName();
//        当前系统的风格
//        String lookAndFeel =UIManager.getSystemLookAndFeelClassName();

    public Initialization() {

//        改变界面风格
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
//        窗口大小不可变
        this.setResizable(false);
//        关闭后结束进程
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void chooseAdmin(MouseEvent e) {
        Login login = new Login();
        this.dispose();
    }

    private void chooseAdmin(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            Login login = new Login();
            this.dispose();
        }
    }

    private void chooseStaff(MouseEvent e) {
        TODO todo = new TODO(this);
    }

    private void chooseStaff(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            TODO todo = new TODO(this);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u529e\u516c\u5ba4\u8017\u6750\u7ba1\u7406\u7cfb\u7edf");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u9009\u62e9\u5ba2\u6237\u7aef");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label2 ----
        label2.setText("\u6b22\u8fce\u4f7f\u7528\u529e\u516c\u5ba4\u8017\u6750\u7ba1\u7406\u7cfb\u7edf^_^");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

        //---- button1 ----
        button1.setText("\u7ba1\u7406\u5458");
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                chooseAdmin(e);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseAdmin(e);
            }
        });

        //---- button2 ----
        button2.setText("\u7528\u6237");
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                chooseStaff(e);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseStaff(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                            .addGap(138, 138, 138))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                            .addGap(70, 70, 70))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(54, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
