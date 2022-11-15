/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KichThuoc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKichThuocService {

    List<KichThuoc> getAll();

    String AddorUpdate(KichThuoc kichThuoc);

    String Delete(KichThuoc kichThuoc);

}
