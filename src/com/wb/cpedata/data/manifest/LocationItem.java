package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.appdata.AppDataLocationType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LocationItem extends PresentationDataItem {
	//public final boolean isFrictional;
	public final String address;
	public final float longitude;
	public final float latitude;
	public final String description;
	public final int zoom;
	private PictureImageData locationThumbnail;
	public final String greaterTitle;
	public final PictureImageData pinImage;
	public final String experienceId;
	private ExperienceData experienceData;
	private List<PresentationDataItem> presentationDataItems = new ArrayList<PresentationDataItem>();
	private LocationItem parentSceneLocation;
	HashMap<String, ExperienceData> experienceIdToExperienceMap;

	public LocationItem(String id, int displayOrder, String type, AppDataLocationType appDataLocation, int zoom, String text,
						PictureImageData locationThumbnail, PictureImageData pinImage, String experienceId, Locale locale, HashMap<String, ExperienceData> experienceIdToExperienceMap){
		super(id, "", null, locale);
		description = text;
		this.zoom = zoom;
		greaterTitle = type;
		if (appDataLocation!= null && appDataLocation.getLocation() != null) {
			AppDataLocationType.Location location = appDataLocation.getLocation().get(0);
			this.address = location.getAddress().toString();
			this.latitude = location.getEarthCoordinate().getLatitude().floatValue();
			this.longitude = location.getEarthCoordinate().getLongitude().floatValue();
			this.title = location.getName();
		}else{
			this.address = "";
			this.latitude = 0;
			this.longitude = 0;
			this.title = "";

		}
		this.locationThumbnail = locationThumbnail;
		this.pinImage = pinImage;
		this.experienceId = experienceId;
		this.experienceIdToExperienceMap = experienceIdToExperienceMap;

	}

	public String getPosterImgUrl(){
		String retImgUrl = null;
		if (locationThumbnail != null)
			retImgUrl = locationThumbnail.url;
		else if (experienceId != null){
			computeFromExperience();
			if (experienceData != null) {
				retImgUrl =  experienceData.getPosterImgUrl();
			}
		}
		if (!StringHelper.isEmpty(retImgUrl))
			return retImgUrl;
		else
			return getGoogleMapImageUrl(320, 180);
	}



	final static String GOOGLE_MAP_IMAGE_URL = "http://maps.googleapis.com/maps/api/staticmap?center=%s,%s&zoom=%s&scale=2&size=%sx%s&maptype=roadmap&format=png&visual_refresh=true";
	final static String PIN_DEFAULT = "&markers=color:red|%s,%s";
	final static String PIN_CUSTOM = "&markers=icon:%s|%s,%s";
	public String getGoogleMapImageUrl(int width, int height){
		String pinPortion = "";
		if (pinImage != null && !StringHelper.isEmpty(pinImage.url)){
			pinPortion = String.format(PIN_CUSTOM, pinImage.url, latitude, longitude);

		}else{
			pinPortion = String.format(PIN_DEFAULT, latitude, longitude);
		}
		return String.format(GOOGLE_MAP_IMAGE_URL, latitude, longitude, zoom - 3, width, height) + pinPortion;
	}

	public List<PresentationDataItem> getPresentationDataItems(){
		computeFromExperience();
		return presentationDataItems;
	}

	private void computeFromExperience(){
		if (!StringHelper.isEmpty(experienceId) && experienceData == null){
			if (experienceIdToExperienceMap != null) {
				experienceData = experienceIdToExperienceMap.get(experienceId);
				presentationDataItems = new ArrayList<PresentationDataItem>();

				if (experienceData.childIdToSequenceNumber.size() > 0){

					for (String childExpId : experienceData.childIdToSequenceNumber.keySet()){
						ExperienceData child = experienceIdToExperienceMap.get(childExpId);
						experienceData.addChild(child);
					}

					for (ExperienceData child : experienceData.getChildrenContents()){
						if (child.audioVisualItems != null && child.audioVisualItems.size() > 0){
							presentationDataItems.addAll(child.audioVisualItems);
						}
						if (child.galleryItems != null && child.galleryItems.size() > 0){
							presentationDataItems.addAll(child.galleryItems);
						}/*
                            if (child.locationItems != null && child.locationItems.size() > 0){
                                child.addAll(child.audioVisualItems);
                            }*/
					}
				}
			}
		}
	}

	public String getTitle(){
		if (!StringHelper.isEmpty(experienceId)){
			computeFromExperience();
			if (experienceData != null && !StringHelper.isEmpty(experienceData.title))
				return experienceData.title;
		}
		return title;
	}

	private String getLocationThumbnailUrl(){
		computeFromExperience();
		if (locationThumbnail != null){
			return locationThumbnail.url;
		}else {
			computeFromExperience();
			if (experienceData != null) {
				return experienceData.getPosterImgUrl();
			}else
				return "";
		}
	}
}
