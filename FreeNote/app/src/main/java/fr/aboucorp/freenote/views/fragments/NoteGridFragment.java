package fr.aboucorp.freenote.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.adapters.TextNoteBaseAdapter;
import fr.aboucorp.freenote.models.TextNote;
import fr.aboucorp.freenote.viewmodels.TextNoteViewModel;

public class NoteGridFragment extends Fragment  {

    private GridView gridView;
    private TextNoteViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        viewModel = new ViewModelProvider(this).get(TextNoteViewModel.class);
        viewModel.getTextNotes().observe(getActivity(), userListUpdateObserver);
        return inflater.inflate(R.layout.fragment_notes_grid, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.gridView = view.findViewById(R.id.fragment_notes_gridview);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 ->  NavHostFragment.findNavController(NoteGridFragment.this)
                .navigate(R.id.action_noteGridFragment_to_addNoteFragment));
    }

    Observer<List<TextNote>> userListUpdateObserver = new Observer<List<TextNote>>() {
        @Override
        public void onChanged(List<TextNote> textNotes) {
            TextNoteBaseAdapter textNoteBaseAdapter = new TextNoteBaseAdapter(getActivity(), textNotes);
            gridView.setAdapter(textNoteBaseAdapter);
        }
    };
}