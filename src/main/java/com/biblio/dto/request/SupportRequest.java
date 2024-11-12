package com.biblio.dto.request;
public class SupportRequest {

    private Long id;
    private String title;
    private String feedbackContent;
    private String status;

    public SupportRequest(Long id, String feedbackContent) {
        this.id = id;
        this.feedbackContent = feedbackContent;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getFeedbackContent() {
        return feedbackContent;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
