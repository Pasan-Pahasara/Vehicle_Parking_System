package view.TM;

import javafx.scene.control.Button;

public class DriversTM {
    private String name;
    private String NIC;
    private String licenseNo;
    private String address;
    private Integer contact;
    private Button delete;

    public DriversTM() {
    }

    public DriversTM(String name, String NIC, String licenseNo, String address, Integer contact, Button delete) {
        this.name = name;
        this.NIC = NIC;
        this.licenseNo = licenseNo;
        this.address = address;
        this.contact = contact;
        this.delete = delete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "DriversTM{" +
                "name='" + name + '\'' +
                ", NIC='" + NIC + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", delete=" + delete +
                '}';
    }
}
