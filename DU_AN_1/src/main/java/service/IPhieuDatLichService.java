/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLPhieuDatLich;

/**
 *
 * @author ADMIN
 */
public interface IPhieuDatLichService {
    
    List<QLPhieuDatLich> getAll();
    
    String save(QLPhieuDatLich qLPhieuDatLich);
    
    String update(QLPhieuDatLich qLPhieuDatLich);

}
