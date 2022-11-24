/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.Acount;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public interface IAcountRepository {
    
    List<Acount> getAll();
    
    Acount getOne();
    
    boolean save(Acount acount);
    
    boolean update(Acount acount);
    
    boolean delete(UUID id);
    
}
