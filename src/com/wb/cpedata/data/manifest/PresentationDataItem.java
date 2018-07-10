package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.Locale;

public abstract class PresentationDataItem {
	public String id;
	public String title;
	public String parentExperienceId;
	public String posterImgUrl;
	public String summary = "";

	public PresentationDataItem(InventoryMetadataType metaData, String parentExperienceId, Locale locale){
		BasicMetadataInfoType localizedInfo = null;
		if (metaData != null && metaData.getBasicMetadata().getLocalizedInfo() != null && metaData.getBasicMetadata().getLocalizedInfo().size() > 0) {


			localizedInfo = CPEData.getMatchingLocalizableObject(metaData.getBasicMetadata().getLocalizedInfo(), locale);


			if (localizedInfo == null)
				localizedInfo = metaData.getBasicMetadata().getLocalizedInfo().get(0);

			title = localizedInfo.getTitleDisplayUnlimited();
			if (localizedInfo.getSummary190() != null && !StringHelper.isEmpty(localizedInfo.getSummary190().getValue())){
				summary = localizedInfo.getSummary190().getValue();
			} else if (localizedInfo.getSummary400() != null && !StringHelper.isEmpty(localizedInfo.getSummary400().getValue())){
				summary = localizedInfo.getSummary400().getValue();
			} else if (localizedInfo.getSummary4000() != null && !StringHelper.isEmpty(localizedInfo.getSummary4000().getValue())){
				summary = localizedInfo.getSummary4000().getValue();
			}
			this.id = metaData.getContentID();
		} else{
			title = "";
			this.id = "";
		}
		this.parentExperienceId = parentExperienceId;
	}

	public PresentationDataItem(String id, String title, String parentExperienceId, Locale locale){
		this.id = id;
		this.title = title;
		this.parentExperienceId = parentExperienceId;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getParentExperienceId(){
		return parentExperienceId;
	}

	public abstract String getPosterImgUrl();

	public String getSummary(){
		return  summary;
	}

	public String getGridItemDisplayName(){
		return getTitle();
	}
}
