/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import response.ChiTietThanhToan.ChiTietDichVuRespone;
import response.ChiTietThanhToan.ChiTietDoThueResponse;
import service.IChiTietThongKeService;
import service.Impl.ChiTietThongKeServiceImpl;

/**
 *
 * @author Admin
 */
public class ChiTietThongKeController {

    private IChiTietThongKeService chiTietThongKeService = new ChiTietThongKeServiceImpl();

    public void thongKeNuocUong(JPanel jpnItem) {
        List<ChiTietDichVuRespone> listItem = chiTietThongKeService.thongKeNuocUong();
        if (listItem.size() > 0 || listItem != null) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChiTietDichVuRespone chiTietDichVuRespone : listItem) {
                tongTien += chiTietDichVuRespone.getTongTien().doubleValue();
                dataset.addValue(chiTietDichVuRespone.getSoluong(), "Tổng Tiền : " + chiTietDichVuRespone.getTongTien(), chiTietDichVuRespone.getTen());
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Nước Uống Được Mua Theo Ngày".toUpperCase(),
                    "Tổng Tiền : " + tongTien, "Số Lượng Loại Nước Uống Được Mua",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Nước Uống Được Mua Theo Ngày".toUpperCase(),
                    "Không Có Dữ Liệu", "Số Lượng Loại Nước Uống Được Mua",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    public void thongKeDoThue(JPanel jpnItem) {
        List<ChiTietDoThueResponse> listItem = chiTietThongKeService.thongKeDoThue();
        if (listItem.size() > 0 || listItem != null) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChiTietDoThueResponse chiTietDichVuRespone : listItem) {
                tongTien += chiTietDichVuRespone.getTongTien();
                dataset.addValue(chiTietDichVuRespone.getSoluong(), "Tổng Tiền : " + chiTietDichVuRespone.getTongTien(), chiTietDichVuRespone.getTenDoThue());
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Đồ Thuê Được Thuê Theo Ngày".toUpperCase(),
                    "Tổng Tiền : " + tongTien, "Số Lượng Đồ Được Thuê",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Đồ Thuê Được Thuê Theo Ngày".toUpperCase(),
                    "Không Có Dữ Liệu", "Số Lượng Đồ Được Thuê",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    //By date
    public void thongKeNuocUongByDate(JPanel jpnItem,Date date) {
        List<ChiTietDichVuRespone> listItem = chiTietThongKeService.thongKeNuocUongByDate(date);
        if (listItem.size() > 0 || listItem != null) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChiTietDichVuRespone chiTietDichVuRespone : listItem) {
                tongTien += chiTietDichVuRespone.getTongTien().doubleValue();
                dataset.addValue(chiTietDichVuRespone.getSoluong(), "Tổng Tiền : " + chiTietDichVuRespone.getTongTien(), chiTietDichVuRespone.getTen());
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Nước Uống Được Mua Theo Ngày".toUpperCase(),
                    "Tổng Tiền : " + tongTien, "Số Lượng Loại Nước Uống Được Mua",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Nước Uống Được Mua Theo Ngày".toUpperCase(),
                    "Không Có Dữ Liệu", "Số Lượng Loại Nước Uống Được Mua",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

    public void thongKeDoThueByDate(JPanel jpnItem,Date date) {
        List<ChiTietDoThueResponse> listItem = chiTietThongKeService.thongKeDoThueByDate(date);
        if (listItem.size() > 0 || listItem != null) {
            double tongTien = 0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (ChiTietDoThueResponse chiTietDichVuRespone : listItem) {
                tongTien += chiTietDichVuRespone.getTongTien();
                dataset.addValue(chiTietDichVuRespone.getSoluong(), "Tổng Tiền : " + chiTietDichVuRespone.getTongTien(), chiTietDichVuRespone.getTenDoThue());
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Đồ Thuê Được Thuê Theo Ngày".toUpperCase(),
                    "Tổng Tiền : " + tongTien, "Số Lượng Đồ Được Thuê",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } else {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu Đồ Thống Kê Số Lượng Đồ Thuê Được Thuê Theo Ngày".toUpperCase(),
                    "Không Có Dữ Liệu", "Số Lượng Đồ Được Thuê",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), jpnItem.getHeight()));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
}
