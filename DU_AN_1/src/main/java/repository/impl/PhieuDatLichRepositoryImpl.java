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
import enumclass.trangThaiHoaDon;
import enumclass.trangThaiKhachHang;
import enumclass.trangThaiPhieuDL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class PhieuDatLichRepositoryImpl implements IPhieuDatLichRepository {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public List<PhieuDatLich> getAll() {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich");
            listPhieus = q.getResultList();
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }

    @Override
    public List<PhieuDatLich> getPhieuDatLichBySDT(String sdt) {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich p where p.khachHang.soDienThoai = :SoDienThoai and trangThai ='0'");
            q.setParameter("SoDienThoai", sdt);
            listPhieus = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }

    @Override
    public PhieuDatLich getByIdSanCa(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            return (PhieuDatLich) session.createQuery("From PhieuDatLich p WHERE p.sanCa.id = :IdSanCa").setParameter("IdSanCa", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuDatLich getPDLByTrangThai(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            return (PhieuDatLich) session.createQuery("From PhieuDatLich p WHERE p.sanCa.trangThai='1' and p.sanCa.id = :IdSanCa").setParameter("IdSanCa", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PhieuDatLich> getPhieuTheoTTHD() {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich pdl WHERE pdl.trangThai = :tt");
            q.setParameter("tt", trangThaiPhieuDL.CHUA_NHAN_SAN);
            listPhieus = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }

    @Override
    public List<PhieuDatLich> getPhieuChuaTT() {
        List<PhieuDatLich> listPhieus;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM PhieuDatLich pdl WHERE pdl.hoaDon.trangThai = :tt");
            q.setParameter("tt", trangThaiHoaDon.CHUA_THANH_TOAN);
            listPhieus = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listPhieus;
    }

    public static void main(String[] args) {
        List<PhieuDatLich> list1 = new PhieuDatLichRepositoryImpl().getPhieuChuaTT();
        List<PhieuDatLich> list12 = new PhieuDatLichRepositoryImpl().getPhieuTheoTTHD();
        list1.addAll(list12);
        Acount acount = new Acount();
        acount.setId("01baa483-4d01-438e-ad14-8780e1b24126");
        for (PhieuDatLich phieuDatLich : list1) {
            phieuDatLich.setAcount(acount);
            new PhieuDatLichRepositoryImpl().update(phieuDatLich);
        }
    }
}
