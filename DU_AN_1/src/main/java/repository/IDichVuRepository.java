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
    
    List<DichVu> findByIdHoaDon(UUID uuid);
    
    List<DichVu> findByIdHoaDonAndNuocUong(UUID idHoaDon,UUID idNuocUong);
    
    List<DichVu> findByIdHoaDonAndDoThue(UUID idHoaDon,UUID idDoThue);

    boolean saveOrUpdate(DichVu dichVu);

    boolean delete(UUID id);

    long totalCount();
}
