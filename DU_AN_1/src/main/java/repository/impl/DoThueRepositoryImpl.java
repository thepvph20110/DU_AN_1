/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DoThue;
import enumclass.trangThaiDoThue;
import java.util.List;
import javax.persistence.TypedQuery;
import modelview.QLDoThue;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import repository.IDoThueRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class DoThueRepositoryImpl implements IDoThueRepository {

    private Session session = new HibernateConfig().getFACTORY().openSession();

    @Override
    public List<DoThue> getAll() {
        String hql = "FROM DoThue";
        Query q = session.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public String AddorUpdate(DoThue doThue) {
        Transaction transaction = null;
        try {
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(doThue);
            transaction.commit();
            return "Bạn đã Thêm Hoặc Sửa thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Bạn đã Thêm Hoặc Sửa thất bại";
        }
    }

    @Override
    public String Delete(DoThue doThue) {
        try {
            session.clear();
            session.beginTransaction();
            session.delete(doThue);
            session.getTransaction().commit();
            return "Xoá thành công";
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return "Xoá thất bại";
        }
    }

    @Override
    public List<DoThue> findByTenDoThue(String ten) {
        List<DoThue> listDoThue = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From DoThue Where tenDoThue like :ten ";
            TypedQuery<DoThue> query = session.createQuery(hql, DoThue.class);
            query.setParameter("ten", "%" + ten + "%");
            listDoThue = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDoThue;
    }

    @Override
    public List<DoThue> findByTrangThai(trangThaiDoThue trangThai) {
        List<DoThue> listDoThue = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From DoThue Where trangThai = :trangThai";
            TypedQuery<DoThue> query = session.createQuery(hql, DoThue.class);
            query.setParameter("trangThai", trangThai);
            listDoThue = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDoThue;
    }

    @Override
    public long totalCount() {
        long count = 0;
        String hql = "Select count(u.id) From DoThue u";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            return count = query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    @Override
    public boolean saveOrUpdate(DoThue doThue) {
        boolean check = false;
        Transaction tran = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            tran = session.getTransaction();
            tran.begin();
            session.saveOrUpdate(doThue);
            check = true;
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.commit();
        }
        return check;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                String hql = "Delete DoThue n Where n.id = :id";
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
    public int genMaDoThue() {
        String maAC = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maDoThue,5,100))) from DoThue ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if (maAC == "") {
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return ma;
        }
        int ma = Integer.valueOf(maAC);
        return ++ma;
    }

}
