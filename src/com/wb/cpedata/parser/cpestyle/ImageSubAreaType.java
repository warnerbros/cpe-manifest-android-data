//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.16 at 03:29:52 PM PDT 
//


package com.wb.cpedata.parser.cpestyle;

import java.math.BigInteger;
import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlSeeAlso;
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for ImageSubArea-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageSubArea-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WidthPixels" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="HeightPixels" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="PixelsFromLeft" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *         &lt;element name="PixelsFromBottom" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageSubArea-type", propOrder = {
    "widthPixels",
    "heightPixels",
    "pixelsFromLeft",
    "pixelsFromBottom"
})
@XmlSeeAlso({
    BackgroundOverlayAreaType.class
})
public class ImageSubAreaType {

    @XmlElement(name = "WidthPixels", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger widthPixels;
    @XmlElement(name = "HeightPixels", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger heightPixels;
    @XmlElement(name = "PixelsFromLeft", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger pixelsFromLeft;
    @XmlElement(name = "PixelsFromBottom", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger pixelsFromBottom;

    /**
     * Gets the value of the widthPixels property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWidthPixels() {
        return widthPixels;
    }

    /**
     * Sets the value of the widthPixels property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWidthPixels(BigInteger value) {
        this.widthPixels = value;
    }

    /**
     * Gets the value of the heightPixels property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHeightPixels() {
        return heightPixels;
    }

    /**
     * Sets the value of the heightPixels property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHeightPixels(BigInteger value) {
        this.heightPixels = value;
    }

    /**
     * Gets the value of the pixelsFromLeft property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPixelsFromLeft() {
        return pixelsFromLeft;
    }

    /**
     * Sets the value of the pixelsFromLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPixelsFromLeft(BigInteger value) {
        this.pixelsFromLeft = value;
    }

    /**
     * Gets the value of the pixelsFromBottom property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPixelsFromBottom() {
        return pixelsFromBottom;
    }

    /**
     * Sets the value of the pixelsFromBottom property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPixelsFromBottom(BigInteger value) {
        this.pixelsFromBottom = value;
    }

}
