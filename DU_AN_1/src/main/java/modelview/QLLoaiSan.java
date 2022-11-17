/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

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
public class QLLoaiSan {

    private UUID id;
    private String maLoaiSan;
    private String tenLoaiSan;
    private String moTa;
    
    public Object[] toDataRow(){
        return new Object[]{id, maLoaiSan, tenLoaiSan, moTa};
    }
}
