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
    public boolean delete(PhuPhi_HoaDon phuPhi_HoaDon) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(phuPhi_HoaDon);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }
    public static void main(String[] args) {
        PhuPhiHoaDonRepositoryImpl pp = new PhuPhiHoaDonRepositoryImpl();
        List<PhuPhi_HoaDon> psd = pp.getAllPhuPhi_HoaDons();
        System.out.println(psd);
    }
}
