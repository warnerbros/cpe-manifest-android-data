//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.16 at 03:29:52 PM PDT 
//


package com.wb.cpedata.parser.cpestyle;

import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlType;
import com.wb.cpedata.parser.manifest.schema.v1_4.TimecodeType;


/**
 * <p>Java class for BackgroundAudio-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BackgroundAudio-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AudioTrackID" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}AudioTrackID-type"/&gt;
 *         &lt;element name="EntryPointTimecode" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}Timecode-type" minOccurs="0"/&gt;
 *         &lt;element name="ExitPointTimecode" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}Timecode-type" minOccurs="0"/&gt;
 *         &lt;element name="LoopTimecode" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}Timecode-type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BackgroundAudio-type", propOrder = {
    "audioTrackID",
    "entryPointTimecode",
    "exitPointTimecode",
    "loopTimecode"
})
public class BackgroundAudioType {

    @XmlElement(name = "AudioTrackID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String audioTrackID;
    @XmlElement(name = "EntryPointTimecode")
    protected TimecodeType entryPointTimecode;
    @XmlElement(name = "ExitPointTimecode")
    protected TimecodeType exitPointTimecode;
    @XmlElement(name = "LoopTimecode")
    protected TimecodeType loopTimecode;

    /**
     * Gets the value of the audioTrackID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioTrackID() {
        return audioTrackID;
    }

    /**
     * Sets the value of the audioTrackID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioTrackID(String value) {
        this.audioTrackID = value;
    }

    /**
     * Gets the value of the entryPointTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link TimecodeType }
     *     
     */
    public TimecodeType getEntryPointTimecode() {
        return entryPointTimecode;
    }

    /**
     * Sets the value of the entryPointTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimecodeType }
     *     
     */
    public void setEntryPointTimecode(TimecodeType value) {
        this.entryPointTimecode = value;
    }

    /**
     * Gets the value of the exitPointTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link TimecodeType }
     *     
     */
    public TimecodeType getExitPointTimecode() {
        return exitPointTimecode;
    }

    /**
     * Sets the value of the exitPointTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimecodeType }
     *     
     */
    public void setExitPointTimecode(TimecodeType value) {
        this.exitPointTimecode = value;
    }

    /**
     * Gets the value of the loopTimecode property.
     * 
     * @return
     *     possible object is
     *     {@link TimecodeType }
     *     
     */
    public TimecodeType getLoopTimecode() {
        return loopTimecode;
    }

    /**
     * Sets the value of the loopTimecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimecodeType }
     *     
     */
    public void setLoopTimecode(TimecodeType value) {
        this.loopTimecode = value;
    }

}
