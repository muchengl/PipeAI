package org.pipeai.models.formats;

public enum ModelDataAcceptance {
    NOT_ACCEPTED("NOT_ACCEPTED"),
    OPTIONAL("OPTIONAL"),
    MANDATORY("MANDATORY");

    private final String enable;

    ModelDataAcceptance(String enable) {
        this.enable=enable;
    }

    @Override
    public String toString() {
//        switch (this) {
//            case NOT_ACCEPTED:
//                return "NOT_ACCEPTED";
//            case OPTIONAL:
//                return "OPTIONAL";
//            case MANDATORY:
//                return "MANDATORY";
//            default:
//                return "UNKNOWN";
//        }
        return enable;
    }
}
