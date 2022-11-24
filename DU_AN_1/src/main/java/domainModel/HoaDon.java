/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiHoaDon;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    
    private String maHoaDon;
    @OneToOne
    @JoinColumn(name = "idPhieuDatLich")
    private PhieuDatLich phieuDatLich;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "hoaDon")
    private Set<DichVu> dichVu;
    @Column(columnDefinition = "date")
    private Date ngayThanhToan;
    private double donGia;
    private double tongTien;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
    @Column(nullable = false)
    private trangThaiHoaDon trangThai = trangThaiHoaDon.CHUA_THANH_TOAN;

}
