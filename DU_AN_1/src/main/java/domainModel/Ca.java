/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiCa;
import java.sql.Time;
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
import org.hibernate.annotations.GenericGenerator;

@Table(name = "Ca")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ca {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String maCa;
    @Column(columnDefinition = "nvarchar(Max)")
    private String tenCa;
    @Column(columnDefinition = "time")
    private Time thoiGianBatDau;
    @Column(columnDefinition = "time")
    private Time thoiGianKetThuc;
    private double giaCa;
    @Column(nullable = false)
    private trangThaiCa trangThai = trangThaiCa.GIO_BINH_THUONG;
}
