package com.example.unitconvertor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnitConverter(viewModel: UnitConvertorViewModel){






    Column( //column  ui elements stacked below each other
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center, //vertical arrangement
        horizontalAlignment = Alignment.CenterHorizontally){ //horizontal allignment

        @Composable
        fun textStyle(text :String){
            BasicTextField(
                value = text,
                onValueChange = { /* Handle value change */ },
                textStyle = TextStyle(

                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic
                )
            )
        }

        textStyle("unit Converter")
        Spacer(modifier = Modifier.height(18.dp))

        //outlinedtextfield contains value that the field allows to enter the value.
        //outlinedtextfield contains onValueChange that tells us what to do when the value changes.
        OutlinedTextField(value = viewModel.inputValue.value, onValueChange ={
            viewModel.inputValue.value=it
            viewModel.convertUnits() }, label = { Text(text = "enter a value") })

        //it : it is the string that we are taking into the inputValue
        //here goes what should happen, when the value of our outlinedextField changes
        //label is used to guide the user what to enter


        Spacer(modifier = Modifier.height(18.dp))

        Row {
            //ui elements stacked next to each other
            //input box
            Box {
                // It arranges stack composables  on top of each other.

                //first button contains input unit
                Button(onClick = {viewModel.iExpanded.value =true }) {
                    Text(text = viewModel.inputUnit.value)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = "Arrow Down")
                }

                //dropdown of first button
                //expanded helps to expand the dropdown
                //ondismissreguest helps to dismiss the dropdown menu
                DropdownMenu(expanded =viewModel.iExpanded.value, onDismissRequest = { viewModel.iExpanded.value=false }) {
                    DropdownMenuItem(
                        text = { Text("centimeters") },
                        onClick = {
                            viewModel.iExpanded.value=false
                            viewModel.inputUnit.value="centimeters"
                            viewModel.convertionFactor.value = 0.01
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("meters") },
                        onClick = {
                            viewModel.iExpanded.value=false
                            viewModel.inputUnit.value="meters"
                            viewModel.convertionFactor.value = 1.0
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("milimeter") },
                        onClick = {
                            viewModel.iExpanded.value=false
                            viewModel.inputUnit.value="milimeter"
                            viewModel.convertionFactor.value = 0.001
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "feet") },
                        onClick = {
                            viewModel.iExpanded.value=false
                            viewModel.inputUnit.value="feet"
                            viewModel.convertionFactor.value = 0.3048
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "kilometer") },
                        onClick = {
                            viewModel.iExpanded.value=false
                            viewModel.inputUnit.value="kilometer"
                            viewModel.convertionFactor.value = 1000.0
                            viewModel.convertUnits()
                        })

                }
            }

            Spacer(modifier = Modifier.width(16.dp))
            //output box
            Box {

                //second button contains output unit
                Button(onClick = { viewModel.oExpanded.value=true}) {
                    Text(text = viewModel.outputUnit.value)
                    Icon(Icons.Default.ArrowDropDown,contentDescription = "Arrow Down")
                }

                //Dropdown for the second button
                DropdownMenu(expanded = viewModel.oExpanded.value, onDismissRequest = {viewModel.oExpanded.value=false }) {
                    DropdownMenuItem(text = { Text(text = "centimeter") },
                        onClick = {viewModel.oExpanded.value=false
                            viewModel.outputUnit.value="centimeters"
                            viewModel.oConvertionFactor.value = 0.01
                            viewModel.convertUnits()})
                    DropdownMenuItem(text = { Text(text = "meters") },
                        onClick = {viewModel.oExpanded.value=false
                            viewModel.outputUnit.value="meters"
                            viewModel.oConvertionFactor.value = 1.00
                            viewModel.convertUnits() })
                    DropdownMenuItem(text = { Text(text = "millimeter") },
                        onClick = { viewModel.oExpanded.value=false
                            viewModel.outputUnit.value="millimeter"
                            viewModel.oConvertionFactor.value = 0.01
                            viewModel.convertUnits()})
                    DropdownMenuItem(text = { Text(text = "feet") },
                        onClick = { viewModel.oExpanded.value=false
                            viewModel.outputUnit.value="feet"
                            viewModel.oConvertionFactor.value = 0.3048
                            viewModel.convertUnits()})
                    DropdownMenuItem(text = { Text(text = "kilometer") },
                        onClick = { viewModel.oExpanded.value=false
                            viewModel.outputUnit.value="kilometer"
                            viewModel.oConvertionFactor.value = 1000.0
                            viewModel.convertUnits() })

                }
            }

        }
        Spacer(modifier = Modifier.height(18.dp))

        //for currency
        Row {

            //Ist Box
            Box{
                //1st Button
                Button(onClick = { viewModel.icurrencyExpanded.value=true}) {
                    Text(text = viewModel.icurrencyButton.value)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }
                DropdownMenu(expanded = viewModel.icurrencyExpanded.value, onDismissRequest = {viewModel.icurrencyExpanded.value=false }) {
                    DropdownMenuItem(text ={ Text(text = "Rupees(\u20B9)") } ,
                        onClick = {
                            viewModel.icurrencyExpanded.value=false
                            viewModel.iCurrencyUnit.value="₹"
                            viewModel.icurrencyButton.value = "Rupees"
                            viewModel.inputCurrency.value=83.50
                            viewModel.convertCurrecncy()
                        })
                    DropdownMenuItem(text ={ Text(text = "Dollar($)") } ,
                        onClick = {
                            viewModel.icurrencyExpanded.value=false
                            viewModel.icurrencyButton.value="$"
                            viewModel.iCurrencyUnit.value="Dollar"
                            viewModel.inputCurrency.value=1.0
                            viewModel.convertCurrecncy()
                        })
                    DropdownMenuItem(text ={ Text(text = "euro(\u20AC)") } ,
                        onClick = {
                            viewModel.icurrencyExpanded.value=false
                            viewModel.iCurrencyUnit.value="€"
                            viewModel.icurrencyButton.value="Euro"
                            viewModel.inputCurrency.value=0.92
                            viewModel.convertCurrecncy()
                        })
                    DropdownMenuItem(text ={ Text(text = "Saudi riyal(لل)") } ,
                        onClick = {
                            viewModel.icurrencyExpanded.value=false
                            viewModel.iCurrencyUnit.value="ل"
                            viewModel.icurrencyButton.value="Saudi Riyal"
                            viewModel.inputCurrency.value=3.75
                            viewModel.convertCurrecncy()
                        })

                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //2nd box
            Box {
                //2nd button
                Button(onClick = { viewModel.ocurrencyExpanded.value=true}) {
                    Text(text = viewModel.ocurrencyButton.value)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }
                DropdownMenu(expanded = viewModel.ocurrencyExpanded.value, onDismissRequest = { viewModel.ocurrencyExpanded.value=false }) {
                    DropdownMenuItem(text ={ Text(text = "Rs(\u20B9)") } ,
                        onClick = {
                            viewModel.ocurrencyExpanded.value=false
                            viewModel.oCurrencyUnit.value="₹"
                            viewModel.ocurrencyButton.value="Rupees"
                            viewModel.outputCurrency.value=83.50
                            viewModel.convertCurrecncy()
                        })
                    DropdownMenuItem(text ={ Text(text = "Dollar($)") } ,
                        onClick = {
                            viewModel.ocurrencyExpanded.value=false
                            viewModel.oCurrencyUnit.value="$"
                            viewModel.ocurrencyButton.value="Dollar"
                            viewModel.outputCurrency.value=1.00
                            viewModel.convertCurrecncy()
                        })
                    DropdownMenuItem(text ={ Text(text = "euro(\u20AC)") } ,
                        onClick = {
                            viewModel.ocurrencyExpanded.value=false
                            viewModel.oCurrencyUnit.value="€"
                            viewModel.ocurrencyButton.value="Euro"
                            viewModel.outputCurrency.value=0.92
                            viewModel.convertCurrecncy()
                        })

                    DropdownMenuItem(text ={ Text(text = "saudi Riyal(\u0644)") } ,
                        onClick = {
                            viewModel.ocurrencyExpanded.value=false
                            viewModel.oCurrencyUnit.value="ل"
                            viewModel.ocurrencyButton.value="Saudi Riyal"
                            viewModel.outputCurrency.value=3.75
                            viewModel.convertCurrecncy()


                        })


                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Text(text = "result :  ${viewModel.outputValue.value}", style = MaterialTheme.typography.headlineSmall)

    }
}