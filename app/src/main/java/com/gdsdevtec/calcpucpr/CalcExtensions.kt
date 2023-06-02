package com.gdsdevtec.calcpucpr

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

fun String.stringValid() = this.isNotEmpty() && this != "0"
fun AppCompatTextView.isValueValid() = this.text.toString().isNotEmpty()
fun AppCompatTextView.clear() {
    this.text = ""
}

fun AppCompatButton.getValue() = this.text.toString()
fun AppCompatTextView.setValue(value: String) {
    if (value.isNotEmpty()) this.text = value
}

fun AppCompatTextView.setValue(value: Double) {
    this.text = value.toString()
}


fun String.verifyExpressions(actual: String): String {
    return when (actual) {
        Constants.PERCENT -> {
            if (!this.contains(Constants.DIVIDER) && !this.contains(Constants.MULTIPLY) &&
                !this.contains(Constants.MINUS) && !this.contains(Constants.PLUS)
                && !this.contains(Constants.PERCENT) && this.isNotEmpty()
            ) this + actual else this
        }

        Constants.DIVIDER -> {
            if (!this.contains(Constants.PERCENT) && !this.contains(Constants.MULTIPLY) &&
                !this.contains(Constants.MINUS) && !this.contains(Constants.PLUS)
                && !this.contains(Constants.DIVIDER) && this.isNotEmpty()
            ) this + actual else this
        }

        Constants.MULTIPLY -> {
            if (!this.contains(Constants.PERCENT) && !this.contains(Constants.DIVIDER) &&
                !this.contains(Constants.MINUS) && !this.contains(Constants.PLUS)
                && !this.contains(Constants.MULTIPLY) && this.isNotEmpty()
            ) this + actual else this
        }

        Constants.MINUS -> {
            if (!this.contains(Constants.PERCENT) && !this.contains(Constants.DIVIDER) &&
                !this.contains(Constants.MULTIPLY) && !this.contains(Constants.PLUS)
                && !this.contains(Constants.MINUS) && this.isNotEmpty()
            ) this + actual else this
        }

        Constants.PLUS -> {
            if (!this.contains(Constants.PERCENT) && !this.contains(Constants.DIVIDER) &&
                !this.contains(Constants.MULTIPLY) && !this.contains(Constants.MINUS)
                && !this.contains(Constants.PLUS) && this.isNotEmpty()
            ) this + actual else this
        }

        else -> {
            ""
        }
    }
}

fun AppCompatTextView.afterTextChange(afterTextChange: (String) -> Unit) {
    this.addTextChangedListener(
        object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                afterTextChange.invoke(editable.toString())
            }
        }
    )
}

fun AppCompatTextView.validateValueForCalc(): Boolean {
    return this.text.matches(Constants.CALC_FOR_REGEX.toRegex())
}