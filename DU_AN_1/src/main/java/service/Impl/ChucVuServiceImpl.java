/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.ChucVu;
import enumclass.trangThaiChucVu;
import java.util.ArrayList;
import java.util.List;
import modelView.QLChucVu;
import repository.IChucVuRepository;
import repository.impl.ChucVuRepository;
import service.IChucVuService;

/**
 *
 * @author Admin
 */
public class ChucVuServiceImpl implements IChucVuService {

    private IChucVuRepository chucVuRepo = new ChucVuRepository();

    @Override
    public List<QLChucVu> getAll() {
        List<QLChucVu> qLChucVus = new ArrayList<>();
        for (ChucVu chucVu : chucVuRepo.getAll()) {
            QLChucVu qLChucVu = new QLChucVu(chucVu.getId(), chucVu.getMaChucVu(), chucVu.getTenChucVu(), trangThaiChucVu.HOAT_DONG);
            qLChucVus.add(qLChucVu);
        }
        return qLChucVus;
    }

    @Override
    public String save(QLChucVu qLChucVu) {
        if (qLChucVu.getMaChucVu().isEmpty() && qLChucVu.getTenChucVu().isEmpty()) {
            return "Không Được Để Trống !!";
        }

        ChucVu chucVu = new ChucVu(null, qLChucVu.getMaChucVu(), qLChucVu.getTenChucVu(), qLChucVu.getTrangThai());
        if (chucVuRepo.save(chucVu) == true) {
            return "Thêm Thành Công";
        }
        return "Thêm Thất Bại";
    }

    @Override
    public String update(QLChucVu qLChucVu, UUID id) {
        if (qLChucVu.getMaChucVu().isEmpty() && qLChucVu.getTenChucVu().isEmpty()) {
            return "Không Được Để Trống !!";
        }
        ChucVu chucVu = new ChucVu(id, qLChucVu.getMaChucVu(), qLChucVu.getTenChucVu(), qLChucVu.getTrangThai());
        if (chucVuRepo.update(chucVu) == true) {
            return "Sửa Thành Công";
        }
        return "Sửa Thất Bại";
    }

    @Override
    public String delete(UUID id) {
        if (chucVuRepo.delete(id) == true) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }

    @Override
    public String genMaChucVu() {
        String pp = chucVuRepo.genMaChucVu();
        int newPP = (Integer.parseInt(pp.substring(2))) + 1;
        return  pp.substring(0, 2) + "00"+ newPP ;
    }

}
