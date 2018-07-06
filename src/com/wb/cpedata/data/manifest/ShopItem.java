package com.wb.cpedata.data.manifest;


import android.content.Context;

import com.wb.cpedata.R;
import com.wb.cpedata.parser.LocalizableMetaDataInterface;
import com.wb.cpedata.parser.appdata.AppDataType;
import com.wb.cpedata.parser.appdata.AppNVPairType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataInfoType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataType;
import com.wb.cpedata.util.Size;
import com.wb.cpedata.util.utils.StringHelper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class ShopItem extends PresentationDataItem implements ShopItemInterface, Serializable {
	//public final boolean isFrictional;
	public  String contentId;
	//public final ContentMetaData longitude;
	public  int displayOrder;
	public  String externalUrl;

	public  String titleDisplayUnlimited;
	public  String titleSort;
	public  String posterUrl;
	public  String summary;
	public Size posterSize;

	public  String workType;
	public  String releaseYear;

	String videoPresentationId = null;
	String videoContentId = null;

	public InventoryMetadataType categoryType;

	AudioVisualItem avItem;

	public String getShopItemText(Context context){
		return context.getResources().getString(R.string.shop_online);
	}

	public long getProductId(){
		return -1;
	}


	public String getProductReportId(){
		if (!StringHelper.isEmpty(titleSort))
			return titleSort;
		else
			return titleDisplayUnlimited;
	}

	public ShopItem(String id, HashMap<String, AppDataType> appDataMap, HashMap<String, InventoryMetadataType> metadataTypeHashMap, Locale locale ){
		super(id, "", null, locale);
		String cid = "";
		int order = 0;
		String url = "";

		String titleDisplayUnlimited = "";
		String titleSort = "";
		String posterUrl = "";
		String summary = "";
		Size posterSize = null;

		String parentContentId;

		String workType = "";
		String releaseYear = "";
		InventoryMetadataType categoryType = null;

		AppDataType appDataType = appDataMap.get(id);

		if (appDataType != null && appDataType.getNVPair() != null && appDataType.getNVPair().size() > 0){
			for (AppNVPairType pair : appDataType.getNVPair()){
				if (pair.getName().equalsIgnoreCase(MovieMetaData.ITEM_CONTENT_ID))
					cid = pair.getContentID();
				else if (pair.getName().equalsIgnoreCase(MovieMetaData.ITEM_DISPLAY_ORDER))
					order = pair.getInteger().intValue();
				else if (pair.getName().endsWith(MovieMetaData.ITEM_EXTERNAL_URL))
					url = pair.getURL();
				else if (pair.getName().equalsIgnoreCase(MovieMetaData.ITEM_PRODUCT_VIDEO)) {
					videoPresentationId = pair.getPresentationID();
				}else if (pair.getName().equalsIgnoreCase(MovieMetaData.ITEM_PRODUCT_VIDEO_CID))
					videoContentId = pair.getContentID();
				else if (pair.getName().endsWith(MovieMetaData.ITEM_PARENT_CID)) {
					parentContentId = pair.getContentID();
					categoryType = metadataTypeHashMap.get(parentContentId);
				}

			}
		}

		if (!StringHelper.isEmpty(cid)){
			InventoryMetadataType metadata = metadataTypeHashMap.get(cid);
			BasicMetadataType basicMetadata = metadata.getBasicMetadata();
			if (basicMetadata != null){
				if (basicMetadata.getLocalizedInfo() != null && basicMetadata.getLocalizedInfo().size() > 0){
					BasicMetadataInfoType localizedInfo = MovieMetaData.getMatchingLocalizableObject(basicMetadata.getLocalizedInfo(), locale);
					titleDisplayUnlimited = localizedInfo.getTitleDisplayUnlimited();
					titleSort = localizedInfo.getTitleSort();
					posterUrl = localizedInfo.getArtReference().size() > 0 ? localizedInfo.getArtReference().get(0).getValue() : "";
					if (localizedInfo.getSummary4000() != null){
						summary = localizedInfo.getSummary4000().getValue();
					} else if (localizedInfo.getSummary400() != null){
						summary = localizedInfo.getSummary400().getValue();
					} else if (localizedInfo.getSummary190() != null)
						summary = localizedInfo.getSummary190().getValue();

					String dimensionStr = localizedInfo.getArtReference().size() > 0 ? localizedInfo.getArtReference().get(0).getResolution() : "";
					try {
						StringTokenizer tokenizer = new StringTokenizer(dimensionStr, "X");
						posterSize = new Size(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
					}catch (Exception ex){

					}
				}

				if (basicMetadata.getReleaseYear() != null){
					releaseYear = basicMetadata.getReleaseYear();
				}

				if (basicMetadata.getWorkType() != null){
					workType = basicMetadata.getWorkType();
				}

			}
		}

		this.titleDisplayUnlimited = titleDisplayUnlimited;
		this.titleSort = titleSort;
		this.posterUrl = posterUrl;
		this.posterSize = posterSize;
		this.summary = summary;
		contentId = cid;
		displayOrder = order;
		externalUrl = url;
		this.workType = workType;
		this.releaseYear = releaseYear;
		this.categoryType = categoryType;
	}

	public AudioVisualItem getAVItem(){
		return avItem;
	}

	public String getPosterImgUrl(){
		return posterUrl;
	}

	public String getTitle(){
		return titleDisplayUnlimited;
	}


	public String getThumbnailUrl(){
		return posterUrl;
	}

	public String getProductThumbnailUrl(){
		return posterUrl;
	}

	public String getProductName(){
		return titleDisplayUnlimited;
	}

	public String getProductBrand(){
		return summary;
	}

	public boolean isVerified(){
		return true;
	}

	public float getKeyCropProductY(){
		return -1f;
	}

	public float getKeyCropProductX(){
		return -1f;
	}

	public String getShareLinkUrl(){
		return "";
	}

	public String getPurchaseLinkUrl(){
		return externalUrl;
	}
}
