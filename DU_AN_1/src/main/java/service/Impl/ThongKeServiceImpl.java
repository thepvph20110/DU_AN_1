/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import java.util.List;
import repository.IThongKeRepository;
import repository.impl.ThongKeRepositoryImpl;
import response.ThanhToan.TongSoLuongDoThue;
import response.ThanhToan.TongSoLuongNuocUong;
import response.ThanhToan.TongTienHoaDonResponse;
import service.IThongKeService;

/**
 *
 * @author Admin
 */
public class ThongKeServiceImpl implements IThongKeService {

    private IThongKeRepository thongKeService = new ThongKeRepositoryImpl();

    @Override
    public List<TongTienHoaDonResponse> getTongTien() {
        return thongKeService.getTongTien();
    }

    @Override
    public List<TongSoLuongNuocUong> getTongNuocUong() {
        return thongKeService.getTongNuocUong();
    }

    @Override
    public List<TongSoLuongDoThue> getTongDoThue() {
        return thongKeService.getTongDoThue();
    }

    @Override
    public List<TongTienHoaDonResponse> getTongTienByYear(String year) {
        return thongKeService.getTongTienByYear(year);
    }

}
