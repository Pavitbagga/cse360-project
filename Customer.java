
import java.util.ArrayList;

public class Customer extends User {

    String email;
    String phoneNum;
    Address address;
    Payment paymentInfo;
    ArrayList<Coupon> couponList = new ArrayList<>();

    public Customer(String newFirstName, String newLastName, String newUsername, String newPassword, int newUserID, String newEmail, String newPhoneNum) {
        super(newFirstName,newLastName,newUsername,newPassword,newUserID);
        this.email = newEmail;
        this.phoneNum = newPhoneNum;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public boolean setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return true;
    }

    public Address getAddress() {
        return address;
    }

    public boolean setAddress(Address address) {
        this.address = address;
        return true;
    }

    public Payment getPaymentInfo() {
        return paymentInfo;
    }

    public boolean setPaymentInfo(Payment paymentInfo) {
        this.paymentInfo = paymentInfo;
        return true;
    }

    public boolean setCoupon(Coupon newCoupon) {
        this.couponList.add(newCoupon);
        return true;
    }

    public ArrayList<Coupon> getCoupon() {
        return couponList;
    }
}

