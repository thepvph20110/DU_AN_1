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
import java.text.DecimalFormat;
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
import modelview.QLCa;
import modelview.QLSanBong;
import modelview.QLSanCa;
import repository.ICaRepository;
import repository.ISanBongRepository;
import repository.impl.CaRepository;
import repository.impl.SanBongRepository;
import service.ICaService;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
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
    private ICaService caService = new CaServiceImpl();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
    private Date ngayTao;
    private DecimalFormat df = new DecimalFormat("###,###,###");

    public FrmDoiLichDat(PhieuDatLich phieuDatLich, QLAcount qLAcount, JPanel pnTong, JLabel lbHome, Date ngayTao) {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.ngayTao = ngayTao;
        this.phieuDatLich = phieuDatLich;
        this.qLAcount = qLAcount;
        this.pnTong = pnTong;
        this.lbHome = lbHome;
        listSanCa = sanCaService.getAll(ngayTao);
        listSanBong = sanBongService.getAll();
        AddSan();
        txttenKH.setText(phieuDatLich.getKhachHang().getTenKhachHang());
        txtNgayDenSan.setEnabled(false);
        txttenKH.setEnabled(false);
        txtTenSan.setEnabled(false);
        txtTGCa.setEnabled(false);
        txtGiaSan.setEnabled(false);
        txtGiaSan.setText(df.format(phieuDatLich.getSanCa().getGiaSanCa()) + " VND");
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
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getTenCa(), ca);
        }

        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String stringDate = sdf.format(txtDate.getDate());
                try {
                    createSanCaFollowDate(sdf.parse(stringDate));
                    mapSanCa.clear();
                    panelTong.removeAll();
                    listSanCa = sanCaService.getAll(txtDate.getDate());
                    for (QLSanCa qLSanCa : listSanCa) {
                        mapSanCa.put(qLSanCa.getId(), qLSanCa);
                    }
                    List<Ca> listQLCa = caRepository.getAll();
                    List<SanBong> listSanBong = sanBongRepository.getAll();
                    AddSan();
                    panelTong.validate();
                    panelTong.repaint();
                    for (SanBong sanBong : listSanBong) {
                        map.put(sanBong.getTenSanBong(), sanBong);
                    }
                    for (Ca ca : listQLCa) {
                        map.put(ca.getTenCa(), ca);
                    }
                } catch (Exception e) {
                }
            }
        });

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
                Time gioKT = new Time(listSanCa.get(j).getThoiGianKetThuc().getHours(), listSanCa.get(j).getThoiGianKetThuc().getMinutes(), listSanCa.get(j).getThoiGianKetThuc().getSeconds());
                Time quaGio = new Time(now.getHours(), now.getMinutes(), now.getSeconds());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date homNay = new Date();
                Date ngayTao = listSanCa.get(j).getNgayTao();
                String ngayTaoSan = dateFormat.format(ngayTao);
                String hienTai = dateFormat.format(homNay);
                if (listSanBong.get(i).getTenSanBong().equals(listSanCa.get(j).getTenSanBong())&&
                        !(gioKT.getTime() < quaGio.getTime() && ngayTaoSan.equals(hienTai))) {

                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.DANG_TRONG) {

                        JPanel panelCa = new JPanel();

                        panelCa.setLayout(new FlowLayout());
                        panelCa.setPreferredSize(new Dimension(90, 90));
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                        panelCa.setLayout(new FlowLayout(10, 20, 20));
                        panelCa.setBackground(new Color(0, 204, 51));
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
                        JLabel labelNgay = new JLabel(sdf.format(listSanCa.get(j).getNgayTao()));
                        JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " - " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        labelCa.setForeground(Color.white);
                        labelCa.setFont(new Font("Tahoma", 1, 9));
                        labelNgay.setForeground(Color.white);
                        labelNgay.setFont(new Font("Tahoma", 1, 9));
                        labelThoiGian.setForeground(Color.white);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 8));
                        labelLoaiSan.setForeground(Color.white);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 8));
                        JLabel labelGiaSan = new JLabel("Giá: " + df.format(listSanCa.get(j).getGiaCaSan()) + " VND");
                        labelGiaSan.setFont(new Font("Tahoma", 1, 8));
                        labelGiaSan.setForeground(Color.white);

                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
                        panelCa.add(labelNgay);
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
        txtGiaSan.setText(df.format(qLSanCa.getGiaCaSan()) + " VND");
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
        txtGiaSan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelTong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtDate = new com.toedter.calendar.JDateChooser();
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

        txtNgayDenSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayDenSanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tên Sân Bóng");

        txtTenSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSanActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Thông Tin Phiếu Đặt");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        txtGiaSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaSanActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Giá Sân ");

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
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayDenSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTGCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTGCa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addComponent(txtNgayDenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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

        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnDoiLich)
                        .addGap(217, 217, 217)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
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
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDoiLich, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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
                phieuDatLich.setNgayDenSan(sanCa.getNgayTao());
                phieuDatLich.setTongTienSan(sanCa.getGiaSanCa());
                if (phieuDatLichService.updateTrangThai(phieuDatLich).equalsIgnoreCase("Sửa Trạng Thái Thành Công")) {
                    ByteArrayOutputStream byteArrayOutputStream = new QRCode().getQRCodeImage(phieuDatLich.getMaQR(), 200, 200);
                    String mess = new JavaMail().sendMail(phieuDatLich, byteArrayOutputStream);
                    JOptionPane.showMessageDialog(this, mess);
                    qLSanCa.setTrangThai(trangThaiSanCa.CHO_NHAN_SAN);
                    sanCaService.update(qLSanCa);
                    sanCaService.update(sanCaCu);
                    this.dispose();
                    HomeController homeController = new HomeController(pnTong, qLAcount, ngayTao,null);
                    homeController.setView(lbHome);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn sân muốn đổi");
            }
        }
    }//GEN-LAST:event_btnDoiLichActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDatePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDatePropertyChange

    private void txtNgayDenSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayDenSanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayDenSanActionPerformed

    private void txtTenSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSanActionPerformed

    private void txtGiaSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaSanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaSanActionPerformed

    private void createSanCaFollowDate(Date ngayTao) {
        if (sanCaService.getByNgayTao(ngayTao).size() <= 0) {

            List<QLSanBong> listQlSanBong = sanBongService.getAll();
            List<QLCa> listCa = caService.getAll();
            List<QLSanCa> listSanCa = new ArrayList<>();
            for (int i = 0; i < listSanBong.size(); i++) {
                QLSanBong qLSanBong = listSanBong.get(i);
                for (int j = 0; j < listCa.size(); j++) {
                    QLCa qLCa = listCa.get(j);
                    QLSanCa qLSanCa = new QLSanCa(null, qLCa.getId(), qLSanBong.getId(), qLSanBong.getSucChua(), qLCa.getThoiGianBatDau(), qLCa.getThoiGianKetThuc(), ngayTao, qLSanBong.getGiaSan() + qLCa.getGiaCa(), trangThaiSanCa.DANG_TRONG);
                    listSanCa.add(qLSanCa);
                }
            }
            if (listSanCa.size() > 0) {
                sanCaService.addListSanCa(listSanCa);
            }
        }
    }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtGiaSan;
    private javax.swing.JTextField txtNgayDenSan;
    private javax.swing.JTextField txtTGCa;
    private javax.swing.JTextField txtTenSan;
    private javax.swing.JTextField txttenKH;
    // End of variables declaration//GEN-END:variables
}
