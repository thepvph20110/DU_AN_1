/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import modelview.QLSanCa;

/**
 *
 * @author hp
 */
public interface ISanCaService {

    QLSanCa getOne();

    List<QLSanCa> getAll();

    String save(QLSanCa qLSanCa);

    String update(QLSanCa qLSanCa);

    String delete(QLSanCa qLSanCa);
}
