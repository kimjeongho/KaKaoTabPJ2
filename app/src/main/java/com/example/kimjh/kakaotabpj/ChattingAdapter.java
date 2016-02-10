package com.example.kimjh.kakaotabpj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChattingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ChattingData> items = new ArrayList<ChattingData>();

    private static final int VIEW_TYPE_RECEIVE = 0;
    private static final int VIEW_TYPE_SEND = 1;
    private static final int VIEW_TYPE_DATE = 2;

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof ChattReceiveData){
            return VIEW_TYPE_RECEIVE;
        } else if (data instanceof ChattSendData){
            return VIEW_TYPE_SEND;
        } else {
            return VIEW_TYPE_DATE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_RECEIVE:
                view = inflater.inflate(R.layout.chatting_receive, parent, false);
                return new ChattReceiveHolder(view);
            case VIEW_TYPE_SEND:
                view = inflater.inflate(R.layout.chatting_send, parent, false);
                return new ChattSendHolder(view);
            case VIEW_TYPE_DATE:
                view = inflater.inflate(R.layout.chatting_data, parent, false);
                return new ChattDateHolder(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case VIEW_TYPE_RECEIVE:
                ((ChattReceiveHolder)holder).setData((ChattReceiveData) items.get(position));
                break;
            case VIEW_TYPE_SEND:
                ((ChattSendHolder)holder).setData((ChattSendData) items.get(position));
                break;
            case VIEW_TYPE_DATE:
                ((ChattDateHolder)holder).setData((ChattDateData) items.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
