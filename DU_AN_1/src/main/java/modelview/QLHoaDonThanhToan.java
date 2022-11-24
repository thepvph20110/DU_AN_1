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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLHoaDonThanhToan {
    private String id;
    private String maThanhToan;
    private String hoaDon;
    private String thanhToan;
    private double tongTien;
    private String ghiChu;
    
    public Object[] toRowData() {
        return new Object[]{id ,maThanhToan, hoaDon, thanhToan, tongTien, ghiChu};
    }
    
}
