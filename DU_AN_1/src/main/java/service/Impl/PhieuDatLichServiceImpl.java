/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.PhieuDatLich;
import enumclass.trangThaiPhieuDL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import modelview.QLPhieuDatLich;
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
            QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(phieuDatLich.getId(),phieuDatLich.getAcount(),phieuDatLich.getKhachHang(),phieuDatLich.getSanCa(),
                                                 phieuDatLich.getNgayTaoPhieu(),phieuDatLich.getNgayDenSan(),phieuDatLich.getTgCheckIn(),phieuDatLich.getGhiChu(),phieuDatLich.getTongTienSan()
                                                ,phieuDatLich.getTrangThai());
            lPhieuDatLichs.add(qLPhieuDatLich);
        }
        
        return lPhieuDatLichs;
    }

    @Override
    public String save(QLPhieuDatLich phieuDatLich) {
        PhieuDatLich phieuDatLichDomain = new PhieuDatLich(phieuDatLich.getId(),phieuDatLich.getAcount(),phieuDatLich.getKhachHang(),phieuDatLich.getSanCa(),
                                                 phieuDatLich.getNgayTaoPhieu(),phieuDatLich.getNgayDenSan(),phieuDatLich.getTgCheckIn(),phieuDatLich.getGhiChu(),phieuDatLich.getTongTienSan()
                                                ,phieuDatLich.getTrangThai());
        if (phieuRepo.save(phieuDatLichDomain) == true) {
            return "Lưu Thành Công";
        }
        return "Lưu Thất Bại";
    }

    @Override
    public String update(QLPhieuDatLich phieuDatLich) {
        PhieuDatLich phieuDatLichDomain = new PhieuDatLich(phieuDatLich.getId(),phieuDatLich.getAcount(),phieuDatLich.getKhachHang(),phieuDatLich.getSanCa(),
                                                 phieuDatLich.getNgayTaoPhieu(),phieuDatLich.getNgayDenSan(),phieuDatLich.getTgCheckIn(),phieuDatLich.getGhiChu(),phieuDatLich.getTongTienSan()
                                                ,phieuDatLich.getTrangThai());
        if (phieuRepo.update(phieuDatLichDomain) == true) {
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
}

