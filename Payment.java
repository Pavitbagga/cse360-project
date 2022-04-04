

import java.io.Serializable;

public class Payment  implements Serializable{

    String cardNum;
    Address billingAddress;
    String securityCode;
    String expiration;

    public Payment(String cardNum, Address billingAddress, String securityCode, String expiration) {
        this.cardNum = cardNum;
        this.billingAddress = billingAddress;
        this.securityCode = securityCode;
        this.expiration = expiration;
    }

    public boolean setCardNum(String cardNum) {
        // if (Integer.toString(cardNum).length()==16) {
            this.cardNum = cardNum;
            return true;
        // }
        // return false;
    }

    public boolean setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return true;
    }

    public boolean setSecurityCode(String securityCode) {
        // if (Integer.toString(securityCode).length()==3 || Integer.toString(securityCode).length()==4) {
            this.securityCode = securityCode;
            // return true;
        // }
        return false;
    }

    public boolean setExpiration(String expiration) {
        // if (expiration.length()==5) {
            // if (expiration.charAt(0)=='0' || expiration.charAt(0) =='1') {
                // if (expiration.charAt(2)=='/') {
                    this.expiration = expiration;
                    return true;
                // }
            // }
        // }
        // return false;

    }

    public String getCardNum(){
        return this.cardNum;
    }
    
    public Address getBillinAddress(){
        return this.billingAddress;
    }

    public String getSecurityCode(){
        return this.securityCode;
    }

    public String getExpiration(){
        return this.expiration;
    }
}
