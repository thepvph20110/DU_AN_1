/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author DANG VAN SY
 */
public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbHome = new javax.swing.JLabel();
        lbQLCa = new javax.swing.JLabel();
        lbDichVu = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        lbLienHe = new javax.swing.JLabel();
        lbDangNhap = new javax.swing.JLabel();
        lbQLSan = new javax.swing.JLabel();
        lbLichDat = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchText1 = new views.SearchText();
        lbSearch = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panSan1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel2.setBackground(new java.awt.Color(11, 127, 171));

        jPanel3.setBackground(new java.awt.Color(11, 127, 171));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(11, 127, 171));

        lbHome.setBackground(new java.awt.Color(11, 127, 171));
        lbHome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbHome.setForeground(new java.awt.Color(255, 255, 255));
        lbHome.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ball.png")); // NOI18N
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setOpaque(true);

        lbQLCa.setBackground(new java.awt.Color(11, 127, 171));
        lbQLCa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLCa.setForeground(new java.awt.Color(255, 255, 255));
        lbQLCa.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ca.png")); // NOI18N
        lbQLCa.setText("Quản Lí Ca");
        lbQLCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLCa.setOpaque(true);
        lbQLCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQLCaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQLCaMouseExited(evt);
            }
        });

        lbDichVu.setBackground(new java.awt.Color(11, 127, 171));
        lbDichVu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lbDichVu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\service.png")); // NOI18N
        lbDichVu.setText("Dịch Vụ");
        lbDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDichVu.setOpaque(true);
        lbDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDichVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDichVuMouseExited(evt);
            }
        });

        lbHoaDon.setBackground(new java.awt.Color(11, 127, 171));
        lbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lbHoaDon.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\bill.png")); // NOI18N
        lbHoaDon.setText("Hóa Đơn");
        lbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHoaDon.setOpaque(true);
        lbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseExited(evt);
            }
        });

        lbLienHe.setBackground(new java.awt.Color(11, 127, 171));
        lbLienHe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLienHe.setForeground(new java.awt.Color(255, 255, 255));
        lbLienHe.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\callss.png")); // NOI18N
        lbLienHe.setText("Liên Hệ ");
        lbLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLienHe.setOpaque(true);
        lbLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLienHeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLienHeMouseExited(evt);
            }
        });

        lbDangNhap.setBackground(new java.awt.Color(11, 127, 171));
        lbDangNhap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbDangNhap.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\Login32.png")); // NOI18N
        lbDangNhap.setText("Đăng Nhập");
        lbDangNhap.setToolTipText("");
        lbDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDangNhap.setOpaque(true);
        lbDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDangNhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDangNhapMouseExited(evt);
            }
        });

        lbQLSan.setBackground(new java.awt.Color(11, 127, 171));
        lbQLSan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLSan.setForeground(new java.awt.Color(255, 255, 255));
        lbQLSan.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\stadium.png")); // NOI18N
        lbQLSan.setText("Quản Lí Sân");
        lbQLSan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLSan.setOpaque(true);
        lbQLSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQLSanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQLSanMouseExited(evt);
            }
        });

        lbLichDat.setBackground(new java.awt.Color(11, 127, 171));
        lbLichDat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLichDat.setForeground(new java.awt.Color(255, 255, 255));
        lbLichDat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\booking.png")); // NOI18N
        lbLichDat.setText("Lịch Đặt");
        lbLichDat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLichDat.setOpaque(true);
        lbLichDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLichDatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLichDatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbQLSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQLCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDangNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbLichDat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lbLichDat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbQLSan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbQLCa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        jPanel1.setBackground(new java.awt.Color(11, 127, 171));

        jLabel1.setBackground(new java.awt.Color(11, 127, 171));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);

        lbSearch.setBackground(new java.awt.Color(11, 127, 171));
        lbSearch.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\search.png")); // NOI18N
        lbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSearch.setOpaque(true);
        lbSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSearchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panSan1Layout = new javax.swing.GroupLayout(panSan1);
        panSan1.setLayout(panSan1Layout);
        panSan1Layout.setHorizontalGroup(
            panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1313, Short.MAX_VALUE)
        );
        panSan1Layout.setVerticalGroup(
            panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(51, 153, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sân 2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 153, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Sân 1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panSan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panSan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangNhapMouseEntered
        lbDangNhap.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbDangNhapMouseEntered

    private void lbDangNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangNhapMouseExited
        lbDangNhap.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbDangNhapMouseExited

    private void lbLienHeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLienHeMouseEntered
        lbLienHe.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbLienHeMouseEntered

    private void lbLienHeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLienHeMouseExited
        lbLienHe.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbLienHeMouseExited

    private void lbDichVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDichVuMouseEntered
        lbDichVu.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbDichVuMouseEntered

    private void lbDichVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDichVuMouseExited
        lbDichVu.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbDichVuMouseExited

    private void lbDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangNhapMouseClicked
        JOptionPane.showMessageDialog(this, "Hello");
    }//GEN-LAST:event_lbDangNhapMouseClicked

    private void lbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseClicked
        lbHoaDon.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbHoaDonMouseClicked

    private void lbHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseEntered
        lbHoaDon.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbHoaDonMouseEntered

    private void lbHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseExited
        lbHoaDon.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbHoaDonMouseExited

    private void lbQLCaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseEntered
        lbQLCa.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbQLCaMouseEntered

    private void lbQLCaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseExited
        lbQLCa.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbQLCaMouseExited

    private void lbLichDatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichDatMouseEntered
        lbLichDat.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbLichDatMouseEntered

    private void lbLichDatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichDatMouseExited
        lbLichDat.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbLichDatMouseExited

    private void lbQLSanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseEntered
        lbQLSan.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbQLSanMouseEntered

    private void lbQLSanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseExited
        lbQLSan.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbQLSanMouseExited

    private void lbSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMouseEntered
        lbSearch.setBackground(new Color(40, 67, 135));
    }//GEN-LAST:event_lbSearchMouseEntered

    private void lbSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMouseExited
        lbSearch.setBackground(new Color(11, 127, 171));
    }//GEN-LAST:event_lbSearchMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private static javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbDichVu;
    private static javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbHome;
    private static javax.swing.JLabel lbLichDat;
    private javax.swing.JLabel lbLienHe;
    private static javax.swing.JLabel lbQLCa;
    private static javax.swing.JLabel lbQLSan;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JPanel panSan1;
    private views.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
