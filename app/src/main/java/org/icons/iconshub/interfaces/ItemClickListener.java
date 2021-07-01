package org.icons.iconshub.interfaces;

import android.view.View;

public interface ItemClickListener {
    default void onClick(View view, int position) {

    }

    default void onClick(String s){

    }
}
