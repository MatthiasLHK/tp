package tp.cap5buddy.modules;

public class Module {
    private String moduleName;
    private String zoomLink;

    public Module (String name) {
        this.moduleName = name;
    }

    public Module (String name, String link) {
        this.moduleName = name;
        this.zoomLink = link;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getZoomLink() {
        return this.zoomLink;
    }

    public void setModuleName(String name) {
        this.moduleName = name;
    }

    public void setZoomLink(String link) {
        this.zoomLink = link;
    }

    public void deleteZoomLink() {
        this.zoomLink = null;
    }
}
