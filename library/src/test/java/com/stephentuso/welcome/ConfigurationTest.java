package com.stephentuso.welcome;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;

import org.mockito.Mock;

/**
 * Extend for tests that need a WelcomeConfiguration object,
 * Sets up the context object
 *
 * Created by stephentuso on 10/19/16.
 */

/* package */ class ConfigurationTest {

    protected static int DEFAULT_COLOR = 0x1e88e5;

    @Mock protected Resources resources;
    @Mock protected Resources.Theme theme;
    @Mock protected Context context;

    protected void initContext() {
        when(resources.getColor(R.color.wel_default_background_color)).thenReturn(DEFAULT_COLOR);
        lenient().when(resources.getColor(R.color.wel_white)).thenReturn(Color.WHITE);
        lenient().when(theme.resolveAttribute(android.R.attr.colorPrimary, new TypedValue(), true)).thenReturn(false);
        lenient().when(theme.resolveAttribute(android.R.attr.colorPrimary, new TypedValue(), true)).thenReturn(false);
        when(context.getResources()).thenReturn(resources);
        when(context.getTheme()).thenReturn(theme);
    }


}
