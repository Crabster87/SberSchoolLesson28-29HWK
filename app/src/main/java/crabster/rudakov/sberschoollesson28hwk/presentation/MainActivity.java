package crabster.rudakov.sberschoollesson28hwk.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import crabster.rudakov.sberschoollesson28hwk.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.bookList);

        MainViewModel viewModel = new ViewModelProvider(this, new BooksViewModelFactory(this))
                .get(MainViewModel.class);
        viewModel.getBooksData().observe(this, books -> listView.setAdapter(new BooksAdapter(books)));
    }

}