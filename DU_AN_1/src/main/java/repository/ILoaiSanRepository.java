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
}
