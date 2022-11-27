/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.loaiHinhThanhToan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "ThanhToan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ThanhToan {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "ma")
    private String maThanhToan;
    @Column(name = "loaiHinhTT")
    private loaiHinhThanhToan hinhThanhToan = loaiHinhThanhToan.Tien_Mat;
    @Column(columnDefinition = "nvarchar(Max)")
    private String moTa;

}
