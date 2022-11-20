/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

import domainmodel.PhieuDatLich;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ADMIN
 */
public class JavaMail {

    public String sendMail(PhieuDatLich phieuDatLich, ByteArrayOutputStream byteArrayOuputStream) {
        final String from = "hshsggdh235@gmail.com";
        final String password = "tvrmnzhlbihpdvpk";
        final String to = phieuDatLich.getKhachHang().getMail();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // phiên làm việc
        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject("Lịch Đặt Sân Bóng Đồng Đế", "UTF-8");
            msg.setSentDate(new Date());

//            msg.setText("Thử nghiệm gửi ảnh", "UTF-8");
            //
            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();

            String html = "<!DOCTYPE html>"
                    + "<html lang=\"en\">"
                    + "<head>"
                    + " <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <title>Document</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<div style=\"width: 400px;\n"
                    + "    height: 550px;\n"
                    + "    border: black;\n"
                    + "    border-width:2px;\n"
                    + "    border-style:solid;\n"
                    + "    background: powderblue;\n"
                    + "    border-radius: 4px;\n"
                    + "    margin-left: 20px;\n"
                    + "    padding-left: 10px;"
                    + "box-shadow: 10px 10px 5px ainsboro;\">"
                    + "<h1 style=\"margin-left: 90px;\">Phiếu Nhận Sân</h1>"
                    + "<div style=\"margin-left: 5px;padding-top: 20px;background: white;\n"
                    + "             width: 90%; border-radius: 4px;height: 30%;padding-left: 20px;\">\n"
                    + "        <label style=\"color: blue;font-size: 17px;font-weight: bold;\">Người Đặt: </label> <span>" + phieuDatLich.getKhachHang().getTenKhachHang() + "</span>\n"
                    + "        <br>\n"
                    + "        <br>\n"
                    + "        <label style=\"color: blue;font-size: 17px;font-weight: bold;\">Tên sân bóng: </label><span>" + phieuDatLich.getSanCa().getSanbong().getTenSanBong() + "</span>\n"
                    + "        <br>\n"
                    + "        <br>\n"
                    + "        <label style=\"color: blue;font-size: 17px;font-weight: bold;\">Ngày nhận sân: </label><span>" + phieuDatLich.getNgayDenSan() + "</span>\n"
                    + "        <br>\n"
                    + "        <br>\n"
                    + "        <label style=\"color: blue;font-size: 17px;font-weight: bold;\">Thời gian: </label><span>" + phieuDatLich.getSanCa().getCa().getThoiGianBatDau() + " - " + phieuDatLich.getSanCa().getCa().getThoiGianKetThuc() + "</span>\n"
                    + " </div>"
                    + " <hr>\n"
                    + "    <h3 style=\"color: black;\">Mã QR nhận sân:</h3>\n"
                    + "    <br>\n"
                    + "    <img style=\"margin-left: auto; margin-right: auto;display: block;width: 50%;\" src=\"cid:image\">\n"
                    + "</div>"
                    + "</body>\n"
                    + "</html>";

            messageBodyPart.setContent(html, "text/html; charset=UTF-8");

            // add it
            multipart.addBodyPart(messageBodyPart);

            // file tạm
            File temp = File.createTempFile("tempfile", ".tmp");

            FileOutputStream fos = new FileOutputStream(temp);
            byteArrayOuputStream.writeTo(fos);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(temp);
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            msg.setContent(multipart);

            Transport.send(msg);
            return "thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "không thành công";
        }
    }
}
