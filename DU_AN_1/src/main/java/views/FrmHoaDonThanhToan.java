/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodel.HoaDon;
import domainmodel.ThanhToan;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLHoaDonThanhToan;

import service.IHoaDonThanhToanService;

import service.Impl.HoaDonThanhToanServiceImpl;

/**
 *
 * @author ASUS
 */
public class FrmHoaDonThanhToan extends javax.swing.JFrame {

    private List<QLHoaDonThanhToan> listQLHoaDonThanHToan = new ArrayList<>();
    private List<UUID> listCBBHoaDon = new ArrayList<>();
    private List<UUID> listCBBThanhToan = new ArrayList<>();
    private DefaultComboBoxModel dcbmHoaDon = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmThanhToan = new DefaultComboBoxModel();
    private IHoaDonThanhToanService hoaDonThanhToanService = new HoaDonThanhToanServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();

    private int index = -1;
    private int curentPage;
    private int totalPage;
    private int pageSize;
    private long totalHoaDonThanhToan;

    public FrmHoaDonThanhToan() {
        initComponents();
        txtTongTien.setEditable(false);
    }

    private void loadDataToTable() {
        //id,maThanhToan, hoaDon, thanhToan, tongTien, ghiChu
        listQLHoaDonThanHToan = hoaDonThanhToanService.getHoaDonThanhToanNoPagination();
        String[] header = {"ID", "Mã Thanh Toán", "Mã Hóa Đơn", "Mã Thanh Toán", "Tổng Tiền", "Ghi Chú"};
        tbHoaDonThanhToan.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        showData(listQLHoaDonThanHToan);

        totalHoaDonThanhToan = hoaDonThanhToanService.countAllHoaDonThanhToan();
        lblTong.setText("Tổng : " + totalHoaDonThanhToan);
    }

    private void showData(List<QLHoaDonThanhToan> listQLHoaDonThanhToan) {
        dtm.setRowCount(0);
        listQLHoaDonThanhToan.forEach(c -> dtm.addRow(c.toRowData()));
    }

    private void load() {
    }

    private QLHoaDonThanhToan getHoaDonDichVuFromInput() {
//        QLHoaDonThanhToan qlHoaDonThanhToan = new QLHoaDonThanhToan();
//        qlHoaDonThanhToan.setMaThanhToan(UUID.fromString(txtMa.getText()));
//        // select all lấy ra tiền trong hóa đơn
//        // tổng tiền = tiền trong hóa đơn 
//        HoaDon hoaDon = new HoaDon();
//        hoaDon.setId(UUID.fromString(cbbHoaDon.getSelectedItem().toString()));
//        qlHoaDonThanhToan.setHoaDon(hoaDon);
//        qlHoaDonThanhToan.setTongTien(Double.parseDouble(txtTongTien.getText()));
//
//        // hình thức thanh toán.
//        ThanhToan thanhToan = new ThanhToan();
//        thanhToan.setId(UUID.fromString(cbbThanhToan.getSelectedItem().toString()));
//
//        qlHoaDonThanhToan.setThanhToan(thanhToan);
//        qlHoaDonThanhToan.setGhiChu(txtGhiChu.getText());
//
//        return qlHoaDonThanhToan;
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnViewNuocUong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnVe = new javax.swing.JButton();
        lblLoad = new javax.swing.JLabel();
        btnTiep = new javax.swing.JButton();
        lblTong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDonThanhToan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbHoaDon = new javax.swing.JComboBox<>();
        cbbThanhToan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(722, 750));
        setResizable(false);

        jpnViewNuocUong.setPreferredSize(new java.awt.Dimension(764, 687));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        lblTong.setText("Tổng : 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVe)
                    .addComponent(lblLoad)
                    .addComponent(btnTiep)
                    .addComponent(lblTong))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn Thanh Toán"));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Cập Nhập");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnThem)
                .addGap(30, 30, 30)
                .addComponent(btnSua)
                .addGap(32, 32, 32)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Mã TT :");

        jLabel6.setText("Id Hóa Đơn :");

        jLabel4.setText("Id Thanh Toán :");

        cbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng Tiền:");

        jLabel5.setText("Ghi Chú :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, 0, 209, Short.MAX_VALUE)
                                            .addComponent(cbbThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(709, 709, 709))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Hóa Đơn Thanh Toán");

        javax.swing.GroupLayout jpnViewNuocUongLayout = new javax.swing.GroupLayout(jpnViewNuocUong);
        jpnViewNuocUong.setLayout(jpnViewNuocUongLayout);
        jpnViewNuocUongLayout.setHorizontalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(285, 285, 285))
            .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpnViewNuocUongLayout.setVerticalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeActionPerformed
//        if (currentPage > 1) {
//            currentPage--;
//        }
//        loadDataToTable();
    }//GEN-LAST:event_btnVeActionPerformed

    private void btnTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepActionPerformed
//        if (currentPage < totalPages) {
//            currentPage++;
//        }
//        loadDataToTable();
    }//GEN-LAST:event_btnTiepActionPerformed

    private void tbHoaDonThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonThanhToanMouseClicked
        int index = this.tbHoaDonThanhToan.getSelectedRow();
        if (index == -1) {
            return;
        }
        this.txtMa.setText(tbHoaDonThanhToan.getValueAt(index, 1).toString());
        cbbHoaDon.setSelectedItem(tbHoaDonThanhToan.getValueAt(index, 2).toString());
        cbbThanhToan.setSelectedItem(tbHoaDonThanhToan.getValueAt(index, 3).toString());
        txtTongTien.setText(tbHoaDonThanhToan.getValueAt(index, 4).toString());
        txtGhiChu.setText(tbHoaDonThanhToan.getValueAt(index, 5).toString());

    }//GEN-LAST:event_tbHoaDonThanhToanMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLHoaDonThanhToan qLHoaDonThanhToan = getHoaDonDichVuFromInput();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn thêm Mới Nước Uống", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonThanhToanService.createNewHoaDonThanhToan(qLHoaDonThanhToan));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy thêm nước uống");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = this.tbHoaDonThanhToan.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        QLHoaDonThanhToan qLHoaDonThanhToan = getHoaDonDichVuFromInput();
        qLHoaDonThanhToan.setId(UUID.fromString(tbHoaDonThanhToan.getValueAt(index, 0).toString()));

        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Update Nước "
                + "Uống", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, hoaDonThanhToanService.updateHoaDonThanhToanById(qLHoaDonThanhToan));

        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy upadte nước uống");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = this.tbHoaDonThanhToan.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        UUID id = UUID.fromString(this.tbHoaDonThanhToan.getValueAt(index, 0).toString());
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Hóa Đơn Thanh Toán", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, hoaDonThanhToanService.deleteHoaDonThanhToanById(id));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy Xóa Hóa Đơn Thanh Toán");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

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
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTiep;
    private javax.swing.JButton btnVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbHoaDon;
    private javax.swing.JComboBox<String> cbbThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnViewNuocUong;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tbHoaDonThanhToan;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
