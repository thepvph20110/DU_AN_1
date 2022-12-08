/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.SanCa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ISanCaRepository {

    SanCa getOne();

    List<SanCa> getAll(Date ngayTao);

    boolean update(SanCa sanCa);

    boolean deleteSanCa(SanCa sanCa);

    boolean save(SanCa sanCa);

    boolean saveOutSanCa(SanCa sanCa);

    List<SanCa> getByNgayTao(Date ngayTao);

    List<SanCa> getSanCaByIdSanBong(String id, Date ngayTaoSanCa);
}
