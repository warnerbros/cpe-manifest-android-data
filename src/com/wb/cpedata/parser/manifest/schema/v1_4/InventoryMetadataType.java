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
import com.wb.cpedata.parser.XmlType;
import com.wb.cpedata.parser.md.schema.v2_3.BasicMetadataType;


/**
 * <p>Java class for InventoryMetadata-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InventoryMetadata-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContainerReference" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://www.movielabs.com/schema/manifest/v1.4/manifest}ContainerReference-type"&gt;
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BasicMetadata" type="{http://www.movielabs.com/schema/md/v2.3/md}BasicMetadata-type" minOccurs="0"/&gt;
 *         &lt;element name="Alias" type="{http://www.movielabs.com/schema/manifest/v1.4/manifest}InventoryMetadataAlias-type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ContentID" use="required" type="{http://www.movielabs.com/schema/md/v2.3/md}ContentID-type" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryMetadata-type", propOrder = {
    "containerReference",
    "basicMetadata",
    "alias"
})
public class InventoryMetadataType {

    @XmlElement(name = "ContainerReference")
    protected List<ContainerReference> containerReference;
    @XmlElement(name = "BasicMetadata")
    protected BasicMetadataType basicMetadata;
    @XmlElement(name = "Alias")
    protected List<InventoryMetadataAliasType> alias;
    @XmlAttribute(name = "ContentID", required = true)
    protected String contentID;

    /**
     * Gets the value of the containerReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containerReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainerReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContainerReference }
     * 
     * 
     */
    public List<ContainerReference> getContainerReference() {
        if (containerReference == null) {
            containerReference = new ArrayList<ContainerReference>();
        }
        return this.containerReference;
    }

    /**
     * Gets the value of the basicMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link BasicMetadataType }
     *     
     */
    public BasicMetadataType getBasicMetadata() {
        return basicMetadata;
    }

    /**
     * Sets the value of the basicMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicMetadataType }
     *     
     */
    public void setBasicMetadata(BasicMetadataType value) {
        this.basicMetadata = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InventoryMetadataAliasType }
     * 
     * 
     */
    public List<InventoryMetadataAliasType> getAlias() {
        if (alias == null) {
            alias = new ArrayList<InventoryMetadataAliasType>();
        }
        return this.alias;
    }

    /**
     * Gets the value of the contentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentID() {
        return contentID;
    }

    /**
     * Sets the value of the contentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentID(String value) {
        this.contentID = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://www.movielabs.com/schema/manifest/v1.4/manifest}ContainerReference-type"&gt;
     *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ContainerReference
        extends ContainerReferenceType
    {

        @XmlAttribute(name = "type")
        protected String type;

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

    }

}
