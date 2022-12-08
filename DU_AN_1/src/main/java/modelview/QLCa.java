/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiCa;
import java.sql.Time;
import java.text.DecimalFormat;
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

public class QLCa {

    private String id;
    private String maCa;
    private String tenCa;
    private Time thoiGianBatDau;
    private Time thoiGianKetThuc;
    private double giaCa;
    private trangThaiCa trangThai = trangThaiCa.GIO_BINH_THUONG;

    public Object toDataRow() {
        return new Object[]{id, maCa, tenCa, thoiGianBatDau, thoiGianKetThuc, new DecimalFormat("###,###,###").format(giaCa) +" "+ "Vnd", trangThai};
    }
}
