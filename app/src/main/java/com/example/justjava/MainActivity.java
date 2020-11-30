package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;

    /**
     * this method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /**
     * this method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }
    /**
     * this method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);

    }
    /**'
     * calculate the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }
    private String createOrderSummary(int price) {
        String priceMessage = "\nName: Abderazzzaq Essalhi";
        priceMessage = priceMessage + "\nquantity:" + quantity;
        priceMessage = priceMessage +"\nTotal: $ " +  price;
        priceMessage = priceMessage + "\nthank you!";
        return priceMessage;
    }


    /**
     * this method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * this  displays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * this method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        orderSummaryTextView.setTextSize(24);
        orderSummaryTextView.setTextColor(Color.RED);
    }
}