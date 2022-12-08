/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiSanBong;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QLSanBong {

    private String id;
    private String maSanBong;
    private String tenSanBong;
    private double giaSan;
    private int sucChua;
    private String tenLoaiSan;
    private trangThaiSanBong trangThai = trangThaiSanBong.HOAT_DONG;

    public Object[] toDataRow() {
        return new Object[]{ giaSan, maSanBong, sucChua, tenSanBong, trangThai, tenLoaiSan};
    }

}
