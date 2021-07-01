package org.icons.iconshub.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

import org.icons.iconshub.BuildConfig;
import org.icons.iconshub.R;
import org.icons.iconshub.adapters.FaqsAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class HelpsDialog extends DialogFragment {
    MaterialToolbar toolbar;
   RecyclerView recyclerView;
   FaqsAdapter adapter;
   MaterialTextView vValue,licencesView;



    public static void showDialog(FragmentManager manager) {
        HelpsDialog dialog = new HelpsDialog();
        dialog.show(manager, "help");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_IconsHub_FullScreenDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.Theme_IconsHub_Slide);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_layout, container, false);
        toolbar = view.findViewById(R.id.toolBar);
        recyclerView=view.findViewById(R.id.recycler);
        vValue=view.findViewById(R.id.versionValue);
        licencesView=view.findViewById(R.id.licencesTitle);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> titles= Arrays.asList(getResources().getStringArray(R.array.faq_questions));
        List<String> bodies=Arrays.asList(getResources().getStringArray(R.array.faq_answers));

        adapter=new FaqsAdapter(getActivity(),titles,bodies);
        return view;
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        licencesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OssLicensesMenuActivity.class));
                dismiss();
            }
        });

        vValue.setText(String.format("%s(%s)", BuildConfig.VERSION_NAME, BuildConfig.BUILD_TYPE));
        recyclerView.setAdapter(adapter);

    }
}
