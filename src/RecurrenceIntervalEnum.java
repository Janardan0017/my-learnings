public enum RecurrenceIntervalEnum {

    YEAR("Year"), MONTH("Month"), DAY("Day"), WEEK("Week");

    private String value;

    public String getValue() {
        return this.value;
    }

    RecurrenceIntervalEnum(String value) {
        this.value = value;
    }

}