package com.nayan.candyparty;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recColor, recSize;
    private SizeAdapter sizeAdapter;
    private ColorAdapter colorAdapter;
    public ArrayList<MProduct> productArrayList;
    private MProduct mProduct;
    public TextView txtPrice, txtDP, txtDPercn;
    private boolean click = false;
    private boolean click1 = false;
    private Button btnBuy, btnBuy1;
    ViewPager viewPager;
    TabLayout footerTab;

    private AdFooterTab adapterFooter;
    private static MainActivity mainActivity;

    public static MainActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dataGenerate();
        prepareDisplay();
        setupFooter();
    }

    private void init() {
        mainActivity = this;
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        footerTab = (TabLayout) findViewById(R.id.footerTab);
        txtDP = (TextView) findViewById(R.id.txtDP);
        txtDPercn = (TextView) findViewById(R.id.txtDPerc);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        mProduct = new MProduct();
        productArrayList = new ArrayList<>();
        recColor = (RecyclerView) findViewById(R.id.recColor);
        recSize = (RecyclerView) findViewById(R.id.recSize);
        colorAdapter = new ColorAdapter(this);
        sizeAdapter = new SizeAdapter(this);

    }

    private void setupFooter() {
        adapterFooter = new AdFooterTab(getSupportFragmentManager());
        adapterFooter.addFragment(FragDetail.newInstance(), "DETAIL");
        adapterFooter.addFragment(FragShiftment.newInstance(), "SHIPPING");
        adapterFooter.addFragment(FragReview.newInstance(), "REVIEW");
        viewPager.setAdapter(adapterFooter);
        footerTab.setupWithViewPager(viewPager);

    }

    private void dataGenerate() {

        mProduct.setColor(Color.GREEN);
        mProduct.setSize("x1");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(300);
        mProduct.setDiscountPrice(270);
        mProduct.setDetail("detals1");
        mProduct.setShiftment("shiftment1");
        mProduct.setReview("Review1");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.RED);
        mProduct.setSize("x2");
        mProduct.setDiscountParcentage("15%");
        mProduct.setPrice(400);
        mProduct.setDiscountPrice(360);
        mProduct.setDetail("detals2");
        mProduct.setShiftment("shiftment2");
        mProduct.setReview("Review2");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.GREEN);
        mProduct.setSize("x3");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(200);
        mProduct.setDiscountPrice(180);
        mProduct.setDetail("detals3");
        mProduct.setShiftment("shiftment3");
        mProduct.setReview("Review3");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.LTGRAY);
        mProduct.setSize("x4");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(300);
        mProduct.setDiscountPrice(270);
        mProduct.setDetail("detals4");
        mProduct.setShiftment("shiftment4");
        mProduct.setReview("Review4");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.DKGRAY);
        mProduct.setSize("x5");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(600);
        mProduct.setDiscountPrice(540);
        mProduct.setDetail("detals5");
        mProduct.setShiftment("shiftment5");
        mProduct.setReview("Review5");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.BLACK);
        mProduct.setSize("x6");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(900);
        mProduct.setDiscountPrice(810);
        mProduct.setDetail("detals6");
        mProduct.setShiftment("shiftment6");
        mProduct.setReview("Review6");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.BLUE);
        mProduct.setSize("x7");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(300);
        mProduct.setDiscountPrice(270);
        mProduct.setDetail("detals7");
        mProduct.setShiftment("shiftment7");
        mProduct.setReview("Review7");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.CYAN);
        mProduct.setSize("x8");
        mProduct.setDiscountParcentage("12%");
        mProduct.setPrice(500);
        mProduct.setDiscountPrice(440);
        mProduct.setDetail("detals8");
        mProduct.setShiftment("shiftment8");
        mProduct.setReview("Review8");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.GRAY);
        mProduct.setSize("x9");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(700);
        mProduct.setDiscountPrice(630);
        mProduct.setDetail("detals9");
        mProduct.setShiftment("shiftment9");
        mProduct.setReview("Review9");
        productArrayList.add(mProduct);
        mProduct = new MProduct();
        mProduct.setColor(Color.MAGENTA);
        mProduct.setSize("x10");
        mProduct.setDiscountParcentage("10%");
        mProduct.setPrice(1000);
        mProduct.setDiscountPrice(900);
        mProduct.setDetail("detals10");
        mProduct.setShiftment("shiftment10");
        mProduct.setReview("Review10");
        productArrayList.add(mProduct);
    }

    private void prepareDisplay() {
        txtDPercn.setText(productArrayList.get(0).getDiscountParcentage() + "");
        txtDP.setText(productArrayList.get(0).getDiscountPrice() + "");
        txtPrice.setText(productArrayList.get(0).getPrice() + "");
        productArrayList.get(0).setClick(1);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recSize.setLayoutManager(layoutManager);
        recColor.setLayoutManager(layoutManager2);
        recColor.setAdapter(colorAdapter);
        recSize.setAdapter(sizeAdapter);
        colorAdapter.setData(productArrayList);
        sizeAdapter.setData(productArrayList);
    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.btnBuy) {
//            if (click == false) {
//                btnBuy.setText("Remove");
//                click = true;
//            } else {
//                click = false;
//                btnBuy.setText("Buy");
//            }
//
//        }
//        if (view.getId() == R.id.btnBuy1) {
//            if (click1 == false) {
//                btnBuy1.setBackgroundColor(Color.GREEN);
//                click1 = true;
//            } else {
//                click1 = false;
//                btnBuy1.setBackgroundColor(Color.GRAY);
//            }
//        }
    }
}
