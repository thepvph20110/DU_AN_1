
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainModel.GiaoCa;
import java.util.Date;
import java.util.List;
import modelview.QLGiaoCa;
import response.ThanhToan.TongTienMatGiaoCa;

/**
 *
 * @author DANG VAN SY
 */
public interface IGiaoCaRepository {

    GiaoCa getOne(String ma);

    String NhanCa(GiaoCa giaoCa);

    String GiaoCa(GiaoCa giaoCa);

    GiaoCa getOneGiaoCaById(String id);

    double tongTienCaHienTaiByIdNV(String id);

    double tongTienNganHang(String id);

    double tongTienMat(String id);

    int tongHoaDOnDaTT(String id);

    int tongHoaDOnChuaTT(String id);

    List<GiaoCa> checkCaTrong(String idNhanVienTrongCa);

    GiaoCa checkCoNhanVIenKo();

    GiaoCa getOneGiaoCaByIdAndTrangThai(String id);

    GiaoCa TimKiemNVCaTiepTheo();

    List<GiaoCa> getAll();

    List<GiaoCa> getAllTrangThaiDaNhanCa();

    List<GiaoCa> giaoCaCoPhuPhiPhatSinh();

    List<GiaoCa> giaoCaCoTienDuocRut();

    List<GiaoCa> searchByName(String name);

    GiaoCa getAcoutAndPhieuDatLich();
}
