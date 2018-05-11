
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "display")
public class Display {

    @XmlAttribute(name = "tag")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tag;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "rotate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rotate;
    @XmlAttribute(name = "flipx")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String flipx;
    @XmlAttribute(name = "width")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String width;
    @XmlAttribute(name = "height")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String height;
    @XmlAttribute(name = "refresh", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String refresh;
    @XmlAttribute(name = "pixclock")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String pixclock;
    @XmlAttribute(name = "htotal")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String htotal;
    @XmlAttribute(name = "hbend")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hbend;
    @XmlAttribute(name = "hbstart")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hbstart;
    @XmlAttribute(name = "vtotal")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String vtotal;
    @XmlAttribute(name = "vbend")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String vbend;
    @XmlAttribute(name = "vbstart")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String vbstart;

    /**
     * Obtient la valeur de la propriete tag.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTag() {
        return tag;
    }

    /**
     * Definit la valeur de la propriete tag.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Obtient la valeur de la propriete type.
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
     * Definit la valeur de la propriete type.
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
     * Obtient la valeur de la propriete rotate.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRotate() {
        return rotate;
    }

    /**
     * Definit la valeur de la propriete rotate.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRotate(String value) {
        this.rotate = value;
    }

    /**
     * Obtient la valeur de la propriete flipx.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlipx() {
        if (flipx == null) {
            return "no";
        } else {
            return flipx;
        }
    }

    /**
     * Definit la valeur de la propriete flipx.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlipx(String value) {
        this.flipx = value;
    }

    /**
     * Obtient la valeur de la propriete width.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWidth() {
        return width;
    }

    /**
     * Definit la valeur de la propriete width.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Obtient la valeur de la propriete height.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHeight() {
        return height;
    }

    /**
     * Definit la valeur de la propriete height.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Obtient la valeur de la propriete refresh.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRefresh() {
        return refresh;
    }

    /**
     * Definit la valeur de la propriete refresh.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRefresh(String value) {
        this.refresh = value;
    }

    /**
     * Obtient la valeur de la propriete pixclock.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPixclock() {
        return pixclock;
    }

    /**
     * Definit la valeur de la propriete pixclock.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPixclock(String value) {
        this.pixclock = value;
    }

    /**
     * Obtient la valeur de la propriete htotal.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHtotal() {
        return htotal;
    }

    /**
     * Definit la valeur de la propriete htotal.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHtotal(String value) {
        this.htotal = value;
    }

    /**
     * Obtient la valeur de la propriete hbend.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHbend() {
        return hbend;
    }

    /**
     * Definit la valeur de la propriete hbend.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHbend(String value) {
        this.hbend = value;
    }

    /**
     * Obtient la valeur de la propriete hbstart.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHbstart() {
        return hbstart;
    }

    /**
     * Definit la valeur de la propriete hbstart.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHbstart(String value) {
        this.hbstart = value;
    }

    /**
     * Obtient la valeur de la propriete vtotal.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVtotal() {
        return vtotal;
    }

    /**
     * Definit la valeur de la propriete vtotal.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVtotal(String value) {
        this.vtotal = value;
    }

    /**
     * Obtient la valeur de la propriete vbend.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVbend() {
        return vbend;
    }

    /**
     * Definit la valeur de la propriete vbend.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVbend(String value) {
        this.vbend = value;
    }

    /**
     * Obtient la valeur de la propriete vbstart.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVbstart() {
        return vbstart;
    }

    /**
     * Definit la valeur de la propriete vbstart.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVbstart(String value) {
        this.vbstart = value;
    }

}
