/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import modelView.QLChucVu;

/**
 *
 * @author Admin
 */
public interface IChucVuService {

    List<QLChucVu> getAll();

    String save(QLChucVu qLChucVu);

    String update(QLChucVu qLChucVu, String id);

    String delete(String id);
    
    String genMaChucVu();
}
