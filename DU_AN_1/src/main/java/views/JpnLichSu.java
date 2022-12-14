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
//        txtTenKhachHang.setEnabled(false);
//        txtNgayDatLich.setEnabled(false);
//        txtTrangThai.setEnabled(false);
//        txtTenCa.setEnabled(false);
//        txtTenSanBong.setEnabled(false);
        txtTenKhachHang.setEditable(false);
        txtNgayDatLich.setEditable(false);
        txtTrangThai.setEditable(false);
        txtTenCa.setEditable(false);
        txtTenSanBong.setEditable(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTenSanBong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenCa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayDatLich = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLichSu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setBackground(new java.awt.Color(65, 147, 169));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lịch Sử Đặt Lịch");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Lịch Sử Đặt Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên khách hàng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tên sân bóng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên ca:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày đặt lịch:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Lịch Sử Đặt Lịch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Xin mời bạn nhập:");

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm theo tên:");

        btnTimKiem.setBackground(new java.awt.Color(51, 102, 255));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSearch)
                                .addGap(161, 161, 161))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnLamMoi.setBackground(new java.awt.Color(255, 0, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayDatLich, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(txtTrangThai)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgayDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        txtTenKhachHang.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(557, 557, 557))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtTenKhachHang.setText("");
        txtTenSanBong.setText("");
        txtTenCa.setText("");
        txtNgayDatLich.setText("");
        txtTrangThai.setText("");
        cbbTimKiem.setSelectedIndex(0);
        txtSearch.setText("");
        lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichs();
        showDataTable(lstQLLichSuDatLichs);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLichSu;
    private javax.swing.JTextField txtNgayDatLich;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenCa;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenSanBong;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
