package org.icons.iconshub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import org.icons.iconshub.R;
import org.icons.iconshub.R2;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FaqsAdapter extends RecyclerView.Adapter<FaqsAdapter.Holder> {

    private Context context;
    private List<String> titleList;
    private List<String> descriptionList;
    public static HashMap<String,Boolean> selectStatus=new HashMap<>();

    public FaqsAdapter(Context context, List<String> titleList, List<String> descriptionList) {
        this.context = context;
        this.titleList = titleList;
        this.descriptionList = descriptionList;

    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faq_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FaqsAdapter.Holder holder, int position) {
String title=titleList.get(position);
        selectStatus.put(title,false);
holder.titleView.setText(title);
holder.bodyView.setText(descriptionList.get(position));

Animation slideDown= AnimationUtils.loadAnimation(context,R.anim.slide_down);
Animation slideUp= AnimationUtils.loadAnimation(context,R.anim.slide_down);

holder.headerLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if (selectStatus.get(title)){
holder.toggleIcon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_keyboard_arrow_right_24));
selectStatus.put(title,false);
holder.bodyLayout.startAnimation(slideUp);
holder.bodyLayout.setVisibility(View.GONE);
}else {
    holder.toggleIcon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_keyboard_arrow_down_24));
    selectStatus.put(title,true);
    holder.bodyLayout.setVisibility(View.VISIBLE);
    holder.bodyLayout.startAnimation(slideDown);

}

    }
});

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
          @BindView(R2.id.faqHead)
          MaterialTextView titleView;

          @BindView(R2.id.faqAnswer)
          MaterialTextView bodyView;

          @BindView(R2.id.header)
        RelativeLayout headerLayout;

          @BindView(R2.id.recycler)
          RecyclerView recyclerView;

          @BindView(R2.id.faqBody)
          RelativeLayout bodyLayout;

          @BindView(R2.id.toggleIcon)
        CircleImageView toggleIcon;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
