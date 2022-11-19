package repository;

import domainmodel.PhuPhi_HoaDon;
import java.util.List;

public interface IPhuPhiHoaDonRepository {

    List<PhuPhi_HoaDon> getAllPhuPhi_HoaDons();

    boolean save(PhuPhi_HoaDon phuPhi_HoaDon);

    boolean delete(PhuPhi_HoaDon phuPhi_HoaDon);
}
