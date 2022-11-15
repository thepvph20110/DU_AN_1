/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiThanhToan;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ThanhToan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    @Column(name = "ma")
    private String maThanhToan;
    @Column(name = "loaiHinhTT")
    private loaiHinhThanhToan hinhThanhToan = loaiHinhThanhToan.Tien_Mat;
    private String moTa;
    @Column(nullable = false)
    private trangThaiThanhToan trangThai = trangThaiThanhToan.Da_Thanh_Toan;

}
