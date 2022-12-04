/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import java.util.Date;
import java.util.List;
import repository.IChiTietThongKeRepository;
import repository.impl.ChiTietThongKeRepositoryImpl;
import response.ChiTietThanhToan.ChiTietDichVuRespone;
import response.ChiTietThanhToan.ChiTietDoThueResponse;
import response.ChiTietThanhToan.ChiTietTongTienTheoNgayResponse;
import service.IChiTietThongKeService;

/**
 *
 * @author Admin
 */
public class ChiTietThongKeServiceImpl implements IChiTietThongKeService {

    private IChiTietThongKeRepository chiTietRepo = new ChiTietThongKeRepositoryImpl();

    @Override
    public ChiTietTongTienTheoNgayResponse chiTietTongTien() {
        return chiTietRepo.chiTietTongTien();
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienMat() {
        return chiTietRepo.getTongTienMat();
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienNganHang() {
        return chiTietRepo.getTongTienNganHang();
    }

    @Override
    public List<ChiTietDichVuRespone> thongKeNuocUong() {
        return chiTietRepo.thongKeNuocUong();
    }

    @Override
    public List<ChiTietDoThueResponse> thongKeDoThue() {
        return chiTietRepo.thongKeDoThue();
    }

    //get by date
    
    @Override
    public ChiTietTongTienTheoNgayResponse chiTietTongTienByDate(Date date) {
        return chiTietRepo.chiTietTongTienByDate(date);
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienMatByDate(Date date) {
        return chiTietRepo.getTongTienMatByDate(date);
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienNganHangByDate(Date date) {
        return  chiTietRepo.getTongTienNganHangByDate(date);
    }

    @Override
    public List<ChiTietDichVuRespone> thongKeNuocUongByDate(Date date) {
        return chiTietRepo.thongKeNuocUongByDate(date);
    }

    @Override
    public List<ChiTietDoThueResponse> thongKeDoThueByDate(Date date) {
        return  chiTietRepo.thongKeDoThueByDate(date);
    }
}
