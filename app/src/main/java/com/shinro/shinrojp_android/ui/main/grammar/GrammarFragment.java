package com.shinro.shinrojp_android.ui.main.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.adapters.GrammarItemAdapter;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.helpers.database.DatabaseAccess;
import com.shinro.shinrojp_android.models.Grammar.Example;
import com.shinro.shinrojp_android.models.ItemGrammar;
import com.shinro.shinrojp_android.ui.main.grammar.detail.DetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GrammarFragment extends BaseFragment implements GrammarContract.View , GrammarItemAdapter.ItemClickListener {
    private GrammarItemAdapter adapter;
    @BindView(R.id.rcv_grammer) RecyclerView recyclerView;

    private GrammarContract.Presenter mPresenter = new GrammarPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grammar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        //test
        List <Example> listExampleG = DatabaseAccess.getInstance(getContext()).getExample();
        ArrayList<ItemGrammar> itemGrammars = new ArrayList();
        for (Example ex:listExampleG) {
            ItemGrammar grammar =new ItemGrammar (ex.getId().toString(),ex.getSentence());
            itemGrammars.add(grammar);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GrammarItemAdapter(getContext(), itemGrammars);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onItemClick(View view, int position) {
        Fragment fragment = new DetailFragment();
        replaceFragment(R.id.frameContainer, fragment);
    }
}
