/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiSanCa;
import java.sql.Time;
import java.util.Date;
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
public class QLSanCa {

    private String id;
    private String tenCa;
    private String tenSanBong;
    private int sucChua;
    private Time thoiGianBatDau;
    private Time thoiGianKetThuc;
    private Date ngayTao;
    private double giaCaSan;
    private trangThaiSanCa trangThai = trangThaiSanCa.DANG_TRONG;

    public Object[] toDataRow() {
        return new Object[]{ ngayTao, tenCa, tenSanBong,sucChua, thoiGianBatDau, thoiGianKetThuc, giaCaSan, trangThai};
    }

}
