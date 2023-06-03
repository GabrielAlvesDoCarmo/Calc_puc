package com.gdsdevtec.calcpucpr.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.calcpucpr.R
import com.gdsdevtec.calcpucpr.clear
import com.gdsdevtec.calcpucpr.utils.Calculate.addExpressionValue
import com.gdsdevtec.calcpucpr.utils.Calculate.executeCalc
import com.gdsdevtec.calcpucpr.utils.Calculate.setNumberValue
import com.gdsdevtec.calcpucpr.databinding.ActivityMainBinding
import com.gdsdevtec.calcpucpr.getValue
import com.gdsdevtec.calcpucpr.isValueValid
import com.gdsdevtec.calcpucpr.setValue
import com.gdsdevtec.calcpucpr.validateValueForCalc

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
    private fun numbersListeners() = with(binding) {
        btnOne.setOnClickListener {
            setNumberValue(getVisorText(),btnOne.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnTwo.setOnClickListener {
            setNumberValue(getVisorText(),btnTwo.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnTree.setOnClickListener {
            setNumberValue(getVisorText(),btnTree.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnFour.setOnClickListener {
            setNumberValue(getVisorText(),btnFour.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnFive.setOnClickListener {
            setNumberValue(getVisorText(),btnFive.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnSix.setOnClickListener {
            setNumberValue(getVisorText(),btnSix.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnSeven.setOnClickListener {
            setNumberValue(getVisorText(),btnSeven.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnEight.setOnClickListener {
            setNumberValue(getVisorText(),btnEight.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnNine.setOnClickListener {
            setNumberValue(getVisorText(),btnNine.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnZero.setOnClickListener {
            setNumberValue(getVisorText(),btnZero.getValue()){newValue->
                visorCalc.setValue(newValue)
            }
        }
        btnPoint.setOnClickListener {
            setFloatPoint()
        }
    }

    private fun operatorsListeners() = with(binding) {
        btnClearAc.setOnClickListener {
            visorCalc.clear()
        }
        btnPercent.setOnClickListener {
            operator = btnPercent.getValue()
            addExpressionValue(visorCalc,getVisorText(),btnPercent.getValue())
        }
        btnDivider.setOnClickListener {
            operator = btnDivider.getValue()
            addExpressionValue(visorCalc,getVisorText(),btnDivider.getValue())
        }
        btnMultiply.setOnClickListener {
            operator = btnMultiply.getValue()
            addExpressionValue(visorCalc,getVisorText(),btnMultiply.getValue())
        }
        btnMinus.setOnClickListener {
            operator = btnMinus.getValue()
            addExpressionValue(visorCalc,getVisorText(),btnMinus.getValue())
        }
        btnAdd.setOnClickListener {
            operator = btnAdd.getValue()
            addExpressionValue(visorCalc,getVisorText(),btnAdd.getValue())
        }
        btnEquals.setOnClickListener {
            if (visorCalc.validateValueForCalc()) executeCalc(getVisorText(),operator){
                visorCalc.setValue(it)
            }
        }
    }

    private fun setFloatPoint() = with(binding) {
        if (visorCalc.isValueValid()) visorCalc.setValue(getPoint())
    }

    private fun getPoint(): String {
        val isContainsPoint = getVisorText().contains(getString(R.string.number_point))
        return if (!isContainsPoint) getVisorText() + getString(R.string.number_point) else ""
    }

    private fun getVisorText(): String = binding.visorCalc.text.toString()
}