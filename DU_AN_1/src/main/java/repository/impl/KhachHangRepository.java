/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.KhachHang;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import repository.IKhachHangRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class KhachHangRepository implements IKhachHangRepository {

    @Override
    public List<KhachHang> getAll() {
        String hql = "From KhachHang";
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(KhachHang khachHang) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(khachHang);
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
    public boolean save(KhachHang khachHang) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
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
    public boolean delete(KhachHang khachHang) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
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
    public List<KhachHang> searchByName(String ten) {
        List<KhachHang> listKh = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From KhachHang Where tenKhachHang like :ten ";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("ten", "%" + ten + "%");
            listKh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listKh;
    }

    @Override
    public int genMaKH() {
        String maAC = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maKhachHang,5,100))) from KhachHang ";
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

}
