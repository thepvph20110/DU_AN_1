/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import modelview.QLHoaDonThanhToan;

/**
 *
 * @author ASUS
 */
public interface IHoaDonThanhToanService {

    List<QLHoaDonThanhToan> getHoaDonThanhToan(int position, int pageSize);

    List<QLHoaDonThanhToan> getHoaDonThanhToanNoPagination();

    String createNewHoaDonThanhToan(QLHoaDonThanhToan hoaDonThanhToan);

    String updateHoaDonThanhToanById(QLHoaDonThanhToan hoaDonThanhToan);

    String deleteHoaDonThanhToanById(String id);

    long countAllHoaDonThanhToan();
}
