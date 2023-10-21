package interface_adapter.clear_users;

public class ClearPresenter {

    public interface View {
        void showConfirmationMessage(String message);
        void showErrorMessage(String message);
    }

    private final View view;
    private final ClearController clearController;

    public ClearPresenter(View view) {
        this.view = view;
        this.clearController = new ClearController();
    }

    public void clearAllUserData() {
        boolean success = clearController.clearAllUsers();
        if(success) {
            view.showConfirmationMessage("All user data cleared.");
        } else {
            view.showErrorMessage("Failed to clear user data.");
        }
    }
}
