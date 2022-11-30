/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.SanCa;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ISanCaRepository {
    
    SanCa getOne();
    
    List<SanCa> getAll();
    
    boolean saveOrUpdate(SanCa sanCa);

    boolean deleteSanCa(SanCa sanCa);

    
}
