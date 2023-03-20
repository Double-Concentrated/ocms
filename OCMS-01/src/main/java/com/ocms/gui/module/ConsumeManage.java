/*
 * Created by JFormDesigner on Mon May 31 20:18:28 CST 2021
 */

package com.ocms.gui.module;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.gui.SelectModule;
import com.ocms.gui.dialog.consumemanage.*;
import com.ocms.pojo.Consume;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.event.*;

/**
 * @author Flat-White
 */
public class ConsumeManage extends JFrame {
    private int conId = 0;
    private List<Consume> consumeList;

    public ConsumeManage() {
        initComponents();
        setVisible(true);
    }

    private void query(MouseEvent e) {
        List<String> consumeLists = new ArrayList<>();
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Consume> consumeList = adminMapper.adminListConsume();
        this.consumeList = consumeList;
        for (Consume consume : consumeList) {
            consumeLists.add(consume.listConsume());
        }
        list1.setListData(consumeLists.toArray());
    }

    private void insert(MouseEvent e) {
        InsertConsume insertConsume = new InsertConsume(this);
    }

    private void update(MouseEvent e) {
        try {
            Consume consume = consumeList.get(list1.getSelectedIndex());
            this.conId = consume.getConId();
            System.out.println("当前选中conId:" + conId);
            UpdateConsume updateConsume = new UpdateConsume(this, conId);
        } catch (Exception exception){
            System.out.println("请先选择耗材");
            JOptionPane.showMessageDialog(null, "请先选择耗材！" ,"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delete(MouseEvent e) {
        try {
            Consume consume = consumeList.get(list1.getSelectedIndex());
            this.conId = consume.getConId();
            System.out.println("当前选中conId:" + conId);
            int i = JOptionPane.showConfirmDialog(null, "确认删除该耗材？", "Confirm", JOptionPane.YES_NO_OPTION);
            if(i == 0){
                Map<String, Object> map = new HashMap<>();
                map.put("conId", conId);

                System.out.println(map);

                AdminMapperImpl adminMapper = new AdminMapperImpl();
                int r = adminMapper.adminDeleteConsume(map);
                if (r > 0){
                    System.out.println("adminDeleteConsume Successfully!");
                    JOptionPane.showMessageDialog(null, "删除成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception exception){
            System.out.println("请先选择耗材");
            JOptionPane.showMessageDialog(null, "请先选择耗材！" ,"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void back(MouseEvent e) {
        SelectModule selectModule = new SelectModule();
        this.dispose();
    }

    private void back(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            SelectModule selectModule = new SelectModule();
            this.dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u8017\u6750\u7ba1\u7406");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("\u8017\u6750ID");

        //---- label2 ----
        label2.setText("\u8017\u6750\u540d\u79f0");

        //---- label3 ----
        label3.setText("\u751f\u4ea7\u5382\u5546");

        //---- label4 ----
        label4.setText("\u5165\u5e93\u65e5\u671f");

        //---- button1 ----
        button1.setText("\u6240\u6709\u8017\u6750");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- button2 ----
        button2.setText("\u65b0\u589e\u8017\u6750");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                insert(e);
            }
        });

        //---- button5 ----
        button5.setText("\u5220\u9664\u8017\u6750");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });

        //---- button4 ----
        button4.setText("\u4fee\u6539\u8017\u6750");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update(e);
            }
        });

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back(e);
            }
        });
        button3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                back(e);
            }
        });

        //---- label5 ----
        label5.setText("\u662f\u5426\u9700\u8981\u8865\u8d27");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(16, 16, 16)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(label4)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JButton button3;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
