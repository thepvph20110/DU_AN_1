/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiKhachHang;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hp
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QLKhachHang {

    private String id;
    private String maKhachHang;
    private String tenKhachHang;
    private String mail;
    private String soDienThoai;
    private String ghiChu;
    private trangThaiKhachHang trangThai = trangThaiKhachHang.BINH_THUONG;
    
    public Object toDataRow(){
        return new Object[] { maKhachHang, tenKhachHang,mail, soDienThoai, ghiChu, trangThai};
    }

    Object getTenKhachHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
