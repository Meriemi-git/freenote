package fr.aboucorp.freenote.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.models.TextNote;

public class TextNoteBaseAdapter extends BaseAdapter {

    private final Activity context;
    private final List<TextNote> textNotes;

    public TextNoteBaseAdapter(Activity context, List<TextNote> textNotes) {
        this.context = context;
        this.textNotes = textNotes;
    }

    @Override
    public int getCount() {
        return textNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextNote textNote = this.textNotes.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.note_item_layout, null);
        }

        // 3
        final TextView note_title = (TextView)convertView.findViewById(R.id.note_layout_txt);
        final TextView note_txt = (TextView)convertView.findViewById(R.id.note_layout_txt);

        // 4
        note_title.setText(textNote.title);
        note_txt.setText(textNote.text);

        return convertView;
    }
}
