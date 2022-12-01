/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import modelview.QLGiaoCa;

/**
 *
 * @author DANG VAN SY
 */
public interface IGiaoCaService {

    QLGiaoCa getOne(String ma);

    String saveOrUpdate(QLGiaoCa qLGiaoCa);
}
