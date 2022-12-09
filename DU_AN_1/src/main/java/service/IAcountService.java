/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Acount;
import java.util.List;
import java.util.UUID;
import modelview.QLAcount;

/**
 *
 * @author Admin
 */
public interface IAcountService {

    Acount getOne();

    Acount getOneByNameAcount(String ten);

    List<QLAcount> getAll();

    String save(QLAcount qLAcount);

    String update(QLAcount qLAcount, String id);

    String delete(String id);

    String genMaAccount();

    QLAcount getByUseNameAndPass(String UseName, String pass);
}
