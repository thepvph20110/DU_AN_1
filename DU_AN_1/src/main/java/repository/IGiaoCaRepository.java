
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainModel.GiaoCa;
import modelview.QLGiaoCa;
/**
 *
 * @author DANG VAN SY
 */
public interface IGiaoCaRepository {

    GiaoCa getOne(String ma);

    String saveOrUpdate(GiaoCa giaoCa);


}
