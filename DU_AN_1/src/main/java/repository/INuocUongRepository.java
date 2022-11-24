/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.NuocUong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ASUS
 */
public interface INuocUongRepository {

    List<NuocUong> fillAll(int firstResult, int maxResults);
    
    List<NuocUong> fillAllNuocUong();
    
    UUID fillByName(String ten);

    boolean saveOrUpdate(NuocUong nuocUong);

    boolean delete(String id);
    
    long totalCount();
    
    NuocUong findByID(String id);
}
