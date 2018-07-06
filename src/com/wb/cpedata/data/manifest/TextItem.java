package com.wb.cpedata.data.manifest;

import java.math.BigInteger;
import java.util.Locale;

public class TextItem extends PresentationDataItem {
	final public BigInteger index;

	public TextItem(BigInteger index, String text, Locale locale){
		super("",text, null, locale);
		this.index = index;
	}
	public String getPosterImgUrl(){
		return "";
	}
}
