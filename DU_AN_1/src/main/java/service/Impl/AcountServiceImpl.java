/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.Acount;
import domainmodel.ChucVu;
import enumclass.trangThaiAcount;
import enumclass.trangThaiChucVu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelview.QLAcount;
import repository.IAcountRepository;
import repository.impl.AcountRepository;
import service.IAcountService;
import views.Detaillogin;
import views.Home;

/**
 *
 * @author Admin
 */
public class AcountServiceImpl implements IAcountService {

    private IAcountRepository acountRepo = new AcountRepository();

    @Override
    public List<QLAcount> getAll() {
        List<QLAcount> qLAcounts = new ArrayList<>();
        for (Acount acount : acountRepo.getAll()) {
            QLAcount qLAcount = new QLAcount(acount.getId(), acount.getMaAcount(), acount.getTenAcount(),
                    acount.getChucVu(), acount.getMatKhau(), acount.getMoTa(), trangThaiAcount.Da_Xac_Minh);
            qLAcounts.add(qLAcount);
        }
        return qLAcounts;
    }

    @Override
    public String save(QLAcount qLAcount) {
        Acount acount = new Acount(null, genMaAccount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), trangThaiAcount.Da_Xac_Minh);
        if (acountRepo.save(acount) == true) {
            return "Lưu Thành Công";
        }
        return "Lưu Thất Bại";
    }

    @Override
    public String update(QLAcount qLAcount, String id) {
        Acount acount = new Acount(id, qLAcount.getMaAcount(), qLAcount.getTenAcount(), qLAcount.getChucVu(),
                qLAcount.getMatKhau(), qLAcount.getMoTa(), trangThaiAcount.Da_Xac_Minh);
        if (acountRepo.update(acount) == true) {
            return "Sua Thành Công";
        }
        return "Sua Thất Bại";
    }

    @Override
    public String delete(String id) {
        if (acountRepo.delete(id) == true) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }

    @Override
    public Acount getOne() {
        Acount acount = acountRepo.getOne();
        QLAcount qlAcount = new QLAcount(acount.getId(), acount.getMaAcount(), acount.getTenAcount(), acount.getChucVu(), acount.getMatKhau(), acount.getMoTa(), acount.getTrangThai());
        return acount;
    }

    @Override
    public String genMaAccount() {
        int maAC = acountRepo.genMaAccount();
        return "AC00"+maAC;
    }

    @Override
    public QLAcount getByUseNameAndPass(String UseName, String pass) {
        Acount acount = acountRepo.getByUseNameAndPass(UseName, pass);
        if (UseName.isBlank() || pass.isBlank()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Use và PassWord");
            return null;
        } else if (acount == null) {
            JOptionPane.showMessageDialog(null, "Sai UseName hoặc PassWord");
            return null;
        } else {
            ChucVu chucVu = acount.getChucVu();
            return new QLAcount(acount.getId(), acount.getMaAcount(), acount.getTenAcount(), chucVu, acount.getMatKhau(), acount.getMoTa(), acount.getTrangThai());
        }
    }

}
