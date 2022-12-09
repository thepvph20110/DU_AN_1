/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonRepository {

    List<HoaDon> getAll();

    boolean save(HoaDon hoaDon);

    boolean update(HoaDon hoaDon);

    boolean delete(String id);
    
    List<HoaDon> getAllByTrangThai();
    
    List<HoaDon> searchByTen(String name);
    

    HoaDon findByHoaDonId(String uuid);

    
<<<<<<< HEAD
    String genMaHoaDon();

=======
    int genMaHoaDon();
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
}
