/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.NhaSanXuat;
import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiThanhToan;
import java.util.ArrayList;
import java.util.List;
import modelview.QLThanhToan;
import repository.IThanhToanRepository;
import repository.impl.ThanhToanRepository;
import service.IThanhToanService;

/**
 *
 * @author ASUS
 */
public class ThanhToanServiceImpl implements IThanhToanService {

    private final IThanhToanRepository repository;
    private List<QLThanhToan> lstQLThanhToan;

    public ThanhToanServiceImpl() {
        repository = new ThanhToanRepository();
        lstQLThanhToan = new ArrayList<>();
    }

    @Override
    public List<QLThanhToan> getAllThanhToans() {
        lstQLThanhToan.clear();
        var x = repository.getAllThanhToans();
        for (ThanhToan t : x) {
            lstQLThanhToan.add(new QLThanhToan(t.getId(), t.getMaThanhToan(), t.getHinhThanhToan(), t.getMoTa()));
        }
        return lstQLThanhToan;
    }

    @Override
    public boolean save(QLThanhToan qLThanhToan) {
        boolean x = repository.save(new ThanhToan(null, qLThanhToan.getMaThanhToan(), qLThanhToan.getHinhThanhToan(), qLThanhToan.getMoTa()));
        return x;
    }

    @Override
    public boolean update(QLThanhToan qLThanhToan) {
        boolean x = repository.save(new ThanhToan(qLThanhToan.getId(), qLThanhToan.getMaThanhToan(), qLThanhToan.getHinhThanhToan(), qLThanhToan.getMoTa()));
        return x;
    }

    @Override
    public boolean delete(QLThanhToan qLThanhToan) {
        boolean x = repository.delete(new ThanhToan(qLThanhToan.getId(), qLThanhToan.getMaThanhToan(), qLThanhToan.getHinhThanhToan(), qLThanhToan.getMoTa()));
        return x;
    }

    public static void main(String[] args) {
        ThanhToanServiceImpl tt = new ThanhToanServiceImpl();
        List<QLThanhToan> lst = tt.getAllThanhToans();
        System.out.println(lst);
    }

}
