/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodel.Acount;
import domainmodel.PhieuDatLich;
import domainmodel.SanCa;
import enumclass.trangThaiAcount;
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
import java.util.Calendar;
import java.util.Date;
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
import service.ISanBongService;
import service.Impl.SanBongServiceImpl;
import service.IAcountService;
import service.ICaService;
import service.IHoaDonService;
import service.IPhieuDatLichService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
import service.Impl.CaServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author DANG VAN SY
 */
public class Home extends javax.swing.JFrame {

    private List<QLSanCa> listSanCa = new ArrayList<>();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private List<QLCa> listCa = new ArrayList<>();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    private ICaService caService = new CaServiceImpl();
    public List<JPanel> listPaneCa = new ArrayList<>();
    private IAcountService acountService = new AcountServiceImpl();
    public JPanel panel = new JPanel();
    private QLAcount qLAcount;
    private Dimension dimension;
    private Map<String, QLSanCa> mapSanCa = new HashMap<>();
    private Map<String, QLHoaDon> mapQLHoaDon = new HashMap<>();
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private IHoaDonService hoaDonService = new HoaDonServiceImpl();
    private PhieuDatLich datLich;

    public Home(QLAcount qLAcount) {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        time();
        this.qLAcount = qLAcount;
        showDongHo();
        listSanCa = sanCaService.getAll();
        listSanBong = sanBongService.getAll();
        listCa = caService.getAll();
        AddSan();
        for (QLSanCa qLSanCa : listSanCa) {
            mapSanCa.put(qLSanCa.getId(), qLSanCa);
        }
        for (QLHoaDon qLHoaDon : hoaDonService.getAll()) {
            mapQLHoaDon.put(qLHoaDon.getPhieuDatLich().getId(), qLHoaDon);
        }
    }

    private void showThanhToan(String id) {
        QLHoaDon hoaDon = mapQLHoaDon.get(id);
        new FrmThanhToan(hoaDon).setVisible(true);

    }

    public void AddSan() {
        PaneTong.setLayout(new GridLayout(10000, 1, 20, 20));

        for (int i = 0; i < listSanBong.size(); i++) {
            TitledBorder border = new TitledBorder(listSanBong.get(i).getTenSanBong());
            JPanel panelSan = new JPanel();
            panelSan.setBorder(border);
            panelSan.setPreferredSize(new Dimension(1325, 200));
            panelSan.setLayout(new GridLayout(1, 100, 20, 20));
            for (int j = 0; j < listSanCa.size(); j++) {
                if (listSanBong.get(i).getTenSanBong().equals(listSanCa.get(j).getTenSanBong())) {
                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.CHO_NHAN_SAN) {
                        JPanel panelCa = new JPanel();
                        panelCa.setBackground(new Color(255, 255, 0));
                        panelCa.setLayout(new FlowLayout());
                        panelCa.setPreferredSize(new Dimension(174, 254));
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                        panelCa.setLayout(new FlowLayout(10, 20, 10));
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                        JLabel labelThoiGian = new JLabel(String.valueOf(listSanCa.get(j).getThoiGianBatDau()) + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                         datLich = phieuDatLichService.getPhieuDatLich(labelIdSanCa.getText());
                        JLabel lableTenKH = new JLabel("Tên Khách hàng: " + datLich.getKhachHang().getTenKhachHang());
                        lableTenKH.setFont(new Font("Tahoma", 1, 12));
                        lableTenKH.setForeground(Color.BLACK);
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        labelCa.setForeground(Color.BLACK);
                        labelCa.setFont(new Font("Tahoma", 1, 16));
                        labelThoiGian.setForeground(Color.BLACK);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 11));
                        labelLoaiSan.setForeground(Color.BLACK);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                        JLabel labelTrangThai = new JLabel(" Trạng thái: " + "Chờ Nhận Sân");
                        labelTrangThai.setForeground(Color.BLACK);
                        labelTrangThai.setPreferredSize(new Dimension(160, 17));
                        labelTrangThai.setFont(new Font("Tahoma", 1, 12));
                        JLabel labelGiaSan = new JLabel("Giá: " + String.valueOf(listSanCa.get(j).getGiaCaSan()));
                        labelGiaSan.setFont(new Font("Tahoma", 1, 12));
                        labelGiaSan.setForeground(Color.BLACK);

                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
                        panelCa.add(lableTenKH);
                        panelCa.add(labelLoaiSan);

                        panelCa.add(labelTrangThai);
                        panelCa.add(labelGiaSan);

                        listPaneCa.add(panelCa);
                        panelSan.add(panelCa);
                    } else if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.KHONG_TRONG) {
                        JPopupMenu jPopupMenu = new JPopupMenu();
                        jPopupMenu.removeAll();
                        JMenuItem itemDatLich = new JMenuItem("Đặt Lịch");
                        JMenuItem itemCheckOut = new JMenuItem("Chi tiết đặt sân");
                        jPopupMenu.add(itemDatLich);
                        jPopupMenu.add(itemCheckOut);
                        JPanel panelCa = new JPanel();
                        panelCa.setBackground(new Color(255, 0, 51));
                        panelCa.setLayout(new FlowLayout());
                        panelCa.add(jPopupMenu);
                        panelCa.setPreferredSize(new Dimension(174, 254));
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
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
                        panelCa.setLayout(new FlowLayout(10, 20, 10));
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                        JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                        labelCa.setForeground(Color.BLACK);
                        labelCa.setFont(new Font("Tahoma", 1, 16));
                        labelThoiGian.setForeground(Color.BLACK);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 11));
                        datLich = phieuDatLichService.getPhieuDatLich(labelIdSanCa.getText());
                        JLabel lableTenKH = new JLabel("Tên Khách hàng: " + datLich.getKhachHang().getTenKhachHang());
                        lableTenKH.setFont(new Font("Tahoma", 1, 12));
                        lableTenKH.setForeground(Color.BLACK);
                        labelLoaiSan.setForeground(Color.BLACK);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                        JLabel labelTrangThai = new JLabel(" Trạng thái: " + "Đang sử dụng");
                        labelTrangThai.setForeground(Color.BLACK);
                        labelTrangThai.setPreferredSize(new Dimension(160, 17));
                        labelTrangThai.setFont(new Font("Tahoma", 1, 12));
                        JLabel labelGiaSan = new JLabel("Giá: " + String.valueOf(listSanCa.get(j).getGiaCaSan()));
                        labelGiaSan.setFont(new Font("Tahoma", 1, 12));
                        labelGiaSan.setForeground(Color.BLACK);
                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
                        panelCa.add(lableTenKH);
                        panelCa.add(labelLoaiSan);
                        panelCa.add(labelTrangThai);
                        panelCa.add(labelGiaSan);
                        listPaneCa.add(panelCa);
                        panelSan.add(panelCa);
                        itemCheckOut.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showThanhToan(datLich.getId());
                                jPopupMenu.setVisible(false);
                            }
                        });
                        itemDatLich.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(panelSan, "Sân đã có người đặt không thể đặt lịch!");
                                jPopupMenu.setVisible(false);
                            }
                        });
                    } else {
                        JPopupMenu jPopupMenu = new JPopupMenu();
                        JMenuItem itemDatLich = new JMenuItem("Đặt Lịch");
                        JMenuItem itemCheckOut = new JMenuItem("Check Out");
                        jPopupMenu.add(itemDatLich);
                        jPopupMenu.add(itemCheckOut);
                        JPanel panelCa = new JPanel();
                        panelCa.setLayout(new FlowLayout());
                        panelCa.setPreferredSize(new Dimension(174, 254));
                        panelCa.setComponentPopupMenu(jPopupMenu);
                        panelCa.setBackground(new Color(0, 153, 0));
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                        panelCa.setLayout(new FlowLayout(10, 20, 20));
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
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
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                        JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " : " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        labelCa.setForeground(Color.BLACK);
                        labelCa.setFont(new Font("Tahoma", 1, 16));
                        labelThoiGian.setForeground(Color.BLACK);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 11));
                        labelLoaiSan.setForeground(Color.BLACK);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                        JLabel labelTrangThai = new JLabel(" Trạng thái: " + "Đang Trống");
                        labelTrangThai.setForeground(Color.BLACK);
                        labelTrangThai.setPreferredSize(new Dimension(160, 17));
                        labelTrangThai.setFont(new Font("Tahoma", 1, 12));
                        JLabel labelGiaSan = new JLabel("Giá: " + String.valueOf(listSanCa.get(j).getGiaCaSan()));
                        labelGiaSan.setFont(new Font("Tahoma", 1, 12));
                        labelGiaSan.setForeground(Color.BLACK);
                        panelCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
                        panelCa.add(labelLoaiSan);
                        panelCa.add(labelTrangThai);
                        panelCa.add(labelGiaSan);
                        listPaneCa.add(panelCa);
                        panelSan.add(panelCa);
                        itemCheckOut.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(panelSan, "Sân này chưa có người đá!");
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
                    }
                }
            }
            PaneTong.add(panelSan);
        }

    }

    private void showDetail(String idSanCa) {
        Acount acount = new Acount(qLAcount.getId(), qLAcount.getMaAcount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), qLAcount.getTrangThai());
        QLSanCa qLSanCa = mapSanCa.get(idSanCa);
        QLKhachHang khachHang = new QLKhachHang();
        new FrmPhieuDatLich(khachHang, qLSanCa, acount).setVisible(true);
    }

    private void time() {
        Date date = new Date();
        lbTime.setText(date.toString());
        jDate.setBackground(new Color(22, 69, 62));
        jDate.setDate(date);
    }

    public void showDongHo() {
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar cal = Calendar.getInstance();
                        int h = cal.get(Calendar.HOUR);
                        int m = cal.get(Calendar.MINUTE);
                        int s = cal.get(Calendar.SECOND);
                        String gio = "", phut = "", giay = "";
                        if (h <= 9) {
                            gio = "0" + h;
                        } else {
                            gio = "" + h;
                        }
                        if (m <= 9) {
                            phut = "0" + m;
                        } else {
                            phut = "" + m;
                        }
                        if (s <= 9) {
                            giay = "0" + s;
                        } else {
                            giay = "" + s;
                        }
                        lbTime.setText(gio + ":" + phut + ":" + giay);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        };
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckInCLick = new javax.swing.JPopupMenu();
        CheckQR = new javax.swing.JMenuItem();
        CheckPhone = new javax.swing.JMenuItem();
        San1Ca1 = new javax.swing.JPopupMenu();
        trangThai = new javax.swing.JMenuItem();
        xoa = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbHome = new javax.swing.JLabel();
        lbQLCa = new javax.swing.JLabel();
        lbHoaD = new javax.swing.JLabel();
        lbLichSu = new javax.swing.JLabel();
        lbDangXuat = new javax.swing.JLabel();
        lbQLSan = new javax.swing.JLabel();
        lbLichDat = new javax.swing.JLabel();
        lbThongKe = new javax.swing.JLabel();
        lbCheckIn = new javax.swing.JLabel();
        lbGiaoCa = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jDate = new com.toedter.calendar.JDateChooser();
        lbTime = new javax.swing.JLabel();
        paneTong = new javax.swing.JScrollPane();
        PaneTong = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchText1 = new utill.SearchText();
        lbReset = new javax.swing.JLabel();

        CheckQR.setText("Check QR Code");
        CheckQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckQRActionPerformed(evt);
            }
        });
        CheckInCLick.add(CheckQR);

        CheckPhone.setMnemonic('P');
        CheckPhone.setText("Check Number Phone");
        CheckPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPhoneActionPerformed(evt);
            }
        });
        CheckInCLick.add(CheckPhone);

        trangThai.setText("Chuyển đổi trạng thái");
        trangThai.setToolTipText("");
        trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaiActionPerformed(evt);
            }
        });
        San1Ca1.add(trangThai);

        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        San1Ca1.add(xoa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(166, 145, 92));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(166, 145, 92));
        jPanel3.setToolTipText("");

        lbHome.setBackground(new java.awt.Color(166, 145, 92));
        lbHome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbHome.setForeground(new java.awt.Color(255, 255, 255));
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setOpaque(true);

        lbQLCa.setBackground(new java.awt.Color(166, 145, 92));
        lbQLCa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLCa.setForeground(new java.awt.Color(255, 255, 255));
        lbQLCa.setText("Quản Lí Ca");
        lbQLCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLCa.setOpaque(true);
        lbQLCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLCaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQLCaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQLCaMouseExited(evt);
            }
        });

        lbHoaD.setBackground(new java.awt.Color(166, 145, 92));
        lbHoaD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbHoaD.setForeground(new java.awt.Color(255, 255, 255));
        lbHoaD.setText("Hóa Đơn");
        lbHoaD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHoaD.setOpaque(true);
        lbHoaD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHoaDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHoaDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHoaDMouseExited(evt);
            }
        });

        lbLichSu.setBackground(new java.awt.Color(166, 145, 92));
        lbLichSu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLichSu.setForeground(new java.awt.Color(255, 255, 255));
        lbLichSu.setText("Lịch Sử");
        lbLichSu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLichSu.setOpaque(true);
        lbLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLichSuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLichSuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLichSuMouseExited(evt);
            }
        });

        lbDangXuat.setBackground(new java.awt.Color(166, 145, 92));
        lbDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lbDangXuat.setText("Đăng Xuất");
        lbDangXuat.setToolTipText("");
        lbDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDangXuat.setOpaque(true);
        lbDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDangXuatMouseExited(evt);
            }
        });

        lbQLSan.setBackground(new java.awt.Color(166, 145, 92));
        lbQLSan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLSan.setForeground(new java.awt.Color(255, 255, 255));
        lbQLSan.setText("Quản Lí Sân");
        lbQLSan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLSan.setOpaque(true);
        lbQLSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLSanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQLSanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQLSanMouseExited(evt);
            }
        });

        lbLichDat.setBackground(new java.awt.Color(166, 145, 92));
        lbLichDat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLichDat.setForeground(new java.awt.Color(255, 255, 255));
        lbLichDat.setText("Lịch Đặt");
        lbLichDat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLichDat.setOpaque(true);
        lbLichDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLichDatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLichDatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLichDatMouseExited(evt);
            }
        });

        lbThongKe.setBackground(new java.awt.Color(166, 145, 92));
        lbThongKe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbThongKe.setText("Thống Kê");
        lbThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbThongKe.setOpaque(true);
        lbThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbThongKeMouseExited(evt);
            }
        });

        lbCheckIn.setBackground(new java.awt.Color(166, 145, 92));
        lbCheckIn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCheckIn.setForeground(new java.awt.Color(255, 255, 255));
        lbCheckIn.setText("Check In");
        lbCheckIn.setToolTipText("");
        lbCheckIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCheckIn.setOpaque(true);
        lbCheckIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCheckInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCheckInMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbCheckInMouseReleased(evt);
            }
        });

        lbGiaoCa.setBackground(new java.awt.Color(166, 145, 92));
        lbGiaoCa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbGiaoCa.setForeground(new java.awt.Color(255, 255, 255));
        lbGiaoCa.setText("Giao Ca");
        lbGiaoCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbGiaoCa.setOpaque(true);
        lbGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbGiaoCaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbGiaoCaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDangXuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLichSu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHoaD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQLCa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQLSan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLichDat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbGiaoCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLichDat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbQLSan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbQLCa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(lbHoaD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(446, Short.MAX_VALUE)
                    .addComponent(lbGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(333, 333, 333)))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jDate.setForeground(new java.awt.Color(204, 204, 204));

        lbTime.setBackground(new java.awt.Color(65, 147, 169));
        lbTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTime.setForeground(new java.awt.Color(65, 147, 169));
        lbTime.setText("Time");
        lbTime.setPreferredSize(new java.awt.Dimension(35, 20));

        paneTong.setBackground(new java.awt.Color(255, 204, 204));
        paneTong.setForeground(new java.awt.Color(255, 204, 204));

        PaneTong.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout PaneTongLayout = new javax.swing.GroupLayout(PaneTong);
        PaneTong.setLayout(PaneTongLayout);
        PaneTongLayout.setHorizontalGroup(
            PaneTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1502, Short.MAX_VALUE)
        );
        PaneTongLayout.setVerticalGroup(
            PaneTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        paneTong.setViewportView(PaneTong);

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Đang trống");

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Chờ nhận sân");

        jLabel18.setBackground(new java.awt.Color(255, 0, 51));
        jLabel18.setForeground(new java.awt.Color(0, 153, 0));
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Đang sử dụng");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        lbReset.setBackground(new java.awt.Color(255, 153, 0));
        lbReset.setForeground(new java.awt.Color(255, 153, 0));
        lbReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(22, 22, 22)
                        .addComponent(lbReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneTong, javax.swing.GroupLayout.DEFAULT_SIZE, 1382, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(searchText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneTong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 779, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbLichDatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichDatMouseExited
        lbLichDat.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbLichDatMouseExited

    private void lbLichDatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichDatMouseEntered
        lbLichDat.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbLichDatMouseEntered

    private void lbQLSanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseExited
        lbQLSan.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbQLSanMouseExited

    private void lbQLSanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseEntered
        lbQLSan.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbQLSanMouseEntered

    private void lbDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangXuatMouseExited
        lbDangXuat.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbDangXuatMouseExited

    private void lbDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangXuatMouseEntered
        lbDangXuat.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbDangXuatMouseEntered

    private void lbDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangXuatMouseClicked
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            this.dispose();
            new Detaillogin(null, true).setVisible(true);
        }
    }//GEN-LAST:event_lbDangXuatMouseClicked

    private void lbLichSuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichSuMouseExited
        lbLichSu.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbLichSuMouseExited

    private void lbLichSuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichSuMouseEntered
        lbLichSu.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbLichSuMouseEntered

    private void lbHoaDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDMouseExited
        lbHoaD.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbHoaDMouseExited

    private void lbHoaDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDMouseEntered
        lbHoaD.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbHoaDMouseEntered

    private void lbQLCaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseExited
        lbQLCa.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbQLCaMouseExited

    private void lbQLCaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseEntered
        lbQLCa.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbQLCaMouseEntered

    private void lbThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThongKeMouseEntered
        lbThongKe.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbThongKeMouseEntered

    private void lbThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThongKeMouseExited
        lbThongKe.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbThongKeMouseExited

    private void lbCheckInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckInMouseEntered
        lbCheckIn.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbCheckInMouseEntered

    private void lbCheckInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckInMouseExited
        lbCheckIn.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbCheckInMouseExited

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText1ActionPerformed
        JOptionPane.showMessageDialog(this, "He so lo ");
    }//GEN-LAST:event_searchText1ActionPerformed

    private void lbCheckInMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckInMouseReleased
        if (evt.isPopupTrigger()) {
            CheckInCLick.show(this, evt.getXOnScreen(), evt.getYOnScreen());
        }
    }//GEN-LAST:event_lbCheckInMouseReleased

    private void CheckQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckQRActionPerformed
        new WebCam().setVisible(true);
    }//GEN-LAST:event_CheckQRActionPerformed

    private void CheckPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPhoneActionPerformed
        JOptionPane.showMessageDialog(this, "Check SDT");
    }//GEN-LAST:event_CheckPhoneActionPerformed

    private void trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaiActionPerformed
        JOptionPane.showMessageDialog(this, "Chuyển đổi thành công ");
    }//GEN-LAST:event_trangThaiActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        JOptionPane.showMessageDialog(this, "Xóa oke ");
    }//GEN-LAST:event_xoaActionPerformed

    private void lbLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichSuMouseClicked
        new FrmLichSuDatSan().setVisible(true);
    }//GEN-LAST:event_lbLichSuMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        new Home(qLAcount).setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lbQLSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseClicked
        new FrmSanBong().setVisible(true);
    }//GEN-LAST:event_lbQLSanMouseClicked

    private void lbQLCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseClicked
        new FrmCa().setVisible(true);
    }//GEN-LAST:event_lbQLCaMouseClicked

    private void lbGiaoCaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiaoCaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbGiaoCaMouseEntered

    private void lbGiaoCaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiaoCaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbGiaoCaMouseExited

    private void lbResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbResetMouseClicked

        new Home(qLAcount).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbResetMouseClicked

    private void lbHoaDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDMouseClicked
        new FrmHoaDon().setVisible(true);
    }//GEN-LAST:event_lbHoaDMouseClicked

    private void lbLichDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichDatMouseClicked
        new FrmSanCa().setVisible(true);
    }//GEN-LAST:event_lbLichDatMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu CheckInCLick;
    private javax.swing.JMenuItem CheckPhone;
    private javax.swing.JMenuItem CheckQR;
    private javax.swing.JPanel PaneTong;
    private javax.swing.JPopupMenu San1Ca1;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private static javax.swing.JLabel lbCheckIn;
    private static javax.swing.JLabel lbDangXuat;
    private javax.swing.JLabel lbGiaoCa;
    private javax.swing.JLabel lbHoaD;
    private javax.swing.JLabel lbHome;
    private static javax.swing.JLabel lbLichDat;
    private javax.swing.JLabel lbLichSu;
    private static javax.swing.JLabel lbQLCa;
    private static javax.swing.JLabel lbQLSan;
    private javax.swing.JLabel lbReset;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbTime;
    private javax.swing.JScrollPane paneTong;
    private utill.SearchText searchText1;
    private javax.swing.JMenuItem trangThai;
    private javax.swing.JMenuItem xoa;
    // End of variables declaration//GEN-END:variables
}
