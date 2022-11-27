/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiDichVu;
import java.util.UUID;
import javax.persistence.CascadeType;
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
import org.hibernate.annotations.GenericGenerator;

@Table(name = "DichVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DichVu {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String maDichVu;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDoThue")
    private DoThue doThue;
    private int soLuongDoThue;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNuocUong")
    private NuocUong nuocUong;
    private int soLuongNuocUong;
    private double donGia;
   @Column(columnDefinition = "nvarchar(Max)")
    private String moTa;
    @Column(nullable = false)
    private trangThaiDichVu trangThai = trangThaiDichVu.Dang_Su_Dung;

}
