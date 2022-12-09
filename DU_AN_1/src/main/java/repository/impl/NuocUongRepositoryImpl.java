/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.NuocUong;
import enumclass.trangThaiNuocUong;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import modelview.QLNuocUong;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.INuocUongRepository;
import utill.HibernateConfig;

/**
 *
 * @author ASUS
 */
public class NuocUongRepositoryImpl implements INuocUongRepository {

    @Override
    public boolean saveOrUpdate(NuocUong nuocUong) {
        boolean check = false;
        Transaction tran = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            tran = session.getTransaction();
            tran.begin();
            session.saveOrUpdate(nuocUong);
            check = true;
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            tran.commit();
        }
        return check;
    }

    @Override
    public boolean delete(UUID id) {
        int check = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                String hql = "Delete NuocUong Where id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                check = query.executeUpdate();
                tran.commit();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return check > 0;
    }

    @Override
    public long totalCount() {
        long count = 0;
        String hql = "Select count(u.id) From NuocUong u";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            return count = query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    @Override
    public List<NuocUong> fillAllNuocUong() {
        String hql = " From NuocUong ";
        List<NuocUong> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<NuocUong> query = session.createQuery(hql, NuocUong.class);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String fillByName(String ten) {
        String id = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = " Select u.id From NuocUong u Where u.tenNuocUong = :ten ";
            TypedQuery<String> query = session.createQuery(hql, String.class);
            query.setParameter("ten", ten);
            id = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public static void main(String[] args) {
        String id = new NuocUongRepositoryImpl().fillByName("Bia heineken");
        System.out.println("" + id);

        List<NuocUong> list = new NuocUongRepositoryImpl().findByTrangThai(trangThaiNuocUong.Con_Hang);
        System.out.println("" + list.toString());
    }

    @Override
    public NuocUong findByID(String id) {
        String hql = " From NuocUong nc WHERE nc.id =:id ";
        NuocUong nuocUong = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<NuocUong> query = session.createQuery(hql, NuocUong.class);
            query.setParameter("id", id);
            nuocUong = query.getSingleResult();
            return nuocUong;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nuocUong;
    }

    @Override
    public List<NuocUong> findByTenNuocUong(String ten) {
        List<NuocUong> listNuocUong = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From NuocUong Where tenNuocUong like :ten ";
            TypedQuery<NuocUong> query = session.createQuery(hql, NuocUong.class);
            query.setParameter("ten", "%" + ten + "%");
            listNuocUong = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNuocUong;
    }

    @Override
    public List<NuocUong> findByTrangThai(trangThaiNuocUong trangThai) {
        List<NuocUong> listNuocUong = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From NuocUong Where trangThai = :trangThai";
            TypedQuery<NuocUong> query = session.createQuery(hql, NuocUong.class);
            query.setParameter("trangThai", trangThai);
            listNuocUong = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNuocUong;
    }

}
