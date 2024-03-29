package crabster.rudakov.sberschoollesson28hwk.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import crabster.rudakov.sberschoollesson28hwk.domain.BooksInteractor;
import crabster.rudakov.sberschoollesson28hwk.domain.model.Book;

public class MainViewModel extends ViewModel {

    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private final MutableLiveData<List<Book>> mBooksData = new MutableLiveData<>();
    private final BooksInteractor mInteractor;

    public MainViewModel(BooksInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mExecutor.shutdownNow();
    }

    public LiveData<List<Book>> getBooksData() {
        if (!mBooksData.hasObservers()) {
            initBooksData();
        }
        return mBooksData;
    }

    public void addBooksData() {
        mExecutor.submit(() -> {
            mInteractor.addSingleBook();
            List<Book> books = mInteractor.getBooks();
            mBooksData.postValue(books);
        });
    }

    public void deleteBooksData() {
        mExecutor.submit(() -> {
            mInteractor.deleteAllBooks();
            List<Book> books = mInteractor.getBooks();
            mBooksData.postValue(books);
        });
    }

    private void initBooksData() {
        mExecutor.submit(() -> {
            List<Book> books = mInteractor.getBooks();
            mBooksData.postValue(books);
        });
    }

}
