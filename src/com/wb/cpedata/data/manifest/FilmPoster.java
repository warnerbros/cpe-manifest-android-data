package com.wb.cpedata.data.manifest;

import com.google.gson.annotations.SerializedName;

public class FilmPoster {
	@SerializedName("IMAGE_ID")	//Integer	933554
	public String imageId;
	@SerializedName("HEIGHT")//Integer	3388348
	public int hegiht;
	@SerializedName("WEIGHT")//Integer	3388348
	public int weight;
	@SerializedName("CAPTION")//String	Laurence Fishburne
	public String name;
	@SerializedName("FULL_URL")//String	http://media.baselineresearch.com/images/933554/933554_full.jpg
	public String fullSizeUrl;
	@SerializedName("LARGE_URL")//String	http://media.baselineresearch.com/images/933554/933554_large.jpg
	public String largeUrl;
	@SerializedName("MEDIUM_URL")//String	http://media.baselineresearch.com/images/933554/933554_medium.jpg
	public String mediumUrl;
	@SerializedName("SMALL_URL")//String	http://media.baselineresearch.com/images/933554/933554_small.jpg
	public String smallUrl;
	@SerializedName("LARGE_THUMBNAIL_URL")  //String	http://media.baselineresearch.com/images/933554/933554_gThumb.jpg
	public String largeThumbnailUrl;
	@SerializedName("THUMBNAIL_URL")	//String	http://media.baselineresearch.com/images/933554/933554_sThumb.jpg
	public String thumbnailUrl;
	@SerializedName("ICON_URL")	//String	http://media.baselineresearch.com/images/933554/933554_icon.jpg
	public String iconUrl;

	public static FilmPoster getDefaultEmptyPoster(){
		FilmPoster empty = new FilmPoster();
		empty.fullSizeUrl = empty.largeUrl = empty.mediumUrl = empty.smallUrl = empty.largeThumbnailUrl = empty.thumbnailUrl = empty.iconUrl = "android.resource://com.wb.nextgen/drawable/poster_blank";
		empty.imageId = "0";
		return empty;
	}

}
