/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.NhaSanXuat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.INhaSanXuatRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class NhaSanXuatRepositoryImpl implements INhaSanXuatRepository {

    private Session session = new HibernateConfig().getFACTORY().openSession();

    @Override
    public List<NhaSanXuat> getAll() {
        String hql = "FROM NhaSanXuat";
        Query q = session.createQuery("hql");
        return q.getResultList();
    }

    @Override
    public String AddorUpdate(NhaSanXuat nhaSanXuat) {
        Transaction transaction = null;
        try {
            session.clear();
            transaction = session.beginTransaction();
            session.saveOrUpdate(nhaSanXuat);
            transaction.commit();
            return "Bạn đã Thêm Hoặc Sửa thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Bạn đã Thêm Hoặc Sửa thất bại";
        }
    }

    @Override
    public String Delete(NhaSanXuat nhaSanXuat) {
        try {
            session.clear();
            session.beginTransaction();
            session.delete(nhaSanXuat);
            session.getTransaction().commit();
            return "Xoá thành công";
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return "Xoá thất bại";
        }
    }

    @Override
    public NhaSanXuat getOne(String ma) {
        String hql = " FROM NhaSanXuat nsx WHERE nsx.Ma = :MaNSX ";
            return session.createQuery(hql, NhaSanXuat.class).setParameter("MaNSX", ma).uniqueResult();
    }
}
