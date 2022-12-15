/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import enumclass.trangThaiDoThue;
import java.util.List;
import modelview.QLDoThue;

/**
 *
 * @author Admin
 */
public interface IDoThueService {

    List<QLDoThue> getAll();

    String AddorUpdate(QLDoThue qLDoThue);

    String Delete(QLDoThue qLDoThue);
<<<<<<< HEAD
    
    List<QLDoThue> searchByName(String ten);
=======

    long countAllDoThue();

    List<QLDoThue> getDoThueByTenDoThue(String tenDoThue);

    List<QLDoThue> getDoThueByTranThai(trangThaiDoThue trangThai);

    String createNewDoThue(QLDoThue qLDoThue);

    String updateDoThueById(QLDoThue qLDoThue);

    String deleteDoThueById(String id);
<<<<<<< HEAD
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
=======
    
    String genMaDoThue();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
