/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Acount;
import domainmodel.ChucVu;
import domainmodel.KhachHang;
import domainmodel.PhieuDatLich;
import enumclass.trangThaiAcount;
import enumclass.trangThaiChucVu;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiPhieuDL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import utill.HibernateConfig;

/**
 *
 * @author ADMIN
 */
public class PhieuDatLichRepositoryImpl {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public void createPhieuDatLich() {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            
            // chức vụ , acount, khách hàng là khóa ngoại của phiếu đặt lịch
            ChucVu chucVu = new ChucVu(null, "CV1", "Quản lý", trangThaiChucVu.HOAT_DONG);
            Acount acount = new Acount(null, "QL1", "nguyễn văn a", chucVu, "123", "aa", trangThaiAcount.Da_Xac_Minh);
            KhachHang khachHang = new KhachHang(null, "KH1", "nguyễn văn b", "0333333", "ttt", trangThaiKhachHang.BINH_THUONG);
            
            
            // tạo 1 phiếu đặt lịch và truyền khóa ngoại vào
//            PhieuDatLich phieuDatLich = new  PhieuDatLich(null, acount, khachHang,dateFormat.parse("12-02-2033") , 
//                    dateFormat.parse("12-02-2033"), dateFormat.parse("12-02-2033"), "dd", 12222, trangThaiPhieuDL.CHUA_NHAN_SAN);
            
            
            session.getTransaction().begin();
            
            session.save(chucVu);
            session.save(acount); 
            session.save(khachHang);
//            session.save(phieuDatLich);
           
            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void main(String[] args) {
        new PhieuDatLichRepositoryImpl().createPhieuDatLich();
    }
    
}
