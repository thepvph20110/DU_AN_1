/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLLichSuDatLich;
import service.ILichSuDatLichService;
import service.Impl.LichSuDatLichServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnLichSu extends javax.swing.JPanel {

    /**
     * Creates new form JpnLichSu
     */
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private List<QLLichSuDatLich> lstQLLichSuDatLichs;
    private List<String> lstCombobox;
    private ILichSuDatLichService iLichSuDatLichService;

    public JpnLichSu() {
        initComponents();
        tbLichSu.setModel(dtm = new DefaultTableModel());
        String[] header = {"MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "SỐ ĐIỆN THOẠI", "NGÀY ĐẶT LỊCH", "NGÀY ĐẾN SÂN", "TÊN SÂN BÓNG", "TÊN CA", "TRẠNG THÁI"};
        dtm.setColumnIdentifiers(header);
        lstQLLichSuDatLichs = new ArrayList<>();
        iLichSuDatLichService = new LichSuDatLichServiceImpl();
        lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichs();
        showDataTable(lstQLLichSuDatLichs);
        loadDataComBo();
    }

    private void loadDataComBo() {
        lstCombobox = new ArrayList<>();
        lstCombobox.add("SỐ ĐIỆN THOẠI");
        lstCombobox.add("TÊN KHÁCH HÀNG");
        cbbTimKiem.setModel(dcbm = new DefaultComboBoxModel());
        lstCombobox.forEach((t) -> cbbTimKiem.addItem(t));

    }

    private void showDataTable(List<QLLichSuDatLich> lstQLLichSuDatLichs) {
        dtm.setRowCount(0);
        for (QLLichSuDatLich lst : lstQLLichSuDatLichs) {
            Object[] toData = {lst.getQLPhieuDatLich().getKhachHang().getMaKhachHang(), lst.getQLPhieuDatLich().getKhachHang().getTenKhachHang(),
                lst.getQLPhieuDatLich().getKhachHang().getSoDienThoai(), lst.getNgayDatLich(), lst.getNgayDenSan(),
                lst.getQLPhieuDatLich().getSanCa().getTenSanBong(), lst.getQLPhieuDatLich().getSanCa().getTenCa(), lst.getTrangThai()};
            dtm.addRow(toData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbTimKiem = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLichSu = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtTenKhachHang = new javax.swing.JTextField();
        txtTenSanBong = new javax.swing.JTextField();
        txtTenCa = new javax.swing.JTextField();
        txtNgayDatLich = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDanhSach = new javax.swing.JLabel();

        setBackground(new java.awt.Color(186, 228, 229));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LỊCH SỬ ĐẶT LỊCH");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TÌM KIẾM THEO: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("XIN MỜI BẠN NHẬP:");

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbLichSu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLichSuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLichSu);

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("TÌM KIẾM NGAY");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(186, 228, 229));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("TÊN KHÁCH HÀNG: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("TÊN SÂN BÓNG: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("TRẠNG THÁI: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("TÊN CA: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("NGÀY ĐẶT LỊCH: ");

        txtDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDanhSach.setText("DANH SÁCH LICH SỬ ĐẶT LỊCH");
        txtDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhSachMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(435, 435, 435))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtDanhSach)
                        .addGap(461, 461, 461))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayDatLich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtDanhSach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String checkTrong() {
        if (txtSearch.getText().isBlank()) {
            return "KHÔNG ĐƯỢC BỎ TRỐNG";
        } else {
            return "OK";
        }
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String search = (String) cbbTimKiem.getSelectedItem();
        String check = checkTrong();
        if (check != "OK") {
            JOptionPane.showMessageDialog(this, check);
            return;
        }
        lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichs();
        showDataTable(lstQLLichSuDatLichs);

        if (search.equals("SỐ ĐIỆN THOẠI")) {
            String soDienThoai = txtSearch.getText();
            lstQLLichSuDatLichs.clear();
            lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichsBySoDienThoai(soDienThoai.trim());
            showDataTable(lstQLLichSuDatLichs);
        }
        if (search.equals("TÊN KHÁCH HÀNG")) {
            String tenKhachHang = txtSearch.getText();
            lstQLLichSuDatLichs.clear();
            lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichsByTenKhachHang(tenKhachHang.trim());
            showDataTable(lstQLLichSuDatLichs);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLichSuMouseClicked
        int row = tbLichSu.getSelectedRow();
        QLLichSuDatLich qLLichSuDatLich = lstQLLichSuDatLichs.get(row);
        txtTenKhachHang.setText(qLLichSuDatLich.getQLPhieuDatLich().getKhachHang().getTenKhachHang());
        txtTenSanBong.setText(qLLichSuDatLich.getQLPhieuDatLich().getSanCa().getTenSanBong());
        txtTenCa.setText(qLLichSuDatLich.getQLPhieuDatLich().getSanCa().getTenCa());
        txtNgayDatLich.setText(String.valueOf(qLLichSuDatLich.getNgayDatLich()));
        txtTrangThai.setText(String.valueOf(qLLichSuDatLich.getTrangThai()));
    }//GEN-LAST:event_tbLichSuMouseClicked

    private void txtDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhSachMouseClicked
        lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichs();
        showDataTable(lstQLLichSuDatLichs);
    }//GEN-LAST:event_txtDanhSachMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbLichSu;
    private javax.swing.JLabel txtDanhSach;
    private javax.swing.JTextField txtNgayDatLich;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenCa;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenSanBong;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
