/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.NhaSanXuat;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhaSanXuatRepository {

    List<NhaSanXuat> getAll();

    String AddorUpdate(NhaSanXuat nhaSanXuat);

    String Delete(NhaSanXuat nhaSanXuat);
    
    NhaSanXuat getOne(String ma);
    
    int genMaNSX();
}
