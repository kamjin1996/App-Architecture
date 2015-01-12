package com.android.app.framework.command;


import com.android.app.framework.controller.IController;
import com.android.app.framework.controller.Notifier;
import com.android.app.framework.net.Response;

import java.util.Map;

/**
 * @author xuwei19
 * @date 2014-11-19 00:22:50
 */
public abstract class AbstractCommand implements ICommand {
    private IController mController;
    private Map<String, String> mParams;
    private Response mResponse;
    private volatile boolean isCancel = false;

    public AbstractCommand(IController controller) {
        this(controller, null);
    }

    public AbstractCommand(IController controller, Map<String, String> paramMap) {
        this(controller, paramMap, null);
    }

    public AbstractCommand(IController controller, Map<String, String> paramMap, Response response) {
        this.mController = controller;
        this.mParams = paramMap;
        this.mResponse = response;
    }

    @Override
    public boolean isCancel() {
        return isCancel;
    }

    @Override
    public void setCancel(boolean isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public final String getName() {
        return getClass().getCanonicalName();
    }

    @Override
    public final IController getController() {
        return mController;
    }

    @Override
    public final Map<String, String> getParams() {
        return mParams;
    }

    @Override
    public final void setParams(Map<String, String> params) {
        this.mParams = params;
    }

    @Override
    public Response getResponse() {
        return mResponse;
    }

    @Override
    public void setResponse(Response response) {
this.mResponse = response;
    }
}