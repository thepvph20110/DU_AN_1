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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "SanCa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SanCa {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @ManyToOne
    @JoinColumn(name = "idCa", nullable = false)
    private Ca ca;
    @ManyToOne
    @JoinColumn(name = "idSanBong")
    private SanBong sanbong;
    @Column(columnDefinition = "date")
    private Date ngayTao;
    private double giaSanCa;
    @Column(nullable = false)
    private trangThaiSanCa trangThai = trangThaiSanCa.DANG_TRONG;
}
