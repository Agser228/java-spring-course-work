package ru.agser.server.enumeration;

public enum VoucherStatus {
    ACCEPTED("Заявка принята"),
    REJECTED("Заявка отклонена"),
    CONSIDERED("Заявка рассматривается");

    private final String message;

    VoucherStatus(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
