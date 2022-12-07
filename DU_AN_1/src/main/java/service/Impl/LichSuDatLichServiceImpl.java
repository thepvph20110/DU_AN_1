package service.Impl;

import domainModel.LichSuDatLich;
import domainmodel.Acount;
import domainmodel.KhachHang;
import domainmodel.PhieuDatLich;
import domainmodel.SanCa;
import enumclass.trangThaiLichSuDatLich;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelview.QLAcount;
import modelview.QLKhachHang;
import modelview.QLLichSuDatLich;
import modelview.QLPhieuDatLich;
import modelview.QLSanCa;
import repository.ILichSuDatLichRepository;
import repository.impl.LichSuDatLichRepositoryImpl;
import service.ILichSuDatLichService;

public class LichSuDatLichServiceImpl implements ILichSuDatLichService {

    private final ILichSuDatLichRepository repository;
    private List<QLLichSuDatLich> lstQLLichSuDatLich;

    public LichSuDatLichServiceImpl() {
        repository = new LichSuDatLichRepositoryImpl();
        lstQLLichSuDatLich = new ArrayList<>();
    }

    @Override
    public List<QLLichSuDatLich> getAllLichSuDatLichs() {
        lstQLLichSuDatLich.clear();
        var lichSuDatLich = repository.getAllLichSuDatLichs();

        for (LichSuDatLich lstLichSu : lichSuDatLich) {
            QLAcount qLAcount = new QLAcount(lstLichSu.getPhieuDatLich().getAcount().getId(), null, lstLichSu.getPhieuDatLich().getAcount().getTenAcount(), null, null, null, null);

            QLKhachHang qLKhachHang = new QLKhachHang(lstLichSu.getPhieuDatLich().getKhachHang().getId(), lstLichSu.getPhieuDatLich().getKhachHang().getMaKhachHang(), lstLichSu.getPhieuDatLich().getKhachHang().getTenKhachHang(), null, lstLichSu.getPhieuDatLich().getKhachHang().getSoDienThoai(), null, null);

            QLSanCa qLSanCa = new QLSanCa(lstLichSu.getPhieuDatLich().getSanCa().getId(), lstLichSu.getPhieuDatLich().getSanCa().getCa().getTenCa(), lstLichSu.getPhieuDatLich().getSanCa().getSanbong().getTenSanBong(), 0, null, null, null, 0, null);

            QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(lstLichSu.getPhieuDatLich().getId(), qLAcount, qLKhachHang, qLSanCa, lstLichSu.getPhieuDatLich().getNgayTaoPhieu(), lstLichSu.getPhieuDatLich().getNgayDenSan(), lstLichSu.getPhieuDatLich().getTgCheckIn(), lstLichSu.getPhieuDatLich().getGhiChu(), lstLichSu.getPhieuDatLich().getMaQR(), lstLichSu.getPhieuDatLich().getTongTienSan(), lstLichSu.getPhieuDatLich().getTrangThai());

            QLLichSuDatLich qLLichSuDatLich = new QLLichSuDatLich(lstLichSu.getId(), qLPhieuDatLich, lstLichSu.getMaLichSu(), lstLichSu.getNgayDatLich(), lstLichSu.getNgayDenSan(), lstLichSu.getTrangThai());
            lstQLLichSuDatLich.add(qLLichSuDatLich);
        }
        return lstQLLichSuDatLich;
    }

    @Override
    public boolean save(QLLichSuDatLich qLLichSuDatLich) {

        PhieuDatLich pdl = new PhieuDatLich();
        pdl.setId(qLLichSuDatLich.getQLPhieuDatLich().getId());

        boolean save = repository.save(new LichSuDatLich(null, pdl, qLLichSuDatLich.getMaLichSu(), qLLichSuDatLich.getNgayDatLich(), qLLichSuDatLich.getNgayDenSan(), qLLichSuDatLich.getTrangThai()));
        return save;

    }

    @Override
    public boolean update(QLLichSuDatLich qLLichSuDatLich) {
        PhieuDatLich pdl = new PhieuDatLich();
        pdl.setId(qLLichSuDatLich.getQLPhieuDatLich().getId());

        boolean update = repository.save(new LichSuDatLich(qLLichSuDatLich.getId(), pdl, qLLichSuDatLich.getMaLichSu(), qLLichSuDatLich.getNgayDatLich(), qLLichSuDatLich.getNgayDenSan(), qLLichSuDatLich.getTrangThai()));
        return update;
    }

    @Override
    public boolean delete(String id) {
        boolean delete = repository.delete(id);
        return delete;
    }

    @Override
    public List<QLLichSuDatLich> getLichSuDatBySoDienThoai(String soDienThoai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QLLichSuDatLich> getLichSuDatByMaLichSu(String soDienThoai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
//        QLPhieuDatLich ql = new QLPhieuDatLich();
//        ql.setId("143f8bae-ce49-42d1-b033-cb43fb2eef7a");
//        Date datend = new Date(2022, 11, 22);
//        QLLichSuDatLich qLLichSuDatLich = new QLLichSuDatLich(null, ql, "LS00000", datend, datend, trangThaiLichSuDatLich.DA_DOI_LICH);
//        LichSuDatLichServiceImpl sc = new LichSuDatLichServiceImpl();
//        sc.save(qLLichSuDatLich);
//        List<QLLichSuDatLich> lstQLLichSuDatLichs = new ArrayList<>();
//        lstQLLichSuDatLichs = sc.getAllLichSuDatLichs();
//        List<Object> lst = new ArrayList<>();
//        for (QLLichSuDatLich lsts : lstQLLichSuDatLichs) {
//            lst.add(lsts);
//        }
//        String ma = sc.genMaObjectIndexs(lst, 0);
//        System.out.println(ma);
    }

    @Override
    public String genMaLichSu(List<QLLichSuDatLich> lstQLLichSuDatLichs) {
        int start;
        List<Integer> lstIntegers = new ArrayList<>();
        int kichThuoc = lstQLLichSuDatLichs.size();
        if (kichThuoc == 0) {
            start = 0;
            lstIntegers.add(1);
        } else {
            
            for (int i = 0; i < lstQLLichSuDatLichs.size(); i++) {
                start = Integer.parseInt(lstQLLichSuDatLichs.get(i).getMaLichSu().substring(4));
                lstIntegers.add(start);
            }
        }
        int max = lstIntegers.get(0);
        for (int i = 0; i < lstIntegers.size(); i++) {
            if (lstIntegers.get(i).compareTo(max) > 0) {
                max = lstIntegers.get(i);
            }
        }
        return "LS00" + (++max);
    }

    @Override
    public List<QLLichSuDatLich> getAllLichSuDatLichsBySoDienThoai(String soDienThoai) {
        lstQLLichSuDatLich.clear();
        List<QLLichSuDatLich> lstKhachHang = new ArrayList<>();
        var lichSuDatLich = repository.getAllLichSuDatLichs();
        for (LichSuDatLich lstLichSu : lichSuDatLich) {
            if (lstLichSu.getPhieuDatLich().getKhachHang().getSoDienThoai().equals(soDienThoai)) {
                QLAcount qLAcount = new QLAcount(lstLichSu.getPhieuDatLich().getAcount().getId(), null, lstLichSu.getPhieuDatLich().getAcount().getTenAcount(), null, null, null, null);

                QLKhachHang qLKhachHang = new QLKhachHang(lstLichSu.getPhieuDatLich().getKhachHang().getId(), lstLichSu.getPhieuDatLich().getKhachHang().getMaKhachHang(), lstLichSu.getPhieuDatLich().getKhachHang().getTenKhachHang(), null, lstLichSu.getPhieuDatLich().getKhachHang().getSoDienThoai(), null, null);

                QLSanCa qLSanCa = new QLSanCa(lstLichSu.getPhieuDatLich().getSanCa().getId(), lstLichSu.getPhieuDatLich().getSanCa().getCa().getTenCa(), lstLichSu.getPhieuDatLich().getSanCa().getSanbong().getTenSanBong(), 0, null, null, null, 0, null);

                QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(lstLichSu.getPhieuDatLich().getId(), qLAcount, qLKhachHang, qLSanCa, lstLichSu.getPhieuDatLich().getNgayTaoPhieu(), lstLichSu.getPhieuDatLich().getNgayDenSan(), lstLichSu.getPhieuDatLich().getTgCheckIn(), lstLichSu.getPhieuDatLich().getGhiChu(), lstLichSu.getPhieuDatLich().getMaQR(), lstLichSu.getPhieuDatLich().getTongTienSan(), lstLichSu.getPhieuDatLich().getTrangThai());

                QLLichSuDatLich qLLichSuDatLich = new QLLichSuDatLich(lstLichSu.getId(), qLPhieuDatLich, lstLichSu.getMaLichSu(), lstLichSu.getNgayDatLich(), lstLichSu.getNgayDenSan(), lstLichSu.getTrangThai());

                lstKhachHang.add(qLLichSuDatLich);
            }
        }
        return lstKhachHang;
    }

    @Override
    public List<QLLichSuDatLich> getAllLichSuDatLichsByTenKhachHang(String tenKhachHang) {
        lstQLLichSuDatLich.clear();
        List<QLLichSuDatLich> lstKhachHang = new ArrayList<>();
        var lichSuDatLich = repository.getAllLichSuDatLichs();
        for (LichSuDatLich lstLichSu : lichSuDatLich) {
            if (lstLichSu.getPhieuDatLich().getKhachHang().getTenKhachHang().equals(tenKhachHang)) {
                QLAcount qLAcount = new QLAcount(lstLichSu.getPhieuDatLich().getAcount().getId(), null, lstLichSu.getPhieuDatLich().getAcount().getTenAcount(), null, null, null, null);

                QLKhachHang qLKhachHang = new QLKhachHang(lstLichSu.getPhieuDatLich().getKhachHang().getId(), lstLichSu.getPhieuDatLich().getKhachHang().getMaKhachHang(), lstLichSu.getPhieuDatLich().getKhachHang().getTenKhachHang(), null, lstLichSu.getPhieuDatLich().getKhachHang().getSoDienThoai(), null, null);

                QLSanCa qLSanCa = new QLSanCa(lstLichSu.getPhieuDatLich().getSanCa().getId(), lstLichSu.getPhieuDatLich().getSanCa().getCa().getTenCa(), lstLichSu.getPhieuDatLich().getSanCa().getSanbong().getTenSanBong(), 0, null, null, null, 0, null);

                QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(lstLichSu.getPhieuDatLich().getId(), qLAcount, qLKhachHang, qLSanCa, lstLichSu.getPhieuDatLich().getNgayTaoPhieu(), lstLichSu.getPhieuDatLich().getNgayDenSan(), lstLichSu.getPhieuDatLich().getTgCheckIn(), lstLichSu.getPhieuDatLich().getGhiChu(), lstLichSu.getPhieuDatLich().getMaQR(), lstLichSu.getPhieuDatLich().getTongTienSan(), lstLichSu.getPhieuDatLich().getTrangThai());

                QLLichSuDatLich qLLichSuDatLich = new QLLichSuDatLich(lstLichSu.getId(), qLPhieuDatLich, lstLichSu.getMaLichSu(), lstLichSu.getNgayDatLich(), lstLichSu.getNgayDenSan(), lstLichSu.getTrangThai());

                lstKhachHang.add(qLLichSuDatLich);
            }
        }
        return lstKhachHang;
    }
}
