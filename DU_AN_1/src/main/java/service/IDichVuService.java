/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import modelview.QLDichVu;

/**
 *
 * @author ASUS
 */
public interface IDichVuService {

    List<QLDichVu> getDichVu(int position, int pageSize);

    List<QLDichVu> getDichVuNoPagination();

    String createNewDichVu(QLDichVu dichVu);

    String updateDichVuById(QLDichVu dichVu);

    String deleteDichVuById(String id);

    long countAllDichVu();
}
