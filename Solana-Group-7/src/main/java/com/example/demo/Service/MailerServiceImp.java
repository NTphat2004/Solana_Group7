package com.example.demo.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import com.example.demo.Entity.MailInfo;

@Service
public class MailerServiceImp implements MailerService {
	List<MailInfo> listEmails = new ArrayList<>();
	@Autowired
	JavaMailSender sender;
	@Autowired
	ServletContext context;
	@Autowired
	private Configuration config;

	@Override
	public void send(MailInfo mail) throws MessagingException {
		javax.mail.internet.MimeMessage message = sender.createMimeMessage();
		// Sử dụng Helper để thiết lập các thông tin cần thiết cho message
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(), true);
		helper.setReplyTo(mail.getFrom());

		String[] cc = mail.getCc();
		// Kiểm tra mảng cc có tồn tại hay không
		if (cc != null && cc.length > 0) {
			helper.setCc(cc);
		}

		String[] bcc = mail.getBcc();
		// Kiểm tra mảng bcc có tồn tại hay không
		if (bcc != null && bcc.length > 0) {
			helper.setBcc(bcc);
		}
		// Mảng file
		List<File> files = mail.getFiles();
		if (files.size() > 0) {
			for (File file : files) {
				helper.addAttachment(file.getName(), file);
			}
		}
		// Gửi message đến SMTP server
		sender.send(message);
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		this.send(new MailInfo(to, subject, body));
	}

	@Override
	public void queue(MailInfo mail) {
		listEmails.add(mail);
	}

	@Override
	public void queue(String to, String subject, String body) {
		queue(new MailInfo(to, subject, body));
	}

	@Scheduled(fixedDelay = 1000)
	public void run() {
		while (!listEmails.isEmpty()) {
			MailInfo mail = listEmails.remove(0);
			try {
				this.send(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String bodyTemplate() {
		String html = "";
		try {
			MimeMessage message = sender.createMimeMessage();
			// Sử dụng Helper để thiết lập các thông tin cần thiết cho message
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

			// add attachment
			File img = new File("/logo.png");
			helper.addAttachment("logo.png", img);
			String opt ="";
			  Map<String, Object> model = new HashMap();
			  
			if (context.getAttribute("optset") != null) {
				 opt = (String) context.getAttribute("optset");
				 String mail = (String) context.getAttribute("mail");
				  model.put("myProperty", opt);
				  model.put("mail", mail);
			}

			Template t = config.getTemplate("email-template.ftl");
			html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
}
