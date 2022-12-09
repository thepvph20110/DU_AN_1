
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

    String saveOrUpdate(GiaoCa giaoCa);

    List<TongTienMatGiaoCa> getTongTienMatHienTai(Date thoiGianNhanCa,Date thoiGianCuoiCa);

    List<TongTienMatGiaoCa> getTongTienKhacHienTai(Date thoiGianNhanCa,Date thoiGianCuoiCa);

}
