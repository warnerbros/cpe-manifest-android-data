//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.08 at 03:02:05 PM PST 
//


package com.wb.cpedata.parser.manifest.schema.v1_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlSeeAlso;
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for TrackMetadata-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackMetadata-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TrackSelectionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *         &lt;element name="VideoTrackReference" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}VideoTrackReference-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AudioTrackReference" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}AudioTrackReference-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SubtitleTrackReference" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}SubtitleTrackReference-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AncillaryTrackReference" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}AncillaryTrackReference-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackMetadata-type", propOrder = {
    "trackSelectionNumber",
    "videoTrackReference",
    "audioTrackReference",
    "subtitleTrackReference",
    "ancillaryTrackReference"
})
@XmlSeeAlso({
    com.wb.cpedata.parser.manifest.schema.v1_4.PresentationType.TrackMetadata.class
})
public class TrackMetadataType {

    @XmlElement(name = "TrackSelectionNumber", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger trackSelectionNumber;
    @XmlElement(name = "VideoTrackReference")
    protected List<VideoTrackReferenceType> videoTrackReference;
    @XmlElement(name = "AudioTrackReference")
    protected List<AudioTrackReferenceType> audioTrackReference;
    @XmlElement(name = "SubtitleTrackReference")
    protected List<SubtitleTrackReferenceType> subtitleTrackReference;
    @XmlElement(name = "AncillaryTrackReference")
    protected List<AncillaryTrackReferenceType> ancillaryTrackReference;

    /**
     * Gets the value of the trackSelectionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrackSelectionNumber() {
        return trackSelectionNumber;
    }

    /**
     * Sets the value of the trackSelectionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrackSelectionNumber(BigInteger value) {
        this.trackSelectionNumber = value;
    }

    /**
     * Gets the value of the videoTrackReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the videoTrackReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVideoTrackReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VideoTrackReferenceType }
     * 
     * 
     */
    public List<VideoTrackReferenceType> getVideoTrackReference() {
        if (videoTrackReference == null) {
            videoTrackReference = new ArrayList<VideoTrackReferenceType>();
        }
        return this.videoTrackReference;
    }

    /**
     * Gets the value of the audioTrackReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audioTrackReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudioTrackReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AudioTrackReferenceType }
     * 
     * 
     */
    public List<AudioTrackReferenceType> getAudioTrackReference() {
        if (audioTrackReference == null) {
            audioTrackReference = new ArrayList<AudioTrackReferenceType>();
        }
        return this.audioTrackReference;
    }

    /**
     * Gets the value of the subtitleTrackReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtitleTrackReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtitleTrackReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubtitleTrackReferenceType }
     * 
     * 
     */
    public List<SubtitleTrackReferenceType> getSubtitleTrackReference() {
        if (subtitleTrackReference == null) {
            subtitleTrackReference = new ArrayList<SubtitleTrackReferenceType>();
        }
        return this.subtitleTrackReference;
    }

    /**
     * Gets the value of the ancillaryTrackReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ancillaryTrackReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAncillaryTrackReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AncillaryTrackReferenceType }
     * 
     * 
     */
    public List<AncillaryTrackReferenceType> getAncillaryTrackReference() {
        if (ancillaryTrackReference == null) {
            ancillaryTrackReference = new ArrayList<AncillaryTrackReferenceType>();
        }
        return this.ancillaryTrackReference;
    }

}