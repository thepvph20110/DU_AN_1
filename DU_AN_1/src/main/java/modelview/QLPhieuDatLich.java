package modelview;

import enumclass.trangThaiPhieuDL;
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
    private QLKhachHang qLkhachHang;
    private Date ngayTaoPhieu;
    private Date NgayDenSan;
    private Date ngayCheckIn;
    private String ghiChu;
    private double tongTienSan;
    private trangThaiPhieuDL trangThai = trangThaiPhieuDL.CHUA_NHAN_SAN;

}
