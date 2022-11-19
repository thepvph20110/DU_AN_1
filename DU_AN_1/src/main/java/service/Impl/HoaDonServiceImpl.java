/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.HoaDon;
import enumclass.trangThaiHoaDon;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import modelview.QLHoaDon;
import repository.IHoaDonRepository;
import repository.impl.HoaDonRepositoryImpl;
import service.IHoaDonService;

/**
 *
 * @author ADMIN
 */
public class HoaDonServiceImpl implements IHoaDonService {
    
    private IHoaDonRepository hoaDonRepo = new HoaDonRepositoryImpl();

    @Override
    public List<QLHoaDon> getAll() {
        List<QLHoaDon> lHoaDons = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepo.getAll()) {
            QLHoaDon qLHoaDon = new QLHoaDon(hoaDon.getId(), hoaDon.getPhieuDatLich(), hoaDon.getNgayThanhToan(),
                        hoaDon.getDonGia(), hoaDon.getTongTien(), hoaDon.getGhiChu(), hoaDon.getTrangThai());
            lHoaDons.add(qLHoaDon);
        }
        return lHoaDons;
    }

    @Override
    public String save(QLHoaDon qLHoaDon) {
        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getPhieuDatLich(), qLHoaDon.getNgayThanhToan(),
                        qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
        if(hoaDonRepo.save(hoaDon) == true){
            return "Thêm Thành Công";
        }
        return "Thêm Thất Bại";
    }

    @Override
    public String update(QLHoaDon qLHoaDon, UUID id) {
        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getPhieuDatLich(), qLHoaDon.getNgayThanhToan(),
                        qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
        if(hoaDonRepo.update(hoaDon) == true){
            return "Sửa Thành Công";
        }
        return "Sửa Thất Bại";
    }

    @Override
    public String delete(UUID id) {
        if(hoaDonRepo.delete(id) == true){
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }

}
