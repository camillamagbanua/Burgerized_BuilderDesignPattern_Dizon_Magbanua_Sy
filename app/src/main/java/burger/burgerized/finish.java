package burger.burgerized;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class finish extends AppCompatActivity {
    TextView code, amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_done);

        code = findViewById(R.id.code);
        String paymentID = randomAlphaNumeric(9);
        code.setText(paymentID);

        amount = findViewById(R.id.amount);

        String amountView = Float.toString(your_bag.totalOrders);
        amount.setText("Payment amount: P" + amountView);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openApp = new Intent(getApplicationContext(), your_bag.class);
                    startActivity(openApp);
                    finish();
                }
            }
        };
        timer.start();
    }
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {

        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

    }
}
