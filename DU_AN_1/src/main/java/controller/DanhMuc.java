/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JLabel;

public class DanhMuc {

    private String tenTrang;
    private JLabel jLbTenMenu;

    public DanhMuc() {
    }

    public DanhMuc(String tenTrang, JLabel jLbTenMenu) {
        this.tenTrang = tenTrang;
        this.jLbTenMenu = jLbTenMenu;
    }

    public String getTenTrang() {
        return tenTrang;
    }

    public void setTenTrang(String tenTrang) {
        this.tenTrang = tenTrang;
    }

    public JLabel getjLbTenMenu() {
        return jLbTenMenu;
    }

    public void setjLbTenMenu(JLabel jLbTenMenu) {
        this.jLbTenMenu = jLbTenMenu;
    }
}
