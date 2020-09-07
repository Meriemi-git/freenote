package fr.aboucorp.freenote.views.fragments;

import android.os.Bundle;
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
import fr.aboucorp.freenote.adapters.TextNoteRecyclerViewAdapter;
import fr.aboucorp.freenote.models.TextNote;
import fr.aboucorp.freenote.viewmodels.TextNoteViewModel;

public class NoteListFragment extends Fragment {
    private TextNoteViewModel viewModel;
    private RecyclerView recyclerView;
    private TextNoteRecyclerViewAdapter textNoteRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        viewModel = new ViewModelProvider(this).get(TextNoteViewModel.class);
        viewModel.getTextNotes().observe(getActivity(), userListUpdateObserver);
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            this.recyclerView = view.findViewById(R.id.fragment_notes_recycle);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 ->  NavHostFragment.findNavController(NoteListFragment.this)
                .navigate(R.id.action_noteListFragment_to_addNoteFragment));
    }

    Observer<List<TextNote>> userListUpdateObserver = new Observer<List<TextNote>>() {
        @Override
        public void onChanged(List<TextNote> textNotes) {
            textNoteRecyclerViewAdapter = new TextNoteRecyclerViewAdapter(getActivity(),textNotes);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(textNoteRecyclerViewAdapter);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
    }
}
