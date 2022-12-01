/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainModel.GiaoCa;
import modelview.QLGiaoCa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IGiaoCaRepository;
import utill.HibernateConfig;

/**
 *
 * @author DANG VAN SY
 */
public class GiaoCaRepository implements IGiaoCaRepository {

    @Override
    public GiaoCa getOne(String ma) {
        String hql = "From GiaoCa gc WHERE gc.ma = :MaGC";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            return session.createQuery(hql, GiaoCa.class).setParameter("MaGC", ma).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new GiaoCaRepository().getOne("GC001"));
    }

    @Override
    public String saveOrUpdate(GiaoCa giaoCa) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(giaoCa);
            transaction.commit();
            return "Giao ca thành công";
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return "Giao ca thất bại";
        }
    }

}
