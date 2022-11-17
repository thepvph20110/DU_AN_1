package service;

import java.util.List;
import modelview.QLThanhToan;

public interface IThanhToanService {

    List<QLThanhToan> getAllThanhToans();

    boolean save(QLThanhToan qLThanhToan);

    boolean update(QLThanhToan qLThanhToan);

    boolean delete(QLThanhToan qLThanhToan);
}
