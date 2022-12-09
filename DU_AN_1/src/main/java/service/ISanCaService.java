/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanCa;
import java.util.List;
import modelview.QLSanCa;

/**
 *
 * @author hp
 */
public interface ISanCaService {

    SanCa getOne();

    List<QLSanCa> getAll();

    String save(QLSanCa qLSanCa);

    String update(QLSanCa qLSanCa);

    String delete(QLSanCa qLSanCa);
<<<<<<< HEAD
=======

    String addListSanCa(List<QLSanCa> list);

    List<QLSanCa> getByNgayTao(Date ngayTao);

    List<SanCa> getSanCaByIdSanBong(String id, Date ngayTaoSanCa);
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
}
