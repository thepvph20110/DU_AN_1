/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Acount;
import domainmodel.Ca;
import domainmodel.KhachHang;
import domainmodel.PhieuDatLich;
import domainmodel.SanCa;
import enumclass.trangThaiPhieuDL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import modelview.QLPhieuDatLich;
import repository.impl.AcountRepository;
import repository.impl.CaRepository;
import repository.impl.PhieuDatLichRepositoryImpl;
import repository.impl.SanCaRepository;
import service.IAcountService;
import service.ICaService;
import service.IPhieuDatLichService;

/**
 *
 * @author ADMIN
 */
public class PhieuDatLichServiceImpl implements IPhieuDatLichService{

    private final List<QLPhieuDatLich> listQLPhieuDatLich = new ArrayList<>();
    private final PhieuDatLichRepositoryImpl re = new PhieuDatLichRepositoryImpl();
    private CaRepository caRepository = new CaRepository();
    private AcountRepository acountRepository = new AcountRepository();
    private SanCaRepository sanCaRepository = new SanCaRepository();
    private Map<String, Object> map = new HashMap<>();
    
    @Override
    public List<QLPhieuDatLich> getAll() {
        listQLPhieuDatLich.clear();
        for (PhieuDatLich phieuDatLich : re.getAll()) {
            listQLPhieuDatLich.add(new QLPhieuDatLich(phieuDatLich.getId(), phieuDatLich.getAcount().getTenAcount(), phieuDatLich.getKhachHang().getTenKhachHang(), phieuDatLich.getSanCa().getCa().getTenCa(), phieuDatLich.getNgayTaoPhieu(), phieuDatLich.getNgayDenSan(), phieuDatLich.getTgCheckIn(), phieuDatLich.getGhiChu(), phieuDatLich.getTongTienSan(), phieuDatLich.getTrangThai()));
        }
        return listQLPhieuDatLich;
    }

    @Override
    public String save(QLPhieuDatLich qLPhieuDatLich) {
        KhachHang khachHang = new KhachHang();
        if(map.containsKey(qLPhieuDatLich.getKhachHang())){
            khachHang = (KhachHang) map.get(qLPhieuDatLich.getKhachHang());
        }
        
        Acount acount = new Acount();
        if(map.containsKey(qLPhieuDatLich.getAcount())){
            acount = (Acount) map.get(qLPhieuDatLich.getAcount());
        }
        
        SanCa sanCa = new SanCa();
        if(map.containsKey(qLPhieuDatLich.getSanCa())){
            sanCa = (SanCa) map.get(qLPhieuDatLich.getSanCa());
        }
        PhieuDatLich phieuDatLich = new PhieuDatLich(null, acount, khachHang, sanCa, qLPhieuDatLich.getNgayTaoPhieu(), qLPhieuDatLich.getNgayDenSan(), qLPhieuDatLich.getTgCheckIn(), qLPhieuDatLich.getGhiChu(), qLPhieuDatLich.getTongTienSan(), qLPhieuDatLich.getTrangThai());
        if(re.saveOrUpdate(phieuDatLich)){
            return "Save complete";
        }else{
            return "Save Fail";
        }
    }

    @Override
    public String update(QLPhieuDatLich qLPhieuDatLich) {
        KhachHang khachHang = new KhachHang();
        if(map.containsKey(qLPhieuDatLich.getKhachHang())){
            khachHang = (KhachHang) map.get(qLPhieuDatLich.getKhachHang());
        }
        
        Acount acount = new Acount();
        if(map.containsKey(qLPhieuDatLich.getAcount())){
            acount = (Acount) map.get(qLPhieuDatLich.getAcount());
        }
        
        SanCa sanCa = new SanCa();
        if(map.containsKey(qLPhieuDatLich.getSanCa())){
            sanCa = (SanCa) map.get(qLPhieuDatLich.getSanCa());
        }
        PhieuDatLich phieuDatLich = new PhieuDatLich(qLPhieuDatLich.getId(), acount, khachHang, sanCa, qLPhieuDatLich.getNgayTaoPhieu(), qLPhieuDatLich.getNgayDenSan(), qLPhieuDatLich.getTgCheckIn(), qLPhieuDatLich.getGhiChu(), qLPhieuDatLich.getTongTienSan(), qLPhieuDatLich.getTrangThai());
        if(re.saveOrUpdate(phieuDatLich)){
            return "Save complete";
        }else{
            return "Save Fail";
        }
    }
    
}
