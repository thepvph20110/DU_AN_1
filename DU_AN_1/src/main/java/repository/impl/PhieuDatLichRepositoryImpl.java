/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.PhieuDatLich;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IPhieuDatLichRepository;
import utill.HibernateConfig;

/**
 *
 * @author ADMIN
 */
public class PhieuDatLichRepositoryImpl implements IPhieuDatLichRepository{

    @Override
    public List<PhieuDatLich> getAll() {
        String hql = "From PhieuDatLich";
        try(Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(PhieuDatLich phieuDatLich) {
        boolean check;
        Transaction transaction = null;
        try(Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(phieuDatLich);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }
    
    public static void main(String[] args) {
        System.out.println(new PhieuDatLichRepositoryImpl().getAll());
    }
    
}
