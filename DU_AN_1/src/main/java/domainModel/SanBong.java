/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiSanBong;
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

@Table(name = "SanBong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanBong {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    private String maSanBong;
    @Column(columnDefinition = "nvarchar(Max)")
    private String tenSanBong;
    private double giaSan;
    private int sucChua;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLoaiSan", nullable = false)
    private LoaiSan loaiSan;
    private trangThaiSanBong trangThai = trangThaiSanBong.HOAT_DONG;
}
