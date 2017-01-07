package com.techpalle.viewpagerwithdatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragTwo extends Fragment {
    ListView listView;
    Cursor c;
    MyDatabase myDatabase;
    SimpleCursorAdapter simpleCursorAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
    }

    public FragTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag_two, container, false);
        listView= (ListView) v.findViewById(R.id.listview1);
        MainActivity mainActivity = (MainActivity) getActivity();
        c= mainActivity.myDataBase.queryStudent();
        simpleCursorAdapter = new SimpleCursorAdapter(getActivity()
                ,R.layout.row,c,new String[]{"_id","sname","ssubject","semail"},new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,}) ;
        listView.setAdapter(simpleCursorAdapter);

        return v;
    }

}
