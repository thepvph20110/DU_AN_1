/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.HoaDon;
import domainmodel.HoaDonThanhToan;
import domainmodel.ThanhToan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import modelview.QLHoaDon;
import modelview.QLHoaDonThanhToan;
import repository.IHoaDonRepository;
import repository.IHoaDonThanhToanRepository;
import repository.IThanhToanRepository;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.HoaDonThanhToanRepositoryImpl;
import repository.impl.ThanhToanRepository;
import service.IHoaDonThanhToanService;

/**
 *
 * @author ASUS
 */
public class HoaDonThanhToanServiceImpl implements IHoaDonThanhToanService {

    private IHoaDonThanhToanRepository hoaDonThanhToanRepositoryImpl = new HoaDonThanhToanRepositoryImpl();
    private Map<String, Object> map = new HashMap<>();
    private IHoaDonRepository hoaDonRepositoryImpl = new HoaDonRepositoryImpl();
    private IThanhToanRepository thanhToanRepositoryImpl = new ThanhToanRepository();

    @Override
    public List<QLHoaDonThanhToan> getHoaDonThanhToanNoPagination() {
        // map hoaDon;
        List<HoaDon> listHoaDon = hoaDonRepositoryImpl.getAll();
        listHoaDon.forEach(hoaDon
                -> {
            map.put(String.valueOf(hoaDon.getId()), hoaDon);
        });
        // map Thanh Toán
        List<ThanhToan> listThanhToan = thanhToanRepositoryImpl.getAllThanhToans();
        listThanhToan.forEach(thanhToan -> {
            map.put(thanhToan.getMaThanhToan(), thanhToan);
        });

        List<HoaDonThanhToan> listHoaDonThanhToan = hoaDonThanhToanRepositoryImpl.fillAllHoaDonThanhToan();
        List<QLHoaDonThanhToan> listQLHoaDonThanhToan = new ArrayList<>();
        for (HoaDonThanhToan hoaDonTT : listHoaDonThanhToan) {
            //id,maThanhToan, hoaDon, thanhToan, tongTien, ghiChu
            listQLHoaDonThanhToan.add(
                    new QLHoaDonThanhToan(
                            hoaDonTT.getId(),
                            hoaDonTT.getMaHDTT(),
                            String.valueOf(hoaDonTT.getHoaDon().getMaHoaDon()),
                            hoaDonTT.getThanhToan().getMaThanhToan(),
                            hoaDonTT.getTongTien(),
                            hoaDonTT.getGhiChu()));
        }
        return listQLHoaDonThanhToan;

    }

    @Override
    public String createNewHoaDonThanhToan(QLHoaDonThanhToan hoaDonThanhToan) {
        hoaDonThanhToan.setId(null);
        HoaDon hoaDon = new HoaDon();
        if (map.containsKey(hoaDonThanhToan.getHoaDon())) {
            hoaDon = (HoaDon) map.get(hoaDonThanhToan.getHoaDon());
        }
        ThanhToan thanhToan = new ThanhToan();
        if (map.containsKey(hoaDonThanhToan.getThanhToan())) {
            thanhToan = (ThanhToan) map.get(hoaDonThanhToan.getThanhToan());
        }
        boolean save = hoaDonThanhToanRepositoryImpl.saveOrUpdate(
                new HoaDonThanhToan(
                        hoaDonThanhToan.getId(),
                        hoaDonThanhToan.getMaHDTT(),
                        hoaDon,
                        thanhToan,
                        hoaDonThanhToan.getTongTien(),
                        hoaDonThanhToan.getGhiChu()
                )
        );
        if (save) {
            return "Tạo Mới Hóa Đơn Thanh Toán Thành Công";
        } else {
            return "Tạo Mới Hóa Đơn Thanh Toán Không Công";
        }

    }

    @Override
    public String updateHoaDonThanhToanById(QLHoaDonThanhToan hoaDonThanhToan) {
        HoaDon hoaDon = new HoaDon();
        if (map.containsKey(hoaDonThanhToan.getHoaDon())) {
            hoaDon = (HoaDon) map.get(hoaDonThanhToan.getHoaDon());
        }
        ThanhToan thanhToan = new ThanhToan();
        if (map.containsKey(hoaDonThanhToan.getThanhToan())) {
            thanhToan = (ThanhToan) map.get(hoaDonThanhToan.getThanhToan());
        }
        boolean update = hoaDonThanhToanRepositoryImpl.saveOrUpdate(
                new HoaDonThanhToan(
                        hoaDonThanhToan.getId(),
                        hoaDonThanhToan.getMaHDTT(),
                        hoaDon,
                        thanhToan,
                        hoaDonThanhToan.getTongTien(),
                        hoaDonThanhToan.getGhiChu()
                )
        );
        if (update) {
            return "Cập Nhập Hóa Đơn Thanh Toán Thành Công";
        } else {
            return "Cập Nhập Hóa Đơn Thanh Toán Không Công";
        }

    }

    @Override
    public String deleteHoaDonThanhToanById(String id) {
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

    public static void main(String[] args) {
        List<QLHoaDon> ql = new HoaDonServiceImpl().getAll();
        ql.forEach(c -> System.out.println("" + c.getId()));
        List<QLHoaDonThanhToan> qlHDTT = new HoaDonThanhToanServiceImpl().getHoaDonThanhToanNoPagination();
        qlHDTT.forEach(c -> System.out.println("" + c.getHoaDon()));
    }

    @Override
    public String genMaHoaDonThanhToan() {
        int maAC = hoaDonThanhToanRepositoryImpl.genMaHoaDonThanhToan();
        return "HDTT00"+maAC;
    }
}
