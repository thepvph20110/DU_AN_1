/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.LoaiSan;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import repository.ILoaiSanRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class LoaiSanRepository implements ILoaiSanRepository {

    @Override
    public List<LoaiSan> getAll() {
        String hql = "From LoaiSan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(LoaiSan loaiSan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(loaiSan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public boolean deleteLoaiSan(LoaiSan loaiSan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(loaiSan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public List<LoaiSan> searchByName(String ten) {
        List<LoaiSan> listNuocUong = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From LoaiSan Where tenLoaiSan like :ten ";
            TypedQuery<LoaiSan> query = session.createQuery(hql, LoaiSan.class);
            query.setParameter("ten", "%" + ten + "%");
            listNuocUong = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNuocUong;
    }

<<<<<<< HEAD
=======
    @Override
    public LoaiSan getOne(String tenLoai) {
        String hql = "From LoaiSan ls WHERE ls.tenLoaiSan = :ten";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (LoaiSan) session.createQuery(hql).setParameter("ten", tenLoai).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public int genMaLoaiSan() {
        String maAC = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maLoaiSan,5,100))) from LoaiSan ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
       
        }
        if(maAC == ""){
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return  ma;
        }
        int ma = Integer.valueOf(maAC);
        return  ++ma;
    }
>>>>>>> 0a5f77edf23f153047e199a5ac27bd4547d84bb5
}
