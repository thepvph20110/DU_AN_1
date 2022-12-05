/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.HomeController;
import domainmodel.Ca;
import domainmodel.PhieuDatLich;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiSanCa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import modelview.QLSanBong;
import modelview.QLSanCa;
import repository.ICaRepository;
import repository.ISanBongRepository;
import repository.impl.CaRepository;
import repository.impl.SanBongRepository;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;
import utill.JavaMail;
import utill.QRCode;

/**
 *
 * @author ADMIN
 */
public class FrmDoiLichDat extends javax.swing.JFrame {

    private PhieuDatLich phieuDatLich = new PhieuDatLich();
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private List<QLSanCa> listSanCa = new ArrayList<>();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    public List<JPanel> listPaneCa = new ArrayList<>();
    private Map<String, QLSanCa> mapSanCa = new HashMap<>();
    private QLSanCa qLSanCa = new QLSanCa();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Map<String, Object> map = new HashMap<>();
    private ISanBongRepository sanBongRepository = new SanBongRepository();
    private ICaRepository caRepository = new CaRepository();
    private QLAcount qLAcount;
    private JPanel pnTong;
    private JLabel lbHome;

    public FrmDoiLichDat(PhieuDatLich phieuDatLich, QLAcount qLAcount, JPanel pnTong, JLabel lbHome) {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.phieuDatLich = phieuDatLich;
        this.qLAcount = qLAcount;
        this.pnTong = pnTong;
        this.lbHome = lbHome;
        listSanCa = sanCaService.getAll(new Date());
        listSanBong = sanBongService.getAll();
        AddSan();
        txttenKH.setText(phieuDatLich.getKhachHang().getTenKhachHang());
        txtNgayDenSan.setEnabled(false);
        txttenKH.setEnabled(false);
        txtTenSan.setEnabled(false);
        txtTGCa.setEnabled(false);
        txtTenSan.setText(phieuDatLich.getSanCa().getSanbong().getTenSanBong());
        txtNgayDenSan.setText(sdf.format(phieuDatLich.getNgayDenSan()));
        txtTGCa.setText(phieuDatLich.getSanCa().getCa().getThoiGianBatDau() + "-" + phieuDatLich.getSanCa().getCa().getThoiGianKetThuc());
        String stringDate = sdf.format(new Date());
        try {
            Date nowDate = sdf.parse(stringDate);
            txtDate.setDate(nowDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (QLSanCa qLSanCa : listSanCa) {
            mapSanCa.put(qLSanCa.getId(), qLSanCa);
        }
        List<Ca> listQLCa = caRepository.getAll();
        List<SanBong> listSanBong = sanBongRepository.getAll();
        for (SanBong sanBong : listSanBong) {
            map.put(sanBong.getTenSanBong(), sanBong);
            map.put(sanBong.getMaSanBong(), sanBong);
            map.put(String.valueOf(sanBong.getGiaSan()), sanBong);
            map.put(String.valueOf(sanBong.getSucChua()), sanBong);
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getMaCa(), ca);
            map.put(ca.getTenCa(), ca);
            map.put(String.valueOf(ca.getGiaCa()), ca);
            map.put(String.valueOf(ca.getThoiGianBatDau()), ca);
            map.put(String.valueOf(ca.getThoiGianKetThuc()), ca);
        }

    }

    public void AddSan() {
        panelTong.setLayout(new GridLayout(10000, 1, 20, 20));
        Date now = new Date();
        for (int i = 0; i < listSanBong.size(); i++) {
            TitledBorder border = new TitledBorder(listSanBong.get(i).getTenSanBong());
            JPanel panelSan = new JPanel();
            panelSan.setBorder(border);
            panelSan.setPreferredSize(new Dimension(1000, 150));
            panelSan.setLayout(new GridLayout(1, 100, 20, 20));
            for (int j = 0; j < listSanCa.size(); j++) {
                if (listSanBong.get(i).getTenSanBong().equals(listSanCa.get(j).getTenSanBong())) {
                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.DANG_TRONG) {
                        JPopupMenu jPopupMenu = new JPopupMenu();
                        JMenuItem itemDatLich = new JMenuItem("Đặt Lịch");
                        JMenuItem itemCheckOut = new JMenuItem("Chi tiết sân đặt");
                        JMenuItem itemDoiLichDat = new JMenuItem("Đổi lịch đặt");
                        jPopupMenu.add(itemDatLich);
                        jPopupMenu.add(itemCheckOut);
                        jPopupMenu.add(itemDoiLichDat);
                        JPanel panelCa = new JPanel();

                        panelCa.setLayout(new FlowLayout());
                        panelCa.setPreferredSize(new Dimension(90, 90));
                        panelCa.setComponentPopupMenu(jPopupMenu);
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                        panelCa.setLayout(new FlowLayout(10, 20, 20));
                        panelCa.setBackground(new Color(0, 204, 51));
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                        JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " - " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        labelCa.setForeground(Color.white);
                        labelCa.setFont(new Font("Tahoma", 1, 10));
                        labelThoiGian.setForeground(Color.white);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 8));
                        labelLoaiSan.setForeground(Color.white);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 8));
                        JLabel labelGiaSan = new JLabel("Giá: " + String.valueOf(listSanCa.get(j).getGiaCaSan()));
                        labelGiaSan.setFont(new Font("Tahoma", 1, 9));
                        labelGiaSan.setForeground(Color.white);
                        Time gioKT = new Time(listSanCa.get(j).getThoiGianKetThuc().getHours(), listSanCa.get(j).getThoiGianKetThuc().getMinutes(), listSanCa.get(j).getThoiGianKetThuc().getSeconds());
                        Time quaGio = new Time(now.getHours(), now.getMinutes(), now.getSeconds());
                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
                        panelCa.add(labelLoaiSan);
                        panelCa.add(labelGiaSan);
                        panelCa.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                for (JPanel jPanel : listPaneCa) {
                                    jPanel.setBackground(new Color(0, 204, 51));
                                }
                                panelCa.setBackground(new Color(51, 51, 255));
                                addQlSanCa(labelIdSanCa.getText());
                            }
                        });
                        listPaneCa.add(panelCa);
                        panelSan.add(panelCa);
                    }
                }
            }
            panelTong.add(panelSan);
        }
    }

    private void addQlSanCa(String idSanCa) {
        this.qLSanCa = mapSanCa.get(idSanCa);
        txtTenSan.setText(qLSanCa.getTenSanBong());
        txtNgayDenSan.setText(sdf.format(qLSanCa.getNgayTao()));
        txtTGCa.setText(qLSanCa.getThoiGianBatDau() + "-" + qLSanCa.getThoiGianKetThuc());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txttenKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTGCa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayDenSan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenSan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelTong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        btnDoiLich = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tên Khách Hàng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Thời Gian Ca");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ngày Đến Sân");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tên Sân Bóng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Thông Tin Phiếu Đặt");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayDenSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTGCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTGCa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(75, 75, 75)
                                .addComponent(txtNgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(59, 59, 59)
                        .addComponent(txtTenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(80, 80, 80))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn sân bóng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelTong);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 204, 51));
        jLabel2.setOpaque(true);

        jLabel3.setText("sân đã chọn");

        jLabel4.setText("Sân trống");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn ngày đặt sân"));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Tìm sân theo ngày");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnDoiLich.setBackground(new java.awt.Color(51, 102, 255));
        btnDoiLich.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDoiLich.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiLich.setText("Đổi lịch đặt");
        btnDoiLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiLichActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnDoiLich)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDoiLich, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiLichActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận đổi lịch đặt", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (check == 0) {
            if (!(qLSanCa == null)) {
                Ca ca = new Ca();
                if (map.containsKey(qLSanCa.getTenCa())) {
                    ca = (Ca) map.get(qLSanCa.getTenCa());
                }
                SanBong sanBong = new SanBong();
                if (map.containsKey(qLSanCa.getTenSanBong())) {
                    sanBong = (SanBong) map.get(qLSanCa.getTenSanBong());
                }
                SanCa sanCa = new SanCa(qLSanCa.getId(), ca, sanBong, qLSanCa.getNgayTao(), qLSanCa.getGiaCaSan(), qLSanCa.getTrangThai());
                QLSanCa sanCaCu = new QLSanCa(phieuDatLich.getSanCa().getId(), phieuDatLich.getSanCa().getCa().getTenCa(), phieuDatLich.getSanCa().getSanbong().getTenSanBong(),
                        phieuDatLich.getSanCa().getSanbong().getSucChua(), phieuDatLich.getSanCa().getCa().getThoiGianBatDau(), phieuDatLich.getSanCa().getCa().getThoiGianKetThuc(),
                        phieuDatLich.getSanCa().getNgayTao(), phieuDatLich.getSanCa().getGiaSanCa(), phieuDatLich.getSanCa().getTrangThai());
                sanCaCu.setTrangThai(trangThaiSanCa.DANG_TRONG);
                phieuDatLich.setSanCa(sanCa);
                if (phieuDatLichService.updateTrangThai(phieuDatLich).equalsIgnoreCase("Sửa Trạng Thái Thành Công")) {
                    ByteArrayOutputStream byteArrayOutputStream = new QRCode().getQRCodeImage(phieuDatLich.getMaQR(), 200, 200);
                    String mess = new JavaMail().sendMail(phieuDatLich, byteArrayOutputStream);
                    JOptionPane.showMessageDialog(panelTong, mess);
                    qLSanCa.setTrangThai(trangThaiSanCa.CHO_NHAN_SAN);
                    sanCaService.update(qLSanCa);
                    sanCaService.update(sanCaCu);
                    this.dispose();
                    HomeController homeController = new HomeController(pnTong, qLAcount, new Date());
                    homeController.setView(lbHome);
                }
            } else {
                JOptionPane.showMessageDialog(panelTong, "Chọn sân muốn đổi");
            }
        }
    }//GEN-LAST:event_btnDoiLichActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmDoiLichDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmDoiLichDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmDoiLichDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmDoiLichDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmDoiLichDat().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiLich;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelTong;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtNgayDenSan;
    private javax.swing.JTextField txtTGCa;
    private javax.swing.JTextField txtTenSan;
    private javax.swing.JTextField txttenKH;
    // End of variables declaration//GEN-END:variables
}
