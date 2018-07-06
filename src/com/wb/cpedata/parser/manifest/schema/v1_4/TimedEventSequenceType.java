//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.08 at 03:02:05 PM PST 
//


package com.wb.cpedata.parser.manifest.schema.v1_4;

import java.util.ArrayList;
import java.util.List;
import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlAttribute;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for TimedEventSequence-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimedEventSequence-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="PresentationID" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}PresentationID-type"/&gt;
 *           &lt;element name="PlayableSequenceID" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}PlayableSequenceID-type"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="TimedEvent" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}TimedEvent-type" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TimedSequenceID" use="required" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}TimedSequenceID-type" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimedEventSequence-type", propOrder = {
    "presentationID",
    "playableSequenceID",
    "timedEvent"
})
public class TimedEventSequenceType {

    @XmlElement(name = "PresentationID")
    @XmlSchemaType(name = "anyURI")
    protected String presentationID;
    @XmlElement(name = "PlayableSequenceID")
    @XmlSchemaType(name = "anyURI")
    protected String playableSequenceID;
    @XmlElement(name = "TimedEvent", required = true)
    protected List<TimedEventType> timedEvent;
    @XmlAttribute(name = "TimedSequenceID", required = true)
    protected String timedSequenceID;

    /**
     * Gets the value of the presentationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentationID() {
        return presentationID;
    }

    /**
     * Sets the value of the presentationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentationID(String value) {
        this.presentationID = value;
    }

    /**
     * Gets the value of the playableSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayableSequenceID() {
        return playableSequenceID;
    }

    /**
     * Sets the value of the playableSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayableSequenceID(String value) {
        this.playableSequenceID = value;
    }

    /**
     * Gets the value of the timedEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timedEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimedEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimedEventType }
     * 
     * 
     */
    public List<TimedEventType> getTimedEvent() {
        if (timedEvent == null) {
            timedEvent = new ArrayList<TimedEventType>();
        }
        return this.timedEvent;
    }

    /**
     * Gets the value of the timedSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimedSequenceID() {
        return timedSequenceID;
    }

    /**
     * Sets the value of the timedSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimedSequenceID(String value) {
        this.timedSequenceID = value;
    }

}