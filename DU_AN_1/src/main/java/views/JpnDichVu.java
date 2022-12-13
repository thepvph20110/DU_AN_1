/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainModel.GiaoCa;
import domainmodel.Acount;
import enumclass.trangThaiGiaoCa;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        txtTienPhatSinh.setText("0");
        TongTien();
        phanQuyen();
    }

    private void phanQuyen() {
        if (qLAcount.getChucVu().getTenChucVu().equals("Quản Lý Sân")) {
            btnReset.setEnabled(false);
        } else {
            btnReset.setEnabled(true);
        }
    }

    private void TongTien() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        lbTienBanDau.setText(df.format(hienTHiNV().getTienBanDau()));
        lbTongTienThuTrongCa.setText(df.format(giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId())));
        lbTOngHoaDOnTT.setText(String.valueOf(giaoCaService.tongHoaDOnDaTT(qLAcount.getId())));
        lbTOngHoaDOnChuaTT.setText(String.valueOf(giaoCaService.tongHoaDOnChuaTT(qLAcount.getId())));
        lbTOngTIenNganHang.setText(df.format(giaoCaService.tongTienNganHang(qLAcount.getId())));
        lbTongTIenThanhTOanBangTienMa.setText(df.format(giaoCaService.tongTienMat(qLAcount.getId())));
        labelTongTIenMatTrongCa.setText(df.format(giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau())));
    }

    private void loadCbbNhanVien() {
        cbbNhanVienNhanCa.setModel(boxTenNv);
        for (QLAcount tenNv : acountService.getAll()) {
            boxTenNv.addElement(tenNv.getTenAcount());
        }
    }

    public GiaoCa hienTHiNV() {
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
        jLabel14 = new javax.swing.JLabel();
        cbbNhanVienNhanCa = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnKetCa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        maNCCaHienTai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbGioVaoCa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbGioHienTai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbTOngHoaDOnChuaTT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTienPhatSinh = new javax.swing.JTextField();
        labelTongTIenMatTrongCa = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbTongTIenThanhTOanBangTienMa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        panelTong.setBackground(new java.awt.Color(186, 228, 229));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Giao dịch trong ca");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Bàn Giao Ca");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nhân viên ca hiện tại : ");

        lbNhanVienCaHienTai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tiền ban đầu: (1) ");

        lbTienBanDau.setBackground(new java.awt.Color(204, 204, 204));
        lbTienBanDau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTienBanDau.setForeground(new java.awt.Color(255, 0, 0));
        lbTienBanDau.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền thu trong ca: (3) + (4)");

        lbTongTienThuTrongCa.setBackground(new java.awt.Color(204, 204, 204));
        lbTongTienThuTrongCa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTongTienThuTrongCa.setForeground(new java.awt.Color(255, 0, 0));
        lbTongTienThuTrongCa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tổng tiền thanh toán bằng ngân hàng: (4)");

        lbTOngTIenNganHang.setBackground(new java.awt.Color(204, 204, 204));
        lbTOngTIenNganHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTOngTIenNganHang.setForeground(new java.awt.Color(255, 0, 0));
        lbTOngTIenNganHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tổng số hóa đơn thanh toán: ");

        lbTOngHoaDOnTT.setBackground(new java.awt.Color(204, 204, 204));
        lbTOngHoaDOnTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTOngHoaDOnTT.setForeground(new java.awt.Color(255, 0, 0));
        lbTOngHoaDOnTT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Bàn giao ca");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Tổng tiền mặt trong ca: (1) - (2)");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Nhân viên nhận ca:");

        cbbNhanVienNhanCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Lý do phát sinh:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnKetCa.setBackground(new java.awt.Color(51, 102, 255));
        btnKetCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKetCa.setForeground(new java.awt.Color(255, 255, 255));
        btnKetCa.setText("Kết ca");
        btnKetCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetCaActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 0, 0));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset Và Rút tiền");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
        lbTOngHoaDOnChuaTT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tiền phát sinh: (2)");

        txtTienPhatSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienPhatSinhKeyTyped(evt);
            }
        });

        labelTongTIenMatTrongCa.setText("jLabel9");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Tổng tiền thanh toán bằng tiền mặt: (3)");

        lbTongTIenThanhTOanBangTienMa.setForeground(new java.awt.Color(255, 0, 51));
        lbTongTIenThanhTOanBangTienMa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelTongLayout.createSequentialGroup()
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTongLayout.createSequentialGroup()
                                            .addGap(70, 70, 70)
                                            .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelTongLayout.createSequentialGroup()
                                                    .addComponent(lbGioVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(maNCCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbTOngHoaDOnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelTongLayout.createSequentialGroup()
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel5))
                                    .addGap(70, 70, 70)
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTOngHoaDOnChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNhanVienCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTienBanDau, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(105, 105, 105)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(271, 271, 271))
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnKetCa)
                                .addGap(72, 72, 72)
                                .addComponent(btnReset))
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13))
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel8))
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTongLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbGioHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                            .addGroup(panelTongLayout.createSequentialGroup()
                                                .addComponent(cbbNhanVienNhanCa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(106, 106, 106))))
                                    .addGroup(panelTongLayout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbTongTienThuTrongCa, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                            .addComponent(labelTongTIenMatTrongCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(54, 54, 54))))
                            .addGroup(panelTongLayout.createSequentialGroup()
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel10))
                                .addGap(32, 32, 32)
                                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTOngTIenNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTongTIenThanhTOanBangTienMa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(573, 573, 573))
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTongLayout.createSequentialGroup()
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
                        .addGap(40, 40, 40)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(lbTienBanDau, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(lbTOngHoaDOnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(lbTOngHoaDOnChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTienPhatSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(panelTongLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGioHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbbNhanVienNhanCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(labelTongTIenMatTrongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(lbTongTienThuTrongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTongTIenThanhTOanBangTienMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTOngTIenNganHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)
                        .addGroup(panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
            .addGroup(panelTongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        new ResetRutTien(qLAcount, panelTong, home, lableHome).setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKetCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetCaActionPerformed
        int chon = JOptionPane.showConfirmDialog(panelTong, "Bạn có chắc chắn kết thúc ca?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            GiaoCa giaoCa = hienTHiNV();
            if (!txtTienPhatSinh.getText().isBlank()) {
                if (Float.valueOf(txtTienPhatSinh.getText()) == 0) {
                    Acount acounttenNVTT = acountService.getOneByNameAcount(cbbNhanVienNhanCa.getSelectedItem().toString());
                    giaoCa.setIdAcount(acountService.getOneByNameAcount(lbNhanVienCaHienTai.getText()));
                    giaoCa.setIdNhanVienCaTiepTheo(acounttenNVTT.getId());
                    giaoCa.setThoiGianGiaoCa(new Date());
                    giaoCa.setTongTienKhac((float) giaoCaService.tongTienNganHang(qLAcount.getId()));
                    giaoCa.setTongTienTrongCa((float) (giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId()) + hienTHiNV().getTienBanDau()));
                    giaoCa.setTongTienMat((float) (giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau())));
                    giaoCa.setTrangThai(trangThaiGiaoCa.KET_THUC_CA);
                    giaoCa.setGhiChuPhatSinh("");
                    giaoCa.setTienPhatSinh(0);
                    String tb = giaoCaService.GiaoCa(giaoCa);
                    JOptionPane.showMessageDialog(null, tb);
                    if (tb.equals("Giao ca thành công")) {
                        home.dispose();
                        new Detaillogin(null, true).setVisible(true);
                    }
                } else {
                    if (txtGhiChu.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ghi chú phát sinh");
                        return;
                    } else {
                        Acount acounttenNVTT = acountService.getOneByNameAcount(cbbNhanVienNhanCa.getSelectedItem().toString());
                        giaoCa.setIdAcount(acountService.getOneByNameAcount(lbNhanVienCaHienTai.getText()));
                        giaoCa.setIdNhanVienCaTiepTheo(acounttenNVTT.getId());
                        giaoCa.setThoiGianGiaoCa(new Date());
                        giaoCa.setTongTienKhac((float) giaoCaService.tongTienNganHang(qLAcount.getId()));
                        giaoCa.setTongTienTrongCa((float) (giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId()) + hienTHiNV().getTienBanDau()));
                        giaoCa.setTongTienMat((float) (giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau())));
                        giaoCa.setTrangThai(trangThaiGiaoCa.KET_THUC_CA);
                        giaoCa.setGhiChuPhatSinh(txtGhiChu.getText());
                        giaoCa.setTienPhatSinh(Float.valueOf(txtTienPhatSinh.getText()));
                        String tb = giaoCaService.GiaoCa(giaoCa);
                        JOptionPane.showMessageDialog(null, tb);
                        if (tb.equals("Giao ca thành công")) {
                            home.dispose();
                            new Detaillogin(null, true).setVisible(true);
                        }
                    }
                }

            } else {
                Acount acounttenNVTT = acountService.getOneByNameAcount(cbbNhanVienNhanCa.getSelectedItem().toString());
                giaoCa.setIdAcount(acountService.getOneByNameAcount(lbNhanVienCaHienTai.getText()));
                giaoCa.setIdNhanVienCaTiepTheo(acounttenNVTT.getId());
                giaoCa.setThoiGianGiaoCa(new Date());
                giaoCa.setTongTienKhac((float) giaoCaService.tongTienNganHang(qLAcount.getId()));
                giaoCa.setTongTienTrongCa((float) (giaoCaService.tongTienCaHienTaiByIdNV(qLAcount.getId()) + hienTHiNV().getTienBanDau()));
                giaoCa.setTongTienMat((float) (giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau())));
                giaoCa.setTrangThai(trangThaiGiaoCa.KET_THUC_CA);
                giaoCa.setGhiChuPhatSinh("");
                giaoCa.setTienPhatSinh(0);
                String tb = giaoCaService.GiaoCa(giaoCa);
                JOptionPane.showMessageDialog(null, tb);
                if (tb.equals("Giao ca thành công")) {
                    home.dispose();
                    new Detaillogin(null, true).setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_btnKetCaActionPerformed

    private void txtTienPhatSinhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienPhatSinhKeyTyped
        String tien = txtTienPhatSinh.getText() + evt.getKeyChar();
        if (!tien.matches("\\d+")) {
            txtTienPhatSinh.setText("");
            JOptionPane.showMessageDialog(null, "Tiền phát sinh không đúng định dạng");
        } else if (Float.valueOf(tien) < 0) {
            JOptionPane.showMessageDialog(null, "Tiền phát sinh phải lớn hơn 0");
        } else {
            float tienPhatSInh = Float.valueOf(tien);
            float tienMatCuoiCa = (float) (giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau()) - tienPhatSInh);
            if (tienMatCuoiCa <= 0) {
                JOptionPane.showMessageDialog(null, "Tiền mặt trong két không đủ");
            } else {
                if (tien.length() == 0) {
                    labelTongTIenMatTrongCa.setText(String.valueOf(giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau()) - 0));
                } else {
                    labelTongTIenMatTrongCa.setText(String.valueOf(giaoCaService.tongTienMat(qLAcount.getId()) + Float.valueOf(hienTHiNV().getTienBanDau()) - tienPhatSInh));
                }

            }
        }

    }//GEN-LAST:event_txtTienPhatSinhKeyTyped

    public JpnDichVu() {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKetCa;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbbNhanVienNhanCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTongTIenMatTrongCa;
    private javax.swing.JLabel lbGioHienTai;
    private javax.swing.JLabel lbGioVaoCa;
    private javax.swing.JLabel lbNhanVienCaHienTai;
    private javax.swing.JLabel lbTOngHoaDOnChuaTT;
    private javax.swing.JLabel lbTOngHoaDOnTT;
    private javax.swing.JLabel lbTOngTIenNganHang;
    private javax.swing.JLabel lbTienBanDau;
    private javax.swing.JLabel lbTongTIenThanhTOanBangTienMa;
    private javax.swing.JLabel lbTongTienThuTrongCa;
    private javax.swing.JLabel maNCCaHienTai;
    private javax.swing.JPanel panelTong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTienPhatSinh;
    // End of variables declaration//GEN-END:variables
}
