/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import domainmodel.DichVu;
import domainmodel.PhieuDatLich;
import enumclass.trangThaiHoaDon;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ADMIN
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLHoaDon {
    
    private UUID id;
    private PhieuDatLich phieuDatLich;
    private DichVu dichVu;
    private Date ngayThanhToan;
    private double donGia;
    private double tongTien;
    private String ghiChu;
    private trangThaiHoaDon trangThai = trangThaiHoaDon.CHUA_THANH_TOAN;

    public QLHoaDon(UUID id) {
        this.id = id;
    }
    
    
}
