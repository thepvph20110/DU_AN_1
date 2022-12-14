/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.PhieuDatLich;
import java.util.List;
import java.util.UUID;
import modelview.QLPhieuDatLich;

/**
 *
 * @author ADMIN
 */
public interface IPhieuDatLichService {

    List<QLPhieuDatLich> getAll();

    String save(QLPhieuDatLich qLPhieuDatLich);

    String update(QLPhieuDatLich qLPhieuDatLich);

    String delete(String id);

    List<PhieuDatLich> getPhieuDatLichByTT();

    List<PhieuDatLich> getPhieuDatLichBySDT(String sdt);

    String updateTrangThai(PhieuDatLich phieuDatLich);

    String datLich(PhieuDatLich phieuDatLich);

    PhieuDatLich getPhieuDatLich(String id);

    PhieuDatLich getPDLByTrangThai(String id);

    List<PhieuDatLich> getPhieuTheoTTHD();

    List<PhieuDatLich> getPhieuChuaTT();

    String updatePDL(PhieuDatLich phieuDatLich);
}
