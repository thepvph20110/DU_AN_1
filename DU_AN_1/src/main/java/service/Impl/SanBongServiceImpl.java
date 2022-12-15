/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.LoaiSan;
import domainmodel.SanBong;
import enumclass.trangThaiSanBong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelview.QLLoaiSan;
import modelview.QLSanBong;
import repository.ILoaiSanRepository;
import repository.impl.LoaiSanRepository;
import repository.impl.SanBongRepository;
import service.ISanBongService;

/**
 *
 * @author hp
 */
public class SanBongServiceImpl implements ISanBongService {

    private final List<QLSanBong> listQLSanBong = new ArrayList<>();
    private final SanBongRepository re = new SanBongRepository();
    private Map<String, Object> map = new HashMap<>();
    private ILoaiSanRepository ire = new LoaiSanRepository();

    @Override
     

    public List<QLSanBong> getAll() {
        List<LoaiSan> listLoaiSan = ire.getAll();
        for (LoaiSan loaiSan : listLoaiSan) {
            map.put(loaiSan.getTenLoaiSan(), loaiSan);
            map.put(loaiSan.getMaLoaiSan(), loaiSan);
        }
        listQLSanBong.clear();
        for (SanBong sanBong : re.getAll()) {
            listQLSanBong.add(new QLSanBong(sanBong.getId(), sanBong.getMaSanBong(), sanBong.getTenSanBong(),sanBong.getGiaSan(), sanBong.getSucChua(), sanBong.getLoaiSan().getTenLoaiSan(), sanBong.getTrangThai()));
        }
        return listQLSanBong;
    }

    @Override
    public String save(QLSanBong qLSanBong) {
        if(map.containsKey(qLSanBong.getMaSanBong()) || map.containsKey(qLSanBong.getTenSanBong())){
            return "Ma or Ten Trung";
        }
        LoaiSan loaiSan = new LoaiSan();
        if(map.containsKey(qLSanBong.getTenLoaiSan())){
            loaiSan =(LoaiSan) map.get(qLSanBong.getTenLoaiSan());
        }
        SanBong sanBong = new SanBong(null, qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.saveOrUpdate(sanBong)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLSanBong qLSanBong) {
        LoaiSan loaiSan = new LoaiSan();
        if(map.containsKey(qLSanBong.getTenLoaiSan())){
            loaiSan =(LoaiSan) map.get(qLSanBong.getTenLoaiSan());
        }
        SanBong sanBong = new SanBong(qLSanBong.getId(), qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.saveOrUpdate(sanBong)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String delete(QLSanBong qLSanBong) {
        LoaiSan loaiSan = new LoaiSan();
        if(map.containsKey(qLSanBong.getTenLoaiSan())){
            loaiSan =(LoaiSan) map.get(qLSanBong.getTenLoaiSan());
        }SanBong sanBong = new SanBong(qLSanBong.getId(), qLSanBong.getMaSanBong(), qLSanBong.getTenSanBong(), qLSanBong.getGiaSan(), qLSanBong.getSucChua(), loaiSan, qLSanBong.getTrangThai());
        if (re.deleteSanBong(sanBong)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new SanBongServiceImpl().getAll());
    }

    @Override
    public List<QLSanBong> searchByName(String ten) {
        List<QLSanBong> qLSanBongs = new ArrayList<>();
        for (SanBong sanBong : re.searchByName(ten)) {
            QLSanBong qLsanBong = new QLSanBong(sanBong.getId(), sanBong.getMaSanBong(), sanBong.getTenSanBong(),sanBong.getGiaSan(), sanBong.getSucChua(), sanBong.getLoaiSan().getTenLoaiSan(), sanBong.getTrangThai());
            qLSanBongs.add(qLsanBong);
        }
        return qLSanBongs;
    }

<<<<<<< HEAD
=======
    @Override
    public String saveSanBong(SanBong sanBong) {
        return re.saveSanBong(sanBong);
    }

    @Override
    public String deleteSanBongNew(SanBong sanBong) {
        if (re.deleteSanBong(sanBong) == true) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }

    @Override
    public String xoaSan(String id) {
        return re.xoaSaṇ̣̣̣̣(id);
    }

    @Override
    public String genMaSanBong() {
        return "SB00" + re.genMaSanBong();
    }

>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
