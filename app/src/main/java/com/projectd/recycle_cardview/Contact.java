package com.projectd.recycle_cardview;

public class Contact {
    private String Name, Subject, Description;
    private Integer Image;

    public Contact(String Name, String Subject, String Description, Integer Image) {
        this.Name = Name;
        this.Subject = Subject;
        this.Description = Description;
        this.Image = Image;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public Integer getImage() {
        return Image;
    }
    public void setImage(Integer image) {
        Image = image;
    }
}
