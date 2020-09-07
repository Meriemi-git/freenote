package fr.aboucorp.freenote.activities.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.adapters.TextNoteViewAdapter;
import fr.aboucorp.freenote.models.TextNote;
import fr.aboucorp.freenote.viewmodels.TextNoteViewModel;

public class NotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextNoteViewModel viewModel;
    private TextNoteViewAdapter textNoteViewAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewModel = new ViewModelProvider(this).get(TextNoteViewModel.class);
        viewModel.getTextNotes().observe(getActivity(), userListUpdateObserver);
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 -> NavHostFragment.findNavController(NotesFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));
        this.recyclerView = view.findViewById(R.id.fragment_notes_recycle);


    }

    Observer<List<TextNote>> userListUpdateObserver = new Observer<List<TextNote>>() {
        @Override
        public void onChanged(List<TextNote> textNotes) {
            Log.i("FreeNote",textNotes.size() + "");
            textNoteViewAdapter = new TextNoteViewAdapter(getActivity(),textNotes);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(textNoteViewAdapter);
        }
    };
}