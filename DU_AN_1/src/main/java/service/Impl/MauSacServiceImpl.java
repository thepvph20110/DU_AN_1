/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.MauSac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repository.impl.MauSacRepositoryImpl;
import service.IMauSacService;

/**
 *
 * @author Admin
 */
public class MauSacServiceImpl implements IMauSacService {

    private List<MauSac> listMSS = new ArrayList<>();
    private MauSacRepositoryImpl mauSacRepositoryImpl = new MauSacRepositoryImpl();
    private Map<String, Object> mapma = new HashMap();

    @Override
    public List<MauSac> getAll() {
        listMSS = mauSacRepositoryImpl.getAll();
        for (MauSac mauSac : listMSS) {
            mapma.put(mauSac.getMaMauSac(), mauSac.getTenMauSac());
        }
        return listMSS;
    }

    @Override
    public String AddorUpdate(MauSac mauSac) {
        if (mapma.containsKey(mauSac.getMaMauSac())) {
            return "Trùng Mã";
        } else {
            return mauSacRepositoryImpl.AddorUpdate(mauSac);
        }

    }

    @Override
    public String Delete(MauSac mauSac) {
        return mauSacRepositoryImpl.Delete(mauSac);
    }

    @Override
    public MauSac getOne(String ma) {
        return mauSacRepositoryImpl.getOne(ma);
    }

}
