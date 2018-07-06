//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.16 at 04:10:08 PM PDT 
//


package com.wb.cpedata.parser.appdata;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import com.wb.cpedata.parser.XmlAccessType;
import com.wb.cpedata.parser.XmlAccessorType;
import com.wb.cpedata.parser.XmlAttribute;
import com.wb.cpedata.parser.XmlElement;
import com.wb.cpedata.parser.XmlSchemaType;
import com.wb.cpedata.parser.XmlType;


/**
 * <p>Java class for ManifestAppDataSet-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManifestAppDataSet-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ManifestAppData" type="{http://www.movielabs.com/schema/md/manifestdata/v1.0/manifestdata}AppData-type" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ManifestDataSetID" type="{http://www.movielabs.com/schema/md/manifestdata/v1.0/manifestdata}manifestdataSetID-type" /&gt;
 *       &lt;attribute name="updateNum" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManifestAppDataSet-type", propOrder = {
    "manifestAppData"
})
public class ManifestAppDataSetType {

    @XmlElement(name = "ManifestAppData", required = true)
    protected List<AppDataType> manifestAppData;
    @XmlAttribute(name = "ManifestDataSetID")
    protected String manifestDataSetID;
    @XmlAttribute(name = "updateNum")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger updateNum;

    /**
     * Gets the value of the manifestAppData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manifestAppData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManifestAppData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppDataType }
     * 
     * 
     */
    public List<AppDataType> getManifestAppData() {
        if (manifestAppData == null) {
            manifestAppData = new ArrayList<AppDataType>();
        }
        return this.manifestAppData;
    }

    /**
     * Gets the value of the manifestDataSetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManifestDataSetID() {
        return manifestDataSetID;
    }

    /**
     * Sets the value of the manifestDataSetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManifestDataSetID(String value) {
        this.manifestDataSetID = value;
    }

    /**
     * Gets the value of the updateNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUpdateNum() {
        return updateNum;
    }

    /**
     * Sets the value of the updateNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUpdateNum(BigInteger value) {
        this.updateNum = value;
    }

}
