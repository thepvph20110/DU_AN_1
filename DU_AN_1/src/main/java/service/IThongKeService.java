/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import response.ThanhToan.TongSoLuongDoThue;
import response.ThanhToan.TongSoLuongNuocUong;
import response.ThanhToan.TongTienHoaDonResponse;

/**
 *
 * @author Admin
 */
public interface IThongKeService {

    List<TongTienHoaDonResponse> getTongTien();

    List<TongSoLuongNuocUong> getTongNuocUong();

    List<TongSoLuongDoThue> getTongDoThue();

    List<TongTienHoaDonResponse> getTongTienByYear(String year);

    double getTongTienNgayHienTai(Date ngayHienTai);
}
