package com.example.ta_prakppb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ta_prakppb.api.ApiClient;
import com.example.ta_prakppb.api.DataGundam;
import com.example.ta_prakppb.api.DataMovie;
import com.example.ta_prakppb.api.ListGundamResponse;
import com.example.ta_prakppb.api.ListMovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesFragment extends Fragment {
    ImageSlider imageSlider;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<DataModel> dataGambar;
    private List<DataMovie> listItem2;

    public MoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesFragment newInstance(String param1, String param2) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        imageSlider = view.findViewById(R.id.imageSlide);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.film_no1,null));
        imageList.add(new SlideModel(R.drawable.film_no2,null));
        imageList.add(new SlideModel(R.drawable.film_no3,null));
        imageList.add(new SlideModel(R.drawable.film_no4,null));

        imageSlider.setImageList(imageList);
        initRecyclerView2(view);
        return view;

    }

    private void initRecyclerView2(View view){
        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(layoutManager);

        dataGambar = new ArrayList<>();

        DataModel ob1 = new DataModel(R.drawable.icon_f_1);
        dataGambar.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.icon_f_2);
        dataGambar.add(ob2);

        DataModel ob3 = new DataModel(R.drawable.icon_f_3);
        dataGambar.add(ob3);

        DataModel ob4 = new DataModel(R.drawable.icon_f_4);
        dataGambar.add(ob4);

        DataModel ob5 = new DataModel(R.drawable.icon_f_5);
        dataGambar.add(ob5);

        for (int i = 6; i <= 23; i++) {
            DataModel ob = new DataModel(R.drawable.group_1);
            dataGambar.add(ob);
        }

        ApiClient.getService().getListMovie().enqueue(new Callback<ListMovieResponse>() {
            @Override

            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("MyTag", "Berhasil ter fetch ");
                    listItem2 = (response.body().getResponse());

                    RecyclerViewAdapter2 adapter = new RecyclerViewAdapter2(listItem2, getActivity(),dataGambar);
                    recyclerView2.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                Log.e("MyTag", "Result of division: ", t);
            }
        });

    }
}