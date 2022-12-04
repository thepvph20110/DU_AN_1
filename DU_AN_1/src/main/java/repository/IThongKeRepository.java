/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import response.ThanhToan.TongSoLuongDoThue;
import response.ThanhToan.TongSoLuongNuocUong;
import response.ThanhToan.TongTienHoaDonResponse;

/**
 *
 * @author Admin
 */
public interface IThongKeRepository {
    
    List<TongTienHoaDonResponse> getTongTien();
    
    List<TongTienHoaDonResponse> getTongTienByYear(String year);
    
    List<TongSoLuongNuocUong> getTongNuocUong();
    
    List<TongSoLuongDoThue> getTongDoThue();
     
}
