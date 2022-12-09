/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

/**
 *
 * @author DANG VAN SY
 */
public class MaRanDom {

    public String genMa(String tenMa) {
        int gen = (int) Math.floor(Math.random() * 999999999 + 100000000);
        return tenMa + gen;
    }

    public static void main(String[] args) {
        System.out.println(new MaRanDom().genMa("sy"));
    }
}
