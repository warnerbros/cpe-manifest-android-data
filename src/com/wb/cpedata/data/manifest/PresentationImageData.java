package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.util.utils.StringHelper;

public class PresentationImageData {
	public final String imageUrl;
	public final int width;
	public final int height;
	public PresentationImageData(BasicMetadataInfoType.ArtReference artReference){
		imageUrl = artReference.getValue();
		String dimensionStr = artReference.getResolution();
		if (!StringHelper.isEmpty(dimensionStr)){
			int tempW = 0, tempH = 0;
			try {
				int xPostion = dimensionStr.indexOf("x");
				String w = dimensionStr.substring(0, xPostion);
				String h = dimensionStr.substring(xPostion + 1, dimensionStr.length() );
				tempW = Integer.parseInt(w);
				tempH = Integer.parseInt(h);
			}catch(Exception ex){}
			width = tempW;
			height = tempH;
		}else{
			width = height = 0;
		}
	}
}
