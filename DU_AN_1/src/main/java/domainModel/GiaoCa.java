/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import domainmodel.Acount;
import enumclass.trangThaiGiaoCa;
import java.io.Serializable;
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

@Table(name = "GiaoCa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class GiaoCa implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String ma;
    private Date thoiGianNhanCa;
    private Date thoiGianGiaoCa;
    private String idNhanVienTrongCa;
    private String idNhanVienCaTiepTheo;
    private float tienBanDau;
    private float tongTienTrongCa;
    private float tongTienMat;
    private float tongTienKhac;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChuPhatSinh;
    private float tongTienMatCaTruoc;
    private Date thoiGianReset;
    @ManyToOne
    @JoinColumn(name = "idAcount")
    private Acount idAcount;
    private float tongTienMatRut;
    private trangThaiGiaoCa trangThai = trangThaiGiaoCa.NHAN_CA;
}
