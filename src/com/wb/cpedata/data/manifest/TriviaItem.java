package com.wb.cpedata.data.manifest;

import java.math.BigInteger;
import java.util.Locale;

public class TriviaItem extends PresentationDataItem {
	public final PictureItem pictureItem;
	public final TextItem textItem;
	public TriviaItem(String id, BigInteger index, String text, PictureImageData fullImg, PictureImageData thumbnailImg, Locale locale){
		super(id,text, null, locale);
		textItem = new TextItem(index, text, locale);
		pictureItem = new PictureItem(null, null, fullImg, thumbnailImg, locale);
	}
	public String getTitle(){
		if (textItem != null)
			return textItem.getTitle();
		else
			return "";
	}

	public String getPosterImgUrl(){
		if (pictureItem != null)
			return pictureItem.getPosterImgUrl();
		else
			return "";
	}
}
