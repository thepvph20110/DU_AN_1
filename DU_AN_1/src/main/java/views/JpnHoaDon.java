/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.KichThuoc;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import enumclass.trangThaiDichVu;
import enumclass.trangThaiDoThue;
import enumclass.trangThaiNuocUong;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLDichVu;
import modelview.QLDoThue;
import modelview.QLHoaDon;
import modelview.QLNuocUong;
import service.IDichVuService;
import service.INuocUongService;
import service.Impl.DichVuServiceImpl;
import service.Impl.DoThueServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.KichThuocServiceImpl;
import service.Impl.MauSacServiceImpl;
import service.Impl.NhaSanXuatServiceImpl;
import service.Impl.NuocUongServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnHoaDon extends javax.swing.JPanel {

    private INuocUongService nuocUongService = new NuocUongServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<QLNuocUong> listsQLNuocUong = new ArrayList<>();

    private DefaultTableModel dtmDoThue = new DefaultTableModel();
    private DefaultComboBoxModel dcbmMauSac = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmKT = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmNSX = new DefaultComboBoxModel();
    private List<QLDoThue> listQLDoThue = new ArrayList<>();
    private List<MauSac> listMauSac = new ArrayList<>();
    private List<KichThuoc> listKThuoc = new ArrayList<>();
    private List<NhaSanXuat> listNSX = new ArrayList<>();
    private MauSacServiceImpl mauSacServiceImpl = new MauSacServiceImpl();
    private KichThuocServiceImpl kichThuocServiceImpl = new KichThuocServiceImpl();
    private NhaSanXuatServiceImpl nhaSanXuatServiceImpl = new NhaSanXuatServiceImpl();
    private DoThueServiceImpl doThueServiceImpl = new DoThueServiceImpl();
    private int index = -1;
    // trang hiện tại.
    private int firstResult;
    // tổng số trang
    private int totalPages;
    // kích thước trang
    private int maxResults;
    // Tổng nước uống
    private long totalNuocUong;

    public JpnHoaDon() {
        initComponents();
        firstResult = 1;
        maxResults = 2;

        loadDataToTable();
        txtGia.setText("0");
        txtSoLuong.setText("0");
        txtMa.setEditable(false);

        loaDataTableToDoThue();
        txtGiaDoThue.setText("0");
        txtSoLuongDoThue.setText("0");
        txtMaDoThue.setEditable(false);
        loadCBBFormToTable();
    }

    private QLNuocUong getNuocUongFromInput() {
        QLNuocUong qLNuocUong = new QLNuocUong();
        qLNuocUong.setMaNuocUong(txtMa.getText().trim());
        qLNuocUong.setTenNuocUong(txtTen.getText().trim());
        qLNuocUong.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
        qLNuocUong.setGia(Long.valueOf(txtGia.getText().trim()));
        if (rdoConHang.isSelected()) {
            qLNuocUong.setTrangThai(trangThaiNuocUong.Con_Hang);
        } else {
            qLNuocUong.setTrangThai(trangThaiNuocUong.Het_Hang);
        }
        return qLNuocUong;
    }

    private void loadDataToTable() {
//        listsQLNuocUong = nuocUongService.getNuocUong(firstResult - 1, maxResults);
        listsQLNuocUong = nuocUongService.getNuocUongNoPagination();
        String[] header = {"Mã", "Tên Nước", "Số Lượng", "Giá", "Trạng Thái"};
        tbNuocUong.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        showData(listsQLNuocUong);

        totalNuocUong = nuocUongService.countAllNuocUong();
        lblTong.setText("Tổng Nước Uống: " + totalNuocUong);

        totalPages = (int) (totalNuocUong / maxResults) + 1;

//        setStatePagination();
    }

    private void showData(List<QLNuocUong> listsQLNuocUong) {
        dtm.setRowCount(0);
        listsQLNuocUong.forEach(c -> dtm.addRow(c.toRowData()));
    }

    private void loaDataTableToDoThue() {
        listQLDoThue.clear();
        listQLDoThue = doThueServiceImpl.getAll();
        tbDoThue.setModel(dtmDoThue);
        String[] deader = {"Mã Đồ Thuê", "Tên Đồ Thuê", "Mã Màu Sắc", "Mã Kích Thước", "Mã NSX", "Số Lượng", "Đơn giá", "Trạng Thái"};
        dtmDoThue.setColumnIdentifiers(deader);
        showDataDoThue(listQLDoThue);
        lblTong1.setText("Tổng Đồ Thuê : " + doThueServiceImpl.countAllDoThue());
    }

    private void fillDataToTableDoThue() {
        txtMaDoThue.setText(mouclick().getMaDoThue());
        txtTenDoThue.setText(mouclick().getTenDoThue());
        cbbMauSac1.setSelectedItem(mouclick().getMaMauSac());
        cbbKT.setSelectedItem(mouclick().getMaKichThuoc());
        cbbNSX.setSelectedItem(mouclick().getMaNhaSanXuat());
        txtSoLuongDoThue.setText(String.valueOf(mouclick().getSoLuong()));
        txtGiaDoThue.setText(String.valueOf(mouclick().getDonGia()));
        trangThaiDoThue tthaiDoThue = mouclick().getTrangThai();
        if (tthaiDoThue == trangThaiDoThue.Con_Hang) {
            rdoConHangDoThue.setSelected(true);
        } else {
            rdoHetHangDoThue.setSelected(true);
        }
    }

    private void showDataDoThue(List<QLDoThue> listQLDoThues) {
        dtmDoThue.setRowCount(0);
        listQLDoThues.forEach(c -> dtmDoThue.addRow(c.toData()));
    }

    private void loadCBBFormToTable() {
        listKThuoc = kichThuocServiceImpl.getAll();
        listMauSac = mauSacServiceImpl.getAll();
        listNSX = nhaSanXuatServiceImpl.getAll();
        for (KichThuoc kt : listKThuoc) {
            dcbmKT.addElement(kt.getMaSize());
        }

        for (MauSac ms : listMauSac) {
            dcbmMauSac.addElement(ms.getMaMauSac());
        }

        for (NhaSanXuat nsx : listNSX) {
            dcbmNSX.addElement(nsx.getMaNSX());
        }

        cbbKT.setModel(dcbmKT);
        cbbNSX.setModel(dcbmNSX);
        cbbMauSac1.setModel(dcbmMauSac);
    }

    private void clearDoThue() {
        txtMaDoThue.setText("");
        txtTenDoThue.setText("");
        txtGiaDoThue.setText("0");
        txtSoLuongDoThue.setText("0");
        rdoConHangDoThue.setSelected(true);
        rdoHetHangDoThue.setSelected(false);
        cbbMauSac1.setSelectedIndex(0);
        cbbNSX.setSelectedIndex(0);
        cbbKT.setSelectedIndex(0);
        txtTimKiemDoThue.setText("");
        rdoTimKiemConHangDT.setSelected(false);
        txtMaDoThue.setEditable(false);
//        rdoTimKiemHetHangDT.setSelected(false);
        loaDataTableToDoThue();
    }

    private QLDoThue mouclick() {
        int index = tbDoThue.getSelectedRow();
        return listQLDoThue.get(index);
    }

    // đặt trangj thái phân trang.
    private void setStatePagination() {
//        btnVe.setEnabled(firstResult > 1);
//
//        btnTiep.setEnabled(firstResult < totalPages);
//
//        lblLoad.setText(firstResult + " / " + totalPages);
    }

    private void clear() {
        txtTimKiem.setText("");
        txtTen.setText("");
        txtGia.setText("0");
        txtSoLuong.setText("0");
        txtMa.setText("");
        txtMa.setEditable(false);
        rdoConHang.setSelected(true);
        rdoHetHang.setSelected(false);
        rdoTimKiemConHang.setSelected(false);
        rdoTimKiemHetHang.setSelected(false);
        loadDataToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpnViewNuocUong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jpnViewNuocUong1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNuocUong = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdoTimKiemConHang = new javax.swing.JRadioButton();
        rdoTimKiemHetHang = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jpnViewNuocUong2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDoThue = new javax.swing.JTable();
        lblTong1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuongDoThue = new javax.swing.JTextField();
        txtTenDoThue = new javax.swing.JTextField();
        txtMaDoThue = new javax.swing.JTextField();
        txtGiaDoThue = new javax.swing.JTextField();
        rdoConHangDoThue = new javax.swing.JRadioButton();
        rdoHetHangDoThue = new javax.swing.JRadioButton();
        btnMoiDoThue = new javax.swing.JButton();
        btnXoaDoThue = new javax.swing.JButton();
        btnSuaDoThue = new javax.swing.JButton();
        btnThemDoThue = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbbKT = new javax.swing.JComboBox<>();
        cbbMauSac1 = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        txtMau = new javax.swing.JLabel();
        txtKT = new javax.swing.JLabel();
        txtNSX = new javax.swing.JLabel();
        btnAddKT = new javax.swing.JButton();
        btnAddMau = new javax.swing.JButton();
        btnAddNsx = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiemDoThue = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rdoTimKiemConHangDT = new javax.swing.JRadioButton();
        rdoTimKiemHetHangDT = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jpnViewNuocUong.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Dịch Vụ");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbNuocUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbNuocUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNuocUongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNuocUong);

        lblTong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTong.setText("Tổng Nước Uống : 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nước Uống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Nước :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên Nước :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá :");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoConHang);
        rdoConHang.setSelected(true);
        rdoConHang.setText("Còn Hàng");

        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setText("Hết Hàng");

        btnMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMoi.setText("Thêm Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Cập Nhập");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(100, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoConHang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(rdoHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoConHang)
                    .addComponent(rdoHetHang))
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(32, 32, 32)
                .addComponent(btnMoi)
                .addGap(62, 62, 62))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên Nước Uống");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Lọc theo trạng thái");

        buttonGroup1.add(rdoTimKiemConHang);
        rdoTimKiemConHang.setText("Còn Hàng");
        rdoTimKiemConHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTimKiemConHangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTimKiemHetHang);
        rdoTimKiemHetHang.setText("Hết Hàng");
        rdoTimKiemHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTimKiemHetHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addComponent(rdoTimKiemConHang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoTimKiemHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(rdoTimKiemConHang)
                    .addComponent(rdoTimKiemHetHang))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewNuocUong1Layout = new javax.swing.GroupLayout(jpnViewNuocUong1);
        jpnViewNuocUong1.setLayout(jpnViewNuocUong1Layout);
        jpnViewNuocUong1Layout.setHorizontalGroup(
            jpnViewNuocUong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewNuocUong1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnViewNuocUong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jpnViewNuocUong1Layout.setVerticalGroup(
            jpnViewNuocUong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUong1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jpnViewNuocUong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnViewNuocUong1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jpnViewNuocUong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Nước Uống", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbDoThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDoThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDoThueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDoThue);

        lblTong1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTong1.setText("Tổng Đồ Thuê : 0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTong1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Đồ Thuê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mã Đồ Thuê:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên Đồ Thuê:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số Lượng:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trạng Thái :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Giá Đồ Thuê:");

        txtSoLuongDoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongDoThueActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoConHangDoThue);
        rdoConHangDoThue.setSelected(true);
        rdoConHangDoThue.setText("Còn Hàng");

        buttonGroup2.add(rdoHetHangDoThue);
        rdoHetHangDoThue.setText("Hết Hàng");

        btnMoiDoThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMoiDoThue.setText("Thêm Mới");
        btnMoiDoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDoThueActionPerformed(evt);
            }
        });

        btnXoaDoThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDoThue.setText("Xóa");
        btnXoaDoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoThueActionPerformed(evt);
            }
        });

        btnSuaDoThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaDoThue.setText("Cập Nhập");
        btnSuaDoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDoThueActionPerformed(evt);
            }
        });

        btnThemDoThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemDoThue.setText("Thêm");
        btnThemDoThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDoThueActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nhà SX:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Màu Sắc:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Kích Thước:");

        cbbKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKTActionPerformed(evt);
            }
        });

        cbbMauSac1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMauSac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSac1ActionPerformed(evt);
            }
        });

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNSXActionPerformed(evt);
            }
        });

        txtMau.setText("Màu -");

        txtKT.setText("Kích Thước -");

        txtNSX.setText("NSX -");

        btnAddKT.setBackground(new java.awt.Color(255, 255, 0));
        btnAddKT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddKT.setText("+");
        btnAddKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKTActionPerformed(evt);
            }
        });

        btnAddMau.setBackground(new java.awt.Color(255, 255, 0));
        btnAddMau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddMau.setText("+");
        btnAddMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMauActionPerformed(evt);
            }
        });

        btnAddNsx.setBackground(new java.awt.Color(255, 255, 0));
        btnAddNsx.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddNsx.setText("+");
        btnAddNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNsxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel18)
                        .addComponent(jLabel17))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbKT, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtNSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnAddKT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(20, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnAddMau, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdoConHangDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rdoHetHangDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtGiaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThemDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnSuaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnXoaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbbMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMau)
                    .addComponent(btnAddMau))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbbKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKT)
                    .addComponent(btnAddKT))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNSX)
                    .addComponent(btnAddNsx))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGiaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoConHangDoThue)
                    .addComponent(rdoHetHangDoThue))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaDoThue)
                    .addComponent(btnThemDoThue)
                    .addComponent(btnXoaDoThue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoiDoThue)
                .addGap(64, 64, 64))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên Đồ Thuê");

        txtTimKiemDoThue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemDoThueKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Lọc theo trạng thái");

        buttonGroup2.add(rdoTimKiemConHangDT);
        rdoTimKiemConHangDT.setText("Còn Hàng");
        rdoTimKiemConHangDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTimKiemConHangDTActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoTimKiemHetHangDT);
        rdoTimKiemHetHangDT.setText("Hết Hàng");
        rdoTimKiemHetHangDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTimKiemHetHangDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiemDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTimKiemConHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTimKiemHetHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTimKiemDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(rdoTimKiemConHangDT)
                    .addComponent(rdoTimKiemHetHangDT))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewNuocUong2Layout = new javax.swing.GroupLayout(jpnViewNuocUong2);
        jpnViewNuocUong2.setLayout(jpnViewNuocUong2Layout);
        jpnViewNuocUong2Layout.setHorizontalGroup(
            jpnViewNuocUong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewNuocUong2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnViewNuocUong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 74, Short.MAX_VALUE))
        );
        jpnViewNuocUong2Layout.setVerticalGroup(
            jpnViewNuocUong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUong2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnViewNuocUong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnViewNuocUong2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnViewNuocUong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản Lý Đồ Thuê", jPanel8);

        javax.swing.GroupLayout jpnViewNuocUongLayout = new javax.swing.GroupLayout(jpnViewNuocUong);
        jpnViewNuocUong.setLayout(jpnViewNuocUongLayout);
        jpnViewNuocUongLayout.setHorizontalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(587, 587, 587))
            .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnViewNuocUongLayout.setVerticalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbNuocUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNuocUongMouseClicked
        int index = this.tbNuocUong.getSelectedRow();
        if (index == -1) {
            return;
        }
        this.txtMa.setText(tbNuocUong.getValueAt(index, 0).toString());
        this.txtTen.setText(tbNuocUong.getValueAt(index, 1).toString());
        this.txtSoLuong.setText(tbNuocUong.getValueAt(index, 2).toString());
        this.txtGia.setText(tbNuocUong.getValueAt(index, 3).toString());
        if (tbNuocUong.getValueAt(index, 4).equals(trangThaiNuocUong.Con_Hang)) {
            this.rdoConHang.setSelected(true);
        } else {
            this.rdoHetHang.setSelected(true);
        }
    }//GEN-LAST:event_tbNuocUongMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        if (txtMa.getText().trim().isEmpty() == true) {
//            JOptionPane.showMessageDialog(this, "Không được để trống mã");}
        if (txtTen.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
        } else if (txtSoLuong.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống số lượng");
        } else if (txtSoLuong.getText().trim().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
        } else if (Integer.parseInt(txtSoLuong.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để số lượng <=0");
        } else if (txtGia.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống giá");
        } else if (txtGia.getText().trim().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Giá phải là số ");
        } else if (Long.valueOf(txtGia.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để giá <= 0");
        } else {
            int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn thêm Mới Nước Uống", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (checkConFirm == JOptionPane.YES_OPTION) {
                QLNuocUong qLNuocUong = new QLNuocUong();
                qLNuocUong.setMaNuocUong(txtMa.getText().trim());
                qLNuocUong.setTenNuocUong(txtTen.getText().trim());
                qLNuocUong.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
                qLNuocUong.setGia(Long.valueOf(txtGia.getText().trim()));
                if (rdoConHang.isSelected()) {
                    qLNuocUong.setTrangThai(trangThaiNuocUong.Con_Hang);
                } else {
                    qLNuocUong.setTrangThai(trangThaiNuocUong.Het_Hang);
                }
                JOptionPane.showMessageDialog(this, nuocUongService.createNewNuocUong(qLNuocUong));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy thêm nước uống");
            }
            loadDataToTable();
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        index = this.tbNuocUong.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn đối tượng");
            return;
        }
        if (txtTen.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
        } else if (txtSoLuong.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống số lượng");
        } else if (txtSoLuong.getText().trim().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
        } else if (Integer.parseInt(txtSoLuong.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để số lượng <=0");
        } else if (txtGia.getText().trim().isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống giá");
        } else if (txtGia.getText().trim().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Giá phải là số ");
        } else if (Long.valueOf(txtGia.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để giá <= 0");
        } else {
            QLNuocUong qLNuocUong = getNuocUongFromInput();
            qLNuocUong.setId(listsQLNuocUong.get(index).getId());
            qLNuocUong.setMaNuocUong(txtMa.getText().trim());
            qLNuocUong.setTenNuocUong(txtTen.getText().trim());
            qLNuocUong.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
            qLNuocUong.setGia(Long.valueOf(txtGia.getText().trim()));
            if (rdoConHang.isSelected()) {
                qLNuocUong.setTrangThai(trangThaiNuocUong.Con_Hang);
            } else {
                qLNuocUong.setTrangThai(trangThaiNuocUong.Het_Hang);
            }
            int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Update Nước "
                    + "Uống", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (checkConFirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, nuocUongService.updateNuocUongById(qLNuocUong));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy upadte nước uống");
            }
            loadDataToTable();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = this.tbNuocUong.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn đối tượng");
            return;
        }
        String id = listsQLNuocUong.get(index).getId();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Delete Nước Uống", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, nuocUongService.deleteNuocUongById(id));
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy Delete nước uống");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        listsQLNuocUong.clear();
        listsQLNuocUong = nuocUongService.getNuocUongByTenNuocUong(txtTimKiem.getText());
        showData(listsQLNuocUong);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void rdoTimKiemConHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTimKiemConHangActionPerformed
        listsQLNuocUong.clear();
        if (rdoTimKiemConHang.isSelected()) {
            listsQLNuocUong = nuocUongService.getNuocUongByTranThai(trangThaiNuocUong.Con_Hang);
            showData(listsQLNuocUong);
        }
    }//GEN-LAST:event_rdoTimKiemConHangActionPerformed

    private void rdoTimKiemHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTimKiemHetHangActionPerformed
        listsQLNuocUong.clear();
        if (rdoTimKiemHetHang.isSelected()) {
            listsQLNuocUong = nuocUongService.getNuocUongByTranThai(trangThaiNuocUong.Het_Hang);
            showData(listsQLNuocUong);
        }
    }//GEN-LAST:event_rdoTimKiemHetHangActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void tbDoThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDoThueMouseClicked
        fillDataToTableDoThue();
    }//GEN-LAST:event_tbDoThueMouseClicked

    private void txtSoLuongDoThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongDoThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongDoThueActionPerformed

    private void btnMoiDoThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDoThueActionPerformed
        clearDoThue();
    }//GEN-LAST:event_btnMoiDoThueActionPerformed

    private void btnXoaDoThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoThueActionPerformed

        if (mouclick() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Đối Tượng Muốn Xóa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Đồ Thuê", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, doThueServiceImpl.deleteDoThueById(mouclick().getId()));
            clearDoThue();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Đã Chọn Hủy Xóa Đồ Thuê");
        }

        loaDataTableToDoThue();
    }//GEN-LAST:event_btnXoaDoThueActionPerformed

    private void btnSuaDoThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDoThueActionPerformed
        index = tbDoThue.getSelectedRow();
        String madoThue = txtMaDoThue.getText().trim();
        String tenDoThue = txtTenDoThue.getText().trim();
        String maMS = cbbMauSac1.getSelectedItem().toString();
        String maKT = cbbKT.getSelectedItem().toString();
        String maNSX = cbbNSX.getSelectedItem().toString();
        String soLuong = txtSoLuongDoThue.getText().trim();
        String donGia = txtGiaDoThue.getText().trim();
        trangThaiDoThue tdt = trangThaiDoThue.Con_Hang;
        if (rdoHetHangDoThue.isSelected()) {
            tdt = trangThaiDoThue.Het_Hang;
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Đối Tượng Muốn Sửa");
            return;
        }
        if (tenDoThue.isEmpty() == true || soLuong.isEmpty() == true || donGia.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống các trường");
        } else if (soLuong.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Số Lượng không đúng định dạng");
        } else if (Integer.valueOf(soLuong) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để số Lượng <= 0");
        } else if (donGia.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
        } else if (Double.valueOf(donGia) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để đơn giá <=0 ");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Cập Nhập Đồ Thuê", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                QLDoThue qLDoThue = new QLDoThue(listQLDoThue.get(index).getId(), madoThue, tenDoThue, maKT, null, maMS, null, maNSX, null, Integer.valueOf(soLuong), Double.valueOf(donGia), tdt);
                JOptionPane.showMessageDialog(this, doThueServiceImpl.AddorUpdate(qLDoThue));

            } else {
                JOptionPane.showMessageDialog(this, "Bạn Đã Chọn Hủy Cập Nhập Đồ Thuê");
            }
            loaDataTableToDoThue();
        }
    }//GEN-LAST:event_btnSuaDoThueActionPerformed

    private void btnThemDoThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDoThueActionPerformed
        String madoThue = txtMaDoThue.getText().trim();
        String tenDoThue = txtTenDoThue.getText().trim();
        String maMS = cbbMauSac1.getSelectedItem().toString();
        String maKT = cbbKT.getSelectedItem().toString().trim();
        String maNSX = cbbNSX.getSelectedItem().toString().trim();
        String soLuong = txtSoLuongDoThue.getText().trim();
        String donGia = txtGiaDoThue.getText().trim();
        trangThaiDoThue tdt = trangThaiDoThue.Con_Hang;
        if (rdoHetHangDoThue.isSelected()) {
            tdt = trangThaiDoThue.Het_Hang;
        }
        if (tenDoThue.isEmpty() == true || soLuong.isEmpty() == true || donGia.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Không để trống các trường");
        } else if (soLuong.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Số Lượng đồ thuê không đúng định dạng");
        } else if (Integer.valueOf(soLuong) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để số Lượng <= 0");
        } else if (donGia.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Đơn giá đồ thuê không đúng định dạng");
        } else if (Double.valueOf(donGia) <= 0) {
            JOptionPane.showMessageDialog(this, "Không để đơn giá đồ thuê <=0 ");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Thêm Đồ Thuê", "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                QLDoThue qLDoThue = new QLDoThue(null, madoThue, tenDoThue, maKT, null, maMS, null, maNSX, null, Integer.valueOf(soLuong), Double.valueOf(donGia), tdt);
                JOptionPane.showMessageDialog(this, doThueServiceImpl.createNewDoThue(qLDoThue));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Đã Chọn Hủy Thêm Đồ Thuê");
            }
            loaDataTableToDoThue();
        }
    }//GEN-LAST:event_btnThemDoThueActionPerformed

    private void txtTimKiemDoThueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDoThueKeyReleased
        listQLDoThue.clear();
        listQLDoThue = doThueServiceImpl.getDoThueByTenDoThue(txtTimKiemDoThue.getText());
        showDataDoThue(listQLDoThue);
    }//GEN-LAST:event_txtTimKiemDoThueKeyReleased

    private void rdoTimKiemConHangDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTimKiemConHangDTActionPerformed
        listQLDoThue.clear();
        listQLDoThue = doThueServiceImpl.getDoThueByTranThai(trangThaiDoThue.Con_Hang);
        showDataDoThue(listQLDoThue);
    }//GEN-LAST:event_rdoTimKiemConHangDTActionPerformed

    private void rdoTimKiemHetHangDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTimKiemHetHangDTActionPerformed
        listQLDoThue.clear();
        listQLDoThue = doThueServiceImpl.getDoThueByTranThai(trangThaiDoThue.Het_Hang);
        showDataDoThue(listQLDoThue);
    }//GEN-LAST:event_rdoTimKiemHetHangDTActionPerformed

    private void cbbMauSac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSac1ActionPerformed
        MauSac msss = mauSacServiceImpl.getOne(cbbMauSac1.getSelectedItem().toString());
        txtMau.setText("Màu - " + msss.getTenMauSac());
    }//GEN-LAST:event_cbbMauSac1ActionPerformed

    private void cbbKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKTActionPerformed
        KichThuoc kthuoc = kichThuocServiceImpl.getOne(cbbKT.getSelectedItem().toString());
        txtKT.setText("Kích Thước - " + String.valueOf(kthuoc.getSize()));
    }//GEN-LAST:event_cbbKTActionPerformed

    private void cbbNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNSXActionPerformed
        NhaSanXuat nsxxx = nhaSanXuatServiceImpl.getOne(cbbNSX.getSelectedItem().toString());
        txtNSX.setText("NSX - " + nsxxx.getTenNSX());
    }//GEN-LAST:event_cbbNSXActionPerformed

    private void btnAddMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMauActionPerformed
        new MauSac_JFrame().setVisible(true);
    }//GEN-LAST:event_btnAddMauActionPerformed

    private void btnAddKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKTActionPerformed
        new KichThuoc_JFrame().setVisible(true);
    }//GEN-LAST:event_btnAddKTActionPerformed

    private void btnAddNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNsxActionPerformed
        new NSX_JFrame().setVisible(true);
    }//GEN-LAST:event_btnAddNsxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKT;
    private javax.swing.JButton btnAddMau;
    private javax.swing.JButton btnAddNsx;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMoiDoThue;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDoThue;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDoThue;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaDoThue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbKT;
    private javax.swing.JComboBox<String> cbbMauSac1;
    private javax.swing.JComboBox<String> cbbNSX;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnViewNuocUong;
    private javax.swing.JPanel jpnViewNuocUong1;
    private javax.swing.JPanel jpnViewNuocUong2;
    private javax.swing.JLabel lblTong;
    private javax.swing.JLabel lblTong1;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoConHangDoThue;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JRadioButton rdoHetHangDoThue;
    private javax.swing.JRadioButton rdoTimKiemConHang;
    private javax.swing.JRadioButton rdoTimKiemConHangDT;
    private javax.swing.JRadioButton rdoTimKiemHetHang;
    private javax.swing.JRadioButton rdoTimKiemHetHangDT;
    private javax.swing.JTable tbDoThue;
    private javax.swing.JTable tbNuocUong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaDoThue;
    private javax.swing.JLabel txtKT;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaDoThue;
    private javax.swing.JLabel txtMau;
    private javax.swing.JLabel txtNSX;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongDoThue;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDoThue;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemDoThue;
    // End of variables declaration//GEN-END:variables
}
