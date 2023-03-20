/*
 * Created by JFormDesigner on Wed May 26 23:44:02 CST 2021
 */

package com.ocms.gui.module;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.gui.SelectModule;
import com.ocms.gui.dialog.check.AgreeApply;
import com.ocms.gui.dialog.check.RejectApply;
import com.ocms.gui.dialog.consumemanage.queryRecord;
import com.ocms.pojo.Apply;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Flat-White
 */
public class Check extends JFrame {
    private int applyId = -1;
    private int adminId;
    private String applyNote;
    private List<Apply> applyList;
    private List<Apply> unTreatApply;
/**
 *     flag 1 -> 所有申请 2 -> 待处理
  */
    private int flag = -1;

    public Check() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void query(MouseEvent e) {
        this.flag = 1;
        List<String> applyLists = new ArrayList<>();
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Apply> applyList = adminMapper.adminListApply();
        this.applyList = applyList;
        for (Apply apply : applyList) {
            applyLists.add(apply.listApply());
        }
        list1.setListData(applyLists.toArray());

    }

    private void getTODO(MouseEvent e) {
        this.flag = 2;
        List<String> todoLists = new ArrayList<>();
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Apply> applyList = adminMapper.adminGetUnTreatApply();
        this.unTreatApply = applyList;
        for (Apply apply : applyList) {
            todoLists.add(apply.listApply());
        }
        list1.setListData(todoLists.toArray());
    }

    private void agree(MouseEvent e) {
        if (list1.getSelectedIndex() == -1){
            System.out.println("请先选择申请");
            JOptionPane.showMessageDialog(null, "请先选择申请！" ,"Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.flag == 1){
            Apply apply = applyList.get(list1.getSelectedIndex());
            this.applyId = apply.getApplyId();
            System.out.println("当前选中的applyId:" + applyId);
            AgreeApply agreeApply = new AgreeApply(this,applyId);
        }
        else if (this.flag == 2){
            System.out.println(list1.getSelectedIndex());
            Apply apply = unTreatApply.get(list1.getSelectedIndex());
            this.applyId = apply.getApplyId();
            System.out.println("当前选中的applyId:" + applyId);
            AgreeApply agreeApply = new AgreeApply(this,applyId);

        }
        else {
            System.out.println("ERROR!");
        }
    }

    private void reject(MouseEvent e) {
        if (list1.getSelectedIndex() == -1){
            System.out.println("请先选择申请");
            JOptionPane.showMessageDialog(null, "请先选择申请！" ,"Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.flag == 1){
            Apply apply = applyList.get(list1.getSelectedIndex());
            this.applyId = apply.getApplyId();
            System.out.println("当前选中的applyId:" + applyId);
            RejectApply rejectApply = new RejectApply(this, applyId);
        }
        else if (this.flag == 2){
            System.out.println(list1.getSelectedIndex());
            Apply apply = unTreatApply.get(list1.getSelectedIndex());
            this.applyId = apply.getApplyId();
            System.out.println("当前选中的applyId:" + applyId);
            RejectApply rejectApply = new RejectApply(this, applyId);
        }
        else {
            System.out.println("ERROR!");
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

    private void getRecord(MouseEvent e) {
        queryRecord queryRecord = new queryRecord(this, list1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button3 = new JButton();
        button6 = new JButton();

        //======== this ========
        setTitle("\u5ba1\u6838");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("\u5355\u53f7");

        //---- label2 ----
        label2.setText("\u7533\u8bf7\u65f6\u95f4");

        //---- label3 ----
        label3.setText("\u9886\u7528\u65f6\u95f4");

        //---- label4 ----
        label4.setText("\u7533\u8bf7\u6570\u91cf");

        //---- label5 ----
        label5.setText("\u8017\u6750\u540d\u79f0");

        //---- button1 ----
        button1.setText("\u6240\u6709\u7533\u8bf7");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5f85\u5904\u7406");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getTODO(e);
            }
        });

        //---- button4 ----
        button4.setText("\u540c\u610f\u7533\u8bf7");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                agree(e);
            }
        });

        //---- button5 ----
        button5.setText("\u62d2\u7edd\u7533\u8bf7");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reject(e);
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

        //---- button6 ----
        button6.setText("\u9886\u7528\u60c5\u51b5");
        button6.setMaximumSize(new Dimension(64, 27));
        button6.setMinimumSize(new Dimension(64, 27));
        button6.setPreferredSize(new Dimension(64, 27));
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getRecord(e);
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
                            .addGap(71, 71, 71)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(16, 16, 16)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(label4)
                                    .addGap(32, 32, 32)
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
                        .addComponent(label5)
                        .addComponent(label4)
                        .addComponent(label3)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JButton button3;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
