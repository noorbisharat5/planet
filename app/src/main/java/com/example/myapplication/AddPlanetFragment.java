package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPlanetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlanetFragment extends Fragment {

    private FireBaseServices fbs;
    private EditText etName,  etColor, etSize, etOrbit ;
    private Button btnAdd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public AddPlanetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddRestaurantFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPlanetFragment newInstance(String param1, String param2) {
        AddPlanetFragment fragment = new AddPlanetFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectComponents();

    }

    private void connectComponents() {
        fbs = FireBaseServices.getInstance();
        etName = getView().findViewById(R.id.etNameAddPlanetFragment);
        etOrbit = getView().findViewById(R.id.etOrbitAddPlanetFragment);
        etColor = getView().findViewById(R.id.etColorAddPlanetFragment);
        etSize = getView().findViewById(R.id.etColorAddPlanetFragment);





        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                String name = etName.getText().toString();
                String color = etColor.getText().toString();
                String orbit = etOrbit.getText().toString();
                String size = etSize.getText().toString();

                // data validation
                if (name.trim().isEmpty() || color.trim().isEmpty() ||
                        orbit.trim().isEmpty() || size.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }

                // add data to fireStore

                AddPlanetFragment rest = new AddPlanetFragment();

                Task<DocumentReference> Planet = fbs.getFire().collection("planet").add(rest).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your restaurant!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> Log.e("Failure AddPlanet: ", Objects.requireNonNull(e.getMessage())));


            }
        });
    }
}