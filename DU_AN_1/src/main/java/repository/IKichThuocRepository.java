/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.KichThuoc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKichThuocRepository {

    List<KichThuoc> getAll();

    String AddorUpdate(KichThuoc kichThuoc);

    String Delete(KichThuoc kichThuoc);

    KichThuoc getOne(String ma);

    int genMaKicThuoc();
}
