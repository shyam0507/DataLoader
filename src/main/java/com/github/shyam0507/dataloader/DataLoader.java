package com.github.shyam0507.dataloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Shyam on 06/06/16.
 */
public class DataLoader {

    Context context;
    View view;
    View parentView;
    View loadingView;
    View errorView;
    View noDataView;

    public DataLoader(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    /*
    Function to show the data loading message on the screen
     */
    public void showLoader(String message) {
        //get the parent view for the recycler view
        ViewGroup parent = (ViewGroup) view.getParent();
        int index = parent.indexOfChild(view);

        //remove the view from parent
        parent.removeView(view);
        LayoutInflater li = LayoutInflater.from(context);
        loadingView = li.inflate(R.layout.loading_layout, parent, false);

        TextView tv_message = (TextView) loadingView.findViewById(R.id.tv_message);
        tv_message.setText(message);
        parent.addView(loadingView, index);
    }


    /*
    Function to hide the loading bar
     */
    public void hideLoader() {
        //get the parent view for the recycler view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //loadingView = li.inflate(R.layout.loading_layout, parent, false);
        parent.addView(view, index);
    }

    //function to show error message
    public void showErrorMessage(String message) {

        //get the parent view for the current loading view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //inflate the error view
        errorView = li.inflate(R.layout.error_layout, parent, false);

        //get the text message
        TextView tv_message = (TextView) errorView.findViewById(R.id.tv_message);
        tv_message.setText(message);
        parent.addView(errorView, index);//now add the error view

    }

    //function to show error message with custom icon from user
    public void showErrorMessage(String message, int resourceId) {

        //get the parent view for the current loading view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //inflate the error view
        errorView = li.inflate(R.layout.error_layout, parent, false);

        //get the text message
        TextView tv_message = (TextView) errorView.findViewById(R.id.tv_message);
        tv_message.setText(message);

        //for the custom icon
        ImageView iv_icon = (ImageView) errorView.findViewById(R.id.iv_icon);
        iv_icon.setBackgroundResource(resourceId);

        parent.addView(errorView, index);//now add the error view

    }

    //function to show message when no data is found
    public void showNoDataMessage(String message) {

        //get the parent view for the current loading view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //inflate the no data view
        noDataView = li.inflate(R.layout.no_data_layout, parent, false);

        //get the text message
        TextView tv_message = (TextView) noDataView.findViewById(R.id.tv_message);
        tv_message.setText(message);
        parent.addView(noDataView, index);//now add the error view

        //change
    }

    //function to show message when no data is found along with the retry button
    public View showNoDataMessageWithButton(String message,String buttonText) {

        //get the parent view for the current loading view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //inflate the no data view
        noDataView = li.inflate(R.layout.no_data_layout, parent, false);

        //get the text message
        TextView tv_message = (TextView) noDataView.findViewById(R.id.tv_message);
        tv_message.setText(message);

        //get the text message
        Button btn_retry = (Button) noDataView.findViewById(R.id.btn_retry);
        btn_retry.setText(buttonText);

        parent.addView(noDataView, index);//now add the error view

        return btn_retry;
    }

    //function to show message when no data is found with custom icon
    public void showNoDataMessage(String message, int resourceId) {

        //get the parent view for the current loading view
        ViewGroup parent = (ViewGroup) loadingView.getParent();
        int index = parent.indexOfChild(loadingView);

        //remove the loading view from parent
        parent.removeView(loadingView);
        LayoutInflater li = LayoutInflater.from(context);
        //inflate the no data view
        noDataView = li.inflate(R.layout.no_data_layout, parent, false);

        //get the text message
        TextView tv_message = (TextView) noDataView.findViewById(R.id.tv_message);
        tv_message.setText(message);

        //for the custom icon
        ImageView iv_icon = (ImageView) noDataView.findViewById(R.id.iv_icon);
        iv_icon.setBackgroundResource(resourceId);

        parent.addView(noDataView, index);//now add the error view
    }

}
