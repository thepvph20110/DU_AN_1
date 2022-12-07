/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
        txtNhapVao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLichSu = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("LỊCH SỬ ĐẶT LỊCH");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TÌM KIẾM THEO: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("XIN MỜI BẠN NHẬP:");

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNhapVao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapVaoActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tbLichSu);

        btnTimKiem.setText("TÌM KIẾM NGAY");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(321, 321, 321))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNhapVao, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhapVao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNhapVaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapVaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapVaoActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String search = (String) cbbTimKiem.getSelectedItem();
        if (search.equals("SỐ ĐIỆN THOẠI")) {
            String soDienThoai = txtNhapVao.getText();
            lstQLLichSuDatLichs.clear();
            lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichsBySoDienThoai(soDienThoai);
        }
        if (search.equals("TÊN KHÁCH HÀNG")) {
            String tenKhachHang = "NGUYỄN QUỐC TUẤN";
            lstQLLichSuDatLichs.clear();
            lstQLLichSuDatLichs = iLichSuDatLichService.getAllLichSuDatLichsByTenKhachHang(tenKhachHang);
        }
        showDataTable(lstQLLichSuDatLichs);
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbLichSu;
    private javax.swing.JTextField txtNhapVao;
    // End of variables declaration//GEN-END:variables
}
