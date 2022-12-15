/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.List;
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
            QLHoaDon qLHoaDon = new QLHoaDon(hoaDon.getId(), hoaDon.getMaHoaDon(), hoaDon.getPhieuDatLich(), null, hoaDon.getPhuPhi(), hoaDon.getNgayThanhToan(),
                    hoaDon.getDonGia(), hoaDon.getTongTien(), hoaDon.getGhiChu(), hoaDon.getTrangThai());
            lHoaDons.add(qLHoaDon);
        }
        return lHoaDons;
    }

    @Override
    public String save(QLHoaDon qLHoaDon) {
<<<<<<< HEAD

//        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getPhieuDatLich(), qLHoaDon.getNgayThanhToan(),
//                        qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
//        if(hoaDonRepo.save(hoaDon) == true){
//            return "Thêm Thành Công";
//        }
//
//
//        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getMaHoaDon(), qLHoaDon.getPhieuDatLich(), null, qLHoaDon.getNgayThanhToan(),
//
//        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getMaHoaDon(), qLHoaDon.getPhieuDatLich(), null,null, qLHoaDon.getNgayThanhToan(),
//
//                qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
//        if (hoaDonRepo.save(hoaDon) == true) {
//            return "Thêm Thành Công";
//        }

=======
        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getMaHoaDon(), qLHoaDon.getPhieuDatLich(), null, null, qLHoaDon.getNgayThanhToan(),
                qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
        if (hoaDonRepo.save(hoaDon) == true) {
            return "Thêm Thành Công";
        }
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5

        return "Thêm Thất Bại";
    }

    @Override
    public String update(QLHoaDon qLHoaDon, UUID id) {
//        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getPhieuDatLich(), qLHoaDon.getNgayThanhToan(),
//                        qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
//        if(hoaDonRepo.update(hoaDon) == true){
//            return "Sửa Thành Công";
//        }
//
//
//
//
//        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getMaHoaDon(), qLHoaDon.getPhieuDatLich(), null,null, qLHoaDon.getNgayThanhToan(),
//                qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
//        if (hoaDonRepo.update(hoaDon) == true) {
//            return "Sửa Thành Công";
//        }

<<<<<<< HEAD
=======
        HoaDon hoaDon = new HoaDon(qLHoaDon.getId(), qLHoaDon.getMaHoaDon(), qLHoaDon.getPhieuDatLich(), null, null, qLHoaDon.getNgayThanhToan(),
                qLHoaDon.getDonGia(), qLHoaDon.getTongTien(), qLHoaDon.getGhiChu(), qLHoaDon.getTrangThai());
        if (hoaDonRepo.update(hoaDon) == true) {
            return "Sửa Thành Công";
        }
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5

        return "Sửa Thất Bại";
    }

    @Override
    public String delete(String id) {
        if (hoaDonRepo.delete(id) == true) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }

    @Override
    public QLHoaDon getByTrangThai(String idSanCa) {
        QLHoaDon lHoaDons = new QLHoaDon();
        HoaDon hoaDon = hoaDonRepo.getByTrangThai(idSanCa);
        if (hoaDon != null) {
            lHoaDons = new QLHoaDon(hoaDon.getId(), hoaDon.getMaHoaDon(), hoaDon.getPhieuDatLich(), null, hoaDon.getPhuPhi(), hoaDon.getNgayThanhToan(),
                    hoaDon.getDonGia(), hoaDon.getTongTien(), hoaDon.getGhiChu(), hoaDon.getTrangThai());
        }
        return lHoaDons;
    }

    @Override
    public List<QLHoaDon> searchByName(String name) {
        List<QLHoaDon> lHoaDons = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonRepo.searchByTen(name)) {
            QLHoaDon qLHoaDon = new QLHoaDon(hoaDon.getId(), hoaDon.getMaHoaDon(), hoaDon.getPhieuDatLich(), null, hoaDon.getPhuPhi(), hoaDon.getNgayThanhToan(),
                    hoaDon.getDonGia(), hoaDon.getTongTien(), hoaDon.getGhiChu(), hoaDon.getTrangThai());
            lHoaDons.add(qLHoaDon);
        }
        return lHoaDons;
    }

    @Override
    public HoaDon findByHoaDonId(String uuid) {
        return hoaDonRepo.findByHoaDonId(uuid);
    }

    @Override
    public String genMaHoaDon() {
        return "HD00" + hoaDonRepo.genMaHoaDon();
    }

}
