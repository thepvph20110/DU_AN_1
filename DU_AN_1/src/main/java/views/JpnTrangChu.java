/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.Acount;
import domainmodel.PhieuDatLich;
import enumclass.trangThaiSanCa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
<<<<<<< HEAD
=======
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;
import modelview.QLAcount;
import modelview.QLCa;
import modelview.QLKhachHang;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.IAcountService;
import service.ICaService;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import service.IThongKeService;
import service.Impl.ThongKeServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnTrangChu extends javax.swing.JPanel {

    private List<QLSanCa> listSanCa = new ArrayList<>();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    public List<JPanel> listPaneCa = new ArrayList<>();
    private IAcountService acountService = new AcountServiceImpl();
    public JPanel panel = new JPanel();
    private QLAcount qLAcount;
    private Dimension dimension;
    private Map<String, QLSanCa> mapSanCa = new HashMap<>();
    private Map<String, PhieuDatLich> map = new HashMap<>();
    private JLabel labelHome;
    private JPanel pnTong;
<<<<<<< HEAD
=======
    private PhieuDatLich datLich;
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private IHoaDonService hoaDonService = new HoaDonServiceImpl();
    private Map<String, QLHoaDon> mapQLHoaDon = new HashMap<>();
    private Map<String, PhieuDatLich> mapPhieuDatLich = new HashMap<>();
    private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private Clip clip;
    private Date ngayTao = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
    private IThongKeService thongKeService = new ThongKeServiceImpl();
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2

    /**
     * Creates new form TrangChuJPanel
     */
<<<<<<< HEAD
    public JpnTrangChu(QLAcount qLAcount, JLabel lbHome, JPanel pnTong) {
        initComponents();
        listSanCa = sanCaService.getAll();
=======
    public JpnTrangChu(QLAcount qLAcount, JLabel lbHome, JPanel pnTong, Date ngatTao) {
        initComponents();
        this.ngayTao = ngatTao;
        listSanCa = sanCaService.getAll(ngayTao);
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
        listSanBong = sanBongService.getAll();
        this.qLAcount = qLAcount;
        labelHome = lbHome;
        this.pnTong = pnTong;
        txtNgay.setText("Ngày: " + sdf.format(ngatTao));
        AddSan();
        for (QLSanCa qLSanCa : listSanCa) {
            mapSanCa.put(qLSanCa.getId(), qLSanCa);
        }
<<<<<<< HEAD
=======
        for (QLHoaDon qLHoaDon : hoaDonService.getAllByTrangThai()) {
            mapQLHoaDon.put(qLHoaDon.getPhieuDatLich().getId(), qLHoaDon);
        }
        lbTongTien.setText(decimalFormat.format(thongKeService.getTongTienNgayHienTai(ngayTao)) + " " + "Vnd");
    }

    private void showThanhToan(String id) {
        QLHoaDon hoaDon = mapQLHoaDon.get(id);
        new FrmThanhToan(hoaDon).setVisible(true);

>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
    }

    private void PlaySound() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("D:\\thongbao.wav")));
            clip.start();
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public void AddSan() {
        panelTong.setLayout(new GridLayout(10000, 1, 20, 20));

        for (int i = 0; i < listSanBong.size(); i++) {
            TitledBorder border = new TitledBorder(listSanBong.get(i).getTenSanBong());
            JPanel panelSan = new JPanel();
            panelSan.setBorder(border);
            panelSan.setPreferredSize(new Dimension(1325, 200));
            panelSan.setLayout(new GridLayout(1, 100, 20, 20));
            for (int j = 0; j < listSanCa.size(); j++) {
                if (listSanBong.get(i).getTenSanBong().equals(listSanCa.get(j).getTenSanBong())) {
                    JPopupMenu jPopupMenu = new JPopupMenu();
                    JMenuItem itemDatLich = new JMenuItem("Đặt Lịch");
                    JMenuItem itemCheckOut = new JMenuItem("Check Out");
                    JMenuItem itemDoiLichDat = new JMenuItem("Đổi lịch đặt");
                    JMenuItem itemThongbao = new JMenuItem("Thông báo");
                    JMenuItem itemTatThongbao = new JMenuItem("Tắt thông báo");
                    jPopupMenu.add(itemDatLich);
                    jPopupMenu.add(itemCheckOut);
<<<<<<< HEAD
=======
                    jPopupMenu.add(itemDoiLichDat);
                    jPopupMenu.add(itemThongbao);
                    jPopupMenu.add(itemTatThongbao);
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
                    JPanel panelCa = new JPanel();
                    panelCa.setLayout(new FlowLayout());
                    panelCa.setPreferredSize(new Dimension(174, 254));
                    panelCa.setComponentPopupMenu(jPopupMenu);
                    panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                    panelCa.setLayout(new FlowLayout(10, 20, 20));
                    JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
<<<<<<< HEAD
=======
                    JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                    JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                    JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                    labelCa.setForeground(Color.BLACK);
                    labelCa.setFont(new Font("Tahoma", 1, 14));
                    labelThoiGian.setForeground(Color.BLACK);
                    labelThoiGian.setFont(new Font("Tahoma", 1, 10));
                    labelLoaiSan.setForeground(Color.BLACK);
                    labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                    JLabel lableTenKH = new JLabel();
                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.KHONG_TRONG || listSanCa.get(j).getTrangThai() == trangThaiSanCa.CHO_NHAN_SAN) {
                        datLich = phieuDatLichService.getPhieuDatLich(labelIdSanCa.getText());
                        lableTenKH.setText("Tên KH:" + datLich.getKhachHang().getTenKhachHang());
                        lableTenKH.setFont(new Font("Tahoma", 1, 10));
                        lableTenKH.setForeground(Color.BLACK);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 10));
                    }

                    JLabel labelTrangThai = new JLabel();
                    labelTrangThai.setForeground(Color.BLACK);
                    labelTrangThai.setPreferredSize(new Dimension(160, 15));
                    labelTrangThai.setFont(new Font("Tahoma", 1, 12));
                    JLabel labelGiaSan = new JLabel("Giá: " + decimalFormat.format(listSanCa.get(j).getGiaCaSan()) + " " + "Vnd");
                    labelGiaSan.setFont(new Font("Tahoma", 1, 12));
                    labelGiaSan.setForeground(Color.BLACK);
                    panelCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
                    panelCa.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            panelCaInMouseReleased(evt);
                        }

                        private void panelCaInMouseReleased(MouseEvent evt) {
                            if (evt.isPopupTrigger()) {
                                jPopupMenu.show(panelCa, evt.getPoint().x, evt.getPoint().y);
                            }

                        }
                    });
                    itemCheckOut.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(panelSan, "Sân này chưa có người đá! Không thể Check Out!");
                            jPopupMenu.setVisible(false);
                        }
                    });
                    itemDatLich.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            showDetail(labelIdSanCa.getText());
                            jPopupMenu.setVisible(false);
                        }
                    });
<<<<<<< HEAD

                    JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                    JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                    JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                    labelCa.setForeground(Color.BLACK);
                    labelCa.setFont(new Font("Tahoma", 1, 16));
                    labelThoiGian.setForeground(Color.BLACK);
                    labelThoiGian.setFont(new Font("Tahoma", 1, 12));
                    labelLoaiSan.setForeground(Color.BLACK);
                    labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                    JLabel labelTrangThai = new JLabel();
                    labelTrangThai.setForeground(Color.BLACK);
                    labelTrangThai.setPreferredSize(new Dimension(160, 17));
                    labelTrangThai.setFont(new Font("Tahoma", 1, 12));
                    JLabel labelGiaSan = new JLabel("Giá: " + String.valueOf(listSanCa.get(j).getGiaCaSan()));
                    labelGiaSan.setFont(new Font("Tahoma", 1, 12));
                    labelGiaSan.setForeground(Color.BLACK);
                    panelCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

                    //Trạng thái sân
//                    
//                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.CHO_NHAN_SAN) {
//                        itemDatLich.show(false);
//                        labelTrangThai.setText(" Trạng thái: " + "Chờ nhận sân");
//                        panelCa.setBackground(new Color(255, 255, 0));
//                    } else if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.KHONG_TRONG) {
//                        itemDatLich.show(false);
//                        labelTrangThai.setText(" Trạng thái: " + "Không trống");
//                        panelCa.setBackground(new Color(255, 0, 51));
//                    } else {
//                        labelTrangThai.setText(" Trạng thái: " + "Đang trống");
//                        panelCa.setBackground(new Color(0, 153, 0));
//                    }
                    customTrangThai(listSanCa.get(j).getTrangThai(), itemDatLich, panelCa, labelTrangThai);

=======
                    itemDoiLichDat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new FrmDoiLichDat(datLich, qLAcount, pnTong, labelHome, ngayTao).setVisible(true);
                            jPopupMenu.setVisible(false);
                        }
                    });
                    itemThongbao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            PlaySound();
                            jPopupMenu.setVisible(false);
                        }
                    });
                    itemTatThongbao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            clip.stop();
                            jPopupMenu.setVisible(false);
                        }
                    });

                    customTrangThai(listSanCa.get(j).getTrangThai(), itemDatLich, panelCa, labelTrangThai, itemDoiLichDat, itemCheckOut, itemThongbao, itemTatThongbao);
                    Time gioKT = new Time(listSanCa.get(j).getThoiGianKetThuc().getHours(), listSanCa.get(j).getThoiGianKetThuc().getMinutes(), listSanCa.get(j).getThoiGianKetThuc().getSeconds());
                    Time quaGio = new Time(now.getHours(), now.getMinutes(), now.getSeconds());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date homNay = new Date();
                    Date ngayTao = listSanCa.get(j).getNgayTao();
                    String ngayTaoSan = dateFormat.format(ngayTao);
                    String hienTai = dateFormat.format(homNay);
                    if (gioKT.getTime() < quaGio.getTime() && ngayTaoSan.equals(hienTai)) {
                        panelCa.setBackground(new Color(189, 195, 199));
                        itemCheckOut.setEnabled(true);
                        itemDatLich.setEnabled(false);
                        itemDoiLichDat.setEnabled(false);
                        itemThongbao.setEnabled(true);
                        itemTatThongbao.setEnabled(true);
                        labelTrangThai.setText("Trạng thái:" + " " + "Quá giờ");
                    }
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
                    panelCa.add(labelCa);
                    panelCa.add(labelThoiGian);
                    panelCa.add(labelLoaiSan);
                    panelCa.add(labelTrangThai);
                    panelCa.add(labelGiaSan);
                    listPaneCa.add(panelCa);
                    panelSan.add(panelCa);

                }
            }
            panelTong.add(panelSan);
        }

    }

<<<<<<< HEAD
    private void customTrangThai(trangThaiSanCa ttSanCa, JMenuItem item, JPanel panel, JLabel label) {
        if (ttSanCa == trangThaiSanCa.CHO_NHAN_SAN) {
            item.setEnabled(false);
            label.setText(" Trạng thái: " + "Chờ nhận sân");
            panel.setBackground(new Color(255, 255, 0));
=======
    private void customTrangThai(trangThaiSanCa ttSanCa, JMenuItem itemDatLich, JPanel panelSanCa, JLabel labelTrangThai, JMenuItem iTemDoiLich, JMenuItem itemCheckOut, JMenuItem itemThongbao, JMenuItem itemTatThongbao) {
        if (ttSanCa == trangThaiSanCa.CHO_NHAN_SAN) {
            itemCheckOut.setEnabled(false);
            itemDatLich.setEnabled(false);
            itemThongbao.setEnabled(false);
            itemTatThongbao.setEnabled(false);
            iTemDoiLich.setEnabled(true);
            labelTrangThai.setText(" Trạng thái: " + "Chờ nhận sân");
            panelSanCa.setBackground(new Color(255, 255, 0));
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
        } else if (ttSanCa == trangThaiSanCa.KHONG_TRONG) {
            item.setEnabled(false);
            label.setText(" Trạng thái: " + "Không trống");
            panel.setBackground(new Color(255, 0, 51));
<<<<<<< HEAD
        } else {
            label.setText(" Trạng thái: " + "Đang trống");
            panel.setBackground(new Color(0, 153, 0));
=======
            iTemDoiLich.setEnabled(false);
            itemDatLich.setEnabled(false);
            itemCheckOut.setEnabled(true);
            itemThongbao.setEnabled(true);
            itemTatThongbao.setEnabled(true);
            panelSanCa.setBackground(new Color(255, 0, 51));
        } else {
            itemDatLich.setEnabled(true);
            itemCheckOut.setEnabled(false);
            iTemDoiLich.setEnabled(false);
            itemThongbao.setEnabled(false);
            itemTatThongbao.setEnabled(false);
            labelTrangThai.setText(" Trạng thái: " + "Đang trống");
            panelSanCa.setBackground(new Color(0, 153, 0));
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
        }
    }

    private void showDetail(String idSanCa) {
        Acount acount = new Acount(qLAcount.getId(), qLAcount.getMaAcount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), qLAcount.getTrangThai());
        QLSanCa qLSanCa = mapSanCa.get(idSanCa);
        QLKhachHang khachHang = new QLKhachHang();
        new FrmPhieuDatLich(khachHang, qLSanCa, acount, labelHome, pnTong, ngayTao).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelTong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNgay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelTong);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNgay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNgay.setText("Ngày: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tổng tiền trong ngày:");

        lbTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTongTien.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbTongTien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JPanel panelTong;
    private javax.swing.JLabel txtNgay;
    // End of variables declaration//GEN-END:variables
}
