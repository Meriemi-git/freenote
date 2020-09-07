package fr.aboucorp.freenote.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.models.TextNote;

public class TextNoteRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Activity context;
    private final List<TextNote> textNotes;

    public TextNoteRecyclerViewAdapter(Activity context, List<TextNote> textNotes) {
        this.context = context;
        this.textNotes = textNotes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.note_item_layout,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextNote textNote = textNotes.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;
        viewHolder.note_layout_title.setText(textNote.title);
        viewHolder.note_layout_txt.setText(textNote.text);
    }

    @Override
    public int getItemCount() {
        return this.textNotes.size();
    }



}
class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
    public TextView note_layout_title;
    public TextView note_layout_txt;

    public RecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        note_layout_title = itemView.findViewById(R.id.note_layout_title);
        note_layout_txt = itemView.findViewById(R.id.note_layout_txt);
    }
}