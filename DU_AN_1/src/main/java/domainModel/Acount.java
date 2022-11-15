/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiAcount;
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

@Table(name = "Acount")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Acount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    private String maAcount;
    @Column(columnDefinition = "nvarchar(Max)")
    private String tenAcount;
    @ManyToOne
    @JoinColumn(name = "ChucVuId")
    private ChucVu chucVu;
    private String matKhau;
    @Column(columnDefinition = "nvarchar(Max)")
    private String moTa;
    @Column(nullable = false)
    private trangThaiAcount trangThai = trangThaiAcount.Chua_Xac_Minh;

}
