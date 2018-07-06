package com.wb.cpedata.model;

import com.wb.cpedata.CPEDataParser;
import com.wb.cpedata.data.manifest.IMEElement;
import com.wb.cpedata.data.manifest.LocationItem;
import com.wb.cpedata.data.manifest.PictureItem;
import com.wb.cpedata.data.manifest.PresentationDataItem;
import com.wb.cpedata.data.manifest.TextItem;
import com.wb.cpedata.util.utils.StringHelper;

import java.util.List;

/**
 * Created by gzcheng on 4/12/16.
 */
public class AVGalleryIMEEngine extends IMEEngine<IMEElement<PresentationDataItem>> {

    public AVGalleryIMEEngine(List<IMEElement<PresentationDataItem>> elements){
        imeElements = elements;
    }

    public int compareCurrentTimeWithItemAtIndex(long timecode, int index){
        return imeElements.get(index).compareTimeCode(timecode);
    }

    public static class IMECombineItem extends PresentationDataItem{
        List<PresentationDataItem> items;
        PictureItem pictureItem;
        TextItem textItem;
        boolean isLocation = false;
        public IMECombineItem(List<PresentationDataItem> items){
            super(null, null, CPEDataParser.getClientLocale());
            this.items = items;
            for(PresentationDataItem pItems : items){
                if (pItems instanceof PictureItem){
                    this.posterImgUrl = ((PictureItem)pItems).thumbnail.url;
                    pictureItem = ((PictureItem)pItems);
                } else if (pItems instanceof TextItem){
                    this.title = ((TextItem)pItems).getTitle();
                    textItem = ((TextItem)pItems);
                } else if (pItems instanceof LocationItem){
                    isLocation = true;
                }
            }

            if (StringHelper.isEmpty(title)){
                if (items != null && items.size() > 0 ){
                    title = items.get(0).getTitle();
                }
            }
        }

        public String getPosterImgUrl(){
            if (StringHelper.isEmpty(posterImgUrl)){
                if (items != null && items.size() > 0 ){
                    posterImgUrl = items.get(0).getPosterImgUrl();
                }
            }
            return posterImgUrl;
        }

        public TextItem getTextItem(){
            return textItem;
        }

        public PictureItem getPictureItem(){
            return  pictureItem;
        }

        public boolean isLocation() {
            return isLocation;
        }

        public List<PresentationDataItem> getAllPresentationItems(){
            return items;
        }
    }


}
