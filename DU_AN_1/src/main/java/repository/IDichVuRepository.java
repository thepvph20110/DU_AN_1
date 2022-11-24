/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DichVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ASUS
 */
public interface IDichVuRepository {

    List<DichVu> fillAll(int position, int pageSize);
    
    List<DichVu> fillAllDichVu();
    
    List<DichVu> findByIdHoaDon(String uuid);
    
    List<DichVu> findByIdHoaDonAndNuocUong(String idHoaDon,String idNuocUong);
    
    List<DichVu> findByIdHoaDonAndDoThue(String idHoaDon,String idDoThue);

    boolean saveOrUpdate(DichVu dichVu);

    boolean delete(UUID id);

    long totalCount();
}
