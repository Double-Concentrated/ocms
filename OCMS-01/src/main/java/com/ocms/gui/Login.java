/*
 * Created by JFormDesigner on Fri May 21 14:23:35 CST 2021
 */

package com.ocms.gui;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.pojo.Admin;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Flat-White
 */
public class Login extends JFrame {
    private String adminAccount;
    private String adminPasswd;

    public Login() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void Login(MouseEvent e) {
        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        map.put("adminPasswd", adminPasswd);
        System.out.println(map);
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        Admin admin = adminMapper.adminLogin(map);
        if(admin != null){
            System.out.println(admin);
            System.out.println("Login successfully!");
            JOptionPane.showMessageDialog(null, "登陆成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
            new SelectModule();
            this.dispose();
        }
        else {
            System.out.println("Login failed!");
            JOptionPane.showMessageDialog(null, "用户名或密码错误！", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void enterToLogin(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            Map<String, Object> map = new HashMap<>();
            map.put("adminAccount", adminAccount);
            map.put("adminPasswd", adminPasswd);
            AdminMapperImpl adminMapper = new AdminMapperImpl();
            Admin admin = adminMapper.adminLogin(map);
            if(admin != null){
                System.out.println(admin);
                System.out.println("Login successfully!");
                JOptionPane.showMessageDialog(null, "登陆成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                new SelectModule();
                this.dispose();
            }
            else {
                System.out.println("Login failed!");
                JOptionPane.showMessageDialog(null, "用户名或密码错误！", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void getadminAccount(KeyEvent e) {
        textField1 = (JTextField) e.getSource();
        this.adminAccount = textField1.getText();
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            e.getComponent().transferFocus();
        }
    }

    private void getadminPasswd(KeyEvent e) {
            textField1 = (JTextField) e.getSource();
            this.adminPasswd = String.valueOf(passwordField1.getPassword());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        label1 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u767b\u5f55");
        Container contentPane = getContentPane();

        //---- label2 ----
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        label2.setText("\u7ba1\u7406\u5458\u767b\u5f55");

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

        //---- textField1 ----
        textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 5f));
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getadminAccount(e);
            }
        });

        //---- passwordField1 ----
        passwordField1.setFont(passwordField1.getFont().deriveFont(passwordField1.getFont().getSize() + 5f));
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getadminPasswd(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                enterToLogin(e);
            }
        });

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label3, GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(157, 157, 157)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(151, 151, 151)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(103, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(31, 31, 31)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JLabel label1;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
