/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.ChiTietThongKeController;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import response.ChiTietThanhToan.ChiTietTongTienTheoNgayResponse;
import service.IChiTietThongKeService;
import service.Impl.ChiTietThongKeServiceImpl;

/**
 *
 * @author Admin
 */
public class FromChiTietThongKe extends javax.swing.JFrame {
    
    private IChiTietThongKeService chiTietThongKeService = new ChiTietThongKeServiceImpl();
    private ChiTietThongKeController chiTietThongKeController = new ChiTietThongKeController();

    /**
     * Creates new form FromChiTietThongKe
     */
    public FromChiTietThongKe() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        chiTietThongKeController.thongKeNuocUong(jpn1);
        chiTietThongKeController.thongKeDoThue(jpn2);
        setTextDataTongTien();
    }
    
    public void setTextDataTongTien() {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse = chiTietThongKeService.chiTietTongTien();
        if (chiTietTongTienTheoNgayResponse == null) {
            txtBagCash.setText(txtBagCash.getText() + " " + "0.0 Vnd");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtTongTienCuaNgay.setText(txtTongTienCuaNgay.getText() + " " + strDate);
        } else {
            txtBagCash.setText(txtBagCash.getText() + " " + dinhDangTienTe(chiTietTongTienTheoNgayResponse.getTongtien()));
            txtTongTienCuaNgay.setText(txtTongTienCuaNgay.getText() + " " + chiTietTongTienTheoNgayResponse.getNgay() + "-" + chiTietTongTienTheoNgayResponse.getThang() + "-" + chiTietTongTienTheoNgayResponse.getNam());
        }

        //Get Tien Ngan Hang
        ChiTietTongTienTheoNgayResponse tongTienMat = chiTietThongKeService.getTongTienMat();
        if (tongTienMat == null) {
            txtCash.setText(txtCash.getText() + " " + "0.0 Vnd");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtTienMat.setText(txtTienMat.getText() + " " + strDate);
        } else {
            txtCash.setText(txtCash.getText() + " " + dinhDangTienTe(tongTienMat.getTongtien()));
            txtTienMat.setText(txtTienMat.getText() + " " + tongTienMat.getNgay() + "-" + tongTienMat.getThang() + "-" + tongTienMat.getNam());
            
        }
        //Get tong Tien Mat
        ChiTietTongTienTheoNgayResponse tongNganHang = chiTietThongKeService.getTongTienNganHang();
        if (tongNganHang == null) {
            txtCreditCash.setText(txtCreditCash.getText() + " " + "0.0 Vnd");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtNganHang.setText(txtNganHang.getText() + " " + strDate);
        } else {
            txtCreditCash.setText(txtCreditCash.getText() + " " + dinhDangTienTe(tongNganHang.getTongtien()));
            txtNganHang.setText(txtNganHang.getText() + " " + tongNganHang.getNgay() + "-" + tongNganHang.getThang() + "-" + tongNganHang.getNam());
        }
    }
    
    public void clearText() {
        txtBagCash.setText("Tổng Tiền:");
        txtTongTienCuaNgay.setText("Tổng Tiền Của Ngày:");
        txtCash.setText("Tổng Tiền:");
        txtTienMat.setText("Tổng Tiền Mặt Của Ngày:");
        txtCreditCash.setText("Tổng Tiền:");
        txtNganHang.setText("Tổng Tiền Chuyển Khoản Của Ngày:");
    }
    
    public String dinhDangTienTe(double tienTe) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(tienTe) + " " + "Vnd";
    }
    
    public void setTextDataTongTienByDate(Date date) {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse = chiTietThongKeService.chiTietTongTienByDate(date);
        clearText();
        if (chiTietTongTienTheoNgayResponse == null) {
            txtBagCash.setText(txtBagCash.getText() + " " + "0.0 Vnd");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtTongTienCuaNgay.setText(txtTongTienCuaNgay.getText() + " " + strDate);
        } else {
            txtBagCash.setText(txtBagCash.getText() + " " + dinhDangTienTe(chiTietTongTienTheoNgayResponse.getTongtien()));
            txtTongTienCuaNgay.setText(txtTongTienCuaNgay.getText() + " " + chiTietTongTienTheoNgayResponse.getNgay() + "-" + chiTietTongTienTheoNgayResponse.getThang() + "-" + chiTietTongTienTheoNgayResponse.getNam());
        }

        //Get Tien Ngan Hang
        ChiTietTongTienTheoNgayResponse tongTienMat = chiTietThongKeService.getTongTienMatByDate(date);
        if (tongTienMat == null) {
            txtCash.setText(txtCash.getText() + " " + "0.0 Vnd");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtTienMat.setText(txtTienMat.getText() + " " + strDate);
        } else {
            txtCash.setText(txtCash.getText() + " " + dinhDangTienTe(tongTienMat.getTongtien()));
            txtTienMat.setText(txtTienMat.getText() + " " + tongTienMat.getNgay() + "-" + tongTienMat.getThang() + "-" + tongTienMat.getNam());
            
        }
        //Get tong Tien Mat
        ChiTietTongTienTheoNgayResponse tongNganHang = chiTietThongKeService.getTongTienNganHangByDate(date);
        if (tongNganHang == null) {
            txtCreditCash.setText(txtCreditCash.getText() + " " + "0.0 Vnd");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(date);
            txtNganHang.setText(txtNganHang.getText() + " " + strDate);
        } else {
            txtCreditCash.setText(txtCreditCash.getText() + " " + String.valueOf(tongNganHang.getTongtien()));
            txtNganHang.setText(txtNganHang.getText() + " " + tongNganHang.getNgay() + "-" + tongNganHang.getThang() + "-" + tongNganHang.getNam());
        }
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
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNganHang = new javax.swing.JLabel();
        txtCreditCash = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTienMat = new javax.swing.JLabel();
        txtCash = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtBagCash = new javax.swing.JLabel();
        txtTongTienCuaNgay = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jpn1 = new javax.swing.JPanel();
        jpn2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 228, 229));

        jPanel1.setBackground(new java.awt.Color(65, 147, 169));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Chọn Ngày");

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(887, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));

        txtNganHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNganHang.setText("Tổng Tiền Chuyển Khoản Của Ngày :");

        txtCreditCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCreditCash.setText("Tổng Tiền:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCreditCash)
                    .addComponent(txtNganHang))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtNganHang)
                .addGap(34, 34, 34)
                .addComponent(txtCreditCash)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        txtTienMat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienMat.setText("Tổng Tiền Mặt Của Ngày:");

        txtCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCash.setText("Tổng Tiền:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCash)
                    .addComponent(txtTienMat))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtTienMat)
                .addGap(41, 41, 41)
                .addComponent(txtCash)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 0, 0));

        txtBagCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBagCash.setText("Tổng Tiền:");

        txtTongTienCuaNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongTienCuaNgay.setText("Tổng Tiền Của Ngày:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBagCash)
                    .addComponent(txtTongTienCuaNgay))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtTongTienCuaNgay)
                .addGap(41, 41, 41)
                .addComponent(txtBagCash)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jpn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpn1Layout = new javax.swing.GroupLayout(jpn1);
        jpn1.setLayout(jpn1Layout);
        jpn1Layout.setHorizontalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        jpn1Layout.setVerticalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpn2Layout = new javax.swing.GroupLayout(jpn2);
        jpn2.setLayout(jpn2Layout);
        jpn2Layout.setHorizontalGroup(
            jpn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        jpn2Layout.setVerticalGroup(
            jpn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jpn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(65, 147, 169));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thoát");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        txtBagCash.setText(txtBagCash.getText() + " " + jdate.getDate());
        if (jdate.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời chọn ngày");
        } else {
            setTextDataTongTienByDate(jdate.getDate());
            chiTietThongKeController.thongKeNuocUongByDate(jpn1, jdate.getDate());
            chiTietThongKeController.thongKeDoThueByDate(jpn2, jdate.getDate());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FromChiTietThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromChiTietThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromChiTietThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromChiTietThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromChiTietThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JPanel jpn1;
    private javax.swing.JPanel jpn2;
    private javax.swing.JLabel txtBagCash;
    private javax.swing.JLabel txtCash;
    private javax.swing.JLabel txtCreditCash;
    private javax.swing.JLabel txtNganHang;
    private javax.swing.JLabel txtTienMat;
    private javax.swing.JLabel txtTongTienCuaNgay;
    // End of variables declaration//GEN-END:variables
}
