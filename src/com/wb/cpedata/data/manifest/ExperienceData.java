package com.wb.cpedata.data.manifest;

import com.wb.cpedata.data.style.ExperienceStyle;
import com.wb.cpedata.parser.manifest.schema.v1_4.ExperienceChildType;
import com.wb.cpedata.parser.manifest.schema.v1_4.ExperienceType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExperienceData {
	final public String title;
	protected String posterImgUrl;
	//final public String ecVideoUrl;
	protected CPEData.ECGroupType type = CPEData.ECGroupType.UNKNOWN;
	final protected List<ExperienceData> childrenExperience = new ArrayList<ExperienceData>();
	final public List<ECGalleryItem> galleryItems = new ArrayList<ECGalleryItem>();
	final public List<AudioVisualItem> audioVisualItems = new ArrayList<AudioVisualItem>();
	final protected List<LocationItem> locationItems = new ArrayList<LocationItem>();
	final public List<ShopItem> shopItems = new ArrayList<ShopItem>();
	final public List<InteractiveItem> interactiveItems = new ArrayList<InteractiveItem>();
	final public String experienceId;
	final protected HashMap<String, Integer> childIdToSequenceNumber = new HashMap<String, Integer>();
	protected ExternalApiData externalApp;
	final public String timeSequenceId;
	final public ExperienceStyle style;
	ExperienceData parent;

	public ExperienceData(String title, String experienceId, String timeSequenceId){
		this.title = title;
		this.experienceId = experienceId;
		this.timeSequenceId = timeSequenceId;
		this.style = null;
	}

	public ExperienceData(ExperienceType experience, InventoryMetadataType metaData, List<AudioVisualItem> avItems,
						  List<ECGalleryItem> galleryItems, List<LocationItem> locationItems, List<ShopItem> shopItems, List<InteractiveItem> interactiveItems,
						  ExperienceStyle style){
		experienceId = experience.getExperienceID();     // or experience Id
		this.style = style;
		if (metaData == null){
			title = null;
			if (experience.getTimedSequenceID() != null && experience.getTimedSequenceID().size() > 0)
				timeSequenceId = experience.getTimedSequenceID().get(0);
			else
				timeSequenceId = null;
		}else {
			timeSequenceId = null;
			BasicMetadataInfoType localizedInfo = metaData.getBasicMetadata().getLocalizedInfo().get(0);
			title = localizedInfo.getTitleDisplayUnlimited(); // should loop the list and look for the correct language code

			if (experience.getApp() != null && experience.getApp().size() > 0 && experience.getApp().get(0).getAppName() != null && experience.getApp().get(0).getAppName().size() > 0) {
				externalApp = new ExternalApiData(experience.getApp().get(0).getAppName().get(0).getValue(), "");
			}


			if (localizedInfo != null && localizedInfo.getArtReference() != null && localizedInfo.getArtReference().size() > 0) {
				posterImgUrl = localizedInfo.getArtReference().get(0).getValue();
			} else if (this.galleryItems.size() > 0) {
				posterImgUrl = null;
			}
			if (experience.getExperienceChild() != null && experience.getExperienceChild().size() > 0) {

				for (ExperienceChildType childType : experience.getExperienceChild()) {
					if (childType.getSequenceInfo() != null) {
						childIdToSequenceNumber.put(childType.getExperienceID(), childType.getSequenceInfo().getNumber());
					}
				}
			}
		}
		if (avItems != null && avItems.size() > 0) {
			audioVisualItems.addAll(avItems);
		}

		if (galleryItems != null && galleryItems.size() > 0) {
			this.galleryItems.addAll(galleryItems);
		}

		if (locationItems != null && locationItems.size() > 0) {
			this.locationItems.addAll(locationItems);
		}

		if (shopItems != null && shopItems.size() > 0) {
			this.shopItems.addAll(shopItems);
		}

		if (interactiveItems != null && interactiveItems.size() > 0){
			this.interactiveItems.addAll(interactiveItems);
		}
	}

	public String getDuration(){
		if (audioVisualItems.size() > 0){
			return audioVisualItems.get(0).duration;
		}
		return null;
	}

	public boolean getIsWatched(){
		if (audioVisualItems.size() > 0){
			return audioVisualItems.get(0).isWatched;
		}
		return false;
	}

	public void setWatched(){
		if (audioVisualItems.size() > 0){
			audioVisualItems.get(0).setWatched();
		}
	}

	public ExternalApiData getExternalApp(){
		return externalApp;
	}

	public CPEData.ECGroupType getECGroupType(){
		if (type == CPEData.ECGroupType.UNKNOWN ){
			if (galleryItems.size() > 0)
				type = CPEData.ECGroupType.GALLERY;
			else if (audioVisualItems.size() > 0)
				type = CPEData.ECGroupType.FEATURETTES;
			else if (locationItems.size() > 0)
				type = CPEData.ECGroupType.LOCATIONS;
			else if (shopItems.size() > 0)
				type = CPEData.ECGroupType.SHOP;
			else if (interactiveItems.size() > 0)
				type = CPEData.ECGroupType.INTERACTIVE;
			else if (externalApp != null)
				type = CPEData.ECGroupType.EXTERNAL_APP;
			else if (childrenExperience.size() > 0)
				type = childrenExperience.get(0).getECGroupType();

		}
		return type;
	}

	void addChild(ExperienceData ecContent){
		ecContent.parent = this;
		// skip if children has been added already
		if (childrenExperience.contains(ecContent))
			return;

		if (childrenExperience.size() == 0 && childIdToSequenceNumber.size() > 0){
			childrenExperience.add(ecContent);
		}else if (childIdToSequenceNumber.containsKey(ecContent.experienceId)) {
			int childSequenceNumber = childIdToSequenceNumber.get(ecContent.experienceId);

			for(int i=childrenExperience.size()-1; i >=0 ; i--){
				String checkExpId = childrenExperience.get(i).experienceId;

				int checkSequenceNumber = childIdToSequenceNumber.get(checkExpId);
				if (childSequenceNumber > checkSequenceNumber){
					childrenExperience.add(i+1, ecContent);
					return;
				}
			}
			childrenExperience.add(0, ecContent);
		}else{
			childrenExperience.add(ecContent);
		}
	}

	public List<ExperienceData> getChildrenContents(){
		return childrenExperience;
	}


	public String getPosterImgUrl(){
		if (!StringHelper.isEmpty(posterImgUrl))
			return posterImgUrl;
		else if (galleryItems.size() > 0) {
			posterImgUrl = galleryItems.get(0).getPosterImgUrl();
		}else if (audioVisualItems.size() > 0) {
			posterImgUrl = audioVisualItems.get(0).getPosterImgUrl();
		}else if (locationItems.size() > 0) {
			posterImgUrl = locationItems.get(0).getPosterImgUrl();
		}else if (shopItems.size() > 0){
			posterImgUrl = shopItems.get(0).getPosterImgUrl();
		}else if (StringHelper.isEmpty(posterImgUrl) && childrenExperience.size() > 0) {
			for (ExperienceData ec : childrenExperience) {
				if (!StringHelper.isEmpty(ec.getPosterImgUrl())) {
					posterImgUrl = ec.getPosterImgUrl();
					break;
				}
			}
		}
		return posterImgUrl;
	}

	private final List<LocationItem> sceneLocations = new ArrayList<LocationItem>();
	public void computeSceneLocationFeature(){
		HashMap<String, LocationItem> sceneLocationMap = new HashMap<String, LocationItem>();
		for (ExperienceData child : childrenExperience){
			LocationItem location = child.locationItems.get(0);
			if (!sceneLocationMap.containsKey(location.getId())){
				sceneLocations.add(location);
				sceneLocationMap.put(location.getId(), location);
			}
		}
	}

	public List<LocationItem> getSceneLocations(){
		return  sceneLocations;
	}

	public ExperienceStyle getStyle(){
		if (style == null){
			ExperienceData nextCheck = parent;
			while (parent != null){
				if (parent.style != null)
					return style;
				else
					nextCheck = nextCheck.parent;
			}
		}
		return style;
	}

	public boolean isShareClip() {
		return experienceId != null && experienceId.contains(CPEData.SHARE_CLIP_KEY);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ExperienceData that = (ExperienceData) o;

		return experienceId.equals(that.experienceId);

	}

	@Override
	public int hashCode() {
		return experienceId.hashCode();
	}
}
