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
import com.wb.cpedata.parser.XmlValue;


/**
 * <p>Java class for ALIDExperienceMap-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ALIDExperienceMap-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ALID" type="{http://www.movielabs.com/schema/md/v2.3/md}AssetLogicalID-type" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ExperienceID" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.movielabs.com/schema/manifest/v1.4/manifest&gt;ExperienceID-type"&gt;
 *                 &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ALIDExperienceMap-type", propOrder = {
    "alid",
    "experienceID"
})
public class ALIDExperienceMapType {

    @XmlElement(name = "ALID", required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> alid;
    @XmlElement(name = "ExperienceID", required = true)
    protected List<ExperienceID> experienceID;

    /**
     * Gets the value of the alid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getALID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getALID() {
        if (alid == null) {
            alid = new ArrayList<String>();
        }
        return this.alid;
    }

    /**
     * Gets the value of the experienceID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the experienceID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExperienceID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExperienceID }
     * 
     * 
     */
    public List<ExperienceID> getExperienceID() {
        if (experienceID == null) {
            experienceID = new ArrayList<ExperienceID>();
        }
        return this.experienceID;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.movielabs.com/schema/manifest/v1.4/manifest&gt;ExperienceID-type"&gt;
     *       &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class ExperienceID {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "condition")
        protected String condition;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the condition property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCondition() {
            return condition;
        }

        /**
         * Sets the value of the condition property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCondition(String value) {
            this.condition = value;
        }

    }

}
