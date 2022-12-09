/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.HoaDon;
import enumclass.trangThaiHoaDon;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
        Transaction transaction = null;
         try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(hoaDon);
           transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
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
    public boolean delete(String id) {
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
        List<HoaDon> lst = hd.searchByTen("S");
        System.out.println(lst.size());
    }

    @Override
    public List<HoaDon> getAllByTrangThai() {
        List<HoaDon> listHds;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM HoaDon hd WHERE hd.trangThai =:status");
            q.setParameter("status", trangThaiHoaDon.CHUA_THANH_TOAN);
            listHds = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listHds;
    }

    @Override
    public List<HoaDon> searchByTen(String name) {
        List<HoaDon> listHds;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM HoaDon hd WHERE hd.phieuDatLich.khachHang.tenKhachHang like :ten");
            q.setParameter("ten", "%"+name+"%");
            listHds = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listHds;
    }

    @Override
    public HoaDon findByHoaDonId(String id) {
        HoaDon hoaDon;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM HoaDon hd WHERE hd.id =:id");
            q.setParameter("id", id);
            hoaDon = (HoaDon) q.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return hoaDon;
    }

    @Override
    public int genMaHoaDon() {
        String maHD = "";
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(maHoaDon,5,100))) from HoaDon ";
            NativeQuery query = session.createNativeQuery(hql);
            maHD = query.getSingleResult().toString();
        } catch (Exception e) {
       
        }
        if(maHD == ""){
            maHD = "1";
            int ma = Integer.valueOf(maHD);
            return  ma;
        }
        int ma = Integer.valueOf(maHD);
        return  ++ma;
    }

   
    
}
