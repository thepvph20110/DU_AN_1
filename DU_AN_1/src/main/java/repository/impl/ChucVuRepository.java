/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.ChucVu;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
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
    public boolean delete(String id) {
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
    public int genMaChucVu() {
        String maCV = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maCV,5,100))) from CHucVu ";
            NativeQuery query = session.createNativeQuery(hql);
            maCV = query.getSingleResult().toString();
        } catch (Exception e) {
       
        }
        if(maCV == ""){
            maCV = "1";
            int ma = Integer.valueOf(maCV);
            return  ma;
        }
        int ma = Integer.valueOf(maCV);
        return  ++ma;
    }
<<<<<<< HEAD

   
}
=======
>>>>>>> c5c370ffe9329ee44f3bb07c8fe6fec2fcb3fca2

}
