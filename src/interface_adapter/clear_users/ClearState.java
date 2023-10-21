package interface_adapter.clear_users;

public class ClearState {

    private boolean clearSuccess;
    private String errorMessage;

    // Default Constructor
    public ClearState() {
        this.clearSuccess = false;
        this.errorMessage = "";
    }

    // Parameterized Constructor
    public ClearState(boolean clearSuccess, String errorMessage) {
        this.clearSuccess = clearSuccess;
        this.errorMessage = errorMessage;
    }

    // Getter and Setter methods
    public boolean isClearSuccess() {
        return clearSuccess;
    }

    public void setClearSuccess(boolean clearSuccess) {
        this.clearSuccess = clearSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ClearState [clearSuccess=" + clearSuccess + ", errorMessage=" + errorMessage + "]";
    }
}
