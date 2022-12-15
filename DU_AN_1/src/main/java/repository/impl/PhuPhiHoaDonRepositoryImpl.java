package repository.impl;

import domainmodel.PhuPhi_HoaDon;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IPhuPhiHoaDonRepository;
import utill.HibernateConfig;

public class PhuPhiHoaDonRepositoryImpl implements IPhuPhiHoaDonRepository {

    @Override
    public List<PhuPhi_HoaDon> getAllPhuPhi_HoaDons() {
        String hql = ("FROM PhuPhi_HoaDon");
        List<PhuPhi_HoaDon> lstPhi_HoaDons = new ArrayList<>();
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            lstPhi_HoaDons = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstPhi_HoaDons;
    }

    @Override
    public boolean save(PhuPhi_HoaDon phuPhi_HoaDon) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(phuPhi_HoaDon);
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
    public boolean delete(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "DELETE FROM PhuPhi_HoaDon WHERE id = :id";
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
        PhuPhiHoaDonRepositoryImpl pp = new PhuPhiHoaDonRepositoryImpl();
        System.out.println(pp.getAllPhuPhi_HoaDonsByIdHoaDon("dfe28a30-66ff-4000-a6cc-32e51a3da6c").size());
    }

    @Override
    public PhuPhi_HoaDon getOne(String idPhuPhi,String idHoaDon) {
        String hql = ("FROM PhuPhi_HoaDon pp WHERE pp.phuPhi.id = :idPP AND pp.hoaDon.id = :idHD");
        PhuPhi_HoaDon phuPhi_HoaDon = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql).setParameter("idPP", idPhuPhi).setParameter("idHD", idHoaDon);
            phuPhi_HoaDon = (PhuPhi_HoaDon) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No Entity Found");
            return null;
        }
        return phuPhi_HoaDon;
    }

    @Override
    public List<PhuPhi_HoaDon> getAllPhuPhi_HoaDonsByIdHoaDon(String idHoaDon) {
        String hql = ("FROM PhuPhi_HoaDon pp WHERE pp.hoaDon.id = :idHD");
        List<PhuPhi_HoaDon> lstPhi_HoaDons = new ArrayList<>();
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("idHD", idHoaDon);
            lstPhi_HoaDons = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstPhi_HoaDons;
    }
}
