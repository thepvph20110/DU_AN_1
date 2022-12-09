/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.SanCa;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ISanCaRepository {
    
    SanCa getOne();
    
    List<SanCa> getAll();
    
    boolean update(SanCa sanCa);

    boolean deleteSanCa(SanCa sanCa);

    boolean save(SanCa sanCa);
<<<<<<< HEAD
    
=======

    boolean saveOutSanCa(SanCa sanCa);

    List<SanCa> getByNgayTao(Date ngayTao);

    List<SanCa> getSanCaByIdSanBong(String id, Date ngayTaoSanCa);
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
}
