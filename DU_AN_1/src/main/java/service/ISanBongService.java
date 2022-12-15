/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLSanBong;

/**
 *
 * @author hp
 */
public interface ISanBongService {

    List<QLSanBong> getAll();

    String save(QLSanBong qLSanBong);

    String update(QLSanBong qLSanBong);

    String delete(QLSanBong qLSanBong);
    
    List<QLSanBong> searchByName(String ten);

<<<<<<< HEAD
=======
    String saveSanBong(SanBong sanBong);

    String deleteSanBongNew(SanBong sanBong);
    
    String xoaSan(String id);
    
    String genMaSanBong();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
