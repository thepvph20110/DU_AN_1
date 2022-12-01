/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.LoaiSan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelview.QLLoaiSan;
import repository.impl.LoaiSanRepository;
import service.ILoaiSanService;

/**
 *
 * @author hp
 */
public class LoaiSanServiceImpl implements ILoaiSanService {

    private final List<QLLoaiSan> listQLLoaiSan = new ArrayList<>();
    private final LoaiSanRepository re = new LoaiSanRepository();
    private Map<String, Object> map = new HashMap<>();

    @Override
    public List<QLLoaiSan> getAll() {
        listQLLoaiSan.clear();
        for (LoaiSan loaiSan : re.getAll()) {
            map.put(loaiSan.getMaLoaiSan(), loaiSan);
            map.put(loaiSan.getTenLoaiSan(), loaiSan);
            QLLoaiSan qLLoaiSan = new QLLoaiSan(loaiSan.getId(), loaiSan.getMaLoaiSan(), loaiSan.getTenLoaiSan(), loaiSan.getMoTa());
            listQLLoaiSan.add(qLLoaiSan);
        }
        return listQLLoaiSan;
    }

    @Override
    public String save(QLLoaiSan qLLoaiSan) {
        if (map.containsKey(qLLoaiSan.getMaLoaiSan()) || map.containsKey(qLLoaiSan.getTenLoaiSan())) {
            return "Ma trung";
        }
        LoaiSan loaiSan = new LoaiSan(null, qLLoaiSan.getMaLoaiSan(), qLLoaiSan.getTenLoaiSan(), qLLoaiSan.getMoTa());
        if (re.saveOrUpdate(loaiSan)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLLoaiSan qLLoaiSan) {
        LoaiSan loaiSan = new LoaiSan(qLLoaiSan.getId(), qLLoaiSan.getMaLoaiSan(), qLLoaiSan.getTenLoaiSan(), qLLoaiSan.getMoTa());
        if (re.saveOrUpdate(loaiSan)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QLLoaiSan qLLoaiSan) {
        LoaiSan loaiSan = new LoaiSan(qLLoaiSan.getId(), qLLoaiSan.getMaLoaiSan(), qLLoaiSan.getTenLoaiSan(), qLLoaiSan.getMoTa());
        if (re.deleteLoaiSan(loaiSan)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }

    @Override
    public List<QLLoaiSan> searchByName(String ten) {
        List<QLLoaiSan> qLLoaiSans = new ArrayList<>();
        for (LoaiSan loaiSan : re.searchByName(ten)) {
            QLLoaiSan qLLoaiSan = new QLLoaiSan(loaiSan.getId(), loaiSan.getMaLoaiSan(), loaiSan.getTenLoaiSan(), loaiSan.getMoTa());
            qLLoaiSans.add(qLLoaiSan);
        }
        return qLLoaiSans;
    }
}
