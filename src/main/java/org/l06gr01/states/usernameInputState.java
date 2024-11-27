package org.l06gr01.states;
import org.l06gr01.GUI.GUI;
import org.l06gr01.controller.Controller;
import org.l06gr01.controller.usernameInput.usernameInputController;
import org.l06gr01.model.leaderboard.User;
import org.l06gr01.viewer.Viewer;
import org.l06gr01.viewer.usernameInput.usernameInputViewer;


public class usernameInputState extends State<User> {


    public usernameInputState(User model) {
        super(model);
    }

    @Override
    protected Viewer<User> getViewer() {
        return new usernameInputViewer(getModel());
    }

    @Override
    protected Controller<User> getController() {
        return new usernameInputController(getModel());
    }
}
