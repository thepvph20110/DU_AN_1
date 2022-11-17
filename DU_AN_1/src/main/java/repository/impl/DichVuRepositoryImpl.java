/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DichVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IDichVuRepository;
import utill.HibernateConfig;

/**
 *
 * @author ASUS
 */
public class DichVuRepositoryImpl implements IDichVuRepository {

    @Override
    public List<DichVu> fillAll(int position, int pageSize) {
        String hql = "Select d From DichVu d";
        List<DichVu> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<DichVu> query = session.createQuery(hql, DichVu.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(DichVu dichVu) {
        boolean check = false;
        Transaction tran = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            tran = session.getTransaction();
            tran.begin();
            session.saveOrUpdate(dichVu);
            check = true;
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.commit();
        }
        return check;
    }

    @Override
    public boolean delete(UUID id) {
        int check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                String hql = "Delete DichVu n Where n.id = :id";
                org.hibernate.query.Query query = session.createQuery(hql);
                query.setParameter("id", id);
                check = query.executeUpdate();
                tran.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return check > 0;
    }

    @Override
    public long totalCount() {
        long count = 0;
        String hql = "Select count(d.id) From DichVu d";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            count = query.getSingleResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    public static void main(String[] args) {
        DichVuRepositoryImpl dv = new DichVuRepositoryImpl();

        System.out.println(dv.fillAll(0, 0).size());
    }

    @Override
    public List<DichVu> fillAllDichVu() {
        String hql = "From DichVu";
        List<DichVu> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<DichVu> query = session.createQuery(hql, DichVu.class);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
