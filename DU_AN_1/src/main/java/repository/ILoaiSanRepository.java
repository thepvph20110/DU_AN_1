/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.LoaiSan;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ILoaiSanRepository {
    
    List<LoaiSan> getAll();
    
    boolean saveOrUpdate(LoaiSan loaiSan);
    
    boolean deleteLoaiSan(LoaiSan loaiSan);
    
    List<LoaiSan> searchByName(String ten);
<<<<<<< HEAD
=======

    LoaiSan getOne(String tenLoai);
    
    int genMaLoaiSan();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
