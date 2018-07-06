package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.appdata.AppDataType;
import com.wb.cpedata.parser.appdata.AppNVPairType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataPeopleType;
import com.wb.cpedata.parser.md.schema.v2_3.PersonIdentifierType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class CastData extends PresentationDataItem {

	final public String displayName;
	final public String charactorName;
	final public String firstGivenName;
	final public String secondGivenName;
	final public String lastName;
	final public String gender;
	final public int order;
	private String baselineApiActorId;
	private String peopleOtherId;
	private String appDataId;
	private String biographyText = null;
	final public String job;
	public BaselineCastData baselineCastData;

	public CastData(BasicMetadataPeopleType castInfo, Locale locale){

		super(null, null, null, locale);
		if (castInfo != null && castInfo.getIdentifier() != null && castInfo.getIdentifier().size() > 0){
			for (PersonIdentifierType identifierType : castInfo.getIdentifier()){
				if (MovieMetaData.OTHER_PEOPLE_ID.equals(identifierType.getNamespace())){
					id = identifierType.getIdentifier();
				} else if (MovieMetaData.OTHER_APP_DATA_ID.equals(identifierType.getNamespace())){
					appDataId = identifierType.getIdentifier();
				}
			}
		}

		if (castInfo!= null && castInfo.getJob() != null && castInfo.getJob().size() > 0){     // this may have multiple values
			job = castInfo.getJob().get(0).getJobFunction().getValue();
			if (castInfo.getJob().get(0).getCharacter() != null && castInfo.getJob().get(0).getCharacter().size() > 0)
				charactorName = castInfo.getJob().get(0).getCharacter().get(0);
			else
				charactorName = "";
			if (castInfo.getJob().get(0).getBillingBlockOrder() != null)
				order = castInfo.getJob().get(0).getBillingBlockOrder();
			else
				order = 0;
		}else{
			order = 0;
			job = "";
			charactorName = "";
		}

		if (castInfo!= null && castInfo.getName() != null){
			lastName = castInfo.getName().getFamilyName();
			firstGivenName = castInfo.getName().getFirstGivenName();
			secondGivenName = castInfo.getName().getSecondGivenName();
			if (castInfo.getName().getDisplayName() != null && castInfo.getName().getDisplayName().size() > 0) {
				displayName = castInfo.getName().getDisplayName().get(0).getValue();
			}else{
				displayName = firstGivenName + " " + lastName;
			}

		}else{
			lastName = "";
			firstGivenName = "";
			secondGivenName = "";
			displayName = "";
		}

		if (castInfo!= null && castInfo.getGender() != null){
			gender = castInfo.getGender();
		}else{
			gender = "";
		}

		if (castInfo!= null && castInfo.getIdentifier() != null){
			for (PersonIdentifierType personId : castInfo.getIdentifier()) {
				if (MovieMetaData.BASELINE_NAMESPACE.equals(personId.getNamespace()) ) {
					baselineApiActorId = personId.getIdentifier();
				} else if (MovieMetaData.OTHER_PEOPLE_ID.equals(personId.getNamespace())){
					peopleOtherId = personId.getIdentifier();
				}
			}
		}
		id = peopleOtherId;
		title = displayName;
		parentExperienceId = null;
	}

	public BaselineCastData getBaselineCastData() {
		return baselineCastData;
	}

	public String getBaselineActorId(){
		return baselineApiActorId;
	}

	public String getOtherPeopleId() {
		return peopleOtherId;
	}

	public String getPosterImgUrl(){
		return "";
	}

	public String getAppDataId() {
		return  appDataId;
	}

	public String getBiographyText() {
		return biographyText;
	}

	public void fillCastDataWithAppData(AppDataType appDataType, HashMap<String, PictureType> pictureTypeAssetsMap, HashMap<String, PictureImageData> pictureImageMap){

		if (appDataType != null && appDataType.getNVPair() != null && appDataType.getNVPair().size() > 0){

			CastHeadShot firstHeadShot = null;
			String appDataBiography = "";
			List<CastHeadShot> castHeadShots = new ArrayList<>();
			for (AppNVPairType nvPairType : appDataType.getNVPair()){
				if ("picture_id".equals(nvPairType.getName())){

					PictureType picture = pictureTypeAssetsMap.get(nvPairType.getPictureID());
					PictureImageData fullImage = pictureImageMap.get(picture.getImageID());
					PictureImageData thumbNailImage = pictureImageMap.get(picture.getThumbnailImageID());
					CastHeadShot imageHeadShot = new CastHeadShot();

					imageHeadShot.fullSizeUrl = fullImage != null ? fullImage.url : null;
					imageHeadShot.thumbnailUrl = thumbNailImage != null ? thumbNailImage.url : null;
					if (firstHeadShot == null)
						firstHeadShot = imageHeadShot;
					else
						castHeadShots.add(imageHeadShot);


				} else if ("description".equals(nvPairType.getName())){
					appDataBiography = nvPairType.getText();
				} else if ("description_header".equals(nvPairType.getName())){
					biographyText = nvPairType.getText();
				}


			}


			final CastHeadShot actorImageShot = firstHeadShot;
			baselineCastData = new BaselineCastData(){

				public String getThumbnailImageUrl(){
					if (actorImageShot != null && !StringHelper.isEmpty(actorImageShot.thumbnailUrl))
						return actorImageShot.thumbnailUrl;
					else
						return getFullImageUrl();
				}

				public String getIconImageUrl(){
					return getThumbnailImageUrl();
				}

				public String getFullImageUrl(){
					if (actorImageShot != null && !StringHelper.isEmpty(actorImageShot.fullSizeUrl))
						return actorImageShot.fullSizeUrl;
					else
						return "";
				}

				public List<CastHeadShot> getGallery(){
					return headShots;
				}

				public List<CastSocialMedia> getSocialMedium(){ return null;}

				public String getSocialMediaUrl(SOCIAL_MEDIA_KEY Key){
					return "";
				}
			};
			baselineCastData.biography = appDataBiography;
			baselineCastData.headShots = castHeadShots;
		}

	}
}
