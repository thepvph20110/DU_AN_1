/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.pdf.BaseFont;
import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.HoaDon;
import domainmodel.HoaDonThanhToan;
import domainmodel.PhuPhi_HoaDon;
import domainmodel.SanCa;
import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiDichVu;
import enumclass.trangThaiHoaDon;
import enumclass.trangThaiSanCa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLDoThue;
import modelview.QLHoaDon;
import modelview.QLHoaDon_PhuPhi;
import modelview.QLNuocUong;
import modelview.QLPhuPhi;
import modelview.QLThanhToan;
import repository.IDichVuRepository;
import repository.impl.DichVuRepositoryImpl;
import repository.impl.DoThueRepositoryImpl;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.HoaDonThanhToanRepositoryImpl;
import repository.impl.NuocUongRepositoryImpl;
import repository.impl.SanCaRepository;
import repository.impl.ThanhToanRepository;
import service.IDoThueService;
import service.IHoaDonService;
import service.INuocUongService;
import service.IPhuPhiService;
import service.IThanhToanService;
import service.Impl.DoThueServiceImpl;
import service.Impl.HoaDonPhuPhiServiceImpl;
import service.Impl.HoaDonServiceImpl;
import service.Impl.NuocUongServiceImpl;
import service.Impl.PhuPhiServiceImpl;
import service.Impl.ThanhToanServiceImpl;

/**
 *
 * @author Admin
 */
public class FrmThanhToan extends javax.swing.JFrame {

    double giaCa;
    private QLHoaDon qLHoaDon;
    private DefaultComboBoxModel dcbmTT = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmPP = new DefaultComboBoxModel();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmDV = new DefaultTableModel();
    private DefaultTableModel dtmCTDV = new DefaultTableModel();
    private List<QLHoaDon> qLHoaDons = new ArrayList<>();
    private IHoaDonService iHoaDonService = new HoaDonServiceImpl();

    private List<DichVu> listDV = new ArrayList<>();
    private IDichVuRepository dichVuRepository = new DichVuRepositoryImpl();

    private IThanhToanService iThanhToanService = new ThanhToanServiceImpl();
    private List<QLThanhToan> qLThanhToans = new ArrayList<>();

    private List<QLNuocUong> listNC = new ArrayList<>();
    private INuocUongService nuocUongService = new NuocUongServiceImpl();

    private List<QLDoThue> listDT = new ArrayList<>();
    private IDoThueService doThueService = new DoThueServiceImpl();

    private IPhuPhiService phuPhiService = new PhuPhiServiceImpl();
    private List<QLPhuPhi> qLPhuPhis = new ArrayList<>();
    public static final String pathUnicode = "font\\unicode.ttf";

    /**
     * Creates new form FrmThanhToan
     */
    public FrmThanhToan(QLHoaDon qLHoaDon) {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.qLHoaDon = qLHoaDon;
        jTable1.setModel(dtm);
        jtbDichVu.setModel(dtmDV);
        jtbChiTietDichVu.setModel(dtmCTDV);
        String headers[] = {"Mã Hóa Đơn", "Tên Tài Khoản", "Tên Khách Hàng", "SDT", "Tiền Sân", "Ngày Tạo Phiếu", "Trạng Thái"};
        String headersDV[] = {"Mã", "Tên", "Giá"};
        String headersCTDV[] = {"Mã", "Tên", "Số Lượng", "Giá", "Thành Tiền"};
        dtm.setColumnIdentifiers(headers);
        dtmDV.setColumnIdentifiers(headersDV);
        dtmCTDV.setColumnIdentifiers(headersCTDV);
        jTen.setText(qLHoaDon.getPhieuDatLich().getKhachHang().getTenKhachHang());
        jtenSan.setText(qLHoaDon.getPhieuDatLich().getSanCa().getSanbong().getTenSanBong());
        txtCa.setText(qLHoaDon.getPhieuDatLich().getSanCa().getCa().getTenCa());
        listDV = dichVuRepository.findByIdHoaDon(qLHoaDon.getId());
        jcbThanhToan.setModel(dcbmTT);
        qLThanhToans = iThanhToanService.getAllThanhToans();
        jcbPhuPhi.setModel(dcbmPP);
        for (QLThanhToan lThanhToan : qLThanhToans) {
            dcbmTT.addElement(lThanhToan.getHinhThanhToan());
        }
        if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Chuyen_Khoan) {
            txtNganHang.setEnabled(true);
            txtTienKhach.setEnabled(false);
        } else if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Tien_Mat) {
            txtTienKhach.setEnabled(true);
            txtNganHang.setEnabled(false);
        }
        txtTongTien.setText(String.valueOf(fillGia()));
        listNC = nuocUongService.getNuocUongNoPagination();
        loadCBPhuPhi();
        addDataRowNuocUong(listNC);
        addDataRow(qLHoaDon);
        addDataRowDichVu(listDV);
    }

    public void loadCBPhuPhi() {
        dcbmPP.removeAllElements();
        qLPhuPhis = phuPhiService.getAllQLPhuPhis();
        for (QLPhuPhi qLPhuPhi : qLPhuPhis) {
            dcbmPP.addElement(qLPhuPhi.getTenPhuPhi());
        }
    }

    public double fillGia() {
        giaCa = qLHoaDon.getPhieuDatLich().getTongTienSan();
        Set<DichVu> dichVus = iHoaDonService.findByHoaDonId(qLHoaDon.getId()).getDichVu();
        List<DichVu> listDV = new ArrayList<>();
        listDV.addAll(dichVus);
        for (DichVu dichVu : listDV) {
            if (dichVu.getNuocUong() != null) {
                giaCa += dichVu.getSoLuongNuocUong() * dichVu.getNuocUong().getGia();
            }
            if (dichVu.getDoThue() != null) {
                giaCa += dichVu.getSoLuongDoThue() * dichVu.getDoThue().getDonGia();
            }
        }

        Set<PhuPhi_HoaDon> phuPhi_HoaDons = iHoaDonService.findByHoaDonId(qLHoaDon.getId()).getPhuPhi();
        List<PhuPhi_HoaDon> listHDTT = new ArrayList<>();
        listHDTT.addAll(phuPhi_HoaDons);
        for (PhuPhi_HoaDon phi_HoaDon : listHDTT) {
            giaCa += phi_HoaDon.getGiaPPHD();
        }
        return giaCa;
    }

    public void addDataRow(QLHoaDon qLHoaDon) {
        dtm.setRowCount(0);
        dtm.addRow(qLHoaDon.toDataRow());
    }

    public void addDataRowDichVu(List<DichVu> listDV) {
        dtmCTDV.setRowCount(0);
        for (DichVu dichVu : listDV) {
            if (dichVu.getNuocUong() != null) {
                Object[] data = {dichVu.getMaDichVu(), dichVu.getNuocUong().getTenNuocUong(), dichVu.getSoLuongNuocUong(),
                    dichVu.getNuocUong().getGia(), dichVu.getNuocUong().getGia() * dichVu.getSoLuongNuocUong()};
                dtmCTDV.addRow(data);
            }

            if (dichVu.getDoThue() != null) {
                Object[] data = {dichVu.getMaDichVu(), dichVu.getDoThue().getTenDoThue(), dichVu.getSoLuongDoThue(),
                    dichVu.getDoThue().getDonGia(), dichVu.getDoThue().getDonGia() * dichVu.getSoLuongDoThue()};
                dtmCTDV.addRow(data);
            }
        }
    }

    public void addDataRowNuocUong(List<QLNuocUong> listNC) {
        dtmDV.setRowCount(0);
        for (QLNuocUong qLNuocUong : listNC) {
            dtmDV.addRow(qLNuocUong.toRowDataNuocUong());
        }
    }

    public void addDataRowDoThue(List<QLDoThue> listDT) {
        dtmDV.setRowCount(0);
        for (QLDoThue qLDoThue : listDT) {
            dtmDV.addRow(qLDoThue.toRowDataDoThue());
        }
    }

    public String createFilePDF() {
        String headerPDF[] = {"Mã", "Tên", "Số Lượng", "Giá", "Thành Tiền"};
//        String headerTBDichVu[] = {"Mã", "Tên", "Số Lượng", "Giá", "Thành Tiền"};
        String diaChi = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            diaChi = j.getSelectedFile().getPath();
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(new Date());
            String path = "D:\\DAN1_BLOCK2\\HoaDon_" + date + ".pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            float col = 280f;
            float columWidth[] = {col, col};

            PdfFont font = PdfFontFactory.createFont(pathUnicode, BaseFont.IDENTITY_H);

            Table table = new Table(columWidth);
            table.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE);
            table.setFont(font);

            table.addCell(new Cell().add("DongDe Stadium").setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setFontSize(30f)
                    .setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Mã hóa đơn: " + jTable1.getValueAt(0, 0).toString() + "\nD/C: FPT, Nam Từ Liêm, Hà Nôi\n LH: Sỹ Gà - 0915288985 ").setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));

            float colWidth[] = {220, 110, 200, 200};
            Table customerInforTable = new Table(colWidth);
            customerInforTable.setFont(font);
            customerInforTable.addCell(new Cell(0, 4)
                    .add("Thông tin khách hàng").setBold().setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Họ tên KH:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + jTen.getText()).setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Họ Tên NV:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("" + jTable1.getValueAt(0, 1).toString()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            customerInforTable.addCell(new Cell().add("Số điện thoại:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + jTable1.getValueAt(0, 3).toString()).setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            customerInforTable.addCell(new Cell().add("Tên Sân: ").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + jtenSan.getText()).setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Ngày thanh toán:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("" + date).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            customerInforTable.addCell(new Cell().add("Ca số: ").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + txtCa.getText()).setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            customerInforTable.addCell(new Cell().add("Tiền Sân: ").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + jTable1.getValueAt(0, 4).toString()).setBorder(Border.NO_BORDER));

            float itemColWidth[] = {132, 132, 132, 132, 132};
            Table itemTable = new Table(itemColWidth);
            itemTable.setFont(font);

            for (int i = 0; i < headerPDF.length; i++) {
                itemTable.addCell(new Cell().add("" + headerPDF[i]).setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            }

            for (int v = 0; v < jtbChiTietDichVu.getRowCount(); v++) {
                for (int y = 0; y < headerPDF.length; y++) {
                    itemTable.addCell("" + jtbChiTietDichVu.getValueAt(v, y).toString());
                }
            }
//            itemTable.addCell("");

            List<QLHoaDon> qlHoaDons = iHoaDonService.getAll();
            String maSan = null;
            for (QLHoaDon hd : qlHoaDons) {
                if (jtenSan.getText().equals(hd.getPhieuDatLich().getSanCa().getSanbong().getTenSanBong())) {
                    maSan = hd.getPhieuDatLich().getSanCa().getSanbong().getMaSanBong();
                }
            }
            itemTable.addCell("" + maSan);
            itemTable.addCell("" + jtenSan.getText());
            itemTable.addCell("1");
            itemTable.addCell("" + jTable1.getValueAt(0, 4).toString());
            itemTable.addCell("" + jTable1.getValueAt(0, 4).toString());
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Chi Phí Phát Sinh ").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            if (txtGiaPhuPhi.getText() != null) {
                itemTable.addCell(new Cell().add("" + txtGiaPhuPhi.getText()).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            } else {
                int GiaPhuPhi = 0;
                itemTable.addCell(new Cell().add("" + GiaPhuPhi).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            }
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Tổng tiền").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("" + txtTongTien.getText() + " Vnd").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(customerInforTable);
            document.add(new Paragraph("\n"));
            document.add(itemTable);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Cảm Ơn Quý Khách !!!!").setFont(font));
            document.close();
            return "Xuất File Thành Công";
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return "Xuất File Không Thành Công";
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

        jpopChiTietDV = new javax.swing.JPopupMenu();
        jMenuXoaDichVu = new javax.swing.JMenuItem();
        jMenuSuaSoLuong = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtenSan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbThanhToan = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTienKhach = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNganHang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPayBack = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnThanhToan1 = new javax.swing.JButton();
        jcbPhuPhi = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnAddPhuPhi = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtGiaPhuPhi = new javax.swing.JTextField();
        btnAddPP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbDichVu = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbDichVu = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChiTietDichVu = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        jMenuXoaDichVu.setText("Xóa Dịch Vụ");
        jMenuXoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuXoaDichVuActionPerformed(evt);
            }
        });
        jpopChiTietDV.add(jMenuXoaDichVu);

        jMenuSuaSoLuong.setText("Sửa Số Lượng");
        jMenuSuaSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSuaSoLuongActionPerformed(evt);
            }
        });
        jpopChiTietDV.add(jMenuSuaSoLuong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel4.setBackground(new java.awt.Color(204, 153, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Chi Tiết Đặt Sân");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 9, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách:");

        jTen.setText("Nguyễn Đình Cao");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Hóa Đơn Chi Tiết");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tên Sân:");

        jtenSan.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ca:");

        txtCa.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTen)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtenSan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCa)
                        .addGap(145, 145, 145))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTen)
                    .addComponent(jLabel6)
                    .addComponent(jtenSan)
                    .addComponent(jLabel7)
                    .addComponent(txtCa))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel5.setBackground(new java.awt.Color(204, 153, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(176, 176, 176))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 153));
        jLabel11.setText("Tổng Thanh Toán:");

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTongTien.setText("1000 VNĐ");

        jLabel13.setText("Hình Thức Thanh Toán");

        jcbThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbThanhToanActionPerformed(evt);
            }
        });

        jLabel14.setText("Tiền Khách Đưa");

        txtTienKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachKeyReleased(evt);
            }
        });

        jLabel15.setText("Tiền Ngân Hàng");

        txtNganHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNganHangKeyReleased(evt);
            }
        });

        jLabel16.setText("Trả Lại");

        btnThanhToan.setBackground(new java.awt.Color(204, 153, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnThanhToan1.setBackground(new java.awt.Color(204, 204, 0));
        btnThanhToan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan1.setText("Thoát");
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });

        jcbPhuPhi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Phụ Phí");

        btnAddPhuPhi.setBackground(new java.awt.Color(102, 102, 0));
        btnAddPhuPhi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddPhuPhi.setText("Thêm Phụ Phí");
        btnAddPhuPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhuPhiActionPerformed(evt);
            }
        });

        jLabel17.setText("Giá Phụ Phí");

        btnAddPP.setBackground(new java.awt.Color(204, 204, 0));
        btnAddPP.setText("+");
        btnAddPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jcbPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddPP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(42, 42, 42)
                        .addComponent(btnAddPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcbThanhToan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPayBack, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTongTien))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPayBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcbPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPhuPhi))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel6.setBackground(new java.awt.Color(204, 153, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Chi Tiết Dịch Vụ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 153, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Thêm Dịch Vụ");

        jLabel9.setText("Chọn Loại Dịch Vụ:");

        jcbDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nước Uống", "Đồ Thuê" }));
        jcbDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDichVuActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtbDichVu.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDichVuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbDichVu);

        jScrollPane3.setViewportView(jScrollPane4);

        jPanel8.setBackground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jtbChiTietDichVu.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbChiTietDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbChiTietDichVuMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChiTietDichVu);

        jScrollPane5.setViewportView(jScrollPane2);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Chi Tiet Dich Vu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Ban Có Muốn Thanh Toán Và In Hóa Đơn ???", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            HoaDon hoaDon = iHoaDonService.findByHoaDonId(qLHoaDon.getId());
            if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Chuyen_Khoan) {
                if (!txtNganHang.getText().isEmpty()) {
                    if (txtNganHang.getText().matches("-?\\d+(\\.\\d+)?")) {
                        ThanhToan tt = new ThanhToanRepository().findOneByTrangThai(loaiHinhThanhToan.Chuyen_Khoan);
                        HoaDonThanhToan hdtt = new HoaDonThanhToan(null, "HDTT003", hoaDon, tt, giaCa, null);
                        new HoaDonThanhToanRepositoryImpl().saveOrUpdate(hdtt);
                        JOptionPane.showMessageDialog(this, createFilePDF());
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không được để trống tiền ngân hàng");
                    return;
                }
            } else if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Tien_Mat) {
                if (!txtTienKhach.getText().isEmpty()) {
                    if (txtTienKhach.getText().isEmpty() || txtTienKhach.getText().matches("-?\\d+(\\.\\d+)?")) {
                        ThanhToan tt = new ThanhToanRepository().findOneByTrangThai(loaiHinhThanhToan.Tien_Mat);
                        HoaDonThanhToan hdtt = new HoaDonThanhToan(null, "HDTT003", hoaDon, tt, giaCa, null);
                        new HoaDonThanhToanRepositoryImpl().saveOrUpdate(hdtt);
                        JOptionPane.showMessageDialog(this, createFilePDF());
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự ");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không được để trống Tiền Khách");
                    return;
                }
            }
            SanCa sanCa = hoaDon.getPhieuDatLich().getSanCa();
            sanCa.setTrangThai(trangThaiSanCa.DANG_TRONG);
            new SanCaRepository().update(sanCa);
            hoaDon.setTongTien(giaCa);
            hoaDon.setTrangThai(trangThaiHoaDon.DA_THANH_TOAN);
            Date date = new Date();
            hoaDon.setNgayThanhToan(date);
            new HoaDonRepositoryImpl().update(hoaDon);
            FrmHoaDon frmHoaDon = new FrmHoaDon();
            frmHoaDon.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachKeyReleased
        // TODO add your handling code here:
        if (!txtTienKhach.getText().isEmpty()) {
            double tt = Double.parseDouble(txtTienKhach.getText()) - giaCa;
            if (tt >= 0) {
                txtPayBack.setText(String.valueOf(tt));
            } else {
                txtPayBack.setText("");
            }
        }
    }//GEN-LAST:event_txtTienKhachKeyReleased

    private void jcbThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbThanhToanActionPerformed
        // TODO add your handling code here:
        if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Chuyen_Khoan) {
            txtTienKhach.setEnabled(false);
            txtNganHang.setEnabled(true);
            txtTienKhach.setText("");
            txtNganHang.setText("");
            txtPayBack.setText("");
        } else if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.Tien_Mat) {
            txtTienKhach.setEnabled(true);
            txtNganHang.setEnabled(false);
            txtNganHang.setText("");
            txtTienKhach.setText("");
            txtPayBack.setText("");
        } else if (jcbThanhToan.getSelectedItem() == loaiHinhThanhToan.CHUYEN_KHOAN_VA_TIEN_MAT) {
            txtTienKhach.setEnabled(true);
            txtNganHang.setEnabled(true);
            txtNganHang.setText("");
            txtTienKhach.setText("");
            txtPayBack.setText("");
        }
    }//GEN-LAST:event_jcbThanhToanActionPerformed

    private void txtNganHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNganHangKeyReleased
        // TODO add your handling code here:
        if (!txtNganHang.getText().isEmpty()) {
            double tt = Double.parseDouble(txtNganHang.getText()) - giaCa;
            if (tt >= 0) {
                txtPayBack.setText(String.valueOf(tt));
            } else {
                txtPayBack.setText("");
            }
        }
    }//GEN-LAST:event_txtNganHangKeyReleased

    private void jMenuXoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuXoaDichVuActionPerformed
        // TODO add your handling code here:
        DichVu dichVu = dichVuRepository.findByIdHoaDon(qLHoaDon.getId()).get(jtbChiTietDichVu.getSelectedRow());
        if (dichVuRepository.delete(dichVu.getId())) {
            JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công");
            addDataRowDichVu(dichVuRepository.findByIdHoaDon(qLHoaDon.getId()));
            txtTongTien.setText(String.valueOf(fillGia()));
        }
    }//GEN-LAST:event_jMenuXoaDichVuActionPerformed

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        // TODO add your handling code here:
        FrmHoaDon frmHoaDon = new FrmHoaDon();
        frmHoaDon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    private void jMenuSuaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSuaSoLuongActionPerformed
        // TODO add your handling code here:
        DichVu dichVu = dichVuRepository.findByIdHoaDon(qLHoaDon.getId()).get(jtbChiTietDichVu.getSelectedRow());
        String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng Dịch Vụ !!");
        if (soLuong == null) {
            return;
        } else {
            if (soLuong.isEmpty() || !soLuong.matches("-?\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(rootPane, "Vui Long Nhập Số");
            } else {
                if (dichVu.getNuocUong() != null) {
                    dichVu.setSoLuongNuocUong(Integer.parseInt(soLuong));
                    dichVuRepository.saveOrUpdate(dichVu);
                    addDataRowDichVu(dichVuRepository.findByIdHoaDon(qLHoaDon.getId()));
                } else if (dichVu.getDoThue() != null) {
                    dichVu.setSoLuongDoThue(Integer.parseInt(soLuong));
                    dichVuRepository.saveOrUpdate(dichVu);
                    addDataRowDichVu(dichVuRepository.findByIdHoaDon(qLHoaDon.getId()));
                }
            }
        }
        txtTongTien.setText(String.valueOf(fillGia()));
    }//GEN-LAST:event_jMenuSuaSoLuongActionPerformed

    private void btnAddPhuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhuPhiActionPerformed
        // TODO add your handling code here
        if (jcbPhuPhi.getSelectedItem().equals("không có phụ phí")) {
            return;
        }
        String tenPP = JOptionPane.showInputDialog(rootPane, "Nhập Tên Phụ Phí !!");
        if (tenPP == null) {
            return;
        } else {
            if (tenPP.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Không Được Để Trống");
            } else {
                QLPhuPhi phuPhi = new QLPhuPhi(null, "PP001", tenPP);
                if (phuPhiService.save(phuPhi)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm Phụ Phí Thành Công");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thất Bại");
                }
            }
        }
        loadCBPhuPhi();
    }//GEN-LAST:event_btnAddPhuPhiActionPerformed

    private void jtbChiTietDichVuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChiTietDichVuMouseReleased
        // TODO add your handling code here:
        if (jtbChiTietDichVu.getSelectedRow() >= 0) {
            if (evt.isPopupTrigger()) {
                jpopChiTietDV.show(jScrollPane5, evt.getPoint().x, evt.getPoint().y);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Xin Mời Chọn!!!");
        }
    }//GEN-LAST:event_jtbChiTietDichVuMouseReleased

    private void jtbDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDichVuMouseClicked
        // TODO add your handling code here:
        if (jcbDichVu.getSelectedIndex() == 0) {
            QLNuocUong qLNuocUong = nuocUongService.getNuocUongNoPagination().get(jtbDichVu.getSelectedRow());
            if (dichVuRepository.findByIdHoaDonAndNuocUong(qLHoaDon.getId(), qLNuocUong.getId()).size() > 0) {
                DichVu dichVu = dichVuRepository.findByIdHoaDonAndNuocUong(qLHoaDon.getId(), qLNuocUong.getId()).get(0);
                String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng");
                if (soLuong == null || !soLuong.matches("-?\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự và để trống ");
                } else {
                    dichVu.setSoLuongNuocUong(dichVu.getSoLuongNuocUong() + Integer.parseInt(soLuong));
                    dichVuRepository.saveOrUpdate(dichVu);
                    listDV = dichVuRepository.findByIdHoaDon(qLHoaDon.getId());
                    addDataRowDichVu(listDV);
                    txtTongTien.setText(String.valueOf(fillGia()));
                }
            } else {
                String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng");
                if (soLuong == null || !soLuong.matches("-?\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự và để trống ");
                } else {
//                    DichVu dichVu = new DichVu(null, "DV008", null, 0, iHoaDonService.findByHoaDonId(qLHoaDon.getId()), new NuocUongRepositoryImpl().findByID(qLNuocUong.getId()),
//                            Integer.parseInt(soLuong), qLNuocUong.getGia(), null, trangThaiDichVu.Dang_Su_Dung);
//                    dichVuRepository.saveOrUpdate(dichVu);
//                    listDV = dichVuRepository.findByIdHoaDon(qLHoaDon.getId());
//                    addDataRowDichVu(listDV);
//                    txtTongTien.setText(String.valueOf(fillGia()));
                }
            }
        } else {
            QLDoThue qLDoThue = doThueService.getAll().get(jtbDichVu.getSelectedRow());
            if (dichVuRepository.findByIdHoaDonAndDoThue(qLHoaDon.getId(), qLDoThue.getId()).size() > 0) {
                DichVu dichVu = dichVuRepository.findByIdHoaDonAndDoThue(qLHoaDon.getId(), qLDoThue.getId()).get(0);
                String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng");
                if (soLuong == null || !soLuong.matches("-?\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự và để trống ");
                } else {
                    dichVu.setSoLuongDoThue(dichVu.getSoLuongDoThue() + Integer.parseInt(soLuong));
                    dichVuRepository.saveOrUpdate(dichVu);
                    listDV = dichVuRepository.findByIdHoaDon(qLHoaDon.getId());
                    addDataRowDichVu(listDV);
                    txtTongTien.setText(String.valueOf(fillGia()));
                }
            } else {
                String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng!!");
                if (soLuong == null || !soLuong.matches("-?\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(rootPane, "Không được nhập khí tự và để trống ");
                } else {
                    DoThue doThue = new DoThueRepositoryImpl().getAll().get(jtbDichVu.getSelectedRow());
                    DichVu dichVu = new DichVu(null, "DV100", doThue, Integer.parseInt(soLuong), iHoaDonService.findByHoaDonId(qLHoaDon.getId()), null,
                            0, doThue.getDonGia(), null, trangThaiDichVu.Dang_Su_Dung);
                    dichVuRepository.saveOrUpdate(dichVu);
                    listDV = dichVuRepository.findByIdHoaDon(qLHoaDon.getId());
                    addDataRowDichVu(listDV);
                    txtTongTien.setText(String.valueOf(fillGia()));
                }
            }
        }
    }//GEN-LAST:event_jtbDichVuMouseClicked

    private void jcbDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDichVuActionPerformed
        // TODO add your handling code here:
        if (jcbDichVu.getSelectedIndex() == 0) {
            listNC.clear();
            listNC = nuocUongService.getNuocUongNoPagination();
            addDataRowNuocUong(listNC);
        } else {
            listDT.clear();
            listDT = doThueService.getAll();
            addDataRowDoThue(listDT);
        }
    }//GEN-LAST:event_jcbDichVuActionPerformed

    private void btnAddPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPPActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        DichVu dichVu = dichVuRepository.findByIdHoaDon(qLHoaDon.getId()).get(jtbChiTietDichVu.getSelectedRow());
//        if (dichVuRepository.delete(dichVu.getId())) {
//            JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công");
//            addDataRowDichVu(dichVuRepository.findByIdHoaDon(qLHoaDon.getId()));
//            txtTongTien.setText(String.valueOf(fillGia()));
//        }
    }//GEN-LAST:event_jMenuXoaDichVuActionPerformed

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        // TODO add your handling code here:
        FrmHoaDon frmHoaDon = new FrmHoaDon();
        frmHoaDon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    private void jMenuSuaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSuaSoLuongActionPerformed
        // TODO add your handling code here:
        DichVu dichVu = dichVuRepository.findByIdHoaDon(qLHoaDon.getId()).get(jtbChiTietDichVu.getSelectedRow());
        String soLuong = JOptionPane.showInputDialog(rootPane, "Mời Nhập Số Lượng Dịch Vụ !!");
        if (soLuong == null) {
=======
        if (txtGiaPhuPhi.getText().isEmpty() || txtGiaPhuPhi.getText().isBlank() || !txtGiaPhuPhi.getText().matches("-?\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(rootPane, "Không Được Để Trống \n"
                    + "Và Nhập Kí Tự !!");
>>>>>>> c50e2f0716ed742766fdf7f1391636ca7038db2d
            return;
        } else {
            QLHoaDon_PhuPhi hoaDon_PhuPhi = new QLHoaDon_PhuPhi(null, qLHoaDon, qLPhuPhis.get(jcbPhuPhi.getSelectedIndex()),
                    Double.parseDouble(txtGiaPhuPhi.getText()), "Ahiih");
            if (new HoaDonPhuPhiServiceImpl().save(hoaDon_PhuPhi)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm That Bai");
            }
        }
        txtTongTien.setText(String.valueOf(fillGia()));
<<<<<<< HEAD
    }//GEN-LAST:event_jMenuSuaSoLuongActionPerformed

    private void btnAddPhuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhuPhiActionPerformed
        // TODO add your handling code here
        if(jcbPhuPhi.getSelectedItem().equals("không có phụ phí")){
            return;
        }
        String tenPP = JOptionPane.showInputDialog(rootPane, "Nhập Tên Phụ Phí !!");
        if (tenPP == null) {
            return;
        } else {
            if (tenPP.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Không Được Để Trống");
            } else {
//                QLPhuPhi phuPhi = new QLPhuPhi(null, phuPhiService.genMaPhuPhi(), tenPP);
//                if (phuPhiService.save(phuPhi)) {
//                    JOptionPane.showMessageDialog(rootPane, "Thêm Phụ Phí Thành Công");
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Thất Bại");
//                }
            }
        }
        loadCBPhuPhi();
    }//GEN-LAST:event_btnAddPhuPhiActionPerformed

    private void jcbPhuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPhuPhiActionPerformed
        // TODO add your handling code here:
//        String gia = JOptionPane.showInputDialog(rootPane, "Xin Mời Nhập Gía");
//        if (gia == null) {
//            return;
//        } else {
//            if (gia.isEmpty() || !gia.matches("-?\\d+(\\.\\d+)?")) {
//                JOptionPane.showMessageDialog(rootPane, "Không Được Để Trống \n"
//                        + "Và Giá Phải Là Số");
//            } else {
//                QLHoaDon_PhuPhi hoaDon_PhuPhi = new QLHoaDon_PhuPhi(null, qLHoaDon, qLPhuPhis.get(jcbPhuPhi.getSelectedIndex()), Double.valueOf(gia), "ahs");
//                if (new HoaDonPhuPhiServiceImpl().save(hoaDon_PhuPhi)) {
//                    JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công");
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Thêm That Bai");
//                }
//            }
//        }
//        txtTongTien.setText(String.valueOf(fillGia()));
    }//GEN-LAST:event_jcbPhuPhiActionPerformed
=======
    }//GEN-LAST:event_btnAddPPActionPerformed
>>>>>>> c50e2f0716ed742766fdf7f1391636ca7038db2d

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPP;
    private javax.swing.JButton btnAddPhuPhi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuSuaSoLuong;
    private javax.swing.JMenuItem jMenuXoaDichVu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTen;
    private javax.swing.JComboBox<String> jcbDichVu;
    private javax.swing.JComboBox<String> jcbPhuPhi;
    private javax.swing.JComboBox<String> jcbThanhToan;
    private javax.swing.JPopupMenu jpopChiTietDV;
    private javax.swing.JTable jtbChiTietDichVu;
    private javax.swing.JTable jtbDichVu;
    private javax.swing.JLabel jtenSan;
    private javax.swing.JLabel txtCa;
    private javax.swing.JTextField txtGiaPhuPhi;
    private javax.swing.JTextField txtNganHang;
    private javax.swing.JTextField txtPayBack;
    private javax.swing.JTextField txtTienKhach;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
