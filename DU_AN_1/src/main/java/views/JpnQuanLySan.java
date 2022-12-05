/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.Ca;
import domainmodel.LoaiSan;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiSanBong;
import enumclass.trangThaiSanCa;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLCa;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import repository.ICaRepository;
import repository.ILoaiSanRepository;
import repository.ISanCaRepository;
import repository.impl.CaRepository;
import repository.impl.LoaiSanRepository;
import repository.impl.SanCaRepository;
import service.ICaService;
import service.ILoaiSanService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
import service.Impl.LoaiSanServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnQuanLySan extends javax.swing.JPanel {

    private List<QLLoaiSan> listQLLoaiSan = new ArrayList<>();
    private List<QLSanBong> listQLSanBong = new ArrayList<>();
    private ILoaiSanService iLoaiSanService = new LoaiSanServiceImpl();
    private ISanBongService iSanBongService = new SanBongServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private ICaRepository caRepository = new CaRepository();
    private ISanCaRepository sanCaRepository = new SanCaRepository();
    private Map<String, Object> mapLoaiSan = new HashMap<>();
    private ILoaiSanRepository loaiSanRepository = new LoaiSanRepository();

    public JpnQuanLySan() {
        initComponents();
        jTable1.setModel(dtm);
        String[] header = {"ID", "Giá sân", "Mã sân", "Sức chứa", "Tên sân", "Trạng thái", "Loại Sân"};
        dtm.setColumnIdentifiers(header);
        listQLLoaiSan = iLoaiSanService.getAll();
        listQLSanBong = iSanBongService.getAll();
        loadCbbLoaiSan();
        showData(listQLSanBong);
        List<LoaiSan> listLoaiSan = loaiSanRepository.getAll();
        for (LoaiSan loaiSan : listLoaiSan) {
            mapLoaiSan.put(loaiSan.getTenLoaiSan(), loaiSan);
            mapLoaiSan.put(loaiSan.getMaLoaiSan(), loaiSan);
        }
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
        String id = UUID.randomUUID().toString();
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        SanBong qlsb = new SanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        if (maSanBong.length() == 0 || tenSanBong.length() == 0 || giaSan.length() == 0 || sucChua.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else {
            LoaiSan loaiSan = iLoaiSanService.getOne(cbbLoaiSan.getSelectedItem().toString());
            SanBong sanBong = new SanBong(id, maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), loaiSan, qlsb.getTrangThai());
            JOptionPane.showMessageDialog(null, iSanBongService.saveSanBong(sanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);
            for (Ca ca : caRepository.getAll()) {
                SanCa sanCa = new SanCa(null, ca, sanBong, new Date(), ca.getGiaCa() + sanBong.getGiaSan(), trangThaiSanCa.DANG_TRONG);
                sanCaRepository.save(sanCa);
            }

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
        LoaiSan loaiSan = new LoaiSan();
        if (mapLoaiSan.containsKey(mountClick().getTenLoaiSan())) {
            loaiSan = (LoaiSan) mapLoaiSan.get(mountClick().getTenLoaiSan());
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected Row ???");
        } else {
            SanBong sanBong = new SanBong(mountClick().getId(), mountClick().getMaSanBong(), mountClick().getTenSanBong(), mountClick().getGiaSan(), mountClick().getSucChua(), loaiSan, mountClick().getTrangThai());
            JOptionPane.showMessageDialog(null, iSanBongService.deleteSanBongNew(sanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);
        }
    }

    private void xoaSan() {
        JOptionPane.showMessageDialog(null, iSanBongService.xoaSan(mountClick().getId()));
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
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaSan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaSanBong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSucChua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenSanBong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        radioSuaChua = new javax.swing.JRadioButton();
        radioHoatDong = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        cbbLoaiSan = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(13, 180, 185));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SÂN BÓNG");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Search");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Giá sân");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã sân bóng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sức chứa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên sân bóng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái");

        buttonGroup1.add(radioSuaChua);
        radioSuaChua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioSuaChua.setSelected(true);
        radioSuaChua.setText("Sửa chữa");

        buttonGroup1.add(radioHoatDong);
        radioHoatDong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioHoatDong.setText("Hoạt động");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Loại Sân");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaSanBong, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                            .addComponent(txtGiaSan)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(45, 45, 45)
                                        .addComponent(radioSuaChua)
                                        .addGap(49, 49, 49)
                                        .addComponent(radioHoatDong)))
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSave)
                                .addGap(84, 84, 84)
                                .addComponent(btnUpdate)
                                .addGap(82, 82, 82)
                                .addComponent(btnDelete)
                                .addGap(110, 110, 110)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSanBong))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(txtSucChua))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch)
                                    .addComponent(cbbLoaiSan, 0, 389, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(512, 512, 512)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(radioSuaChua)
                    .addComponent(radioHoatDong)
                    .addComponent(jLabel7)
                    .addComponent(cbbLoaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate)
                        .addComponent(btnSave)
                        .addComponent(btnDelete))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel8))
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listQLSanBong.clear();
        listQLSanBong = iSanBongService.searchByName(txtSearch.getText());
        showData(listQLSanBong);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            save();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa đổi sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            xoaSan();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_jTable1MouseClicked


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
