/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;


import domainmodel.SanBong;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ISanBongRepository {
    List<SanBong> getAll();
    
    boolean saveOrUpdate(SanBong sanBong);
    
    boolean deleteSanBong(SanBong sanBong);
    
    List<SanBong> searchByName(String ten);
<<<<<<< HEAD
    
=======

    String saveSanBong(SanBong sanBong);

    SanBong getOne(String id);

    String xoaSaṇ̣̣̣̣(String id);
    
    int genMaSanBong();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
