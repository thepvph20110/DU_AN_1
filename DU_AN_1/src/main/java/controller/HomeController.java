/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelview.QLAcount;
import views.Home;
import views.JpnCheckIn;
import views.JpnDichVu;
import views.JpnHoaDon;
import views.JpnLichDat;
import views.JpnLichSu;
import views.JpnQuanLyCa;
import views.JpnQuanLySan;
import views.JpnThongKe;
import views.JpnTrangChu;

/**
 *
 * @author ASUS
 */
public class HomeController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMuc> listDanhMuc;
    private QLAcount qLAcount;
    private JLabel labelHome;

    public HomeController(JPanel JPnRoot, QLAcount qLAcount) {
        this.root = JPnRoot;
        this.qLAcount = qLAcount;
    }

    public HomeController() {
    }

    public void setView(JLabel jblItem) {
        labelHome = jblItem;
        // mặc định cái được chọn là trang chu jpanel 
        kindSelected = "TrangChu";
        JpnTrangChu nood = new JpnTrangChu(qLAcount, jblItem, root);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(nood);
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> listItem) {
        this.listDanhMuc = listItem;
        for (DanhMuc iteam : listItem) {
            iteam.getjLbTenMenu().addMouseListener(new LabelEvent(iteam.getTenTrang(), iteam.getjLbTenMenu()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JLabel jlbItem;

        public LabelEvent(String kind, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new JpnTrangChu(qLAcount, labelHome, root);
                    break;
                case "LichDat":
                    node = new JpnLichDat();
                    break;
                case "CheckIn":
                    node = new JpnCheckIn(qLAcount,root,labelHome);
                    break;
                case "QLSan":
                    node = new JpnQuanLySan();
                    break;
                case "QLCa":
                    node = new JpnQuanLyCa();
                    break;
                case "DichVu":
                    node = new JpnDichVu(qLAcount);
                    break;
                case "HoaDon":
                    node = new JpnHoaDon();
                    break;
                case "LichSu":
                    node = new JpnLichSu();
                    break;
                case "ThongKe":
                    node = new JpnThongKe();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jlbItem.setBackground(new Color(100, 149, 237));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            kindSelected = kind;
            jlbItem.setBackground(new Color(100, 149, 237));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (kindSelected.equalsIgnoreCase(kind)) {
                jlbItem.setBackground(new Color(166, 145, 92));
            }
        }
    }
}
