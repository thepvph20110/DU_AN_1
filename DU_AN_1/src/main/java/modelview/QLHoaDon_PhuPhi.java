package modelview;

import enumclass.trangThaiPhuPhiHoaDon;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLHoaDon_PhuPhi {

    private UUID id;

    private QLHoaDon hoaDon;

    private QLPhuPhi phuPhi;

    private double giaPPHD;
    
    private String moTa;

}
