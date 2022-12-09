/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.SanCa;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ISanCaRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class SanCaRepository implements ISanCaRepository {

    @Override
    public List<SanCa> getAll() {
        String hql = "From SanCa sc order by sc.ca.tenCa";
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean update(SanCa sanCa) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanCa);
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
    public boolean deleteSanCa(SanCa sanCa) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanCa);
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
    public SanCa getOne() {
        SanCa sanCa;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From SanCa";
            TypedQuery<SanCa> query = session.createQuery(hql, SanCa.class);
            query.setFirstResult(0);
            query.setMaxResults(1);
            sanCa = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            sanCa = null;
        }
        return sanCa;
    }

    @Override
    public boolean save(SanCa sanCa) {
        boolean check;
        Transaction transaction = null;
        try (Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanCa);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }
<<<<<<< HEAD
=======
    
    @Override
    public boolean saveOutSanCa(SanCa sanCa) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
  
                session.save(sanCa);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    public List<SanCa> getByNgayTao(Date ngayTao) {
        String hql = "From SanCa sc Where sc.ngayTao = :ngayTaoSan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql).setParameter("ngayTaoSan", ngayTao);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanCa> getSanCaByIdSanBong(String id,Date ngayTaoSanCa) {
        String hql = "From SanCa sc WHERE sc.sanbong.id = :idSanBong and sc.ngayTao = :ngayTao";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql).setParameter("idSanBong", id).setParameter("ngayTao", ngayTaoSanCa);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2
}
