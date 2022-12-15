/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.SanBong;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import repository.ISanBongRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class SanBongRepository implements ISanBongRepository {

    @Override
    public List<SanBong> getAll() {
        String hql = "From SanBong sb order by sb.tenSanBong";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(SanBong sanBong) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanBong);
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
    public boolean deleteSanBong(SanBong sanBong) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanBong);
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
    public List<SanBong> searchByName(String ten) {
        List<SanBong> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From SanBong Where tenSanBong like :ten ";
            TypedQuery<SanBong> query = session.createQuery(hql, SanBong.class);
            query.setParameter("ten", "%" + ten + "%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

<<<<<<< HEAD
=======
    @Override
    public String saveSanBong(SanBong sanBong) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanBong);
            transaction.commit();
            return "Thêm thành công";
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return "Thêm thất bại";
        }
    }

    @Override
    public SanBong getOne(String id) {
        String hql = "From SanBong sb WHERE sb.id = :IDSan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return (SanBong) session.createQuery(hql).setParameter("IDSan", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        if (new SanBongRepository().deleteSanBong(new SanBongRepository().getOne("284cba49-82c5-465b-beda-2e059694b62d")) == true) {
            JOptionPane.showMessageDialog(null, "oke");
        }
        System.out.println(new SanBongRepository().getOne("284cba49-82c5-465b-beda-2e059694b62d"));
    }

    @Override
    public String xoaSaṇ̣̣̣̣(String id) {
        String hql = "DELETE FROM SanBong sb Where sb.id = :ID";
        Transaction transaction = null;
        try ( Session sesion = new HibernateConfig().getFACTORY().openSession()) {
            transaction = sesion.beginTransaction();
            Query q = sesion.createQuery(hql).setParameter("ID", id);
            q.executeUpdate();
            transaction.commit();
            return "Xóa thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Xóa thất bại";
        }
    }

    @Override
    public int genMaSanBong() {
        String maAC = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maSanBong,5,100))) from SanBong ";
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
