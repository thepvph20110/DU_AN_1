/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiDichVu;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QLDichVu {


    private String id;
    private String maDichVu;


    private String tenDoThue;
    private int soLuongDoThue;

    private String hoaDon;


    private String tenNuocUong;
    private int soLuongNuocUong;
    private double donGia;

    private String moTa;
    private trangThaiDichVu trangThai = trangThaiDichVu.Dang_Su_Dung;

    
    public Object[] toRowData(){
        return new Object[]{maDichVu, tenDoThue, soLuongDoThue, hoaDon, tenNuocUong, soLuongNuocUong, donGia, moTa,trangThai};
    }
    
}
