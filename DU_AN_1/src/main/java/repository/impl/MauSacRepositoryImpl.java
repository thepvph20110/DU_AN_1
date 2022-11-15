/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.MauSac;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IMauSacRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class MauSacRepositoryImpl implements IMauSacRepository {

    private Session session = new HibernateConfig().getFACTORY().openSession();

    @Override
    public List<MauSac> getAll() {
        String hql = "FROM MauSac";
        Query q = session.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public String AddorUpdate(MauSac mauSac) {
        Transaction transaction = null;
        try {
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return "Bạn đã Thêm Hoặc Sửa thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Bạn đã Thêm Hoặc Sửa thất bại";
        }
    }
    public static void main(String[] args) {
        MauSac ms = new MauSac(null, "MS01", "Mau Den");
        System.out.println(new MauSacRepositoryImpl().AddorUpdate(ms));
    }

    @Override
    public String Delete(MauSac mauSac) {
        try {
            session.clear();
            session.beginTransaction();
            session.delete(mauSac);
            session.getTransaction().commit();
            return "Xoá thành công";
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return "Xoá thất bại";
        }
    }

    @Override
    public MauSac getOne(String ma) {
        String hql = " FROM MauSac ms WHERE ms.Ma = :MaMauSac ";
            return session.createQuery(hql, MauSac.class).setParameter("MaMauSac", ma).uniqueResult();
    }
}
