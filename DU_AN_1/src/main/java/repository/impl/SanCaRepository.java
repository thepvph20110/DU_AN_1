/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.SanCa;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
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
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
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
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
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
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
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

    public boolean saveOutSanCa(List<SanCa> listSanCa) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            for (SanCa sanCa : listSanCa) {
                session.save(sanCa);
            }

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

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngayTao = dateFormat.parse("2022-12-04");
//            String d = dateFormat.format(ngayTao);
//            System.out.println(dateFormat.format(ngayTao));
//            String a = String.valueOf(dateFormat.format(ngayTao));
//            System.out.println(a);
            System.out.println(new SanCaRepository().getByNgayTao(ngayTao));
        } catch (ParseException ex) {
            Logger.getLogger(SanCaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
