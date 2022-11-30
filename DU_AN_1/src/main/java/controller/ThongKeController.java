/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import response.TongSoLuongDoThue;
import response.TongSoLuongNuocUong;
import response.TongTienHoaDonResponse;
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
        double tongTien = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (TongTienHoaDonResponse item : listItem) {
                tongTien += item.getTongTien();
                dataset.addValue(item.getTongTien(), "Tổng Tiền", item.getThang() +"-"+item.getNam());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                "Tổng Tiền Của Năm "+listItem.get(0).getNam()+" : "+tongTien, "Tổng Tiền Từng Tháng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    public void setTongTienByYear(JPanel jpnItem,String year) {
        List<TongTienHoaDonResponse> listItem = thongKeService.getTongTienByYear(year);
        double tongTien = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (TongTienHoaDonResponse item : listItem) {
                tongTien += item.getTongTien();
                dataset.addValue(item.getTongTien(), "Tổng Tiền", item.getThang() +"-"+item.getNam());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê tông tiền theo tháng".toUpperCase(),
                "Tổng Tiền Của Năm "+listItem.get(0).getNam()+" : "+tongTien, "Tổng Tiền Từng Tháng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    public void setDataSoLuongNuocUong(JPanel jpnItem) {
        List<TongSoLuongNuocUong> listItem = thongKeService.getTongNuocUong();
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (listItem != null) {
            for (TongSoLuongNuocUong item : listItem) {
                 dataset.setValue(item.getTen(), item.getSoluongnuocuong());
            }
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Tổng Nước Uống Được Mua Nhiều Nhất", dataset, true, true, true);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    public void setDataSoLuongDoThue(JPanel jpnItem) {
        List<TongSoLuongDoThue> listItem = thongKeService.getTongDoThue();
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (listItem != null) {
            for (TongSoLuongDoThue item : listItem) {
                 dataset.setValue(item.getTenDoThue(), item.getSoluongdothue());
            }
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Tổng Đồ Thuê Được Thuê Nhiều Nhất", dataset, true, true, true);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
}
