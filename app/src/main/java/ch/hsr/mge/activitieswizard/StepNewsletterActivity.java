package ch.hsr.mge.activitieswizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class StepNewsletterActivity extends AppCompatActivity {

    private UserRegistrationData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_newsletter);

        data = (UserRegistrationData) getIntent().getSerializableExtra(Constants.REGISTRATION_DATA);

        TextView question = findViewById(R.id.newsletterTextView);
        Switch newsletter = findViewById(R.id.newsletterSwitch);
        question.setText(data.getName() + ", möchten Sie unseren Newsletter abonnieren?");

        findViewById(R.id.nextButton).setOnClickListener(v -> {
            boolean wantsNewsletter = newsletter.isChecked();
            data.setNewsletter(wantsNewsletter);

            Intent intent;
            if (wantsNewsletter) {
                intent = new Intent(this, StepSubscribedActivity.class);
            } else {
                intent = new Intent(this, StepDoneActivity.class);
            }

            intent.putExtra(Constants.REGISTRATION_DATA, data);
            startActivity(intent);
        });
    }
}
