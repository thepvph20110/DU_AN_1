/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Ca;
import domainmodel.PhieuDatLich;
import domainmodel.SanBong;
import domainmodel.SanCa;
import java.util.ArrayList;
import java.util.List;
import modelview.QLCa;
import modelview.QLPhieuDatLich;
import modelview.QLSanBong;
import modelview.QLSanCa;
import repository.impl.SanCaRepository;
import service.ISanCaService;

/**
 *
 * @author hp
 */
public class SanCaServiceImpl implements ISanCaService {

    private final List<QLSanCa> listQLSanCa = new ArrayList<>();
    private final SanCaRepository re = new SanCaRepository();

    @Override
    public List<QLSanCa> getAll() {
        listQLSanCa.clear();
        for (SanCa sanCa : re.getAll()) {
            QLCa qLCa = new QLCa(sanCa.getCa().getId(), null, sanCa.getCa().getTenCa(), null, null, 0, null);
            QLPhieuDatLich qLPhieuDatLich = new QLPhieuDatLich(sanCa.getPhieuDatLich().getId(), null, sanCa.getPhieuDatLich().getNgayTaoPhieu(), null, null, null, 0, null);
            QLSanBong qLSanBong = new QLSanBong(sanCa.getSanBong().getId(), null, sanCa.getSanBong().getTenSanBong(), 0, 0, null, null);
            QLSanCa qlsc = new QLSanCa(sanCa.getId(), qLCa, qLPhieuDatLich, qLSanBong, sanCa.getGiaCa(), sanCa.getTrangThai());
            listQLSanCa.add(qlsc);
        }
        return listQLSanCa;
    }

    @Override
    public String save(QLSanCa qLSanCa) {
        Ca ca = new Ca(qLSanCa.getQLca().getId(), null, null, null, null, 0, null);
        PhieuDatLich phieuDatLich = new PhieuDatLich(qLSanCa.getQLphieuDatLich().getId(), null, null, null, null, null, null, 0, null);
        SanBong sanBong = new SanBong(qLSanCa.getSanBong().getId(), null, null, 0, 0, null, null);
        SanCa sanCa = new SanCa(null, ca, phieuDatLich, sanBong, qLSanCa.getGiaCa(), qLSanCa.getTrangThai());
        if (re.saveOrUpdate(sanCa)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLSanCa qLSanCa) {
        Ca ca = new Ca(qLSanCa.getQLca().getId(), null, null, null, null, 0, null);
        PhieuDatLich phieuDatLich = new PhieuDatLich(qLSanCa.getQLphieuDatLich().getId(), null, null, null, null, null, null, 0, null);
        SanBong sanBong = new SanBong(qLSanCa.getSanBong().getId(), null, null, 0, 0, null, null);
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, phieuDatLich, sanBong, qLSanCa.getGiaCa(), qLSanCa.getTrangThai());
        if (re.saveOrUpdate(sanCa)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QLSanCa qLSanCa) {
         Ca ca = new Ca(qLSanCa.getQLca().getId(), null, null, null, null, 0, null);
        PhieuDatLich phieuDatLich = new PhieuDatLich(qLSanCa.getQLphieuDatLich().getId(), null, null, null, null, null, null, 0, null);
        SanBong sanBong = new SanBong(qLSanCa.getSanBong().getId(), null, null, 0, 0, null, null);
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, phieuDatLich, sanBong, qLSanCa.getGiaCa(), qLSanCa.getTrangThai());
        if (re.deleteSanCa(sanCa)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }

}
