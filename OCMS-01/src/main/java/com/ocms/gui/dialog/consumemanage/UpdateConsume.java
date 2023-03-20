/*
 * Created by JFormDesigner on Mon May 31 22:11:17 CST 2021
 */

package com.ocms.gui.dialog.consumemanage;

import com.ocms.dao.AdminMapperImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Flat-White
 */
public class UpdateConsume extends JDialog {
    private int conId;
    private String conName;
    private int conNum;
    private String conFactory;
    private Date conIndate = new Date();

    public UpdateConsume(Window owner, int conId) {
        super(owner);
        this.conId = conId;
        initComponents();
        setVisible(true);
    }

    private void close(KeyEvent e) {
        this.dispose();
    }

    private void getconName(KeyEvent e) {
        textField1 = (JTextField) e.getSource();
        this.conName = textField1.getText();
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            e.getComponent().transferFocus();
        }
    }

    private void getconNum(KeyEvent e) {
        textField2 = (JTextField) e.getSource();
        this.conNum = Integer.parseInt(textField2.getText());
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            e.getComponent().transferFocus();
        }
    }

    private void getconFactory(KeyEvent e) {
        textField3 = (JTextField) e.getSource();
        this.conFactory = textField3.getText();
    }

    private void ok(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            Map<String, Object> map = new HashMap<>();
            map.put("conId", conId);
            map.put("conName", conName);
            map.put("conNum", conNum);
            map.put("conFactory", conFactory);
            map.put("conIndate", conIndate);

            System.out.println(map);

            AdminMapperImpl adminMapper = new AdminMapperImpl();
            int i = adminMapper.adminUpdateConsume(map);
            if (i > 0){
                System.out.println("adminUpdateConsume Successfully!");
                JOptionPane.showMessageDialog(null, "修改耗材信息成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }

    private void ok(MouseEvent e) {
        Map<String, Object> map = new HashMap<>();
        map.put("conId", conId);
        map.put("conName", conName);
        map.put("conNum", conNum);
        map.put("conFactory", conFactory);
        map.put("conIndate", conIndate);

        System.out.println(map);

        AdminMapperImpl adminMapper = new AdminMapperImpl();
        int i = adminMapper.adminUpdateConsume(map);
        if (i > 0){
            System.out.println("adminUpdateConsume Successfully!");
            JOptionPane.showMessageDialog(null, "修改耗材信息成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    private void cancel(MouseEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label4 = new JLabel();
        label3 = new JLabel();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u4fee\u6539\u8017\u6750\u4fe1\u606f");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                close(e);
            }
        });
        Container contentPane = getContentPane();

        //---- textField1 ----
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getconName(e);
            }
        });

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u76f8\u5173\u4fe1\u606f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- textField2 ----
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getconNum(e);
            }
        });

        //---- textField3 ----
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getconFactory(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                ok(e);
            }
        });

        //---- label4 ----
        label4.setText("\u751f\u4ea7\u5382\u5546");

        //---- label3 ----
        label3.setText("\u8017\u6750\u6570\u91cf");

        //---- label1 ----
        label1.setText("\u8017\u6750\u540d\u79f0");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ok(e);
            }
        });

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancel(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(label2)
                    .addContainerGap(79, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(13, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4)
                                .addComponent(label3)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(label2)
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label3;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
