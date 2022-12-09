/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.MauSac;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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

    public static void main(String[] args) {
        System.out.println(new MauSacRepositoryImpl().getOne("MS01"));
    }

    @Override
    public MauSac getOne(String ma) {
        String hql = " FROM MauSac ms WHERE ms.maMauSac = :MaMS ";
        return session.createQuery(hql, MauSac.class).setParameter("MaMS", ma).uniqueResult();
    }

    @Override
    public int genMaMauSac() {
                String maAC = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from MauSac ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if(maAC == ""){
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return  ma;
        }
        int ma = Integer.valueOf(maAC);
        return  ++ma;
    }

}
