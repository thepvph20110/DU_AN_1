/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;


import enumclass.trangThaiNuocUong;
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


@Table(name = "NuocUong")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NuocUong {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    private String maNuocUong;
    @Column(name = "ten",columnDefinition = "nvarchar(Max)")
    private String tenNuocUong;
    private int soLuong;
    private long gia;
    private trangThaiNuocUong trangThai;

}
