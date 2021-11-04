package crabster.rudakov.sberschoollesson28hwk.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import crabster.rudakov.sberschoollesson28hwk.data.database.BookDbHelper;
import crabster.rudakov.sberschoollesson28hwk.data.repository.BooksRepositoryImpl;
import crabster.rudakov.sberschoollesson28hwk.domain.BooksInteractor;

public class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final Context mAppContext;

    public BooksViewModelFactory(@NonNull Context context) {
        mAppContext = context.getApplicationContext();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(new BooksInteractor(new BooksRepositoryImpl(new BookDbHelper(mAppContext))));
    }

}