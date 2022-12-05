package repository;

import domainmodel.PhuPhi_HoaDon;
import java.util.List;

public interface IPhuPhiHoaDonRepository {

    List<PhuPhi_HoaDon> getAllPhuPhi_HoaDons();

    boolean save(PhuPhi_HoaDon phuPhi_HoaDon);

    boolean delete(String id);
    
    PhuPhi_HoaDon getOne(String idPhuPhi,String idHoaDon);
    
    List<PhuPhi_HoaDon> getAllPhuPhi_HoaDonsByIdHoaDon(String idHoaDon);
}
