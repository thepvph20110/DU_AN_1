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
    public String saveOrUpdate(QLGiaoCa qLGiaoCa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TongTienMatGiaoCa> getTongTienMatHienTai(Date thoiGianNhanCa, Date thoiGianCuoiCa) {
        return giaoCaRepo.getTongTienMatHienTai(thoiGianNhanCa, thoiGianNhanCa);
    }

    @Override
    public List<TongTienMatGiaoCa> getTongTienKhacHienTai(Date thoiGianNhanCa, Date thoiGianCuoiCa) {
        return giaoCaRepo.getTongTienKhacHienTai(thoiGianNhanCa, thoiGianNhanCa);
    }

}
