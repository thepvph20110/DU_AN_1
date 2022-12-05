/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ca;
import java.util.List;
import modelview.QLCa;

/**
 *
 * @author hp
 */
public interface ICaService {

    List<QLCa> getAll();

    String save(QLCa qLCa);

    String update(QLCa qLCa);

    String delete(QLCa qLCa);

    List<QLCa> searchByName(String ten);

    String saveNewCa(Ca ca);

    String xoaCa(String id);
}
