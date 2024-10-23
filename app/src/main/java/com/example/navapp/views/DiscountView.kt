package com.example.navapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navapp.components.MainIconButton
import com.example.navapp.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountView ( navController: NavController ) {
    Scaffold (
        topBar = {
            TopAppBar (
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Green
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TitleBar(name = "Discount View")
                        MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowForward) {
                            navController.navigate("Calculator")
                        }
                    }
                }
            )
        }
    ) {
        DiscountContent()
    }
}

@Composable
fun DiscountContent() {
    var precio by remember { mutableStateOf("") }
    var porcentaje by remember { mutableStateOf("") }
    var precioFinal by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField (
            value = precio,
            onValueChange = { newPrecio -> precio = newPrecio },
            label = { Text ( text = "Precio" ) },
            placeholder = { Text ( text = "Precio" ) },

            colors = OutlinedTextFieldDefaults.colors (
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.DarkGray
            ),

            modifier = Modifier
                .width(300.dp)
        )
        OutlinedTextField (
            value = porcentaje,
            onValueChange = { newPorcentaje -> porcentaje = newPorcentaje },
            label = { Text ( text = "% de Descuento" ) },
            placeholder = { Text ( text = "% de Descuento" ) },

            colors = OutlinedTextFieldDefaults.colors (
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.DarkGray
            ),

            modifier = Modifier
                .width(300.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button (
                onClick = {
                    descuento = (precio.toDouble() * ( porcentaje.toDouble()/100 )).toString()
                    precioFinal = (precio.toDouble() - descuento.toDouble()).toString()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            ) {
                Text ( text = "Calcular" )
            }
            Button (
                onClick = {
                    precio = ""
                    porcentaje = ""
                    descuento = ""
                    precioFinal = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            ) {
                Text ( text = "Borrar" )
            }
        }
        Text ( text = "Descuento = $descuento")
        Text ( text = "Precio Final = $precioFinal")
    }
}

