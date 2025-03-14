package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.lang.Integer.parseInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Marc general on s'han d'incloure tots els elements de la interficie d'usuari de l'app
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        // Write your code here

        // Bloc on va la imatge i el títol de l'app
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Write your code here

            // Imatge del títol de l'app
            Image(painter = painterResource(id = R.drawable.itb_logo), contentDescription = "ITB")

            // Text del títol de l'app
            Text(
                text = "M15 - Android",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
        // Cos de l'app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // Write your code here

            // Títol de l'exercici
            Text(
                text = "EXERCICI PARELL O SENAR",
                fontSize = 24.sp,
                modifier = modifier
            )
            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))
            // text esplicatiu
            Text(
                text = "Si us plau, introdueix un número per comprovar si és parell o senar.",
                modifier = modifier
            )
            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))
            // Text pel missatge (EVEN - ODD)
            var message by rememberSaveable { mutableStateOf("") }
            Text(
                text = message,
                fontSize = 48.sp,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
            )
            // Quadre de text per introduir el número
            var text by rememberSaveable { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
            )
            // Botó per verifiar el número
            Button(modifier =Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Gray
                ), onClick = {
                    try {
                        val num = parseInt(text)
                        if (num < 0) {
                            throw NumberFormatException()
                        }
                        if ((num % 2) == 0) {
                            message = "Even"
                        } else {
                            message = "Odd"
                        }
                    } catch (e: NumberFormatException) {
                        message = "String is not a number or is less than zero."
                    }
                }) {
                Text(text = "Comprovar")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Saray")
    }
}