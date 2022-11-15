/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import domainmodel.KichThuoc;
import enumclass.trangThaiDoThue;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class QLDoThue {

    private UUID id;
    private String maDoThue;
    private String tenDoThue;
    private UUID kichThuoc;
    private String maKichThuoc;
    private String tenKichThuoc;
    private UUID mauSac;
    private String maMauSac;
    private String tenMauSac;
    private UUID nhaSanXuat;
    private String maNhaSanXuat;
    private String tenNhaSanXuat;
    private int soLuong;
    private double donGia;
    private trangThaiDoThue trangThai = trangThaiDoThue.Con_Hang;

    public QLDoThue() {
    }

    public QLDoThue(UUID id, String maDoThue, String tenDoThue, UUID kichThuoc, String maKichThuoc, String tenKichThuoc, UUID mauSac, String maMauSac, String tenMauSac, UUID nhaSanXuat, String maNhaSanXuat, String tenNhaSanXuat, int soLuong, double donGia) {
        this.id = id;
        this.maDoThue = maDoThue;
        this.tenDoThue = tenDoThue;
        this.kichThuoc = kichThuoc;
        this.maKichThuoc = maKichThuoc;
        this.tenKichThuoc = tenKichThuoc;
        this.mauSac = mauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.nhaSanXuat = nhaSanXuat;
        this.maNhaSanXuat = maNhaSanXuat;
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaDoThue() {
        return maDoThue;
    }

    public void setMaDoThue(String maDoThue) {
        this.maDoThue = maDoThue;
    }

    public String getTenDoThue() {
        return tenDoThue;
    }

    public void setTenDoThue(String tenDoThue) {
        this.tenDoThue = tenDoThue;
    }

    public UUID getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(UUID kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(String maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    public UUID getMauSac() {
        return mauSac;
    }

    public void setMauSac(UUID mauSac) {
        this.mauSac = mauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public UUID getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(UUID nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getMaNhaSanXuat() {
        return maNhaSanXuat;
    }

    public void setMaNhaSanXuat(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public trangThaiDoThue getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(trangThaiDoThue trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QLDoThue{" + "id=" + id + ", maDoThue=" + maDoThue + ", tenDoThue=" + tenDoThue + ", kichThuoc=" + kichThuoc + ", maKichThuoc=" + maKichThuoc + ", tenKichThuoc=" + tenKichThuoc + ", mauSac=" + mauSac + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + ", nhaSanXuat=" + nhaSanXuat + ", maNhaSanXuat=" + maNhaSanXuat + ", tenNhaSanXuat=" + tenNhaSanXuat + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }
    
    

}
