/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Acount;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import repository.IAcountRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class AcountRepository implements IAcountRepository {

    @Override
    public List<Acount> getAll() {
        List<Acount> listAcount;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM Acount");
            listAcount = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listAcount;
    }

    @Override
    public boolean save(Acount acount) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.save(acount);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Acount acount) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(acount);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "DELETE FROM Acount WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Acount getOne() {
        Acount acount;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From Acount ";
            TypedQuery<Acount> query = session.createQuery(hql, Acount.class);
            query.setFirstResult(0);
            query.setMaxResults(1);
            acount = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            acount = null;
        }
        return acount;
    }

    public static void main(String[] args) {
        new AcountRepository().getOne();
        System.out.println( new AcountRepository().genMaAccount());
    }

    @Override
    public String genMaAccount() {
        String top1 = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM Acount a order by a.maAcount Desc";
            Query query = session.createQuery(hql);
            session.getTransaction().begin();
            query.setMaxResults(1);
            Acount acount = (Acount) query.getSingleResult();
            top1 = acount.getMaAcount();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return top1;
        }
        return top1;
    }

    @Override
    public Acount getByUseNameAndPass(String tenAccount, String matKhau) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From Acount ac Where  ac.tenAcount = :use and ac.matKhau = :pass";
            return session.createQuery(hql, Acount.class).setParameter("use", tenAccount).setParameter("pass", matKhau).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
