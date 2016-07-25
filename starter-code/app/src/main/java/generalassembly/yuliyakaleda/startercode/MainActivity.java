package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText enterText;
    Button addItemButton;
    TextView wishText;
    ViewGroup wishList;


    @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      enterText = (EditText)findViewById(R.id.edit_wish);
      addItemButton = (Button) findViewById(R.id.add_wish_button);
      wishText = (TextView) findViewById(R.id.wish_text);
      wishList = (ViewGroup) findViewById(R.id.wish_list);

      addItemButton.setOnClickListener(this);


  }




  //TODO: set up all the view and event listeners.


  @Override
  public void onClick(View v) {

      String wish = enterText.getText().toString();

      if(wish.trim().equals("")){
          enterText.setError("Please Enter a Wish");
          return;
      }

      wishText.setText(wish);

      Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);

      wishText.startAnimation(animation);
      wishText.setVisibility(View.INVISIBLE);

      TextView newWish = new TextView(this);
      newWish.setTextSize(25.0f);
      newWish.setText(wish);

      animation = AnimationUtils.loadAnimation(this,R.anim.wish_animation);

      wishList.addView(newWish,0);
      newWish.startAnimation(animation);

      enterText.setText("");

  }

}