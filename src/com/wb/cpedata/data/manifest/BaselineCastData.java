package com.wb.cpedata.data.manifest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaselineCastData {
	private static final String FACEBOOK_KEY = "facebook.com";

	public static enum SOCIAL_MEDIA_KEY{
		FACEBOOK_KEY("facebook.com"), INSTAGRAM_KEY("instagram.com"), TWITTER_KEY("twitter.com");
		String keyValue;
		SOCIAL_MEDIA_KEY(String keyValue){
			this.keyValue = keyValue;
		}
	}

	public List<CastHeadShot> headShots;
	@SerializedName("SHORT_BIO")
	public String biography;
	@SerializedName("FILMOGRAPHY")
	public List<Filmography> filmogrphies;
	@SerializedName("SOCIAL_ACCOUNTS")
	private List<CastSocialMedia> socialMedium;

	public String getThumbnailImageUrl(){
		if (headShots != null && headShots.size() > 0){
			return headShots.get(0).largeUrl;
		}else
			return null;
	}

	public String getIconImageUrl(){
		if (headShots != null && headShots.size() > 0){
			return headShots.get(0).iconUrl;
		}else
			return null;
	}

	public String getFullImageUrl(){
		if (headShots != null && headShots.size() > 0){
			return headShots.get(0).fullSizeUrl;
		}else
			return null;
	}

	public List<CastHeadShot> getGallery(){
		return headShots;
	}

	public void setSocialMedium(List<CastSocialMedia> socialMedium){
		this.socialMedium = socialMedium;
	}

	public List<CastSocialMedia> getSocialMedium(){ return socialMedium;}

	public String getSocialMediaUrl(SOCIAL_MEDIA_KEY Key){
		if (socialMedium != null && socialMedium.size() > 0){
			for (CastSocialMedia socialMedia : socialMedium){
				if (socialMedia.url.contains(Key.keyValue)){
					return socialMedia.url;
				}
			}
		}
		return null;

	}

	public boolean hasGotAllFilmPictures(){
		if (filmogrphies != null && filmogrphies.size() > 0){
			for(Filmography film : filmogrphies){
				if (!film.isFilmPosterRequest())
					return false;
			}
		}
		return true;
	}

	public void filterText() {
		if (biography != null) {
			biography = biography.replaceAll("&amp;", "&");
		}
	}
}
