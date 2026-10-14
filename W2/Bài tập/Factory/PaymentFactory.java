public class PaymentFactory {
    public static Payment getPayment(String type) {
        if (type.equalsIgnoreCase("momo")){
            return new MomoPayment();
        } else if (type.equalsIgnoreCase("tpbank")) {
            return new TpBankPayment();
        } else if (type.equalsIgnoreCase("scbank")){
            return new SCBankPayment();
        }else {
            throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
