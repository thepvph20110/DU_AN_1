/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;


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

@Table(name = "HoaDonThanhToan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class HoaDonThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    @Column(name = "maTT")
    private String maThanhToan;
    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "idThanhToan")
    private ThanhToan thanhToan;
    private double tongTien;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
}
