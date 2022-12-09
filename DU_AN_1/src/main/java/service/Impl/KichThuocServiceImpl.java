/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.KichThuoc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repository.impl.KichThuocRepositoryImpl;
import service.IKichThuocService;

/**
 *
 * @author Admin
 */
public class KichThuocServiceImpl implements IKichThuocService {

    private KichThuocRepositoryImpl kichThuocRepositoryImpl = new KichThuocRepositoryImpl();
    private List<KichThuoc> listKthuoc = new ArrayList<>();
    private Map<String, Object> mapma = new HashMap();

    @Override
    public List<KichThuoc> getAll() {
        listKthuoc = kichThuocRepositoryImpl.getAll();
        for (KichThuoc kichThuoc : listKthuoc) {
            mapma.put(kichThuoc.getMaSize(), kichThuoc.getSize());
        }
        return listKthuoc;
    }

    @Override
    public String AddorUpdate(KichThuoc kichThuoc) {
        return kichThuocRepositoryImpl.AddorUpdate(kichThuoc);
    }

    @Override
    public String Delete(KichThuoc kichThuoc) {
        return kichThuocRepositoryImpl.Delete(kichThuoc);
    }

    @Override
    public KichThuoc getOne(String ma) {
        return kichThuocRepositoryImpl.getOne(ma);
    }

}
