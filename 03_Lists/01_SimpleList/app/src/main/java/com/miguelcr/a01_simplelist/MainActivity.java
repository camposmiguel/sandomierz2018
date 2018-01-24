package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference to the ListView component
        lista = findViewById(R.id.listViewStudents);

        // 2. list of students > initialize > add student names
        studentList = new ArrayList<>();
        studentList.add("Jakub I");
        studentList.add("Kamil");
        studentList.add("Adrian");
        studentList.add("Maciej");
        studentList.add("Karolina");
        studentList.add("Christina");
        studentList.add("Filip");
        studentList.add("Danil");
        studentList.add("Martin");
        studentList.add("Maciek");
        studentList.add("Marcel");
        studentList.add("Bartek I");
        studentList.add("Bartek II");
        studentList.add("Jakub II");
        studentList.add("Michal");

        // 3. Create the adapter
        ArrayAdapter studentAdapter = new ArrayAdapter<String>(
              MainActivity.this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        // 4. Connect the adapter with the ListView component
        lista.setAdapter(studentAdapter);

    }
}
