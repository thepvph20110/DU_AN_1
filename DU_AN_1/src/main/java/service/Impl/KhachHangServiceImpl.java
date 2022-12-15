/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.KhachHang;
import enumclass.trangThaiKhachHang;
import java.util.ArrayList;
import java.util.List;
import modelview.QLKhachHang;
import repository.impl.KhachHangRepository;
import service.IKhachHangService;

/**
 *
 * @author hp
 */
public class KhachHangServiceImpl implements IKhachHangService {

    private final KhachHangRepository re = new KhachHangRepository();

    @Override
    public List<QLKhachHang> getAll() {

        List<QLKhachHang> listQLKhachHang = new ArrayList<>();
        for (KhachHang KhachHang : re.getAll()) {
            QLKhachHang khachHang = new QLKhachHang(KhachHang.getId(), KhachHang.getMaKhachHang(), KhachHang.getTenKhachHang(), KhachHang.getMail(), KhachHang.getSoDienThoai(), KhachHang.getGhiChu(), KhachHang.getTrangThai());
            listQLKhachHang.add(khachHang);
        }
        return listQLKhachHang;


    }

    @Override
    public String save(QLKhachHang qLKhachHang) {

//        KhachHang khachHang = new KhachHang(null, qLKhachHang.getMaKhachHang(), qLKhachHang.getTenKhachHang(), qLKhachHang.getSoDienThoai(), qLKhachHang.getGhiChu(), qLKhachHang.getTrangThai());
//        if (re.saveOrUpdate(khachHang)) {
//            return "Save complete";
//        } else {
//            return "Save Fail";
//        }
     return null;
    }

    @Override
    public String update(QLKhachHang qLKhachHang) {


//        KhachHang khachHang = new KhachHang(qLKhachHang.getId(), qLKhachHang.getMaKhachHang(), qLKhachHang.getTenKhachHang(), qLKhachHang.getSoDienThoai(), qLKhachHang.getGhiChu(), qLKhachHang.getTrangThai());
//        if (re.saveOrUpdate(khachHang)) {
//            return "Update complete";
//        } else {
//            return "Update Fail";
//        }
       return null;

    }

    @Override
    public String delete(QLKhachHang qLKhachHang) {


//        KhachHang khachHang = new KhachHang(qLKhachHang.getId(), qLKhachHang.getMaKhachHang(), qLKhachHang.getTenKhachHang(), qLKhachHang.getSoDienThoai(), qLKhachHang.getGhiChu(), qLKhachHang.getTrangThai());
//        if (re.delete(khachHang)) {
//            return "Delete complete";
//        } else {
//            return "Delete Fail";
//        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangServiceImpl().getAll().size());
    }

    @Override
    public List<QLKhachHang> searchByName(String ten) {
//        List<QLKhachHang> qLKhachHang = new ArrayList<>();
//        for (KhachHang KhachHang : re.searchByName(ten)) {
//            QLKhachHang khachHang = new QLKhachHang(KhachHang.getId(), KhachHang.getMaKhachHang(), KhachHang.getTenKhachHang(), KhachHang.getMail(), KhachHang.getSoDienThoai(), KhachHang.getGhiChu(), KhachHang.getTrangThai());
//            qLKhachHang.add(khachHang);
//        }
//        return qLKhachHang;
        return null;
    }
<<<<<<< HEAD
=======

    @Override
    public String genMaKH() {
        return "KH00"+re.genMaKH();
    }

>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
