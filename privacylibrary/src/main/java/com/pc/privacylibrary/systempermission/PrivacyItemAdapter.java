package com.pc.privacylibrary.systempermission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pc.privacylibrary.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author: xyc
 * @date: 2022/3/22
 * @describe：
 */
public class PrivacyItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<PrivacyBean> dataList;
    private final LayoutInflater inflater;

    public PrivacyItemAdapter(Context context, List<PrivacyBean> dataList) {
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.privacy_item_view, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (!(holder instanceof ItemViewHolder) || dataList == null) {
            return;
        }
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
         PrivacyBean bean = dataList.get(position);
        itemHolder.tvName.setText(bean.getName());
        if (bean.getLeftIcon() != 0) {
            itemHolder.ivLeftIcon.setVisibility(View.VISIBLE);
            itemHolder.ivLeftIcon.setImageResource(bean.getLeftIcon());
        }else {
            itemHolder.ivLeftIcon.setVisibility(View.GONE);
        }
        if (bean.getRightIcon() != 0) {
            itemHolder.ivLeftIcon.setImageResource(bean.getRightIcon());
        }
        if (itemClickListener != null) {
            itemHolder.itemView.setTag(bean);
            itemHolder.itemView.setOnClickListener(itemClickListener);
        }
    }

    private View.OnClickListener itemClickListener;

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLeftIcon;
        TextView tvName;
        ImageView ivRightIcon;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLeftIcon = itemView.findViewById(R.id.ivLeftIcon);
            tvName = itemView.findViewById(R.id.tvName);
            ivRightIcon = itemView.findViewById(R.id.ivRightIcon);
        }

    }

}
