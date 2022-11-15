/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiHoaDon;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idPhieuDatLich")
    private PhieuDatLich phieuDatLich;
    @ManyToOne
    @JoinColumn(name = "idDichVu")
    private DichVu dichVu;
    private Date ngayThanhToan;
    private double donGia;
    private double tongTien;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
    @Column(nullable = false)
    private trangThaiHoaDon trangThai = trangThaiHoaDon.CHUA_THANH_TOAN;

}
