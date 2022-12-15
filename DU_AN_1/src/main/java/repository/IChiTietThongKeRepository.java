/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Date;
import java.util.List;
import response.ChiTietThanhToan.ChiTietDichVuRespone;
import response.ChiTietThanhToan.ChiTietDoThueResponse;
import response.ChiTietThanhToan.ChiTietTongTienTheoNgayResponse;

/**
 *
 * @author Admin
 */
public interface IChiTietThongKeRepository {

    //get Default date
    ChiTietTongTienTheoNgayResponse chiTietTongTien();

    ChiTietTongTienTheoNgayResponse getTongTienMat();

    ChiTietTongTienTheoNgayResponse getTongTienNganHang();
    
    List<ChiTietDichVuRespone> thongKeNuocUong();
    
    List<ChiTietDoThueResponse> thongKeDoThue();
    
    //get Default by date
    
    ChiTietTongTienTheoNgayResponse chiTietTongTienByDate(Date date);

    ChiTietTongTienTheoNgayResponse getTongTienMatByDate(Date date);

    ChiTietTongTienTheoNgayResponse getTongTienNganHangByDate(Date date);
    
    List<ChiTietDichVuRespone> thongKeNuocUongByDate(Date date);
    
    List<ChiTietDoThueResponse> thongKeDoThueByDate(Date date);
}
