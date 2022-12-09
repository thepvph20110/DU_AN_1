/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainModel.GiaoCa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import modelview.QLGiaoCa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import repository.IGiaoCaRepository;
import response.ThanhToan.TongTienHoaDonResponse;
import response.ThanhToan.TongTienMatGiaoCa;
import utill.HibernateConfig;

/**
 *
 * @author DANG VAN SY
 */
public class GiaoCaRepository implements IGiaoCaRepository {

    private List<TongTienMatGiaoCa> TongTIen = new ArrayList<>();

    @Override
    public GiaoCa getOne(String ma) {
        String hql = "From GiaoCa gc WHERE gc.ma = :MaGC";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return session.createQuery(hql, GiaoCa.class).setParameter("MaGC", ma).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String a = "2022-12-06";
            Date date = format.parse(a);
        } catch (ParseException ex) {
            Logger.getLogger(GiaoCaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String saveOrUpdate(GiaoCa giaoCa) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(giaoCa);
            transaction.commit();
            return "Giao ca thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Giao ca thất bại";
        }
    }

    @Override
    public List<TongTienMatGiaoCa> getTongTienMatHienTai( Date thoiGianNhanCa,Date thoiGianCuoiCa) {

        String sql = "SELECT SUM(dbo.HoaDon.tongTien) AS TongTien FROM dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idAcount =  dbo.Acount.id"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id "
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id "
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id "
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id WHERE dbo.ThanhToan.loaiHinhTT = 0 and dbo.GiaoCa.thoiGianNhanCa = :TimeNhanCa and dbo.GiaoCa.thoiGianGiaoCa = :TimeKT";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            TongTIen = session.createSQLQuery(sql).setParameter("TimeNhanCa", thoiGianNhanCa).setParameter("TimeKT", thoiGianCuoiCa).setResultTransformer(
                    Transformers.aliasToBean(TongTienMatGiaoCa.class)).list();
            return TongTIen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TongTienMatGiaoCa> getTongTienKhacHienTai(Date thoiGianNhanCa,Date thoiGianCuoiCa) {
        String sql = "SELECT SUM(dbo.HoaDon.tongTien) AS TongTien FROM dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idAcount =  dbo.Acount.id"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id "
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id "
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id "
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id WHERE dbo.ThanhToan.loaiHinhTT = 0 and dbo.GiaoCa.thoiGianNhanCa = :TimeNhanCa and dbo.ThanhToan.loaiHinhTT = 1";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            TongTIen = session.createSQLQuery(sql).setParameter("TimeNhanCa", thoiGianNhanCa).setResultTransformer(
                    Transformers.aliasToBean(TongTienMatGiaoCa.class)).list();
            return TongTIen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
