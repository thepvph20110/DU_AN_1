/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import domainmodel.KichThuoc;
import enumclass.trangThaiDoThue;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLDoThue {

    private String id;
    private String maDoThue;
    private String tenDoThue;
    private String maKichThuoc;
    private String tenKichThuoc;
    private String maMauSac;
    private String tenMauSac;
    private String maNhaSanXuat;
    private String tenNhaSanXuat;
    private int soLuong;
    private double donGia;
    private trangThaiDoThue trangThai = trangThaiDoThue.Con_Hang;

    @Override
    public String toString() {
        return "QLDoThue{" + "id=" + id + ", maDoThue=" + maDoThue + ", tenDoThue=" + tenDoThue + ", maKichThuoc=" + maKichThuoc + ", tenKichThuoc=" + tenKichThuoc + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + ", maNhaSanXuat=" + maNhaSanXuat + ", tenNhaSanXuat=" + tenNhaSanXuat + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }

    public Object[] toData() {
        return new Object[]{maDoThue, tenDoThue, maMauSac, maKichThuoc, maNhaSanXuat, soLuong, dinhDang(donGia), trangThai};
    }
    public String dinhDang(double tienTe) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(tienTe);
    }
    public String dinhDangTienTe(double tienTe) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(tienTe) + " " + "VNĐ";
    }

    public Object[] toRowDataDoThue() {
        return new Object[]{maDoThue, tenDoThue, dinhDangTienTe(donGia)};
    }

}
