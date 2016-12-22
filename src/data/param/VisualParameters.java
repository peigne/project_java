
package data.param;

import data.xmladapters.ColorAdapter;
import javafx.scene.paint.Color;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="param")
public class VisualParameters {
    private boolean beaconsAreDisplayed;
    private int baseMapStrokeWidth;
    private int beaconSize;
    private int beaconStrokeWidth;
    private int beaconTextOffsetX;
    private int beaconTextOffsetY;
    private int cometSize;
    private int cometSizeReduction;
    private int cometStrokeWidth;
    private int flightLevel;
    private int labelOffsetX;
    private int labelOffsetY;
    private int labelStrokeWidth;
    private int menuBarSize;
    private int sectorStrokeWidth;
    private int speedVectorStrokeWidth;
    private int timeHorizon;
    private String fileBaseMap;
    private String fileBeacons;
    private String fileSectors;
    private String ivyBus;
    private Color baseMapFillColor;
    private Color baseMapStrokeColor;
    private Color beaconFillColor;
    private Color beaconStrokeColor;
    private Color beaconTextFillColor;
    private Color cometStrokeColor;
    private Color cometFillColor;
    private Color labelArrowStrokeColor;
    private Color labelFillColor;
    private Color sceneBackgroundColor;
    private Color sectorStrokeColor;
    private Color sectorFillColor;
    private Color sectorTextFillColor;
    private Color speedVectorColor;

    public Color getBaseMapFillColor() {
        return this.baseMapFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setBaseMapFillColor(Color baseMapFillColor) {
        this.baseMapFillColor = baseMapFillColor;
    }

    public Color getBaseMapStrokeColor() {
        return this.baseMapStrokeColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setBaseMapStrokeColor(Color baseMapStrokeColor) {
        this.baseMapStrokeColor = baseMapStrokeColor;
    }

    public int getBaseMapStrokeWidth() {
        return this.baseMapStrokeWidth;
    }

    @XmlElement
    public void setBaseMapStrokeWidth(int baseMapStrokeWidth) {
        this.baseMapStrokeWidth = baseMapStrokeWidth;
    }

    public int getBeaconTextOffsetX() {
        return this.beaconTextOffsetX;
    }

    @XmlElement
    public void setBeaconTextOffsetX(int beaconTextOffsetX) {
        this.beaconTextOffsetX = beaconTextOffsetX;
    }

    public int getBeaconTextOffsetY() {
        return this.beaconTextOffsetY;
    }

    @XmlElement
    public void setBeaconTextOffsetY(int beaconTextOffsetY) {
        this.beaconTextOffsetY = beaconTextOffsetY;
    }

    public Color getBeaconTextFillColor() {
        return this.beaconTextFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setBeaconTextFillColor(Color beaconTextFillColor) {
        this.beaconTextFillColor = beaconTextFillColor;
    }

    public Color getBeaconFillColor() {
        return this.beaconFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setBeaconFillColor(Color beaconFillColor) {
        this.beaconFillColor = beaconFillColor;
    }

    public Color getBeaconStrokeColor() {
        return this.beaconStrokeColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setBeaconStrokeColor(Color beaconStrokeColor) {
        this.beaconStrokeColor = beaconStrokeColor;
    }

    public int getBeaconStrokeWidth() {
        return this.beaconStrokeWidth;
    }

    @XmlElement
    public void setBeaconStrokeWidth(int beaconStrokeWidth) {
        this.beaconStrokeWidth = beaconStrokeWidth;
    }

    public int getBeaconSize() {
        return this.beaconSize;
    }

    @XmlElement
    public void setBeaconSize(int beaconSize) {
        this.beaconSize = beaconSize;
    }

    public boolean getBeaconsAreDisplayed() {
        return this.beaconsAreDisplayed;
    }

    @XmlElement
    public void setBeaconsAreDisplayed(boolean beaconsAreDisplayed) {
        this.beaconsAreDisplayed = beaconsAreDisplayed;
    }

    public int getCometSize() {
        return this.cometSize;
    }

    @XmlElement
    public void setCometSize(int cometSize) {
        this.cometSize = cometSize;
    }

    public int getCometSizeReduction() {
        return this.cometSizeReduction;
    }

    @XmlElement
    public void setCometSizeReduction(int cometSizeReduction) {
        this.cometSizeReduction = cometSizeReduction;
    }

    public int getCometStrokeWidth() {
        return this.cometStrokeWidth;
    }

    @XmlElement
    public void setCometStrokeWidth(int cometStrokeWidth) {
        this.cometStrokeWidth = cometStrokeWidth;
    }

    public Color getCometStrokeColor() {
        return this.cometStrokeColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setCometStrokeColor(Color cometStrokeColor) {
        this.cometStrokeColor = cometStrokeColor;
    }

    public Color getCometFillColor() {
        return this.cometFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setCometFillColor(Color cometFillColor) {
        this.cometFillColor = cometFillColor;
    }

    public String getFileBaseMap() {
        return this.fileBaseMap;
    }

    @XmlElement
    public void setFileBaseMap(String fileBaseMap) {
        this.fileBaseMap = fileBaseMap;
    }

    public String getFileBeacons() {
        return this.fileBeacons;
    }

    @XmlElement
    public void setFileBeacons(String fileBeacons) {
        this.fileBeacons = fileBeacons;
    }

    public String getFileSectors() {
        return this.fileSectors;
    }

    @XmlElement
    public void setFileSectors(String fileSectors) {
        this.fileSectors = fileSectors;
    }

    public int getFlightLevel() {
        return this.flightLevel;
    }

    @XmlElement
    public void setFlightLevel(int flightLevel) {
        this.flightLevel = flightLevel;
    }

    public String getIvyBus() {
        return this.ivyBus;
    }

    @XmlElement
    public void setIvyBus(String ivyBus) {
        this.ivyBus = ivyBus;
    }

    public int getLabelOffsetX() {
        return this.labelOffsetX;
    }

    @XmlElement
    public void setLabelOffsetX(int labelOffsetX) {
        this.labelOffsetX = labelOffsetX;
    }

    public int getLabelOffsetY() {
        return this.labelOffsetY;
    }

    @XmlElement
    public void setLabelOffsetY(int labelOffsetY) {
        this.labelOffsetY = labelOffsetY;
    }

    public Color getLabelFillColor() {
        return this.labelFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setLabelFillColor(Color labelFillColor) {
        this.labelFillColor = labelFillColor;
    }

    public Color getLabelArrowStrokeColor() {
        return this.labelArrowStrokeColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setLabelArrowStrokeColor(Color labelArrowStrokeColor) {
        this.labelArrowStrokeColor = labelArrowStrokeColor;
    }

    public int getLabelStrokeWidth() {
        return this.labelStrokeWidth;
    }

    @XmlElement
    public void setLabelStrokeWidth(int labelStrokeWidth) {
        this.labelStrokeWidth = labelStrokeWidth;
    }

    public int getMenuBarSize() {
        return this.menuBarSize;
    }

    @XmlElement
    public void setMenuBarSize(int menuBarSize) {
        this.menuBarSize = menuBarSize;
    }

    public Color getSceneBackgroundColor() {
        return this.sceneBackgroundColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setSceneBackgroundColor(Color sceneBackgroundColor) {
        this.sceneBackgroundColor = sceneBackgroundColor;
    }

    public Color getSectorFillColor() {
        return this.sectorFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setSectorFillColor(Color sectorFillColor) {
        this.sectorFillColor = sectorFillColor;
    }

    public Color getSectorStrokeColor() {
        return this.sectorStrokeColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setSectorStrokeColor(Color sectorStrokeColor) {
        this.sectorStrokeColor = sectorStrokeColor;
    }

    public int getSectorStrokeWidth() {
        return this.sectorStrokeWidth;
    }

    @XmlElement
    public void setSectorStrokeWidth(int sectorStrokeWidth) {
        this.sectorStrokeWidth = sectorStrokeWidth;
    }

    public Color getSectorTextFillColor() {
        return this.sectorTextFillColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setSectorTextFillColor(Color sectorTextFillColor) {
        this.sectorTextFillColor = sectorTextFillColor;
    }

    public Color getSpeedVectorColor() {
        return this.speedVectorColor;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value=ColorAdapter.class)
    public void setSpeedVectorColor(Color speedVectorColor) {
        this.speedVectorColor = speedVectorColor;
    }

    public int getSpeedVectorStrokeWidth() {
        return this.speedVectorStrokeWidth;
    }

    @XmlElement
    public void setSpeedVectorStrokeWidth(int speedVectorStrokeWidth) {
        this.speedVectorStrokeWidth = speedVectorStrokeWidth;
    }

    public int getTimeHorizon() {
        return this.timeHorizon;
    }

    @XmlElement
    public void setTimeHorizon(int timeHorizon) {
        this.timeHorizon = timeHorizon;
    }
}

