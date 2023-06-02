package com.gdsdevtec.calcpucpr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.calcpucpr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var operator: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        numbersListeners()
        operatorsListeners()
    }

    private fun operatorsListeners() = with(binding) {
        btnClearAc.setOnClickListener {
            visorCalc.clear()
        }
        btnPercent.setOnClickListener {
            operator = btnPercent.getValue()
            addExpressionValue(btnPercent.getValue())
        }
        btnDivider.setOnClickListener {
            operator = btnDivider.getValue()
            addExpressionValue(btnDivider.getValue())
        }
        btnMultiply.setOnClickListener {
            operator = btnMultiply.getValue()
            addExpressionValue(btnMultiply.getValue())
        }
        btnMinus.setOnClickListener {
            operator = btnMinus.getValue()
            addExpressionValue(btnMinus.getValue())
        }
        btnAdd.setOnClickListener {
            operator = btnAdd.getValue()
            addExpressionValue(btnAdd.getValue())
        }
        btnEquals.setOnClickListener {
            val isValueValid = binding.visorCalc.validateValueForCalc()
            if (isValueValid) {
                val numbersCalc = getVisorText().split(operator)
                val firstNumber = numbersCalc.first().replace(",",".").toDouble()
                val lastNumber = numbersCalc.last().replace(",",".").toDouble()
                calculate(firstNumber, operator, lastNumber)
            }
        }
    }

    private fun calculate(firstNumber: Double, operator: String, lastNumber: Double) {
        when (operator) {
            Constants.PERCENT -> {
                val result = (lastNumber * firstNumber) / 100
                binding.visorCalc.setValue(result)
            }
            Constants.DIVIDER -> {
                if(firstNumber != 0.0){
                    binding.visorCalc.setValue(firstNumber / lastNumber)
                }else binding.visorCalc.setValue("Error")
            }
            Constants.MULTIPLY -> {
                val result = firstNumber * lastNumber
                binding.visorCalc.setValue(result)
            }
            Constants.MINUS -> {
                val result = firstNumber - lastNumber
                binding.visorCalc.setValue(result)
            }
            Constants.PLUS -> {
                val result = firstNumber + lastNumber
                binding.visorCalc.setValue(result)
            }
        }
    }

    private fun addExpressionValue(value: String) {
        when (value) {
            Constants.PERCENT -> {
                operator = value
                binding.visorCalc.setValue(setExpression(value))
            }

            Constants.DIVIDER -> {
                binding.visorCalc.setValue(setExpression(value))
            }

            Constants.MULTIPLY -> {
                binding.visorCalc.setValue(setExpression(value))
            }

            Constants.MINUS -> {
                binding.visorCalc.setValue(setExpression(value))
            }

            Constants.PLUS -> {
                binding.visorCalc.setValue(setExpression(value))
            }
        }
    }

    private fun setExpression(value: String) = getVisorText().verifyExpressions(value)

    private fun numbersListeners() = with(binding) {
        btnOne.setOnClickListener {
            setNumberValue(btnOne.getValue())
        }
        btnTwo.setOnClickListener {
            setNumberValue(btnTwo.getValue())
        }
        btnTree.setOnClickListener {
            setNumberValue(btnTree.getValue())
        }
        btnFour.setOnClickListener {
            setNumberValue(btnFour.getValue())
        }
        btnFive.setOnClickListener {
            setNumberValue(btnFive.getValue())
        }
        btnSix.setOnClickListener {
            setNumberValue(btnSix.getValue())
        }
        btnSeven.setOnClickListener {
            setNumberValue(btnSeven.getValue())
        }
        btnEight.setOnClickListener {
            setNumberValue(btnEight.getValue())
        }
        btnNine.setOnClickListener {
            setNumberValue(btnNine.getValue())
        }
        btnZero.setOnClickListener {
            setNumberValue(btnZero.getValue())
        }
        btnPoint.setOnClickListener {
            setFloatPoint()
        }
    }

    private fun setFloatPoint() = with(binding) {
        if (visorCalc.isValueValid()) visorCalc.setValue(getPoint())
    }

    private fun getPoint(): String {
        val isContainsPoint = getVisorText().contains(getString(R.string.number_point))
        return if (!isContainsPoint) getVisorText() + getString(R.string.number_point) else ""
    }

    private fun setNumberValue(number: String) = with(binding) {
        val valid = getVisorText().stringValid()
        val newValue = if (!valid) number else getVisorText() + number
        visorCalc.setValue(newValue)
    }

    private fun getVisorText(): String = binding.visorCalc.text.toString()


}