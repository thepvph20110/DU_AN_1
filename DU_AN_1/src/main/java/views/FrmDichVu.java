/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import enumclass.trangThaiDichVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
public class FrmDichVu extends javax.swing.JFrame {
    
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
    
    public FrmDichVu() {
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnViewNuocUong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbTranThaiTim = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dịch Vụ");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTong.setText("Tổng: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblTong)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(45, 45, 45)
                .addComponent(cbbTranThaiTim, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(cbbTranThaiTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dịch Vụ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch Vụ"));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhap.setText("Cập Nhập");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThem)
                .addGap(31, 31, 31)
                .addComponent(btnCapNhap)
                .addGap(35, 35, 35)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoi)
                .addGap(22, 22, 22))
        );

        jLabel4.setText("Nước Uống:");

        jLabel5.setText("Số Lượng Nước:");

        jLabel6.setText("Đơn giá :");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbNuocUong, 0, 151, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongNuocUong))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                        .addComponent(rdoDangSD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdoNgungSD)))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rdoDangSD))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuongNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(rdoNgungSD))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDonGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewNuocUongLayout = new javax.swing.GroupLayout(jpnViewNuocUong);
        jpnViewNuocUong.setLayout(jpnViewNuocUongLayout);
        jpnViewNuocUongLayout.setHorizontalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                .addGroup(jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnViewNuocUongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnViewNuocUongLayout.setVerticalGroup(
            jpnViewNuocUongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnViewNuocUongLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnViewNuocUong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDichVuMouseClicked
        int index = this.tbDichVu.getSelectedRow();
        if (index == -1) {
            return;
        }
        txtMaDV.setEditable(false);
//"ID", "Mã DV", "Đồ Thuê", "SL Đồ", "Nước Uống", "SL Nước", "Đơn Giá", "Mô Tả", "Trạng Thái"     
        this.txtMaDV.setText(tbDichVu.getValueAt(index, 1).toString());
        this.cbbDoThue.setSelectedItem(tbDichVu.getValueAt(index, 2).toString());
        this.txtSoLuongDoThue.setText(tbDichVu.getValueAt(index, 3).toString());
        this.cbbHoaDon.setSelectedItem(tbDichVu.getValueAt(index, 4));
        this.cbbNuocUong.setSelectedItem(tbDichVu.getValueAt(index, 5).toString());
        this.txtSoLuongNuocUong.setText(tbDichVu.getValueAt(index, 6).toString());
        this.txtDonGiaDV.setText(tbDichVu.getValueAt(index, 7).toString());
        
        this.jtaMoTa.setText(tbDichVu.getValueAt(index, 8).toString());
        
        if (tbDichVu.getValueAt(index, 9).equals(trangThaiDichVu.Dang_Su_Dung)) {
            this.rdoDangSD.setSelected(true);
        } else {
            this.rdoNgungSD.setSelected(true);
        }
    }//GEN-LAST:event_tbDichVuMouseClicked

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
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        QLDichVu qlDichVu = getDichVuFromInput();
        qlDichVu.setId(listQLDichVu.get(index).getId());
        
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Update Dịch Vụ", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, dichVuService.updateDichVuById(qlDichVu));
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy upadte dịch vụ");
        }

    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = this.tbDichVu.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn đối tượng");
            return;
        }
        String id = listQLDichVu.get(index).getId();
        int checkConFirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Delete dịch vụ", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (checkConFirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, dichVuService.deleteDichVuById(id));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn hủy Delete dịch vụ");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSoLuongNuocUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongNuocUongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongNuocUongActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtMaDV.setEditable(true);
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        listQLDichVu.clear();
        listQLDichVu = dichVuService.getDichVuByMaDichVu(txtTimKiem.getText());
        showData(listQLDichVu);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbbTranThaiTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTranThaiTimActionPerformed
        listQLDichVu.clear();
        
        listQLDichVu = dichVuService.getDichVuByTrangThai(trangThaiDichVu.valueOf(cbbTranThaiTim.getSelectedItem().toString()));
        showData(listQLDichVu);
    }//GEN-LAST:event_cbbTranThaiTimActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDichVu().setVisible(true);
            }
        });
    }

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
