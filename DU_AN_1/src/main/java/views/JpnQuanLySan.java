/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.Ca;
import domainmodel.LoaiSan;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiSanBong;
import enumclass.trangThaiSanCa;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLCa;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import repository.ICaRepository;
import repository.ILoaiSanRepository;
import repository.ISanCaRepository;
import repository.impl.CaRepository;
import repository.impl.LoaiSanRepository;
import repository.impl.SanCaRepository;
import service.ICaService;
import service.ILoaiSanService;
import service.ISanBongService;
import service.ISanCaService;
import service.Impl.CaServiceImpl;
import service.Impl.LoaiSanServiceImpl;
import service.Impl.SanBongServiceImpl;
import service.Impl.SanCaServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnQuanLySan extends javax.swing.JPanel {

    private List<QLLoaiSan> listQLLoaiSan = new ArrayList<>();
    private List<QLSanBong> listQLSanBong = new ArrayList<>();
    private ILoaiSanService iLoaiSanService = new LoaiSanServiceImpl();
    private ISanBongService iSanBongService = new SanBongServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private ICaRepository caRepository = new CaRepository();
    private ISanCaRepository sanCaRepository = new SanCaRepository();
    private Map<String, Object> mapLoaiSan = new HashMap<>();
    private ILoaiSanRepository loaiSanRepository = new LoaiSanRepository();

    public JpnQuanLySan() {
        initComponents();
        jTable1.setModel(dtm);
        String[] header = {"Giá sân", "Mã sân", "Sức chứa", "Tên sân", "Trạng thái", "Loại Sân"};
        dtm.setColumnIdentifiers(header);
        listQLLoaiSan = iLoaiSanService.getAll();
        listQLSanBong = iSanBongService.getAll();
        loadCbbLoaiSan();
//        txtMaSanBong.disable();
        txtMaSanBong.setEditable(false);
        showData(listQLSanBong);
        List<LoaiSan> listLoaiSan = loaiSanRepository.getAll();
        for (LoaiSan loaiSan : listLoaiSan) {
            mapLoaiSan.put(loaiSan.getTenLoaiSan(), loaiSan);
            mapLoaiSan.put(loaiSan.getMaLoaiSan(), loaiSan);
        }
    }

    private QLSanBong mountClick() {
        int row = jTable1.getSelectedRow();
        return listQLSanBong.get(row);
    }

    private void showData(List<QLSanBong> listQLSanBong) {
        dtm.setRowCount(0);
        for (QLSanBong qLSanBong : listQLSanBong) {
            dtm.addRow(qLSanBong.toDataRow());
        }
    }

    private void loadCbbLoaiSan() {
        for (QLLoaiSan qLLoaiSan : listQLLoaiSan) {
            cbbLoaiSan.addItem(qLLoaiSan.getTenLoaiSan());
        }
    }

    private void save() {
        String id = UUID.randomUUID().toString();
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        SanBong qlsb = new SanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        for (QLSanBong qlSan : listQLSanBong) {
            if (tenSanBong.equalsIgnoreCase(qlSan.getTenSanBong())) {
                JOptionPane.showMessageDialog(this, "Tên sân trùng");
                return;
            }
        }
        if (tenSanBong.length() == 0 || giaSan.length() == 0 || sucChua.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        } else if (sucChua.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Sức chứa là số");
        } else if (giaSan.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Giá sân là số");
        } else if ((Double.valueOf(giaSan) <= 0)) {
            JOptionPane.showMessageDialog(this, "Giá sân sai định dạng");
        } else if ((Integer.valueOf(sucChua) <= 0)) {
            JOptionPane.showMessageDialog(this, "Sức chứa sai định dạng");
        } else {
            LoaiSan loaiSan = iLoaiSanService.getOne(cbbLoaiSan.getSelectedItem().toString());
            SanBong sanBong = new SanBong(id, iSanBongService.genMaSanBong(), tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), loaiSan, qlsb.getTrangThai());
            JOptionPane.showMessageDialog(null, iSanBongService.saveSanBong(sanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);
            for (Ca ca : caRepository.getAll()) {
                SanCa sanCa = new SanCa(null, ca, sanBong, new Date(), ca.getGiaCa() + sanBong.getGiaSan(), trangThaiSanCa.DANG_TRONG);
                sanCaRepository.save(sanCa);
            }

        }
    }

    private void update() {
        String maSanBong = txtMaSanBong.getText().trim();
        String tenSanBong = txtTenSanBong.getText().trim();
        String giaSan = txtGiaSan.getText().trim();
        String sucChua = txtSucChua.getText().trim();
        QLSanBong qlsb = new QLSanBong();
        if (radioHoatDong.isSelected()) {
            qlsb.setTrangThai(trangThaiSanBong.HOAT_DONG);
        } else {
            qlsb.setTrangThai(trangThaiSanBong.SUA_CHUA);
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected Row ???");
        } else {
            if (tenSanBong.length() == 0 || giaSan.length() == 0 || sucChua.length() == 0) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
            } else if (sucChua.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(this, "Sức chứa là số");
            } else if (giaSan.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(this, "Giá sân là số");
            } else if ((Double.valueOf(giaSan) <= 0)) {
                JOptionPane.showMessageDialog(this, "Giá sân sai định dạng");
            } else if ((Integer.valueOf(sucChua) <= 0)) {
                JOptionPane.showMessageDialog(this, "Sức chứa sai định dạng");
            } else {
                QLSanBong qLSanBong = new QLSanBong(mountClick().getId(), iSanBongService.genMaSanBong(), tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), cbbLoaiSan.getSelectedItem().toString(), qlsb.getTrangThai());
                JOptionPane.showMessageDialog(this, iSanBongService.update(qLSanBong));
                listQLSanBong = iSanBongService.getAll();
                showData(listQLSanBong);
            }
        }

    }

    private void delete() {
        LoaiSan loaiSan = new LoaiSan();
        if (mapLoaiSan.containsKey(mountClick().getTenLoaiSan())) {
            loaiSan = (LoaiSan) mapLoaiSan.get(mountClick().getTenLoaiSan());
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected Row ???");
        } else {
            SanBong sanBong = new SanBong(mountClick().getId(), mountClick().getMaSanBong(), mountClick().getTenSanBong(), mountClick().getGiaSan(), mountClick().getSucChua(), loaiSan, mountClick().getTrangThai());
            JOptionPane.showMessageDialog(null, iSanBongService.deleteSanBongNew(sanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);
        }
    }

    private void xoaSan() {
        JOptionPane.showMessageDialog(null, iSanBongService.xoaSan(mountClick().getId()));
        listQLSanBong = iSanBongService.getAll();
        showData(listQLSanBong);
    }

    private void fillData(int index) {
        QLSanBong qlsb = listQLSanBong.get(index);
        txtGiaSan.setText(String.valueOf(qlsb.getGiaSan()));
        txtSucChua.setText(String.valueOf(qlsb.getSucChua()));
        txtMaSanBong.setText(qlsb.getMaSanBong());
        txtTenSanBong.setText(qlsb.getTenSanBong());
        if (qlsb.getTrangThai() == trangThaiSanBong.HOAT_DONG) {
            radioHoatDong.setSelected(true);
        } else {
            radioSuaChua.setSelected(true);
        }
        cbbLoaiSan.setSelectedItem(qlsb.getTenLoaiSan());
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSanBong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaSan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenSanBong = new javax.swing.JTextField();
        cbbLoaiSan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        radioSuaChua = new javax.swing.JRadioButton();
        radioHoatDong = new javax.swing.JRadioButton();
        txtSucChua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(65, 147, 169));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Sân Bóng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Sân Bóng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã sân bóng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Giá sân");

        txtGiaSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaSanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên sân bóng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sức chứa");

        btnUpdate.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Cập Nhập");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Thêm");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái");

        buttonGroup1.add(radioSuaChua);
        radioSuaChua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioSuaChua.setSelected(true);
        radioSuaChua.setText("Sửa chữa");

        buttonGroup1.add(radioHoatDong);
        radioHoatDong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioHoatDong.setText("Hoạt động");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Loại Sân");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setForeground(new java.awt.Color(242, 242, 242));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tìm Kiếm Sân");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioSuaChua)
                                .addGap(93, 93, 93)
                                .addComponent(radioHoatDong))
                            .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbLoaiSan, 0, 294, Short.MAX_VALUE)
                            .addComponent(txtTenSanBong)
                            .addComponent(txtMaSanBong))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSanBong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLoaiSan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(radioSuaChua)
                            .addComponent(radioHoatDong))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGiaSan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(552, 552, 552))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listQLSanBong.clear();
        listQLSanBong = iSanBongService.searchByName(txtSearch.getText());
        showData(listQLSanBong);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            save();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa đổi sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sân?", null, JOptionPane.YES_NO_OPTION);
        if (chon == 0) {
            xoaSan();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtGiaSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaSanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaSanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLoaiSan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioHoatDong;
    private javax.swing.JRadioButton radioSuaChua;
    private javax.swing.JTextField txtGiaSan;
    private javax.swing.JTextField txtMaSanBong;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSucChua;
    private javax.swing.JTextField txtTenSanBong;
    // End of variables declaration//GEN-END:variables
}
