package seedu.address.logic.commands;

import seedu.address.model.module.ZoomLink;

import java.util.List;

public class ViewCommandResult extends CommandResult {

    private String textArea;
    private List<ZoomLink> zoomLinksToCopy;
    private List<ZoomLink> zoomLinks;

    public ViewCommandResult(String feedbackToUser) {
        super(feedbackToUser);
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public void setZoomLinks(List<ZoomLink> zoomLinks) {
        this.zoomLinks = zoomLinks;
    }

    public void setZoomLinksToCopy(List<ZoomLink> zoomLinksToCopy) {
        this.zoomLinksToCopy = zoomLinksToCopy;
    }

    public String getTextArea() {
        return textArea;
    }

    public List<ZoomLink> getZoomLinks() {
        return zoomLinks;
    }

    public List<ZoomLink> getZoomLinksToCopy() {
        return zoomLinksToCopy;
    }
}
