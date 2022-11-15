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

    private UUID id;
    private String maSanBong;
    private String tenSanBong;
    private long giaSan;
    private int sucChua;
    private QLLoaiSan QLloaiSan;
    private trangThaiSanBong trangThai = trangThaiSanBong.HOAT_DONG;
    
    public Object[] toDataRow(){
        return new Object[]{id, maSanBong, tenSanBong, giaSan, sucChua, QLloaiSan.getTenLoaiSan(), trangThai};
    }

}
