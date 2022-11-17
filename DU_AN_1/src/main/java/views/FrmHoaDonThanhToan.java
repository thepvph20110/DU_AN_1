/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLHoaDon;
import modelview.QLHoaDonThanhToan;
import modelview.QLThanhToan;
import service.IHoaDonService;
import service.IHoaDonThanhToanService;
import service.Impl.HoaDonServiceImpl;
import service.Impl.HoaDonThanhToanServiceImpl;
import service.Impl.ThanhToanServiceImpl;

public class FrmHoaDonThanhToan extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<QLHoaDonThanhToan> listQLHoaDonThanhToan = new ArrayList<>();
    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanServiceImpl();
    private DefaultComboBoxModel dcbmHoaDon = new DefaultComboBoxModel();
    private List<QLHoaDon> listCBBHoaDon = new ArrayList<>();
    private List<String> listCBBThanhToan = new ArrayList<>();
    private DefaultComboBoxModel dcbmThanhToan = new DefaultComboBoxModel();

    private int index = -1;
    private int curentPage;
    private int totalPage;
    private int pageSize;
    private long totalHoDonThanhToan;

    public FrmHoaDonThanhToan() {
        initComponents();
        loadDataToTable();
        loadCBBHoaDon();
        loadCBBThanhToan();

        txtTongTien.setEditable(false);
        txtTongTien.setText(String.valueOf(getTongTienHoaDon()));
    }

    private void loadCBBHoaDon() {
        List<QLHoaDon> listQLHoaDon = new HoaDonServiceImpl().getAll();
        for (QLHoaDon hoaDon : listQLHoaDon) {
            listCBBHoaDon.add(hoaDon);
        }

        for (QLHoaDon qlHoaDon : listCBBHoaDon) {
            dcbmHoaDon.addElement(qlHoaDon.getId());
        }

        cbbHoaDon.setModel(dcbmHoaDon);
    }

    private void loadCBBThanhToan() {
        List<QLThanhToan> listQLThanhToan = new ThanhToanServiceImpl().getAllThanhToans();
        for (QLThanhToan thanhToan : listQLThanhToan) {
            listCBBThanhToan.add(thanhToan.getMaThanhToan());
        }

        for (String qlThanhToan : listCBBThanhToan) {
            dcbmThanhToan.addElement(qlThanhToan);
        }

        cbbThanhToan.setModel(dcbmThanhToan);
    }

    private void loadDataToTable() {
        listQLHoaDonThanhToan = hoaDonThanhToanService.getHoaDonThanhToanNoPagination();
        String[] header = {"ID", "Mã HDTT", "iD Hóa Đơn", "Mã Thanh Toan", "Tổng Tiền", "Ghi Chú"};
        tbHoaDonThanhToan.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        showData(listQLHoaDonThanhToan);
        totalHoDonThanhToan = hoaDonThanhToanService.countAllHoaDonThanhToan();
        lblTong.setText("Tổng : " + totalHoDonThanhToan);

    }

    private void mouseClick() {
        index = tbHoaDonThanhToan.getSelectedRow();
        txtMaHoaDonTT.setText(tbHoaDonThanhToan.getValueAt(index, 1).toString());
        cbbHoaDon.setSelectedItem(tbHoaDonThanhToan.getValueAt(index, 2));
        cbbThanhToan.setSelectedItem(tbHoaDonThanhToan.getValueAt(index, 3));
        txtGhiChu.setText(tbHoaDonThanhToan.getValueAt(index, 5).toString());
        txtTongTien.setText(tbHoaDonThanhToan.getValueAt(index, 4).toString());
    }

    private void showData(List<QLHoaDonThanhToan> listQLHoaDonThanhToan) {
        dtm.setRowCount(0);
        for (QLHoaDonThanhToan listHoaDonTT : listQLHoaDonThanhToan) {
            dtm.addRow(listHoaDonTT.toRowData());
        }
    }

    private double getTongTienHoaDon() {
        double tongTien = 0;
        List<QLHoaDon> listQLHoaDon = new HoaDonServiceImpl().getAll();
        for (QLHoaDon hoaDon : listQLHoaDon) {
            if (hoaDon.getId().equals(cbbHoaDon.getSelectedItem())) {
                tongTien = hoaDon.getTongTien();
            }
        }
        return tongTien;
    }

    private QLHoaDonThanhToan getHoaDonThanhToanFromInput() {
        QLHoaDonThanhToan qlHoaDonThanhToan = new QLHoaDonThanhToan();
        qlHoaDonThanhToan.setMaThanhToan(txtMaHoaDonTT.getText());
        qlHoaDonThanhToan.setHoaDon(cbbHoaDon.getSelectedItem().toString());
        qlHoaDonThanhToan.setThanhToan(cbbThanhToan.getSelectedItem().toString());
        qlHoaDonThanhToan.setGhiChu(txtGhiChu.getText());
        qlHoaDonThanhToan.setTongTien(Double.valueOf(txtTongTien.getText()));
        return qlHoaDonThanhToan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDonThanhToan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHoaDonTT = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        cbbHoaDon = new javax.swing.JComboBox<>();
        cbbThanhToan = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnVe = new javax.swing.JButton();
        lblLoad = new javax.swing.JLabel();
        btnTiep = new javax.swing.JButton();
        lblTong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(722, 750));
        setResizable(false);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbHoaDonThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHoaDonThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonThanhToanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDonThanhToan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn Thanh Toán"));

        jLabel1.setText("Mã HDTT :");

        jLabel2.setText("ID Hóa Đơn :");

        jLabel3.setText("Mã Thanh Toán :");

        jLabel4.setText("Ghi Chú :");

        jLabel5.setText("Tổng Tiền :");

        cbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHoaDonActionPerformed(evt);
            }
        });

        cbbThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnThem)
                .addGap(28, 28, 28)
                .addComponent(btnCapNhap)
                .addGap(29, 29, 29)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtMaHoaDonTT)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(cbbHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHoaDonTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnVe.setText("<<");
        btnVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeActionPerformed(evt);
            }
        });

        lblLoad.setText("1/1");

        btnTiep.setText(">>");
        btnTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepActionPerformed(evt);
            }
        });

        lblTong.setText("Tổng: 0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVe, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLoad)
                .addGap(18, 18, 18)
                .addComponent(btnTiep, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVe)
                    .addComponent(lblLoad)
                    .addComponent(btnTiep)
                    .addComponent(lblTong))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLHoaDonThanhToan qLHoaDonThanhToan = getHoaDonThanhToanFromInput();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Tạo Hóa Đơn Thanh Toán", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonThanhToanService.createNewHoaDonThanhToan(qLHoaDonThanhToan));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Đã Hủy Tạo Hóa Đơn Thanh Toán");
        }

        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHoaDonActionPerformed
//        double tongTien = 0;
//        List<QLHoaDon> listQLHoaDon = new HoaDonServiceImpl().getAll();
//        for (QLHoaDon hoaDon : listQLHoaDon) {
//            if (hoaDon.getId().equals(cbbHoaDon.getSelectedItem())) {
//                tongTien = hoaDon.getTongTien();
//                System.out.println("" + hoaDon.getId());
//            }
//        }
//        System.out.println("" + tongTien);
    }//GEN-LAST:event_cbbHoaDonActionPerformed

    private void btnVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeActionPerformed
//        if (firstResult > 1) {
//            firstResult--;
//        }
//        loadDataToTable();
    }//GEN-LAST:event_btnVeActionPerformed

    private void btnTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepActionPerformed
//        if (firstResult < totalPages) {
//            firstResult++;
//        }
//        loadDataToTable();
    }//GEN-LAST:event_btnTiepActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        index = this.tbHoaDonThanhToan.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        QLHoaDonThanhToan qLHoaDonThanhToan = getHoaDonThanhToanFromInput();
        qLHoaDonThanhToan.setId(UUID.fromString(tbHoaDonThanhToan.getValueAt(index, 0).toString()));
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Cập Nhập Hóa Đơn Thanh Toán", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonThanhToanService.updateHoaDonThanhToanById(qLHoaDonThanhToan));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Đã Hủy Cập Nhập Hóa Đơn Thanh Toán");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = this.tbHoaDonThanhToan.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        UUID id = UUID.fromString(tbHoaDonThanhToan.getValueAt(index, 0).toString());
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Hóa Đơn Thanh Toán", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonThanhToanService.deleteHoaDonThanhToanById(id));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Đã Hủy Xóa Hóa Đơn Thanh Toán");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbHoaDonThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonThanhToanMouseClicked
        mouseClick();
    }//GEN-LAST:event_tbHoaDonThanhToanMouseClicked

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
            java.util.logging.Logger.getLogger(FrmHoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHoaDonThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTiep;
    private javax.swing.JButton btnVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbHoaDon;
    private javax.swing.JComboBox<String> cbbThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tbHoaDonThanhToan;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHoaDonTT;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
