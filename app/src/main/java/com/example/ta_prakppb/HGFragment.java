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
import com.example.ta_prakppb.api.ListGundamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HGFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HGFragment extends Fragment {
    ImageSlider imageSlider;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<DataGundam> listItem;

    private List<DataModel> dataGambar;

    public HGFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HGFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HGFragment newInstance(String param1, String param2) {
        HGFragment fragment = new HGFragment();
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
        View view = inflater.inflate(R.layout.fragment_h_g, container, false);
        imageSlider = view.findViewById(R.id.imageSlide);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.hg_top1,null));
        imageList.add(new SlideModel(R.drawable.mg_top1,null));
        imageList.add(new SlideModel(R.drawable.pg_top1,null));
        imageList.add(new SlideModel(R.drawable.rg_top1,null));

        imageSlider.setImageList(imageList);

        initRecyclerView(view);
        return view;

    }

    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        dataGambar = new ArrayList<>();

        DataModel ob1 = new DataModel(R.drawable.barbatos);
        dataGambar.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.force_impulse);
        dataGambar.add(ob2);

        DataModel ob3 = new DataModel(R.drawable.gundam_ds);
        dataGambar.add(ob3);

        DataModel ob4 = new DataModel(R.drawable.kyrios);
        dataGambar.add(ob4);

        DataModel ob5 = new DataModel(R.drawable.ps_gundam);
        dataGambar.add(ob5);

        for (int i = 6; i <= 10; i++) {
            DataModel ob = new DataModel(R.drawable.group_1);
            dataGambar.add(ob);
        }

        ApiClient.getService().getListHg().enqueue(new Callback<ListGundamResponse>() {
            @Override
            public void onResponse(Call<ListGundamResponse> call, Response<ListGundamResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("MyTag", "Berhasil ter fetch ");
                    listItem = (response.body().getResponse());

                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(listItem, getActivity(),dataGambar);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListGundamResponse> call, Throwable t) {
                Log.e("MyTag", "Result of division: ", t);
            }
        });

    }

}