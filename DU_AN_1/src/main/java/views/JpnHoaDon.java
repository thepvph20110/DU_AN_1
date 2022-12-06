/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import enumclass.trangThaiDichVu;
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
import service.Impl.DichVuServiceImpl;
import service.Impl.DoThueServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.NuocUongServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form JpnHoaDon
     */
    private List<QLDichVu> listQLDichVu = new ArrayList<>();
    private List<String> listCBBNuocUong = new ArrayList<>();
    private DefaultComboBoxModel dcbmNuocUong = new DefaultComboBoxModel();

    private List<String> listCBBDoThue = new ArrayList<>();
    private DefaultComboBoxModel dcbmDoThue = new DefaultComboBoxModel();

    private List<String> listCBBHoaDon = new ArrayList<>();
    private DefaultComboBoxModel dcbmHoaDon = new DefaultComboBoxModel();

    private List<trangThaiDichVu> listCBBTrangThai = new ArrayList<>();
    private DefaultComboBoxModel dcbmTrangThai = new DefaultComboBoxModel();

    private IDichVuService dichVuService = new DichVuServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();

    private int index = -1;
    private int curentPage;
    private int totalPage;
    private int pageSize;
    private long totalDichVu;

    public JpnHoaDon() {
        initComponents();
        loadDataToTable();
        cbbNuocUong.setModel(dcbmNuocUong);
        loadCBBNuocUong();

        cbbDoThue.setModel(dcbmDoThue);
        loadCBBDoThue();

        txtDonGiaDV.setEditable(false);

        fixCungSoLuong();

        loadCBBHoaDon();

        loadCBBTimKiemTrangThai();

        jtaMoTa.setText("N/A");
    }

    private void clear() {
        txtMaDV.setText("");
        txtTimKiem.setText("");
        txtSoLuongNuocUong.setText("0");
        txtSoLuongDoThue.setText("0");
        txtDonGiaDV.setText("0");
        jtaMoTa.setText("N/A");
        cbbDoThue.setSelectedIndex(0);
        cbbHoaDon.setSelectedIndex(0);
        cbbNuocUong.setSelectedIndex(0);
        cbbTranThaiTim.setSelectedIndex(0);
        rdoDangSD.setSelected(true);
        rdoNgungSD.setSelected(false);
        loadDataToTable();
    }

    private void loadDataToTable() {
        listQLDichVu = dichVuService.getDichVuNoPagination();
        String[] header = {"ID", "Mã DV", "Đồ Thuê", "SL Đồ", "Hóa Đơn", "Nước Uống", "SL Nước", "Đơn Giá", "Mô Tả", "Trạng Thái"};

        tbDichVu.setModel(dtm);
        dtm.setColumnIdentifiers(header);
        showData(listQLDichVu);

        totalDichVu = dichVuService.countAllDichVu();
        lblTong.setText("Tổng : " + totalDichVu);

    }

    private void showData(List<QLDichVu> listQLDichVu) {
        dtm.setRowCount(0);
        listQLDichVu.forEach(c -> dtm.addRow(c.toRowData()));
    }

    private void loadCBBNuocUong() {
        List<QLNuocUong> listQLNuocUong = new NuocUongServiceImpl().getNuocUongNoPagination();
        for (QLNuocUong qlNuocUong : listQLNuocUong) {
            listCBBNuocUong.add(qlNuocUong.getTenNuocUong());
        }

        for (String nuocUong : listCBBNuocUong) {
            dcbmNuocUong.addElement(nuocUong);
        }
    }

    private void loadCBBHoaDon() {
        List<QLHoaDon> listQLHoaDon = new HoaDonServiceImpl().getAll();
        for (QLHoaDon qLHoaDon : listQLHoaDon) {
            listCBBHoaDon.add(String.valueOf(qLHoaDon.getMaHoaDon()));
        }

        for (String hoaDon : listCBBHoaDon) {
            dcbmHoaDon.addElement(hoaDon);
        }
        cbbHoaDon.setModel(dcbmHoaDon);
    }

    private void loadCBBDoThue() {
        List<QLDoThue> listQLDoThue = new DoThueServiceImpl().getAll();
        for (QLDoThue qlDoThue : listQLDoThue) {
            listCBBDoThue.add(qlDoThue.getTenDoThue());
        }

        for (String doThue : listCBBDoThue) {
            dcbmDoThue.addElement(doThue);
        }
    }

    private void loadCBBTimKiemTrangThai() {

        listCBBTrangThai.add(trangThaiDichVu.Dang_Su_Dung);
        listCBBTrangThai.add(trangThaiDichVu.NGUNG_Su_Dung);
        for (trangThaiDichVu trangThai : listCBBTrangThai) {
            dcbmTrangThai.addElement(trangThai);
        }

        cbbTranThaiTim.setModel(dcbmTrangThai);
    }

    private void fixCungSoLuong() {
        txtSoLuongDoThue.setText("0");
        txtSoLuongNuocUong.setText("0");
        txtDonGiaDV.setText(String.valueOf(getDonGia()));
    }

    private double getDonGia() {
        double giaNuoc = 0;
        int soLuongNuoc = 0;
        double giaDoThue = 0;
        int soLuongDoThue = 0;
        double donGia = 0;

        soLuongNuoc = Integer.parseInt(txtSoLuongNuocUong.getText());
        List<QLNuocUong> qlNuocUong = new NuocUongServiceImpl().getNuocUongNoPagination();
        for (QLNuocUong list : qlNuocUong) {
            if (cbbNuocUong.getSelectedItem().equals(list.getTenNuocUong())) {
                giaNuoc = list.getGia();

            }
        }

        soLuongDoThue = Integer.parseInt(txtSoLuongDoThue.getText());
        List<QLDoThue> qlDoThue = new DoThueServiceImpl().getAll();
        for (QLDoThue list : qlDoThue) {
            if (cbbNuocUong.getSelectedItem().equals(list.getTenDoThue())) {
                giaNuoc = list.getDonGia();
            }
        }

        return donGia = (giaNuoc * soLuongNuoc) + (giaDoThue * soLuongDoThue);
    }

    private QLDichVu getDichVuFromInput() {
        //"ID", "Mã DV", "Đồ Thuê", "SL Đồ", "Nước Uống", "SL Nước", "Đơn Giá", "Mô Tả", "Trạng Thái"
        QLDichVu qlDichVu = new QLDichVu();
        qlDichVu.setMaDichVu(txtMaDV.getText());

        qlDichVu.setTenNuocUong(cbbNuocUong.getSelectedItem().toString());
        qlDichVu.setSoLuongNuocUong(Integer.parseInt(txtSoLuongNuocUong.getText()));
        qlDichVu.setHoaDon(cbbHoaDon.getSelectedItem().toString());
        qlDichVu.setTenDoThue(cbbDoThue.getSelectedItem().toString());
        qlDichVu.setSoLuongDoThue(Integer.parseInt(txtSoLuongDoThue.getText()));
        if (rdoDangSD.isSelected()) {
            qlDichVu.setTrangThai(trangThaiDichVu.Dang_Su_Dung);
        } else {
            qlDichVu.setTrangThai(trangThaiDichVu.NGUNG_Su_Dung);
        }
        txtDonGiaDV.setText(String.valueOf(getDonGia()));
        qlDichVu.setDonGia(Double.parseDouble(txtDonGiaDV.getText()));
        qlDichVu.setMoTa(jtaMoTa.getText());

        return qlDichVu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnViewNuocUong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        txtSoLuongDoThue = new javax.swing.JTextField();
        cbbDoThue = new javax.swing.JComboBox<>();
        cbbNuocUong = new javax.swing.JComboBox<>();
        txtSoLuongNuocUong = new javax.swing.JTextField();
        txtDonGiaDV = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaMoTa = new javax.swing.JTextArea();
        rdoDangSD = new javax.swing.JRadioButton();
        rdoNgungSD = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        cbbHoaDon = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbTranThaiTim = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jpnViewNuocUong.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTong.setText("Tổng Dịch Vụ: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTong)
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch Vụ"));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnCapNhap)
                    .addComponent(btnThem))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel4.setText("Nước Uống:");

        jLabel5.setText("Số Lượng Nước:");

        jLabel7.setText("Trạng Thái :");

        jLabel8.setText("Mô tả :");

        jLabel9.setText("Số Lượng Đồ:");

        jLabel10.setText("Đồ Thuê :");

        jLabel11.setText("Mã :");

        cbbDoThue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbNuocUong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtSoLuongNuocUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongNuocUongActionPerformed(evt);
            }
        });

        jtaMoTa.setColumns(20);
        jtaMoTa.setRows(5);
        jScrollPane3.setViewportView(jtaMoTa);

        buttonGroup1.add(rdoDangSD);
        rdoDangSD.setSelected(true);
        rdoDangSD.setText("Đang Sử Dụng");

        buttonGroup1.add(rdoNgungSD);
        rdoNgungSD.setText("Ngừng Sử Dụng");

        jLabel2.setText("Mã Hóa Đơn");

        cbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbDichVu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDichVu);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel3.setText("Mã Dịch Vụ");

        jLabel12.setText("Trạng Thái");

        cbbTranThaiTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTranThaiTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTranThaiTimActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(35, 35, 35)
                .addComponent(cbbTranThaiTim, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTranThaiTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setText("Đơn giá :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdoDangSD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(rdoNgungSD)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoLuongNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbbDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoDangSD)))
                        .addGap(13, 13, 13)
                        .addComponent(rdoNgungSD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoLuongNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDonGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dịch Vụ");

        javax.swing.GroupLayout jpnViewNuocUongLayout = new javax.swing.GroupLayout(jpnViewNuocUong);
        jpnViewNuocUong.setLayout(jpnViewNuocUongLayout);
        jpnViewNuocUongLayout.setHorizontalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                .addGap(626, 626, 626)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnViewNuocUongLayout.setVerticalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDichVuMouseClicked
        int index = this.tbDichVu.getSelectedRow();
        if (index == -1) {
            return;
        }
        txtMaDV.setEditable(false);
        //"ID", "Mã DV", "Đồ Thuê", "SL Đồ", "Nước Uống", "SL Nước", "Đơn Giá", "Mô Tả", "Trạng Thái"
//        this.txtMaDV.setText(tbDichVu.getValueAt(index, 1).toString());
//        this.cbbDoThue.setSelectedItem(tbDichVu.getValueAt(index, 2).toString());
//        this.txtSoLuongDoThue.setText(tbDichVu.getValueAt(index, 3).toString());
//        this.cbbHoaDon.setSelectedItem(tbDichVu.getValueAt(index, 4));
//        this.cbbNuocUong.setSelectedItem(tbDichVu.getValueAt(index, 5).toString());
//        this.txtSoLuongNuocUong.setText(tbDichVu.getValueAt(index, 6).toString());
//        this.txtDonGiaDV.setText(tbDichVu.getValueAt(index, 7).toString());
//
//        this.jtaMoTa.setText(tbDichVu.getValueAt(index, 8).toString());
//
//        if (tbDichVu.getValueAt(index, 9).equals(trangThaiDichVu.Dang_Su_Dung)) {
//            this.rdoDangSD.setSelected(true);
//        } else {
//            this.rdoNgungSD.setSelected(true);
//        }

        this.txtMaDV.setText(listQLDichVu.get(index).getMaDichVu());
        this.cbbDoThue.setSelectedItem(listQLDichVu.get(index).getTenDoThue());
        this.txtSoLuongDoThue.setText(String.valueOf(listQLDichVu.get(index).getSoLuongDoThue()));
        this.cbbHoaDon.setSelectedItem(listQLDichVu.get(index).getHoaDon());
        this.cbbNuocUong.setSelectedItem(listQLDichVu.get(index).getTenNuocUong());
        this.txtSoLuongNuocUong.setText(String.valueOf(listQLDichVu.get(index).getSoLuongNuocUong()));
        this.txtDonGiaDV.setText(String.valueOf(listQLDichVu.get(index).getDonGia()));

        this.jtaMoTa.setText(listQLDichVu.get(index).getMoTa());

        if (listQLDichVu.get(index).getTrangThai().equals(trangThaiDichVu.Dang_Su_Dung)) {
            this.rdoDangSD.setSelected(true);
        } else {
            this.rdoNgungSD.setSelected(true);
        }
    }//GEN-LAST:event_tbDichVuMouseClicked

    private void cbbTranThaiTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTranThaiTimActionPerformed
        listQLDichVu.clear();

        listQLDichVu = dichVuService.getDichVuByTrangThai(trangThaiDichVu.valueOf(cbbTranThaiTim.getSelectedItem().toString()));
        showData(listQLDichVu);
    }//GEN-LAST:event_cbbTranThaiTimActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        listQLDichVu.clear();
        listQLDichVu = dichVuService.getDichVuByMaDichVu(txtTimKiem.getText());
        showData(listQLDichVu);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        QLDichVu qlDichVu = getDichVuFromInput();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn thêm Dịch Vụ", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, dichVuService.createNewDichVu(qlDichVu));
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy thêm Dịch Vụ");
        }

        System.out.println("" + txtDonGiaDV.getText());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        index = this.tbDichVu.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn đối tượng");
            return;
        }
        QLDichVu qlDichVu = getDichVuFromInput();
        qlDichVu.setId(listQLDichVu.get(index).getId());

        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Update Dịch Vụ", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, dichVuService.updateDichVuById(qlDichVu));
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy upadte dịch vụ");
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = this.tbDichVu.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn đối tượng");
            return;
        }
        String id = listQLDichVu.get(index).getId();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Delete dịch vụ", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, dichVuService.deleteDichVuById(id));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy Delete dịch vụ");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtMaDV.setEditable(true);
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtSoLuongNuocUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongNuocUongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongNuocUongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDoThue;
    private javax.swing.JComboBox<String> cbbHoaDon;
    private javax.swing.JComboBox<String> cbbNuocUong;
    private javax.swing.JComboBox<String> cbbTranThaiTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnViewNuocUong;
    private javax.swing.JTextArea jtaMoTa;
    private javax.swing.JLabel lblTong;
    private javax.swing.JRadioButton rdoDangSD;
    private javax.swing.JRadioButton rdoNgungSD;
    private javax.swing.JTable tbDichVu;
    private javax.swing.JTextField txtDonGiaDV;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtSoLuongDoThue;
    private javax.swing.JTextField txtSoLuongNuocUong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
