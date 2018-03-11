package sk.uc.edu.graphqlclient.adapter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sk.uc.edu.graphqlclient.GetTodosQuery;
import sk.uc.edu.graphqlclient.R;

/**
 * Created by malobicky
 * on 6.3.18.
 * AndroidClient
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    private List<GetTodosQuery.GetAll> listItems;

    public Adapter() {
        this.listItems = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        GetTodosQuery.GetAll item = listItems.get(position);
        holder.getViewById().setText(item.description());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView viewById;
        private View itemView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            viewById = itemView.findViewById(R.id.item__main_text);
            this.itemView = itemView;
        }

        public TextView getViewById() {
            return viewById;
        }


    }

    private int dataVersion = 0;

    @SuppressLint("StaticFieldLeak")
    public void swapItems(final List<GetTodosQuery.GetAll> update) {

        if (update != null) {
            if (update.isEmpty()) {
                listItems.clear();
                notifyDataSetChanged();
                return;
            }
        }
        dataVersion++;
        if (this.listItems == null) {
            if (update == null) {
                return;
            }
            this.listItems = update;
            notifyDataSetChanged();
        } else if (update == null) {
            int oldSize = this.listItems.size();
            this.listItems = null;
            notifyItemRangeRemoved(0, oldSize);
        } else {
            final int startVersion = dataVersion;
            new AsyncTask<Void, Void, DiffUtil.DiffResult>() {
                @Override
                protected DiffUtil.DiffResult doInBackground(Void... voids) {
                    return DiffUtil.calculateDiff(new ActorDiffCallback(listItems, update));
                }

                @Override
                protected void onPostExecute(DiffUtil.DiffResult diffResult) {
                    if (startVersion != dataVersion) {
                        // ignore update
                        return;
                    }
                    listItems.clear();
                    listItems.addAll(update);

                    diffResult.dispatchUpdatesTo(Adapter.this);

                }
            }.execute();
        }
    }

}
