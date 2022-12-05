package service.Impl;

import domainmodel.HoaDon;
import domainmodel.PhuPhi;
import domainmodel.PhuPhi_HoaDon;
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
        lstQLHoaDonPhuPhi.clear();
        var lstHDPhuPhi = repository.getAllPhuPhi_HoaDons();
        for (PhuPhi_HoaDon phuPhi_HoaDon : lstHDPhuPhi) {
            QLPhuPhi qLPhuPhi = new QLPhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi());
            QLHoaDon qLHoaDon = new QLHoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getMaHoaDon(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), null, null, phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
                    phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
            QLHoaDon_PhuPhi qLHoaDon_PhuPhi = new QLHoaDon_PhuPhi(phuPhi_HoaDon.getId(), qLHoaDon, qLPhuPhi, phuPhi_HoaDon.getGiaPPHD(), phuPhi_HoaDon.getMoTa());
            lstQLHoaDonPhuPhi.add(qLHoaDon_PhuPhi);
        }
        return lstQLHoaDonPhuPhi;
    }
    
    @Override
    public boolean save(QLHoaDon_PhuPhi phuPhi_HoaDon) {
        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi());
        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getMaHoaDon(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), null, null, phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
                phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
        boolean save = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getGiaPPHD(), phuPhi_HoaDon.getMoTa()));
        return save;
    }
    
    @Override
    public boolean update(QLHoaDon_PhuPhi phuPhi_HoaDon) {
        PhuPhi phuPhi = new PhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi());
        HoaDon hoaDon = new HoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getMaHoaDon(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), null, null, phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
                phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
        boolean update = repository.save(new PhuPhi_HoaDon(phuPhi_HoaDon.getId(), hoaDon, phuPhi, phuPhi_HoaDon.getGiaPPHD(), phuPhi_HoaDon.getMoTa()));
        return update;
    }
    
    @Override
    public boolean delete(String id) {
        boolean update = repository.delete(id);
        return update;
    }
    
    public static void main(String[] args) {
        HoaDonPhuPhiServiceImpl sv = new HoaDonPhuPhiServiceImpl();
        System.out.println(sv.getAllPhuPhi_HoaDonsByIdHoaDon(""));
        
    }
    
    @Override
    public QLHoaDon_PhuPhi getOne(String idPhuPhi,String idHoaDon) {
        PhuPhi_HoaDon phuPhi_HoaDon = repository.getOne(idPhuPhi,idHoaDon);
        if (phuPhi_HoaDon == null) {
            return null;
        }
        QLPhuPhi qLPhuPhi = new QLPhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi());
        QLHoaDon qLHoaDon = new QLHoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getMaHoaDon(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), null, null, phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
                phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
        return new QLHoaDon_PhuPhi(phuPhi_HoaDon.getId(), qLHoaDon, qLPhuPhi, phuPhi_HoaDon.getGiaPPHD(), phuPhi_HoaDon.getMoTa());
    }

    @Override
    public List<QLHoaDon_PhuPhi> getAllPhuPhi_HoaDonsByIdHoaDon(String idHoaDon) {
        List<QLHoaDon_PhuPhi> list = new ArrayList<>();
        for (PhuPhi_HoaDon phuPhi_HoaDon : repository.getAllPhuPhi_HoaDonsByIdHoaDon(idHoaDon)) {
            QLPhuPhi qLPhuPhi = new QLPhuPhi(phuPhi_HoaDon.getPhuPhi().getId(), phuPhi_HoaDon.getPhuPhi().getMaPhuPhi(), phuPhi_HoaDon.getPhuPhi().getTenPhuPhi());
            QLHoaDon qLHoaDon = new QLHoaDon(phuPhi_HoaDon.getHoaDon().getId(), phuPhi_HoaDon.getHoaDon().getMaHoaDon(), phuPhi_HoaDon.getHoaDon().getPhieuDatLich(), null, null, phuPhi_HoaDon.getHoaDon().getNgayThanhToan(),
                    phuPhi_HoaDon.getHoaDon().getDonGia(), phuPhi_HoaDon.getHoaDon().getTongTien(), phuPhi_HoaDon.getHoaDon().getGhiChu(), phuPhi_HoaDon.getHoaDon().getTrangThai());
            QLHoaDon_PhuPhi qLHoaDon_PhuPhi = new QLHoaDon_PhuPhi(phuPhi_HoaDon.getId(), qLHoaDon, qLPhuPhi, phuPhi_HoaDon.getGiaPPHD(), phuPhi_HoaDon.getMoTa());
            list.add(qLHoaDon_PhuPhi);
        }
        return list;
    }
}
