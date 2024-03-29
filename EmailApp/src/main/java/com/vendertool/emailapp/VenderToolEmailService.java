package com.vendertool.emailapp;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.vendertool.emailapp.datamodel.RegistrationEmailDataModel;

public class VenderToolEmailService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void sendEmail(RegistrationEmailDataModel dataModel) {
		sendConfirmationEmail(dataModel);
	}

	private void sendConfirmationEmail(final RegistrationEmailDataModel dataModel) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@SuppressWarnings("unchecked")
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(dataModel.getToEmail());
				message.setSubject(dataModel.getSubject());
				Map model = new HashMap();
				model.put("user", dataModel);
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "templates/Registration.vm",
						model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
}