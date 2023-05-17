package com.stephentuso.welcomeexample;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

import pl.waskysoft.welcome.sample.R;

/**
 * Created by stephentuso on 10/5/16.
 */

public class NoSkipWelcomeActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimary)
                .defaultTitleTypefacePath("Roboto-Bold.ttf")
                .defaultHeaderTypefacePath("Roboto-Bold.ttf")
                .page(new BasicPage(R.drawable.ic_image_white,
                        "No skip",
                        "canSkip(false) was called on the builder"))
                .page(new BasicPage(R.drawable.ic_back_white,
                        "Back behaviour",
                        "Pressing back on the first page will finish this with RESULT_CANCELED"))
                .page(new BasicPage(R.drawable.ic_check_white,
                        "Completion",
                        "RESULT_OK will only be returned after navigating all the way to the end"))
                .canSkip(false)
                .swipeToDismiss(true)
                .build();
    }

}
