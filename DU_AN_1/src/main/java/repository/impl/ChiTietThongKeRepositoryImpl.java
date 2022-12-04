/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import repository.IChiTietThongKeRepository;
import response.ChiTietThanhToan.ChiTietDichVuRespone;
import response.ChiTietThanhToan.ChiTietDoThueResponse;
import response.ChiTietThanhToan.ChiTietTongTienTheoNgayResponse;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class ChiTietThongKeRepositoryImpl implements IChiTietThongKeRepository {

    //get Default date
    @Override
    public ChiTietTongTienTheoNgayResponse chiTietTongTien() {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse = null;
        String sql = "Select Sum(hd.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , year(hd.ngayThanhToan) as nam from HoaDon hd where Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and"
                + " year(hd.ngayThanhToan) = YEAR(GETDATE()) And hd.trangThai = 1 Group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();
            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            System.out.println("No Entity Found!!!");
        }
        return chiTietTongTienTheoNgayResponse;
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietThongKeRepositoryImpl().getTongTienNganHangByDate(new Date()));
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienMat() {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse;
        String sql = "Select SUM(hdtt.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , "
                + " year(hd.ngayThanhToan) as nam from HoaDonThanhToan hdtt Inner join ThanhToan tt on hdtt.idThanhToan = tt.id "
                + " Inner join HoaDon hd on hd.id = hdtt.idHoaDon Where Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and "
                + " year(hd.ngayThanhToan) = YEAR(GETDATE()) And hd.trangThai = 1 and tt.loaiHinhTT = 0  group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();
            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            System.out.println("No Entity Found!!!");
        }
        return null;
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienNganHang() {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse;
        String sql = "Select SUM(hdtt.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , "
                + " year(hd.ngayThanhToan) as nam from HoaDonThanhToan hdtt Inner join ThanhToan tt on hdtt.idThanhToan = tt.id "
                + " Inner join HoaDon hd on hd.id = hdtt.idHoaDon Where Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and "
                + " year(hd.ngayThanhToan) = YEAR(GETDATE()) And hd.trangThai = 1 and tt.loaiHinhTT = 1  group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();
            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            System.out.println("No Entity Found!!!");
        }
        return null;
    }

    @Override
    public List<ChiTietDichVuRespone> thongKeNuocUong() {
        List<ChiTietDichVuRespone> listDVs = null;
        String sql = "Select SUM(dv.soLuongNuocUong) as soluong,Sum(nu.gia * dv.soLuongNuocUong) AS tongTien,nu.ten from HoaDon hd INNER JOIN DichVu dv on hd.id = dv.idHoaDon Inner join NuocUong nu on dv.idNuocUong = nu.id "
                + "  WHERE Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and year(hd.ngayThanhToan) = YEAR(GETDATE()) AND hd.trangThai = 1 GROUP BY nu.Ten";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            listDVs = session.createSQLQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(ChiTietDichVuRespone.class)).list();
            return listDVs;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDVs;
    }

    @Override
    public List<ChiTietDoThueResponse> thongKeDoThue() {
        List<ChiTietDoThueResponse> listDVs = null;
        String sql = "Select SUM(dv.soLuongDoThue) as soluong,Sum(dt.donGia * dv.soLuongDoThue) AS tongTien,dt.tenDoThue from HoaDon hd INNER JOIN DichVu dv on hd.id = dv.idHoaDon Inner join DoThue dt on dv.idDoThue = dt.id "
                + "  WHERE Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and year(hd.ngayThanhToan) = YEAR(GETDATE()) AND hd.trangThai = 1 GROUP BY dt.tenDoThue";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            listDVs = session.createSQLQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(ChiTietDoThueResponse.class)).list();
            return listDVs;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDVs;
    }

//    public ChiTietTongTienTheoNgayResponse searchByDate() {
//        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse = null;
//        String sql = "Select Sum(hd.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , year(hd.ngayThanhToan) as nam from HoaDon hd where Day(hd.ngayThanhToan) = DAY(GETDATE()) And Month(hd.ngayThanhToan) = MONTH(GETDATE()) and"
//                + " year(hd.ngayThanhToan) = YEAR(GETDATE()) And hd.trangThai = 1 Group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
//        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
//            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).setResultTransformer(
//                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();
//            return chiTietTongTienTheoNgayResponse;
//        } catch (Exception e) {
//            System.out.println("No Entity Found!!!");
//        }
//        return chiTietTongTienTheoNgayResponse;
//    }
    //get by date
    @Override
    public ChiTietTongTienTheoNgayResponse chiTietTongTienByDate(Date date) {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse;
        String sql = "Select Sum(hd.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , year(hd.ngayThanhToan) as nam from HoaDon hd where Day(hd.ngayThanhToan) = :day And Month(hd.ngayThanhToan) = :month and"
                + " year(hd.ngayThanhToan) = :year And hd.trangThai = 1 Group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).
                    setParameter("day", String.valueOf(localDate.getDayOfMonth())).setParameter("month", String.valueOf(localDate.getMonthValue())).setParameter("year", String.valueOf(localDate.getYear())).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();
            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienMatByDate(Date date) {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse;
        String sql = "Select SUM(hdtt.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , "
                + " year(hd.ngayThanhToan) as nam from HoaDonThanhToan hdtt Inner join ThanhToan tt on hdtt.idThanhToan = tt.id "
                + " Inner join HoaDon hd on hd.id = hdtt.idHoaDon Where Day(hd.ngayThanhToan) = :day And Month(hd.ngayThanhToan) = :month and "
                + " year(hd.ngayThanhToan) = :year And hd.trangThai = 1 and tt.loaiHinhTT = 0  group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println(localDate.getDayOfMonth() + " " + localDate.getMonthValue() + localDate.getYear());
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).
                    setParameter("day", String.valueOf(localDate.getDayOfMonth())).setParameter("month", String.valueOf(localDate.getMonthValue())).setParameter("year", String.valueOf(localDate.getYear())).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();

            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            System.out.println("No Entity Found!!!");
        }
        return null;
    }

    @Override
    public ChiTietTongTienTheoNgayResponse getTongTienNganHangByDate(Date date) {
        ChiTietTongTienTheoNgayResponse chiTietTongTienTheoNgayResponse;
        String sql = "Select SUM(hdtt.tongTien) as tongtien,Day(hd.ngayThanhToan) as ngay,Month(hd.ngayThanhToan) as thang , "
                + " year(hd.ngayThanhToan) as nam from HoaDonThanhToan hdtt Inner join ThanhToan tt on hdtt.idThanhToan = tt.id "
                + " Inner join HoaDon hd on hd.id = hdtt.idHoaDon Where Day(hd.ngayThanhToan) = :day And Month(hd.ngayThanhToan) = :month and "
                + " year(hd.ngayThanhToan) = :year And hd.trangThai = 1 and tt.loaiHinhTT = 1  group by day(hd.ngayThanhToan),month(hd.ngayThanhToan),year(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            chiTietTongTienTheoNgayResponse = (ChiTietTongTienTheoNgayResponse) session.createNativeQuery(sql).
                    setParameter("day", String.valueOf(localDate.getDayOfMonth())).setParameter("month", String.valueOf(localDate.getMonthValue())).setParameter("year", String.valueOf(localDate.getYear())).setResultTransformer(
                    Transformers.aliasToBean(ChiTietTongTienTheoNgayResponse.class)).getSingleResult();

            return chiTietTongTienTheoNgayResponse;
        } catch (Exception e) {
            System.out.println("No Entity Found!!!");
        }
        return null;
    }

    @Override
    public List<ChiTietDichVuRespone> thongKeNuocUongByDate(Date date) {
        List<ChiTietDichVuRespone> listDVs = null;
        String sql = "Select SUM(dv.soLuongNuocUong) as soluong,Sum(nu.gia * dv.soLuongNuocUong) AS tongTien,nu.ten from HoaDon hd INNER JOIN DichVu dv on hd.id = dv.idHoaDon Inner join NuocUong nu on dv.idNuocUong = nu.id "
                + "  WHERE Day(hd.ngayThanhToan) = :day And Month(hd.ngayThanhToan) = :month and year(hd.ngayThanhToan) = :year AND hd.trangThai = 1 GROUP BY nu.Ten";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            listDVs = session.createSQLQuery(sql).
                    setParameter("day", String.valueOf(localDate.getDayOfMonth())).setParameter("month", String.valueOf(localDate.getMonthValue())).setParameter("year", String.valueOf(localDate.getYear())).setResultTransformer(
                    Transformers.aliasToBean(ChiTietDichVuRespone.class)).list();
            return listDVs;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDVs;
    }

    @Override
    public List<ChiTietDoThueResponse> thongKeDoThueByDate(Date date) {
        List<ChiTietDoThueResponse> listDVs = null;
        String sql = "Select SUM(dv.soLuongDoThue) as soluong,Sum(dt.donGia * dv.soLuongDoThue) AS tongTien,dt.tenDoThue from HoaDon hd INNER JOIN DichVu dv on hd.id = dv.idHoaDon Inner join DoThue dt on dv.idDoThue = dt.id "
                + "  WHERE Day(hd.ngayThanhToan) = :day And Month(hd.ngayThanhToan) = :month and year(hd.ngayThanhToan) = :year AND hd.trangThai = 1 GROUP BY dt.tenDoThue";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            listDVs = session.createSQLQuery(sql).
                    setParameter("day", String.valueOf(localDate.getDayOfMonth())).setParameter("month", String.valueOf(localDate.getMonthValue())).setParameter("year", String.valueOf(localDate.getYear())).setResultTransformer(
                    Transformers.aliasToBean(ChiTietDichVuRespone.class)).list();
            return listDVs;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDVs;
    }
}
