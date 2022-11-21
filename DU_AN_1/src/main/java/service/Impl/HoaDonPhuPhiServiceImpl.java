package service.Impl;

import domainmodel.HoaDon;
import domainmodel.PhuPhi;
import domainmodel.PhuPhi_HoaDon;
import enumclass.trangThaiHoaDon;
import enumclass.trangThaiPhuPhi;
import enumclass.trangThaiPhuPhiHoaDon;
import java.util.ArrayList;
import java.util.List;
import modelview.QLHoaDon;
import modelview.QLHoaDon_PhuPhi;
import modelview.QLPhuPhi;
import repository.IPhuPhiHoaDonRepository;
import repository.impl.PhuPhiHoaDonRepositoryImpl;
import service.IHoaDon_PhuPhiService;

public class HoaDonPhuPhiServiceImpl implements IHoaDon_PhuPhiService {

    private final IPhuPhiHoaDonRepository repository;
    private List<QLHoaDon_PhuPhi> lstQLHoaDonPhuPhi;

    public HoaDonPhuPhiServiceImpl() {
        repository = new PhuPhiHoaDonRepositoryImpl();
        lstQLHoaDonPhuPhi = new ArrayList<>();
    }

    @Override
    public List<QLHoaDon_PhuPhi> getALlLHoaDon_PhuPhis() {
//        lstQLHoaDonPhuPhi.clear();
//        var lstHDPhuPhi = repository.getAllPhuPhi_HoaDons();
//        for (PhuPhi_HoaDon phuPhi_HoaDon : lstHDPhuPhi) {
//            QLPhuPhi qLPhuPhi = new QLPhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//            QLHoaDon qLHoaDon = new QLHoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
//                    phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//            QLHoaDon_PhuPhi qLHoaDon_PhuPhi = new QLHoaDon_PhuPhi(phuPhi_HoaDon.getId(), qLHoaDon, qLPhuPhi, phuPhi_HoaDon.getTrangThai());
//            lstQLHoaDonPhuPhi.add(qLHoaDon_PhuPhi);
//        }
        return lstQLHoaDonPhuPhi;
    }

    @Override
    public boolean save(QLHoaDon_PhuPhi phuPhi_HoaDon) {
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean save = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return save;
        return false;
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean save = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return save;
    }

    @Override
    public boolean update(QLHoaDon_PhuPhi phuPhi_HoaDon) {
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean update = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return update;
        return false;
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean update = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return update;
    }

    @Override
    public boolean delete(QLHoaDon_PhuPhi phuPhi_HoaDon) {
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean delete = repository.delete(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return delete;
        return false;
//        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(),
//                phuPhi_HoaDon.getPhuPhi().getTenPhuPhi(), phuPhi_HoaDon.getPhuPhi().getGiaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getMoTa(), phuPhi_HoaDon.getPhuPhi().getTrangThai());
//        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), phuPhi_HoaDon.getHoaDon().getDichVu(), phuPhi_HoaDon.getHoaDon().getNgayThanhToan(), phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
//        var phuPhi_HoaDon1 = new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai());
//        boolean delete = repository.delete(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getTrangThai()));
//        return delete;
    }

}
