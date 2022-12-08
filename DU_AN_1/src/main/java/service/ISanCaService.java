/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.SanCa;
import java.util.Date;
import java.util.List;
import modelview.QLSanCa;

/**
 *
 * @author hp
 */
public interface ISanCaService {

    SanCa getOne();

    List<QLSanCa> getAll(Date ngayTao);

    String save(QLSanCa qLSanCa);

    String update(QLSanCa qLSanCa);

    String delete(QLSanCa qLSanCa);

    String addListSanCa(List<QLSanCa> list);

    List<QLSanCa> getByNgayTao(Date ngayTao);

    List<SanCa> getSanCaByIdSanBong(String id, Date ngayTaoSanCa);
}
