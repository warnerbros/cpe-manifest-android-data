package com.wb.cpedata.data.manifest;

import com.wb.cpedata.data.style.ExperienceStyle;
import com.wb.cpedata.data.style.NodeStyleData;
import com.wb.cpedata.data.style.StyleData;
import com.wb.cpedata.data.style.ThemeData;
import com.wb.cpedata.model.AVGalleryIMEEngine;
import com.wb.cpedata.model.IMEEngine;
import com.wb.cpedata.parser.LocalizableMetaDataInterface;
import com.wb.cpedata.parser.ManifestXMLParser;
import com.wb.cpedata.parser.appdata.AppDataLocationType;
import com.wb.cpedata.parser.appdata.AppDataType;
import com.wb.cpedata.parser.appdata.AppNVPairType;
import com.wb.cpedata.parser.appdata.ManifestAppDataSetType;
import com.wb.cpedata.parser.cpestyle.CPEStyleSetType;
import com.wb.cpedata.parser.cpestyle.ExperienceMenuMapType;
import com.wb.cpedata.parser.cpestyle.NodeStyleType;
import com.wb.cpedata.parser.cpestyle.ThemeType;
import com.wb.cpedata.parser.manifest.schema.v1_4.AppGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.AudiovisualClipRefType;
import com.wb.cpedata.parser.manifest.schema.v1_4.AudiovisualType;
import com.wb.cpedata.parser.manifest.schema.v1_4.ExperienceAppType;
import com.wb.cpedata.parser.manifest.schema.v1_4.ExperienceChildType;
import com.wb.cpedata.parser.manifest.schema.v1_4.ExperienceType;
import com.wb.cpedata.parser.manifest.schema.v1_4.GalleryType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryAudioType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryImageType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryInteractiveType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryMetadataType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryTextObjectType;
import com.wb.cpedata.parser.manifest.schema.v1_4.InventoryVideoType;
import com.wb.cpedata.parser.manifest.schema.v1_4.MediaManifestType;
import com.wb.cpedata.parser.manifest.schema.v1_4.OtherIDType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PictureType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PlayableSequenceListType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PlayableSequenceType;
import com.wb.cpedata.parser.manifest.schema.v1_4.PresentationType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TextGroupType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TimecodeType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TimedEventSequenceType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TimedEventType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TrackMetadataType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataPeopleType;
import com.wb.cpedata.parser.md.schema.v2_3.ContentIdentifierType;
import com.wb.cpedata.parser.md.schema.v2_3.RegionType;
import com.wb.cpedata.util.utils.StringHelper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by gzcheng on 3/21/16.
 */
public class MovieMetaData {

	final public static String THE_TAKE_MANIFEST_IDENTIFIER = "thetake.com";
    final public static String BASELINE_NAMESPACE = "baselineapi.com";
    final public static String SHARE_CLIP_KEY = "clipshare";
	final public static String SHARE_CLIP_SUBTYPE = "Shareable Clip";

    final public static String MAIN_SUBTYPE = "Main";

    final public static String OTHER_APP_DATA_ID = "AppID";
    final public static String OTHER_PEOPLE_ID = "PeopleOtherID";

    final static String ITEM_DISPLAY_ORDER = "display_order";
    final static String ITEM_TYPE = "type";
    final static String ITEM_LOCATION = "location";
    final static String ITEM_ZOOM = "zoom";
    final static String ITEM_TEXT = "text";
    final static String ITEM_VIDEO_ID = "video_id";
    final static String ITEM_VIDEO_THUMBNAIL = "video_thumbnail";
    final static String ITEM_LOCATION_THUMBNAIL = "location_thumbnail";
    final static String ITEM_GALLERY_ID = "gallery_id";
    final static String ITEM_GALLERY_THUMBNAIL = "gallery_thumbnail";
    final static String ITEM_EXPERIENCE_ID = "experience_id";
    final static String ITEM_PRODUCT_VIDEO = "product_video";
    final static String ITEM_PRODUCT_VIDEO_CID = "product_video_content_id";


    final static String ITEM_CONTENT_ID = "content_id";
    final static String ITEM_EXTERNAL_URL = "external_url";
    final static String ITEM_PARENT_CID = "parent_content_id";

    final static String NVPAIR_TYPE = "type";
    final static String NVPAIR_TYPE_PRODUCT = "PRODUCT";

    //final private List<ECGroupData> movieExperiences = new ArrayList<ECGroupData>();
    final private List<ExperienceData> extraECGroups = new ArrayList<ExperienceData>();
    final private List<ExperienceData> imeECGroups = new ArrayList<ExperienceData>();
    final private List<IMEElementsGroup> imeElementGroups = new ArrayList<IMEElementsGroup>();

    final private HashMap<String, ExperienceData> experienceIdToExperienceMap = new HashMap<String, ExperienceData>();
    final private HashMap<String, ShopItem> appIdToShopItemMap = new HashMap<>();

    private ExperienceData rootExperience;
    private boolean hasCalledBaselineAPI = false;

    private List<List<IMEElement<CastData>>> castIMEElements = new ArrayList<List<IMEElement<CastData>>>() ;

    private HashMap<String, ExperienceStyle> experienceStyleMap = new HashMap<String, ExperienceStyle>();

    final static public String movieTitleText = "Man of Steel";

    private IMEElementsGroup shareClipIMEElementGroup = null;

    public String getMainMovieUrl(){
        if (rootExperience != null && rootExperience.audioVisualItems.size() > 0){
            return rootExperience.audioVisualItems.get(0).getVideoUrl();
        }
        return "";
    }

    public String getMoiveId(){
        if (rootExperience != null)
            return rootExperience.experienceId;
        else
            return "";
    }

    public ShopItem getShopItemByAppId(String appId){
        return appIdToShopItemMap.get(appId);
    }

    final List<CastData> allCastsList = new ArrayList<CastData>();


    final private List<CastGroup> castGroupsList = new ArrayList<CastGroup>();

    private void addCastToGroup(CastData castData){
        allCastsList.add(castData);
        for (CastGroup group: castGroupsList){
            if (group.groupJob.equals(castData.job)){
                group.castsList.add(castData);
                return;
            }
        }
        CastGroup newGroup = new CastGroup(castData.job);
        newGroup.castsList.add(castData);
        castGroupsList.add(newGroup);
    }

    private void sortCastGroups(){
        for (CastGroup group: castGroupsList) {
            Collections.sort(group.castsList, new Comparator<CastData>() {
                @Override
                public int compare(CastData lhs, CastData rhs) {
                    return (int) (lhs.order - rhs.order);
                }
            });
        }
    }

    public CastGroup getCastGroupByTitle(String title){
        if (castGroupsList.size() > 0) {
            if (StringHelper.isEmpty(title)){
                return castGroupsList.get(0);
            }
            for (CastGroup group : castGroupsList) {
                if (group.getGroupTitle().equals(title)) {
                    return group;
                }
            }
        }
        return null;
    }

    public String findJobByCastGroupName(String castGroupName) {
        for (CastGroup group : castGroupsList) {
            if (group.getGroupTitle().equals(castGroupName)) {
                return group.groupJob;
            }
        }
        return "";
    }

    public List<CastGroup> getCastGroups(){
        return castGroupsList;
    }

    public List<CastData> getAllCastsList(){
        return allCastsList;
    }

    public static MovieMetaData process(ManifestXMLParser.NextGenManifestData manifest){

        MediaManifestType mediaManifest = manifest.mainManifest;
        ManifestAppDataSetType appDataManifest = manifest.appDataManifest;
        CPEStyleSetType styleSetType = manifest.cpeStyle;

        MovieMetaData result = new MovieMetaData();

        HashMap<String, InventoryMetadataType> metaDataAssetsMap = new HashMap<String, InventoryMetadataType>();
        HashMap<String, InventoryVideoType> videoAssetsMap = new HashMap<String, InventoryVideoType>();
        HashMap<String, InventoryAudioType> audioAssetsMap = new HashMap<String, InventoryAudioType>();
        HashMap<String, PresentationType> presentationAssetMap = new HashMap<String, PresentationType>();
        HashMap<String, PictureImageData> pictureImageMap = new HashMap<String, PictureImageData>();
        HashMap<String, InventoryInteractiveType> inventoryAssetsMap = new HashMap<String, InventoryInteractiveType>();
        HashMap<String, PictureGroupType> pictureGroupAssetsMap = new HashMap<String, PictureGroupType>();
        HashMap<String, PictureType> pictureTypeAssetsMap = new HashMap<String, PictureType>();
        HashMap<String, AudioVisualItem> presentationIdToAVItemMap = new HashMap<String, AudioVisualItem>();
        HashMap<String, ECGalleryItem> galleryIdToGalleryItemMap = new HashMap<String, ECGalleryItem>();
        HashMap<String, HashMap<BigInteger, String>> indexToTextMap = new HashMap<>();

        HashMap<String, AppGroupType> appGroupIdToAppGroupMap = new HashMap<String, AppGroupType>();

        HashMap<String, ExperienceData> timeSequenceIdToECGroup = new HashMap<String, ExperienceData>();

        HashMap<String, CastData> peopleIdToCastData = new HashMap<String, CastData>();

        HashMap<String, PlayableSequenceType> playableSequenceTypeHashMap = new HashMap<String, PlayableSequenceType>();


        HashMap<String, List<ExperienceData>> experienceChildrenToParentMap = new HashMap<String, List<ExperienceData>>();
        HashMap<String, AppDataType> appDataIdTpAppDataMap = new HashMap<String, AppDataType>();

        HashMap<String, LocationItem> appIdToLocationItemMap = new HashMap<>();

        List<ShopItem> shopItemsWithVideo = new ArrayList<>();

        String castTSId = null;

        String mainMovieExperienceId = mediaManifest.getALIDExperienceMaps().getALIDExperienceMap().get(0).getExperienceID().get(0).getValue();


        if (mediaManifest.getInventory() != null){
            if (mediaManifest.getInventory().getMetadata().size() > 0) {
                for (InventoryMetadataType metaData : mediaManifest.getInventory().getMetadata()){
                    metaDataAssetsMap.put(metaData.getContentID(), metaData);
                }
            }

            if (mediaManifest.getInventory().getVideo().size() > 0){
                for (InventoryVideoType videoData : mediaManifest.getInventory().getVideo()){
                    videoAssetsMap.put(videoData.getVideoTrackID(), videoData);
                }
            }

            if (mediaManifest.getInventory().getAudio().size() > 0){
                for (InventoryAudioType audioData : mediaManifest.getInventory().getAudio()){
                    audioAssetsMap.put(audioData.getAudioTrackID(), audioData);
                }
            }

            if (mediaManifest.getInventory().getImage().size() > 0){
                for (InventoryImageType imageData : mediaManifest.getInventory().getImage()){
                    PictureImageData pictureImageData = new PictureImageData(imageData);
                    pictureImageMap.put(pictureImageData.imageId, pictureImageData);
                }
            }

            if (mediaManifest.getInventory().getInteractive() != null && mediaManifest.getInventory().getInteractive().size() > 0){
                for (InventoryInteractiveType interactiveData : mediaManifest.getInventory().getInteractive()){
                    inventoryAssetsMap.put(interactiveData.getInteractiveTrackID(), interactiveData);
                }
            }

            if (mediaManifest.getPlayableSequences() != null && mediaManifest.getPlayableSequences().getPlayableSequence() != null && mediaManifest.getPlayableSequences().getPlayableSequence().size() > 0){
                for (PlayableSequenceListType.PlayableSequence playableSequence : mediaManifest.getPlayableSequences().getPlayableSequence()){
                    playableSequenceTypeHashMap.put(playableSequence.getPlayableSequenceID(), playableSequence);
                }
            }
        }

        if (mediaManifest.getAppGroups() != null && mediaManifest.getAppGroups().getAppGroup().size() > 0){
            for(AppGroupType appGroup : mediaManifest.getAppGroups().getAppGroup()){
                appGroupIdToAppGroupMap.put(appGroup.getAppGroupID(), appGroup);
            }
        }

        if (mediaManifest.getPresentations().getPresentation().size() > 0){
            for(PresentationType presentation : mediaManifest.getPresentations().getPresentation()){
                presentationAssetMap.put(presentation.getPresentationID(), presentation);
            }
        }

        if (mediaManifest.getPictureGroups().getPictureGroup().size() > 0){
            for(PictureGroupType pictureGroup : mediaManifest.getPictureGroups().getPictureGroup()){
                pictureGroupAssetsMap.put(pictureGroup.getPictureGroupID(), pictureGroup);
                if (pictureGroup.getPicture() != null && pictureGroup.getPicture().size() > 0){
                    for (PictureType picture : pictureGroup.getPicture()){
                        pictureTypeAssetsMap.put(picture.getPictureID(), picture);
                    }
                }
            }
        }

        HashMap<String, String> textObjectIdToTextGroupId = new HashMap<String, String>();
        if (mediaManifest.getTextGroups() != null && mediaManifest.getTextGroups().getTextGroup() != null && mediaManifest.getTextGroups().getTextGroup().size() > 0 ){
            for (TextGroupType textGroupType : mediaManifest.getTextGroups().getTextGroup()){
                if (textGroupType.getTextObjectID() != null && textGroupType.getTextObjectID().size() > 0){
                    textObjectIdToTextGroupId.put(textGroupType.getTextObjectID().get(0), textGroupType.getTextGroupID());
                }
            }
        }

        if (mediaManifest.getInventory().getTextObject()!= null && mediaManifest.getInventory().getTextObject().size() > 0){

            if (mediaManifest.getInventory().getTextObject().size() > 0){
                for (InventoryTextObjectType textObjectType : mediaManifest.getInventory().getTextObject()){
                    HashMap<BigInteger, String> textMap = new HashMap<BigInteger, String>();
                    String textGroupId = textObjectIdToTextGroupId.get(textObjectType.getTextObjectID());
                    indexToTextMap.put(textGroupId, textMap);

                    for (int i = 0 ; i< textObjectType.getTextString().size(); i++){
                        if (textObjectType.getTextString().get(i).getIndex() == null){
                            textMap.put(BigInteger.valueOf(i + 1), textObjectType.getTextString().get(i).getValue());
                        }else {
                            textMap.put(textObjectType.getTextString().get(i).getIndex(), textObjectType.getTextString().get(i).getValue());
                        }
                    }
                }
            }
        }

        if (appDataManifest != null && appDataManifest.getManifestAppData() != null && appDataManifest.getManifestAppData().size() > 0){
            for (AppDataType appData : appDataManifest.getManifestAppData()){
                appDataIdTpAppDataMap.put(appData.getAppID(), appData);
            }
        }

        if (styleSetType != null) {

            HashMap<String, ThemeData> themeDataHashMap = new HashMap<>();
            if (styleSetType.getTheme() != null && styleSetType.getTheme().size() > 0){
                for (ThemeType theme : styleSetType.getTheme()) {
                    ThemeData themeData = new ThemeData(theme, pictureImageMap);
                    themeDataHashMap.put(theme.getThemeID(), themeData);
                }
            }

            HashMap<String, NodeStyleData> nodeStyleTypeHashMap = new HashMap<>();
            if (styleSetType.getNodeStyle() != null && styleSetType.getNodeStyle().size() > 0) {
                for (NodeStyleType nodeStyle : styleSetType.getNodeStyle()){
                    NodeStyleData thisStyle = new NodeStyleData(nodeStyle, themeDataHashMap,
                            pictureGroupAssetsMap, pictureImageMap, presentationAssetMap, videoAssetsMap, audioAssetsMap);
                    nodeStyleTypeHashMap.put(thisStyle.nodeStyleId, thisStyle);
                }
            }

            if (styleSetType.getExperienceStyleMap() != null && styleSetType.getExperienceStyleMap().size() > 0) {
                for (ExperienceMenuMapType menuMapType : styleSetType.getExperienceStyleMap()) {
                    ExperienceStyle experienceStyle = new ExperienceStyle(menuMapType, nodeStyleTypeHashMap);
                    result.experienceStyleMap.put(experienceStyle.getExperienceId(), experienceStyle);
                }
            }
        }

        /**************Experiences ***************/
        if (mediaManifest.getExperiences() != null && mediaManifest.getExperiences().getExperience() != null) {

            //List<ExperienceType> exprienceParentList = new ArrayList<ExperienceType>();
            ExperienceData rootData = null;


            for (ExperienceType experience : mediaManifest.getExperiences().getExperience()) {
                List<ECGalleryItem> galleryItems = new ArrayList<ECGalleryItem>();
                List<AudioVisualItem> avItems = new ArrayList<AudioVisualItem>();
                List<LocationItem> locationItems = new ArrayList<LocationItem>();
                List<ShopItem> shopItems = new ArrayList<ShopItem>();
                List<InteractiveItem> interactiveItems = new ArrayList<InteractiveItem>();
                boolean isRootExperience = false;
                String subtype = null;
                InventoryMetadataType experienceMetaData = metaDataAssetsMap.get(experience.getContentID());

                boolean bShouldExcludeThisExp = false;
                try {
                    if (experience.getExcludedRegion() != null && experience.getExcludedRegion().size() > 0) {
                        for (RegionType regionType : experience.getExcludedRegion()) {
                            if (regionType.getCountry().equals(manifest.locale.getCountry())) {
                                bShouldExcludeThisExp = true;
                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                }

                if (!bShouldExcludeThisExp) {

                    if (experience.getExperienceID().contains(SHARE_CLIP_KEY))
                        subtype = SHARE_CLIP_KEY;

                    if (experience.getGallery() != null && experience.getGallery().size() > 0) {
                        for (GalleryType gallery : experience.getGallery()) {
                            String pictureGroupId = gallery.getPictureGroupID();
                            PictureGroupType pictureGroup = pictureGroupAssetsMap.get(pictureGroupId);
                            InventoryMetadataType galleryMataData = metaDataAssetsMap.get(gallery.getContentID());
                            List<PictureItem> pictureItems = new ArrayList<PictureItem>();
                            if (pictureGroup != null) {
                                for (PictureType picture : pictureGroup.getPicture()) {
                                    PictureImageData fullImageData = pictureImageMap.get(picture.getImageID());
                                    PictureImageData thumbNailImageData = pictureImageMap.get(picture.getThumbnailImageID());
                                    PictureItem pictureItem = new PictureItem(experience.getExperienceID(), galleryMataData, fullImageData, thumbNailImageData, manifest.locale);
                                    pictureItems.add(pictureItem);
                                }
                            }

                            if (gallery.getSubType() != null && gallery.getSubType().size() > 0) {
                                subtype = gallery.getSubType().get(0);
                            }

                            ECGalleryItem thisItem = new ECGalleryItem(experience.getExperienceID(), gallery.getGalleryID(), galleryMataData, pictureItems, subtype, manifest.locale);
                            galleryItems.add(thisItem);

                            galleryIdToGalleryItemMap.put(gallery.getGalleryID(), thisItem);
                        }
                    }

                    if (experience.getAudiovisual() != null) {
                        if (experience.getAudiovisual().size() > 0) {                           // for video Asset
                            for (AudiovisualType audioVisual : experience.getAudiovisual()) {
                                if (MAIN_SUBTYPE.equalsIgnoreCase(audioVisual.getType()))       // root experience check
                                    isRootExperience = true;

                                InventoryMetadataType avMetaData = metaDataAssetsMap.get(audioVisual.getContentID());        // get Video asset by ContentID of its AudioVisual
                                List<ExternalApiData> externalApiDatas = new ArrayList<ExternalApiData>();
                                if (avMetaData.getBasicMetadata() != null && avMetaData.getBasicMetadata().getAltIdentifier() != null) {
                                    for (ContentIdentifierType identifier : avMetaData.getBasicMetadata().getAltIdentifier()) {
                                        externalApiDatas.add(new ExternalApiData(identifier.getNamespace(), identifier.getIdentifier()));
                                    }
                                }

                                if (avMetaData.getBasicMetadata() != null && avMetaData.getBasicMetadata().getPeople() != null && avMetaData.getBasicMetadata().getPeople().size() > 0) {
                                    for (BasicMetadataPeopleType people : avMetaData.getBasicMetadata().getPeople()) {
                                        CastData cast = new CastData(people, manifest.locale);

                                        if (!StringHelper.isEmpty(cast.getAppDataId())){
                                            AppDataType appDataType = appDataIdTpAppDataMap.get(cast.getAppDataId());
                                            cast.fillCastDataWithAppData(appDataType, pictureTypeAssetsMap, pictureImageMap);


                                        }

                                        if (!StringHelper.isEmpty(cast.getOtherPeopleId()))
                                            peopleIdToCastData.put(cast.getOtherPeopleId(), cast);

                                        result.addCastToGroup(cast);
                                    }
                                    result.sortCastGroups();
                                }

                                List<String> presentationIds = new ArrayList<>();
                                if (!StringHelper.isEmpty(audioVisual.getPresentationID())) {
                                    presentationIds.add(audioVisual.getPresentationID());
                                }

                                if (presentationIds.size() == 0 && !StringHelper.isEmpty(audioVisual.getPlayableSequenceID())) {
                                    PlayableSequenceType playableSequenceType = playableSequenceTypeHashMap.get(audioVisual.getPlayableSequenceID());
                                    if (playableSequenceType != null && playableSequenceType.getClip() != null && playableSequenceType.getClip().size() > 0) {
                                        for (AudiovisualClipRefType clipRefType : playableSequenceType.getClip()) {
                                            presentationIds.add(clipRefType.getPresentationID());

                                        }
                                    }
                                }


                                for (String presentationId : presentationIds) {
                                    List<AudioVisualTrack> tracks = new ArrayList<>();
                                    boolean isValidAVItem = false;
                                    if (!StringHelper.isEmpty(presentationId)) {
                                        PresentationType presentation = presentationAssetMap.get(presentationId);  // get Presentation by presentation id
                                        if (presentation.getTrackMetadata() != null && presentation.getTrackMetadata().size() > 0) {
                                            for (TrackMetadataType trackMetadataType : presentation.getTrackMetadata()) {

                                                InventoryVideoType video = null;
                                                InventoryAudioType audio = null;

                                                if (trackMetadataType.getVideoTrackReference() != null &&
                                                        trackMetadataType.getVideoTrackReference().size() > 0 &&
                                                        trackMetadataType.getVideoTrackReference().get(0).getVideoTrackID().size() > 0)                                          // get the video id from presentation
                                                    video = videoAssetsMap.get(trackMetadataType.getVideoTrackReference().get(0).getVideoTrackID().get(0));
                                                if (trackMetadataType.getAudioTrackReference() != null &&
                                                        trackMetadataType.getAudioTrackReference().size() > 0 &&
                                                        trackMetadataType.getAudioTrackReference().get(0).getAudioTrackID().size() > 0)                                          // get the video id from presentation
                                                    audio = audioAssetsMap.get(trackMetadataType.getAudioTrackReference().get(0).getAudioTrackID().get(0));
                                                if (video != null) {
                                                    isValidAVItem = true;
                                                }
                                                tracks.add(new AudioVisualTrack(video, audio));
                                            }


                                        }
                                    }

                                    if (!StringHelper.isEmpty(presentationId) && tracks.size() > 0 && isValidAVItem) {
                                        //ExperienceData ecData = new ExperienceData(experience, metaData, video, null);
                                        if (audioVisual.getSubType() != null && audioVisual.getSubType().size() > 0)
                                            subtype = audioVisual.getSubType().get(0);
                                        AudioVisualItem item = new AudioVisualItem(experience.getExperienceID(), audioVisual.getPresentationID(), avMetaData, tracks, externalApiDatas, subtype, manifest.locale);
                                        avItems.add(item);
                                        presentationIdToAVItemMap.put(presentationId, item);
                                    }
                                }

                            }
                        }
                    }

                    if (experience.getApp() != null && experience.getApp().size() > 0) {   // scene locations
                        List<ExperienceAppType> appList = experience.getApp();
                        for (ExperienceAppType appType : appList) {
                            String appId = appType.getAppID();
                            String appGroupId = appType.getAppGroupID();

                            if (!StringHelper.isEmpty(appId)) {     // appData

                                if (isShopItem(appDataIdTpAppDataMap.get(appId))) {
                                    ShopItem shopItem = getShopItemFromMap(result.appIdToShopItemMap, appDataIdTpAppDataMap, metaDataAssetsMap, appId, manifest.locale);
                                    if (shopItem != null)
                                        shopItems.add(shopItem);
                                    if (!StringHelper.isEmpty(shopItem.videoPresentationId) && !shopItemsWithVideo.contains(shopItem)){
                                        shopItemsWithVideo.add(shopItem);
                                    }
                                } else {
                                    LocationItem locationItem = getLocationItemfromMap(appIdToLocationItemMap, appDataIdTpAppDataMap, pictureImageMap, result.experienceIdToExperienceMap, appId, manifest.locale);
                                    if (locationItem != null)
                                        locationItems.add(locationItem);
                                }
                            } else if (!StringHelper.isEmpty(appGroupId)) {      // interactive
                                AppGroupType appGroupType = appGroupIdToAppGroupMap.get(appGroupId);
                                InteractiveItem interactiveItem = new InteractiveItem(appGroupType, inventoryAssetsMap);
                                interactiveItems.add(interactiveItem);
                            }
                        }

                    }

                    if (experience.getTimedSequenceID() != null) {

                    }

                    ExperienceStyle expStyle = result.experienceStyleMap.containsKey(experience.getExperienceID()) ?
                            result.experienceStyleMap.get(experience.getExperienceID()) : null;
                    ExperienceData thisExperience = new ExperienceData(experience, experienceMetaData, avItems, galleryItems, locationItems, shopItems, interactiveItems, expStyle);


                    result.experienceIdToExperienceMap.put(experience.getExperienceID(), thisExperience);
                    List<ExperienceData> parentGroups = experienceChildrenToParentMap.get(experience.getExperienceID());
                    if (parentGroups != null && parentGroups.size() > 0) {
                        for (ExperienceData parentGroup : parentGroups) {
                            parentGroup.addChild(thisExperience);
                        }
                    }

                    if (isRootExperience) {
                        rootData = thisExperience;
                    }
                    if (experience.getTimedSequenceID() != null && experience.getTimedSequenceID().size() > 0 && !StringHelper.isEmpty(experience.getTimedSequenceID().get(0))) {
                        timeSequenceIdToECGroup.put(experience.getTimedSequenceID().get(0), thisExperience);
                    }

                    if (experience.getExperienceChild() != null && experience.getExperienceChild().size() > 0) {
                        for (ExperienceChildType child : experience.getExperienceChild()) {
                            if (result.experienceIdToExperienceMap.containsKey(child.getExperienceID())) {   // if child experience has already been created.
                                thisExperience.addChild(result.experienceIdToExperienceMap.get(child.getExperienceID()));
                            } else if (experienceChildrenToParentMap.containsKey(child.getExperienceID())) {  // if child exp has not been created, but children list in the hash table already exist
                                List<ExperienceData> parents = experienceChildrenToParentMap.get(child.getExperienceID());
                                parents.add(thisExperience);
                            } else {                    // if the children list has not been created in the hash table yet
                                List<ExperienceData> parents = new ArrayList<ExperienceData>();
                                parents.add(thisExperience);
                                experienceChildrenToParentMap.put(child.getExperienceID(), parents);    //skip these IDs when encounter.

                            }
                        }
                    }

                }

            }
            if (rootData != null && rootData.childrenExperience.size() == 2) {
                result.extraECGroups.addAll(rootData.childrenExperience.get(0).childrenExperience);
                for (ExperienceData exp : result.extraECGroups) {
                    if (exp.getECGroupType() == MovieMetaData.ECGroupType.LOCATIONS) {
                        exp.computeSceneLocationFeature();
                    }
                }
                result.imeECGroups.addAll(rootData.childrenExperience.get(1).childrenExperience);
                result.rootExperience = rootData;
                if (rootData.audioVisualItems != null && rootData.audioVisualItems.size() > 0) {
                    String inter = rootData.audioVisualItems.get(0).getVideoUrl();
                }
            }

        }

        /*****************End of Experiences****************************/

        /*****************Time Sequence Events****************************/
        if (mediaManifest.getTimedEventSequences() != null && mediaManifest.getTimedEventSequences().getTimedEventSequence().size() > 0){
            for (TimedEventSequenceType timedEventSequence : mediaManifest.getTimedEventSequences().getTimedEventSequence()){
                ExperienceData timedECGroup = null;
                boolean isCast = false;
                if (timeSequenceIdToECGroup.containsKey(timedEventSequence.getTimedSequenceID())){
                    timedECGroup = timeSequenceIdToECGroup.get(timedEventSequence.getTimedSequenceID());
                }
                if (timedECGroup != null) {
                    IMEElementsGroup imeGroup = new IMEElementsGroup(timedECGroup);     // need to figure out the type of this group
                    String presentationId = timedEventSequence.getPresentationID(); // this should be the main movie presentation ID
                    if (timedEventSequence.getTimedEvent() != null && timedEventSequence.getTimedEvent().size() > 0) {
                        for (int i = 0; i < timedEventSequence.getTimedEvent().size(); i++) {
                            TimedEventType timedEvent = timedEventSequence.getTimedEvent().get(i);

                            TimecodeType startTimeCode = timedEvent.getStartTimecode();
                            TimecodeType endTimeCode = timedEvent.getEndTimecode();
                            float startTime = Float.parseFloat(startTimeCode.getValue()) * 1000F;
                            float endTime = Float.parseFloat(endTimeCode.getValue()) * 1000F;

                            String eventPID = timedEvent.getPresentationID();
                            String galleryId = timedEvent.getGalleryID();
                            String pictureID = timedEvent.getPictureID();
                            OtherIDType otherID = timedEvent.getOtherID();
                            String initialization = timedEvent.getInitialization();

                            TimedEventType.TextGroupID textGroupId = timedEvent.getTextGroupID();

                            PresentationDataItem presentationData = null;
                            if (!StringHelper.isEmpty(eventPID)) {
                                if (presentationIdToAVItemMap.containsKey(eventPID)) {
                                    presentationData = presentationIdToAVItemMap.get(eventPID);

                                }
                            } else if (!StringHelper.isEmpty(galleryId)) {
                                if (galleryIdToGalleryItemMap.containsKey(galleryId)) {
                                    presentationData = galleryIdToGalleryItemMap.get(galleryId);

                                }
                            } else if (textGroupId != null && !StringHelper.isEmpty(textGroupId.getValue())) {
                                BigInteger index = textGroupId.getIndex();
                                if (indexToTextMap.containsKey(textGroupId.getValue())) {
                                    String triviaText = indexToTextMap.get(textGroupId.getValue()).get(index);
                                    if (!StringHelper.isEmpty(initialization)) {                 //this is trivia
                                        PictureType picture = pictureTypeAssetsMap.get(initialization);
                                        PictureImageData fullImageData = pictureImageMap.get(picture.getImageID());
                                        PictureImageData thumbNailImageData = pictureImageMap.get(picture.getThumbnailImageID());

                                        presentationData = new TriviaItem(textGroupId.getValue(), index, triviaText, fullImageData, thumbNailImageData, manifest.locale);
                                    } else
                                        presentationData = new TextItem(index, triviaText, manifest.locale);
                                }
                            } else if (!StringHelper.isEmpty(pictureID)) {
                                PictureType picture = pictureTypeAssetsMap.get(pictureID);
                                PictureImageData fullImageData = pictureImageMap.get(picture.getImageID());
                                PictureImageData thumbNailImageData = pictureImageMap.get(picture.getThumbnailImageID());
                                //String imageText= picture.getAlternateText()
                                presentationData = new PictureItem(null, null, fullImageData, thumbNailImageData, manifest.locale);
                            } else if (otherID != null) {
                                if (isShopItem(appDataIdTpAppDataMap.get(otherID.getIdentifier()))) {
                                    presentationData = getShopItemFromMap(result.appIdToShopItemMap, appDataIdTpAppDataMap, metaDataAssetsMap, otherID.getIdentifier(), manifest.locale);
                                    //presentationData = new ShopItem(otherID.getIdentifier(), appDataIdTpAppDataMap, metaDataAssetsMap, manifest.locale);

                                    if (!StringHelper.isEmpty(((ShopItem)presentationData).videoPresentationId) && !shopItemsWithVideo.contains(((ShopItem)presentationData))){
                                        shopItemsWithVideo.add(((ShopItem)presentationData));
                                    }

                                } else if (OTHER_APP_DATA_ID.equals(otherID.getNamespace())) {
                                    String locationId = otherID.getIdentifier();

                                    presentationData = getLocationItemfromMap(appIdToLocationItemMap, appDataIdTpAppDataMap, pictureImageMap, result.experienceIdToExperienceMap, locationId, manifest.locale);

                                } else if (OTHER_PEOPLE_ID.equals(otherID.getNamespace())) {
                                    isCast = true;
                                    CastData cast = peopleIdToCastData.get(otherID.getIdentifier());
                                    presentationData = cast;
                                }
                            }


                            if (timedEvent.getProductID() != null) {
                                ExternalApiData data = new ExternalApiData(timedEvent.getProductID().getNamespace(), timedEvent.getProductID().getIdentifier());
                                imeGroup.setExtenralApiData(data);
                            }

                            if (presentationData != null) {
                                IMEElement<PresentationDataItem> element = new IMEElement((long) startTime, (long) endTime, presentationData, i);
                                imeGroup.addElement(element);
                            }

                        }
                    }
                    Collections.sort(imeGroup.imeElementsList, new Comparator<IMEElement>() {
                        @Override
                        public int compare(IMEElement lhs, IMEElement rhs) {

                            return (int) (lhs.startTimecode - rhs.startTimecode);
                        }
                    });


                    if (isCast) {
                        castTSId = timedEventSequence.getTimedSequenceID();
                        result.reGroupCastIMEEventGroup(imeGroup);
                    } else if (imeGroup.linkedExperience != null) {
                        int order = 10;
                        ExperienceData imeExp = result.getInMovieExperience();
                        if (imeExp != null) {
                            boolean bInserted = false;
                            try {
                                order = imeExp.childIdToSequenceNumber.get(imeGroup.linkedExperience.experienceId);

                                for (int j = 0; j < result.imeElementGroups.size(); j++) {
                                    Integer thisOrder = imeExp.childIdToSequenceNumber.get(result.imeElementGroups.get(j).linkedExperience.experienceId);
                                    if (thisOrder == null){
                                        break;
                                    }else if (order < thisOrder){
                                        result.imeElementGroups.add(j, imeGroup);
                                        bInserted = true;
                                        break;
                                    }
                                }
                            } catch (Exception ex) {}

                            if (!bInserted)
                                result.imeElementGroups.add(imeGroup);

                        } else {
                            result.imeElementGroups.add(imeGroup);
                        }
                    }
                }

            }
        }
        if (shopItemsWithVideo.size() > 0){
            for (ShopItem shopItem : shopItemsWithVideo){
                AudioVisualItem avItem = presentationIdToAVItemMap.get(shopItem.videoPresentationId);
                if (avItem == null){
                    PresentationType pItem = presentationAssetMap.get(shopItem.videoPresentationId);

                    avItem = generalAudioVisualItem(pItem.getPresentationID(), metaDataAssetsMap, videoAssetsMap, pItem, audioAssetsMap, null, "", shopItem.videoContentId, manifest.locale);
                }
                shopItem.avItem = avItem;
            }
        }


        /*****************End of Time Sequence Events****************************/

        return result;
    }

    static AudioVisualItem generalAudioVisualItem(String experienceId, HashMap<String, InventoryMetadataType> metaDataAssetsMap, HashMap<String, InventoryVideoType> videoAssetsMap,
                                                  PresentationType presentation, HashMap<String, InventoryAudioType> audioAssetsMap, List<ExternalApiData> externalApiDatas, String subType,
                                                  String avContentId, Locale locale){
        AudioVisualItem item = null;

        InventoryMetadataType avMetaData = metaDataAssetsMap.get(avContentId);        // get Video asset by ContentID of its AudioVisual


            List<AudioVisualTrack> tracks = new ArrayList<>();
            boolean isValidAVItem = false;
            if (presentation != null) {
                if (presentation.getTrackMetadata() != null && presentation.getTrackMetadata().size() > 0) {
                    for (TrackMetadataType trackMetadataType : presentation.getTrackMetadata()) {

                        InventoryVideoType video = null;
                        InventoryAudioType audio = null;

                        if (trackMetadataType.getVideoTrackReference() != null &&
                                trackMetadataType.getVideoTrackReference().size() > 0 &&
                                trackMetadataType.getVideoTrackReference().get(0).getVideoTrackID().size() > 0)                                          // get the video id from presentation
                            video = videoAssetsMap.get(trackMetadataType.getVideoTrackReference().get(0).getVideoTrackID().get(0));
                        if (trackMetadataType.getAudioTrackReference() != null &&
                                trackMetadataType.getAudioTrackReference().size() > 0 &&
                                trackMetadataType.getAudioTrackReference().get(0).getAudioTrackID().size() > 0)                                          // get the video id from presentation
                            audio = audioAssetsMap.get(trackMetadataType.getAudioTrackReference().get(0).getAudioTrackID().get(0));
                        if (video != null) {
                            isValidAVItem = true;
                        }
                        tracks.add(new AudioVisualTrack(video, audio));
                    }


                }
            }

            if (!StringHelper.isEmpty(presentation.getPresentationID()) && tracks.size() > 0 && isValidAVItem) {
                item = new AudioVisualItem(experienceId, presentation.getPresentationID(), avMetaData, tracks, externalApiDatas, subType, locale);
            }
            return item;

    }


    public boolean hasShareClipExp(){
        if (imeElementGroups != null && imeElementGroups.size() > 0){
            for (IMEElementsGroup imeElementsGroup : imeElementGroups){
                if (imeElementsGroup.linkedExperience != null && imeElementsGroup.linkedExperience.isShareClip()) {
                    shareClipIMEElementGroup = imeElementsGroup;
                    return true;
                }
            }
        }
        return false;
    }

    IMEEngine shareClipIMEEngine;

    public String getClosestShareClipImage(int timeCode){
        if (hasShareClipExp()){
            if (shareClipIMEEngine == null)
                shareClipIMEEngine = new AVGalleryIMEEngine(shareClipIMEElementGroup.getIMEElementesList());
            IMEElement item = ((IMEElement)shareClipIMEEngine.searchForClosestItem(timeCode));
            if (item != null && item.imeObject != null && item.imeObject instanceof AudioVisualItem)
                return ((AudioVisualItem) item.imeObject).getPosterImgUrl();
            else
                return null;
        }
        return null;
    }

    private static boolean isShopItem(AppDataType appDataType){
        if (appDataType != null){
            if (appDataType.getNVPair() != null && appDataType.getNVPair().size() > 0){
                for (AppNVPairType pair : appDataType.getNVPair()){
                    if (pair.getName().equalsIgnoreCase(NVPAIR_TYPE) && pair.getText().equalsIgnoreCase(NVPAIR_TYPE_PRODUCT))
                        return true;
                }
            }

        }
        return false;

    }


    public static Map<String, InventoryTextObjectType> getTextGroups(List<InventoryTextObjectType> localizableObjects){
        Map<String, InventoryTextObjectType> result = new HashMap<>();
        if (localizableObjects != null && localizableObjects.size() > 0) {
            for (InventoryTextObjectType textObject : localizableObjects ){
                result.put(textObject.getTextObjectID(), textObject);

            }

        }
        return result;
    }

    private static ShopItem getShopItemFromMap(HashMap<String, ShopItem> appIdToShopItemMap, HashMap<String, AppDataType> appDataMap, HashMap<String, InventoryMetadataType> metadataTypeHashMap, String appId, Locale locale){
        ShopItem item = appIdToShopItemMap.get(appId);
        if (item != null)
            return item;
        item = new ShopItem(appId, appDataMap, metadataTypeHashMap, locale);
        appIdToShopItemMap.put(appId, item);

        return item;
    }


    public static <T extends LocalizableMetaDataInterface>T getMatchingLocalizableObject(List<T> localizableObjects, Locale clientLocale){
        if (localizableObjects != null && localizableObjects.size() > 0) {
            int matchingIndex = -1, secondaryMatch = -1, engLangIndex = -1, emptyLocaleIndex = -1;
            for (int i = 0; i < localizableObjects.size() ; i++){
                T localizableObject = localizableObjects.get(i);

                String thisLang = localizableObject.getLanguage();
                if (thisLang == null || !StringHelper.isEmpty(thisLang))
                    emptyLocaleIndex = i;
                else if (thisLang.contains("-")){           // this is a locale
                    thisLang = thisLang.replace("-", "_");
                    Locale thisLocale = new Locale(thisLang);

                    if (clientLocale.equals(thisLocale)) {       // this is a perfect match
                        matchingIndex = i;
                        break;
                    } else if (clientLocale.getLanguage().equals(thisLocale.getLanguage())){
                        secondaryMatch = i;
                    }else if (Locale.US.equals(thisLocale)) {
                        engLangIndex = i;
                    }
                }else{
                    if (clientLocale.getLanguage().equals(thisLang)){
                        secondaryMatch = i;
                    } else if (Locale.US.getLanguage().equals(thisLang)){
                        engLangIndex = i;
                    }
                }

            }

            if (matchingIndex != -1)
                return localizableObjects.get(matchingIndex);
            else if (secondaryMatch != -1)
                return localizableObjects.get(secondaryMatch);
            else if (emptyLocaleIndex != -1)
                return localizableObjects.get(emptyLocaleIndex);
            else if (engLangIndex != -1)
                return localizableObjects.get(engLangIndex);
            else
                return localizableObjects.get(0);

        }
        return null;
    }

    private static LocationItem getLocationItemfromMap(HashMap<String, LocationItem> appIdToLocationItemMap,
                                                       HashMap<String, AppDataType> appDataMap,
                                                       HashMap<String, PictureImageData> imageAssetsMap,
                                                       HashMap<String, ExperienceData> experienceIdToExperienceMap,
                                                       String appId, Locale locale){
        AppDataType appData = appDataMap.get(appId);
        if(appData == null)
            return null;

        LocationItem result = appIdToLocationItemMap.get(appId);
        if (result != null)
            return result;

        int displayOrder = 0;
        String type = "";
        int zoom = 0;
        AppDataLocationType location = null;
        String text = "";

        ECGalleryItem galleryItem = null;
        AudioVisualItem avItem = null;
        String experienceId = null;

        PictureImageData videoThumbnail = null, locationThumbnail = null, pinImage = null;

        if (appData.getNVPair() != null && appData.getNVPair().size() > 0){
            for (AppNVPairType pair : appData.getNVPair()){
                if (ITEM_TYPE.equals(pair.getName())){
                    type = pair.getText();
                } else if (ITEM_LOCATION.equals(pair.getName())){
                    location = pair.getLocationSet();
                    if (location.getLocation() != null && location.getLocation().size() > 0){
                        String imageId = location.getLocation().get(0).getIcon();
                        if (!StringHelper.isEmpty(imageId)){
                            pinImage = imageAssetsMap.get(imageId);
                        }
                    }
                } else if (ITEM_ZOOM.equals(pair.getName())){
                    zoom = pair.getInteger().intValue();
                } else if (ITEM_DISPLAY_ORDER.equals(pair.getName())){
                    displayOrder = pair.getInteger().intValue();
                } else if (ITEM_TEXT.equals(pair.getName())){
                    text = pair.getText();
                } else if (ITEM_LOCATION_THUMBNAIL.equals(pair.getName())){
                    String imageId = pair.getPictureID();
                    locationThumbnail = imageAssetsMap.get(imageId);

                } else if (ITEM_EXPERIENCE_ID.equals(pair.getName())){
                    experienceId = pair.getExperienceID();
                }
            }
        }

        result = new LocationItem(appId, displayOrder, type, location, zoom, text, locationThumbnail, pinImage, experienceId, locale, experienceIdToExperienceMap);
        appIdToLocationItemMap.put(appId, result);
        return result;
    }

    public List<ExperienceData> getExtraECGroups(){
        return extraECGroups;
    }

    public List<IMEElementsGroup> getImeElementGroups(){
        return imeElementGroups;
    }

    public boolean hasMultipleCastMode(){
        return castGroupsList.size() > 1;
    }

    public ExperienceData findExperienceDataById(String id){
        if (!StringHelper.isEmpty(id)) {
            return experienceIdToExperienceMap.get(id);

        }
        return null;
    }


    public List<List<IMEElement<CastData>>> getCastIMEElements(){
        return castIMEElements;
    }

    public static enum ECGroupType{
        FEATURETTES, VISUAL_EFFECT, GALLERY, MIX, EXTERNAL_APP, LOCATIONS, INTERACTIVE, UNKNOWN, ACTORS, SHOP
    }

    public String getIdentifierForExternalAPI(String key){
        if (!StringHelper.isEmpty(key) && rootExperience != null && rootExperience.audioVisualItems != null && rootExperience.audioVisualItems.size() > 0 &&
                rootExperience.audioVisualItems.get(0).externalApiDataList != null){
            for (ExternalApiData data : rootExperience.audioVisualItems.get(0).externalApiDataList){
                if (key.equals(data.externalApiName))
                    return data.apiUniqueProjectId;
            }
        }
        return null;
    }
    HashMap<String, String> peopleIdToTalentGroupNameMap = new HashMap<>();

    private void reGroupCastIMEEventGroup(IMEElementsGroup<CastData> castCombinedGroup){
        if (castCombinedGroup == null || castCombinedGroup.getIMEElementesList() == null || castCombinedGroup.getIMEElementesList().size() == 0)
            return;
        HashMap<String, List<IMEElement<CastData>>> peopleIDToImeListMap = new HashMap<String, List<IMEElement<CastData>>>();
        for (IMEElement<CastData> castIMEElement : castCombinedGroup.getIMEElementesList()){
            String peopleId = castIMEElement.imeObject.getOtherPeopleId();
            if (!StringHelper.isEmpty(peopleId)){
                List<IMEElement<CastData>> thisIMEList;
                if (peopleIDToImeListMap.containsKey(peopleId)){
                    thisIMEList = peopleIDToImeListMap.get(peopleId);
                }else{
                    thisIMEList = new ArrayList<IMEElement<CastData>>();
                    peopleIDToImeListMap.put(peopleId, thisIMEList);
                    castIMEElements.add(thisIMEList);
                }
                peopleIdToTalentGroupNameMap.put(peopleId, castCombinedGroup.linkedExperience.title);
                thisIMEList.add(castIMEElement);
            }
        }

        //castIMEGroups
    }

    public String getInterstitialVideoURL(){
        if (rootExperience.audioVisualItems != null && rootExperience.audioVisualItems.size() > 1){
            return rootExperience.audioVisualItems.get(0).getVideoUrl();
        }else{
            return "http://wb-extras.warnerbros.com/extrasplus/prod/Manifest/BatmanvSuperman/streams/BVS_final_v2_H264_HDX_Stream_6750K_23976p.mp4";
        }
    }

    public String getPreviewMovieVideoURL(){
        if (rootExperience.audioVisualItems != null && rootExperience.audioVisualItems.size() > 1){

            return rootExperience.audioVisualItems.get(rootExperience.audioVisualItems.size() -1 ).getVideoUrl();
        }else{
            return "";
        }
    }

    public String getCommentaryTrackURL(){
        if (rootExperience.audioVisualItems != null && rootExperience.audioVisualItems.size() > 0){
            List<AudioVisualTrack> tracks = rootExperience.audioVisualItems.get(rootExperience.audioVisualItems.size() -1 ).tracksList;
            if (tracks.size() > 1){
                AudioVisualTrack commentaryTrack = tracks.get(tracks.size() - 1);
                return commentaryTrack.getAudioUrl();
            }else
                return "";
        }else{
            return "";
        }
    }

    public ExperienceStyle getRootExperienceStyle(){
        return rootExperience.style;
    }

    public String getTitletreatmentImageUrl(){
        return rootExperience.childrenExperience.get(1).posterImgUrl;
    }

    public ExperienceStyle getIMEExperienceStyle(){
        if (rootExperience.childrenExperience.size() > 1)
            return rootExperience.childrenExperience.get(1).style;
        else
            return null;
    }

    public ExperienceData getExtraExperience(){

        if (rootExperience.childrenExperience.size() > 0)
            return rootExperience.childrenExperience.get(0);
        else return null;
    }

    public ExperienceData getInMovieExperience(){

        if (rootExperience.childrenExperience.size() > 1)
            return rootExperience.childrenExperience.get(1);
        else return null;
    }

    public ExperienceStyle getStyleData(String experienceId){
        return experienceStyleMap.get(experienceId);
    }


}
