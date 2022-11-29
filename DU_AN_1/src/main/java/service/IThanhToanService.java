package service;

import domainmodel.ThanhToan;
import java.util.List;
import modelview.QLThanhToan;

public interface IThanhToanService {

    List<QLThanhToan> getAllThanhToans();

    boolean save(QLThanhToan qLThanhToan);

    boolean update(QLThanhToan qLThanhToan);

    boolean delete(String id);

    String genMaThanhToan(List<QLThanhToan> lstQLThanhToans);

    QLThanhToan fillByMaThanhToan(String maThanhToan);
}
