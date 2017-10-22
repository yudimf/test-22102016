package yudimf.id.prelo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yudimf.id.prelo.R;
import yudimf.id.prelo.models.Item;

/**
 * Created by yudimf on 21/10/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private List<Item> itemList;

    private Context mContext;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.mContext = context;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View itemView = inflater.inflate(R.layout.recycle_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);

        ImageView itemImage = holder.itemImage;
        Glide.with(mContext).load(item.getUrl()).centerCrop().into(itemImage);
        TextView itemName = holder.itemName;
        itemName.setText(item.getName());
        TextView itemPrice = holder.itemPrice;
        itemPrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemName;
        public TextView itemPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
