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
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for ColorPaletteInstance-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColorPaletteInstance-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Outline" type="{http://www.movielabs.com/schema/md/cpestyle/v1.0/cpestyle}ColorHex-type"/&gt;
 *         &lt;element name="Fill" type="{http://www.movielabs.com/schema/md/cpestyle/v1.0/cpestyle}ColorHex-type" minOccurs="0"/&gt;
 *         &lt;element name="Shadow" type="{http://www.movielabs.com/schema/md/cpestyle/v1.0/cpestyle}ColorHex-type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorPaletteInstance-type", propOrder = {
    "outline",
    "fill",
    "shadow"
})
public class ColorPaletteInstanceType {

    @XmlElement(name = "Outline", required = true)
    protected String outline;
    @XmlElement(name = "Fill")
    protected String fill;
    @XmlElement(name = "Shadow")
    protected String shadow;

    /**
     * Gets the value of the outline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutline() {
        return outline;
    }

    /**
     * Sets the value of the outline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutline(String value) {
        this.outline = value;
    }

    /**
     * Gets the value of the fill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFill() {
        return fill;
    }

    /**
     * Sets the value of the fill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFill(String value) {
        this.fill = value;
    }

    /**
     * Gets the value of the shadow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShadow() {
        return shadow;
    }

    /**
     * Sets the value of the shadow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShadow(String value) {
        this.shadow = value;
    }

}
