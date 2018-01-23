package com.miguelcr.a03_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView tl, tc, tr, ml, mc, mr, bl, bc, br;
    Boolean turn = true;
    Integer AndroidID, HumanID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = findViewById(R.id.imageViewTL);
        tl.setTag(1);
        tc = findViewById(R.id.imageViewTC);
        tc.setTag(2);
        tr = findViewById(R.id.imageViewTR);
        tr.setTag(3);
        ml = findViewById(R.id.imageViewML);
        ml.setTag(4);
        mc = findViewById(R.id.imageViewMC);
        mc.setTag(5);
        mr = findViewById(R.id.imageViewMR);
        mr.setTag(6);
        bl = findViewById(R.id.imageViewBL);
        bl.setTag(7);
        bc = findViewById(R.id.imageViewBC);
        bc.setTag(8);
        br = findViewById(R.id.imageViewBR);
        br.setTag(9);


    }

    public void tap(View v){
        ImageView image = findViewById(v.getId());

        if (turn){
            image.setImageResource(R.drawable.ic_android_black_24dp);
            image.setTag(R.drawable.ic_android_black_24dp);
            AndroidID = (Integer) image.getTag();
            checkVictory();
            turn = false;
            image.setEnabled(false);

        }else{
            image.setImageResource(R.drawable.ic_accessibility_black_24dp);
            image.setTag(R.drawable.ic_accessibility_black_24dp);
            AndroidID = (Integer) image.getTag();
            checkVictory();
            turn = true;
            image.setEnabled(false);

        }
    }

    public void checkVictory(){
        if((Integer)tl.getTag() == AndroidID && (Integer)tc.getTag() == AndroidID && (Integer)tr.getTag() == AndroidID ||
                (Integer)ml.getTag() == AndroidID && (Integer)mc.getTag() == AndroidID && (Integer)mr.getTag() == AndroidID ||
                (Integer)bl.getTag() == AndroidID && (Integer)bc.getTag() == AndroidID && (Integer)br.getTag() == AndroidID ||
                (Integer)tl.getTag() == AndroidID && (Integer)ml.getTag() == AndroidID && (Integer)bl.getTag() == AndroidID ||
                (Integer)tc.getTag() == AndroidID && (Integer)mc.getTag() == AndroidID && (Integer)bc.getTag() == AndroidID ||
                (Integer)tr.getTag() == AndroidID && (Integer)mr.getTag() == AndroidID && (Integer)br.getTag() == AndroidID ||
                (Integer)tl.getTag() == AndroidID && (Integer)mc.getTag() == AndroidID && (Integer)br.getTag() == AndroidID ||
                (Integer)tr.getTag() == AndroidID && (Integer)mc.getTag() == AndroidID && (Integer)bl.getTag() == AndroidID){

            Toast.makeText(this, "You win, player 1!", Toast.LENGTH_SHORT).show();
            recreate();

        }else if((Integer)tl.getTag() == HumanID && (Integer)tc.getTag() == HumanID && (Integer)tr.getTag() == HumanID ||
                (Integer)ml.getTag() == HumanID && (Integer)mc.getTag() == HumanID && (Integer)mr.getTag() == HumanID ||
                (Integer)bl.getTag() == HumanID && (Integer)bc.getTag() == HumanID && (Integer)br.getTag() == HumanID ||
                (Integer)tl.getTag() == HumanID && (Integer)ml.getTag() == HumanID && (Integer)bl.getTag() == HumanID ||
                (Integer)tc.getTag() == HumanID && (Integer)mc.getTag() == HumanID && (Integer)bc.getTag() == HumanID ||
                (Integer)tr.getTag() == HumanID && (Integer)mr.getTag() == HumanID && (Integer)br.getTag() == HumanID ||
                (Integer)tl.getTag() == HumanID && (Integer)mc.getTag() == HumanID && (Integer)br.getTag() == HumanID ||
                (Integer)tr.getTag() == HumanID && (Integer)mc.getTag() == HumanID && (Integer)bl.getTag() == HumanID){

            Toast.makeText(this, "You win, player 2!", Toast.LENGTH_SHORT).show();
            recreate();

        }
    }
}
