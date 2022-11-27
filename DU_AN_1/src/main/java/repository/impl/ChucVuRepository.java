/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Acount;
import domainmodel.ChucVu;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.IChucVuRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class ChucVuRepository implements IChucVuRepository {

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listCV;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM ChucVu");
            listCV = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listCV;
    }

    @Override
    public boolean save(ChucVu chucVu) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.save(chucVu);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ChucVu chucVu) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(chucVu);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "DELETE FROM ChucVu WHERE id = :id";
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
    public String genMaChucVu() {
        String top1 = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM ChucVu cv order by cv.maChucVu DESC";
            Query query = session.createQuery(hql);
            session.getTransaction().begin();
            query.setMaxResults(1);
            ChucVu chucVu = (ChucVu) query.getSingleResult();
            top1 = chucVu.getMaChucVu();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return top1;
        }
        return top1;
    }
}

