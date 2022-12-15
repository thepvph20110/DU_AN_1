/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.Ca;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiCa;
import enumclass.trangThaiSanCa;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLCa;
import repository.ISanBongRepository;
import repository.ISanCaRepository;
import repository.impl.SanBongRepository;
import repository.impl.SanCaRepository;
import service.ICaService;
import service.Impl.CaServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnQuanLyCa extends javax.swing.JPanel {

    private List<QLCa> listQLCa;
    private DefaultTableModel dtm;
    private ICaService ics = new CaServiceImpl();
    private ISanBongRepository sanBongRepository = new SanBongRepository();
    private ISanCaRepository sanCaRepository = new SanCaRepository();

    public JpnQuanLyCa() {
        initComponents();
        listQLCa = new ArrayList<>();
        jTable1.setModel(dtm = new DefaultTableModel());
        String[] header = {"Mã Ca", "Tên Ca", "TG Bắt Đầu", "TG Kết Thúc", "Giá Ca", "Trạng Thái"};
        dtm.setColumnIdentifiers(header);
        listQLCa = ics.getAll();
//        txtMaCa.disable();
        txtMaCa.setEditable(false);
        showData(listQLCa);
    }

    private QLCa mountClick() {
        int row = jTable1.getSelectedRow();
        return listQLCa.get(row);
    }

    private void showData(List<QLCa> listQL) {
        dtm.setRowCount(0);
        for (QLCa qLCa : listQL) {
            dtm.addRow((Object[]) qLCa.toDataRow());
        }
    }

    private void fillData(int index) {
        QLCa qLCa = listQLCa.get(index);
        txtGiaCa.setText(String.valueOf(qLCa.getGiaCa()));
        txtMaCa.setText(qLCa.getMaCa());
        txtTenCa.setText(qLCa.getTenCa());
        txtTGKetThuc.setText(String.valueOf(qLCa.getThoiGianKetThuc()));
        txtThoiGianBD.setText(String.valueOf(qLCa.getThoiGianBatDau()));
        if (qLCa.getTrangThai() == trangThaiCa.GIO_CAO_DIEM) {
            radioGioCaoDiem.setSelected(true);
        } else {
            radioGioBinhThuong.setSelected(true);
        }
    }

    private void save() {
        String tenCa = txtTenCa.getText();
        String thoiGianBatDau = txtThoiGianBD.getText();
        String thoiGianKetThuc = txtTGKetThuc.getText();
        String gia = txtGiaCa.getText();
        QLCa qlCa = new QLCa();
        if (radioGioBinhThuong.isSelected()) {
            qlCa.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        } else {
            qlCa.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        }
        if (tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else if (gia.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Gia la so");
        } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
        } else if ((Double.valueOf(gia) <= 0)) {
            JOptionPane.showMessageDialog(this, "Gia san sai dinh dang");
        } else {
            QLCa qLCa = new QLCa(null, ics.genMaCa(), tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
            JOptionPane.showMessageDialog(this, ics.save(qLCa));
            listQLCa = ics.getAll();
            showData(listQLCa);
        }
    }

    private void saveNewCa() {
        String id = UUID.randomUUID().toString();
        String maCa = txtMaCa.getText();
        String tenCa = txtTenCa.getText();
        String thoiGianBatDau = txtThoiGianBD.getText();
        String thoiGianKetThuc = txtTGKetThuc.getText();
        String gia = txtGiaCa.getText();
        Ca qlCa = new Ca();
        if (radioGioBinhThuong.isSelected()) {
            qlCa.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        } else {
            qlCa.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        }
        if (tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else if (gia.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Gia la so");
        } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
        } else if ((Double.valueOf(gia) <= 0)) {
            JOptionPane.showMessageDialog(this, "Gia san sai dinh dang");
        } else {
            Ca ca = new Ca(id, ics.genMaCa(), tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
            JOptionPane.showMessageDialog(this, ics.saveNewCa(ca));
            listQLCa = ics.getAll();
            showData(listQLCa);
            for (SanBong sb : sanBongRepository.getAll()) {
                SanCa sanCa = new SanCa(null, ca, sb, new Date(), ca.getGiaCa() + sb.getGiaSan(), trangThaiSanCa.DANG_TRONG);
                sanCaRepository.save(sanCa);
            }
        }
    }

    private void update() {
        String maCa = txtMaCa.getText().trim();
        String tenCa = txtTenCa.getText().trim();
        String thoiGianBatDau = txtThoiGianBD.getText().trim();
        String thoiGianKetThuc = txtTGKetThuc.getText().trim();
        String gia = txtGiaCa.getText().trim();
        QLCa qlCa = new QLCa();
        if (radioGioBinhThuong.isSelected()) {
            qlCa.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        } else {
            qlCa.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ???");

        } else {
            if (tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
                JOptionPane.showMessageDialog(this, "IsEmpty");
            } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
                JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
            } else if (gia.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(this, "Gia la so");
            } else if ((Double.valueOf(gia) <= 0)) {
                JOptionPane.showMessageDialog(this, "Gia san sai dinh dang");
            } else {
                QLCa qLCa = new QLCa(mountClick().getId(), ics.genMaCa(), tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
                JOptionPane.showMessageDialog(this, ics.update(qLCa));
                listQLCa = ics.getAll();
                showData(listQLCa);
            }
        }
    }

    private void delete() {
        String maCa = txtMaCa.getText();
        String tenCa = txtTenCa.getText();
        String thoiGianBatDau = txtThoiGianBD.getText();
        String thoiGianKetThuc = txtTGKetThuc.getText();
        String gia = txtGiaCa.getText();
        QLCa qlCa = new QLCa();
        if (radioGioBinhThuong.isSelected()) {
            qlCa.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        } else {
            qlCa.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        }
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selected row ???");

        } else {
            QLCa qLCa = new QLCa(mountClick().getId(), ics.genMaCa(), tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
            JOptionPane.showMessageDialog(this, ics.delete(qLCa));
            listQLCa = ics.getAll();
            showData(listQLCa);
        }
    }

    private void xoaSan() {
        JOptionPane.showMessageDialog(null, ics.xoaCa(mountClick().getId()));
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
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaCa = new javax.swing.JTextField();
        txtThoiGianBD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenCa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTGKetThuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaCa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        radioGioBinhThuong = new javax.swing.JRadioButton();
        radioGioCaoDiem = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(65, 147, 169));
        setPreferredSize(new java.awt.Dimension(1351, 690));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quản Lí Ca");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Ca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã Ca");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("TG Bắt Đầu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên Ca");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("TG Kết Thúc");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Giá Ca");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái");

        buttonGroup1.add(radioGioBinhThuong);
        radioGioBinhThuong.setSelected(true);
        radioGioBinhThuong.setText("Giờ Bình Thường");

        buttonGroup1.add(radioGioCaoDiem);
        radioGioCaoDiem.setText("Giờ Cao Điểm");

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

        btnUpdate.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Cập Nhập");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenCa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiGianBD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTGKetThuc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioGioBinhThuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(radioGioCaoDiem))
                            .addComponent(txtGiaCa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaCa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtThoiGianBD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTGKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGiaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(radioGioBinhThuong)
                            .addComponent(radioGioCaoDiem))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(596, 596, 596)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listQLCa.clear();
        listQLCa = ics.searchByName(txtSearch.getText());
        showData(listQLCa);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveNewCa();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        xoaSan();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioGioBinhThuong;
    private javax.swing.JRadioButton radioGioCaoDiem;
    private javax.swing.JTextField txtGiaCa;
    private javax.swing.JTextField txtMaCa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTGKetThuc;
    private javax.swing.JTextField txtTenCa;
    private javax.swing.JTextField txtThoiGianBD;
    // End of variables declaration//GEN-END:variables
}
