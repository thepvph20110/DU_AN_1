/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;


/**
 *
 * @author DANG VAN SY
 */
public class QRCode {

    public ByteArrayOutputStream getQRCodeImage(String text, int width, int height) {
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
            return byteArrayOutputStream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
