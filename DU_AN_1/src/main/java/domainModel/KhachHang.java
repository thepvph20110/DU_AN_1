/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiKhachHang;
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

@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    private String maKhachHang;
    @Column(columnDefinition = "nvarchar(Max)")
    private String tenKhachHang;
    private String mail;
    @Column(name = "sdt")
    private String soDienThoai;
    @Column(columnDefinition = "nvarchar(Max)")
    private String ghiChu;
    @Column(nullable = false)
    private trangThaiKhachHang trangThai = trangThaiKhachHang.BINH_THUONG;
    
}
