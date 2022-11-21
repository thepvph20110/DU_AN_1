/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonRepository {

    List<HoaDon> getAll();

    boolean save(HoaDon hoaDon);

    boolean update(HoaDon hoaDon);

    boolean delete(UUID id);
    
    List<HoaDon> getAllByTrangThai();
    
    List<HoaDon> searchByTen(String name);
    
    HoaDon findByHoaDonId(UUID uuid);
}
