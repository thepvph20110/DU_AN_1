/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiNuocUong;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QLNuocUong {

    private UUID id;
    private String maNuocUong;
    private String tenNuocUong;
    private int soLuong;
    private long gia;
    private trangThaiNuocUong trangThai;
    
    public Object[] toRowData(){
        return new Object[]{id, maNuocUong, tenNuocUong, soLuong, gia, trangThai};
    }
    
    public Object[] toRowDataNuocUong(){
        return new Object[]{ maNuocUong, tenNuocUong, gia};
    }
}
