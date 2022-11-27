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
    
<<<<<<< HEAD
    HoaDon findByHoaDonId(UUID uuid);
=======
    HoaDon findByHoaDonId(String uuid);
    
    String genMaHoaDon();
>>>>>>> 0f4cad2f7c54da986d78447c8a91cf878af78d91
}
