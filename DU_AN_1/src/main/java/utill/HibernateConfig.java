package utill;

import domainModel.GiaoCa;
import domainmodel.Acount;
import domainmodel.Ca;
import domainmodel.ChucVu;
import domainmodel.DichVu;
import domainmodel.DoThue;
import domainmodel.HoaDon;
import domainmodel.HoaDonThanhToan;
import domainmodel.KhachHang;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import domainmodel.NuocUong;
import domainmodel.PhieuDatLich;
import domainmodel.PhuPhi;
import domainmodel.PhuPhi_HoaDon;
import domainmodel.SanBong;
import domainmodel.SanCa;
import domainmodel.KichThuoc;
import domainmodel.LoaiSan;
import domainmodel.ThanhToan;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QLSanBongDongDe");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "songlong");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "none");

        conf.setProperties(properties);
        conf.addAnnotatedClass(SanBong.class);
        conf.addAnnotatedClass(Ca.class);
        conf.addAnnotatedClass(LoaiSan.class);
        conf.addAnnotatedClass(SanCa.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(Acount.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(KichThuoc.class);
        conf.addAnnotatedClass(DoThue.class);
        conf.addAnnotatedClass(NuocUong.class);
        conf.addAnnotatedClass(PhieuDatLich.class);
        conf.addAnnotatedClass(DichVu.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(PhuPhi.class);
        conf.addAnnotatedClass(ThanhToan.class);
        conf.addAnnotatedClass(PhuPhi_HoaDon.class);
        conf.addAnnotatedClass(HoaDonThanhToan.class);
        conf.addAnnotatedClass(GiaoCa.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
