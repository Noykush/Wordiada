
package engine.jabx.schema.generated;

import engine.jabx.schema.generated.Letters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{}DictionaryFileName"/>
 *         &lt;element ref="{}Letters"/>
 *         &lt;element ref="{}BoardSize"/>
 *         &lt;element name="RetriesNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CubeFacets">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="6"/>
 *               &lt;maxInclusive value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Structure")
public class Structure {

    @XmlElement(name = "DictionaryFileName", required = true)
    protected String dictionaryFileName;
    @XmlElement(name = "Letters", required = true)
    protected Letters letters;
    @XmlElement(name = "BoardSize")
    protected byte boardSize;
    @XmlElement(name = "RetriesNumber")
    protected byte retriesNumber;
    @XmlElement(name = "CubeFacets")
    protected byte cubeFacets;

    /**
     * Gets the value of the dictionaryFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictionaryFileName() {
        return dictionaryFileName;
    }

    /**
     * Sets the value of the dictionaryFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictionaryFileName(String value) {
        this.dictionaryFileName = value;
    }

    /**
     * Gets the value of the letters property.
     * 
     * @return
     *     possible object is
     *     {@link Letters }
     *     
     */
    public Letters getLetters() {
        return letters;
    }

    /**
     * Sets the value of the letters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Letters }
     *     
     */
    public void setLetters(Letters value) {
        this.letters = value;
    }

    /**
     * Gets the value of the boardSize property.
     * 
     */
    public byte getBoardSize() {
        return boardSize;
    }

    /**
     * Sets the value of the boardSize property.
     * 
     */
    public void setBoardSize(byte value) {
        this.boardSize = value;
    }

    /**
     * Gets the value of the retriesNumber property.
     * 
     */
    public byte getRetriesNumber() {
        return retriesNumber;
    }

    /**
     * Sets the value of the retriesNumber property.
     * 
     */
    public void setRetriesNumber(byte value) {
        this.retriesNumber = value;
    }

    /**
     * Gets the value of the cubeFacets property.
     * 
     */
    public byte getCubeFacets() {
        return cubeFacets;
    }

    /**
     * Sets the value of the cubeFacets property.
     * 
     */
    public void setCubeFacets(byte value) {
        this.cubeFacets = value;
    }

}
