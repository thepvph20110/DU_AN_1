/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodel.Acount;
import domainmodel.KhachHang;
import domainmodel.SanCa;
import enumclass.trangThaiKhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLAcount;
import modelview.QLKhachHang;
import modelview.QLSanCa;
import service.IKhachHangService;
import service.Impl.KhachHangServiceImpl;

/**
 *
 * @author hp
 */
public class FrmKhachHang extends javax.swing.JFrame {

    private List<QLKhachHang> listKhachHang = new ArrayList<>();
    private IKhachHangService iKhachHangService = new KhachHangServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private QLSanCa sanCa = new QLSanCa();
    private Acount acount = new Acount();

    /**
     * Creates new form FrmKhachHang
     */
    public FrmKhachHang(QLSanCa sanCa, Acount acountEntity) {
        initComponents();
        acount = acountEntity;
        this.sanCa = sanCa;
        jTable1.setModel(dtm);
        String[] header = {"ID", "Mã KH", "Tên KH", "Email", "SÐT", "Ghi Chú", "Trạng thái"};
        dtm.setColumnIdentifiers(header);
        listKhachHang = iKhachHangService.getAll();
        showData(listKhachHang);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        radioCanhBao = new javax.swing.JRadioButton();
        radioBinhThuong = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel3.setText("SĐT");

        jLabel4.setText("Ghi chú");

        jLabel5.setText("Trạng thái");

        buttonGroup1.add(radioCanhBao);
        radioCanhBao.setText("Cảnh cáo");

        buttonGroup1.add(radioBinhThuong);
        radioBinhThuong.setText("Bình thường");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel6.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(94, 94, 94)
                        .addComponent(btnUpdate)
                        .addGap(107, 107, 107)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioCanhBao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioBinhThuong)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioCanhBao)
                    .addComponent(radioBinhThuong))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = UUID.randomUUID().toString();
        String ten = txtTenKh.getText().trim();
        String ma = txtMaKH.getText().trim();
        String ghiChu = txtGhiChu.getText().trim();
        String sdt = txtSoDT.getText().trim();
        String email = txtEmail.getText().trim();
        QLKhachHang qLKhachHang = new QLKhachHang();
        if (radioBinhThuong.isSelected()) {
            qLKhachHang.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        } else {
            qLKhachHang.setTrangThai(trangThaiKhachHang.CANH_CAO);
        }
        KhachHang khachHang = new KhachHang(id , ma, ten, email, sdt, ghiChu, qLKhachHang.getTrangThai());
        String checkSave = iKhachHangService.save(khachHang);
        
        listKhachHang = iKhachHangService.getAll();
        showData(listKhachHang);
        if (checkSave.equals("Save complete")) {
            int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thêm khách hàng", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                QLKhachHang qLKhachHang1 = new QLKhachHang(khachHang.getId(), khachHang.getMaKhachHang(), khachHang.getTenKhachHang(),
                        khachHang.getMail(), khachHang.getSoDienThoai(), khachHang.getGhiChu(), khachHang.getTrangThai());
                new FrmPhieuDatLich(qLKhachHang1, sanCa, acount).setVisible(true);
                this.dispose();
            }
        }else{
           JOptionPane.showMessageDialog(this,"Lưu thất bại"); 
        }
        

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = jTable1.getSelectedRow();
        String ten = txtTenKh.getText().trim();
        String ma = txtMaKH.getText().trim();
        String ghiChu = txtGhiChu.getText().trim();
        String sdt = txtSoDT.getText().trim();
        String email = txtEmail.getText().trim();
        QLKhachHang qLKhachHang = new QLKhachHang();
        if (radioBinhThuong.isSelected()) {
            qLKhachHang.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        } else {
            qLKhachHang.setTrangThai(trangThaiKhachHang.CANH_CAO);
        }
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ??");
        } else {
            if (ten.length() == 0 || ma.length() == 0 || ghiChu.length() == 0 || sdt.length() == 0 || email.length() == 0) {
                JOptionPane.showMessageDialog(this, "Null");
            } else {
                QLKhachHang khachHang = new QLKhachHang(mountClick().getId(), ma, ten, email, sdt, ghiChu, qLKhachHang.getTrangThai());
                JOptionPane.showMessageDialog(this, iKhachHangService.update(khachHang));
                listKhachHang = iKhachHangService.getAll();
                showData(listKhachHang);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = jTable1.getSelectedRow();
        String ten = txtTenKh.getText().trim();
        String ma = txtMaKH.getText().trim();
        String ghiChu = txtGhiChu.getText().trim();
        String sdt = txtSoDT.getText().trim();
        String email = txtEmail.getText().trim();
        QLKhachHang qLKhachHang = new QLKhachHang();
        if (radioBinhThuong.isSelected()) {
            qLKhachHang.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        } else {
            qLKhachHang.setTrangThai(trangThaiKhachHang.CANH_CAO);
        }
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ??");
        } else {
            QLKhachHang khachHang = new QLKhachHang(mountClick().getId(), ma, ten, email, sdt, ghiChu, qLKhachHang.getTrangThai());
            JOptionPane.showMessageDialog(this, iKhachHangService.delete(khachHang));
            listKhachHang = iKhachHangService.getAll();
            showData(listKhachHang);

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thêm khách hàng", "Thông Báo", JOptionPane.YES_NO_OPTION);
        int index = jTable1.getSelectedRow();
        fillData(index);
        QLKhachHang qLKhachHang = listKhachHang.get(index);
        if (check == JOptionPane.YES_OPTION) {
            new FrmPhieuDatLich(qLKhachHang, sanCa, acount).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private QLKhachHang mountClick() {
        int row = jTable1.getSelectedRow();
        return listKhachHang.get(row);
    }

    private void fillData(int index) {
        QLKhachHang qLKhachHang = listKhachHang.get(index);
        txtGhiChu.setText(qLKhachHang.getGhiChu());
        txtMaKH.setText(qLKhachHang.getMaKhachHang());
        txtSoDT.setText(qLKhachHang.getSoDienThoai());
        txtTenKh.setText(qLKhachHang.getTenKhachHang());
        if (qLKhachHang.getTrangThai() == trangThaiKhachHang.BINH_THUONG) {
            radioBinhThuong.setSelected(true);
        } else {
            radioCanhBao.setSelected(true);

        }
    }

    private void showData(List<QLKhachHang> listQLKhachHang) {
        dtm.setRowCount(0);
        for (QLKhachHang qLKhachHang : listQLKhachHang) {
            dtm.addRow((Object[]) qLKhachHang.toDataRow());
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioBinhThuong;
    private javax.swing.JRadioButton radioCanhBao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenKh;
    // End of variables declaration//GEN-END:variables
}
