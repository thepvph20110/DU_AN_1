/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import modelview.QLDoThue;

/**
 *
 * @author Admin
 */
public interface IDoThueService {

    List<QLDoThue> getAll();

    String AddorUpdate(QLDoThue qLDoThue);

    String Delete(QLDoThue qLDoThue);
    
    List<QLDoThue> searchByName(String ten);
}
