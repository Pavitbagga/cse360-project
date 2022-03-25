

public class Payment {

    int cardNum;
    Address billingAddress;
    int securityCode;
    String expiration;

    public Payment(int cardNum, Address billingAddress, int securityCode, String expiration) {
        this.cardNum = cardNum;
        this.billingAddress = billingAddress;
        this.securityCode = securityCode;
        this.expiration = expiration;
    }

    public boolean setCardNum(int cardNum) {
        if (Integer.toString(cardNum).length()==16) {
            this.cardNum = cardNum;
            return true;
        }
        return false;
    }

    public boolean setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return true;
    }

    public boolean setSecurityCode(int securityCode) {
        if (Integer.toString(securityCode).length()==3 || Integer.toString(securityCode).length()==4) {
            this.securityCode = securityCode;
            return true;
        }
        return false;
    }

    public boolean setExpiration(String expiration) {
        if (expiration.length()==5) {
            if (expiration.charAt(0)=='0' || expiration.charAt(0) =='1') {
                if (expiration.charAt(2)=='/') {
                    this.expiration = expiration;
                    return true;
                }
            }
        }
        return false;

    }
}
