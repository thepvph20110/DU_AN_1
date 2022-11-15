/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiAcount;
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
public class QLAcount {

    private UUID id;
    private String maAcount;
    private String tenAcount;
    private String tenChucVu;
    private String matKhau;
    private String moTa;
    private trangThaiAcount trangThai = trangThaiAcount.Da_Xac_Minh;
    
}
