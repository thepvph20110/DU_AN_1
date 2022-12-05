package service;

import java.util.List;
import modelview.QLHoaDon_PhuPhi;

public interface IHoaDon_PhuPhiService {

    List<QLHoaDon_PhuPhi> getALlLHoaDon_PhuPhis();

    boolean save(QLHoaDon_PhuPhi qLHoaDon_PhuPhi);

    boolean update(QLHoaDon_PhuPhi qLHoaDon_PhuPhi);

    boolean delete(String id);

    QLHoaDon_PhuPhi getOne(String idPhuPhi,String idHoaDon);

    List<QLHoaDon_PhuPhi> getAllPhuPhi_HoaDonsByIdHoaDon(String idHoaDon);
}
