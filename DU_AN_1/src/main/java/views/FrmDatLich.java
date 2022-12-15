/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import datechooser.model.multiple.PeriodSet;
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
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import modelview.QLAcount;
import modelview.QLCa;
import modelview.QLSanBong;
import modelview.QLSanCa;
import service.ICaService;
import service.IPhieuDatLichService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
import service.Impl.PhieuDatLichServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author ADMIN
 */
public class FrmDatLich extends javax.swing.JFrame {

    private QLAcount qLAcount = new QLAcount();
    private DefaultTableModel tableModel;
    private List<Calendar> listCalendars = new ArrayList<>();
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private JLabel labelHome;
    private JPanel panelTong;
    private DecimalFormat df = new DecimalFormat("###,###,###");
    private QLSanCa qLSanCa = new QLSanCa();
    private int indexRow = 0;
    private PhieuDatLich phieuDatLich = new PhieuDatLich();
    private List<QLSanCa> listSanCa = new ArrayList<>();
    private List<QLSanBong> listSanBong = new ArrayList<>();
    private ISanCaService sanCaService = new SanCaServiceImpl();
    private ISanBongService sanBongService = new SanBongServiceImpl();
    public List<JPanel> listPaneCa = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Map<String, QLSanCa> mapSanCa = new HashMap<>();
    private ICaService caService = new CaServiceImpl();

    /**
     * Creates new form FrmDatLich
     */
    public FrmDatLich() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.qLAcount = qLAcount;
        this.qLSanCa = qLSanCa;
        this.labelHome = labelHome;
        this.panelTong = panelTong;
        tableModel = (DefaultTableModel) jTable1.getModel();
        txtNV.setEditable(false);
        txtNV.setText(qLAcount.getTenAcount());
        txtKhachHang.setEditable(false);
        txtGiaSanBong.setEditable(false);
        txtTenSanBong.setEditable(false);
        txtCa.setEditable(false);
        listSanCa = sanCaService.getAll(new Date());
        listSanBong = sanBongService.getAll();
        AddSan();
        for (QLSanCa qLSanCa : listSanCa) {
            mapSanCa.put(qLSanCa.getId(), qLSanCa);
        }
        txtDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                Calendar calendar = txtDate.getSelectedDate();
                try {
                    if (format.parse(format.format(calendar.getTime())).before(format.parse(format.format(new Date())))) {
                        JOptionPane.showMessageDialog(null, "Chọn ngày sau ngày hiện tại");
                    } else {
                        listCalendars.clear();
                        PeriodSet periodSet = txtDate.getSelectedPeriodSet();
                        periodSet.getDates().forEach(a -> {
                            listCalendars.add(a);

                        });
                        for (Calendar listCalendar : listCalendars) {
                            if (format.parse(format.format(listCalendar.getTime())).before(format.parse(format.format(new Date())))) {
                                listCalendars.remove(listCalendar);
                            }
                        }
                        showDate(listCalendars);
                        String time = "";
                        for (int i= 0; i> listCalendars.size();i++) {
                            try {
                                String stringDate = sdf.format(listCalendars.get(i).getTime());
                                System.out.println("AAAAAAAAAA: "+stringDate);
                                if (i == 0) {
                                    time = time + "where sc.ngayTao = :" + stringDate;
                                }else{
                                     time = time + " and sc.ngayTao = :" + stringDate;
                                }
                                createSanCaFollowDate(format.parse(stringDate));
                            } catch (Exception e) {
                            }
                        }
                        getAllByTime(time);
                        mapSanCa.clear();
                        pnTong.removeAll();
                        for (QLSanCa qLSanCa : listSanCa) {
                            mapSanCa.put(qLSanCa.getId(), qLSanCa);
                        }
//                    List<Ca> listQLCa = caRepository.getAll();
//                    List<SanBong> listSanBong = sanBongRepository.getAll();
                        AddSan();
                        pnTong.validate();
                        pnTong.repaint();
//                    for (SanBong sanBong : listSanBong) {
//                        map.put(sanBong.getTenSanBong(), sanBong);
//                    }
//                    for (Ca ca : listQLCa) {
//                        map.put(ca.getTenCa(), ca);
//                    }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        itemXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCalendars.remove(indexRow);
                showDate(listCalendars);
                popupMenu.setVisible(false);
            }
        });
    }

    private void getAllByTime(String time) {
        listSanCa.clear();
        listSanCa = sanCaService.getAllByNgayTao(time);
    }

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

    private Object[] billDate(Calendar calendar) {
        return new Object[]{calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)};
    }

    private void showDate(List<Calendar> list) {
        tableModel.setNumRows(0);
        for (Calendar calendar : list) {
            tableModel.addRow(billDate(calendar));
        }
    }

    public void AddSan() {
        pnTong.setLayout(new GridLayout(10000, 1, 20, 20));
        Date now = new Date();
        for (int i = 0; i < listSanBong.size(); i++) {
            int sizeSanCa = 150;
            TitledBorder border = new TitledBorder(listSanBong.get(i).getTenSanBong());
            JPanel panelSan = new JPanel();
            panelSan.setBorder(border);
            panelSan.setPreferredSize(new Dimension(sizeSanCa, 150));
            panelSan.setLayout(new GridLayout(1, 100, 20, 20));

            for (int j = 0; j < listSanCa.size(); j++) {
                Time gioKT = new Time(listSanCa.get(j).getThoiGianKetThuc().getHours(), listSanCa.get(j).getThoiGianKetThuc().getMinutes(), listSanCa.get(j).getThoiGianKetThuc().getSeconds());
                Time quaGio = new Time(now.getHours(), now.getMinutes(), now.getSeconds());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date homNay = new Date();
                Date ngayTao = listSanCa.get(j).getNgayTao();
                String ngayTaoSan = dateFormat.format(ngayTao);
                String hienTai = dateFormat.format(homNay);
                if (listSanBong.get(i).getTenSanBong().equals(listSanCa.get(j).getTenSanBong())
                        && !(gioKT.getTime() < quaGio.getTime() && ngayTaoSan.equals(hienTai))) {

                    if (listSanCa.get(j).getTrangThai() == trangThaiSanCa.DANG_TRONG) {
                        sizeSanCa = sizeSanCa + 150;
                        JPanel panelCa = new JPanel();

                        panelCa.setLayout(new FlowLayout());
                        panelCa.setPreferredSize(new Dimension(90, 90));
                        panelCa.setLayout(new BoxLayout(panelCa, BoxLayout.Y_AXIS));
                        panelCa.setLayout(new FlowLayout(10, 20, 20));
                        panelCa.setBackground(new Color(0, 204, 51));
                        JLabel labelIdSanCa = new JLabel(listSanCa.get(j).getId());
                        JLabel labelCa = new JLabel(listSanCa.get(j).getTenCa());
//                        JLabel labelNgay = new JLabel(sdf.format(listSanCa.get(j).getNgayTao()));
                        JLabel labelThoiGian = new JLabel(listSanCa.get(j).getThoiGianBatDau() + " - " + String.valueOf(listSanCa.get(j).getThoiGianKetThuc()));
                        JLabel labelLoaiSan = new JLabel("Loại sân" + " " + listSanCa.get(j).getSucChua());
                        labelCa.setForeground(Color.black);
                        labelCa.setFont(new Font("Tahoma", 1, 10));
//                        labelNgay.setForeground(Color.black);
//                        labelNgay.setFont(new Font("Tahoma", 1, 10));
                        labelThoiGian.setForeground(Color.black);
                        labelThoiGian.setFont(new Font("Tahoma", 1, 9));
                        labelLoaiSan.setForeground(Color.black);
                        labelLoaiSan.setFont(new Font("Tahoma", 1, 9));
                        JLabel labelGiaSan = new JLabel("Giá: " + df.format(listSanCa.get(j).getGiaCaSan()) + " VND");
                        labelGiaSan.setFont(new Font("Tahoma", 1, 9));
                        labelGiaSan.setForeground(Color.black);

                        panelCa.add(labelCa);
                        panelCa.add(labelThoiGian);
//                        panelCa.add(labelNgay);
                        panelCa.add(labelLoaiSan);
                        panelCa.add(labelGiaSan);
                        panelCa.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                for (JPanel jPanel : listPaneCa) {
                                    jPanel.setBackground(new Color(0, 204, 51));
                                }
                                panelCa.setBackground(new Color(255, 255, 153));
                                addQlSanCa(labelIdSanCa.getText());
                            }
                        });
                        listPaneCa.add(panelCa);
                        panelSan.add(panelCa);
                    }
                }
            }
            pnTong.add(panelSan);
        }
    }

    private void addQlSanCa(String idSanCa) {
        this.qLSanCa = mapSanCa.get(idSanCa);
        txtTenSanBong.setText(qLSanCa.getTenSanBong());
        txtGiaSanBong.setText(df.format(qLSanCa.getGiaCaSan()) + " VND");
        txtCa.setText(qLSanCa.getThoiGianBatDau() + "-" + qLSanCa.getThoiGianKetThuc());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        itemXoa = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        txtDate = new datechooser.beans.DateChooserPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtKhachHang = new javax.swing.JTextField();
        btnAddKH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNV = new javax.swing.JTextField();
        btnThoai = new javax.swing.JButton();
        btnDatLich = new javax.swing.JButton();
        tdtd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnTong = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenSanBong = new javax.swing.JTextField();
        txtCa = new javax.swing.JTextField();
        txtGiaSanBong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txthiChu1 = new javax.swing.JTextArea();

        itemXoa.setText("Xóa");
        popupMenu.add(itemXoa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDate.setCalendarBackground(new java.awt.Color(153, 153, 0));
        txtDate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
            (java.awt.Color)null,
            (java.awt.Color)null,
            (java.awt.Color)null,
            (java.awt.Color)null),
        "Chọn Ngày Đặt Sân",
        javax.swing.border.TitledBorder.LEADING,
        javax.swing.border.TitledBorder.DEFAULT_POSITION ,
        new java.awt.Font("Tahoma", java.awt.Font.BOLD, 10),
        new java.awt.Color(0, 0, 0)));

jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ngày đặt sân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
    },
    new String [] {
        "Ngày", "Tháng", "Năm"
    }
    ));
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jTable1MouseReleased(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel7.setText("Tên Khách Hàng");

    btnAddKH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnAddKH.setText("+");
    btnAddKH.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddKHActionPerformed(evt);
        }
    });

    jLabel8.setText("Tên Nhân Viên");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnAddKH))
                .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(16, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8))
            .addGap(24, 24, 24))
    );

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(22, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(50, 50, 50)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(62, Short.MAX_VALUE))
    );

    btnThoai.setBackground(new java.awt.Color(255, 51, 51));
    btnThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnThoai.setForeground(new java.awt.Color(255, 255, 255));
    btnThoai.setText("Thoát");
    btnThoai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnThoaiActionPerformed(evt);
        }
    });

    btnDatLich.setBackground(new java.awt.Color(51, 102, 255));
    btnDatLich.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnDatLich.setForeground(new java.awt.Color(255, 255, 255));
    btnDatLich.setText("Đặt lịch");

    javax.swing.GroupLayout pnTongLayout = new javax.swing.GroupLayout(pnTong);
    pnTong.setLayout(pnTongLayout);
    pnTongLayout.setHorizontalGroup(
        pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 773, Short.MAX_VALUE)
    );
    pnTongLayout.setVerticalGroup(
        pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 479, Short.MAX_VALUE)
    );

    jScrollPane2.setViewportView(pnTong);

    javax.swing.GroupLayout tdtdLayout = new javax.swing.GroupLayout(tdtd);
    tdtd.setLayout(tdtdLayout);
    tdtdLayout.setHorizontalGroup(
        tdtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
    tdtdLayout.setVerticalGroup(
        tdtdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
    );

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sân"));

    jLabel9.setText("Tên sân bóng");

    jLabel10.setText("Thời Gian");

    jLabel11.setText("Giá ca");

    jLabel2.setText("Ghi chú");

    txthiChu1.setColumns(20);
    txthiChu1.setRows(5);
    jScrollPane3.setViewportView(txthiChu1);

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(48, 48, 48)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(txtGiaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2))
                    .addGap(29, 29, 29)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11)
                .addComponent(txtGiaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(30, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(tdtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(51, 51, 51))
        .addGroup(layout.createSequentialGroup()
            .addGap(362, 362, 362)
            .addComponent(btnDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(317, 317, 317))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tdtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(33, 33, 33))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKHActionPerformed
        // TODO add your handling code here:
        Acount acount = new Acount(qLAcount.getId(), qLAcount.getMaAcount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), qLAcount.getTrangThai());
        FrmKhachHangDL frmKhachHang = new FrmKhachHangDL(qLSanCa, acount, labelHome, panelTong, new Date());
        frmKhachHang.setVisible(true);
    }//GEN-LAST:event_btnAddKHActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn dòng");
            return;
        }
        if (evt.isPopupTrigger()) {
            indexRow = index;
            popupMenu.show(jTable1, evt.getPoint().x, evt.getPoint().y);
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void btnThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoaiActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatLich().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKH;
    private javax.swing.JButton btnDatLich;
    private javax.swing.JButton btnThoai;
    private javax.swing.JMenuItem itemXoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnTong;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JPanel tdtd;
    private javax.swing.JTextField txtCa;
    private datechooser.beans.DateChooserPanel txtDate;
    private javax.swing.JTextField txtGiaSanBong;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtTenSanBong;
    private javax.swing.JTextArea txthiChu1;
    // End of variables declaration//GEN-END:variables
}
