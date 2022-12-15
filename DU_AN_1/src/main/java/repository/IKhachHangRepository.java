/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.KhachHang;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IKhachHangRepository {
    
    List<KhachHang> getAll();
    
    boolean saveOrUpdate(KhachHang khachHang);
    
    boolean save(KhachHang khachHang);
    
    boolean delete(KhachHang khachHang);
    
    List<KhachHang> searchByName(String ten);
    
    int genMaKH();
}
