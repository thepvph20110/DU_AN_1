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

    List<PhieuDatLich> getPhieuDatLichByTT();

    List<PhieuDatLich> getPhieuDatLichBySDT(String sdt);

    boolean save(PhieuDatLich phieuDatLich);

    boolean update(PhieuDatLich phieuDatLich);

    boolean delete(String id);

    PhieuDatLich getByIdSanCa(String id);

    PhieuDatLich getPDLByTrangThai(String id);

    List<PhieuDatLich> getPhieuTheoTTHD();

    List<PhieuDatLich> getPhieuChuaTT();
}
