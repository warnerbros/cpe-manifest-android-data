package com.wb.cpedata.data.manifest;

import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryImageType;

public class PictureImageData {

	final public String url;
	final public int width;
	final public int height;
	final public String imageId;

	public PictureImageData(InventoryImageType inventoryImageType){
		imageId = inventoryImageType.getImageID();
		url = inventoryImageType.getContainerReference().getContainerLocation();
		width = inventoryImageType.getWidth();
		height = inventoryImageType.getHeight();
	}
}
