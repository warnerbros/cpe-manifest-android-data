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
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for TimelineStyle-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimelineStyle-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="something" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimelineStyle-type", propOrder = {
    "something"
})
public class TimelineStyleType {

    @XmlElement(required = true)
    protected Object something;

    /**
     * Gets the value of the something property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSomething() {
        return something;
    }

    /**
     * Sets the value of the something property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSomething(Object value) {
        this.something = value;
    }

}
