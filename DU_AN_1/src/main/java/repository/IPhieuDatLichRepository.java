/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodel.PhieuDatLich;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ADMIN
 */
public interface IPhieuDatLichRepository {

    List<PhieuDatLich> getAll();
<<<<<<< HEAD
    
    List<PhieuDatLich> getPhieuDatLichByTT();
 
=======

    List<PhieuDatLich> getPhieuDatLichByTT();

    List<PhieuDatLich> getPhieuDatLichBySDT(String sdt);

>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
    boolean save(PhieuDatLich phieuDatLich);

    boolean update(PhieuDatLich phieuDatLich);

    boolean delete(UUID id);

<<<<<<< HEAD
=======
    PhieuDatLich getByIdSanCa(String id);

    PhieuDatLich getPDLByTrangThai(String id);

    List<PhieuDatLich> getPhieuTheoTTHD();

    List<PhieuDatLich> getPhieuChuaTT();
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
