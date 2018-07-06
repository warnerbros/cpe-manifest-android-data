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
import com.wb.cpedata.parser.XmlSeeAlso;
import com.wb.cpedata.parser.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for BackgroundImage-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BackgroundImage-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Inherit" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="PictureGroupID" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}PictureGroupID-type"/&gt;
 *         &lt;element name="Slideshow"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PictureGroupID" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}PictureGroupID-type"/&gt;
 *                   &lt;element name="Shuffle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/&gt;
 *                   &lt;element name="Transition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BackgroundImage-type", propOrder = {
    "inherit",
    "pictureGroupID",
    "slideshow"
})
@XmlSeeAlso({
    com.wb.cpedata.parser.cpestyle.BackgroundType.Image.class
})
public class BackgroundImageType {

    @XmlElement(name = "Inherit")
    protected Boolean inherit;
    @XmlElement(name = "PictureGroupID")
    @XmlSchemaType(name = "anyURI")
    protected String pictureGroupID;
    @XmlElement(name = "Slideshow")
    protected BackgroundImageType.Slideshow slideshow;

    /**
     * Gets the value of the inherit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInherit() {
        return inherit;
    }

    /**
     * Sets the value of the inherit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInherit(Boolean value) {
        this.inherit = value;
    }

    /**
     * Gets the value of the pictureGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureGroupID() {
        return pictureGroupID;
    }

    /**
     * Sets the value of the pictureGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureGroupID(String value) {
        this.pictureGroupID = value;
    }

    /**
     * Gets the value of the slideshow property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundImageType.Slideshow }
     *     
     */
    public BackgroundImageType.Slideshow getSlideshow() {
        return slideshow;
    }

    /**
     * Sets the value of the slideshow property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundImageType.Slideshow }
     *     
     */
    public void setSlideshow(BackgroundImageType.Slideshow value) {
        this.slideshow = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PictureGroupID" type="{http://www.movielabs.com/schema/manifest/v1.5/manifest}PictureGroupID-type"/&gt;
     *         &lt;element name="Shuffle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/&gt;
     *         &lt;element name="Transition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pictureGroupID",
        "shuffle",
        "duration",
        "transition"
    })
    public static class Slideshow {

        @XmlElement(name = "PictureGroupID", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String pictureGroupID;
        @XmlElement(name = "Shuffle")
        protected String shuffle;
        @XmlElement(name = "Duration")
        protected Duration duration;
        @XmlElement(name = "Transition")
        protected String transition;

        /**
         * Gets the value of the pictureGroupID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPictureGroupID() {
            return pictureGroupID;
        }

        /**
         * Sets the value of the pictureGroupID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPictureGroupID(String value) {
            this.pictureGroupID = value;
        }

        /**
         * Gets the value of the shuffle property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShuffle() {
            return shuffle;
        }

        /**
         * Sets the value of the shuffle property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShuffle(String value) {
            this.shuffle = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link Duration }
         *     
         */
        public Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link Duration }
         *     
         */
        public void setDuration(Duration value) {
            this.duration = value;
        }

        /**
         * Gets the value of the transition property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransition() {
            return transition;
        }

        /**
         * Sets the value of the transition property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransition(String value) {
            this.transition = value;
        }

    }

}
