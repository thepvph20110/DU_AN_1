/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.SanCa;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ISanCaRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class SanCaRepository implements ISanCaRepository{

    @Override
    public List<SanCa> getAll() {
        String hql = "From SanCa";
        try(Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(SanCa sanCa) {
        boolean check;
        Transaction transaction = null;
        try(Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.saveOrUpdate(sanCa);
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
        try(Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction =session.beginTransaction();
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
    
}
