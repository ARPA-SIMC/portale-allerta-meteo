package it.eng.allerter.allerta.utils;

import java.net.MalformedURLException;
import java.net.URL;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;

public class FacebookConnector {
	private  Facebook facebook = null;

	public FacebookConnector(String appID,String appSecret,String permToken){

		facebook = new FacebookFactory().getInstance();

		facebook.setOAuthAppId(appID, appSecret);
		facebook.setOAuthPermissions("email,publish_stream,manage_pages,publish_pages,user_posts");
		facebook.setOAuthAccessToken(new AccessToken(permToken,null));
	}	

	public  void postWithLinkAndPic(String type, String title, String message, String link, String pictureLink){
		PostUpdate post = null;
		try {
			post = new PostUpdate(new URL(link))
					.picture(new URL(pictureLink))
					.name(title)
					.caption("ALLERTAMETEO ER")
					.description(message).message(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			facebook.postFeed(post);
		} catch (FacebookException e) {
			e.printStackTrace();
		}
	}

	public void postWithLinkAndText(String title, String message, String link, String pictureLink){
		PostUpdate post = null;
		try {
			message = title +"\n"+message;
			post = new PostUpdate(new URL(link)).description(title).message(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			facebook.postFeed(post);
		} catch (FacebookException e) {
			e.printStackTrace();
		}
	}

	public void postWithLink(String type, String title, String message, String link){
		PostUpdate post = null;
		try {
			post = new PostUpdate(new URL(link))
					.name(type.toUpperCase()+" : "+title)
					.caption("ARPAE")
					.description(message);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			facebook.postFeed(post);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postWithPic(String type, String title, String message,  String pictureLink){
		PostUpdate post = null;
		try {
			post = new PostUpdate(title)
					.picture(new URL(pictureLink))
					.name(type.toUpperCase()+" : "+title)
					.caption("ARPAE")
					.description(message);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			facebook.postFeed(post);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postMessage(String title, String message){
		try {
			facebook.postStatusMessage(title+"\n"+message);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void post(String type, String title, String message){
		//			
		//			 PostUpdate post = new PostUpdate(title)
		//			        .name(type.toUpperCase()+" : "+title)
		//			        .caption("ARPAE")
		//			        .description(message);
		try {
			facebook.postLink(new URL("http://facebook4j.org"));
			//			facebook.postFeed(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
