package shishkoam.testmapcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ав on 12.06.2016
 */
public class SimpleAdapter extends ArrayAdapter<String> {
    private Context context;
    private ListHolder listHolder;
    private int dayVerse = -1;

    public SimpleAdapter(Context context, ListHolder listHolder) {
        super(context, android.R.layout.simple_list_item_1);
        this.context = context;
        this.listHolder = listHolder;
        addAll(listHolder.getNames());
    }

    public SimpleAdapter(Context context, ListHolder listHolder, int dayVerse) {
        super(context, android.R.layout.simple_list_item_1);
        this.context = context;
        this.listHolder = listHolder;
        this.dayVerse = dayVerse;
        addAll(listHolder.getNames());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView nameTV = (TextView) rowView.findViewById(R.id.text_name);
        TextView addressTV = (TextView) rowView.findViewById(R.id.text_address);
        nameTV.setText(listHolder.getNames().get(position));
        addressTV.setText(listHolder.getAddresses().get(position));
        if (listHolder.isSelected(position)) {
//            rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.select_default_color));
        } else {
            if (dayVerse == position){
//                rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.select_gold_color));
            } else {
//                rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_color));
            }
        }
        return rowView;
    }
}