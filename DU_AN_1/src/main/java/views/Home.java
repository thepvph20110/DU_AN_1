/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodel.KhachHang;
import enumclass.trangThaiSanBong;
import enumclass.trangThaiSanCa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.swing.border.TitledBorder;
=======
import modelview.QLAcount;
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
import modelview.QLKhachHang;
import modelview.QLSanBong;
import modelview.QLSanCa;
<<<<<<< HEAD
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.SanBongServiceImpl;
=======
import service.IAcountService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======
import javax.swing.border.TitledBorder;
import modelview.QLAcount;
import modelview.QLKhachHang;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.SanBongServiceImpl;
import service.IAcountService;
import service.ISanCaService;
import service.Impl.AcountServiceImpl;
>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author DANG VAN SY
 */
public class Home extends javax.swing.JFrame {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
    
    public JPanel panelCa;
    public JPanel panelSan;
    public JLabel labelCa;
    public JLabel labelThoiGian;
    public JLabel labelLoaiSan;
    public JLabel labelSan;
    public JPopupMenu jPopupMenu = new JPopupMenu();
    public JMenuItem itemtt;
    public JMenuItem itemxoa;
    public JLabel labelTrangThai;
    private List<QLSanCa> listSanCa = new ArrayList<>();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    public List<JPanel> listPaneCa = new ArrayList<>();

<<<<<<< HEAD
=======
=======
>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private IAcountService acountService = new AcountServiceImpl();
    public JPanel panel = new JPanel();

    
<<<<<<< HEAD
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
    public Home() {
        initComponents();
        time();
        showDongHo();
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        AddSan();
        
    }
    
    public void AddSan() {
        listSanCa = sanCaService.getAll();
        listSanBong = sanBongService.getAll();
        System.out.println(listSanCa);
//        PaneTong.setLayout(new BoxLayout(PaneTong, BoxLayout.X_AXIS));
        PaneTong.setLayout(new GridLayout(10000, 1, 20, 20));
        
        JMenuItem itemtt = new JMenuItem("Đổi trạng thái");
        JMenuItem itemxoa = new JMenuItem("Xóa");
        
        itemtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(panelSan, "heloo");
                int a = panelSan.getX();
                panelCa = listPaneCa.get(a);
                panelCa.setBackground(Color.red);            
            }
        });
        itemxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelSan, "heloo");
            }
        });
        jPopupMenu.add(itemtt);
        jPopupMenu.add(itemxoa);
        for (int i = 1; i <= listSanBong.size(); i++) {
            TitledBorder border = new TitledBorder("Sân" + " " + i);
            panelSan = new JPanel();
//            for (QLSanCa qLSanBong : listSanCa) {
//                if (qLSanBong.getTrangThai() == trangThaiSanCa.CHO_NHAN_SAN) {
//                    panelSan.setBackground(new Color(255, 0, 51));
//                } else {
//                    panelSan.setBackground(new Color(186, 228, 229));
//                }
//            }

            panelSan.setBorder(border);
            
            panelSan.setPreferredSize(new Dimension(1325, 200));
            panelSan.setLayout(new GridLayout(1, 6, 20, 20));
            for (int j = 1; j <= listSanCa.size(); j++) {
                panelCa = new JPanel();
                for (QLSanCa qLSanCa : listSanCa) {
                    
               
                panelCa.setLayout(new FlowLayout());
                panelCa.add(jPopupMenu);
                panelCa.setPreferredSize(new Dimension(174, 254));
                panelCa.setBackground(new Color(0, 153, 0));
                panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                panelCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panelCa.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        panelCaInMouseReleased(evt);
                    }
                    
                    private void panelCaInMouseReleased(MouseEvent evt) {
                        if (evt.isPopupTrigger()) {
                            jPopupMenu.show(null, evt.getXOnScreen(), evt.getYOnScreen());
                        }
                        
                    }
                });
                panelCa.setLayout(new FlowLayout(10, 65, 20));
                labelCa = new JLabel("Ca" + " " + j);
                labelCa.setLayout(new FlowLayout(10, 75, 20));
                labelThoiGian = new JLabel("Thời gian");
                labelLoaiSan = new JLabel("Loại sân" + " " + j);
                labelCa.setForeground(Color.white);
                labelCa.setFont(new Font("Tahoma", 1, 16));
                labelThoiGian.setForeground(Color.white);
                labelThoiGian.setFont(new Font("Tahoma", 1, 14));
                labelLoaiSan.setForeground(Color.white);
                labelLoaiSan.setFont(new Font("Tahoma", 1, 14));
                labelTrangThai = new JLabel(" "+qLSanCa.getTrangThai());
                labelTrangThai.setForeground(Color.white);
                labelTrangThai.setPreferredSize(new Dimension(100, 17));
                panelCa.add(labelCa);
                panelCa.add(labelThoiGian);
                panelCa.add(labelLoaiSan);
                panelCa.add(labelTrangThai);
                listPaneCa.add(panelCa);
                panelSan.add(panelCa);
                 }
            }
            PaneTong.add(panelSan);
        }
        
    }
<<<<<<< HEAD
=======
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
//        addSanPane();
    }
    
//    public void addSanPane() {
//        frame.setLayout(new FlowLayout());
//        jPanel8 = new JPanel();
//        paneTong = new JScrollPane();
//        paneTong.setLayout(new ScrollPaneLayout());
//        panel.setPreferredSize(new Dimension(1333, 324));
//        panel.setBackground(new Color(186, 228, 229));
//        jPanel8.add(panel);
//        jPanel8.show();
//        paneTong.add(jPanel8);
////        paneTong.show();
//        frame.add(paneTong);
//        frame.show();
//        
//    }
<<<<<<< HEAD
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
    
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
        lbDichVu = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        lbLichSu = new javax.swing.JLabel();
        lbDangXuat = new javax.swing.JLabel();
        lbQLSan = new javax.swing.JLabel();
        lbLichDat = new javax.swing.JLabel();
        lbThongKe = new javax.swing.JLabel();
        lbCheckIn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchText1 = new utill.SearchText();
        lbSearch = new javax.swing.JLabel();
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
        btnDatLich = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

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
        lbHome.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\ball.png")); // NOI18N
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setOpaque(true);

        lbQLCa.setBackground(new java.awt.Color(166, 145, 92));
        lbQLCa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLCa.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
<<<<<<< HEAD
        lbQLCa.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\ca.png")); // NOI18N
=======
        lbQLCa.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ca.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbQLCa.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\ca.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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

        lbDichVu.setBackground(new java.awt.Color(166, 145, 92));
        lbDichVu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDichVu.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
<<<<<<< HEAD
        lbDichVu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\service.png")); // NOI18N
=======
        lbDichVu.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\service.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbDichVu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\service.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        lbDichVu.setText("Dịch Vụ");
        lbDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDichVu.setOpaque(true);
        lbDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDichVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDichVuMouseExited(evt);
            }
        });

        lbHoaDon.setBackground(new java.awt.Color(166, 145, 92));
        lbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
<<<<<<< HEAD
        lbHoaDon.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\bill.png")); // NOI18N
=======
        lbHoaDon.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\bill.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbHoaDon.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\bill.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        lbHoaDon.setText("Hóa Đơn");
        lbHoaDon.setToolTipText("");
        lbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHoaDon.setOpaque(true);
        lbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHoaDonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHoaDonMousePressed(evt);
            }
        });

        lbLichSu.setBackground(new java.awt.Color(166, 145, 92));
        lbLichSu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLichSu.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
<<<<<<< HEAD
        lbLichSu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\history.png")); // NOI18N
=======
        lbLichSu.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\history.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbLichSu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\history.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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
<<<<<<< HEAD
<<<<<<< HEAD
        lbDangXuat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\logout.png")); // NOI18N
=======
        lbDangXuat.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\Login32.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbDangXuat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\logout.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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
<<<<<<< HEAD
<<<<<<< HEAD
        lbQLSan.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\stadium.png")); // NOI18N
=======
        lbQLSan.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\stadium.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbQLSan.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\stadium.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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
<<<<<<< HEAD
<<<<<<< HEAD
        lbLichDat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\booking.png")); // NOI18N
=======
        lbLichDat.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\booking.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbLichDat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\booking.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        lbLichDat.setText("Lịch Đặt");
        lbLichDat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLichDat.setOpaque(true);
        lbLichDat.addMouseListener(new java.awt.event.MouseAdapter() {
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
<<<<<<< HEAD
<<<<<<< HEAD
        lbThongKe.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\ThongKe.png")); // NOI18N
=======
        lbThongKe.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ThongKe.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbThongKe.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\ThongKe.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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
<<<<<<< HEAD
<<<<<<< HEAD
        lbCheckIn.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\Check.png")); // NOI18N
=======
        lbCheckIn.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\Check.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbCheckIn.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\Check.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
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
                            .addComponent(lbHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQLCa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbQLSan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLichDat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                .addGap(40, 40, 40)
                .addComponent(lbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(11, 127, 171));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);

        searchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText1ActionPerformed(evt);
            }
        });

        lbSearch.setBackground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
<<<<<<< HEAD
        lbSearch.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\search.png")); // NOI18N
=======
        lbSearch.setIcon(new javax.swing.ImageIcon("D:\\DU_AN_1\\DU_AN_1\\src\\main\\java\\views\\icon\\search.png")); // NOI18N
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

        lbSearch.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\search.png")); // NOI18N

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        lbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSearch.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(452, 452, 452)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(searchText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addGap(0, 1357, Short.MAX_VALUE)
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
        jLabel19.setText("Không trống");

        btnDatLich.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDatLich.setText("Đặt lịch");
        btnDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1_V1\\DU_AN_1\\src\\main\\java\\views\\icon\\refech.png")); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatLich)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(paneTong)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDatLich)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneTong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 779, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
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
        JOptionPane.showMessageDialog(this, "Hello");
    }//GEN-LAST:event_lbDangXuatMouseClicked

    private void lbLichSuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichSuMouseExited
        lbLichSu.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbLichSuMouseExited

    private void lbLichSuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLichSuMouseEntered
        lbLichSu.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbLichSuMouseEntered

    private void lbHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseExited
        lbHoaDon.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbHoaDonMouseExited

    private void lbHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseEntered
        lbHoaDon.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbHoaDonMouseEntered

    private void lbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMouseClicked
        lbHoaDon.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbHoaDonMouseClicked

    private void lbDichVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDichVuMouseExited
        lbDichVu.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbDichVuMouseExited

    private void lbDichVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDichVuMouseEntered
        lbDichVu.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbDichVuMouseEntered

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

    private void btnDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichActionPerformed
        // TODO add your handling code here:
        QLKhachHang khachHang = new QLKhachHang();
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366
        QLSanCa qLSanCa = new QLSanCa();
        new FrmPhieuDatLich(khachHang, qLSanCa).setVisible(true);
    }//GEN-LAST:event_btnDatLichActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lbQLSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSanMouseClicked
        new FrmSanBong().setVisible(true);
    }//GEN-LAST:event_lbQLSanMouseClicked

    private void lbQLCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLCaMouseClicked
        new FrmCa().setVisible(true);
    }//GEN-LAST:event_lbQLCaMouseClicked
<<<<<<< HEAD
=======
        QLSanCa qLSanCa = sanCaService.getOne();
        QLAcount qLAcount = acountService.getOne();
        new FrmPhieuDatLich(khachHang,qLSanCa,qLAcount).setVisible(true);
    }//GEN-LAST:event_btnDatLichActionPerformed

    private void lbHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHoaDonMousePressed
        // TODO add your handling code here:
        new FrmHoaDon().setVisible(true);
    }//GEN-LAST:event_lbHoaDonMousePressed
>>>>>>> acceb2419cc15f426a814e5cba3e404d0c4281e6
=======

>>>>>>> a461aab29b932192bcc93406c1f367b0f4f77366

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu CheckInCLick;
    private javax.swing.JMenuItem CheckPhone;
    private javax.swing.JMenuItem CheckQR;
    private javax.swing.JPanel PaneTong;
    private javax.swing.JPopupMenu San1Ca1;
    private javax.swing.JButton btnDatLich;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private static javax.swing.JLabel lbCheckIn;
    private static javax.swing.JLabel lbDangXuat;
    private javax.swing.JLabel lbDichVu;
    private static javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbHome;
    private static javax.swing.JLabel lbLichDat;
    private javax.swing.JLabel lbLichSu;
    private static javax.swing.JLabel lbQLCa;
    private static javax.swing.JLabel lbQLSan;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbTime;
    private javax.swing.JScrollPane paneTong;
    private utill.SearchText searchText1;
    private javax.swing.JMenuItem trangThai;
    private javax.swing.JMenuItem xoa;
    // End of variables declaration//GEN-END:variables
}
