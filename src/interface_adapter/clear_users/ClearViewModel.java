package interface_adapter.clear_users;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClearViewModel {

    // Define constants for property names
    public static final String CLEAR_STATE_PROPERTY = "clearState";

    // Observable property to represent the current state of the "clear" operation
    private ClearState clearState;

    // Support for property change listeners, to notify the view of changes
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ClearViewModel() {
        this.clearState = new ClearState();
    }

    public ClearState getClearState() {
        return clearState;
    }

    public void setClearState(ClearState clearState) {
        ClearState oldState = this.clearState;
        this.clearState = clearState;
        propertyChangeSupport.firePropertyChange(CLEAR_STATE_PROPERTY, oldState, clearState);
    }

    // Allow external components to add/remove listeners to changes in this ViewModel
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    // Commands or methods for the view to call
    public void clearAllUserData() {
        // Invoke the ClearController to perform the actual clearing operation
        // Here, we'll just simulate the clearing operation:

        ClearController clearController = new ClearController();
        boolean success = clearController.clearAllUsers();
        if(success) {
            setClearState(new ClearState(true, "All user data cleared successfully."));
        } else {
            setClearState(new ClearState(false, "Failed to clear user data."));
        }
    }
}
