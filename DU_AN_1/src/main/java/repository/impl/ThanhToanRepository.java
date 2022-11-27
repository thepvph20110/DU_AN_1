package repository.impl;

import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiThanhToan;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IThanhToanRepository;
import utill.HibernateConfig;

public class ThanhToanRepository implements IThanhToanRepository {

    @Override
    public List<ThanhToan> getAllThanhToans() {
        String hql = "FROM ThanhToan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(ThanhToan thanhToan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(thanhToan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public boolean update(ThanhToan thanhToan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(thanhToan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.commit();
        }
        return check;
    }

    @Override
    public boolean delete(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "DELETE FROM ThanhToan WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ThanhToanRepository tt = new ThanhToanRepository();
        System.out.println(tt.findOneByTrangThai(loaiHinhThanhToan.Tien_Mat).toString());

    }

    @Override
    public ThanhToan findOneByTrangThai(loaiHinhThanhToan loaiHinh) {
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            String hql = "FROM ThanhToan tt WHERE tt.hinhThanhToan =:trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("trangThai", loaiHinh);
            return (ThanhToan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String genMaThanhToan() {
        String top1 = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM ThanhToan tt order by tt.maThanhToan DESC";
            Query query = session.createQuery(hql);
            session.getTransaction().begin();
            query.setMaxResults(1);
            ThanhToan thanhToan = (ThanhToan) query.getSingleResult();
            top1 = thanhToan.getMaThanhToan();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return top1;
        }
        return top1;
    }

    @Override
    public ThanhToan fillBymaThanhToan(String maThanhToan) {
        ThanhToan thanhToan;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM ThanhToan tt WHERE tt.maThanhToan = :maThanhToan";
            Query query = session.createQuery(hql);
            query.setParameter("maThanhToan", maThanhToan);
            thanhToan = (ThanhToan) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return thanhToan;
    }
}
