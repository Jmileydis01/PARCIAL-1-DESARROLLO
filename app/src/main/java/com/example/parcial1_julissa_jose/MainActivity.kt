package com.example.parcial1_julissa_jose
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValidarNotaApp()
        }
    }
}

@Composable
fun ValidarNotaApp() {
    val context = LocalContext.current
    var notaTexto by remember { mutableStateOf("") }

    fun validarNota(nota: Int): String {
        return when {
            nota in 91..100 -> "A (Excelente)"
            nota in 81..90 -> "B (Bueno)"
            nota in 71..80 -> "C (Regular)"
            nota in 61..70 -> "D (Más o menos regular)"
            nota < 61 -> " F No Aprobado"
            else -> "Nota inválida"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3D9FF)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Parcial #1", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("JULISSA MORALES")
            Text("JOSE PALACIO")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Ingrese la nota a validar")
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = notaTexto,
                onValueChange = { notaTexto = it },
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val nota = notaTexto.toIntOrNull()
                    val resultado = if (nota != null) validarNota(nota) else "Ingrese un número válido"
                    Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CEFA))
            ) {
                Text("Validar")
            }
        }
    }
}