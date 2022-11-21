/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Acount;
import domainmodel.KhachHang;
import domainmodel.PhieuDatLich;
import domainmodel.SanCa;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import modelview.QLAcount;
import modelview.QLKhachHang;
import modelview.QLPhieuDatLich;
import modelview.QLSanCa;
import repository.IPhieuDatLichRepository;
import repository.impl.PhieuDatLichRepositoryImpl;
import service.IPhieuDatLichService;

/**
 *
 * @author ADMIN
 */
public class PhieuDatLichServiceImpl implements IPhieuDatLichService{
    

    private IPhieuDatLichRepository phieuRepo = new PhieuDatLichRepositoryImpl();

    @Override
    public List<QLPhieuDatLich> getAll() {
        List<QLPhieuDatLich> lPhieuDatLichs = new ArrayList<>();
        for (PhieuDatLich phieuDatLich : phieuRepo.getAll()) {
            QLAcount qLAcount = new QLAcount(phieuDatLich.getAcount().getId(), null, phieuDatLich.getAcount().getTenAcount(), null, null, null, null);
            QLKhachHang qLKhachHang = new QLKhachHang(phieuDatLich.getKhachHang().getId(), null, phieuDatLich.getKhachHang().getTenKhachHang(),null, null, null, null,null);
            QLSanCa qLSanCa = new QLSanCa(phieuDatLich.getSanCa().getId(), phieuDatLich.getSanCa().getCa().getTenCa(), null, null, 0, null);
            QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(phieuDatLich.getId(), qLAcount, qLKhachHang, qLSanCa, phieuDatLich.getNgayTaoPhieu(), phieuDatLich.getNgayDenSan(), phieuDatLich.getTgCheckIn(), phieuDatLich.getGhiChu(),phieuDatLich.getMaQR(), phieuDatLich.getTongTienSan(), phieuDatLich.getTrangThai());
            lPhieuDatLichs.add(qLPhieuDatLich);
        }
        
        return lPhieuDatLichs;
    }

    @Override
    public String save(QLPhieuDatLich phieuDatLich) {
        Acount acount = new Acount(phieuDatLich.getAcount().getId(), null, null, null, null, null, null);
        KhachHang khachHang = new KhachHang(phieuDatLich.getKhachHang().getId(),null,null, null, null, null, null);
        SanCa sanCa = new SanCa(phieuDatLich.getSanCa().getId(), null, null, null, 0, null);
        PhieuDatLich pdl = new PhieuDatLich(null, acount, khachHang, sanCa, phieuDatLich.getNgayTaoPhieu(), phieuDatLich.getNgayDenSan(), phieuDatLich.getTgCheckIn(), phieuDatLich.getGhiChu(),phieuDatLich.getMaQR(), phieuDatLich.getTongTienSan(), phieuDatLich.getTrangThai());
        if (phieuRepo.save(pdl) == true) {
            return "Lưu Thành Công";
        }
        return "Lưu Thất Bại";
    }

    @Override
    public String update(QLPhieuDatLich phieuDatLich) {
        Acount acount = new Acount(phieuDatLich.getAcount().getId(), null, null, null, null, null, null);
        KhachHang khachHang = new KhachHang(phieuDatLich.getKhachHang().getId(),null,null, null, null, null, null);
        SanCa sanCa = new SanCa(phieuDatLich.getSanCa().getId(), null, null, null, 0, null);
        PhieuDatLich pdl = new PhieuDatLich(phieuDatLich.getId(), acount, khachHang, sanCa, phieuDatLich.getNgayTaoPhieu(), phieuDatLich.getNgayDenSan(), phieuDatLich.getTgCheckIn(), phieuDatLich.getGhiChu(),phieuDatLich.getMaQR(), phieuDatLich.getTongTienSan(), phieuDatLich.getTrangThai());
        if (phieuRepo.update(pdl) == true) {
            return "Sửa Thành Công";
        }
        return "Sửa Thất Bại";
    }

    @Override
    public String delete(UUID id) {
        if (phieuRepo.delete(id) == true) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }
    
    public static void main(String[] args) {
        PhieuDatLichServiceImpl lichServiceImpl = new PhieuDatLichServiceImpl();
        System.out.println(lichServiceImpl.getAll().size());
    }

    @Override
    public List<PhieuDatLich> getPhieuDatLichByTT() {
        return phieuRepo.getPhieuDatLichByTT();
    }
}

