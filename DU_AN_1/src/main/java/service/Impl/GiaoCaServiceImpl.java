/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainModel.GiaoCa;
import enumclass.trangThaiGiaoCa;
import java.util.Date;
import java.util.List;
import modelview.QLGiaoCa;
import repository.IGiaoCaRepository;
import repository.impl.GiaoCaRepository;
import response.ThanhToan.TongTienMatGiaoCa;
import service.IGiaoCaService;

/**
 *
 * @author DANG VAN SY
 */
public class GiaoCaServiceImpl implements IGiaoCaService {

    private IGiaoCaRepository giaoCaRepo = new GiaoCaRepository();
    private GiaoCa giaoCa = new GiaoCa();

    @Override
    public QLGiaoCa getOne(String ma) {
        giaoCa = giaoCaRepo.getOne(ma);
        return new QLGiaoCa(giaoCa.getId(), giaoCa.getMa(), giaoCa.getThoiGianNhanCa(), giaoCa.getThoiGianGiaoCa(), giaoCa.getIdNhanVienTrongCa(), giaoCa.getIdNhanVienCaTiepTheo(), giaoCa.getTienBanDau(), giaoCa.getTongTienTrongCa(), giaoCa.getTongTienMat(), giaoCa.getTongTienKhac(), giaoCa.getGhiChuPhatSinh(), giaoCa.getTongTienMatCaTruoc(), giaoCa.getThoiGianReset(), giaoCa.getIdAcount(), giaoCa.getTongTienMatRut(), giaoCa.getTrangThai());
    }

    @Override
    public String NhanCa(GiaoCa giaoCa) {
        return giaoCaRepo.NhanCa(giaoCa);
    }

    @Override
    public GiaoCa getOneByIdNV(String id) {
        return giaoCaRepo.getOneGiaoCaById(id);
    }

    @Override
    public double tongTienCaHienTaiByIdNV(String id) {
        return giaoCaRepo.tongTienCaHienTaiByIdNV(id);
    }

    @Override
    public int tongHoaDOnDaTT(String id) {
        return giaoCaRepo.tongHoaDOnDaTT(id);
    }

    @Override
    public int tongHoaDOnChuaTT(String id) {
        return giaoCaRepo.tongHoaDOnChuaTT(id);
    }

    @Override
    public double tongTienNganHang(String id) {
        return giaoCaRepo.tongTienNganHang(id);
    }

    @Override
    public String GiaoCa(GiaoCa giaoCa) {
        return giaoCaRepo.GiaoCa(giaoCa);
    }

    @Override
    public boolean checkCaTrong(String idNhanVienTrongCa) {
        if (giaoCaRepo.checkCaTrong(idNhanVienTrongCa).size() == 0) {
            return false;
        }
        return true;

    }

    @Override
    public GiaoCa checkCoNhanVIenKo() {
        return giaoCaRepo.checkCoNhanVIenKo();
    }

    @Override
    public GiaoCa getOneGiaoCaByIdAndTrangThai(String id) {
        return giaoCaRepo.getOneGiaoCaByIdAndTrangThai(id);
    }

    @Override
    public double tongTienMat(String id) {
        return giaoCaRepo.tongTienMat(id);
    }

    @Override
    public GiaoCa getNvCaTT() {
        return giaoCaRepo.TimKiemNVCaTiepTheo();
    }

    @Override
    public List<GiaoCa> getAll() {
        return giaoCaRepo.getAll();
    }

    @Override
    public List<GiaoCa> searchByName(String name) {
        return giaoCaRepo.searchByName(name);
    }

}
