package com.techpalle.viewpagerwithdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragOne extends Fragment {
    EditText et1,et2,et3;
    Button b1;


    public FragOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag_one, container, false);
        et1= (EditText) v.findViewById(R.id.edittext1);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        b1= (Button) v.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= et1.getText().toString();
                String subject= et2.getText().toString();
                String email= et3.getText().toString();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.myDataBase.insertStudent(name,subject,email);
                mainActivity.notifyData();
                Toast.makeText(mainActivity, "Inserted a row", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
