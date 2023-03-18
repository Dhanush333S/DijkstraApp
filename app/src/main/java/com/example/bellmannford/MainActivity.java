package com.example.bellmannford;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        int[] arr=bundle.getIntArray("number");

        BellmanFord bellmanFord = new BellmanFord();

        // create input graph
        BellmanFord.V = 5;
        BellmanFord.E = 14;
        BellmanFord.edges = new BellmanFord.Edge[BellmanFord.E];
        BellmanFord.edges[0] = new BellmanFord.Edge(0, 1, arr[0]);
        BellmanFord.edges[1] = new BellmanFord.Edge(0, 2, arr[1]);
        BellmanFord.edges[2] = new BellmanFord.Edge(1, 2, arr[2]);
        BellmanFord.edges[3] = new BellmanFord.Edge(1, 3, arr[3]);
        BellmanFord.edges[4] = new BellmanFord.Edge(2, 3, arr[4]);
        BellmanFord.edges[5] = new BellmanFord.Edge(2, 4, arr[5]);
        BellmanFord.edges[6] = new BellmanFord.Edge(3, 4, arr[6]);
        BellmanFord.edges[7] = new BellmanFord.Edge(1, 0, arr[0]);
        BellmanFord.edges[8] = new BellmanFord.Edge(2, 0, arr[1]);
        BellmanFord.edges[9] = new BellmanFord.Edge(2, 1, arr[2]);
        BellmanFord.edges[10] = new BellmanFord.Edge(3, 1, arr[3]);
        BellmanFord.edges[11] = new BellmanFord.Edge(3, 2, arr[4]);
        BellmanFord.edges[12] = new BellmanFord.Edge(4, 2, arr[5]);
        BellmanFord.edges[13] = new BellmanFord.Edge(4, 3, arr[6]);
//        BellmanFord.edges[7] = new BellmanFord.Edge(4, 3, -3);



        BellmanFord.dist = new int[BellmanFord.V];

        int src = 0;
        bellmanFord.bellmanFord(src);

        // print shortest distances
        for (int i = 0; i < BellmanFord.V; i++) {
            if (BellmanFord.dist[i] == BellmanFord.INF)
                Log.d("Shortest Distance", "Vertex " + i + ": INF");
            else
                Log.d("Shortest Distance", "Vertex " + i + ": " + BellmanFord.dist[i]);
        }

        radioGroup=findViewById(R.id.radioGroup);
        cost=findViewById(R.id.cost);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.one:
                        cost.setText(Integer.toString(BellmanFord.dist[1]));
                        break;
                    case R.id.two:
                        cost.setText(Integer.toString(BellmanFord.dist[2]));
                        break;
                    case R.id.three:
                        cost.setText(Integer.toString(BellmanFord.dist[3]));
                        break;
                    case R.id.four:
                        cost.setText(Integer.toString(BellmanFord.dist[4]));
                        break;
                    default:cost.setText("0");
                }
            }
        });
    }
}