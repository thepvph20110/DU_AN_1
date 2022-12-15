package views;

import enumclass.trangThaiPhuPhi;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLPhuPhi;
import service.IPhuPhiService;
import service.Impl.PhuPhiServiceImpl;

public class FrmQLPhuPhi extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private List<QLPhuPhi> lstQLPhuPhis;
    private IPhuPhiService iPhuPhiService;

    public FrmQLPhuPhi() {
        initComponents();
        showDataTable();
        txtMa.setEnabled(false);
    }

    private String checkTrong() {
        if (txtTen.getText().isBlank()) {
            return "KHÔNG ĐƯỢC BỎ TRỐNG";
        } else if (txtTen.getText().matches("^[0-9]+$")) {
            return "TÊN CÓ SỐ RỒI";
        } else {
            return "OK";
        }
    }

    private QLPhuPhi formInputqLPhuPhiSave() {
        String check = checkTrong();
        QLPhuPhi ql = new QLPhuPhi();
        if (check != "OK") {
            JOptionPane.showMessageDialog(this, check);
        } else {
            ql.setId(null);
            String ma = iPhuPhiService.genMaPhuPhi(lstQLPhuPhis);
            ql.setMaPhuPhi(ma);
            String ten = txtTen.getText();
            ql.setTenPhuPhi(ten);
            return ql;
        }
        return null;
    }

    private QLPhuPhi formInputqLPhuPhiUpdate() {
        String check = checkTrong();
        QLPhuPhi ql = new QLPhuPhi();
        if (check != "OK") {
            JOptionPane.showMessageDialog(this, check);
        } else {
            int row = tbQLPhuPhi.getSelectedRow();
            QLPhuPhi qlgetID = lstQLPhuPhis.get(row);
            String id = qlgetID.getId();
            ql.setId(id);
            String ma = txtMa.getText();
            ql.setMaPhuPhi(ma);
            String ten = txtTen.getText();
            ql.setTenPhuPhi(ten);
            return ql;
        }
        return null;

    }

    private void showDataTable() {
        tbQLPhuPhi.setModel(dtm = new DefaultTableModel());
        lstQLPhuPhis = new ArrayList<>();
        iPhuPhiService = new PhuPhiServiceImpl();
        lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
        String[] header = {"MÃ", "TÊN"};
        dtm.setColumnIdentifiers(header);
        loadDataTable(lstQLPhuPhis);
    }

    private void loadDataTable(List<QLPhuPhi> lstQLPhuPhis) {
        dtm.setRowCount(0);
        for (QLPhuPhi l : lstQLPhuPhis) {
            Object[] toData = {l.getMaPhuPhi(), l.getTenPhuPhi()};
            dtm.addRow(toData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQLPhuPhi = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("MÃ:");

        btnThem.setText("THÊM ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ PHỤ PHÍ");

        tbQLPhuPhi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbQLPhuPhi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQLPhuPhiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbQLPhuPhi);

        jLabel4.setText("TÊN:");

        jLabel5.setText("TÌM KIẾM:");

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem)
                            .addComponent(btnXoa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLPhuPhi ql = formInputqLPhuPhiSave();
        if (ql == null) {
            return;
        } else {
            iPhuPhiService.save(ql);
            JOptionPane.showMessageDialog(this, "THÀNH CÔNG");
            lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
            loadDataTable(lstQLPhuPhis);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        QLPhuPhi ql = formInputqLPhuPhiUpdate();
        if (ql == null) {
            return;
        } else {
            iPhuPhiService.update(ql);
            JOptionPane.showMessageDialog(this, "THÀNH CÔNG");
            lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
            loadDataTable(lstQLPhuPhis);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (!txtMa.getText().isEmpty()) {
            int row = tbQLPhuPhi.getSelectedRow();
            QLPhuPhi qLPhuPhi = lstQLPhuPhis.get(row);
            String idQLPhuPhi = qLPhuPhi.getId();
            iPhuPhiService.delete(idQLPhuPhi);
            JOptionPane.showMessageDialog(this, "THÀNH CÔNG");
            lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
            loadDataTable(lstQLPhuPhis);
        } else {
            JOptionPane.showMessageDialog(this, "CHƯA CHỌN");
            return;
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbQLPhuPhiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQLPhuPhiMouseClicked
        // TODO add your handling code here:
        int row = tbQLPhuPhi.getSelectedRow();
        QLPhuPhi ql = lstQLPhuPhis.get(row);
        txtMa.setText(ql.getMaPhuPhi());
        txtTen.setText(ql.getTenPhuPhi());
    }//GEN-LAST:event_tbQLPhuPhiMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
        String timKiem = txtTimKiem.getText();
        if (timKiem.isBlank()) {
            JOptionPane.showMessageDialog(this, "TÌM KIẾM TRÔNG");
            return;
        }
        int dem = 0;
        for (QLPhuPhi lst : lstQLPhuPhis) {
            if (lst.getMaPhuPhi().equals(timKiem)) {
                dem = dem + 1;
            }
        }
        if (dem == 1) {
            lstQLPhuPhis.clear();
            QLPhuPhi qLPhuPhi = iPhuPhiService.fillByMaPhuPhi(timKiem);
            lstQLPhuPhis.add(qLPhuPhi);
            loadDataTable(lstQLPhuPhis);
        } else {
            JOptionPane.showMessageDialog(this, "KHÔNG CÓ");
            return;
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQLPhuPhi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLPhuPhi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLPhuPhi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLPhuPhi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLPhuPhi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbQLPhuPhi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
