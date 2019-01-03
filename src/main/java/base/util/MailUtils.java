package base.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import ipp.aci.scriptbase.util.EncryptionUtil;

public class MailUtils {

	public static void main(String[] args) throws Exception {

//		String hostOutlook = "outlook.office365.com";
//		String mailStoreTypeOutlook = "pop3";
//		String portOutlook = "995";
//		String usernameOutlook = "equipeqa.mktplace.primeup@outlook.com";
//		String passwordOutlook = "MarketPlace18";
//
//		System.out.println(
//				checkMailOutlook(hostOutlook, portOutlook, mailStoreTypeOutlook, usernameOutlook, passwordOutlook));
		
		System.out.println(EncryptionUtil.encrypt("patricksf"));
		
	}

	public static String checkMailOutlook(String host, String port, String storeType, String user, String password) {

		String mailMessage = null;

		try {
			Properties properties = new Properties();
			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", port);
			properties.put("mail.pop3.starttls.enable", "true");

			Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, password);

			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message m = emailFolder.getMessage(1);
			mailMessage = getMimeMessage(m);

			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mailMessage;
	}

	public static String extractActivationLink(String message) {

		String urlRegex = "^http:\\/\\/[\\w|.|:|\\/|?|=]+$";
		final Pattern pattern = Pattern.compile(urlRegex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(message);

		matcher.find();
		return matcher.group(0);
	}

	public static ArrayList<String> extractCredentials(String message) {

		ArrayList<String> credenciais = new ArrayList<String>();
		String urlRegex = "^ Login: [\\w]+$";
		final Pattern patternLogin = Pattern.compile(urlRegex, Pattern.MULTILINE);
		final Matcher matcherLogin = patternLogin.matcher(message);

		matcherLogin.find();
		credenciais.add(matcherLogin.group(0).substring(8));

		urlRegex = "^ Senha: [\\w|.|:|\\\\/|?|=|!|@|$|&]+$";
		final Pattern patternSenha = Pattern.compile(urlRegex, Pattern.MULTILINE);
		final Matcher matcherSenha = patternSenha.matcher(message);

		matcherSenha.find();
		credenciais.add(matcherSenha.group(0).substring(8));

		return credenciais;
	}

	protected static String getMimeMessage(Message message) throws MessagingException, IOException {
		Object content = message.getContent();
		if (content instanceof MimeMultipart) {
			MimeMultipart multipart = (MimeMultipart) content;
			if (multipart.getCount() > 0) {
				BodyPart part = multipart.getBodyPart(0);
				content = part.getContent();
			}
		}
		if (content != null) {
			return content.toString();
		}
		return null;
	}
}
