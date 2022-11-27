/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.ChucVu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChucVuRepository {
    
    List<ChucVu> getAll();
    
    boolean save(ChucVu chucVu);
    
    boolean update(ChucVu chucVu);
    
    boolean delete(String id);
    
    String genMaChucVu();
}
