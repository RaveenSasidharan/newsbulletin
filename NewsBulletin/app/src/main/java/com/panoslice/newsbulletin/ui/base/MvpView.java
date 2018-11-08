package com.panoslice.newsbulletin.ui.base;

import android.os.Bundle;
import android.view.View;

public interface MvpView {
    View getRootView();
    Bundle getViewState();
}
