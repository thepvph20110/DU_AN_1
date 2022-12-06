package domainModel;

import domainmodel.PhieuDatLich;
import enumclass.trangThaiLichSuDatLich;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "LichSuDatLich")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LichSuDatLich {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "idPhieuDatLich")
    private PhieuDatLich phieuDatLich;

    @Column(name = "maLichSu")
    private String maLichSu;

    @Column(name = "ngayDatLich")
    private Date ngayDatLich;

    @Column(name = "ngayDenSan")
    private Date ngayDenSan;

    @Column(name = "trangThai")
    private trangThaiLichSuDatLich trangThai = trangThaiLichSuDatLich.DA_DAT_LICH;
}
