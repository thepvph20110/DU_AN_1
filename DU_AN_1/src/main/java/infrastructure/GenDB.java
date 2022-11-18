/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domainmodel.Acount;
import domainmodel.Ca;
import domainmodel.ChucVu;
import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.HoaDon;
import domainmodel.HoaDonThanhToan;
import domainmodel.KhachHang;
import domainmodel.KichThuoc;
import domainmodel.LoaiSan;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import domainmodel.NuocUong;
import domainmodel.PhieuDatLich;
import domainmodel.PhuPhi;
import domainmodel.PhuPhi_HoaDon;
import domainmodel.SanBong;
import domainmodel.SanCa;
import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiAcount;
import enumclass.trangThaiCa;
import enumclass.trangThaiChucVu;
import enumclass.trangThaiDichVu;
import enumclass.trangThaiDoThue;
import enumclass.trangThaiHoaDon;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiNuocUong;
import enumclass.trangThaiPhieuDL;
import enumclass.trangThaiPhuPhi;
import enumclass.trangThaiPhuPhiHoaDon;
import enumclass.trangThaiSanBong;
import enumclass.trangThaiSanCa;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class GenDB {
    
    //Tạo DB trong SQL SERVER = SOFT2041_PTPM
    //Sau đó tiến hành chạy đển zen bảng

    public static void main(String[] args) {

        try (Session session = HibernateConfig.getFACTORY().openSession()){
             Transaction trans = session.beginTransaction();

        //Gen Nha San Xuat
        NhaSanXuat nsx1 = new NhaSanXuat();
        nsx1.setMaNSX("NSX01");
        nsx1.setTenNSX("Nike");
        session.save(nsx1);

        NhaSanXuat nsx2 = new NhaSanXuat();
        nsx2.setMaNSX("NSX02");
        nsx2.setTenNSX("Adidas");
        session.save(nsx2);

        NhaSanXuat nsx3 = new NhaSanXuat();
        nsx3.setMaNSX("NSX03");
        nsx3.setTenNSX("Puma");
        session.save(nsx3);

        NhaSanXuat nsx4 = new NhaSanXuat();
        nsx4.setMaNSX("NSX04");
        nsx4.setTenNSX("Anta");
        session.save(nsx4);

        //Gen Mau Sac
        MauSac ms1 = new MauSac();
        ms1.setMaMauSac("MS01");
        ms1.setTenMauSac("Đỏ");
        session.save(ms1);

        MauSac ms2 = new MauSac();
        ms2.setMaMauSac("MS02");
        ms2.setTenMauSac("Vàng");
        session.save(ms2);

        MauSac ms3 = new MauSac();
        ms3.setMaMauSac("MS03");
        ms3.setTenMauSac("Trắng");
        session.save(ms3);

        MauSac ms4 = new MauSac();
        ms4.setMaMauSac("MS04");
        ms4.setTenMauSac("Xanh");
        session.save(ms4);

        //Gen Size
        KichThuoc kt = new KichThuoc();
        kt.setMaSize("KT01");
        kt.setSize(42);
        session.save(kt);

        KichThuoc kt2 = new KichThuoc();
        kt2.setMaSize("KT02");
        kt2.setSize(43);
        session.save(kt2);

        KichThuoc kt3 = new KichThuoc();
        kt3.setMaSize("KT03");
        kt3.setSize(41);
        session.save(kt3);

        KichThuoc kt4 = new KichThuoc();
        kt4.setMaSize("KT04");
        kt4.setSize(40);
        session.save(kt4);

        //Gen Đồ Thuê
        DoThue dt1 = new DoThue();
        dt1.setDonGia(300);
        dt1.setMaDoThue("DT001");
        dt1.setSoLuong(44);
        dt1.setTenDoThue("Áo Chống Nắng");
        dt1.setTrangThai(trangThaiDoThue.Con_Hang);
        dt1.setKichThuoc(kt);
        dt1.setMauSac(ms1);
        dt1.setNhaSanXuat(nsx1);
        session.save(dt1);

        DoThue dt2 = new DoThue();
        dt2.setDonGia(400);
        dt2.setMaDoThue("DT002");
        dt2.setSoLuong(20);
        dt2.setTenDoThue("Áo Thi Đấu");
        dt2.setTrangThai(trangThaiDoThue.Con_Hang);
        dt2.setKichThuoc(kt2);
        dt2.setMauSac(ms2);
        dt2.setNhaSanXuat(nsx2);
        session.save(dt2);

        DoThue dt3 = new DoThue();
        dt3.setDonGia(100);
        dt3.setMaDoThue("DT003");
        dt3.setSoLuong(15);
        dt3.setTenDoThue("Giay Đá Bóng");
        dt3.setTrangThai(trangThaiDoThue.Con_Hang);
        dt3.setKichThuoc(kt3);
        dt3.setMauSac(ms3);
        dt3.setNhaSanXuat(nsx3);
        session.save(dt3);

        DoThue dt4 = new DoThue();
        dt4.setDonGia(300);
        dt4.setMaDoThue("DT001");
        dt4.setSoLuong(44);
        dt4.setTenDoThue("Áo Chống Nắng");
        dt4.setTrangThai(trangThaiDoThue.Con_Hang);
        dt4.setKichThuoc(kt);
        dt4.setMauSac(ms1);
        dt4.setNhaSanXuat(nsx1);
        session.save(dt4);

        //Gen Nuoc Uong
        NuocUong nc1 = new NuocUong();
        nc1.setGia(200);
        nc1.setMaNuocUong("NU001");
        nc1.setSoLuong(2);
        nc1.setTenNuocUong("Trà Thảo Mộc Doctor Thanh");
        nc1.setTrangThai(trangThaiNuocUong.Con_Hang);
        session.save(nc1);

        NuocUong nc2 = new NuocUong();
        nc2.setGia(250);
        nc2.setMaNuocUong("NU002");
        nc2.setSoLuong(33);
        nc2.setTenNuocUong("Trà Xanh 0 Độ");
        nc2.setTrangThai(trangThaiNuocUong.Con_Hang);
        session.save(nc2);

        NuocUong nc3 = new NuocUong();
        nc3.setGia(250);
        nc3.setMaNuocUong("NU003");
        nc3.setSoLuong(22);
        nc3.setTenNuocUong("MU");
        nc3.setTrangThai(trangThaiNuocUong.Con_Hang);
        session.save(nc3);

        NuocUong nc4 = new NuocUong();
        nc4.setGia(500);
        nc4.setMaNuocUong("NU004");
        nc4.setSoLuong(52);
        nc4.setTenNuocUong("Nước Tranh Muối");
        nc4.setTrangThai(trangThaiNuocUong.Con_Hang);
        session.save(nc4);
        
        //Gen Loại Sân
        LoaiSan ls1 = new LoaiSan();
        ls1.setMaLoaiSan("LS001");
        ls1.setMoTa("Sân VIP");
        ls1.setTenLoaiSan("Sân Double Pro");
        session.save(ls1);

        LoaiSan ls2 = new LoaiSan();
        ls2.setMaLoaiSan("LS002");
        ls2.setMoTa("Sân Super VIP");
        ls2.setTenLoaiSan("Sân Double Pro Vip");
        session.save(ls2);

        LoaiSan ls3 = new LoaiSan();
        ls3.setMaLoaiSan("LS003");
        ls3.setMoTa("Sân VIP 3");
        ls3.setTenLoaiSan("Sân Double Pro 2");
        session.save(ls3);

        //Gen Sân Bóng
        SanBong sb1 = new SanBong();
        sb1.setGiaSan(200);
        sb1.setMaSanBong("SB001");
        sb1.setSucChua(7);
        sb1.setTenSanBong("Sân Bóng 1");
        sb1.setLoaiSan(ls1);
        sb1.setTrangThai(trangThaiSanBong.HOAT_DONG);
        session.save(sb1);

        SanBong sb2 = new SanBong();
        sb2.setGiaSan(300);
        sb2.setMaSanBong("SB002");
        sb2.setSucChua(7);
        sb2.setTenSanBong("Sân Bóng 2");
        sb2.setLoaiSan(ls2);
        sb2.setTrangThai(trangThaiSanBong.HOAT_DONG);
        session.save(sb2);

        SanBong sb3 = new SanBong();
        sb3.setGiaSan(200);
        sb3.setMaSanBong("SB003");
        sb3.setSucChua(12);
        sb3.setTenSanBong("Sân Bóng 3");
        sb3.setLoaiSan(ls3);
        sb3.setTrangThai(trangThaiSanBong.HOAT_DONG);
        session.save(sb3);

        //Gen Ca
        Ca ca1 = new Ca();
        ca1.setGiaCa(20);
        ca1.setMaCa("CA001");
        ca1.setTenCa("Ca 1");
        Time tCa1bd = new Time(7, 0, 0);
        ca1.setThoiGianBatDau(tCa1bd);
        Time tCa1kt = new Time(9, 0, 0);
        ca1.setThoiGianKetThuc(tCa1kt);
        ca1.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca1);

        Ca ca2 = new Ca();
        ca2.setGiaCa(20);
        ca2.setMaCa("CA002");
        ca2.setTenCa("Ca 2");
        Time tCa2bd = new Time(9,30, 0);
        ca2.setThoiGianBatDau(tCa2bd);
        Time tCa2kt = new Time(11, 30, 0);
        ca2.setThoiGianKetThuc(tCa2kt);
        ca2.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca2);

        Ca ca3 = new Ca();
        ca3.setGiaCa(20);
        ca3.setMaCa("CA003");
        ca3.setTenCa("Ca 3");
        Time tCa3bd = new Time(14, 0, 0);
        ca3.setThoiGianBatDau(tCa3bd);
        Time tCa3kt = new Time(16, 0, 0);
        ca3.setThoiGianKetThuc(tCa3kt);
        ca3.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca3);

        Ca ca4 = new Ca();
        ca4.setGiaCa(20);
        ca4.setMaCa("CA004");
        ca4.setTenCa("Ca 4");
        Time tCa4bd = new Time(16, 30, 0);
        ca4.setThoiGianBatDau(tCa4bd);
        Time tCa4kt = new Time(18, 30, 0);
        ca4.setThoiGianKetThuc(tCa4kt);
        ca4.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca4);

        Ca ca5 = new Ca();
        ca5.setGiaCa(30);
        ca5.setMaCa("CA005");
        ca5.setTenCa("Ca 5");
        Time tCa5bd = new Time(19, 00, 0);
        ca5.setThoiGianBatDau(tCa5bd);
        Time tCa5kt = new Time(21, 00, 0);
        ca5.setThoiGianKetThuc(tCa5kt);
        ca5.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        session.save(ca5);

        Ca ca6 = new Ca();
        ca6.setGiaCa(30);
        ca6.setMaCa("CA006");
        ca6.setTenCa("Ca 6");
        Time tCa6bd = new Time(21, 30, 0);
        ca6.setThoiGianBatDau(tCa6bd);
        Time tCa6kt = new Time(23, 30, 0);
        ca6.setThoiGianKetThuc(tCa6kt);
        ca6.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca6);

        //Gen Sân Ca
        SanCa san1ca1 = new SanCa();
        san1ca1.setGiaCa(200);
        Calendar myCal = Calendar.getInstance();
        myCal.set(Calendar.YEAR, 2022);
        myCal.set(Calendar.MONTH, 9);
        myCal.set(Calendar.DAY_OF_MONTH, 26);
        myCal.set(Calendar.HOUR, 7);
        myCal.set(Calendar.MINUTE, 0);
        myCal.set(Calendar.SECOND, 0);
        Date ngayTao1 = myCal.getTime();
        san1ca1.setNgayTao(ngayTao1);
        san1ca1.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san1ca1.setCa(ca1);
        san1ca1.setSanbong(sb1);
        session.save(san1ca1);

        SanCa san1ca2 = new SanCa();
        san1ca2.setGiaCa(200);
        Calendar myCal2 = Calendar.getInstance();
        myCal2.set(Calendar.YEAR, 2022);
        myCal2.set(Calendar.MONTH, 9);
        myCal2.set(Calendar.DAY_OF_MONTH, 26);
        myCal2.set(Calendar.HOUR, 9);
        myCal2.set(Calendar.MINUTE, 0);
        myCal2.set(Calendar.SECOND, 0);
        Date ngayTao2 = myCal2.getTime();
        san1ca1.setNgayTao(ngayTao2);
        san1ca1.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san1ca2.setCa(ca2);
        san1ca1.setSanbong(sb1);
        session.save(san1ca2);

        SanCa san1ca6 = new SanCa();
        san1ca1.setGiaCa(250);
        Calendar myCal3 = Calendar.getInstance();
        myCal2.set(Calendar.YEAR, 2022);
        myCal2.set(Calendar.MONTH, 9);
        myCal2.set(Calendar.DAY_OF_MONTH, 26);
        myCal2.set(Calendar.HOUR, 21);
        myCal2.set(Calendar.MINUTE, 0);
        myCal2.set(Calendar.SECOND, 0);
        Date ngayTao3 = myCal3.getTime();
        san1ca1.setNgayTao(ngayTao3);
        san1ca1.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san1ca6.setCa(ca6);
        san1ca1.setSanbong(sb1);
        session.save(san1ca6);

        SanCa san2ca6 = new SanCa();
        san2ca6.setGiaCa(250);
        Date ngayTao4 = new Date(2022, 9, 26, 21, 0, 0);
        san2ca6.setNgayTao(ngayTao4);
        san2ca6.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san2ca6.setCa(ca6);
        san2ca6.setSanbong(sb2);
        session.save(san2ca6);

        SanCa san2ca5 = new SanCa();
        san2ca5.setGiaCa(250);
        Date ngayTao5 = new Date(2022, 9, 26, 19, 0, 0);
        san2ca5.setNgayTao(ngayTao5);
        san2ca5.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san2ca5.setCa(ca5);
        san2ca5.setSanbong(sb2);
        session.save(san2ca5);

        SanCa san2ca3 = new SanCa();
        san2ca3.setGiaCa(250);
        Date ngayTao6 = new Date(2022, 9, 26, 14, 0, 0);
        san2ca3.setNgayTao(ngayTao6);
        san2ca3.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san2ca3.setCa(ca3);
        san2ca3.setSanbong(sb2);
        session.save(san2ca3);

        SanCa san3ca2 = new SanCa();
        san3ca2.setGiaCa(250);
        Date ngayTao7 = new Date(2022, 9, 26, 9, 0, 0);
        san3ca2.setNgayTao(ngayTao7);
        san3ca2.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san3ca2.setCa(ca2);
        san3ca2.setSanbong(sb3);
        session.save(san3ca2);

        SanCa san3ca5 = new SanCa();
        san3ca5.setGiaCa(250);
        Date ngayTao8 = new Date(2022, 9, 26, 19, 0, 0);
        san3ca5.setNgayTao(ngayTao8);
        san3ca5.setTrangThai(trangThaiSanCa.DANG_TRONG);
        san3ca5.setCa(ca5);
        san3ca5.setSanbong(sb3);
        session.save(san3ca5);

        //Gen Chức Vụ
        ChucVu cv1 = new ChucVu();
        cv1.setMaChucVu("CV1");
        cv1.setTenChucVu("Chủ Sân");
        cv1.setTrangThai(trangThaiChucVu.HOAT_DONG);
        session.save(cv1);

        ChucVu cv2 = new ChucVu();
        cv2.setMaChucVu("CV2");
        cv2.setTenChucVu("Quản Lý Sân");
        cv2.setTrangThai(trangThaiChucVu.HOAT_DONG);
        session.save(cv2);

        //Gen Account
        Acount acc1 = new Acount();
        acc1.setMaAcount("AC001");
        acc1.setMatKhau("1234");
        acc1.setMoTa("Tk Vip");
        acc1.setTenAcount("Cao Dinh");
        acc1.setTrangThai(trangThaiAcount.Da_Xac_Minh);
        acc1.setChucVu(cv1);
        session.save(acc1);

        Acount acc2 = new Acount();
        acc2.setMaAcount("AC002");
        acc2.setMatKhau("2233");
        acc2.setMoTa("Tk Vip");
        acc2.setTenAcount("Trien Ngu");
        acc2.setTrangThai(trangThaiAcount.Da_Xac_Minh);
        acc2.setChucVu(cv1);
        session.save(acc2);

        Acount acc3 = new Acount();
        acc3.setMaAcount("AC003");
        acc3.setMatKhau("1111");
        acc3.setMoTa("Tk Vip");
        acc3.setTenAcount("Cuoc Tuan");
        acc3.setTrangThai(trangThaiAcount.Da_Xac_Minh);
        acc3.setChucVu(cv2);
        session.save(acc3);

        //Gen Khách Hàng
        KhachHang kh1 = new KhachHang();
        kh1.setGhiChu("Ahhihii Đồ Ngốc");
        kh1.setMaKhachHang("KH001");
        kh1.setSoDienThoai("0987654321");
        kh1.setTenKhachHang("Thể Fan");
        kh1.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        session.save(kh1);

        KhachHang kh2 = new KhachHang();
        kh2.setGhiChu("Ahhihii Đồ Ngốc");
        kh2.setMaKhachHang("KH002");
        kh2.setSoDienThoai("0987654432");
        kh2.setTenKhachHang("Sỹ Gà");
        kh2.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        session.save(kh2);

        KhachHang kh3 = new KhachHang();
        kh3.setGhiChu("Ahhihii Đồ Ngốc");
        kh3.setMaKhachHang("KH003");
        kh3.setSoDienThoai("0988888888");
        kh3.setTenKhachHang("Lâm Xung");
        kh3.setTrangThai(trangThaiKhachHang.BINH_THUONG);
        session.save(kh3);

        //Gen Phụ Phí
        PhuPhi pp1 = new PhuPhi();
        pp1.setGiaPhuPhi(20);
        pp1.setMaPhuPhi("PP001");
        pp1.setMoTa("Chơi Qúa Liều");
        pp1.setTenPhuPhi("Chơi Qúa Gio");
        pp1.setTrangThai(trangThaiPhuPhi.Co);
        session.save(pp1);

        PhuPhi pp2 = new PhuPhi();
        pp2.setGiaPhuPhi(30);
        pp2.setMaPhuPhi("PP002");
        pp2.setMoTa("Chơi Ngu");
        pp2.setTenPhuPhi("Lam Hong Bong");
        pp2.setTrangThai(trangThaiPhuPhi.Co);
        session.save(pp2);

        PhuPhi pp3 = new PhuPhi();
        pp3.setGiaPhuPhi(20);
        pp3.setMaPhuPhi("PP003");
        pp3.setMoTa("Ngu");
        pp3.setTenPhuPhi("Lam Hong San");
        pp3.setTrangThai(trangThaiPhuPhi.Co);
        session.save(pp3);
        //Gen Phiếu Đặt Lịch
        PhieuDatLich pdl1 = new PhieuDatLich();
        Date nds1 = new Date(2022, 8, 13, 14, 30);
        pdl1.setNgayDenSan(nds1);
        pdl1.setGhiChu("Ahihi Đồ Ngốc");
        Time tgCI1 = new Time(20,20, 10);
        pdl1.setTgCheckIn(tgCI1);
        Date ntp = new Date(2022, 8, 13, 14, 55);
        pdl1.setNgayTaoPhieu(ntp);
        pdl1.setTongTienSan(550);
        pdl1.setTrangThai(trangThaiPhieuDL.DA_NHAN_SAN);
        pdl1.setAcount(acc2);
        pdl1.setKhachHang(kh3);
        pdl1.setSanCa(san2ca3);
        session.save(pdl1);

        PhieuDatLich pdl2 = new PhieuDatLich();
        Date nds2 = new Date(2022, 8, 13, 19, 40);
        pdl2.setNgayDenSan(nds2);
        pdl2.setGhiChu("Ahihi Đồ Ngốc");
        Time tgCI2 = new Time(12,20, 10);
        pdl2.setTgCheckIn(tgCI2);
        Date ntp2 = new Date(2022, 8, 13, 19, 39);
        pdl2.setNgayTaoPhieu(ntp2);
        pdl2.setTongTienSan(600);
        pdl2.setTrangThai(trangThaiPhieuDL.DA_HUY);
        pdl2.setAcount(acc3);
        pdl2.setKhachHang(kh2);
        pdl2.setSanCa(san1ca6);
        session.save(pdl2);

        PhieuDatLich pdl3 = new PhieuDatLich();
        Date nds3 = new Date(2022, 8, 13, 6, 49);
        pdl3.setNgayDenSan(nds3);
        pdl3.setGhiChu("Ahihi Đồ Ngốc");
        Time tgCI3 = new Time(05,20, 10);
        pdl3.setTgCheckIn(tgCI3);
        Date ntp3 = new Date(2022, 8, 13, 6, 30);
        pdl3.setNgayTaoPhieu(ntp3);
        pdl3.setTongTienSan(700);
        pdl3.setTrangThai(trangThaiPhieuDL.DA_NHAN_SAN);
        pdl3.setAcount(acc3);
        pdl3.setKhachHang(kh2);
        pdl3.setSanCa(san1ca1);
        session.save(pdl3);

        //Gen Thanh Toan
        ThanhToan tt1 = new ThanhToan();
        tt1.setMaThanhToan("TT001");
        tt1.setMoTa("Aggd");
        tt1.setHinhThanhToan(loaiHinhThanhToan.Chuyen_Khoan);
        session.save(tt1);
        
        ThanhToan tt2 = new ThanhToan();
        tt2.setMaThanhToan("TT002");
        tt2.setMoTa("Aggd");
        tt2.setHinhThanhToan(loaiHinhThanhToan.Tien_Mat);
        session.save(tt2);
        
        //Gen HoaDon
        HoaDon hd1 = new HoaDon();
        hd1.setDonGia(230);
        hd1.setGhiChu("HDHA");
        Date ntt1 = new Date(2022, 13, 8, 19, 22);
        hd1.setNgayThanhToan(ntt1);
        hd1.setTongTien(2000);
        hd1.setTrangThai(trangThaiHoaDon.DA_THANH_TOAN);
        hd1.setPhieuDatLich(pdl3);
        session.save(hd1);
        
        HoaDon hd2 = new HoaDon();
        hd2.setDonGia(220);
        hd2.setGhiChu("ccxcx");
        Date ntt2 = new Date(2022, 13, 8, 20, 22);
        hd2.setNgayThanhToan(ntt2);
        hd2.setTongTien(1900);
        hd2.setTrangThai(trangThaiHoaDon.DA_THANH_TOAN);
        hd2.setPhieuDatLich(pdl2);
        session.save(hd2);
        
        HoaDon hd3 = new HoaDon();
        hd3.setDonGia(230);
        hd3.setGhiChu("HDHA");
        Date ntt3 = new Date(2022, 13, 8, 17, 22);
        hd3.setNgayThanhToan(ntt3);
        hd3.setTongTien(2000);
        hd3.setTrangThai(trangThaiHoaDon.DA_THANH_TOAN);
        hd3.setPhieuDatLich(pdl2);
        session.save(hd3);

        //Gen Dịch Vụ
        DichVu dv1 = new DichVu();
        dv1.setDonGia(300);
        dv1.setMaDichVu("DV001");
        dv1.setMoTa("Ngon Bổ Rẻ");
        dv1.setSoLuongDoThue(24);
        dv1.setSoLuongNuocUong(10);
        dv1.setNuocUong(nc4);
        dv1.setHoaDon(hd1);
        dv1.setTrangThai(trangThaiDichVu.Dang_Su_Dung);
        dv1.setDoThue(dt4);
        session.save(dv1);

        DichVu dv2 = new DichVu();
        dv2.setDonGia(400);
        dv2.setMaDichVu("DV002");
        dv2.setMoTa("Ngon Bổ Rẻ");
        dv2.setSoLuongDoThue(14);
        dv2.setSoLuongNuocUong(14);
        dv2.setNuocUong(nc3);
        dv2.setHoaDon(hd1);
        dv2.setTrangThai(trangThaiDichVu.Dang_Su_Dung);
        dv2.setDoThue(dt3);
        session.save(dv2);

        DichVu dv3 = new DichVu();
        dv3.setDonGia(300);
        dv3.setMaDichVu("DV001");
        dv3.setMoTa("Ngon Bổ Rẻ");
        dv3.setSoLuongDoThue(24);
        dv3.setSoLuongNuocUong(10);
        dv3.setHoaDon(hd2);
        dv3.setNuocUong(nc1);
        dv3.setTrangThai(trangThaiDichVu.Dang_Su_Dung);
        dv3.setDoThue(dt1);
        session.save(dv3);
        
        //Gen HoaDon Thanh Toan
        
        HoaDonThanhToan hdtt1 = new HoaDonThanhToan();
        hdtt1.setGhiChu("ABCXYZ");
        hdtt1.setMaThanhToan(null);
        hdtt1.setTongTien(250);
        hdtt1.setHoaDon(hd1);
        hdtt1.setThanhToan(tt1);
        session.save(hdtt1);
        
        HoaDonThanhToan hdtt2 = new HoaDonThanhToan();
        hdtt2.setGhiChu("ABCXYZ");
        hdtt2.setMaThanhToan(null);
        hdtt2.setTongTien(250);
        hdtt2.setHoaDon(hd1);
        hdtt2.setThanhToan(tt2);
        session.save(hdtt2);
        
        HoaDonThanhToan hdtt3 = new HoaDonThanhToan();
        hdtt3.setGhiChu("ABCXYZ");
        hdtt3.setMaThanhToan(null);
        hdtt3.setTongTien(300);
        hdtt3.setHoaDon(hd2);
        hdtt3.setThanhToan(tt2);
        session.save(hdtt3);
        
        HoaDonThanhToan hdtt4 = new HoaDonThanhToan();
        hdtt4.setGhiChu("ABCXYZ");
        hdtt4.setMaThanhToan(null);
        hdtt4.setTongTien(400);
        hdtt4.setHoaDon(hd3);
        hdtt4.setThanhToan(tt2);
        session.save(hdtt4);
        
        //Gen Phụ Phí Hóa Đơn
        PhuPhi_HoaDon pphd1 = new PhuPhi_HoaDon();
        pphd1.setTrangThai(trangThaiPhuPhiHoaDon.Da_Tra);
        pphd1.setPhuPhi(pp1);
        pphd1.setHoaDon(hd1);
        session.save(pphd1);
        
        PhuPhi_HoaDon pphd4 = new PhuPhi_HoaDon();
        pphd4.setTrangThai(trangThaiPhuPhiHoaDon.Da_Tra);
        pphd4.setPhuPhi(pp2);
        pphd4.setHoaDon(hd2);
        session.save(pphd1);
        
        PhuPhi_HoaDon pphd2 = new PhuPhi_HoaDon();
        pphd2.setTrangThai(trangThaiPhuPhiHoaDon.Da_Tra);
        pphd2.setPhuPhi(pp2);
        pphd2.setHoaDon(hd1);
        session.save(pphd2);
        
        PhuPhi_HoaDon pphd3 = new PhuPhi_HoaDon();
        pphd3.setTrangThai(trangThaiPhuPhiHoaDon.Da_Tra);
        pphd3.setPhuPhi(pp1);
        pphd3.setHoaDon(hd3);
        session.save(pphd3);

        // db generator : gen bảng tự động
        trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
