/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.DoThue;
import domainmodel.KichThuoc;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import enumclass.trangThaiDoThue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelview.QLDoThue;
import repository.impl.DoThueRepositoryImpl;
import repository.impl.KichThuocRepositoryImpl;
import repository.impl.MauSacRepositoryImpl;
import repository.impl.NhaSanXuatRepositoryImpl;
import service.IDoThueService;

/**
 *
 * @author Admin
 */
public class DoThueServiceImpl implements IDoThueService {
    
    private NhaSanXuatRepositoryImpl nhaSanXuatRepositoryImpl = new NhaSanXuatRepositoryImpl();
    private MauSacRepositoryImpl mauSacRepositoryImpl = new MauSacRepositoryImpl();
    private KichThuocRepositoryImpl kichThuocRepositoryImpl = new KichThuocRepositoryImpl();
    private DoThueRepositoryImpl doThueRepositoryImpl = new DoThueRepositoryImpl();
    private List<DoThue> listDT = new ArrayList<>();
    private List<QLDoThue> listqldt = new ArrayList<>();
    private Map<String, Object> mapma = new HashMap();
    
    @Override
    public List<QLDoThue> getAll() {
        listDT = doThueRepositoryImpl.getAll();
        for (DoThue doThue : listDT) {
            mapma.put(doThue.getMaDoThue(), doThue);
            QLDoThue qldt = new QLDoThue(doThue.getId(), doThue.getMaDoThue(), doThue.getTenDoThue(), doThue.getKichThuoc().getMaSize(), String.valueOf(doThue.getKichThuoc().getSize()), doThue.getMauSac().getMaMauSac(), doThue.getMauSac().getTenMauSac(), doThue.getNhaSanXuat().getMaNSX(), doThue.getNhaSanXuat().getTenNSX(), doThue.getSoLuong(), doThue.getDonGia(), doThue.getTrangThai());
            listqldt.add(qldt);
            
        }
        return listqldt;
    }
    
    public static void main(String[] args) {
        System.out.println(new DoThueServiceImpl().getAll());
    }
    
    @Override
    public String AddorUpdate(QLDoThue qLDoThue) {
        if (mapma.containsKey(qLDoThue.getMaDoThue())) {
            return "Trùng Mã";
        } else {
            NhaSanXuat nsx = nhaSanXuatRepositoryImpl.getOne(qLDoThue.getMaNhaSanXuat());
            MauSac ms = mauSacRepositoryImpl.getOne(qLDoThue.getMaMauSac());
            KichThuoc kt = kichThuocRepositoryImpl.getOne(qLDoThue.getMaKichThuoc());
            DoThue dt = new DoThue(qLDoThue.getId(), qLDoThue.getMaDoThue(), qLDoThue.getTenDoThue(), kt, ms, nsx, qLDoThue.getSoLuong(), qLDoThue.getDonGia(), qLDoThue.getTrangThai());
            return doThueRepositoryImpl.AddorUpdate(dt);
        }
    }
    
    @Override
    public String Delete(QLDoThue qLDoThue) {
        NhaSanXuat nsx = nhaSanXuatRepositoryImpl.getOne(qLDoThue.getMaNhaSanXuat());
        MauSac ms = mauSacRepositoryImpl.getOne(qLDoThue.getMaMauSac());
        KichThuoc kt = kichThuocRepositoryImpl.getOne(qLDoThue.getMaKichThuoc());
        DoThue dt = new DoThue(qLDoThue.getId(), qLDoThue.getMaDoThue(), qLDoThue.getTenDoThue(), kt, ms, nsx, qLDoThue.getSoLuong(), qLDoThue.getDonGia(), qLDoThue.getTrangThai());
        return doThueRepositoryImpl.Delete(dt);
    }
    
    @Override
    public long countAllDoThue() {
        return doThueRepositoryImpl.totalCount();
    }
    
    @Override
    public List<QLDoThue> getNuocUongByTenDoThue(String tenDoThue) {
        listDT = doThueRepositoryImpl.findByTenDoThue(tenDoThue);
        for (DoThue doThue : listDT) {
            mapma.put(doThue.getMaDoThue(), doThue);
            QLDoThue qldt = new QLDoThue(doThue.getId(), doThue.getMaDoThue(), doThue.getTenDoThue(), doThue.getKichThuoc().getMaSize(), String.valueOf(doThue.getKichThuoc().getSize()), doThue.getMauSac().getMaMauSac(), doThue.getMauSac().getTenMauSac(), doThue.getNhaSanXuat().getMaNSX(), doThue.getNhaSanXuat().getTenNSX(), doThue.getSoLuong(), doThue.getDonGia(), doThue.getTrangThai());
            listqldt.add(qldt);
            
        }
        return listqldt;
    }
    
    @Override
    public List<QLDoThue> getDoThueByTranThai(trangThaiDoThue trangThai) {
        listDT = doThueRepositoryImpl.findByTrangThai(trangThai);
        for (DoThue doThue : listDT) {
            mapma.put(doThue.getMaDoThue(), doThue);
            QLDoThue qldt = new QLDoThue(doThue.getId(), doThue.getMaDoThue(), doThue.getTenDoThue(), doThue.getKichThuoc().getMaSize(), String.valueOf(doThue.getKichThuoc().getSize()), doThue.getMauSac().getMaMauSac(), doThue.getMauSac().getTenMauSac(), doThue.getNhaSanXuat().getMaNSX(), doThue.getNhaSanXuat().getTenNSX(), doThue.getSoLuong(), doThue.getDonGia(), doThue.getTrangThai());
            listqldt.add(qldt);
        }
        return listqldt;
    }
}
