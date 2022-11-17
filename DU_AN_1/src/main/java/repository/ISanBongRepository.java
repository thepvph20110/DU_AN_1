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
    
}
