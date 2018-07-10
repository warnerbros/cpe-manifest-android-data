package com.wb.cpedata.data.manifest;

import com.wb.cpedata.CPEDataParser;
import com.wb.cpedata.R;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.util.utils.F;
import com.wb.cpedata.util.utils.CPEDataParserLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.Duration;

public class AudioVisualItem extends PresentationDataItem {
	final public List<AudioVisualTrack> tracksList;
	final public String duration;
	final public List<ExternalApiData> externalApiDataList = new ArrayList<ExternalApiData>();
	final PresentationImageData[] images;
	final Duration durationObject;
	final String subtype;
	final public String videoId;

	boolean isWatched = false;

	public AudioVisualItem(String parentExperienceId, String videoId, InventoryMetadataType metaData, List<AudioVisualTrack> tracks, String subtype, Locale locale){
		super(metaData, parentExperienceId, locale);
		this.subtype = subtype;
		this.videoId = videoId;
		BasicMetadataInfoType localizedInfo = metaData!= null ? metaData.getBasicMetadata().getLocalizedInfo().get(0): null;
		if (tracks != null && tracks.size() > 0) {
			tracksList = tracks;

			if (localizedInfo != null && localizedInfo.getArtReference() != null && localizedInfo.getArtReference().size() > 0) {
				posterImgUrl = localizedInfo.getArtReference().get(0).getValue();
				images = new PresentationImageData[localizedInfo.getArtReference().size()];
				for (int i = 0; i< localizedInfo.getArtReference().size(); i++){
					images[i] = new PresentationImageData(localizedInfo.getArtReference().get(i));
				}
			}else {
				images = null;
				posterImgUrl = null;
			}

			String dValue = "";
			if (metaData != null && metaData.getBasicMetadata() != null)
				durationObject = metaData.getBasicMetadata().getRunLength();
			else
				durationObject = null;

			if (durationObject != null) {
				try {
					dValue = durationObject.toString();
				} catch (Exception ex) {
					CPEDataParserLogger.d(F.TAG, ex.getLocalizedMessage());
				}
			}
			duration = dValue;
		}else{
			tracksList = null;
			posterImgUrl = null;
			duration = null;
			images = null;
			durationObject = null;
		}
	}


	public String getVideoUrl(){
		if (tracksList != null && tracksList.size() > 0)
			return tracksList.get(0).getVideoUrl();
		else
			return null;
	}

	public String getAudioUrl(){
		if (tracksList != null && tracksList.size() > 0)
			return tracksList.get(0).getAudioUrl();
		else
			return null;
	}

	public void setLocationMetaData(String title, String url){
		this.title = title;
		posterImgUrl = url;
	}

	public String getFullDurationString(){
		if (durationObject == null)
			return "";
		int h = durationObject.getHours();
		int m = durationObject.getMinutes();
		int s = durationObject.getSeconds();
		String retString = "";
		if (s > 0)
			retString = s + " sec";
		if (m > 0)
			retString = m + " min " + retString;
		if (h > 0)
			retString = h + " hour " + retString;

		return  retString;
	}

	public AudioVisualItem(String parentExperienceId, String videoId, InventoryMetadataType metaData, List<AudioVisualTrack> tracksList, List<ExternalApiData> apiDataList, String subtype, Locale locale){
		this(parentExperienceId, videoId, metaData, tracksList, subtype, locale);
		if (apiDataList != null)
			externalApiDataList.addAll(apiDataList);
	}

	public String getPreviewImageUrl(){
		if (images != null){
			return images[images.length-1].imageUrl;
		}else
			return null;
	}

	@Override
	public String getPosterImgUrl(){

		return posterImgUrl;
	}

	public boolean getIsWatched(){
		return isWatched;
	}

	public void setWatched(){
		isWatched = true;
	}

	public boolean isShareClip() {
		if (CPEData.SHARE_CLIP_SUBTYPE.equalsIgnoreCase(subtype))
			return true;	// man of steel
		else {
			// travel up the parent to see if it's a sharable clip
			ExperienceData exp = CPEDataParser.getCPEData().findExperienceDataById(parentExperienceId);
			do {
				if (exp.isShareClip())
					return true;
			} while ((exp = exp.parent) != null);
			return false;
		}
	}

	@Override
	public String getGridItemDisplayName(){
		if (isShareClip()){
			return CPEDataParser.getApplicationContext().getResources().getString(R.string.share_clip_sub_text);
		}else {
			return super.getGridItemDisplayName();
		}
	}
}
