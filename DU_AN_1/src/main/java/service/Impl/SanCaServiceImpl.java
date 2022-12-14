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
    private SanCaRepository re = new SanCaRepository();
    private Map<String, Object> map = new HashMap<>();
    private ISanBongRepository isb = new SanBongRepository();
    private ICaRepository ica = new CaRepository();
    private List<SanCa> lisSanCaDomain = new ArrayList<>();

    @Override
    public List<QLSanCa> getAll(Date ngayTao) {
        List<Ca> listQLCa = ica.getAll();
        List<SanBong> listSanBong = isb.getAll();
        listQLSanCa.clear();
        for (SanBong sanBong : listSanBong) {
            map.put(sanBong.getTenSanBong(), sanBong);
            map.put(sanBong.getMaSanBong(), sanBong);
            map.put(String.valueOf(sanBong.getGiaSan()), sanBong);
            map.put(String.valueOf(sanBong.getSucChua()), sanBong);
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getMaCa(), ca);
            map.put(ca.getTenCa(), ca);
            map.put(String.valueOf(ca.getGiaCa()), ca);
            map.put(String.valueOf(ca.getThoiGianBatDau()), ca);
            map.put(String.valueOf(ca.getThoiGianKetThuc()), ca);
        }
        for (SanCa sanCa : re.getAll(ngayTao)) {
            QLSanCa qLSanCa = new QLSanCa(sanCa.getId(), sanCa.getCa().getTenCa(), sanCa.getSanbong().getTenSanBong(), sanCa.getSanbong().getSucChua(), sanCa.getCa().getThoiGianBatDau(), sanCa.getCa().getThoiGianKetThuc(), sanCa.getNgayTao(), sanCa.getSanbong().getGiaSan() + sanCa.getCa().getGiaCa(), sanCa.getTrangThai());
            listQLSanCa.add(qLSanCa);
        }
        return listQLSanCa;
    }

    @Override
    public String save(QLSanCa qLSanCa) {
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getTenCa())) {
            ca = (Ca) map.get(qLSanCa.getTenCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getTenSanBong())) {
            sanBong = (SanBong) map.get(qLSanCa.getTenSanBong());
        }
        SanCa sanCa = new SanCa(null, ca, sanBong, new Date(), ca.getGiaCa() + sanBong.getGiaSan(), qLSanCa.getTrangThai());
        if (re.save(sanCa)) {
            return "Save Complete";
        } else {
            return "Save Fail";
        }
    }

    @Override
    public String update(QLSanCa qLSanCa) {
        List<Ca> listQLCa = ica.getAll();
        List<SanBong> listSanBong = isb.getAll();
        listQLSanCa.clear();
        for (SanBong sanBong : listSanBong) {
            map.put(sanBong.getTenSanBong(), sanBong);
            map.put(sanBong.getMaSanBong(), sanBong);
            map.put(String.valueOf(sanBong.getGiaSan()), sanBong);
            map.put(String.valueOf(sanBong.getSucChua()), sanBong);
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getMaCa(), ca);
            map.put(ca.getTenCa(), ca);
            map.put(String.valueOf(ca.getGiaCa()), ca);
            map.put(String.valueOf(ca.getThoiGianBatDau()), ca);
            map.put(String.valueOf(ca.getThoiGianKetThuc()), ca);
        }
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getTenCa())) {
            ca = (Ca) map.get(qLSanCa.getTenCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getTenSanBong())) {
            sanBong = (SanBong) map.get(qLSanCa.getTenSanBong());
        }
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, sanBong, qLSanCa.getNgayTao(), ca.getGiaCa() + sanBong.getGiaSan(), qLSanCa.getTrangThai());
        if (re.update(sanCa)) {
            return "Update Complete";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String delete(QLSanCa qLSanCa) {
        Ca ca = new Ca();
        if (map.containsKey(qLSanCa.getTenCa())) {
            ca = (Ca) map.get(qLSanCa.getTenCa());
        }
        SanBong sanBong = new SanBong();
        if (map.containsKey(qLSanCa.getTenSanBong())) {
            sanBong = (SanBong) map.get(qLSanCa.getTenSanBong());
        }
        SanCa sanCa = new SanCa(qLSanCa.getId(), ca, sanBong, new Date(), ca.getGiaCa() + sanBong.getGiaSan(), qLSanCa.getTrangThai());
        if (re.deleteSanCa(sanCa)) {
            return "Delete Complete";
        } else {
            return "Delete Fail";
        }
    }

    @Override
    public SanCa getOne() {
        SanCa sanCa = re.getOne();
        QLSanCa qLSanCa = new QLSanCa(sanCa.getId(), sanCa.getCa().getTenCa(), sanCa.getSanbong().getTenSanBong(), sanCa.getSanbong().getSucChua(), sanCa.getCa().getThoiGianBatDau(), sanCa.getCa().getThoiGianKetThuc(), sanCa.getNgayTao(), sanCa.getSanbong().getGiaSan() + sanCa.getCa().getGiaCa(), sanCa.getTrangThai());
        return sanCa;
    }

    @Override
    public String addListSanCa(List<QLSanCa> list) {
        List<Ca> listQLCa = ica.getAll();
        List<SanBong> listSanBong = isb.getAll();
        listQLSanCa.clear();
        List<SanCa> listSanCaEntity= new ArrayList<>();
        for (SanBong sanBong : listSanBong) {
            map.put(sanBong.getId(), sanBong);
        }
        for (Ca ca : listQLCa) {
            map.put(ca.getId(), ca);
        }
        for (QLSanCa qLSanCa : list) {
            Ca ca = new Ca();
            if (map.containsKey(qLSanCa.getTenCa())) {
                ca = (Ca) map.get(qLSanCa.getTenCa());
            }
            SanBong sanBong = new SanBong();
            if (map.containsKey(qLSanCa.getTenSanBong())) {
                sanBong = (SanBong) map.get(qLSanCa.getTenSanBong());
            }
            SanCa sanCa = new SanCa(null, ca, sanBong, qLSanCa.getNgayTao(), ca.getGiaCa() + sanBong.getGiaSan(), qLSanCa.getTrangThai());
            listSanCaEntity.add(sanCa);
        }
        try {
            for (SanCa sanCa : listSanCaEntity) {
                re.saveOutSanCa(sanCa);
            }
            return "Save Complete";
        } catch (Exception e) {
            return "Save Fail";
        }

//        if (re.saveOutSanCa(lisSanCaDomain)) {
//            
//        } else {
//            
//        }
    }

    @Override
    public List<QLSanCa> getByNgayTao(Date ngayTao) {
        List<QLSanCa> listQlSC = new ArrayList<>();
        for (SanCa sanCa : re.getByNgayTao(ngayTao)) {
            QLSanCa qLSanCa = new QLSanCa(sanCa.getId(), sanCa.getCa().getTenCa(), sanCa.getSanbong().getTenSanBong(), sanCa.getSanbong().getSucChua(), sanCa.getCa().getThoiGianBatDau(), sanCa.getCa().getThoiGianKetThuc(), sanCa.getNgayTao(), sanCa.getGiaSanCa(), sanCa.getTrangThai());
            listQlSC.add(qLSanCa);
        }
        return listQlSC;
    }

    @Override
    public List<SanCa> getSanCaByIdSanBong(String id, Date ngayTaoSanCa) {
        return re.getSanCaByIdSanBong(id, ngayTaoSanCa);
    }

    @Override
    public List<QLSanCa> getAllByNgayTao(String ngayTao) {
         List<QLSanCa> listQlSC = new ArrayList<>();
        for (SanCa sanCa : re.getAllByNgayTao(ngayTao)) {
            QLSanCa qLSanCa = new QLSanCa(sanCa.getId(), sanCa.getCa().getTenCa(), sanCa.getSanbong().getTenSanBong(), sanCa.getSanbong().getSucChua(), sanCa.getCa().getThoiGianBatDau(), sanCa.getCa().getThoiGianKetThuc(), sanCa.getNgayTao(), sanCa.getGiaSanCa(), sanCa.getTrangThai());
            listQlSC.add(qLSanCa);
        }
        return listQlSC;
    }

}
