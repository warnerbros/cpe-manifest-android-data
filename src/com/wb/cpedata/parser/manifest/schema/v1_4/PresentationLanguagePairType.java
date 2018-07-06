//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.08 at 03:02:05 PM PST 
//


package com.wb.cpedata.parser.manifest.schema.v1_4;

import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlType;
import com.wb.cpedata.parser.adapters.CollapsedStringAdapter;
import com.wb.cpedata.parser.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for PresentationLanguagePair-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PresentationLanguagePair-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SystemLanguage" type="{http://www.w3.org/2001/XMLSchema}language"/&gt;
 *         &lt;element name="AudioLanguage" type="{http://www.w3.org/2001/XMLSchema}language"/&gt;
 *         &lt;element name="SubtitleLanguage" type="{http://www.w3.org/2001/XMLSchema}language"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PresentationLanguagePair-type", propOrder = {
    "systemLanguage",
    "audioLanguage",
    "subtitleLanguage"
})
public class PresentationLanguagePairType {

    @XmlElement(name = "SystemLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String systemLanguage;
    @XmlElement(name = "AudioLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String audioLanguage;
    @XmlElement(name = "SubtitleLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String subtitleLanguage;

    /**
     * Gets the value of the systemLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemLanguage() {
        return systemLanguage;
    }

    /**
     * Sets the value of the systemLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemLanguage(String value) {
        this.systemLanguage = value;
    }

    /**
     * Gets the value of the audioLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioLanguage() {
        return audioLanguage;
    }

    /**
     * Sets the value of the audioLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioLanguage(String value) {
        this.audioLanguage = value;
    }

    /**
     * Gets the value of the subtitleLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtitleLanguage() {
        return subtitleLanguage;
    }

    /**
     * Sets the value of the subtitleLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtitleLanguage(String value) {
        this.subtitleLanguage = value;
    }

}