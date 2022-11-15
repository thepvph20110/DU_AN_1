/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiPhieuDL;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PhieuDatLich {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idAcount")
    private Acount acount;
    @ManyToOne
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;
    
    private Date ngayTaoPhieu;
    private Date NgayDenSan;
    private Date ngayCheckIn;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
    private double tongTienSan;
    @Column(nullable = false)
    private trangThaiPhieuDL trangThai = trangThaiPhieuDL.CHUA_NHAN_SAN;
}
