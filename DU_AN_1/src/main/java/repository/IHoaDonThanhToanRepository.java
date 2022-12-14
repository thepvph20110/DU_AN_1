/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDonThanhToan;
import java.util.List;
import java.util.UUID;

public interface IHoaDonThanhToanRepository {

    List<HoaDonThanhToan> fillAllHoaDonThanhToan();
    
    boolean saveOrUpdate(HoaDonThanhToan hoaDonThanhToan);

    boolean delete(String id);

    long totalCount();
    
    int genMaHoaDonThanhToan();
}
