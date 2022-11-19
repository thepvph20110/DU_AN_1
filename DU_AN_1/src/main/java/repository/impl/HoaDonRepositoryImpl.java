/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.HoaDon;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.IHoaDonRepository;
import utill.HibernateConfig;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepositoryImpl implements IHoaDonRepository{

    @Override
    public List<HoaDon> getAll() {
         List<HoaDon> listHds;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM HoaDon");
            listHds = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listHds;
    }

    @Override
    public boolean save(HoaDon hoaDon) {
         try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.save(hoaDon);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(HoaDon hoaDon) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(hoaDon);
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
            String hql = "DELETE FROM HoaDon WHERE id = :id";
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
    public static void main(String[] args) {
        HoaDonRepositoryImpl hd = new HoaDonRepositoryImpl();
        List<HoaDon> lst = hd.getAll();
        System.out.println(lst);
    }
}
