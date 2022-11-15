/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLSanBong;

/**
 *
 * @author hp
 */
public interface ISanBongService {

    List<QLSanBong> getAll();

    String save(QLSanBong qLSanBong);

    String update(QLSanBong qLSanBong);

    String delete(QLSanBong qLSanBong);
}
