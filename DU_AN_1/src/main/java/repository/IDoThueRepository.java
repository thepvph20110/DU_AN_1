/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DoThue;
import enumclass.trangThaiDoThue;
import java.util.List;
import modelview.QLDoThue;

/**
 *
 * @author Admin
 */
public interface IDoThueRepository {

    List<DoThue> getAll();

    String AddorUpdate(DoThue doThue);

    String Delete(DoThue doThue);
<<<<<<< HEAD
    
    List<DoThue> searchByName(String ten);
=======

    List<DoThue> findByTenDoThue(String ten);

    List<DoThue> findByTrangThai(trangThaiDoThue trangThai);

    long totalCount();

    boolean saveOrUpdate(DoThue doThue);

    boolean delete(String id);
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
}
