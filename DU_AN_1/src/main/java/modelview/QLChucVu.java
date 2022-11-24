/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import enumclass.trangThaiChucVu;
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
public class QLChucVu {

    private String id;
    private String maChucVu;
    private String tenChucVu;
    private trangThaiChucVu trangThai;
    
    public Object[] toDataRow(){
        return new Object[]{maChucVu,tenChucVu,trangThai};
    }
    
}
