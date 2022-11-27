package views;

import enumclass.trangThaiPhuPhiHoaDon;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelview.QLHoaDon;
import modelview.QLHoaDon_PhuPhi;
import modelview.QLPhuPhi;
import service.IHoaDonService;
import service.IHoaDon_PhuPhiService;
import service.IPhuPhiService;
import service.Impl.HoaDonPhuPhiServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.PhuPhiServiceImpl;

public class FrmHoaDonPhuPhi extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private List<QLHoaDon_PhuPhi> lstHoaDon_PhuPhis;
    private IHoaDon_PhuPhiService iHoaDon_PhuPhiService;
    private DefaultComboBoxModel dcbmHoaDon;
    private DefaultComboBoxModel dcbmPhuPhi;
    private List<QLHoaDon> lstQLHoaDons;
    private List<QLPhuPhi> lstQLPhuPhis;
    private IHoaDonService iHoaDonService;
    private IPhuPhiService iPhuPhiService;

    public FrmHoaDonPhuPhi() {
        initComponents();
        showDataTable();
        showDataCbbHoaDon();
        showDataCbbPhuPhi();
    }

    private String getIDHoaDon() {
        String maHoaDon = (String) cbbHoaDon.getSelectedItem();
        String id = null;
        for (int i = 0; i < lstQLHoaDons.size(); i++) {
            if (lstQLHoaDons.get(i).getMaHoaDon().equals(maHoaDon)) {
                id = lstQLHoaDons.get(i).getId();
            }
        }
        return id;
    }

    private String getIDPhuPhi() {
        String maPhuPhi = (String) cbbPhuPhi.getSelectedItem();
        String id = null;
        for (int i = 0; i < lstQLPhuPhis.size(); i++) {
            if (lstQLPhuPhis.get(i).getMaPhuPhi().equals(maPhuPhi)) {
                id = lstQLPhuPhis.get(i).getId();
            }
        }
        return id;
    }

    private void showDataCbbHoaDon() {
        lstQLHoaDons = new ArrayList<>();
        iHoaDonService = new HoaDonServiceImpl();
        lstQLHoaDons = iHoaDonService.getAll();
        cbbHoaDon.setModel(dcbmHoaDon = new DefaultComboBoxModel());
        loadDataCbbHoaDon(lstQLHoaDons);
    }

    private void showDataCbbPhuPhi() {
        lstQLPhuPhis = new ArrayList<>();
        iPhuPhiService = new PhuPhiServiceImpl();
        lstQLPhuPhis = iPhuPhiService.getAllQLPhuPhis();
        cbbPhuPhi.setModel(dcbmPhuPhi = new DefaultComboBoxModel());
        loadDataCbbPhuPhi(lstQLPhuPhis);
    }

    private void loadDataCbbHoaDon(List<QLHoaDon> lstQLHoaDons) {
        lstQLHoaDons.forEach((t) -> cbbHoaDon.addItem(String.valueOf(t.getId())));
    }

    private void loadDataCbbPhuPhi(List<QLPhuPhi> lstQLPhuPhis) {
        lstQLPhuPhis.forEach((t) -> cbbPhuPhi.addItem(String.valueOf(t.getId())));
    }

    private QLHoaDon_PhuPhi getFormInput() {
        QLHoaDon_PhuPhi qLHoaDon_PhuPhi = new QLHoaDon_PhuPhi();
        qLHoaDon_PhuPhi.setId(null);

        String idHoaDon = (String) cbbHoaDon.getSelectedItem();
        QLHoaDon qLHoaDon = new QLHoaDon();
        qLHoaDon.setId(idHoaDon);
        qLHoaDon_PhuPhi.setHoaDon(qLHoaDon);

        String idPhuPhi = (String) cbbPhuPhi.getSelectedItem();
        QLPhuPhi qLPhuPhi = new QLPhuPhi();
        qLPhuPhi.setId(idPhuPhi);
        qLHoaDon_PhuPhi.setPhuPhi(qLPhuPhi);

        double giaPPHD = Double.valueOf(txtGia.getText());
        qLHoaDon_PhuPhi.setGiaPPHD(giaPPHD);

        String moTa = txtMoTa.getText();
        qLHoaDon_PhuPhi.setMoTa(moTa);

        return qLHoaDon_PhuPhi;
    }

    private QLHoaDon_PhuPhi getFormInputUpdate() {
        QLHoaDon_PhuPhi qLHoaDon_PhuPhi = new QLHoaDon_PhuPhi();
        String id = txtID.getText();
        qLHoaDon_PhuPhi.setId(id);

        String idHoaDon = (String) cbbHoaDon.getSelectedItem();
        QLHoaDon qLHoaDon = new QLHoaDon();
        qLHoaDon.setId(idHoaDon);
        qLHoaDon_PhuPhi.setHoaDon(qLHoaDon);

        String idPhuPhi = (String) cbbPhuPhi.getSelectedItem();
        QLPhuPhi qLPhuPhi = new QLPhuPhi();
        qLPhuPhi.setId(idPhuPhi);
        qLHoaDon_PhuPhi.setPhuPhi(qLPhuPhi);

        double giaPPHD = Double.valueOf(txtGia.getText());
        qLHoaDon_PhuPhi.setGiaPPHD(giaPPHD);

        String moTa = txtMoTa.getText();
        qLHoaDon_PhuPhi.setMoTa(moTa);

        return qLHoaDon_PhuPhi;
    }

    private void showDataTable() {
        lstHoaDon_PhuPhis = new ArrayList<>();
        iHoaDon_PhuPhiService = new HoaDonPhuPhiServiceImpl();
        lstHoaDon_PhuPhis = iHoaDon_PhuPhiService.getALlLHoaDon_PhuPhis();
        tbPhuPhiHoaDon.setModel(dtm = new DefaultTableModel());
        String[] header = {"ID", "MÃ HÓA ĐƠN", "MÃ PHỤ PHÍ", "GIÁ PPHD", "MÔ TẢ"};
        dtm.setColumnIdentifiers(header);
        loadDataTable(lstHoaDon_PhuPhis);

    }

    private void loadDataTable(List<QLHoaDon_PhuPhi> lstHoaDon_PhuPhis) {
        dtm.setRowCount(0);
        for (QLHoaDon_PhuPhi hoaDon_PhuPhi : lstHoaDon_PhuPhis) {
            Object[] toData = {hoaDon_PhuPhi.getId(), hoaDon_PhuPhi.getHoaDon().getId(), hoaDon_PhuPhi.getPhuPhi().getId(), hoaDon_PhuPhi.getGiaPPHD(), hoaDon_PhuPhi.getMoTa()};
            dtm.addRow(toData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhuPhiHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtID = new javax.swing.JTextField();
        cbbHoaDon = new javax.swing.JComboBox<>();
        cbbPhuPhi = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbPhuPhiHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPhuPhiHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhuPhiHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhuPhiHoaDon);

        jLabel1.setText("HÓA ĐƠN:");

        jLabel2.setText("ID: ");

        jLabel3.setText("PHỤ PHÍ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("QUẢN LÝ PHỤ PHÍ HÓA ĐƠN");

        cbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbPhuPhi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThem.setText("THÊM");
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

        jLabel4.setText("GIÁ PPHD:");

        jLabel6.setText("MÔ TẢ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 292, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(269, 269, 269))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPhuPhi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLHoaDon_PhuPhi qLHoaDon_PhuPhi = getFormInput();
        iHoaDon_PhuPhiService.save(qLHoaDon_PhuPhi);
        lstHoaDon_PhuPhis = iHoaDon_PhuPhiService.getALlLHoaDon_PhuPhis();
        loadDataTable(lstHoaDon_PhuPhis);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        QLHoaDon_PhuPhi qLHoaDon_PhuPhi = getFormInputUpdate();
        iHoaDon_PhuPhiService.update(qLHoaDon_PhuPhi);
        lstHoaDon_PhuPhis = iHoaDon_PhuPhiService.getALlLHoaDon_PhuPhis();
        loadDataTable(lstHoaDon_PhuPhis);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        iHoaDon_PhuPhiService.delete(id);
        lstHoaDon_PhuPhis = iHoaDon_PhuPhiService.getALlLHoaDon_PhuPhis();
        loadDataTable(lstHoaDon_PhuPhis);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbPhuPhiHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhuPhiHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tbPhuPhiHoaDon.getSelectedRow();
        QLHoaDon_PhuPhi qLHoaDon_PhuPhi = lstHoaDon_PhuPhis.get(row);
        txtID.setText(String.valueOf(qLHoaDon_PhuPhi.getId()));
        String idHoaDon = String.valueOf(qLHoaDon_PhuPhi.getHoaDon().getId());
        cbbHoaDon.setSelectedItem(idHoaDon);
        String idPhuPhi = String.valueOf(qLHoaDon_PhuPhi.getPhuPhi().getId());
        cbbPhuPhi.setSelectedItem(idPhuPhi);
        txtGia.setText(String.valueOf(qLHoaDon_PhuPhi.getGiaPPHD()));
        txtMoTa.setText(qLHoaDon_PhuPhi.getMoTa());
    }//GEN-LAST:event_tbPhuPhiHoaDonMouseClicked

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
            java.util.logging.Logger.getLogger(FrmHoaDonPhuPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonPhuPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonPhuPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDonPhuPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHoaDonPhuPhi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbHoaDon;
    private javax.swing.JComboBox<String> cbbPhuPhi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbPhuPhiHoaDon;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMoTa;
    // End of variables declaration//GEN-END:variables
}
