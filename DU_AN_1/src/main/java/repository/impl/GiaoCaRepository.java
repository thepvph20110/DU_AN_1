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

    @Override
    public String NhanCa(GiaoCa giaoCa) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(giaoCa);
            transaction.commit();
            return "Nhận ca thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Nhận ca thất bại";
        }
    }

    @Override
    public GiaoCa getOneGiaoCaById(String id) {
        GiaoCa giaoCa;
        String hql = "From GiaoCa gc WHERE gc.idNhanVienTrongCa = :idNhanvien ORDER BY gc.thoiGianNhanCa DESC";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql, GiaoCa.class).setParameter("idNhanvien", id);
            query.setFirstResult(0);
            query.setMaxResults(1);
            giaoCa = (GiaoCa) query.getSingleResult();
            return giaoCa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double tongTienCaHienTaiByIdNV(String id) {
        String hql = "SELECT SUM(HoaDon.tongTien) AS TongTien \n"
                + "FROM    dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idNhanVienTrongCa =  dbo.Acount.id\n"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id \n"
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id \n"
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id \n"
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id\n"
                + "WHERE GiaoCa.idNhanVienTrongCa = :idNhanVienTrongCa and  HoaDon.ngayThanhToan between GiaoCa.thoiGianNhanCa and GETDATE() \n"
                + " and DATEPART(HOUR,HoaDon.ngayThanhToan)  between (Select TOP 1 DATEPART(HOUR,GiaoCa.thoiGianNhanCa) FROM GiaoCa order by GiaoCa.thoiGianNhanCa DESC) and DATEPART(HOUR,GETDATE())\n"
                + "GROUP BY dbo.Acount.maAcount";
        double tongTieng;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            tongTieng = (double) session.createSQLQuery(hql).setParameter("idNhanVienTrongCa", id).getSingleResult();
            return tongTieng;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int tongHoaDOnDaTT(String id) {
        String hql = "SELECT COUNT(HoaDon.id) AS TongTien \n"
                + "FROM    dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idNhanVienTrongCa =  dbo.Acount.id\n"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id \n"
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id \n"
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id \n"
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id\n"
                + "WHERE GiaoCa.idNhanVienTrongCa = :idNhanVienTrongCa and  HoaDon.ngayThanhToan between GiaoCa.thoiGianNhanCa and GETDATE() \n"
                + " and DATEPART(HOUR,HoaDon.ngayThanhToan)  between (Select TOP 1 DATEPART(HOUR,GiaoCa.thoiGianNhanCa) FROM GiaoCa order by GiaoCa.thoiGianNhanCa DESC) and DATEPART(HOUR,GETDATE()) and HoaDon.trangThai = 1 \n"
                + "GROUP BY dbo.Acount.maAcount";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (int) session.createSQLQuery(hql).setParameter("idNhanVienTrongCa", id).getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int tongHoaDOnChuaTT(String id) {
        String hql = "SELECT COUNT(HoaDon.id) AS TongTien \n"
                + "FROM    dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idNhanVienTrongCa =  dbo.Acount.id\n"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id \n"
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id \n"
                + "WHERE GiaoCa.idNhanVienTrongCa = :idNhanVienTrongCa and GiaoCa.trangThai = 0 and HoaDon.trangThai = 0";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (int) session.createSQLQuery(hql).setParameter("idNhanVienTrongCa", id).getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public double tongTienNganHang(String id) {
        String hql = "SELECT SUM(HoaDon.tongTien) AS TongTien\n"
                + "FROM    dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idNhanVienTrongCa =  dbo.Acount.id\n"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id \n"
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id \n"
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id \n"
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id\n"
                + "WHERE GiaoCa.idNhanVienTrongCa = :idNhanVienTrongCa and GiaoCa.trangThai = 0 and ThanhToan.loaiHinhTT = 1";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (double) session.createSQLQuery(hql).setParameter("idNhanVienTrongCa", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String GiaoCa(GiaoCa giaoCa) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(giaoCa);
            transaction.commit();
            return "Giao ca thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Giao ca thất bại";
        }
    }

    @Override
    public List<GiaoCa> checkCaTrong(String idNhanVienTrongCa) {
        List<GiaoCa> listGiaoCa = new ArrayList<>();
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            String sql = "FROM  GiaoCa gc WHERE gc.idNhanVienTrongCa = :NhanVienTrongCa and gc.trangThai = 0";
            Query q = session.createQuery(sql).setParameter("NhanVienTrongCa", idNhanVienTrongCa);
            listGiaoCa = q.getResultList();
            return listGiaoCa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGiaoCa;
    }

    @Override
    public GiaoCa checkCoNhanVIenKo() {
        List<GiaoCa> listGiaoCa = new ArrayList<>();
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            String sql = "FROM  GiaoCa gc WHERE gc.trangThai = 0";
            return (GiaoCa) session.createQuery(sql).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GiaoCa getOneGiaoCaByIdAndTrangThai(String id) {
        GiaoCa giaoCa;
        String hql = "From GiaoCa gc WHERE gc.idNhanVienTrongCa = :idNhanvien and gc.trangThai = 0 ";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql, GiaoCa.class).setParameter("idNhanvien", id);
            giaoCa = (GiaoCa) query.getSingleResult();
            return giaoCa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public double tongTienMat(String id) {
        String hql = "SELECT SUM(HoaDon.tongTien) AS TongTien\n"
                + "FROM    dbo.GiaoCa JOIN dbo.Acount ON dbo.GiaoCa.idNhanVienTrongCa =  dbo.Acount.id\n"
                + "		JOIN dbo.PhieuDatLich ON dbo.PhieuDatLich.idAcount = dbo.Acount.id \n"
                + "		JOIN dbo.HoaDon ON dbo.HoaDon.idPhieuDatLich = dbo.PhieuDatLich.id \n"
                + "		JOIN dbo.HoaDonThanhToan ON dbo.HoaDonThanhToan.idHoaDon = dbo.HoaDon.id \n"
                + "		JOIN dbo.ThanhToan ON dbo.HoaDonThanhToan.idThanhToan = dbo.ThanhToan.id\n"
                + "WHERE GiaoCa.idNhanVienTrongCa = :idNhanVienTrongCa and GiaoCa.trangThai = 0 and ThanhToan.loaiHinhTT = 0";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (double) session.createSQLQuery(hql).setParameter("idNhanVienTrongCa", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public GiaoCa TimKiemNVCaTiepTheo() {
        String hql = "From GiaoCa gc "
                + "  ORDER By gc.thoiGianNhanCa DESC";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql, GiaoCa.class);
            query.setFirstResult(0);
            query.setMaxResults(1);
            return (GiaoCa) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GiaoCaRepository().TimKiemNVCaTiepTheo().getId());
    }

    @Override
    public List<GiaoCa> getAll() {
        List<GiaoCa> list = new ArrayList<>();
        String hql = "From GiaoCa";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql, GiaoCa.class);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<GiaoCa> searchByName(String name) {
        List<GiaoCa> list = new ArrayList<>();
        String hql = "From GiaoCa gc WHERE gc.idAcount.tenAcount like :ten and gc.trangThai = 1";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql, GiaoCa.class).setParameter("ten", "%" + name + "%");
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<GiaoCa> giaoCaCoPhuPhiPhatSinh() {
        List<GiaoCa> list = new ArrayList<>();
        String hql = "From GiaoCa gc WHERE gc.tienPhatSinh > 0";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql, GiaoCa.class);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<GiaoCa> getAllTrangThaiDaNhanCa() {
        List<GiaoCa> list = new ArrayList<>();
        String hql = "From GiaoCa gc WHERE gc.trangThai = 1";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql, GiaoCa.class);
            list = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
}
