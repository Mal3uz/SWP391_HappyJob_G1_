/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author tuna
 */

//CREATE TABLE ServicePackage (
//    PacketID INT identity(1,1) PRIMARY KEY,
//    TalentID INT,
//    Title NVARCHAR(255),
//    [Description] NTEXT,
//    Price DECIMAL(10, 2),
//	Revisions Int,
//	[Type] NVARCHAR(255),
//    Deadline Int,
//    FOREIGN KEY (TalentID) REFERENCES Talent(TalentID)
//);
public class ServicePackage {
    private int packageID;
    private int talentID;
    private String title;
    private String description;
    private int price;
    private int revisions;
    private String type;
    private int deadline;

    public ServicePackage() {
    }

    public ServicePackage(int packageID, int talentID, String title, String description, int price, int revisions, String type, int deadline) {
        this.packageID = packageID;
        this.talentID = talentID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.revisions = revisions;
        this.type = type;
        this.deadline = deadline;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getTalentID() {
        return talentID;
    }

    public void setTalentID(int talentID) {
        this.talentID = talentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRevisions() {
        return revisions;
    }

    public void setRevisions(int revisions) {
        this.revisions = revisions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ServicePackage{" + "packageID=" + packageID + ", talentID=" + talentID + ", title=" + title + ", description=" + description + ", price=" + price + ", revisions=" + revisions + ", type=" + type + ", deadline=" + deadline + '}';
    }
    
    
}
