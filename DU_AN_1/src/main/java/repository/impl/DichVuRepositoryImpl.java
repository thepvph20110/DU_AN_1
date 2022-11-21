/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.DichVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IDichVuRepository;
import utill.HibernateConfig;

/**
 *
 * @author ASUS
 */
public class DichVuRepositoryImpl implements IDichVuRepository {

    @Override
    public List<DichVu> fillAll(int position, int pageSize) {
        String hql = "Select d From DichVu d";
        List<DichVu> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<DichVu> query = session.createQuery(hql, DichVu.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(DichVu dichVu) {
        boolean check = false;
        Transaction tran = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            tran = session.getTransaction();
            tran.begin();
            session.saveOrUpdate(dichVu);
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
                String hql = "Delete DichVu n Where n.id = :id";
                org.hibernate.query.Query query = session.createQuery(hql);
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
        String hql = "Select count(d.id) From DichVu d";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            count = query.getSingleResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    public static void main(String[] args) {
        DichVuRepositoryImpl dv = new DichVuRepositoryImpl();
        System.out.println(dv.findByIdHoaDon(UUID.fromString("77cced0f-7124-4a5e-9a9b-19b8eff7a25d")).size());
    }

    @Override
    public List<DichVu> fillAllDichVu() {
        String hql = "From DichVu";
        List<DichVu> lists = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<DichVu> query = session.createQuery(hql, DichVu.class);
            lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<DichVu> findByIdHoaDon(UUID uuid) {
        List<DichVu> listDV;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM DichVu dv WHERE dv.hoaDon.id =:id");
            q.setParameter("id", uuid);
            listDV = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listDV;
    }

    @Override
    public List<DichVu> findByIdHoaDonAndNuocUong(UUID idHoaDon, UUID idNuocUong) {
        List<DichVu> listDV = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM DichVu dv WHERE dv.hoaDon.id =:hoaDonId AND dv.nuocUong.id =:idNuocUong");
            q.setParameter("hoaDonId", idHoaDon);
            q.setParameter("idNuocUong", idNuocUong);
            listDV = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listDV;
    }

    @Override
    public List<DichVu> findByIdHoaDonAndDoThue(UUID idHoaDon, UUID idDoThue) {
        List<DichVu> listDV = new ArrayList<>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM DichVu dv WHERE dv.hoaDon.id =:hoaDonId AND dv.doThue.id =:idDoThue");
            q.setParameter("hoaDonId", idHoaDon);
            q.setParameter("idDoThue", idDoThue);
            listDV = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listDV;
    }
}
