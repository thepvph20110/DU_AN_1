/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.NhaSanXuat;
import java.util.List;
import repository.impl.NhaSanXuatRepositoryImpl;
import service.INhaSanXuatService;

/**
 *
 * @author Admin
 */
public class NhaSanXuatServiceImpl implements INhaSanXuatService{

    private NhaSanXuatRepositoryImpl  nhaSanXuatRepositoryImpl = new NhaSanXuatRepositoryImpl();
    
    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepositoryImpl.getAll();
    }

    @Override
    public String AddorUpdate(NhaSanXuat nhaSanXuat) {
        return nhaSanXuatRepositoryImpl.AddorUpdate(nhaSanXuat);
    }

    @Override
    public String Delete(NhaSanXuat nhaSanXuat) {
        return nhaSanXuatRepositoryImpl.Delete(nhaSanXuat);
    }
    
}
