//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.08 at 03:02:05 PM PST 
//


package com.wb.cpedata.parser.md.schema.v2_3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlAnyElement;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlSeeAlso;
import com.wb.cpedata.parser.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for ContainerMetadata-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContainerMetadata-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://www.movielabs.com/schema/md/v2.3/md}string-Container-Type" minOccurs="0"/&gt;
 *         &lt;element name="Track" type="{http://www.movielabs.com/schema/md/v2.3/md}ContainerTrackMetadata-type" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Hash" type="{http://www.movielabs.com/schema/md/v2.3/md}Hash-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/&gt;
 *         &lt;element name="ContainerReference" type="{http://www.movielabs.com/schema/md/v2.3/md}string-Container-ContainerReference" minOccurs="0"/&gt;
 *         &lt;element name="ContainerIdentifier" type="{http://www.movielabs.com/schema/md/v2.3/md}ContentIdentifier-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ContainerSpecificMetadata" type="{http://www.movielabs.com/schema/md/v2.3/md}ContainerSpecific-type" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContainerMetadata-type", propOrder = {
    "type",
    "track",
    "hash",
    "size",
    "containerReference",
    "containerIdentifier",
    "containerSpecificMetadata",
    "any"
})
@XmlSeeAlso({
    ContainerMetadataWithIDType.class
})
public class ContainerMetadataType {

    @XmlElement(name = "Type")
    protected String type;
    @XmlElement(name = "Track", required = true)
    protected List<ContainerTrackMetadataType> track;
    @XmlElement(name = "Hash")
    protected List<HashType> hash;
    @XmlElement(name = "Size")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger size;
    @XmlElement(name = "ContainerReference")
    protected String containerReference;
    @XmlElement(name = "ContainerIdentifier")
    protected List<ContentIdentifierType> containerIdentifier;
    @XmlElement(name = "ContainerSpecificMetadata")
    protected ContainerSpecificType containerSpecificMetadata;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the track property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the track property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContainerTrackMetadataType }
     * 
     * 
     */
    public List<ContainerTrackMetadataType> getTrack() {
        if (track == null) {
            track = new ArrayList<ContainerTrackMetadataType>();
        }
        return this.track;
    }

    /**
     * Gets the value of the hash property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hash property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHash().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HashType }
     * 
     * 
     */
    public List<HashType> getHash() {
        if (hash == null) {
            hash = new ArrayList<HashType>();
        }
        return this.hash;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSize(BigInteger value) {
        this.size = value;
    }

    /**
     * Gets the value of the containerReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerReference() {
        return containerReference;
    }

    /**
     * Sets the value of the containerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerReference(String value) {
        this.containerReference = value;
    }

    /**
     * Gets the value of the containerIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containerIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainerIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentIdentifierType }
     * 
     * 
     */
    public List<ContentIdentifierType> getContainerIdentifier() {
        if (containerIdentifier == null) {
            containerIdentifier = new ArrayList<ContentIdentifierType>();
        }
        return this.containerIdentifier;
    }

    /**
     * Gets the value of the containerSpecificMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerSpecificType }
     *     
     */
    public ContainerSpecificType getContainerSpecificMetadata() {
        return containerSpecificMetadata;
    }

    /**
     * Sets the value of the containerSpecificMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerSpecificType }
     *     
     */
    public void setContainerSpecificMetadata(ContainerSpecificType value) {
        this.containerSpecificMetadata = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
