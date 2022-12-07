package service;

import java.util.List;
import modelview.QLLichSuDatLich;

public interface ILichSuDatLichService {

    List<QLLichSuDatLich> getAllLichSuDatLichs();

    boolean save(QLLichSuDatLich qLLichSuDatLich);

    boolean update(QLLichSuDatLich qLLichSuDatLich);

    boolean delete(String id);

    List<QLLichSuDatLich> getLichSuDatBySoDienThoai(String soDienThoai);

    List<QLLichSuDatLich> getLichSuDatByMaLichSu(String soDienThoai);

    String genMaLichSu(List<QLLichSuDatLich> lstQLLichSuDatLichs);
}
