/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainModel.GiaoCa;
import domainmodel.Acount;
import enumclass.trangThaiGiaoCa;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelview.QLAcount;
import service.IAcountService;
import service.IGiaoCaService;
import service.Impl.AcountServiceImpl;
import service.Impl.GiaoCaServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnDichVu extends javax.swing.JPanel {

    private QLAcount qLAcount;
    private IAcountService acountService = new AcountServiceImpl();
    private DefaultComboBoxModel boxTenNv = new DefaultComboBoxModel();
    private IGiaoCaService giaoCaService = new GiaoCaServiceImpl();
    private Home home;
    private JLabel lableHome;
    private JPanel pnTong;

    public JpnDichVu(QLAcount qLAcount, Home home, JPanel pnTOng, JLabel lableHome) {
        initComponents();
        this.qLAcount = qLAcount;
        this.home = home;
        this.pnTong = pnTOng;
        this.lableHome = lableHome;
        JpnKhaiBaoTienDauCa dauCa = new JpnKhaiBaoTienDauCa(this.qLAcount, pnTong, lableHome);
        lbNhanVienCaHienTai.setText(qLAcount.getTenAcount());
        maNCCaHienTai.setText(qLAcount.getMaAcount());
        loadCbbNhanVien();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a");
        lbGioHienTai.setText(sdf.format(timestamp));
        lbGioVaoCa.setText(sdf.format(hienTHiNV().getThoiGianNhanCa()));
        TongTien();
    }

    private void TongTien() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        lbTienBanDau.setText(df.format(hienTHiNV().getTienBanDau()));
        lbTongTienThuTrongCa.setText(df.format(giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId())));
        lbTOngHoaDOnTT.setText(df.format(giaoCaService.tongHoaDOnDaTT(qLAcount.getId())));
        lbTOngHoaDOnChuaTT.setText(String.valueOf(giaoCaService.tongHoaDOnChuaTT(qLAcount.getId())));
        lbTOngTIenNganHang.setText(df.format(giaoCaService.tongTienNganHang(qLAcount.getId())));
    }

    private void loadCbbNhanVien() {
        cbbNhanVienNhanCa.setModel(boxTenNv);
        for (QLAcount tenNv : acountService.getAll()) {
            boxTenNv.addElement(tenNv.getTenAcount());
        }
    }

    private GiaoCa hienTHiNV() {
        return giaoCaService.getOneByIdNV(qLAcount.getId());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTong = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNhanVienCaHienTai = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTienBanDau = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTongTienThuTrongCa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbTOngTIenNganHang = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbTOngHoaDOnTT = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTongTIenMatCuoiCa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbbNhanVienNhanCa = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnKetCa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        maNCCaHienTai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbGioVaoCa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbGioHienTai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbTOngHoaDOnChuaTT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Giao dịch trong ca");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setText("Bàn Giao Ca");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nhân viên ca hiện tại : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tiền ban đầu: ");

        lbTienBanDau.setBackground(new java.awt.Color(204, 204, 204));
        lbTienBanDau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTienBanDau.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền thu trong ca: ");

        lbTongTienThuTrongCa.setBackground(new java.awt.Color(204, 204, 204));
        lbTongTienThuTrongCa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTongTienThuTrongCa.setForeground(new java.awt.Color(255, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tổng tiền ngân hàng:");

        lbTOngTIenNganHang.setBackground(new java.awt.Color(204, 204, 204));
        lbTOngTIenNganHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTOngTIenNganHang.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tổng số hóa đơn thanh toán: ");

        lbTOngHoaDOnTT.setBackground(new java.awt.Color(204, 204, 204));
        lbTOngHoaDOnTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTOngHoaDOnTT.setForeground(new java.awt.Color(255, 0, 0));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Bàn giao ca");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Tổng tiền mặt cuối ca : ");

        txtTongTIenMatCuoiCa.setForeground(new java.awt.Color(255, 0, 0));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Nhân viên nhận ca:");

        cbbNhanVienNhanCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Lý do phát sinh:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnKetCa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnKetCa.setText("Kết ca");
        btnKetCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetCaActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Giờ vào ca:");

        lbGioVaoCa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGioVaoCa.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Giờ hiện tại:");

        lbGioHienTai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGioHienTai.setText("jLabel5");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Tổng hóa đơn chưa thanh toán:");

        lbTOngHoaDOnChuaTT.setBackground(new java.awt.Color(204, 204, 204));
        lbTOngHoaDOnChuaTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTOngHoaDOnChuaTT.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTOngTIenNganHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTongTienThuTrongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(70, 70, 70)
                                .addComponent(lbTOngHoaDOnChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTongLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelTongLayout.createSequentialGroup()
                                                .addComponent(lbGioVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(panelTongLayout.createSequentialGroup()
                                                .addComponent(lbNhanVienCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(maNCCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTOngHoaDOnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTongLayout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(lbTienBanDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(105, 105, 105)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(271, 271, 271))
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnKetCa)
                                .addGap(72, 72, 72)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13))
                                    .addComponent(jLabel4))
                                .addGap(63, 63, 63)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTongTIenMatCuoiCa)
                                    .addComponent(cbbNhanVienNhanCa, 0, 224, Short.MAX_VALUE)
                                    .addComponent(lbGioHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel15))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(529, 529, 529))
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongLayout.createSequentialGroup()
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel12)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)))
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelTongLayout.createSequentialGroup()
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(lbGioVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelTongLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(maNCCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lbNhanVienCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(lbTienBanDau, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(lbTOngHoaDOnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(lbTOngHoaDOnChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbTongTienThuTrongCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTOngTIenNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lbGioHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTongTIenMatCuoiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(cbbNhanVienNhanCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(121, 121, 121))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnKetCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetCaActionPerformed
        int chon = JOptionPane.showConfirmDialog(panelTong, "Bạn có chắc chắn kết thúc ca?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            GiaoCa giaoCa = hienTHiNV();
            JOptionPane.showMessageDialog(null, giaoCa.getIdAcount().getTenAcount());
            Acount acounttenNVTT = acountService.getOneByNameAcount(cbbNhanVienNhanCa.getSelectedItem().toString());

            giaoCa.setIdAcount(acountService.getOneByNameAcount(lbNhanVienCaHienTai.getText()));
            giaoCa.setIdNhanVienCaTiepTheo(acounttenNVTT.getId());
            giaoCa.setThoiGianGiaoCa(new Date());
            giaoCa.setTongTienKhac((float) giaoCaService.tongTienNganHang(qLAcount.getId()));
            giaoCa.setTongTienTrongCa((float) giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId()));
            giaoCa.setTongTienMat(Float.valueOf(txtTongTIenMatCuoiCa.getText()));
            giaoCa.setTrangThai(trangThaiGiaoCa.KET_THUC_CA);
            giaoCa.setGhiChuPhatSinh(txtGhiChu.getText());
            String tb = giaoCaService.GiaoCa(giaoCa);
            if (tb.equals("Giao ca thành công")) {
                home.dispose();
                new Detaillogin(null, true).setVisible(true);

            }
        }
    }//GEN-LAST:event_btnKetCaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnKetCa;
    private javax.swing.JComboBox<String> cbbNhanVienNhanCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbGioHienTai;
    private javax.swing.JLabel lbGioVaoCa;
    private javax.swing.JLabel lbNhanVienCaHienTai;
    private javax.swing.JLabel lbTOngHoaDOnChuaTT;
    private javax.swing.JLabel lbTOngHoaDOnTT;
    private javax.swing.JLabel lbTOngTIenNganHang;
    private javax.swing.JLabel lbTienBanDau;
    private javax.swing.JLabel lbTongTienThuTrongCa;
    private javax.swing.JLabel maNCCaHienTai;
    private javax.swing.JPanel panelTong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTongTIenMatCuoiCa;
    // End of variables declaration//GEN-END:variables
}
