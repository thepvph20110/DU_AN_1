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
import enumclass.trangThaiAcount;
import enumclass.trangThaiCa;
import enumclass.trangThaiChucVu;
import enumclass.trangThaiDoThue;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiNuocUong;
import enumclass.trangThaiPhuPhi;
import enumclass.trangThaiSanBong;
import java.sql.Time;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class GenDB {
    //Tạo DB trong SQL SERVER = SOFT2041_PTPM
    //Sau đó tiến hành chạy đển zen bảng

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        Properties prop = HibernateConfig.getProperties();
        prop.put(Environment.HBM2DDL_AUTO, "create");
        // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(prop)
                .build();

        // tạo lớp giao tiếp với jdbc
        conf.setProperties(prop);
        conf.addAnnotatedClass(SanBong.class);
        conf.addAnnotatedClass(Ca.class);
        conf.addAnnotatedClass(LoaiSan.class);
        conf.addAnnotatedClass(SanCa.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(Acount.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(KichThuoc.class);
        conf.addAnnotatedClass(DoThue.class);
        conf.addAnnotatedClass(NuocUong.class);
        conf.addAnnotatedClass(PhieuDatLich.class);
        conf.addAnnotatedClass(DichVu.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(PhuPhi.class);
        conf.addAnnotatedClass(ThanhToan.class);
        conf.addAnnotatedClass(PhuPhi_HoaDon.class);
        conf.addAnnotatedClass(HoaDonThanhToan.class);
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        // tạo giao dịch tương ứng 
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

        //Gen Dịch Vụ
//        DichVu dv1 = new DichVu();
//        dv1.setDonGia(300);
//        dv1.setMaDichVu("DV001");
//        dv1.setMoTa("Ngon Bổ Rẻ");
//        dv1.setSoLuongDoThue(24);
//        dv1.setSoLuongNuocUong(10);
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
        Time tCa2bd = new Time(9, 15, 0);
        ca2.setThoiGianBatDau(tCa2bd);
        Time tCa2kt = new Time(11, 15, 0);
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
        Time tCa4bd = new Time(16, 15, 0);
        ca4.setThoiGianBatDau(tCa4bd);
        Time tCa4kt = new Time(18, 15, 0);
        ca4.setThoiGianKetThuc(tCa4kt);
        ca4.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca4);

        Ca ca5 = new Ca();
        ca5.setGiaCa(30);
        ca5.setMaCa("CA005");
        ca5.setTenCa("Ca 5");
        Time tCa5bd = new Time(18, 30, 0);
        ca5.setThoiGianBatDau(tCa5bd);
        Time tCa5kt = new Time(20, 30, 0);
        ca5.setThoiGianKetThuc(tCa5kt);
        ca5.setTrangThai(trangThaiCa.GIO_CAO_DIEM);
        session.save(ca5);

        Ca ca6 = new Ca();
        ca6.setGiaCa(30);
        ca6.setMaCa("CA006");
        ca6.setTenCa("Ca 6");
        Time tCa6bd = new Time(21, 0, 0);
        ca6.setThoiGianBatDau(tCa6bd);
        Time tCa6kt = new Time(23, 30, 0);
        ca6.setThoiGianKetThuc(tCa6kt);
        ca6.setTrangThai(trangThaiCa.GIO_BINH_THUONG);
        session.save(ca6);

        //Gen Chức Vụ
        ChucVu cv1 = new ChucVu();
        cv1.setMaChucVu("CV1");
        cv1.setTenChucVu("Quản Lý Sân");
        cv1.setTrangThai(trangThaiChucVu.HOAT_DONG);
        session.save(cv1);

        ChucVu cv2 = new ChucVu();
        cv2.setMaChucVu("CV1");
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
        
        PhuPhi pp2 = new PhuPhi();
        pp2.setGiaPhuPhi(30);
        pp2.setMaPhuPhi("PP002");
        pp2.setMoTa("Chơi Ngu");
        pp2.setTenPhuPhi("Lam Hong Bong");
        pp2.setTrangThai(trangThaiPhuPhi.Co);
        
        PhuPhi pp3 = new PhuPhi();
        pp3.setGiaPhuPhi(20);
        pp3.setMaPhuPhi("PP003");
        pp3.setMoTa("Ngu");
        pp3.setTenPhuPhi("Lam Hong San");
        pp3.setTrangThai(trangThaiPhuPhi.Co);
        
        //Gen 

        // db generator : gen bảng tự động
        trans.commit();
    }
}
