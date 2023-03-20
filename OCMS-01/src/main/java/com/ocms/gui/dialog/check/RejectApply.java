/*
 * Created by JFormDesigner on Mon May 31 11:20:02 CST 2021
 */

package com.ocms.gui.dialog.check;

import com.ocms.dao.AdminMapperImpl;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

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
public class RejectApply extends JDialog {
    private int applyId;
    private int adminId;
    private String applyNote;

    public RejectApply(Window owner, int applyId) {
        super(owner);
        this.applyId = applyId;
        initComponents();
        setVisible(true);
    }

    private void close(KeyEvent e) {
        this.dispose();
    }

    private void getadminId(KeyEvent e) {
        textField1 = (JTextField) e.getSource();
        try {
            this.adminId = Integer.parseInt(textField1.getText());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            e.getComponent().transferFocus();
        }
    }

    private void ok(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){

            Map<String, Object> map = new HashMap<>();
            map.put("applyId", applyId);
            map.put("adminId", adminId);
            map.put("applyNote", applyNote);

            System.out.println(map);

            try {
                AdminMapperImpl adminMapper = new AdminMapperImpl();
                int staId = adminMapper.adminGetStaIdByApplyId(map);
                map.put("staId", staId);
                int i = adminMapper.adminRejectApply(map);
                if (i > 0){
                    System.out.println("adminRejectApply Successfully!");
                    JOptionPane.showMessageDialog(null, "拒绝申请成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } catch (Exception exception){
                exception.printStackTrace();
                System.out.println("adminId不存在！");
            }
        }
    }

    private void getapplyNote(KeyEvent e) {
        textField2 = (JTextField) e.getSource();
        this.applyNote = textField2.getText();
    }

    private void ok(MouseEvent e) {
        Map<String, Object> map = new HashMap<>();
        map.put("applyId", applyId);
        map.put("adminId", adminId);
        map.put("applyNote", applyNote);

        System.out.println(map);

        try {
            AdminMapperImpl adminMapper = new AdminMapperImpl();
            int staId = adminMapper.adminGetStaIdByApplyId(map);
            map.put("staId", staId);
            int i = adminMapper.adminRejectApply(map);
            if (i > 0){
                System.out.println("adminRejectApply Successfully!");
                JOptionPane.showMessageDialog(null, "拒绝申请成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (Exception exception){
            exception.printStackTrace();
            System.out.println("adminId不存在！");
        }
    }

    private void cancel(MouseEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label3 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u62d2\u7edd\u7533\u8bf7");
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
                getadminId(e);
            }
        });

        //---- label3 ----
        label3.setText("\u7406\u7531");

        //---- label1 ----
        label1.setText("ID");

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u7ba1\u7406\u5458ID\u4e0e\u62d2\u7edd\u7406\u7531");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- textField2 ----
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getapplyNote(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                ok(e);
            }
        });

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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addGap(36, 36, 36))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
    private JLabel label3;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
