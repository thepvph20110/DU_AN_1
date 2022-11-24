/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import enumclass.trangThaiSanCa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLCa;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.ICaService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author hp
 */
public class FrmSanCa extends javax.swing.JFrame {

    private List<QLSanCa> listQLSanCa = new ArrayList<>();
    private List<QLSanBong> listQLSanBong = new ArrayList<>();
    private List<QLCa> listQLCa = new ArrayList<>();
    private ISanCaService iSanCaService = new SanCaServiceImpl();
    private ISanBongService iSanBongService = new SanBongServiceImpl();
    private ICaService iCaService = new CaServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();

    /**
     *
     * Creates new form FrmSanCa
     */
    public FrmSanCa() {
        initComponents();
        jTable1.setModel(dtm);
        String[] header = {"ID", "Ngày tạo", "Ca", "Sân bóng","Sức chứa","TG Bắt Đầu","TG Kết Thúc", "Giá Ca", "Trạng thái"};
        dtm.setColumnIdentifiers(header);
        listQLCa = iCaService.getAll();
        listQLSanBong = iSanBongService.getAll();
        listQLSanCa = iSanCaService.getAll();
        //listQLPhieuDatLich = 
        loadCbbCa();
        loadCbbSanBong();
        Date date = new Date();
        jDateNgayTao.setDate(date);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbCa = new javax.swing.JComboBox<>();
        cbbSanBong = new javax.swing.JComboBox<>();
        txtGiaCa = new javax.swing.JTextField();
        radioTrong = new javax.swing.JRadioButton();
        radioChoNhanSan = new javax.swing.JRadioButton();
        radioKhongTrong = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateNgayTao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ SÂN CA");

        jLabel3.setText("Ca");

        jLabel4.setText("Ngày tạo");

        jLabel5.setText("Sân bóng");

        jLabel7.setText("Giá Ca");

        jLabel8.setText("Trạng thái");

        buttonGroup1.add(radioTrong);
        radioTrong.setSelected(true);
        radioTrong.setText("Đang trống");

        buttonGroup1.add(radioChoNhanSan);
        radioChoNhanSan.setText("Cho nhận sân");

        buttonGroup1.add(radioKhongTrong);
        radioKhongTrong.setText("Không trống");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnSave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(btnUpdate)
                                .addGap(89, 89, 89)
                                .addComponent(btnDelete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbCa, 0, 154, Short.MAX_VALUE)
                                    .addComponent(cbbSanBong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(52, 52, 52)
                                .addComponent(radioTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioChoNhanSan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioKhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaCa, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jDateNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGiaCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(radioTrong)
                            .addComponent(radioChoNhanSan)
                            .addComponent(radioKhongTrong))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        QLSanCa qLSanCa = new QLSanCa();
        QLCa qLCa = new QLCa();
        QLSanBong qLSanBong = new QLSanBong();
        String tenSanBong = cbbSanBong.getSelectedItem()+"";
        String tenca = cbbCa.getSelectedItem()+"";
        QLSanCa qlsc = new QLSanCa(null, tenca, tenSanBong,0,null,null, new Date(), 0, qLSanCa.getTrangThai());
        JOptionPane.showMessageDialog(this, iSanCaService.save(qlsc));
        listQLSanCa = iSanCaService.getAll();
        showData(listQLSanBong);
        //}

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed


        QLSanCa qLSanCa = new QLSanCa();
        QLCa qLCa = new QLCa();
        QLSanBong qLSanBong = new QLSanBong();
        String tenSanBong = cbbSanBong.getSelectedItem()+"";
        String tenca = cbbCa.getSelectedItem()+"";
        if (radioChoNhanSan.isSelected()) {
            qLSanCa.setTrangThai(trangThaiSanCa.CHO_NHAN_SAN);
        } else if (radioKhongTrong.isSelected()) {
            qLSanCa.setTrangThai(trangThaiSanCa.KHONG_TRONG);
        } else {
            qLSanCa.setTrangThai(trangThaiSanCa.DANG_TRONG);
        }
        QLSanCa qlsc = new QLSanCa(mountClick().getId(), tenca, tenSanBong,0,null,null, new Date(), 0, qLSanCa.getTrangThai());
        JOptionPane.showMessageDialog(this, iSanCaService.update(qlsc));
        listQLSanCa = iSanCaService.getAll();
        showData(listQLSanBong);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        QLSanCa qLSanCa = new QLSanCa();
        QLCa qLCa = new QLCa();
        QLSanBong qLSanBong = new QLSanBong();
        String tenSanBong = cbbSanBong.getSelectedItem()+"";
        String tenca = cbbCa.getSelectedItem()+"";
        if (radioChoNhanSan.isSelected()) {
            qLSanCa.setTrangThai(trangThaiSanCa.CHO_NHAN_SAN);
        } else if (radioKhongTrong.isSelected()) {
            qLSanCa.setTrangThai(trangThaiSanCa.KHONG_TRONG);
        } else {
            qLSanCa.setTrangThai(trangThaiSanCa.DANG_TRONG);
        }
        QLSanCa qlsc = new QLSanCa(mountClick().getId(), tenca, tenSanBong,0,null,null, new Date(), 0, qLSanCa.getTrangThai());
        JOptionPane.showMessageDialog(this, iSanCaService.delete(qlsc));
        listQLSanCa = iSanCaService.getAll();
        showData(listQLSanBong);


    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSanCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSanCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSanCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSanCa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSanCa().setVisible(true);
            }
        });
    }

    private QLSanCa mountClick() {
        int row = jTable1.getSelectedRow();
        return listQLSanCa.get(row);
    }

    private void fillData(int index) {
        QLSanCa qLSanCa = listQLSanCa.get(index);
        txtGiaCa.setText(String.valueOf(qLSanCa.getGiaCaSan()));
        jDateNgayTao.setDate(qLSanCa.getNgayTao());
        cbbCa.setSelectedItem(qLSanCa.getTenCa());
        cbbSanBong.setSelectedItem(qLSanCa.getTenSanBong());
        if (qLSanCa.getTrangThai() == trangThaiSanCa.CHO_NHAN_SAN) {
            radioChoNhanSan.setSelected(true);
        } else if (qLSanCa.getTrangThai() == trangThaiSanCa.DANG_TRONG) {
            radioTrong.setSelected(true);
        } else {
            radioKhongTrong.setSelected(true);
        }
    }

    private void showData(List<QLSanBong> listQLSanBong) {
        dtm.setRowCount(0);
        for (QLSanCa qLSanCa : listQLSanCa) {
            dtm.addRow(qLSanCa.toDataRow());
        }
    }

    private void loadCbbCa() {
        for (QLCa qLCa : listQLCa) {
            cbbCa.addItem(qLCa.getTenCa());
        }
    }

    private void loadCbbSanBong() {
        for (QLSanBong qLSanBong : listQLSanBong) {
            cbbSanBong.addItem(qLSanBong.getTenSanBong());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCa;
    private javax.swing.JComboBox<String> cbbSanBong;
    private com.toedter.calendar.JDateChooser jDateNgayTao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioChoNhanSan;
    private javax.swing.JRadioButton radioKhongTrong;
    private javax.swing.JRadioButton radioTrong;
    private javax.swing.JTextField txtGiaCa;
    // End of variables declaration//GEN-END:variables
}
