package modelview;

import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiThanhToan;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ASUS
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QLThanhToan {

    private String id;
    private String maThanhToan;
    private loaiHinhThanhToan hinhThanhToan;
    private String moTa;

}
