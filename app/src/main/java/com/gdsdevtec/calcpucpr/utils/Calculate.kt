package com.gdsdevtec.calcpucpr.utils

import androidx.appcompat.widget.AppCompatTextView
import com.gdsdevtec.calcpucpr.model.Calcule
import com.gdsdevtec.calcpucpr.setValue
import com.gdsdevtec.calcpucpr.stringValid
import com.gdsdevtec.calcpucpr.verifyExpressions

object Calculate {

    fun executeCalc(actualValue : String,operator : String, actionResult: (String) -> Unit) {
        val numbersCalc = actualValue.split(operator)
        val firstNumber = numbersCalc.first().replace(",", ".").toDouble()
        val lastNumber = numbersCalc.last().replace(",", ".").toDouble()
        calculate(
            Calcule(
                firstNumber,
                operator,
                lastNumber
            )
        ) { actionResult(it) }
    }


    private fun calculate(calculate: Calcule, actionResult: (String) -> Unit) {
        when (calculate.operator) {
            Constants.PERCENT -> {
                val result = (calculate.lastNumber * calculate.firstNumber) / 100
                actionResult.invoke(result.toString())
            }

            Constants.DIVIDER -> {
                if (calculate.firstNumber != 0.0) {
                    val result = calculate.firstNumber / calculate.lastNumber
                   actionResult(result.toString())
                } else actionResult("Error")
            }

            Constants.MULTIPLY -> {
                val result = calculate.firstNumber * calculate.lastNumber
                actionResult(result.toString())
            }

            Constants.MINUS -> {
                val result = calculate.firstNumber - calculate.lastNumber
               actionResult(result.toString())
            }

            Constants.PLUS -> {
                val result = calculate.firstNumber + calculate.lastNumber
                actionResult(result.toString())
            }
        }
    }

    fun addExpressionValue(input : AppCompatTextView,actualValue : String, value: String) {
        when (value) {
            Constants.PERCENT -> {
               input.setValue(setExpression(actualValue,value))
            }

            Constants.DIVIDER -> {
               input.setValue(setExpression(actualValue,value))
            }

            Constants.MULTIPLY -> {
               input.setValue(setExpression(actualValue,value))
            }

            Constants.MINUS -> {
               input.setValue(setExpression(actualValue,value))
            }
            Constants.PLUS -> {
               input.setValue(setExpression(actualValue,value))
            }
        }
    }

    fun setNumberValue(actualValue : String, number: String,result : (String)->Unit)  {
        val valid = actualValue.stringValid()
        val newValue = if (!valid) number else actualValue + number
        result(newValue)
    }
    private fun setExpression(actualValue : String, value: String) = actualValue.verifyExpressions(value)
}