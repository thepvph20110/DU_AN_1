package repository.impl;

import domainModel.LichSuDatLich;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateConfig;
import repository.ILichSuDatLichRepository;

public class LichSuDatLichRepositoryImpl implements ILichSuDatLichRepository {

    @Override
    public List<LichSuDatLich> getAllLichSuDatLichs() {
        String hql = "FROM LichSuDatLich";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(LichSuDatLich lichSuDatLich) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(lichSuDatLich);
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
            String hql = "DELETE FROM LichSuDatLich WHERE id = :id";
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

    @Override
    public List<LichSuDatLich> getLichSuDatBySoDienThoai(String soDienThoai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LichSuDatLich> getLichSuDatByMaLichSu(String maLichSu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        LichSuDatLichRepositoryImpl lichRepositoryImpl = new LichSuDatLichRepositoryImpl();
        List<LichSuDatLich> lst = lichRepositoryImpl.getAllLichSuDatLichs();
        System.out.println(lst);
    }
}
