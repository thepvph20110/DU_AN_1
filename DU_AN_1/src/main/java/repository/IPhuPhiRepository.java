package repository;

import domainmodel.PhuPhi;
import java.util.List;

public interface IPhuPhiRepository {

    List<PhuPhi> getAllPhuPhi();

    boolean save(PhuPhi phuPhi);

    boolean delete(String id);

    String genMaPhuPhi();

    PhuPhi fillByMa(String maPhuPhi);
}
