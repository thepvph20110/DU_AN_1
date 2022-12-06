package repository;

import domainModel.LichSuDatLich;
import java.util.List;

public interface ILichSuDatLichRepository {

    List<LichSuDatLich> getAllLichSuDatLichs();

    boolean save(LichSuDatLich lichSuDatLich);

    boolean delete(String id);

    List<LichSuDatLich> getLichSuDatBySoDienThoai(String soDienThoai);

    List<LichSuDatLich> getLichSuDatByMaLichSu(String maLichSu);
}
