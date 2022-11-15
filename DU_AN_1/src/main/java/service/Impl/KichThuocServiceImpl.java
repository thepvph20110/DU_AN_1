/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.KichThuoc;
import java.util.List;
import repository.impl.KichThuocRepositoryImpl;
import service.IKichThuocService;

/**
 *
 * @author Admin
 */
public class KichThuocServiceImpl implements IKichThuocService{
    
    private KichThuocRepositoryImpl kichThuocRepositoryImpl = new KichThuocRepositoryImpl();

    @Override
    public List<KichThuoc> getAll() {
        return kichThuocRepositoryImpl.getAll();
    }

    @Override
    public String AddorUpdate(KichThuoc kichThuoc) {
        return kichThuocRepositoryImpl.AddorUpdate(kichThuoc);
    }

    @Override
    public String Delete(KichThuoc kichThuoc) {
        return kichThuocRepositoryImpl.Delete(kichThuoc);
    }
    
    
    
}
