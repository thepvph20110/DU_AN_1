/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.HomeController;
import domainmodel.Acount;
import domainmodel.Ca;
import domainmodel.KhachHang;
import domainmodel.LoaiSan;
import domainmodel.PhieuDatLich;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiAcount;
import enumclass.trangThaiPhieuDL;
import enumclass.trangThaiSanCa;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelview.QLAcount;
import modelview.QLCa;
import modelview.QLKhachHang;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.ICaService;
import service.IHoaDonService;
import service.ILoaiSanService;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.LoaiSanServiceImpl;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;
import utill.JavaMail;
import utill.QRCode;

/**
 *
 * @author ADMIN
 */
public class FrmPhieuDatLich extends javax.swing.JFrame {

    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private QLKhachHang qlKhachHang = new QLKhachHang();
    private Acount acount = new Acount();
    private String maQr = UUID.randomUUID().toString();
    private QLSanCa sanCa = new QLSanCa();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ByteArrayOutputStream byteArrayOutputStream = new QRCode().getQRCodeImage(maQr, 200, 200);
    private Map<String, Object> map = new HashMap<>();
    private ICaService caService = new CaServiceImpl();
    private IHoaDonService hoaDonService = new HoaDonServiceImpl();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private List<QLCa> listca = new ArrayList<>();
    private List<QLLoaiSan> listLoaiSan = new ArrayList<>();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    private ILoaiSanService loaiSanService = new LoaiSanServiceImpl();
    private JLabel labelHome;
    private JPanel pnTong;

    /**
     * Creates new form FrmPhieuDatLich
     */
    public FrmPhieuDatLich(QLKhachHang qLKhachHang, QLSanCa sanCa, Acount acountentity, JLabel lbHome,JPanel pnTong) {
        initComponents();
        this.labelHome=lbHome;
        this.pnTong = pnTong;
        acount = acountentity;
        qlKhachHang = qLKhachHang;
        this.sanCa = sanCa;
        setTitle("Phiếu Đặt Lịch");

        txtTenSanca.setText(this.sanCa.getTenSanBong() + " - " + this.sanCa.getTenCa());
        txtTenSanca.setEnabled(false);

        txtTienSanBong.setText(sanCa.getGiaCaSan() + "");
        txtTienSanBong.setEnabled(false);

        txtTenKhachHang.setText(qlKhachHang.getTenKhachHang());
        txtTenKhachHang.setEnabled(false);

        txtQuanLy.setText(acount.getTenAcount());
        txtQuanLy.setEnabled(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        txtNgayDenSan.setText(sdf.format(sanCa.getNgayTao())+"");
        txtNgayDenSan.setEnabled(false);

        txtMaQR.setIcon(new ImageIcon(byteArrayOutputStream.toByteArray()));

        listSanBong = sanBongService.getAll();
        for (QLSanBong qLSanBong : listSanBong) {
            map.put(qLSanBong.getTenSanBong(), qLSanBong);
        }
        listca = caService.getAll();
        for (QLCa qLCa : listca) {
            map.put(qLCa.getTenCa(), qLCa);
        }
        listLoaiSan = loaiSanService.getAll();
        for (QLLoaiSan qLLoaiSan : listLoaiSan) {
            map.put(qLLoaiSan.getTenLoaiSan(), qLLoaiSan);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtTienSanBong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuanLy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaQR = new javax.swing.JLabel();
        txtTenSanca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayDenSan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnDatLich = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Thông tin khách hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tiền sân bóng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tên Quản Lý");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Ngày đến sân");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã QR");

        txtMaQR.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tên sân ca");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTienSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(txtTenSanca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaQR, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenSanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaQR, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDatLich.setBackground(new java.awt.Color(51, 51, 255));
        btnDatLich.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnDatLich.setText("Đặt lịch");
        btnDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btnDatLich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(btnDatLich, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichActionPerformed
        // TODO add your handling code here:
        int Request = JOptionPane.showConfirmDialog(rootPane, "Xác nhận Đặt lịch", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (Request == JOptionPane.YES_OPTION) {
            String maPhieuLichDat = UUID.randomUUID().toString();
            Date ngayDen = sanCa.getNgayTao();
            String ghiChu = txtGhiChu.getText();
            Date ngayTao = new Date();
            QLCa qLCa = (QLCa) map.get(sanCa.getTenCa());
            QLSanBong qLSanBong = (QLSanBong) map.get(sanCa.getTenSanBong());
            QLLoaiSan qLLoaiSan = (QLLoaiSan) map.get(qLSanBong.getTenLoaiSan());
            Ca caEntity = new Ca(qLCa.getId(), qLCa.getMaCa(), qLCa.getTenCa(), qLCa.getThoiGianBatDau(), qLCa.getThoiGianKetThuc(), qLCa.getGiaCa(), qLCa.getTrangThai());
            LoaiSan loaiSanEnity = new LoaiSan(qLLoaiSan.getId(), qLLoaiSan.getMaLoaiSan(), qLLoaiSan.getTenLoaiSan(), qLLoaiSan.getMoTa());
            SanBong sanBongEntity = new SanBong(qLSanBong.getId(), qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(),
                    loaiSanEnity, qLSanBong.getTrangThai());
            SanCa sanCaEntity = new SanCa(sanCa.getId(), caEntity, sanBongEntity, ngayTao, sanCa.getGiaCaSan(), sanCa.getTrangThai());
            KhachHang khachHang = new KhachHang(qlKhachHang.getId(), qlKhachHang.getMaKhachHang(), qlKhachHang.getTenKhachHang(), qlKhachHang.getMail(), qlKhachHang.getSoDienThoai(), qlKhachHang.getGhiChu(), qlKhachHang.getTrangThai());
            PhieuDatLich phieuDatLich = new PhieuDatLich(maPhieuLichDat, acount, khachHang, sanCaEntity, ngayTao, ngayDen, null, ghiChu, maQr, sanCa.getGiaCaSan(), trangThaiPhieuDL.CHUA_NHAN_SAN);

            try {
                String check = phieuDatLichService.datLich(phieuDatLich);
                if (check.equalsIgnoreCase("Lưu Thành Công")) {
                    JOptionPane.showMessageDialog(rootPane, new JavaMail().sendMail(phieuDatLich, byteArrayOutputStream));
                    sanCa.setTrangThai(trangThaiSanCa.CHO_NHAN_SAN);
                    sanCaService.update(sanCa);
                    QLAcount qLAcount= new QLAcount(acount.getId(), acount.getMaAcount(), acount.getTenAcount(), acount.getChucVu(), acount.getMatKhau(),acount.getMoTa(), acount.getTrangThai());
                    HomeController controller = new HomeController(pnTong,qLAcount);
                    controller.setView(labelHome);

                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, check);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "lỗi hệ thống");
            }
        }

    }//GEN-LAST:event_btnDatLichActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrmKhachHang frmKhachHang = new FrmKhachHang(sanCa, acount,labelHome,pnTong);
        frmKhachHang.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLich;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JLabel txtMaQR;
    private javax.swing.JTextField txtNgayDenSan;
    private javax.swing.JTextField txtQuanLy;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenSanca;
    private javax.swing.JTextField txtTienSanBong;
    // End of variables declaration//GEN-END:variables
}
