/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

/**
 *
 * @author ASUS
 */
public class JpnQuanLySan extends javax.swing.JPanel {

    /**
     * Creates new form JpnQuanLySan
     */
    public JpnQuanLySan() {
        initComponents();
<<<<<<< HEAD
=======
        jTable1.setModel(dtm);
        String[] header = {"Giá sân", "Mã sân", "Sức chứa", "Tên sân", "Trạng thái", "Loại Sân"};
        dtm.setColumnIdentifiers(header);
        listQLLoaiSan = iLoaiSanService.getAll();
        listQLSanBong = iSanBongService.getAll();
        loadCbbLoaiSan();
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
        if (maSanBong.length() == 0 || tenSanBong.length() == 0 || giaSan.length() == 0 || sucChua.length() == 0) {
            JOptionPane.showMessageDialog(this, "IsEmpty");
        } else {
            LoaiSan loaiSan = iLoaiSanService.getOne(cbbLoaiSan.getSelectedItem().toString());
            SanBong sanBong = new SanBong(id, maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), loaiSan, qlsb.getTrangThai());
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

            QLSanBong qLSanBong = new QLSanBong(mountClick().getId(), maSanBong, tenSanBong, Double.valueOf(giaSan), Integer.valueOf(sucChua), cbbLoaiSan.getSelectedItem().toString(), qlsb.getTrangThai());
            JOptionPane.showMessageDialog(this, iSanBongService.update(qLSanBong));
            listQLSanBong = iSanBongService.getAll();
            showData(listQLSanBong);

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

        setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setText("Quản Lý Sân");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel1)
                .addContainerGap(411, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(599, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
