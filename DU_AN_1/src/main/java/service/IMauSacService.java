/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.MauSac;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMauSacService {
    
     List<MauSac> getAll();
    
    String AddorUpdate(MauSac mauSac);
    
    String Delete(MauSac mauSac);
    
    MauSac getOne(String ma);
}
