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
        var lstThanhToan = repository.getAllThanhToans();
        for (ThanhToan thanhToan : lstThanhToan) {
            lstQLThanhToan.add(new QLThanhToan(thanhToan.getId(), thanhToan.getMaThanhToan(), thanhToan.getHinhThanhToan(), thanhToan.getMoTa()));
        }
        return lstQLThanhToan;
    }

    @Override
    public boolean save(QLThanhToan qLThanhToan) {
        boolean save = repository.save(new ThanhToan(null, qLThanhToan.getMaThanhToan(), qLThanhToan.getHinhThanhToan(), qLThanhToan.getMoTa()));
        return save;
    }

    @Override
    public boolean update(QLThanhToan qLThanhToan) {
        boolean update = repository.save(new ThanhToan(qLThanhToan.getId(), qLThanhToan.getMaThanhToan(), qLThanhToan.getHinhThanhToan(), qLThanhToan.getMoTa()));
        return update;
    }

    @Override
    public boolean delete(String id) {
        boolean delete = repository.delete(id);
        return delete;
    }

    @Override
    public String genMaThanhToan(List<QLThanhToan> lstQLThanhToans) {
        int start;
        List<Integer> lstIntegers = new ArrayList<>();
        for (int i = 0; i < lstQLThanhToans.size(); i++) {
            start = Integer.parseInt(lstQLThanhToans.get(i).getMaThanhToan().substring(4));
            lstIntegers.add(start);
        }
        int max = lstIntegers.get(0);
        for (int i = 0; i < lstIntegers.size(); i++) {
            if (lstIntegers.get(i).compareTo(max) > 0) {
                max = lstIntegers.get(i);
            }
        }
        return "TT00" + (++max);
    }

    @Override
    public QLThanhToan fillByMaThanhToan(String maThanhToan) {
        var thanhToan = repository.fillBymaThanhToan(maThanhToan);
        QLThanhToan qLThanhToan = new QLThanhToan(thanhToan.getId(), thanhToan.getMaThanhToan(), thanhToan.getHinhThanhToan(), thanhToan.getMoTa());
        return qLThanhToan;
    }

}
