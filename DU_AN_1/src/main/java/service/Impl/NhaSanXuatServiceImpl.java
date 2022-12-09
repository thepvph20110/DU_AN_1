/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.NhaSanXuat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repository.impl.NhaSanXuatRepositoryImpl;
import service.INhaSanXuatService;

/**
 *
 * @author Admin
 */
public class NhaSanXuatServiceImpl implements INhaSanXuatService {

    private NhaSanXuatRepositoryImpl nhaSanXuatRepositoryImpl = new NhaSanXuatRepositoryImpl();
    private List<NhaSanXuat> listNSX = new ArrayList<>();
    private Map<String, Object> mapma = new HashMap();

    @Override
    public List<NhaSanXuat> getAll() {
        listNSX = nhaSanXuatRepositoryImpl.getAll();
        for (NhaSanXuat nhaSanXuat : listNSX) {
            mapma.put(nhaSanXuat.getMaNSX(), nhaSanXuat.getTenNSX());
        }
        return listNSX;
    }

    @Override
    public String AddorUpdate(NhaSanXuat nhaSanXuat) {
        return nhaSanXuatRepositoryImpl.AddorUpdate(nhaSanXuat);
    }

    @Override
    public String Delete(NhaSanXuat nhaSanXuat) {
        return nhaSanXuatRepositoryImpl.Delete(nhaSanXuat);
    }

    @Override
    public NhaSanXuat getOne(String ma) {
        return nhaSanXuatRepositoryImpl.getOne(ma);
    }

    @Override
    public String genMaNSX() {
        int maAC = nhaSanXuatRepositoryImpl.genMaNSX();
        return "NSX00"+maAC;
    }

}
