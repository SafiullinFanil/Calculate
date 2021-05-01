package com.example.calculate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var model: Model
        setOnClickListenerB()
        
    }

    private fun setOnClickListenerB(){

        btn_0.setOnClickListener{setTextFields("0")}
        btn_1.setOnClickListener{setTextFields("1")}
        btn_2.setOnClickListener{setTextFields("2")}
        btn_3.setOnClickListener{setTextFields("3")}
        btn_4.setOnClickListener{setTextFields("4")}
        btn_5.setOnClickListener{setTextFields("5")}
        btn_6.setOnClickListener{setTextFields("6")}
        btn_7.setOnClickListener{setTextFields("7")}
        btn_8.setOnClickListener{setTextFields("8")}
        btn_9.setOnClickListener{setTextFields("9")}

        btn_minus.setOnClickListener{setTextFields("-")}
        btn_sum.setOnClickListener{setTextFields("+")}
        btn_div.setOnClickListener{setTextFields("/")}
        btn_multip.setOnClickListener{setTextFields("*")}
        btn_left.setOnClickListener { setTextFields("(") }
        btn_rig.setOnClickListener { setTextFields(")") }
        btn_point.setOnClickListener{ setTextFields(".")}

        btn_AC.setOnClickListener{
            btnAC()
        }

        btn_Back.setOnClickListener{
            btnBack()
        }

        btn_equal.setOnClickListener{
            onClickEquals()
        }
    }

    private fun btnBack(){
        val str = math_operation.text.toString()
        if(str.isNotEmpty())
            math_operation.text = str.substring(0, str.length - 1)
        result_text.text = ""
    }

    private fun btnAC(){
        math_operation.text = ""
        result_text.text = ""
    }


    private fun onClickEquals(){
        try {

            val model = Model(math_operation.text.toString())
            //val ex = ExpressionBuilder(math_operation.text.toString()).build()
           //val result = ex.evaluate()
            val result = model.evaluateArithmeticExpression()

            val longRes = result.toLong()
            if (result == longRes.toDouble())
                result_text.text = longRes.toString()
            else
                result_text.text = result.toString()

        }catch (e: Exception){
            Log.d("Ошибка", "Ошибка ${e.message}")

        }
    }


     private fun setTextFields(str:String){
        if (result_text.text != "")
            math_operation.text = result_text.text
            result_text.text = ""

        math_operation.append(str)
    }
}