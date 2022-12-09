/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

/**
 *
 * @author ASUS
 */
public class JpnQuanLyCa extends javax.swing.JPanel {

    /**
     * Creates new form JpnQuanLyCa
     */
    public JpnQuanLyCa() {
        initComponents();
<<<<<<< HEAD
=======
        listQLCa = new ArrayList<>();
        jTable1.setModel(dtm = new DefaultTableModel());
        String[] header = {"Mã Ca", "Tên Ca", "TG Bắt Đầu", "TG Kết Thúc", "Giá Ca", "Trạng Thái"};
        dtm.setColumnIdentifiers(header);
        listQLCa = ics.getAll();
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
        txtMaCa.setText(qLCa.getTenCa());
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
        if (maCa.length() == 0 || tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else if (!gia.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(this, "Please enter number Gia");
        } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
        } else {
            QLCa qLCa = new QLCa(null, maCa, tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
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
        if (maCa.length() == 0 || tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else if (!gia.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(this, "Please enter number Gia");
        } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
        } else {
            Ca ca = new Ca(id, maCa, tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
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
            if (maCa.length() == 0 || tenCa.length() == 0 || thoiGianBatDau.length() == 0 || thoiGianKetThuc.length() == 0 || gia.length() == 0) {
                JOptionPane.showMessageDialog(this, "IsEmpty");
            } else if (!thoiGianBatDau.matches("^\\d{2}:\\d{2}:\\d{2}$") || !thoiGianKetThuc.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
                JOptionPane.showMessageDialog(this, "Incorrect format time (hh:mm:ss)");
            } else {
                QLCa qLCa = new QLCa(mountClick().getId(), maCa, tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
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
            QLCa qLCa = new QLCa(mountClick().getId(), maCa, tenCa, Time.valueOf(thoiGianBatDau), Time.valueOf(thoiGianKetThuc), Double.valueOf(gia), qlCa.getTrangThai());
            JOptionPane.showMessageDialog(this, ics.delete(qLCa));
            listQLCa = ics.getAll();
            showData(listQLCa);
        }
    }

    private void xoaSan() {
        JOptionPane.showMessageDialog(null, ics.xoaCa(mountClick().getId()));
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Quản Lý Ca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel1)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(595, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
