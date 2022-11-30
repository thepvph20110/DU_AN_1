package service;

import domainmodel.PhuPhi;
import java.util.List;
import modelview.QLPhuPhi;

public interface IPhuPhiService {

    List<QLPhuPhi> getAllQLPhuPhis();

    boolean save(QLPhuPhi qLphuPhi);

    boolean update(QLPhuPhi qLphuPhi);

    boolean delete(String id);

    String genMaPhuPhi(List<QLPhuPhi> lstQLPhuPhis);

    QLPhuPhi fillByMaPhuPhi(String maPhuPhi);
}
