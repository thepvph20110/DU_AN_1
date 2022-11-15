/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiDichVu;
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

@Table(name = "DichVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    private String maDichVu;
    @ManyToOne
    @JoinColumn(name = "idDoThue")
    private DoThue doThue;
    private int soLuongDoThue;
    @ManyToOne
    @JoinColumn(name = "idNuocUong")
    private NuocUong nuocUong;
    private int soLuongNuocUong;
    private double donGia;
   @Column(columnDefinition = "nvarchar(Max)")
    private String moTa;
    @Column(nullable = false)
    private trangThaiDichVu trangThai = trangThaiDichVu.Dang_Su_Dung;

}
