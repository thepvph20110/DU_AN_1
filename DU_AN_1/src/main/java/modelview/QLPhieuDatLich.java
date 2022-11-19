package modelview;

import enumclass.trangThaiPhieuDL;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QLPhieuDatLich {

    private UUID id;
    private QLAcount acount;
    private QLKhachHang khachHang;
    private QLSanCa sanCa;
    private Date ngayTaoPhieu;
    private Date NgayDenSan;
    private Time tgCheckIn;
    private String ghiChu;
    private double tongTienSan;
    private trangThaiPhieuDL trangThai = trangThaiPhieuDL.CHUA_NHAN_SAN;
    
    public Object toDataRow(){
        return new Object[] {id, acount.getTenAcount(), khachHang.getTenKhachHang(),sanCa.getCa(), ngayTaoPhieu, NgayDenSan, tgCheckIn, ghiChu, tongTienSan, trangThai};
    }

}