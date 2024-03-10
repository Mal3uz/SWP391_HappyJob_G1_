/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ns
 */
public class WaitingListItem {

    private int accountID;

    private int talentID;

    private int packageID;

    private Talent talent;

    private ServicePackage servicePackage;

    public WaitingListItem() {
    }

    public WaitingListItem(int accountId, int talentId, int packageId) {
        this.accountID = accountId;
        this.talentID = talentId;
        this.packageID = packageId;
    }

    public int getAccountId() {
        return accountID;
    }

    public void setAccountId(int accountId) {
        this.accountID = accountId;
    }

    public int getTalentId() {
        return talentID;
    }

    public void setTalentId(int talentId) {
        this.talentID = talentId;
    }

    public int getPackageId() {
        return packageID;
    }

    public void setPackageId(int packageId) {
        this.packageID = packageId;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(ServicePackage servicePackage) {
        this.servicePackage = servicePackage;
    }

}
