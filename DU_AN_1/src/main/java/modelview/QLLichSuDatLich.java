package modelview;

import enumclass.trangThaiLichSuDatLich;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class QLLichSuDatLich {

    private String id;

    private QLPhieuDatLich qLPhieuDatLich;

    private String maLichSu;

    private Date ngayDatLich;

    private Date ngayDenSan;

    private trangThaiLichSuDatLich trangThai = trangThaiLichSuDatLich.DA_DAT_LICH;
}
