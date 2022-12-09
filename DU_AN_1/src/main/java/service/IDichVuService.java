/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import enumclass.trangThaiDichVu;
import java.util.List;
import java.util.UUID;
import modelview.QLDichVu;

/**
 *
 * @author ASUS
 */
public interface IDichVuService {

    List<QLDichVu> getDichVuNoPagination();

    String createNewDichVu(QLDichVu dichVu);

    String updateDichVuById(QLDichVu dichVu);

    String deleteDichVuById(String id);

    long countAllDichVu();

    List<QLDichVu> getDichVuByMaDichVu(String maDichVu);

    List<QLDichVu> getDichVuByTrangThai(trangThaiDichVu trangThai);
    
    String genMaDichVu();
}
