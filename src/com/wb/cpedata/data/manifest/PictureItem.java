package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;

import java.util.Locale;

public class PictureItem extends PresentationDataItem {
	final public PictureImageData fullImage;
	final public PictureImageData thumbnail;

	public PictureItem(String parentExperienceId, InventoryMetadataType metadata, PictureImageData fullImage, PictureImageData thumbnail, Locale locale){
		super(metadata, parentExperienceId, locale);
		this.fullImage = fullImage;
		this.thumbnail = thumbnail;
	}

	public String getPosterImgUrl(){
		return thumbnail != null ? thumbnail.url : null;
	}
}
