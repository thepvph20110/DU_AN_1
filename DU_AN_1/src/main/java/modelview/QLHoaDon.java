/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import domainmodel.DichVu;
import domainmodel.PhieuDatLich;
import enumclass.trangThaiHoaDon;
import java.util.Date;
import java.util.Set;
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
    
    private String id;
    private String maHoaDon;
    private PhieuDatLich phieuDatLich;
    private Set<DichVu> dichVu;
    private Date ngayThanhToan;
    private double donGia;
    private double tongTien;
    private String ghiChu;
    private trangThaiHoaDon trangThai = trangThaiHoaDon.CHUA_THANH_TOAN;
    
    public Object[] toDataRow(){
        return new Object[]{maHoaDon,phieuDatLich.getAcount().getTenAcount(),phieuDatLich.getKhachHang().getTenKhachHang(),phieuDatLich.getKhachHang().getSoDienThoai(),phieuDatLich.getTongTienSan(),phieuDatLich.getNgayTaoPhieu(),trangThai};
    }
    
}
