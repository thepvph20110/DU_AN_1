/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiNuocUong;
import java.text.NumberFormat;
import java.util.Locale;
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

    private String id;
    private String maNuocUong;
    private String tenNuocUong;
    private int soLuong;
    private long gia;
    private trangThaiNuocUong trangThai;

    
    public Object[] toRowData(){
        return new Object[]{maNuocUong, tenNuocUong, soLuong, gia, trangThai};
    }

    public String dinhDangTienTe(double tienTe) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(tienTe) + " " + "VNĐ";
    }

    public Object[] toRowDataNuocUong() {
        return new Object[]{maNuocUong, tenNuocUong, dinhDangTienTe(gia)};
    }
}
