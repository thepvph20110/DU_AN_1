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

/**
 *
 * @author hp
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLKhachHang {

    private UUID id;
    private String maKhachHang;
    private String tenKhachHang;
    private String mail;
    private String soDienThoai;
    private String ghiChu;
    private trangThaiKhachHang trangThai = trangThaiKhachHang.BINH_THUONG;
    
    public Object toDataRow(){
        return new Object[] {id, maKhachHang, tenKhachHang,mail, soDienThoai, ghiChu, trangThai};
    }
}
