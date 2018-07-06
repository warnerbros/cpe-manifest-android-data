package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ECGalleryItem extends PresentationDataItem {
	final public List<PictureItem> galleryImages = new ArrayList<PictureItem>();
	final public String subType;
	final public String galleryId;
	public ECGalleryItem(String parentExperienceId, String galleryId, InventoryMetadataType metaData, List<PictureItem> galleryImages, String subType, Locale locale){
		super(metaData, parentExperienceId, locale);
		this.galleryImages.addAll(galleryImages);
		this.galleryId = galleryId;
		this.subType = subType;
		if (metaData != null) {
			BasicMetadataInfoType localizedInfo = metaData != null ? metaData.getBasicMetadata().getLocalizedInfo().get(0) : null;
			if (localizedInfo != null && localizedInfo.getArtReference() != null && localizedInfo.getArtReference().size() > 0) {
				posterImgUrl = localizedInfo.getArtReference().get(0).getValue();
			}
		}
	}

	@Override
	public String getPosterImgUrl(){
		if (StringHelper.isEmpty(posterImgUrl) ) {
			if (galleryImages.size() > 0){
				posterImgUrl = galleryImages.get(0).thumbnail != null ? galleryImages.get(0).thumbnail.url : null;
			}
		}
		return posterImgUrl;
	}

	public boolean isTurnTable(){
		return "Turntable".equalsIgnoreCase(subType);
	}
}
