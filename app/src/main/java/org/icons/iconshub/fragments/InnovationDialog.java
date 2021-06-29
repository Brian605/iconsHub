package org.icons.iconshub.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.icons.iconshub.R;
import org.icons.iconshub.adapters.GalleryAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InnovationDialog extends DialogFragment {

    RecyclerView recyclerView;
    MaterialToolbar toolbar;
    ExtendedFloatingActionButton fab;
    GalleryAdapter adapter;
    List<Integer> imagesList;

    public static void showDialog(FragmentManager manager){
    InnovationDialog dialog=new InnovationDialog();
        dialog.show(manager,"innovation");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_IconsHub_FullScreenDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog=getDialog();
        if (dialog!=null){
            int width= ViewGroup.LayoutParams.MATCH_PARENT;
            int height=ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width,height);
            dialog.getWindow().setWindowAnimations(R.style.Theme_IconsHub_Slide);
        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.innovation_layout,container,false);
        recyclerView=view.findViewById(R.id.recycler);
        toolbar=view.findViewById(R.id.toolBar);
        fab=view.findViewById(R.id.btnSubscribe);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

imagesList=new ArrayList<>();
imagesList.addAll(Arrays.asList(R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c3));

        adapter=new GalleryAdapter(getActivity(),imagesList);

return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
