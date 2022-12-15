package repository;

import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import java.util.List;

public interface IThanhToanRepository {

    List<ThanhToan> getAllThanhToans();

    ThanhToan findOneByTrangThai(loaiHinhThanhToan loaiHinh);

    boolean save(ThanhToan thanhToan);

    boolean update(ThanhToan thanhToan);

    boolean delete(String id);

    String genMaThanhToan();

    ThanhToan fillBymaThanhToan(String maThanhToan);
}
