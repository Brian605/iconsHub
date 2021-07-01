package org.icons.iconshub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.icons.iconshub.R;
import org.icons.iconshub.R2;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ImageHolder> {

    private Context context;
    private List<Integer> imageId;

    public GalleryAdapter(Context context, List<Integer> imageId) {
        this.context = context;
        this.imageId = imageId;
    }

    @NonNull
    @NotNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GalleryAdapter.ImageHolder holder, int position) {
        int id = imageId.get(position);
        holder.imageView.setImageResource(id);

    }

    @Override
    public int getItemCount() {
        return imageId.size();
    }

    static class ImageHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.imagView)
        ImageView imageView;


        public ImageHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
