package service;

import java.util.List;
import modelview.QLHoaDon_PhuPhi;

public interface IHoaDon_PhuPhiService {

    List<QLHoaDon_PhuPhi> getALlLHoaDon_PhuPhis();

    boolean save(QLHoaDon_PhuPhi qLHoaDon_PhuPhi);

    boolean update(QLHoaDon_PhuPhi qLHoaDon_PhuPhi);

    boolean delete(QLHoaDon_PhuPhi qLHoaDon_PhuPhi);
}