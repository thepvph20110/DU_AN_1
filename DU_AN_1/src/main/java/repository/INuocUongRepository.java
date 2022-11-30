/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.NuocUong;
import enumclass.trangThaiNuocUong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ASUS
 */
public interface INuocUongRepository {

    
    List<NuocUong> fillAllNuocUong();
    
    String fillByName(String ten);

    boolean saveOrUpdate(NuocUong nuocUong);

    boolean delete(UUID id);
    
    long totalCount();

    NuocUong findByID(String id);
    
    List<NuocUong> findByTenNuocUong(String ten);
    
    List<NuocUong> findByTrangThai(trangThaiNuocUong trangThai);

}
