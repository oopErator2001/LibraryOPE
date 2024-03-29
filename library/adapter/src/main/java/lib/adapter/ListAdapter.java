package lib.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lib.user.User;

public class ListAdapter extends BaseAdapter {
    private final ArrayList<User> list;

    public ListAdapter(ArrayList<User> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.list_item, null);
        } else {
            viewProduct = convertView;
        }

        User user = (User) getItem(position);
        TextView textView = viewProduct.findViewById(R.id.list_textView);
        textView.setText(String.format("Name: %-10s Age: %s", user.getUserName(), user.getUserAge()));

        return viewProduct;
    }
}
