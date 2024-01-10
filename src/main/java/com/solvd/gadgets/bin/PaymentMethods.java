package com.solvd.gadgets.bin;

public class PaymentMethods {

    private long paymentMethodID;
    private String methodName;

    public PaymentMethods() {
    }

    public PaymentMethods(long paymentMethodID, String methodName) {
        this.paymentMethodID = paymentMethodID;
        this.methodName = methodName;
    }

    public long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "paymentMethodID=" + paymentMethodID +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
