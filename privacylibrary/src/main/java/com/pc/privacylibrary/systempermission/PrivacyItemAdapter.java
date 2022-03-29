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
    private Context mContext;

    public PrivacyItemAdapter(Context context, List<PrivacyBean> dataList) {
        this.dataList = dataList;
        mContext = context;
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
        if (bean.getRightIcon() != 0) {
            itemHolder.ivRightIcon.setImageResource(bean.getRightIcon());
        }
        if (bean.isGranted()) {
            itemHolder.tvGrandState.setText("已开启");
            itemHolder.tvGrandState.setTextColor(mContext.getResources().getColor(R.color.color_AAAAAA));
        } else {
            itemHolder.tvGrandState.setText("去设置");
            itemHolder.tvGrandState.setTextColor(mContext.getResources().getColor(R.color.color_007AFF));
        }
        itemHolder.tvSubDsc.setText(bean.getIntroduce() == null ? "" : bean.getIntroduce());
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
        TextView tvName;
        TextView tvSubDsc;
        TextView tvGrandState;
        ImageView ivRightIcon;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGrandState = itemView.findViewById(R.id.tvGrandState);
            tvName = itemView.findViewById(R.id.tvName);
            tvSubDsc = itemView.findViewById(R.id.tvSubDsc);
            ivRightIcon = itemView.findViewById(R.id.ivRightIcon);
        }

    }

}
