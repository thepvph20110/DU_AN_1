/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanBong;
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

    String saveSanBong(SanBong sanBong);

    String deleteSanBongNew(SanBong sanBong);
    
    String xoaSan(String id);
    
    String genMaSanBong();
}
