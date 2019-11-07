package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        check_button.setOnClickListener {
            clickHandlerFunction(it)
        }
    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {
        // Add code to perform the button click event
        val carprice = findViewById<EditText>(R.id.price).text.toString()
        val downpay = findViewById<EditText>(R.id.downpay).text.toString()
        val loanperiod = findViewById<EditText>(R.id.period).text.toString()
        val interest = findViewById<EditText>(R.id.rate).text.toString()

        val l:Double = carprice.toDouble() - downpay.toDouble();
        val i:Double = l * interest.toDouble() * loanperiod.toDouble();
        val r:Double = (l+i) / loanperiod.toDouble()/ 12.000;

        val result = findViewById<TextView>(R.id.result_text)
        val carloan = findViewById<TextView>(R.id.carloan_text)
        val interestCal = findViewById<TextView>(R.id.interest_text)
        val repay = findViewById<TextView>(R.id.repay_text)
        val resultloan = findViewById<TextView>(R.id.result_loan)
        val result_int = findViewById<TextView>(R.id.result_Int)
        val result_pay = findViewById<TextView>(R.id.result_pay)

        result.visibility = View.VISIBLE
        carloan.visibility = View.VISIBLE
        interestCal.visibility = View.VISIBLE
        repay.visibility = View.VISIBLE
        resultloan.visibility = View.VISIBLE
        result_int.visibility = View.VISIBLE
        result_pay.visibility = View.VISIBLE

        resultloan.text = "RM" + "%.2f".format(l)
        result_int.text = "RM" + "%.2f".format(i)
        result_pay.text = "RM" + "%.2f".format(r)
    }
}
