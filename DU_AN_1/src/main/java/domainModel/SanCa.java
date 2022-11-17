/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiSanCa;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "SanCa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SanCa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "idCa", nullable = false)
    private Ca ca;
    @ManyToOne
    @JoinColumn(name = "idSanBong")
    private SanBong sanbong;
    @Column(columnDefinition = "date")
    private Date ngayTao;
    private double giaCa;
    @Column(nullable = false)
    private trangThaiSanCa trangThai = trangThaiSanCa.DANG_TRONG;
}
