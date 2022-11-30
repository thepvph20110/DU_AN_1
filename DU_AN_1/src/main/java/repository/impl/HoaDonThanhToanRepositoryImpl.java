/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.impl;

import domainmodel.HoaDonThanhToan;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IHoaDonThanhToanRepository;
import utill.HibernateConfig;

/**
 *
 * @author ASUS
 */
public class HoaDonThanhToanRepositoryImpl implements IHoaDonThanhToanRepository {

    @Override
    public boolean saveOrUpdate(HoaDonThanhToan hoaDonThanhToan) {
        boolean check = false;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                session.saveOrUpdate(hoaDonThanhToan);
                check = true;
                tran.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } finally {
            return check;
        }

    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                String hql = "Delete HoaDonThanhToan n Where n.id = :id";
                Query query = session.createQuery(hql);
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
        String hql = "Select count(h.id) From HoaDonThanhToan h";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            return count = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    @Override
    public List<HoaDonThanhToan> fillAllHoaDonThanhToan() {
        String hql = "Select h From HoaDonThanhToan h";
        List<HoaDonThanhToan> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDonThanhToan> query = session.createQuery(hql, HoaDonThanhToan.class);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
