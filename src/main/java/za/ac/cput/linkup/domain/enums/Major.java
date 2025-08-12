package za.ac.cput.linkup.domain.enums;

public enum Major {
    COMPUTER_SCIENCE("Computer Science"),
    INFORMATION_TECHNOLOGY("Information Technology"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    DATA_SCIENCE("Data Science"),
    CYBER_SECURITY("Cyber Security"),
    NETWORKING("Networking"),
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    CIVIL_ENGINEERING("Civil Engineering"),
    CHEMICAL_ENGINEERING("Chemical Engineering"),
    INDUSTRIAL_ENGINEERING("Industrial Engineering"),
    OTHER("Other");

    private final String displayName;

    Major(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
