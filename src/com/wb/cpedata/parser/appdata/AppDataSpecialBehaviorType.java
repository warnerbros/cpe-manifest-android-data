//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.16 at 04:10:08 PM PDT 
//


package com.wb.cpedata.parser.appdata;

import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for AppDataSpecialBehavior-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppDataSpecialBehavior-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="ChoseAudioTrackRef" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}AudioTrackID-type"/&gt;
 *         &lt;element name="ChoseVideoTrackRef" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}VideoTrackID-type"/&gt;
 *         &lt;element name="ChoseSubTrackRef" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}SubtitleTrackID-type"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppDataSpecialBehavior-type", propOrder = {
    "choseAudioTrackRef",
    "choseVideoTrackRef",
    "choseSubTrackRef"
})
public class AppDataSpecialBehaviorType {

    @XmlElement(name = "ChoseAudioTrackRef")
    @XmlSchemaType(name = "anyURI")
    protected String choseAudioTrackRef;
    @XmlElement(name = "ChoseVideoTrackRef")
    @XmlSchemaType(name = "anyURI")
    protected String choseVideoTrackRef;
    @XmlElement(name = "ChoseSubTrackRef")
    @XmlSchemaType(name = "anyURI")
    protected String choseSubTrackRef;

    /**
     * Gets the value of the choseAudioTrackRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoseAudioTrackRef() {
        return choseAudioTrackRef;
    }

    /**
     * Sets the value of the choseAudioTrackRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoseAudioTrackRef(String value) {
        this.choseAudioTrackRef = value;
    }

    /**
     * Gets the value of the choseVideoTrackRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoseVideoTrackRef() {
        return choseVideoTrackRef;
    }

    /**
     * Sets the value of the choseVideoTrackRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoseVideoTrackRef(String value) {
        this.choseVideoTrackRef = value;
    }

    /**
     * Gets the value of the choseSubTrackRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoseSubTrackRef() {
        return choseSubTrackRef;
    }

    /**
     * Sets the value of the choseSubTrackRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoseSubTrackRef(String value) {
        this.choseSubTrackRef = value;
    }

}