/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import enumclass.trangThaiSanBong;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import service.ILoaiSanService;
import service.ISanBongService;
import service.Impl.LoaiSanServiceImpl;
import service.Impl.SanBongServiceImpl;

/**
 *
 * @author hp
 */
public class FrmSanBong extends javax.swing.JFrame {

    private List<QLLoaiSan> listQLLoaiSan = new ArrayList<>();
    private List<QLSanBong> listQLSanBong = new ArrayList<>();
    private ILoaiSanService iLoaiSanService = new LoaiSanServiceImpl();
    private ISanBongService iSanBongService = new SanBongServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form FrmSanBong
     */
    public FrmSanBong() {
        initComponents();
        jTable1.setModel(dtm);
        String[] header = {"Giá sân", "Mã sân", "Sức chứa", "Tên sân", "Trạng thái", "Loại Sân"};
        dtm.setColumnIdentifiers(header);
        listQLLoaiSan = iLoaiSanService.getAll();
        listQLSanBong = iSanBongService.getAll();
        loadCbbLoaiSan();
        showData(listQLSanBong);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtGiaSan = new javax.swing.JTextField();
        txtMaSanBong = new javax.swing.JTextField();
        txtSucChua = new javax.swing.JTextField();
        txtTenSanBong = new javax.swing.JTextField();
        radioSuaChua = new javax.swing.JRadioButton();
        radioHoatDong = new javax.swing.JRadioButton();
        cbbLoaiSan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ SÂN BÓNG");

        jLabel2.setText("Giá sân");

        jLabel3.setText("Mã sân bóng");

        jLabel4.setText("Sức chứa");

        jLabel5.setText("Tên sân bóng");

        jLabel6.setText("Trạng Thái");

        jLabel7.setText("Loại Sân");

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
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(radioSuaChua);
        radioSuaChua.setSelected(true);
        radioSuaChua.setText("Sửa chữa");

        buttonGroup1.add(radioHoatDong);
        radioHoatDong.setText("Hoạt động");

        jLabel8.setText("Search");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnSave)
                        .addGap(93, 93, 93)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(radioSuaChua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(radioHoatDong))
                                            .addComponent(cbbLoaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(radioSuaChua)
                    .addComponent(radioHoatDong))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbLoaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listQLSanBong.clear();
        listQLSanBong = iSanBongService.searchByName(txtSearch.getText());
        showData(listQLSanBong);
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(FrmSanBong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSanBong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSanBong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSanBong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSanBong().setVisible(true);
            }
        });
    }

    private QLSanBong mountClick() {
        int row = jTable1.getSelectedRow();
        return listQLSanBong.get(row);
    }

    private void showData(List<QLSanBong> listQLSanBong) {
        dtm.setRowCount(0);
        for (QLSanBong qLSanBong : listQLSanBong) {
            dtm.addRow(qLSanBong.toDataRow());
        }
    }

    private void loadCbbLoaiSan() {
        for (QLLoaiSan qLLoaiSan : listQLLoaiSan) {
            cbbLoaiSan.addItem(qLLoaiSan.getTenLoaiSan());
        }
    }

    private void save() {
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        QLSanBong qlsb = new QLSanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        if (maSanBong.length() == 0 || tenSanBong.length() == 0 || giaSan.length() == 0 || sucChua.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        }  else {

            QLSanBong qLSanBong = new QLSanBong(null, maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), cbbLoaiSan.getSelectedItem().toString(), qlsb.getTrangThai());
            JOptionPane.showMessageDialog(this, iSanBongService.save(qLSanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);

        }
    }

    private void update() {
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        QLSanBong qlsb = new QLSanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected Row ???");
        } else {
            
                QLSanBong qLSanBong = new QLSanBong(mountClick().getId(), maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), cbbLoaiSan.getSelectedItem().toString(), qlsb.getTrangThai());
                JOptionPane.showMessageDialog(this, iSanBongService.update(qLSanBong));
                listQLSanBong = iSanBongService.getAll();
                showData(listQLSanBong);

            }
        
    }

    private void delete() {
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        QLSanBong qlsb = new QLSanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected Row ???");
        } else {
            QLSanBong qLSanBong = new QLSanBong(mountClick().getId(), maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), cbbLoaiSan.getSelectedItem().toString(), qlsb.getTrangThai());
            JOptionPane.showMessageDialog(this, iSanBongService.delete(qLSanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);
        }

    }

    private void fillData(int index) {
        QLSanBong qlsb = listQLSanBong.get(index);
        txtGiaSan.setText(String.valueOf(qlsb.getGiaSan()));
        txtSucChua.setText(String.valueOf(qlsb.getSucChua()));
        txtMaSanBong.setText(qlsb.getMaSanBong());
        txtTenSanBong.setText(qlsb.getTenSanBong());
        if (qlsb.getTrangThai() == trangThaiSanBong.HOAT_DONG) {
            radioHoatDong.setSelected(true);
        } else {
            radioSuaChua.setSelected(true);
        }
        cbbLoaiSan.setSelectedItem(qlsb.getTenLoaiSan());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaiSan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioHoatDong;
    private javax.swing.JRadioButton radioSuaChua;
    private javax.swing.JTextField txtGiaSan;
    private javax.swing.JTextField txtMaSanBong;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSucChua;
    private javax.swing.JTextField txtTenSanBong;
    // End of variables declaration//GEN-END:variables
}
