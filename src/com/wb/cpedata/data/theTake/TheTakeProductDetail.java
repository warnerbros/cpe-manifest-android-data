package com.wb.cpedata.data.theTake;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TheTakeProductDetail {
	public FrameImages cropImage;//	Object
	public FrameImages actorImage;//	Object
	public FrameImages posterImage;//	Object
	public FrameImages keyFrameImage;//	Object
	public FrameImages productImage;//	Object

	public List<TheTakeProductDetail> compProducts;//	Array
	public List<TheTakeProduct> accessories;//	Array

	public String productBrand;//	String	Etro
	public int tertiaryCategoryId;//	Integer	42
	public boolean verified;//	Boolean	false
	public String mediaDescription;//	String
	public String shortUrl;//	String	thetake.com/LoisScarf
	public int primaryCategoryId;//	Integer	1
	public double frameLetterboxRatio;//	Number	0.12963
	public int mediaId;//	Integer	421
	@SerializedName("unavailable")
	public int isUnavailable;//	Integer	0
	public String characterName;//	String	Lois Lane
	public boolean soldOut;//	Boolean	false
	public String mediaName	;//String	Man of Steel (Full Movie - Theatrical)
	public double trendingScore;//	Integer	10
	public String shareUrl;//	String	https://thetake.com/product/104741/amy-adams-etro-paisley-print-scarf-man-of-steel-full-movie-theatrical
	public int characterId;//	Integer	941
	public int actorId;//	Integer	1078
	public double keyCropProductY;//	Number	0.6167012264556395
	public double keyCropProductX;//	Number	0.3425107458083145
	public String actorName;//	String	Amy Adams
	public String itunesLink;//	String
	public String primaryCategoryName;//	String	Women's Fashion
	public String tertiaryCategoryName;//	String	Scarves
	public String purchaseLink;//	String	http://www.farfetch.com/shopping/item11136152.aspx
	public int secondaryCategoryId;//	Integer	35
	public int productId;//	Integer	104741
	public String keyFrameProductX;//	Number	0.618824
	public int keyFrameTime;//	Integer	3157000
	public String amazonLink;//	String
	public String keyFrameProductY;//	Number	0.48583
	public String secondaryCategoryName;//	String	Accessories
	public String productName;//	String	Paisley Print Scarf
	public String productPrice;//	String	$242.82
	public String fandangoLink;//	String


	public String getProductImage(){
		return productImage.image500px;
	}
}
