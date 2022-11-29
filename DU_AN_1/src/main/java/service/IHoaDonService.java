/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import java.util.List;
import java.util.UUID;
import modelview.QLHoaDon;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonService {

    List<QLHoaDon> getAll();

    String save(QLHoaDon qLHoaDon);

    String update(QLHoaDon qLHoaDon, UUID id);

    String delete(String id);
    
    List<QLHoaDon> getAllByTrangThai();
    
    List<QLHoaDon> searchByName(String name);
      
    HoaDon findByHoaDonId(String uuid);
    
      String genMaHoaDon();

}
