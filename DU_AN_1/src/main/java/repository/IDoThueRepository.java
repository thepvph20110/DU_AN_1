/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.DoThue;
import java.util.List;
import modelview.QLDoThue;

/**
 *
 * @author Admin
 */
public interface IDoThueRepository {
    
    List<DoThue> getAll();
    
    String AddorUpdate(DoThue doThue);
    
    String Delete(DoThue doThue);
    
}
