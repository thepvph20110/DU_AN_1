/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.HoaDonThanhToan;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import modelview.QLHoaDonThanhToan;
import repository.impl.HoaDonThanhToanRepositoryImpl;
import service.IHoaDonThanhToanService;

/**
 *
 * @author ASUS
 */
public class HoaDonThanhToanServiceImpl implements IHoaDonThanhToanService {

    private HoaDonThanhToanRepositoryImpl hoaDonThanhToanRepositoryImpl = new HoaDonThanhToanRepositoryImpl();

    @Override
    public List<QLHoaDonThanhToan> getHoaDonThanhToan(int position, int pageSize) {
        List<HoaDonThanhToan> listHoaDonThanhToan = hoaDonThanhToanRepositoryImpl.fillAll(position, pageSize);

        List<QLHoaDonThanhToan> listQLHoaDonThanhToan = new ArrayList<>();
        for (HoaDonThanhToan x : listHoaDonThanhToan) {
            //id,maThanhToan, hoaDon, thanhToan, tongTien, ghiChu
            listQLHoaDonThanhToan.add(new QLHoaDonThanhToan(x.getId(), x.getMaThanhToan(), x.getHoaDon().getId(),
                    x.getThanhToan(), x.getTongTien(), x.getGhiChu()));
        }
        return listQLHoaDonThanhToan;
    }

    @Override
    public List<QLHoaDonThanhToan> getHoaDonThanhToanNoPagination() {
        List<HoaDonThanhToan> listHoaDonThanhToan = hoaDonThanhToanRepositoryImpl.fillAllHoaDonThanhToan();

        List<QLHoaDonThanhToan> listQLHoaDonThanhToan = new ArrayList<>();

        for (HoaDonThanhToan x : listHoaDonThanhToan) {
            listQLHoaDonThanhToan.add(new QLHoaDonThanhToan(x.getId(), x.getMaThanhToan(), x.getHoaDon(),
                    x.getThanhToan(), x.getTongTien(), x.getGhiChu()));
        }
        return listQLHoaDonThanhToan;
    }

    @Override
    public String createNewHoaDonThanhToan(QLHoaDonThanhToan hoaDonThanhToan) {
        hoaDonThanhToan.setId(null);
        boolean save = hoaDonThanhToanRepositoryImpl.saveOrUpdate(new HoaDonThanhToan(hoaDonThanhToan.getId(),
                hoaDonThanhToan.getMaThanhToan(), hoaDonThanhToan.getHoaDon(),
                hoaDonThanhToan.getThanhToan(), hoaDonThanhToan.getTongTien(), hoaDonThanhToan.getGhiChu()));
        if (save) {
            return "Tạo mới Hóa Đơn Thanh Toán Thành Công";
        } else {
            return "Tạo mới Hóa Đơn Thanh Toán Không Công";
        }

    }

    @Override
    public String updateHoaDonThanhToanById(QLHoaDonThanhToan hoaDonThanhToan) {
        boolean save = hoaDonThanhToanRepositoryImpl.saveOrUpdate(new HoaDonThanhToan(hoaDonThanhToan.getId(),
                hoaDonThanhToan.getMaThanhToan(), hoaDonThanhToan.getHoaDon(),
                hoaDonThanhToan.getThanhToan(), hoaDonThanhToan.getTongTien(), hoaDonThanhToan.getGhiChu()));
        if (save) {
            return "Cập Nhập Hóa Đơn Thanh Toán Thành Công";
        } else {
            return "Cập Nhập Hóa Đơn Thanh Toán Không Công";
        }
    }

    @Override
    public String deleteHoaDonThanhToanById(UUID id) {
        boolean delete = hoaDonThanhToanRepositoryImpl.delete(id);
        if (delete) {
            return "Xóa Hóa Đơn Thanh Toán Thành Công";
        } else {
            return "Xóa Hóa Đơn Thanh Toán Không Công";
        }
    }

    @Override
    public long countAllHoaDonThanhToan() {
        long count = hoaDonThanhToanRepositoryImpl.totalCount();
        return count;
    }

}
