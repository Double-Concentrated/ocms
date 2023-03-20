/*
 * Created by JFormDesigner on Wed Jun 02 10:14:06 CST 2021
 */

package com.ocms.gui.dialog.consumemanage;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.pojo.Apply;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Flat-White
 */
public class queryRecord extends JDialog {
    private String staName;
    private List<String> list;
    private JList list1;

    public queryRecord(Window owner, JList list1) {
        super(owner);
        this.list1 = list1;
        initComponents();
        setVisible(true);
    }

    private void close(KeyEvent e) {
        this.dispose();
    }

    private void getstaName(KeyEvent e) {
        textField1 = (JTextField) e.getSource();
        this.staName = textField1.getText();
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            e.getComponent().transferFocus();
        }
    }

    private void ok(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            Map<String, Object> map = new HashMap<>();
            map.put("staName", staName);

            System.out.println(map);

            try {
                AdminMapperImpl adminMapper = new AdminMapperImpl();
                List<Apply> applyList = adminMapper.adminGetApplyByStaName(map);
                List<String> list = new ArrayList<>();
                this.list = list;
                for (Apply apply : applyList) {
                    list.add(apply.listApply());
                }
                list1.setListData(list.toArray());
                this.dispose();
            } catch (Exception exception){
                exception.printStackTrace();
                System.out.println("ERROR");
            }
        }
    }

    private void ok(MouseEvent e) {
        Map<String, Object> map = new HashMap<>();
        map.put("staName", staName);

        System.out.println(map);

        try {
            AdminMapperImpl adminMapper = new AdminMapperImpl();
            List<Apply> applyList = adminMapper.adminGetApplyByStaName(map);
            List<String> list = new ArrayList<>();
            this.list = list;
            for (Apply apply : applyList) {
                list.add(apply.listApply());
            }
            list1.setListData(list.toArray());
            this.dispose();
        } catch (Exception exception){
            exception.printStackTrace();
            System.out.println("ERROR!");
        }
    }

    private void cancel(MouseEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label2 = new JLabel();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u67e5\u8be2\u7533\u8bf7\u8bb0\u5f55");
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
                getstaName(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                ok(e);
            }
        });

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u8981\u67e5\u8be2\u7684\u5458\u5de5");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- label1 ----
        label1.setText("\u5458\u5de5\u59d3\u540d");

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
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(label2)))
                    .addContainerGap(9, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(label2)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JLabel label2;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
