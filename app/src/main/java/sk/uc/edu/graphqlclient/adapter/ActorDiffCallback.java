package sk.uc.edu.graphqlclient.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

import sk.uc.edu.graphqlclient.GetTodosQuery;

/**
 * Created by malobicky
 * on 8.9.17.
 * Bazar.sk
 */


public class ActorDiffCallback extends DiffUtil.Callback {

    private final List<GetTodosQuery.GetAll> oldList;
    private final List<GetTodosQuery.GetAll> newList;

    public ActorDiffCallback(List<GetTodosQuery.GetAll> oldList, List<GetTodosQuery.GetAll> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).toString().equals(newList.get(newItemPosition).toString());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final GetTodosQuery.GetAll oldItem = oldList.get(oldItemPosition);
        final GetTodosQuery.GetAll newItem = newList.get(newItemPosition);

        return oldItem.toString().equals(newItem.toString());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}

