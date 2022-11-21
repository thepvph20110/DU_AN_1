/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import enumclass.trangThaiAcount;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiPhieuDL;
import enumclass.trangThaiSanCa;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLAcount;
import modelview.QLKhachHang;
import modelview.QLPhieuDatLich;
import modelview.QLSanCa;
import service.IAcountService;
import service.IKhachHangService;
import service.IPhieuDatLichService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
import service.Impl.KhachHangServiceImpl;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author hp
 */
public class AddPhieuDatLich extends javax.swing.JFrame {

    private List<QLAcount> listAcount = new ArrayList<>();
    private List<QLSanCa> listQLSanCa = new ArrayList<>();
    private List<QLKhachHang> listKhachHang = new ArrayList<>();
    private List<QLPhieuDatLich> listPhieuDatLich = new ArrayList<>();
    private ISanCaService iSanCaService = new SanCaServiceImpl();
    private IAcountService iAcountService = new AcountServiceImpl();
    private IKhachHangService iKhachHangService = new KhachHangServiceImpl();
    private IPhieuDatLichService iPhieuDatLichService = new PhieuDatLichServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form AddPhieuDatLich
     */
    public AddPhieuDatLich() {
        initComponents();
        jTable1.setModel(dtm);
        String[] header = {"ID", "Acount", "Khách Hàng", "Sân ca", "Ngày tạo phiếu", "Ngày đến", "CheckIn", "Ghi chú", "Tổng tiền", "Trạng thái"};
        dtm.setColumnIdentifiers(header);
        listAcount = iAcountService.getAll();
        listKhachHang = iKhachHangService.getAll();
        listQLSanCa = iSanCaService.getAll();
        listPhieuDatLich = iPhieuDatLichService.getAll();
        loadCbbAcount();
        loadCbbKhachHang();
        loadCbbSanCa();
        Date d = new Date();
        NgayTaoPhieu.setDate(d);
        showData(listPhieuDatLich);

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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbSanCa = new javax.swing.JComboBox<>();
        cbbAcount = new javax.swing.JComboBox<>();
        cbbKhachHang = new javax.swing.JComboBox<>();
        NgayDenSan = new com.toedter.calendar.JDateChooser();
        NgayTaoPhieu = new com.toedter.calendar.JDateChooser();
        TongTienSan = new javax.swing.JTextField();
        radioChuaNhanSan = new javax.swing.JRadioButton();
        radioDaNhanSan = new javax.swing.JRadioButton();
        radioDaHuy = new javax.swing.JRadioButton();
        TimeCheckIn = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ngay Den San");

        jLabel2.setText("Thoi Gian CheckIn");

        jLabel3.setText("Ngay Tao Phieu");

        jLabel4.setText("Tong tien san");

        jLabel5.setText("Trang Thai");

        jLabel6.setText("Acount");

        jLabel7.setText("Khach Hang");

        jLabel8.setText("Sân Ca");

        NgayDenSan.setDateFormatString("dd-MM-yyyy");

        NgayTaoPhieu.setDateFormatString("dd-MM-yyyy");

        buttonGroup1.add(radioChuaNhanSan);
        radioChuaNhanSan.setSelected(true);
        radioChuaNhanSan.setText("Chưa nhận sân");

        buttonGroup1.add(radioDaNhanSan);
        radioDaNhanSan.setText("Đã nhận sân");

        buttonGroup1.add(radioDaHuy);
        radioDaHuy.setText("Đã hủy");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("QR Nè");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(40, 40, 40))
        );

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

        jLabel10.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(NgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TongTienSan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TimeCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(NgayTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnSave)
                        .addGap(103, 103, 103)
                        .addComponent(btnUpdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioChuaNhanSan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioDaNhanSan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(radioDaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSanCa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)
                            .addComponent(cbbAcount, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cbbAcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cbbSanCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TimeCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(TongTienSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NgayTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(123, 123, 123)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(radioChuaNhanSan)
                        .addComponent(radioDaNhanSan)
                        .addComponent(radioDaHuy)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String tongTien = TongTienSan.getText().trim();
        String time = TimeCheckIn.getText().trim();
        String ghiChu = txtGhiChu.getText();
        QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich();
        if (radioChuaNhanSan.isSelected()) {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.CHUA_NHAN_SAN);
        } else if (radioDaNhanSan.isSelected()) {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.DA_NHAN_SAN);
        } else {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.DA_HUY);
        }
        Date ngayDenSan = NgayDenSan.getDate();
        Date d = new Date();
        NgayTaoPhieu.setDate(d);
        if (tongTien.length() == 0 || time.length() == 0) {
            JOptionPane.showMessageDialog(this, "Null .....");
        } else if (!time.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Format time");
        } else {
            QLKhachHang khachHang = new QLKhachHang(setKhachHang(), null, null, null, null, null, null);
            QLSanCa sanCa = new QLSanCa(setSanCa(), null, null, null, 0, null);
            QLAcount acount = new QLAcount(setAcount(), null, null, null, null, null, null);
            QLPhieuDatLich lich = new QLPhieuDatLich(null, acount, khachHang, sanCa, d, ngayDenSan, Time.valueOf(time), ghiChu,qLPhieuDatLich.getMaQR(), Double.valueOf(tongTien), qLPhieuDatLich.getTrangThai());
            JOptionPane.showMessageDialog(this, iPhieuDatLichService.save(lich));
            listPhieuDatLich = iPhieuDatLichService.getAll();
            showData(listPhieuDatLich);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = jTable1.getSelectedRow();
        String tongTien = TongTienSan.getText().trim();
        String time = TimeCheckIn.getText().trim();
        String ghiChu = txtGhiChu.getText();
        QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich();
        if (radioChuaNhanSan.isSelected()) {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.CHUA_NHAN_SAN);
        } else if (radioDaNhanSan.isSelected()) {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.DA_NHAN_SAN);
        } else {
            qLPhieuDatLich.setTrangThai(trangThaiPhieuDL.DA_HUY);
        }
        Date ngayDenSan = NgayDenSan.getDate();
        Date d = new Date();
        NgayTaoPhieu.setDate(d);
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ??");
        } else {
            if (tongTien.length() == 0 || time.length() == 0) {
                JOptionPane.showMessageDialog(this, "Null .....");
            } else if (!time.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
                JOptionPane.showMessageDialog(this, "Format time");
            } else {
                QLKhachHang khachHang = new QLKhachHang(setKhachHang(), null, null, null, null, null, null);
                QLSanCa sanCa = new QLSanCa(setSanCa(), null, null, null, 0, null);
                QLAcount acount = new QLAcount(setAcount(), null, null, null, null, null, null);
                QLPhieuDatLich lich = new QLPhieuDatLich(mountClick().getId(), acount, khachHang, sanCa, d, ngayDenSan, Time.valueOf(time), ghiChu,qLPhieuDatLich.getMaQR(), Double.valueOf(tongTien), qLPhieuDatLich.getTrangThai());
                JOptionPane.showMessageDialog(this, iPhieuDatLichService.update(lich));
                listPhieuDatLich = iPhieuDatLichService.getAll();
                showData(listPhieuDatLich);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ??");
        } else {
            JOptionPane.showMessageDialog(this, iPhieuDatLichService.delete(mountClick().getId()));
            listPhieuDatLich = iPhieuDatLichService.getAll();
            showData(listPhieuDatLich);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked

    private QLPhieuDatLich mountClick() {
        int row = jTable1.getSelectedRow();
        return listPhieuDatLich.get(row);
    }

    private void loadCbbAcount() {
        for (QLAcount qLAcount : listAcount) {
            cbbAcount.addItem(qLAcount.getTenAcount());
        }
    }

    private void loadCbbKhachHang() {
        for (QLKhachHang qLKhachHang : listKhachHang) {
            cbbKhachHang.addItem(qLKhachHang.getTenKhachHang());
        }
    }

    private void loadCbbSanCa() {
        for (QLSanCa qLSanCa : listQLSanCa) {
            cbbSanCa.addItem(qLSanCa.getCa());
        }
    }

    private void showData(List<QLPhieuDatLich> listPhieuDatLich) {
        dtm.setRowCount(0);
        for (QLPhieuDatLich qLPhieuDatLich : listPhieuDatLich) {
            dtm.addRow((Object[]) qLPhieuDatLich.toDataRow());
        }
    }

    private void fillData(int index) {
        QLPhieuDatLich qLPhieuDatLich = listPhieuDatLich.get(index);
        TimeCheckIn.setText(String.valueOf(qLPhieuDatLich.getTgCheckIn()));
        TongTienSan.setText(String.valueOf(qLPhieuDatLich.getTongTienSan()));
        cbbAcount.setSelectedItem(qLPhieuDatLich.getAcount().getTenAcount());
        cbbKhachHang.setSelectedItem(qLPhieuDatLich.getKhachHang().getTenKhachHang());
        cbbSanCa.setSelectedItem(qLPhieuDatLich.getSanCa().getCa());
        NgayDenSan.setDate(qLPhieuDatLich.getNgayDenSan());
        NgayTaoPhieu.setDate(qLPhieuDatLich.getNgayTaoPhieu());
        if (qLPhieuDatLich.getTrangThai() == trangThaiPhieuDL.CHUA_NHAN_SAN) {
            radioChuaNhanSan.setSelected(true);
        } else if (qLPhieuDatLich.getTrangThai() == trangThaiPhieuDL.DA_NHAN_SAN) {
            radioDaNhanSan.setSelected(true);
        } else {
            radioDaHuy.setSelected(true);
        }
    }

    private UUID setAcount() {
        String ten = (String) cbbAcount.getSelectedItem();
        UUID id = null;
        for (QLAcount qLAcount : listAcount) {
            if (qLAcount.getTenAcount().equals(ten)) {
                id = qLAcount.getId();
            }
        }
        return id;
    }

    private UUID setKhachHang() {
        String ten = (String) cbbKhachHang.getSelectedItem();
        UUID id = null;
        for (QLKhachHang qLKhachHang : listKhachHang) {
            if (qLKhachHang.getTenKhachHang().equals(ten)) {
                id = qLKhachHang.getId();
            }
        }
        return id;
    }

    private UUID setSanCa() {
        String ten = (String) cbbSanCa.getSelectedItem();
        UUID id = null;
        for (QLSanCa qLSanCa : listQLSanCa) {
            if (qLSanCa.getCa().equals(ten)) {
                id = qLSanCa.getId();
            }
        }
        return id;
    }

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
            java.util.logging.Logger.getLogger(AddPhieuDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPhieuDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPhieuDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPhieuDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPhieuDatLich().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgayDenSan;
    private com.toedter.calendar.JDateChooser NgayTaoPhieu;
    private javax.swing.JTextField TimeCheckIn;
    private javax.swing.JTextField TongTienSan;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbAcount;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbSanCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioChuaNhanSan;
    private javax.swing.JRadioButton radioDaHuy;
    private javax.swing.JRadioButton radioDaNhanSan;
    private javax.swing.JTextArea txtGhiChu;
    // End of variables declaration//GEN-END:variables
}
