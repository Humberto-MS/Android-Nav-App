package com.example.navapp.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.navapp.R
import com.example.navapp.components.MainIconButton
import com.example.navapp.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView ( navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                            navController.popBackStack()
                        }
                        TitleBar(name = "Calculator View")
                        MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowForward) {
                            navController.navigate("Lottery")
                        }
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {
        ShowLayout ( modifier = Modifier )
    }
}

@Composable
fun ShowLayout ( modifier: Modifier = Modifier ) {
    val imagen = painterResource( id = R.drawable.perrito )
    var edad by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image (
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Text (
            text = "Mi edad perruna \uD83D\uDC15",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        )
        OutlinedTextField (
            value = edad,

            leadingIcon = { Icon (
                imageVector = Icons.Default.Edit,
                contentDescription = "editIcon"
            ) },

            onValueChange = { newEdad ->
                if ( newEdad.isDigitsOnly() ) {
                    edad = newEdad
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, ingresa solo números",
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            label = { Text ( text = "Edad Humana" ) },
            placeholder = { Text ( text = "Edad Humana" ) },

            colors = OutlinedTextFieldDefaults.colors (
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.DarkGray
            ),

            modifier = Modifier
                .width(350.dp)
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        Button (
            onClick = {
                var res = 0
                res = edad.toInt() * 7
                resultado = res.toString()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .padding(20.dp)
        ) {
            Text ( text = "Calcular" )
        }
        OutlinedTextField (
            value = resultado,

            leadingIcon = { Icon (
                imageVector = Icons.Default.Edit,
                contentDescription = "editIcon"
            ) },

            onValueChange = { newResultado -> resultado = newResultado },
            label = { Text ( text = "Edad Perruna" ) },
            placeholder = { Text ( text = "Edad Perruna" ) },
            readOnly = true,

            colors = OutlinedTextFieldDefaults.colors (
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.DarkGray
            ),

            modifier = Modifier
                .width(350.dp)
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
        )
        Button (
            onClick = {
                edad = ""
                resultado = ""
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .width(250.dp)
                .padding(20.dp, 0.dp, 20.dp, 30.dp)
        ) {
            Text ( text = "Borrar" )
        }
    }
}