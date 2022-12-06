/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.Ca;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ICaRepository {

    List<Ca> getAll();

    boolean saveOrUpdate(Ca ca);

    boolean deleteCa(Ca ca);

    List<Ca> searchByName(String ten);

    String saveCaNew(Ca ca);

    String xoaCa(String id);
}
