package org.pipeai.models.formats;

public enum ModelDataAcceptance {
    NOT_ACCEPTED,
    OPTIONAL,
    MANDATORY;

    @Override
    public String toString() {
        switch (this) {
            case NOT_ACCEPTED:
                return "NOT_ACCEPTED";
            case OPTIONAL:
                return "OPTIONAL";
            case MANDATORY:
                return "MANDATORY";
            default:
                return "UNKNOWN";
        }
    }
}
