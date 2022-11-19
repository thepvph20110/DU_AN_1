/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLKhachHang;

/**
 *
 * @author hp
 */
public interface IKhachHangService {
    
    List<QLKhachHang> getAll();
    
    String save(QLKhachHang qLKhachHang);
    
    String update(QLKhachHang qLKhachHang);
    
    String delete(QLKhachHang qLKhachHang);
}
