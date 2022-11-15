/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.LoaiSan;
import domainmodel.SanBong;
import java.util.ArrayList;
import java.util.List;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import repository.impl.SanBongRepository;
import service.ISanBongService;

/**
 *
 * @author hp
 */
public class SanBongServiceImpl implements ISanBongService {

    private final List<QLSanBong> listQLSanBong = new ArrayList<>();
    private final SanBongRepository re = new SanBongRepository();

    @Override
    public List<QLSanBong> getAll() {
        listQLSanBong.clear();
        for (SanBong sanBong : re.getAll()) {
            QLLoaiSan loaiSan = new QLLoaiSan(sanBong.getLoaiSan().getId(), sanBong.getLoaiSan().getMaLoaiSan(), sanBong.getLoaiSan().getTenLoaiSan(), sanBong.getLoaiSan().getMoTa());
            QLSanBong qLSanBong = new QLSanBong(sanBong.getId(), sanBong.getMaSanBong(), sanBong.getTenSanBong(), sanBong.getGiaSan(), sanBong.getSucChua(), loaiSan, sanBong.getTrangThai());
            listQLSanBong.add(qLSanBong);
        }
        return listQLSanBong;
    }

    @Override
    public String save(QLSanBong qLSanBong) {
        LoaiSan loaiSan = new LoaiSan(qLSanBong.getQLloaiSan().getId(), null, null, null);
        SanBong sanBong = new SanBong(null, qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.saveOrUpdate(sanBong)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLSanBong qLSanBong) {
        LoaiSan loaiSan = new LoaiSan(qLSanBong.getQLloaiSan().getId(), null, null, null);
        SanBong sanBong = new SanBong(qLSanBong.getId(), qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.saveOrUpdate(sanBong)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String delete(QLSanBong qLSanBong) {
        LoaiSan loaiSan = new LoaiSan(qLSanBong.getQLloaiSan().getId(), null, null, null);
        SanBong sanBong = new SanBong(qLSanBong.getId(), qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.deleteSanBong(sanBong)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

}
