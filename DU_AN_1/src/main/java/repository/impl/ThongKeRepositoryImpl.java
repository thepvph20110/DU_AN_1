/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import response.TongTienHoaDonResponse;
import utill.HibernateConfig;
import repository.IThongKeRepository;
import response.TongSoLuongDoThue;
import response.TongSoLuongNuocUong;

/**
 *
 * @author Admin
 */
public class ThongKeRepositoryImpl implements IThongKeRepository {

    @Override
    public List<TongTienHoaDonResponse> getTongTien() {
        List<TongTienHoaDonResponse> list = null;
        String sql = "Select Sum(hd.tongTien) AS tongTien,MONTH(hd.ngayThanhToan) AS thang ,YEAR(hd.ngayThanhToan)as nam from HoaDon"
                + " hd Where hd.trangThai = 1 and YEAR(hd.ngayThanhToan) = YEAR(GETDATE()) group by MONTH(hd.ngayThanhToan)"
                + ",YEAR(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            list = session.createSQLQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(TongTienHoaDonResponse.class)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        ThongKeRepositoryImpl impl = new ThongKeRepositoryImpl();
        for (TongTienHoaDonResponse tongTienHoaDonResponse : impl.getTongTienByYear("2020")) {
            System.out.println(tongTienHoaDonResponse.getTongTien());
        }
    }

    @Override
    public List<TongSoLuongNuocUong> getTongNuocUong() {
        List<TongSoLuongNuocUong> list = null;
        String sql = "Select SUM(dv.soLuongNuocUong) as soluongnuocuong,nc.ten from DichVu dv"
                + " inner join NuocUong nc on dv.idNuocUong = nc.id group by nc.ten";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            list = session.createSQLQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(TongSoLuongNuocUong.class)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public List<TongSoLuongDoThue> getTongDoThue() {
        List<TongSoLuongDoThue> list = null;
        String sql = "Select SUM(dv.soLuongDoThue) as soluongdothue,dt.tenDoThue from DichVu dv inner join DoThue dt on dv.idDoThue = dt.id group by dt.tenDoThue";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            list = session.createSQLQuery(sql).setResultTransformer(
                    Transformers.aliasToBean(TongSoLuongDoThue.class)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public List<TongTienHoaDonResponse> getTongTienByYear(String year) {
        List<TongTienHoaDonResponse> list = null;
        String sql = "Select Sum(hd.tongTien) AS tongTien,MONTH(hd.ngayThanhToan) AS thang ,YEAR(hd.ngayThanhToan)as nam from HoaDon"
                + " hd Where hd.trangThai = 1 and YEAR(hd.ngayThanhToan) = :year group by MONTH(hd.ngayThanhToan)"
                + ",YEAR(hd.ngayThanhToan)";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            list = session.createSQLQuery(sql).setParameter("year", year).setResultTransformer(
                    Transformers.aliasToBean(TongTienHoaDonResponse.class)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
