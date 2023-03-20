/*
 * Created by JFormDesigner on Mon May 31 11:45:18 CST 2021
 */

package com.ocms.gui.module;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.gui.SelectModule;
import com.ocms.gui.dialog.staffmanage.InsertStaff;
import com.ocms.gui.dialog.staffmanage.UpdateStaff;
import com.ocms.pojo.Staff;

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
public class StaffManage extends JFrame {
    private int staId = 0;
    private List<Staff> staffList;

    public StaffManage() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void query(MouseEvent e) {
        List<String> staffLists = new ArrayList<>();
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Staff> staffList = adminMapper.adminListStaff();
        this.staffList = staffList;
        for (Staff staff : staffList) {
            staffLists.add(staff.listStaff());
        }
        list1.setListData(staffLists.toArray());
    }

    private void insert(MouseEvent e) {
        InsertStaff insertStaff = new InsertStaff(this);
    }

    private void delete(MouseEvent e) {
        try {
            Staff staff = staffList.get(list1.getSelectedIndex());
            this.staId = staff.getStaId();
            System.out.println("当前选中的staId:" + staId);
            int i = JOptionPane.showConfirmDialog(null, "确认删除该员工？", "Confirm", JOptionPane.YES_NO_OPTION);
            if(i == 0){
                Map<String, Object> map = new HashMap<>();
                map.put("staId", staId);

                System.out.println(map);

                AdminMapperImpl adminMapper = new AdminMapperImpl();
                int r = adminMapper.adminDeleteStaff(map);
                if (r > 0){
                    System.out.println("adminDeleteStaff Successfully!");
                    JOptionPane.showMessageDialog(null, "删除成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception exception){
            System.out.println("请先选择员工");
            JOptionPane.showMessageDialog(null, "请先选择员工！" ,"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void update(MouseEvent e) {
        try {
            Staff staff = staffList.get(list1.getSelectedIndex());
            this.staId = staff.getStaId();
            System.out.println("当前选中的staId:" + staId);
            UpdateStaff updateStaff = new UpdateStaff(this, staId);
        } catch (Exception exception){
            System.out.println("请先选择员工");
            JOptionPane.showMessageDialog(null, "请先选择员工！" ,"Error", JOptionPane.ERROR_MESSAGE);
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

        //======== this ========
        setTitle("\u5458\u5de5\u7ba1\u7406");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("\u5458\u5de5ID");

        //---- label2 ----
        label2.setText("\u6240\u5c5e\u90e8\u95e8");

        //---- label3 ----
        label3.setText("\u5458\u5de5\u59d3\u540d");

        //---- label4 ----
        label4.setText("\u8054\u7cfb\u65b9\u5f0f");

        //---- button1 ----
        button1.setText("\u6240\u6709\u5458\u5de5");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- button2 ----
        button2.setText("\u65b0\u589e\u5458\u5de5");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                insert(e);
            }
        });

        //---- button5 ----
        button5.setText("\u5220\u9664\u5458\u5de5");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });

        //---- button4 ----
        button4.setText("\u4fee\u6539\u5458\u5de5");
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
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label3)
                                    .addGap(42, 42, 42)
                                    .addComponent(label4))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(58, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label4)
                        .addComponent(label3))
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
                    .addContainerGap(22, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
