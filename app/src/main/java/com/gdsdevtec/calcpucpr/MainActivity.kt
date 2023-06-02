package com.gdsdevtec.calcpucpr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.calcpucpr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupActivity()
    }

    private fun setupActivity() {
        setupListeners()
        observer()
    }

    private fun observer() {

    }

    private fun setupListeners() {
        numbersListeners()
        operatorsListeners()
    }

    private fun operatorsListeners() = with(binding) {
        btnClearAc.setOnClickListener {
            clearCalc()
        }
        btnPercent.setOnClickListener {

        }
        btnDivider.setOnClickListener {

        }
        btnMultiply.setOnClickListener {

        }
        btnMinus.setOnClickListener {

        }
        btnAdd.setOnClickListener {

        }
        btnEquals.setOnClickListener {

        }
    }

    private fun clearCalc() = with(binding) {
        visorCalc.text = ""
    }

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
        val actual = getVisorText()
        val isContainsPoint = actual.contains(getString(R.string.number_point))
        return if (!isContainsPoint) getVisorText() + getString(R.string.number_point) else ""
    }

    private fun setNumberValue(number: String) = with(binding) {
        val valid = getVisorText().stringValid()
        val newValue = if (!valid) number else getVisorText() + number
        visorCalc.setValue(newValue)
    }

    private fun getVisorText(): String {
        return binding.visorCalc.text.toString()
    }

}