/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Ca;
import domainmodel.PhieuDatLich;
import domainmodel.SanBong;
import domainmodel.SanCa;
import enumclass.trangThaiSanCa;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelview.QLCa;
import modelview.QLPhieuDatLich;
import modelview.QLSanBong;
import modelview.QLSanCa;
import repository.ICaRepository;
import repository.ISanBongRepository;
import repository.impl.CaRepository;
import repository.impl.SanBongRepository;
import repository.impl.SanCaRepository;
import service.ISanCaService;

/**
 *
 * @author hp
 */
public class SanCaServiceImpl implements ISanCaService {

    private final List<QLSanCa> listQLSanCa = new ArrayList<>();
    private final SanCaRepository re = new SanCaRepository();
    private Map<String, Object> map = new HashMap<>();
    private ISanBongRepository isb = new SanBongRepository();
    private ICaRepository ica = new CaRepository();

    @Override
    public List<QLSanCa> getAll() {
        List<Ca> listQLCa = ica.getAll();
        List<SanBong> listSanBong = isb.getAll();
        listQLSanCa.clear();
        for (SanBong sanBong : listSanBong) {
            map.put(sanBong.getTenSanBong(), sanBong);
            map.put(sanBong.getMaSanBong(), sanBong);
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getMaCa(), ca);
            map.put(ca.getTenCa(), ca);
        }
        for (SanCa sanCa : re.getAll()) {
            QLSanCa qlsc = new QLSanCa(sanCa.getId(), sanCa.getCa().getTenCa(), sanCa.getSanbong().getTenSanBong(), (sanCa.getNgayTao()), sanCa.getGiaCa(), sanCa.getTrangThai());
            listQLSanCa.add(qlsc);
        }
        return listQLSanCa;
    }

    @Override
    public String save(QLSanCa qLSanCa) {
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getCa())) {
            ca = (Ca) map.get(qLSanCa.getCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getSanBong())) {
            sanBong = (SanBong) map.get(qLSanCa.getSanBong());
        }
        SanCa sanCa = new SanCa(null, ca, sanBong, qLSanCa.getNgayTao(), ca.getGiaCa()+sanBong.getGiaSan(), qLSanCa.getTrangThai());
        if (re.saveOrUpdate(sanCa)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLSanCa qLSanCa) {
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getCa())) {
            ca = (Ca) map.get(qLSanCa.getCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getSanBong())) {
            sanBong = (SanBong) map.get(qLSanCa.getSanBong());
        }
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, sanBong, qLSanCa.getNgayTao(), qLSanCa.getGiaCa(), qLSanCa.getTrangThai());
        if (re.saveOrUpdate(sanCa)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QLSanCa qLSanCa) {
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getCa())) {
            ca = (Ca) map.get(qLSanCa.getCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getSanBong())) {
            ca = (Ca) map.get(qLSanCa.getSanBong());
        }
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, sanBong, qLSanCa.getNgayTao(), qLSanCa.getGiaCa(), qLSanCa.getTrangThai());
        if (re.deleteSanCa(sanCa)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new SanCaServiceImpl().getAll().size());
    }

}
