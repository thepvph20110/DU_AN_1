/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import modelview.QLAcount;

/**
 *
 * @author Admin
 */
public interface IAcountService {

    QLAcount getOne();
            
    List<QLAcount> getAll();

    String save(QLAcount qLAcount);

    String update(QLAcount qLAcount, UUID id);

<<<<<<< HEAD
    String delete(UUID id);
=======
    String delete(String id);
    
    String genMaAccount();
>>>>>>> 0f4cad2f7c54da986d78447c8a91cf878af78d91
}
