/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLLoaiSan;

/**
 *
 * @author hp
 */
public interface ILoaiSanService {

    List<QLLoaiSan> getAll();

    String save(QLLoaiSan qLLoaiSan);

    String update(QLLoaiSan qLLoaiSan);

    String delete(QLLoaiSan qLLoaiSan);
    
    List<QLLoaiSan> searchByName(String ten);

<<<<<<< HEAD
=======
    LoaiSan getOne(String tenSan);
    
    String genMaLoaiSan();

>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
