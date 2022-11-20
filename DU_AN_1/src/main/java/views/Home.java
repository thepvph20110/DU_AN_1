/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;

/**
 *
 * @author DANG VAN SY
 */
public class Home extends javax.swing.JFrame {
    
    public JPanel panel = new JPanel();
    public JFrame frame = new JFrame();
    
    public Home() {
        initComponents();
        time();
        showDongHo();
        addSanPane();
    }
    
    public void addSanPane() {
        frame.setLayout(new FlowLayout());
        jPanel8 = new JPanel();
        paneTong = new JScrollPane();
        paneTong.setLayout(new ScrollPaneLayout());
        panel.setPreferredSize(new Dimension(1333, 324));
        panel.setBackground(new Color(186, 228, 229));
        jPanel8.add(panel);
        jPanel8.show();
        paneTong.add(jPanel8);
//        paneTong.show();
        frame.add(paneTong);
        frame.show();
        
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbHome = new javax.swing.JLabel();
        lbQLCa = new javax.swing.JLabel();
        lbDichVu = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        lbLienHe = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        panSan1 = new javax.swing.JPanel();
        Pane1San1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbTrangThaiS1C1 = new javax.swing.JLabel();
        lbLoaiSanS1C1 = new javax.swing.JLabel();
        Pane2San1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbLoaiSanS1C2 = new javax.swing.JLabel();
        lbTrangThaiS1C2 = new javax.swing.JLabel();
        Pane3San1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbLoaiSanS1C3 = new javax.swing.JLabel();
        lbTrangThaiS1C3 = new javax.swing.JLabel();
        Pane4San1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbLoaiSanS1C4 = new javax.swing.JLabel();
        lbTrangThaiS1C4 = new javax.swing.JLabel();
        Pane5San1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbLoaiSanS1C5 = new javax.swing.JLabel();
        lbTrangThaiS1C5 = new javax.swing.JLabel();
        Pane6San1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbLoaiSanS1C6 = new javax.swing.JLabel();
        lbTrangThaiS1C6 = new javax.swing.JLabel();
        lbTenSan1 = new javax.swing.JLabel();
        panSan2 = new javax.swing.JPanel();
        Pane1San2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbLoaiSanS2C1 = new javax.swing.JLabel();
        lbTrangThaiS2C1 = new javax.swing.JLabel();
        Pane2San2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbLoaiSanS2C2 = new javax.swing.JLabel();
        lbTrangThaiS2C2 = new javax.swing.JLabel();
        Pane3San2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbLoaiSanS2C3 = new javax.swing.JLabel();
        lbTrangThaiS2C3 = new javax.swing.JLabel();
        Pane4San2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbLoaiSanS2C4 = new javax.swing.JLabel();
        lbTrangThaiS2C4 = new javax.swing.JLabel();
        Pane5San2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbLoaiSanS2C5 = new javax.swing.JLabel();
        lbTrangThaiS2C5 = new javax.swing.JLabel();
        Pane6San2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbLoaiSanS2C6 = new javax.swing.JLabel();
        lbTrangThaiS2C6 = new javax.swing.JLabel();
        lbTenSan2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

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
        lbHome.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ball.png")); // NOI18N
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setOpaque(true);

        lbQLCa.setBackground(new java.awt.Color(166, 145, 92));
        lbQLCa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQLCa.setForeground(new java.awt.Color(255, 255, 255));
        lbQLCa.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ca.png")); // NOI18N
        lbQLCa.setText("Quản Lí Ca");
        lbQLCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLCa.setOpaque(true);
        lbQLCa.addMouseListener(new java.awt.event.MouseAdapter() {
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
        lbDichVu.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\service.png")); // NOI18N
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
        lbHoaDon.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\bill.png")); // NOI18N
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
        });

        lbLienHe.setBackground(new java.awt.Color(166, 145, 92));
        lbLienHe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbLienHe.setForeground(new java.awt.Color(255, 255, 255));
        lbLienHe.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\callss.png")); // NOI18N
        lbLienHe.setText("Liên Hệ ");
        lbLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLienHe.setOpaque(true);
        lbLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLienHeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLienHeMouseExited(evt);
            }
        });

        lbDangXuat.setBackground(new java.awt.Color(166, 145, 92));
        lbDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lbDangXuat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\Login32.png")); // NOI18N
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
        lbQLSan.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\stadium.png")); // NOI18N
        lbQLSan.setText("Quản Lí Sân");
        lbQLSan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQLSan.setOpaque(true);
        lbQLSan.addMouseListener(new java.awt.event.MouseAdapter() {
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
        lbLichDat.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\booking.png")); // NOI18N
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
        lbThongKe.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\ThongKe.png")); // NOI18N
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
        lbCheckIn.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\Check.png")); // NOI18N
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
                            .addComponent(lbLienHe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(lbLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lbSearch.setIcon(new javax.swing.ImageIcon("D:\\TAI_LIEU_HOC_TAP\\Du_An_1\\DU_AN_1\\src\\main\\java\\views\\icon\\search.png")); // NOI18N
        lbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSearch.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(452, 452, 452)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        panSan1.setBackground(new java.awt.Color(186, 228, 229));
        panSan1.setForeground(new java.awt.Color(186, 228, 229));

        Pane1San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane1San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane1San1.setForeground(new java.awt.Color(0, 153, 0));
        Pane1San1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pane1San1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Pane1San1MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ca 1");

        lbTrangThaiS1C1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C1.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C1.setText("Trạng thái");

        lbLoaiSanS1C1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C1.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C1.setText("Loại sân");

        javax.swing.GroupLayout Pane1San1Layout = new javax.swing.GroupLayout(Pane1San1);
        Pane1San1.setLayout(Pane1San1Layout);
        Pane1San1Layout.setHorizontalGroup(
            Pane1San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane1San1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(Pane1San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTrangThaiS1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLoaiSanS1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pane1San1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(38, 38, 38))
        );
        Pane1San1Layout.setVerticalGroup(
            Pane1San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane1San1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addComponent(lbLoaiSanS1C1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        Pane2San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane2San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane2San1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ca 2");

        lbLoaiSanS1C2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C2.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C2.setText("Loại sân");

        lbTrangThaiS1C2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C2.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C2.setText("Trạng thái");

        javax.swing.GroupLayout Pane2San1Layout = new javax.swing.GroupLayout(Pane2San1);
        Pane2San1.setLayout(Pane2San1Layout);
        Pane2San1Layout.setHorizontalGroup(
            Pane2San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2San1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(Pane2San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2San1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2San1Layout.createSequentialGroup()
                        .addGroup(Pane2San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTrangThaiS1C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLoaiSanS1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))))
        );
        Pane2San1Layout.setVerticalGroup(
            Pane2San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2San1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addGap(48, 48, 48)
                .addComponent(lbLoaiSanS1C2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        Pane3San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane3San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane3San1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ca 3");

        lbLoaiSanS1C3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C3.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C3.setText("Loại sân");

        lbTrangThaiS1C3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C3.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C3.setText("Trạng thái");

        javax.swing.GroupLayout Pane3San1Layout = new javax.swing.GroupLayout(Pane3San1);
        Pane3San1.setLayout(Pane3San1Layout);
        Pane3San1Layout.setHorizontalGroup(
            Pane3San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane3San1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(Pane3San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane3San1Layout.createSequentialGroup()
                        .addComponent(lbTrangThaiS1C3)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane3San1Layout.createSequentialGroup()
                        .addGroup(Pane3San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbLoaiSanS1C3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );
        Pane3San1Layout.setVerticalGroup(
            Pane3San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane3San1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addComponent(lbLoaiSanS1C3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        Pane4San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane4San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane4San1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ca 4");

        lbLoaiSanS1C4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C4.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C4.setText("Loại sân");

        lbTrangThaiS1C4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C4.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C4.setText("Trạng thái");

        javax.swing.GroupLayout Pane4San1Layout = new javax.swing.GroupLayout(Pane4San1);
        Pane4San1.setLayout(Pane4San1Layout);
        Pane4San1Layout.setHorizontalGroup(
            Pane4San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane4San1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane4San1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pane4San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTrangThaiS1C4)
                    .addComponent(lbLoaiSanS1C4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        Pane4San1Layout.setVerticalGroup(
            Pane4San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane4San1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(45, 45, 45)
                .addComponent(lbLoaiSanS1C4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        Pane5San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane5San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane5San1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ca 5");

        lbLoaiSanS1C5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C5.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C5.setText("Loại sân");

        lbTrangThaiS1C5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C5.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C5.setText("Trạng thái");

        javax.swing.GroupLayout Pane5San1Layout = new javax.swing.GroupLayout(Pane5San1);
        Pane5San1.setLayout(Pane5San1Layout);
        Pane5San1Layout.setHorizontalGroup(
            Pane5San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane5San1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(Pane5San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane5San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbTrangThaiS1C5)
                        .addGroup(Pane5San1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane5San1Layout.createSequentialGroup()
                        .addComponent(lbLoaiSanS1C5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        Pane5San1Layout.setVerticalGroup(
            Pane5San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane5San1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addGap(44, 44, 44)
                .addComponent(lbLoaiSanS1C5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        Pane6San1.setBackground(new java.awt.Color(0, 153, 0));
        Pane6San1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane6San1.setForeground(new java.awt.Color(0, 153, 0));
        Pane6San1.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ca 6");

        lbLoaiSanS1C6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS1C6.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS1C6.setText("Loại sân");

        lbTrangThaiS1C6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS1C6.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS1C6.setText("Trạng thái");

        javax.swing.GroupLayout Pane6San1Layout = new javax.swing.GroupLayout(Pane6San1);
        Pane6San1.setLayout(Pane6San1Layout);
        Pane6San1Layout.setHorizontalGroup(
            Pane6San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane6San1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(Pane6San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane6San1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane6San1Layout.createSequentialGroup()
                        .addComponent(lbLoaiSanS1C6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(Pane6San1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbTrangThaiS1C6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Pane6San1Layout.setVerticalGroup(
            Pane6San1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane6San1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(39, 39, 39)
                .addComponent(lbLoaiSanS1C6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS1C6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        lbTenSan1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenSan1.setText("Sân 1");

        javax.swing.GroupLayout panSan1Layout = new javax.swing.GroupLayout(panSan1);
        panSan1.setLayout(panSan1Layout);
        panSan1Layout.setHorizontalGroup(
            panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSan1Layout.createSequentialGroup()
                .addGroup(panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSan1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Pane1San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Pane2San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Pane3San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Pane4San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Pane5San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Pane6San1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panSan1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTenSan1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panSan1Layout.setVerticalGroup(
            panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSan1Layout.createSequentialGroup()
                .addComponent(lbTenSan1)
                .addGap(9, 9, 9)
                .addGroup(panSan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pane3San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane1San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane2San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane4San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane5San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane6San1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panSan2.setBackground(new java.awt.Color(186, 228, 229));
        panSan2.setForeground(new java.awt.Color(186, 228, 229));

        Pane1San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane1San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane1San2.setForeground(new java.awt.Color(0, 153, 0));
        Pane1San2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pane1San2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Pane1San2MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ca 1");

        lbLoaiSanS2C1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C1.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C1.setText("Loại sân");

        lbTrangThaiS2C1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C1.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C1.setText("Trạng thái");

        javax.swing.GroupLayout Pane1San2Layout = new javax.swing.GroupLayout(Pane1San2);
        Pane1San2.setLayout(Pane1San2Layout);
        Pane1San2Layout.setHorizontalGroup(
            Pane1San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane1San2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane1San2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pane1San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTrangThaiS2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLoaiSanS2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        Pane1San2Layout.setVerticalGroup(
            Pane1San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane1San2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLoaiSanS2C1)
                .addGap(54, 54, 54)
                .addComponent(lbTrangThaiS2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        Pane2San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane2San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane2San2.setForeground(new java.awt.Color(0, 153, 0));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ca 2");

        lbLoaiSanS2C2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C2.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C2.setText("Loại sân");

        lbTrangThaiS2C2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C2.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C2.setText("Trạng thái");

        javax.swing.GroupLayout Pane2San2Layout = new javax.swing.GroupLayout(Pane2San2);
        Pane2San2.setLayout(Pane2San2Layout);
        Pane2San2Layout.setHorizontalGroup(
            Pane2San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2San2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(Pane2San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2San2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane2San2Layout.createSequentialGroup()
                        .addGroup(Pane2San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTrangThaiS2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLoaiSanS2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );
        Pane2San2Layout.setVerticalGroup(
            Pane2San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane2San2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addGap(53, 53, 53)
                .addComponent(lbLoaiSanS2C2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        Pane3San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane3San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane3San2.setForeground(new java.awt.Color(0, 153, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ca 3");

        lbLoaiSanS2C3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C3.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C3.setText("Loại sân");

        lbTrangThaiS2C3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C3.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C3.setText("Trạng thái");

        javax.swing.GroupLayout Pane3San2Layout = new javax.swing.GroupLayout(Pane3San2);
        Pane3San2.setLayout(Pane3San2Layout);
        Pane3San2Layout.setHorizontalGroup(
            Pane3San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane3San2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(Pane3San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane3San2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane3San2Layout.createSequentialGroup()
                        .addGroup(Pane3San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTrangThaiS2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLoaiSanS2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        Pane3San2Layout.setVerticalGroup(
            Pane3San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane3San2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addComponent(lbLoaiSanS2C3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        Pane4San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane4San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane4San2.setForeground(new java.awt.Color(0, 153, 0));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ca 4");

        lbLoaiSanS2C4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C4.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C4.setText("Loại sân");

        lbTrangThaiS2C4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C4.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C4.setText("Trạng thái");

        javax.swing.GroupLayout Pane4San2Layout = new javax.swing.GroupLayout(Pane4San2);
        Pane4San2.setLayout(Pane4San2Layout);
        Pane4San2Layout.setHorizontalGroup(
            Pane4San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane4San2Layout.createSequentialGroup()
                .addGroup(Pane4San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbLoaiSanS2C4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pane4San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Pane4San2Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Pane4San2Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(lbTrangThaiS2C4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        Pane4San2Layout.setVerticalGroup(
            Pane4San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane4San2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel13)
                .addGap(46, 46, 46)
                .addComponent(lbLoaiSanS2C4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS2C4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        Pane5San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane5San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane5San2.setForeground(new java.awt.Color(0, 153, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ca 5");

        lbLoaiSanS2C5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C5.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C5.setText("Loại sân");

        lbTrangThaiS2C5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C5.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C5.setText("Trạng thái");

        javax.swing.GroupLayout Pane5San2Layout = new javax.swing.GroupLayout(Pane5San2);
        Pane5San2.setLayout(Pane5San2Layout);
        Pane5San2Layout.setHorizontalGroup(
            Pane5San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane5San2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(Pane5San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane5San2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane5San2Layout.createSequentialGroup()
                        .addGroup(Pane5San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTrangThaiS2C5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLoaiSanS2C5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        Pane5San2Layout.setVerticalGroup(
            Pane5San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane5San2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel15)
                .addGap(40, 40, 40)
                .addComponent(lbLoaiSanS2C5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangThaiS2C5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        Pane6San2.setBackground(new java.awt.Color(0, 153, 0));
        Pane6San2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pane6San2.setForeground(new java.awt.Color(0, 153, 0));
        Pane6San2.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ca 6");

        lbLoaiSanS2C6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLoaiSanS2C6.setForeground(new java.awt.Color(255, 255, 255));
        lbLoaiSanS2C6.setText("Loại sân");

        lbTrangThaiS2C6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTrangThaiS2C6.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThaiS2C6.setText("Trạng thái");

        javax.swing.GroupLayout Pane6San2Layout = new javax.swing.GroupLayout(Pane6San2);
        Pane6San2.setLayout(Pane6San2Layout);
        Pane6San2Layout.setHorizontalGroup(
            Pane6San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pane6San2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(Pane6San2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(Pane6San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTrangThaiS2C6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLoaiSanS2C6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pane6San2Layout.setVerticalGroup(
            Pane6San2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pane6San2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel16)
                .addGap(39, 39, 39)
                .addComponent(lbLoaiSanS2C6)
                .addGap(57, 57, 57)
                .addComponent(lbTrangThaiS2C6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbTenSan2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenSan2.setText("Sân 2");

        javax.swing.GroupLayout panSan2Layout = new javax.swing.GroupLayout(panSan2);
        panSan2.setLayout(panSan2Layout);
        panSan2Layout.setHorizontalGroup(
            panSan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSan2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTenSan2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1057, Short.MAX_VALUE))
            .addGroup(panSan2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pane1San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Pane2San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Pane3San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Pane4San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Pane5San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Pane6San2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        panSan2Layout.setVerticalGroup(
            panSan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSan2Layout.createSequentialGroup()
                .addComponent(lbTenSan2)
                .addGap(9, 9, 9)
                .addGroup(panSan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pane3San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane1San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane2San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane4San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane5San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pane6San2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panSan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panSan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );

        paneTong.setViewportView(jPanel8);

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Đang trống");

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Chờ nhận sân");

        jLabel18.setBackground(new java.awt.Color(255, 0, 51));
        jLabel18.setForeground(new java.awt.Color(0, 153, 0));
        jLabel18.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Không trống");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(123, 123, 123)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(paneTong, javax.swing.GroupLayout.PREFERRED_SIZE, 1323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 35, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneTong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 817, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void lbLienHeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLienHeMouseExited
        lbLienHe.setBackground(new Color(166, 145, 92));
    }//GEN-LAST:event_lbLienHeMouseExited

    private void lbLienHeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLienHeMouseEntered
        lbLienHe.setBackground(new Color(13, 180, 185));
    }//GEN-LAST:event_lbLienHeMouseEntered

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

    private void Pane1San2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pane1San2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pane1San2MousePressed

    private void Pane1San1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pane1San1MousePressed

    }//GEN-LAST:event_Pane1San1MousePressed

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
    private javax.swing.JPanel Pane1San1;
    private javax.swing.JPanel Pane1San2;
    private javax.swing.JPanel Pane2San1;
    private javax.swing.JPanel Pane2San2;
    private javax.swing.JPanel Pane3San1;
    private javax.swing.JPanel Pane3San2;
    private javax.swing.JPanel Pane4San1;
    private javax.swing.JPanel Pane4San2;
    private javax.swing.JPanel Pane5San1;
    private javax.swing.JPanel Pane5San2;
    private javax.swing.JPanel Pane6San1;
    private javax.swing.JPanel Pane6San2;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private static javax.swing.JLabel lbCheckIn;
    private static javax.swing.JLabel lbDangXuat;
    private javax.swing.JLabel lbDichVu;
    private static javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbHome;
    private static javax.swing.JLabel lbLichDat;
    private javax.swing.JLabel lbLienHe;
    private javax.swing.JLabel lbLoaiSanS1C1;
    private javax.swing.JLabel lbLoaiSanS1C2;
    private javax.swing.JLabel lbLoaiSanS1C3;
    private javax.swing.JLabel lbLoaiSanS1C4;
    private javax.swing.JLabel lbLoaiSanS1C5;
    private javax.swing.JLabel lbLoaiSanS1C6;
    private javax.swing.JLabel lbLoaiSanS2C1;
    private javax.swing.JLabel lbLoaiSanS2C2;
    private javax.swing.JLabel lbLoaiSanS2C3;
    private javax.swing.JLabel lbLoaiSanS2C4;
    private javax.swing.JLabel lbLoaiSanS2C5;
    private javax.swing.JLabel lbLoaiSanS2C6;
    private static javax.swing.JLabel lbQLCa;
    private static javax.swing.JLabel lbQLSan;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbTenSan1;
    private javax.swing.JLabel lbTenSan2;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTrangThaiS1C1;
    private javax.swing.JLabel lbTrangThaiS1C2;
    private javax.swing.JLabel lbTrangThaiS1C3;
    private javax.swing.JLabel lbTrangThaiS1C4;
    private javax.swing.JLabel lbTrangThaiS1C5;
    private javax.swing.JLabel lbTrangThaiS1C6;
    private javax.swing.JLabel lbTrangThaiS2C1;
    private javax.swing.JLabel lbTrangThaiS2C2;
    private javax.swing.JLabel lbTrangThaiS2C3;
    private javax.swing.JLabel lbTrangThaiS2C4;
    private javax.swing.JLabel lbTrangThaiS2C5;
    private javax.swing.JLabel lbTrangThaiS2C6;
    private javax.swing.JPanel panSan1;
    private javax.swing.JPanel panSan2;
    private javax.swing.JScrollPane paneTong;
    private utill.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
