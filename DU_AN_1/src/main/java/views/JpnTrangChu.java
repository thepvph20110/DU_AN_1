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
import modelview.QLHoaDon;
import modelview.QLKhachHang;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.IAcountService;
import service.ICaService;
import service.IHoaDonService;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
import service.Impl.CaServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;

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
    private PhieuDatLich datLich;
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private IHoaDonService hoaDonService = new HoaDonServiceImpl();
    private Map<String, QLHoaDon> mapQLHoaDon = new HashMap<>();
    private Map<String, PhieuDatLich> mapPhieuDatLich = new HashMap<>();

    /**
     * Creates new form TrangChuJPanel
     */
    public JpnTrangChu(QLAcount qLAcount, JLabel lbHome, JPanel pnTong) {
        initComponents();
        listSanCa = sanCaService.getAll();
        listSanBong = sanBongService.getAll();
        this.qLAcount = qLAcount;
        labelHome = lbHome;
        this.pnTong = pnTong;
        AddSan();
        for (QLSanCa qLSanCa : listSanCa) {
            mapSanCa.put(qLSanCa.getId(), qLSanCa);
        }
        for (QLHoaDon qLHoaDon : hoaDonService.getAllByTrangThai()) {
            mapQLHoaDon.put(qLHoaDon.getPhieuDatLich().getId(), qLHoaDon);
        }
    }

    private void showThanhToan(String id) {
        QLHoaDon hoaDon = mapQLHoaDon.get(id);

        System.out.println("aaa12333434:" + id);
        new FrmThanhToan(hoaDon).setVisible(true);

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
                    JMenuItem itemCheckOut = new JMenuItem("Chi tiết sân đặt");
                    JMenuItem itemDoiLichDat = new JMenuItem("Đổi lịch đặt");
                    jPopupMenu.add(itemDatLich);
                    jPopupMenu.add(itemCheckOut);
                    jPopupMenu.add(itemDoiLichDat);
                    JPanel panelCa = new JPanel();
                    panelCa.setLayout(new FlowLayout());
                    panelCa.setPreferredSize(new Dimension(174, 254));
                    panelCa.setComponentPopupMenu(jPopupMenu);
                    panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                    panelCa.setLayout(new FlowLayout(10, 20, 20));
                    JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                    JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                    JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                    JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                    labelCa.setForeground(Color.BLACK);
                    labelCa.setFont(new Font("Tahoma", 1, 16));
                    labelThoiGian.setForeground(Color.BLACK);
                    labelThoiGian.setFont(new Font("Tahoma", 1, 12));
                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.KHONG_TRONG) {
                        datLich = phieuDatLichService.getPhieuDatLich(labelIdSanCa.getText());
                        System.out.println(datLich.getId());
                    }
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
                            showThanhToan(datLich.getId());
                            panelCa.setEnabled(false);
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

                    customTrangThai(listSanCa.get(j).getTrangThai(), itemDatLich, panelCa, labelTrangThai);

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

    private void customTrangThai(trangThaiSanCa ttSanCa, JMenuItem item, JPanel panel, JLabel label) {
        if (ttSanCa == trangThaiSanCa.CHO_NHAN_SAN) {
            item.setEnabled(false);
            label.setText(" Trạng thái: " + "Chờ nhận sân");
            panel.setBackground(new Color(255, 255, 0));
        } else if (ttSanCa == trangThaiSanCa.KHONG_TRONG) {
            item.setEnabled(false);

            label.setText(" Trạng thái: " + "Đang sử dụng");
            panel.setBackground(new Color(255, 0, 51));
        } else {
            label.setText(" Trạng thái: " + "Đang trống");
            panel.setBackground(new Color(0, 153, 0));
        }
    }

    private void showDetail(String idSanCa) {
        Acount acount = new Acount(qLAcount.getId(), qLAcount.getMaAcount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), qLAcount.getTrangThai());
        QLSanCa qLSanCa = mapSanCa.get(idSanCa);
        QLKhachHang khachHang = new QLKhachHang();
        new FrmPhieuDatLich(khachHang, qLSanCa, acount, labelHome, pnTong).setVisible(true);
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

        setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelTong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTong;
    // End of variables declaration//GEN-END:variables
}
