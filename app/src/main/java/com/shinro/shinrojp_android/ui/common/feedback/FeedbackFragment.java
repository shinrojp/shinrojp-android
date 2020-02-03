package com.shinro.shinrojp_android.ui.common.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textview.MaterialTextView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseDialog;
import com.shinro.shinrojp_android.bases.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FeedbackFragment extends BaseFragment implements FeedbackContract.View, RatingBar.OnRatingBarChangeListener {

    private Unbinder unbinder;
    private float rateValues;

    @BindView(R.id.rbFeedback) RatingBar rbFeedback;
    @BindView(R.id.tvRateCount) MaterialTextView tvRateCount;
    @BindView(R.id.tvRateMessage) MaterialTextView tvRateMessage;

    private FeedbackContract.Presenter mPresenter = new FeedbackPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_back_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        rbFeedback.setOnRatingBarChangeListener(this);
    }

    private void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        rateValues = rbFeedback.getRating();
        tvRateCount.setText("You rated : " + rateValues + "/5 .");
        if(rateValues < 1) {
            tvRateMessage.setText(getString(R.string.feedback_zero_start));
        }else if(rateValues < 2) {
            tvRateMessage.setText(getString(R.string.feedback_one_start));
        }else if(rateValues < 3) {
            tvRateMessage.setText(getString(R.string.feedback_two_start));
        }else if(rateValues < 4) {
            tvRateMessage.setText(getString(R.string.feedback_three_start));
        }else if(rateValues < 5) {
            tvRateMessage.setText(getString(R.string.feedback_four_start));
            onReceiveFeedback();
        }else if(rateValues == 5) {
            tvRateMessage.setText(getString(R.string.feedback_five_start));
        }

        onReceiveFeedback();
    }

    private void onReceiveFeedback() {
        BaseDialog dialog = new BaseDialog(getActivity());
                dialog.setTitle(getString(R.string.feedback_dialog_title))
                .setMessage(getString(R.string.feedback_dialog_message))
                .setPositiveButton(getString(R.string.feedback_dialog_positive_button), (dialog1, which) -> {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareSubject = getResources().getString(R.string.feedback_subject);
                    String shareBody = getResources().getString(R.string.feedback_content);
                    intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(intent, "Share via"));
                })
                .setNeutralButton(getString(R.string.feedback_dialog_neutral_button), (dialog1, which) -> dialog.dismissDialog())
                .setNegativeButton(getString(R.string.feedback_dialog_negative_button), (dialog1, which) -> dialog.dismissDialog())
                .setCancelable(true)
                .showDialog();
    }

}
