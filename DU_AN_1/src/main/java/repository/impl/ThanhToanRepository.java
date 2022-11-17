package repository.impl;

import domainmodel.ThanhToan;
import enumclass.loaiHinhThanhToan;
import enumclass.trangThaiThanhToan;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IThanhToanRepository;
import utill.HibernateConfig;

public class ThanhToanRepository implements IThanhToanRepository {

    @Override
    public List<ThanhToan> getAllThanhToans() {
        String hql = "FROM ThanhToan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(ThanhToan thanhToan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(thanhToan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public boolean update(ThanhToan thanhToan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(thanhToan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.commit();
        }
        return check;
    }

    @Override
    public boolean delete(ThanhToan thanhToan) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(thanhToan);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.commit();
        }
        return check;
    }

    public static void main(String[] args) {
        ThanhToanRepository tt = new ThanhToanRepository();
//        List<ThanhToan> lst = tt.getAllThanhToans();
//        System.out.println(lst);
//        UUID uu = UUID.fromString("0xC9EBF059A96943FFBF63F61FE89905E00000000000000000000000000000000000000000");
//        ThanhToan tsv = new ThanhToan(null, "TT5", loaiHinhThanhToan.Chuyen_Khoan, "ok", trangThaiThanhToan.Da_Thanh_Toan);
//        tt.save();
    }
}
