package repository;

import domainmodel.ThanhToan;
import java.util.List;

public interface IThanhToanRepository {

    List<ThanhToan> getAllThanhToans();

    boolean save(ThanhToan thanhToan);

    boolean update(ThanhToan thanhToan);

    boolean delete(ThanhToan thanhToan);
}
