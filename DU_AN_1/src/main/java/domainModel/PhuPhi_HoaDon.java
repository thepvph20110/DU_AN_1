/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiPhuPhi;
import enumclass.trangThaiPhuPhiHoaDon;
import java.util.Date;
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

@Table(name = "PhuPhi_HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PhuPhi_HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPhuPhi")
    private PhuPhi phuPhi;
    private double giaPPHD;
    @Column(columnDefinition = "nvarchar(Max)")
    private String moTa;
}
