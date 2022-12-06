/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ICaService;
import modelview.QLCa;
import repository.impl.CaRepository;

/**
 *
 * @author hp
 */
public class CaServiceImpl implements ICaService {

    private final CaRepository re = new CaRepository();
    private final List<QLCa> listQLCa = new ArrayList<>();
    private Map<String, Object> map = new HashMap<>();

    @Override
    public List<QLCa> getAll() {
        listQLCa.clear();
        for (Ca ca : re.getAll()) {
            map.put(ca.getMaCa(), ca);
            map.put(ca.getTenCa(), ca);
            QLCa qLCa = new QLCa(ca.getId(), ca.getMaCa(), ca.getTenCa(), ca.getThoiGianBatDau(), ca.getThoiGianKetThuc(), ca.getGiaCa(), ca.getTrangThai());
            listQLCa.add(qLCa);
        }
        return listQLCa;
    }

    @Override
    public String save(QLCa qLCa) {
        if (map.containsKey(qLCa.getMaCa()) || map.containsKey(qLCa.getTenCa())) {
            return "Ma trung";
        }
        Ca ca = new Ca(null, qLCa.getMaCa(), qLCa.getTenCa(), qLCa.getThoiGianBatDau(), qLCa.getThoiGianKetThuc(), qLCa.getGiaCa(), qLCa.getTrangThai());
        if (re.saveOrUpdate(ca)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String delete(QLCa qLCa) {
        Ca ca = new Ca(qLCa.getId(), qLCa.getMaCa(), qLCa.getTenCa(), qLCa.getThoiGianBatDau(), qLCa.getThoiGianKetThuc(), qLCa.getGiaCa(), qLCa.getTrangThai());
        if (re.deleteCa(ca)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }

    @Override
    public String update(QLCa qLCa) {
        Ca ca = new Ca(qLCa.getId(), qLCa.getMaCa(), qLCa.getTenCa(), qLCa.getThoiGianBatDau(), qLCa.getThoiGianKetThuc(), qLCa.getGiaCa(), qLCa.getTrangThai());
        if (re.saveOrUpdate(ca)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public List<QLCa> searchByName(String ten) {
        List<QLCa> qLCas = new ArrayList<>();
        for (Ca ca : re.searchByName(ten)) {
            QLCa qLCa = new QLCa(ca.getId(), ca.getMaCa(), ca.getTenCa(), ca.getThoiGianBatDau(), ca.getThoiGianKetThuc(), ca.getGiaCa(), ca.getTrangThai());
            qLCas.add(qLCa);
        }
        return qLCas;
    }

    @Override
    public String saveNewCa(Ca ca) {
        return re.saveCaNew(ca);
    }

    @Override
    public String xoaCa(String id) {
        return re.xoaCa(id);
    }
}
