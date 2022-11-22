/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiPhieuDL;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSanCa", nullable = false)
    private SanCa sanCa;
    @Column(columnDefinition = "date")
    private Date ngayTaoPhieu;
    @Column(columnDefinition = "date")
    private Date NgayDenSan;
    @Column(columnDefinition = "time")
    private Time tgCheckIn;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
    @Column(length = 36)
    private String maQR = UUID.randomUUID().toString();
    private double tongTienSan;
    @Column(nullable = false)
    private trangThaiPhieuDL trangThai = trangThaiPhieuDL.CHUA_NHAN_SAN;
}
