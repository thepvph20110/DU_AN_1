/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.HoaDon;
import domainmodel.NuocUong;
import enumclass.trangThaiDichVu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import modelview.QLDichVu;
import repository.IDichVuRepository;
import repository.IDoThueRepository;
import repository.IHoaDonRepository;
import repository.INuocUongRepository;
import repository.impl.DichVuRepositoryImpl;
import repository.impl.DoThueRepositoryImpl;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.NuocUongRepositoryImpl;
import service.IDichVuService;

public class DichVuServiceImpl implements IDichVuService {

    private IDichVuRepository dichVuRepositoryImpl = new DichVuRepositoryImpl();
    private Map<String, Object> map = new HashMap<>();
    private INuocUongRepository nuocUongRepositoryImpl = new NuocUongRepositoryImpl();
    private IDoThueRepository doThueRepositoryImpl = new DoThueRepositoryImpl();
    private IHoaDonRepository hoaDonRepositoryImpl = new HoaDonRepositoryImpl();

    @Override
    public List<QLDichVu> getDichVu(int position, int pageSize) {
        List<DichVu> listDichVu = dichVuRepositoryImpl.fillAll(position, pageSize);

        List<QLDichVu> listQLDichVu = new ArrayList<>();
//id, maDichVu, tenDoThue, soLuongDoThue, hoaDon, tenNuocUong, soLuongNuocUong, donGia, moTa,trangThai
        for (DichVu dichVu : listDichVu) {
            listQLDichVu.add(new QLDichVu(
                    dichVu.getId(),
                    dichVu.getMaDichVu(),
                    dichVu.getDoThue().getTenDoThue(),
                    dichVu.getSoLuongDoThue(),
                    String.valueOf(dichVu.getHoaDon().getId()),
                    dichVu.getNuocUong().getTenNuocUong(),
                    dichVu.getSoLuongNuocUong(),
                    dichVu.getDonGia(),
                    dichVu.getMoTa(),
                    trangThaiDichVu.Dang_Su_Dung)
            );
        }
        return listQLDichVu;
    }

    @Override
    public List<QLDichVu> getDichVuNoPagination() {

//  map nước uống
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.fillAllNuocUong();
        listNuocUong.forEach(nuocUong -> {
            map.put(nuocUong.getTenNuocUong(), nuocUong);
        });
// map đồ thuê
        List<DoThue> listDoThue = doThueRepositoryImpl.getAll();
        listDoThue.forEach(doThue -> {
            map.put(doThue.getTenDoThue(), doThue);
        });
// map hóa đơn
        List<HoaDon> listHoaDon = hoaDonRepositoryImpl.getAll();
        listHoaDon.forEach(hoaDon -> {
            map.put(String.valueOf(hoaDon.getId()), hoaDon);
        });

// chạy for add
        List<DichVu> listDichVu = dichVuRepositoryImpl.fillAllDichVu();
        List<QLDichVu> listQLDichVu = new ArrayList<>();
        for (DichVu dichVu : listDichVu) {
            map.put(dichVu.getMaDichVu(), dichVu);

//id, maDichVu, tenDoThue, soLuongDoThue, hoaDon, tenNuocUong, soLuongNuocUong, donGia, moTa,trangThai
            listQLDichVu.add(
                    new QLDichVu(
                            dichVu.getId(),
                            dichVu.getMaDichVu(),
                            dichVu.getDoThue().getTenDoThue(),
                            dichVu.getSoLuongDoThue(),
                            String.valueOf(dichVu.getHoaDon().getId()),
                            dichVu.getNuocUong().getTenNuocUong(),
                            dichVu.getSoLuongNuocUong(),
                            dichVu.getDonGia(),
                            dichVu.getMoTa(),
                            trangThaiDichVu.Dang_Su_Dung)
            );
        }
        return listQLDichVu;
    }

    @Override
    public String createNewDichVu(QLDichVu dichVu) {
        dichVu.setId(null);
        NuocUong nuocUong = new NuocUong();
        if (map.containsKey(dichVu.getTenNuocUong())) {
            nuocUong = (NuocUong) map.get(dichVu.getTenNuocUong());
        }

        DoThue doThue = new DoThue();
        if (map.containsKey(dichVu.getTenDoThue())) {
            doThue = (DoThue) map.get(dichVu.getTenDoThue());
        }
        if (map.containsKey(dichVu.getMaDichVu())) {
            return "Mã trùng";
        }
        HoaDon hoaDon = new HoaDon();
        if (map.containsKey(hoaDon.getId())) {
            hoaDon = (HoaDon) map.get(dichVu.getHoaDon());
        }

//id, maDichVu, tenDoThue, soLuongDoThue, hoaDon, tenNuocUong, soLuongNuocUong, donGia, moTa,trangThai
        boolean save = dichVuRepositoryImpl.saveOrUpdate(
                new DichVu(
                        dichVu.getId(),
                        dichVu.getMaDichVu(),
                        doThue,
                        dichVu.getSoLuongDoThue(),
                        hoaDon,
                        nuocUong,
                        dichVu.getSoLuongNuocUong(),
                        dichVu.getDonGia(),
                        dichVu.getMoTa(),
                        dichVu.getTrangThai())
        );
        if (save) {
            return "Tạo mới Dịch Vụ Thành Công";
        } else {
            return "Tạo mới Dịch Vụ Không Công";
        }
    }

    @Override
    public String updateDichVuById(QLDichVu dichVu) {
        NuocUong nuocUong = new NuocUong();
        if (map.containsKey(dichVu.getTenNuocUong())) {
            nuocUong = (NuocUong) map.get(dichVu.getTenNuocUong());
        }

        DoThue doThue = new DoThue();
        if (map.containsKey(dichVu.getTenDoThue())) {
            doThue = (DoThue) map.get(dichVu.getTenDoThue());
        }

        HoaDon hoaDon = new HoaDon();
        if (map.containsKey(hoaDon.getId())) {
            hoaDon = (HoaDon) map.get(dichVu.getHoaDon());
        }
        boolean save = dichVuRepositoryImpl.saveOrUpdate(
                new DichVu(dichVu.getId(),
                        dichVu.getMaDichVu(),
                        doThue,
                        dichVu.getSoLuongDoThue(),
                        hoaDon,
                        nuocUong,
                        dichVu.getSoLuongNuocUong(),
                        dichVu.getDonGia(),
                        dichVu.getMoTa(),
                        dichVu.getTrangThai()
                )
        );
        if (save) {
            return "Cập nhập Dịch Vụ Thành Công";
        } else {
            return "Cập Nhập Dịch Vụ Không Công";
        }

    }

    @Override
    public String deleteDichVuById(UUID id) {
        boolean delete = dichVuRepositoryImpl.delete(id);
        if (delete) {
            return "Xóa Dịch Vụ Thành Công";
        } else {
            return "Xóa Dịch Vụ Không Công";
        }
    }

    @Override
    public long countAllDichVu() {
        long count = dichVuRepositoryImpl.totalCount();
        return count;
    }
}
