package com.odk.apisuiviapprenant.exception;

public enum ErrorCode {
    APPRENANT_NOT_FOUND(1000),
    APPRENANT_NOT_VALID(1001),
    FORMATEUR_NOTE_FOUND(2000)
    ;

    private int code;
    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
