package com.shinro.shinrojp_android.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ImageViewUtils {

    public void loadAvtar(Context context, ImageView view, String sourceImage, boolean hasDefaultImageAvatar, Priority priority) {
        int defaultResourceImageAvatar = 0;
        try {
            if(hasDefaultImageAvatar) {
                Glide.with(context)
                    .load(sourceImage)
                    .priority(priority)
                    .placeholder(defaultResourceImageAvatar)
                    .error(defaultResourceImageAvatar)
                    .into(view);
            } else {
                Glide.with(context)
                    .load(sourceImage)
                    .priority(priority)
                    .error(defaultResourceImageAvatar)
                    .into(view);
            }
        } catch (Exception e) {
            AppLogger.e(e);
            try {
                Glide.with(context).load(defaultResourceImageAvatar).into(view);
            } catch (Exception e1) {
                AppLogger.e(e1);
            }
        }
    }

    public void loadImage(Context context, ImageView view, String sourceImage, Priority priority) {
        int defaultResourceImageAvatar = 0;
        try {
            Glide.with(context)
                .load(sourceImage)
                .priority(priority)
                .placeholder(defaultResourceImageAvatar)
                .error(defaultResourceImageAvatar)
                .into(view);
        } catch (Exception e) {
            AppLogger.e(e);
            try {
                Glide.with(context).load(defaultResourceImageAvatar).priority(priority).into(view);
            } catch (Exception e1) {
                AppLogger.e(e1);
            }
        }
    }

    public void loadImageWithProgressBar(Context context, ImageView view, String sourceImage, Priority priority, ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        try {
            Glide.with(context)
                    .load(sourceImage)
                    .priority(priority)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(view);
        } catch (Exception e) {
            AppLogger.e(e);
        }
    }

}
