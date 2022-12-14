/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.GiaoCa;
import java.util.Date;
import java.util.List;
import modelview.QLGiaoCa;
import response.ThanhToan.TongTienMatGiaoCa;

/**
 *
 * @author DANG VAN SY
 */
public interface IGiaoCaService {

    QLGiaoCa getOne(String ma);

    String NhanCa(GiaoCa giaoCa);

    String GiaoCa(GiaoCa giaoCa);

    GiaoCa getOneByIdNV(String id);

    double tongTienCaHienTaiByIdNV(String id);

    int tongHoaDOnDaTT(String id);

    int tongHoaDOnChuaTT(String id);

    double tongTienNganHang(String id);

    double tongTienMat(String id);

    boolean checkCaTrong(String idNhanVienTrongCa);

    GiaoCa checkCoNhanVIenKo();

    GiaoCa getOneGiaoCaByIdAndTrangThai(String id);

    GiaoCa getNvCaTT();

    List<GiaoCa> getAll();

    List<GiaoCa> searchByName(String name);

    List<GiaoCa> giaoCaCoPhuPhiPhatSinh();

    List<GiaoCa> getAllTrangThaiDaNhanCa();

    List<GiaoCa> giaoCaCoTienDuocRut();
}
