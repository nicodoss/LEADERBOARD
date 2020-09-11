package com.e.leaderboard;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LeaderFragment extends Fragment {
    RecyclerView recyclerView;
    Context ctx;
    Adapter adapter;
    List<LeaderBoardresult> leaderBoardresultList=new ArrayList<>();;
    private static String jsonurl = "https://gadsapi.herokuapp.com/api/hours";
    View v;
    public LeaderFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_leader,container,false);
        v.getContext();
        System.out.println(leaderBoardresultList.size());
        recyclerView=v.findViewById(R.id.leadersitem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter=new Adapter(getContext(),leaderBoardresultList);
        recyclerView.setAdapter(adapter);
        extractleaderresult();
        return v;


    }

    private void extractleaderresult () {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, jsonurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        LeaderBoardresult LDB = new LeaderBoardresult();
                        LDB.setName(jsonObject.getString("name"));
                        LDB.setHours(jsonObject.getString("hours") + " learning hours" + ", " + jsonObject.getString("country"));
                        LDB.setImagecover(jsonObject.getString("badgeUrl"));
                        leaderBoardresultList.add(LDB);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }
}
