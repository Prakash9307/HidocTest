package com.example.hidoctest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hidoctest.API.Api;
import com.example.hidoctest.Adapter.NewsAdapter;
import com.example.hidoctest.R;
import com.example.hidoctest.model.ArticlesData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNews extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentNews() {
        // Required empty public constructor
    }

    private RecyclerView recycler_news;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNews.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNews newInstance(String param1, String param2) {
        FragmentNews fragment = new FragmentNews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler_news = view.findViewById(R.id.recycler_news);
        downloadNewsData();

    }

    private void setNewsData(ArrayList<ArticlesData> arrayList)
    {
        NewsAdapter newsAdapter = new NewsAdapter(getContext(),arrayList);
        recycler_news.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_news.setItemAnimator(new DefaultItemAnimator());
        recycler_news.setAdapter(newsAdapter);
    }

    public void downloadNewsData()
    {

        Api.getClient().getArticles().
                enqueue(new Callback<ArticlesData>() {
                    @Override
                    public void onResponse(Call<ArticlesData> call,
                                           Response<ArticlesData> response) {
                        if (response.body().getStatus().equals("ok"))
                        {
                            setNewsData(response.body().getArticles());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticlesData> call, Throwable t) {

                    }
                });
    }


}