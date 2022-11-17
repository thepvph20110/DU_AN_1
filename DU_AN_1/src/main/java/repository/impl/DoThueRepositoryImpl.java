/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DoThue;
import java.util.List;
import modelview.QLDoThue;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

}
