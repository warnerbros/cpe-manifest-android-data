package com.wb.cpedata.data.theTake;

import com.google.gson.annotations.SerializedName;

public class FrameImages {
	@SerializedName(value="1000pxLink", alternate={"1000pxFrameLink", "1000pxKeyFrameLink", "1000pxCropLink", "1000pxHeadshotLink"})//"1000pxFrameLink")
	public String image1000px;
	@SerializedName(value="500pxLink", alternate={"500pxFrameLink", "500pxKeyFrameLink", "500pxCropLink", "500pxHeadshotLink"})
	public String image500px;
	@SerializedName(value="fullSizeFrameLink")
	public String image1FullSize;
	@SerializedName(value="250pxLink", alternate={"250pxFrameLink", "250pxKeyFrameLink", "250pxCropLink", "250pxHeadshotLink"})
	public String image250px;
	@SerializedName(value="125pxLink", alternate={"125pxFrameLink", "125pxKeyFrameLink", "125pxCropLink", "125pxHeadshotLink"})
	public String image125px;
	@SerializedName(value="50pxLink", alternate={"50pxFrameLink", "50pxKeyFrameLink", "50pxCropLink", "50pxHeadshotLink"})
	public String image50px;
}
