/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import enumclass.trangThaiSanCa;
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

    private UUID id;
    private QLCa qLca;
    private QLPhieuDatLich qLphieuDatLich;
    private QLSanBong sanBong;
    private double giaCa;
    private trangThaiSanCa trangThai = trangThaiSanCa.DANG_TRONG;
    
    public Object[] toDataRow(){
        return new Object[]{id, qLca.getTenCa(), qLphieuDatLich.getNgayTaoPhieu(), sanBong.getTenSanBong(), giaCa, trangThai};
    }

}
