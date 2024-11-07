package com.example.aplikasimetricconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikasimetricconverter.ui.theme.AplikasiMetricConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiMetricConverterTheme {
                MetricConverterApp()
            }
        }
    }
}

@Composable
fun MetricConverterApp() {
    var selectedMetric by remember { mutableStateOf("Panjang") }
    var fromUnit by remember { mutableStateOf("Meter") }
    var toUnit by remember { mutableStateOf("Centimeter") }
    var inputValue by remember { mutableStateOf("") }
    var conversionResult by remember { mutableStateOf("") }

    val lengthUnits = listOf("Kilometer", "Meter", "Centimeter", "Millimeter")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Metric Converter",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "By: Teofide Pangemanan",
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Pilih Metrik")
        DropdownMenu(selectedMetric, listOf("Panjang")) { selectedMetric = it }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Dari:")
        DropdownMenu(fromUnit, lengthUnits) { fromUnit = it }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Ke:")
        DropdownMenu(toUnit, lengthUnits) { toUnit = it }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text("Masukkan Nilai") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            conversionResult = convertLength(inputValue.toDoubleOrNull() ?: 0.0, fromUnit, toUnit)
        }) {
            Text("Konversi")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hasil: $conversionResult",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DropdownMenu(selectedValue: String, options: List<String>, onSelectionChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        Button(onClick = { expanded = true }) {
            Text(selectedValue)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    onSelectionChange(option)
                    expanded = false
                }) {
                    Text(option)
                }
            }
        }
    }
}

fun convertLength(value: Double, fromUnit: String, toUnit: String): String {
    val conversionRates = mapOf(
        "Kilometer" to 1000.0,
        "Meter" to 1.0,
        "Centimeter" to 0.01,
        "Millimeter" to 0.001
    )

    val fromRate = conversionRates[fromUnit] ?: return "Invalid"
    val toRate = conversionRates[toUnit] ?: return "Invalid"
    val result = value * fromRate / toRate
    return result.toString()
}
