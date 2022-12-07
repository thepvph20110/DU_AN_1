/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

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

    String saveOrUpdate(QLGiaoCa qLGiaoCa);

    List<TongTienMatGiaoCa> getTongTienMatHienTai(Date thoiGianNhanCa,Date thoiGianCuoiCa);

    List<TongTienMatGiaoCa> getTongTienKhacHienTai(Date thoiGianNhanCa,Date thoiGianCuoiCa);
}
