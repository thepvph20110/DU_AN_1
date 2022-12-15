/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

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
<<<<<<< HEAD
=======

    String saveNewCa(Ca ca);

    String xoaCa(String id);
    
    String genMaCa();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
