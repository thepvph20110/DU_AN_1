/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import repository.IChiTietThongKeRepository;
import utill.HibernateConfig;

/**
 *
 * @author Admin
 */
public class ChiTietThongKeRepositoryImpl implements IChiTietThongKeRepository {

    @Override
    public double tongTien() {
        double tongTien = 0;
        String sql = "Select Sum(hd.tongTien) as tongtien from HoaDon hd where Day(hd.ngayThanhToan) = DAY(GETDATE()) And "
                + "Month(hd.ngayThanhToan) = MONTH(GETDATE()) and year(hd.ngayThanhToan) = year(GETDATE()) Group by hd.ngayThanhToan";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            tongTien = (double) session.createSQLQuery(sql).getSingleResult();
            return tongTien;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tongTien;
    }

    public static void main(String[] args) {
//        System.out.println(new ChiTietThongKeRepositoryImpl().tongTien());
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        System.out.println(strDate);

    }
}
