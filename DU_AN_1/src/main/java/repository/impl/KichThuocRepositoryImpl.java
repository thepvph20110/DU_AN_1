/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.KichThuoc;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IKichThuocRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class KichThuocRepositoryImpl implements IKichThuocRepository {
    
    private Session session = new HibernateConfig().getFACTORY().openSession();
    
    @Override
    public List<KichThuoc> getAll() {
        String hql = "FROM KichThuoc";
        Query q = session.createQuery(hql);
        return q.getResultList();
    }
    
    @Override
    public String AddorUpdate(KichThuoc kichThuoc) {
        Transaction transaction = null;
        try {
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(kichThuoc);
            transaction.commit();
            return "Bạn đã Thêm Hoặc Sửa thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Bạn đã Thêm Hoặc Sửa thất bại";
        }
    }
    public static void main(String[] args) {
        KichThuoc kt = new KichThuoc(null, "SZ01", 35);
        System.out.println(new KichThuocRepositoryImpl().AddorUpdate(kt));
    }
    @Override
    public String Delete(KichThuoc kichThuoc) {
        try {
            session.clear();
            session.beginTransaction();
            session.delete(kichThuoc);
            session.getTransaction().commit();
            return "Xoá thành công";
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return "Xoá thất bại";
        }
    }

    @Override
    public KichThuoc getOne(String ma) {
        String hql = " FROM KichThuoc kt WHERE kt.maSize = :MaKichThuoc ";
            return session.createQuery(hql, KichThuoc.class).setParameter("MaKichThuoc", ma).uniqueResult();
    }
}
