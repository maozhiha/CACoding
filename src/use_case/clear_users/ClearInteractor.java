package use_case.clear_users;

public class ClearInteractor implements ClearInputBoundary {
    private ClearUserDataAccessInterface dataAccess;
    private ClearOutputBoundary outputBoundary;

    public ClearInteractor(ClearUserDataAccessInterface dataAccess, ClearOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void clearUsers(ClearInputData inputData) {
        boolean result = dataAccess.clearAllUsers();
        ClearOutputData outputData = new ClearOutputData();
        if (result) {
            outputData.setSuccess(true);
            outputData.setMessage("Users cleared successfully.");
        } else {
            outputData.setSuccess(false);
            outputData.setMessage("Failed to clear users.");
        }
        outputBoundary.receiveClearResult(outputData);
    }
}
