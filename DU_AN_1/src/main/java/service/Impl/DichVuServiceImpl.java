/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.NuocUong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import modelview.QLDichVu;
import repository.INuocUongRepository;
import repository.impl.DichVuRepositoryImpl;
import repository.impl.NuocUongRepositoryImpl;
import service.IDichVuService;

public class DichVuServiceImpl implements IDichVuService {

    private DichVuRepositoryImpl dichVuRepositoryImpl = new DichVuRepositoryImpl();
    private Map<String, Object> map = new HashMap<>();
    private INuocUongRepository nuocUongRepositoryImpl = new NuocUongRepositoryImpl();

    @Override
    public List<QLDichVu> getDichVu(int position, int pageSize) {
        List<DichVu> listDichVu = dichVuRepositoryImpl.fillAll(position, pageSize);

        List<QLDichVu> listQLDichVu = new ArrayList<>();

        for (DichVu x : listDichVu) {
            listQLDichVu.add(new QLDichVu(x.getId(), x.getMaDichVu(),
                    x.getDoThue().getTenDoThue(), x.getSoLuongDoThue(),
                    x.getNuocUong().getTenNuocUong(), x.getSoLuongNuocUong(),
                    x.getDonGia(), x.getMoTa(), x.getTrangThai()));
        }
        return listQLDichVu;
    }

    @Override
    public List<QLDichVu> getDichVuNoPagination() {
//  map dịch vụ
        List<DichVu> listDichVu = dichVuRepositoryImpl.fillAllDichVu();
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.fillAllNuocUong();
        listNuocUong.forEach(nuocUong -> {
            map.put(nuocUong.getTenNuocUong(), nuocUong);
        });
// map đồ thuê

        List<QLDichVu> listQLDichVu = new ArrayList<>();
        for (DichVu x : listDichVu) {
            map.put(x.getMaDichVu(), x);
            //id, maDichVu, doThue, soLuongDoThue, nuocUong, soLuongNuocUong, donGia, moTa, trangThai
            listQLDichVu.add(new QLDichVu(x.getId(), x.getMaDichVu(), x.getDoThue().getTenDoThue(), x.getSoLuongDoThue(), x.getNuocUong().getTenNuocUong(), x.getSoLuongNuocUong(), x.getDonGia(), x.getMoTa(), x.getTrangThai()));
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
        boolean save = dichVuRepositoryImpl.saveOrUpdate(new DichVu(dichVu.getId(), dichVu.getMaDichVu(), doThue, dichVu.getSoLuongDoThue(), nuocUong, dichVu.getSoLuongNuocUong(), dichVu.getDonGia(), dichVu.getMoTa(), dichVu.getTrangThai()));
        if (save) {
            return "Tạo mới Dịch Vụ Thành Công";
        } else {
            return "Tạo mới Dịch Vụ Không Công";
        }
    }

    @Override
    public String updateDichVuById(QLDichVu dichVu) {
        dichVu.setId(null);
        NuocUong nuocUong = new NuocUong();
        if (map.containsKey(dichVu.getTenNuocUong())) {
            nuocUong = (NuocUong) map.get(dichVu.getTenNuocUong());
        }

        DoThue doThue = new DoThue();
        if (map.containsKey(dichVu.getTenDoThue())) {
            doThue = (DoThue) map.get(dichVu.getTenDoThue());
        }
        boolean save = dichVuRepositoryImpl.saveOrUpdate(new DichVu(dichVu.getId(), dichVu.getMaDichVu(), doThue, dichVu.getSoLuongDoThue(), nuocUong, dichVu.getSoLuongNuocUong(), dichVu.getDonGia(), dichVu.getMoTa(), dichVu.getTrangThai()));

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
