/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.HoaDon;
import domainmodel.KichThuoc;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import domainmodel.NuocUong;
import enumclass.trangThaiDichVu;
import enumclass.trangThaiDoThue;
import enumclass.trangThaiHoaDon;
import enumclass.trangThaiNuocUong;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import utill.HibernateConfig;

/**
 *
 * @author ASUS
 */
public class FixCungDichVuImpl {

    public void fixCungDichVu() {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {

//            NuocUong nuocUong = new NuocUong(null, "NU04", "CoCaCola", 5, 10000, trangThaiNuocUong.Con_Hang);
//            //UUID id,String maDoThue,String tenDoThue,KichThuoc kichThuoc,MauSac mauSac,NhaSanXuat nhaSanXuat,int soLuong,double donGia, trangThaiDoThue trangThai
//            //
//            KichThuoc kichThuoc1 = new KichThuoc(null, "KT01", 1);
//            KichThuoc kichThuoc2 = new KichThuoc(null, "KT02", 2);
//            KichThuoc kichThuoc3 = new KichThuoc(null, "KT03", 3);
//            //
//            MauSac mauSac1 = new MauSac(null, "MS01", "Đỏ");
//            MauSac mauSac2 = new MauSac(null, "MS02", "Trắng");
//            MauSac mauSac = new MauSac(null, "MS03", "Xanh");
//            //
//            NhaSanXuat nsx1 = new NhaSanXuat(null, "NSX01", "Kim Yên");
//            NhaSanXuat nsx2 = new NhaSanXuat(null, "NSX02", "Thăng Long");
//            //
//            DoThue doThue = new DoThue(null, "DT01", "Bóng B2", kichThuoc1, mauSac2, nsx2, 10, 5000, trangThaiDoThue.Con_Hang);
//            DoThue doThue1 = new DoThue(null, "DT02", "Áo Lưới Tập", kichThuoc1, mauSac1, nsx2, 100, 50000, trangThaiDoThue.Con_Hang);
//            DoThue doThue2 = new DoThue(null, "DT03", "Áo Lưới Tập", kichThuoc1, mauSac, nsx2, 100, 50000, trangThaiDoThue.Con_Hang);
//            // dich vu
//            DichVu dv1 = new DichVu(null, "DV01", doThue, 2, nuocUong, 2, doThue.getDonGia() * 2 + nuocUong.getGia() * 2, "Đang cho thuê", trangThaiDichVu.Dang_Su_Dung);
//            DichVu dv2 = new DichVu(null, "DV02", doThue1, 2, nuocUong, 2, doThue1.getDonGia() * 2 + nuocUong.getGia() * 2, "Đang cho thuê", trangThaiDichVu.Dang_Su_Dung);
//            ss.getTransaction().begin();
//            
//            ss.save(nuocUong);
//            
//            ss.save(kichThuoc1);
//            ss.save(kichThuoc2);
//            ss.save(kichThuoc3);
//            
//            
//            
//            ss.save(mauSac);
//            ss.save(mauSac2);
//            ss.save(mauSac1);
//            
//            
//            ss.save(nsx1);
//            ss.save(nsx2);
//            
//            ss.save(doThue);
//            ss.save(doThue1);
//            ss.save(doThue2);
//            
//            ss.save(dv1);
//            ss.save(dv2);


//            HoaDon hoaDon = new HoaDon(null, phieuDatLich, dichVu, new Date(), 0, 0, ghiChu, trangThaiHoaDon.DA_THANH_TOAN);
            ss.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
    public static void main(String[] args) {
        FixCungDichVuImpl fix = new FixCungDichVuImpl();
        fix.fixCungDichVu();
    }
}
