/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import response.ThanhToan.TongSoLuongDoThue;
import response.ThanhToan.TongSoLuongNuocUong;
import response.ThanhToan.TongTienHoaDonResponse;
import service.IThongKeService;
import service.Impl.ThongKeServiceImpl;

/**
 *
 * @author Admin
 */
public class ThongKeController {

    private IThongKeService thongKeService = new ThongKeServiceImpl();

    public void setDataToChart1(JPanel jpnItem) {
        List<TongTienHoaDonResponse> listItem = thongKeService.getTongTien();
        if (listItem.size() > 0) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            if (listItem != null) {
                for (TongTienHoaDonResponse item : listItem) {
                    tongTien += item.getTongTien();
                    dataset.addValue(item.getTongTien(), "Tổng Tiền", item.getThang() + "-" + item.getNam());
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                    "Tổng Tiền Của Năm " + listItem.get(0).getNam() + " : " + dinhDangTienTe(tongTien), "Tổng Tiền Từng Tháng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 600));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                    "Không Có Dữ Liệu", "Tổng Tiền Từng Tháng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 600));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    public String dinhDangTienTe(double tienTe) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(tienTe) + " " + "Vnd";
    }

    public void setTongTienByYear(JPanel jpnItem, String year) {
        List<TongTienHoaDonResponse> listItem = thongKeService.getTongTienByYear(year);
        if (listItem.size() > 0) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            if (listItem != null) {
                for (TongTienHoaDonResponse item : listItem) {
                    tongTien += item.getTongTien();
                    dataset.addValue(item.getTongTien(), "Tổng Tiền", item.getThang() + "-" + item.getNam());
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                    "Tổng Tiền Của Năm " + listItem.get(0).getNam() + " : " + dinhDangTienTe(tongTien), "Tổng Tiền Từng Tháng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 600));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                    " Không Có Dữ Liệu", "Tổng Tiền Từng Tháng",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 600));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

//    public void setDataSoLuongNuocUong(JPanel jpnItem) {
//        List<TongSoLuongNuocUong> listItem = thongKeService.getTongNuocUong();
//        if (listItem.size() > 0) {
//            DefaultPieDataset dataset = new DefaultPieDataset();
//            if (listItem != null) {
//                for (TongSoLuongNuocUong item : listItem) {
//                    dataset.setValue(item.getTen(), item.getSoluongnuocuong());
//                }
//            }
//
//            JFreeChart pieChart = ChartFactory.createPieChart(
//                    "Tổng Nước Uống Được Mua Nhiều Nhất", dataset, true, true, true);
//
//            ChartPanel chartPanel = new ChartPanel(pieChart);
//            chartPanel.setPreferredSize(new Dimension(50, 50));
//
//            jpnItem.removeAll();
//            jpnItem.setLayout(new CardLayout());
//            jpnItem.add(chartPanel);
//            jpnItem.validate();
//            jpnItem.repaint();
//        } else {
//            DefaultPieDataset dataset = new DefaultPieDataset();
//            JFreeChart pieChart = ChartFactory.createPieChart(
//                    "Không Có Dữ Liệu", dataset, true, true, true);
//
//            ChartPanel chartPanel = new ChartPanel(pieChart);
//            chartPanel.setPreferredSize(new Dimension(50, 50));
//
//            jpnItem.removeAll();
//            jpnItem.setLayout(new CardLayout());
//            jpnItem.add(chartPanel);
//            jpnItem.validate();
//            jpnItem.repaint();
//        }
//    }
//
//    public void setDataSoLuongDoThue(JPanel jpnItem) {
//        List<TongSoLuongDoThue> listItem = thongKeService.getTongDoThue();
//        if (listItem.size() > 0) {
//            DefaultPieDataset dataset = new DefaultPieDataset();
//            if (listItem != null) {
//                for (TongSoLuongDoThue item : listItem) {
//                    dataset.setValue(item.getTenDoThue(), item.getSoluongdothue());
//                }
//            }
//
//            JFreeChart pieChart = ChartFactory.createPieChart(
//                    "Tổng Đồ Thuê Được Thuê Nhiều Nhất", dataset, true, true, true);
//
//            ChartPanel chartPanel = new ChartPanel(pieChart);
//            chartPanel.setPreferredSize(new Dimension(50, 50));
//
//            jpnItem.removeAll();
//            jpnItem.setLayout(new CardLayout());
//            jpnItem.add(chartPanel);
//            jpnItem.validate();
//            jpnItem.repaint();
//        } else {
//            DefaultPieDataset dataset = new DefaultPieDataset();
//            JFreeChart pieChart = ChartFactory.createPieChart(
//                    "Không Có Dữ Liệu", dataset, true, true, true);
//            ChartPanel chartPanel = new ChartPanel(pieChart);
//            chartPanel.setPreferredSize(new Dimension(50, 50));
//
//            jpnItem.removeAll();
//            jpnItem.setLayout(new CardLayout());
//            jpnItem.add(chartPanel);
//            jpnItem.validate();
//            jpnItem.repaint();
//        }
//    }
}
