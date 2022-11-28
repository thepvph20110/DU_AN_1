/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Acount;
import domainmodel.ChucVu;
import domainmodel.KhachHang;
import domainmodel.PhieuDatLich;
import enumclass.trangThaiAcount;
import enumclass.trangThaiChucVu;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiPhieuDL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public List<PhieuDatLich> getAll() {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich");
            listPhieus = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }

    @Override
    public boolean save(PhieuDatLich phieuDatLich) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.save(phieuDatLich);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(PhieuDatLich phieuDatLich) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(phieuDatLich);
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
            String hql = "DELETE FROM PhieuDatLich WHERE id = :id";
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
    public List<PhieuDatLich> getPhieuDatLichByTT() {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich where trangThai ='0'");
            listPhieus = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }
    
}