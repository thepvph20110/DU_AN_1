/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Ca;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<QLCa> getAll() {
        listQLCa.clear();
        for (Ca ca : re.getAll()) {
            QLCa qLCa = new QLCa(ca.getId(), ca.getMaCa(), ca.getTenCa(), ca.getThoiGianBatDau(), ca.getThoiGianKetThuc(), ca.getGiaCa(), ca.getTrangThai());
            listQLCa.add(qLCa);
        }
        return listQLCa;
    }

    @Override
    public String save(QLCa qLCa) {
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
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

}
