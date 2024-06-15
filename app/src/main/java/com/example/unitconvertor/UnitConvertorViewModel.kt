package com.example.unitconvertor

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UnitConvertorViewModel : ViewModel() {

    var inputValue = mutableStateOf("")
        private set
    var outputValue =  mutableStateOf("")
        private set
    var inputUnit=  mutableStateOf("meter")
        private set
    var outputUnit =  mutableStateOf("meter")
        private set
    var iExpanded  = mutableStateOf(false)
        private set
    var oExpanded =  mutableStateOf(false)
        private set
    var convertionFactor =  mutableStateOf(1.00)
        private set
    var oConvertionFactor =  mutableStateOf(1.0)
        private set

    var inputCurrency = mutableStateOf(1.0)
        private set
    var outputCurrency = mutableStateOf(1.0)
        private set
    var iCurrencyUnit =  mutableStateOf(" ")
        private set
    var oCurrencyUnit   =  mutableStateOf(" ")
        private set
    var icurrencyExpanded =  mutableStateOf(false)
        private set
    var ocurrencyExpanded =  mutableStateOf(false)
        private set
    var icurrencyButton =  mutableStateOf("Dollar")
        private set
    var ocurrencyButton = mutableStateOf(" Dollar")
        private set

    fun convertUnits(){
        // ?: elvis operator - if  the netered value is not number it gives 0.0.
        val inputValueDouble = inputValue.value.toDoubleOrNull()?:0.0
        val result = (inputValueDouble * convertionFactor.value*100.0/oConvertionFactor.value)/100
        outputValue.value =  String.format("%.4f", result)

    }

    fun convertCurrecncy(){

        val inputValueDouble = inputValue.value.toDoubleOrNull()?:0.0
        val result = (inputValueDouble * outputCurrency.value*100.0/inputCurrency.value)/100
        outputValue.value= " ${oCurrencyUnit.value
        }"+String.format("%.2f",result)
    }
}