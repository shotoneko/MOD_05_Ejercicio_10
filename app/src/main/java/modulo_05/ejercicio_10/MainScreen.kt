package modulo_05.ejercicio_10


import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import modulo_05.ejercicio_10.components.MySegmentedButton
import modulo_05.ejercicio_10.components.MyText
import modulo_05.ejercicio_10.components.MyTextField


@Composable
fun MainScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .fillMaxSize(),// Padding del Scaffold

        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var edad by rememberSaveable { mutableStateOf("") }
        var peso by rememberSaveable { mutableStateOf("") }
        var altura by rememberSaveable { mutableStateOf("") }
        var imc by rememberSaveable { mutableDoubleStateOf(0.0) }


        LaunchedEffect(peso, altura) {
            // Lanzar efecto cuando peso o altura cambien
            val pesoDouble = peso.toDoubleOrNull()
            val alturaDouble = altura.toDoubleOrNull()
            if (pesoDouble != null && alturaDouble != null && alturaDouble !=0.0) {
                imc = calcularIMC(pesoDouble, alturaDouble)
            }
        }
        MyText(text = stringResource(id=R.string.tituloApp))
        MySegmentedButton()
        Column(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            MyTextField(
                text = edad,
                onValueChange = { edad = it },
                label = stringResource(id = R.string.edad)
            )
            MyTextField(
                text = peso,
                onValueChange = { peso = it },
                label = stringResource(id = R.string.peso)
            )
            MyTextField(
                text = altura,
                onValueChange = { altura = it },
                label = stringResource(id = R.string.altura)
            )

            Text(text = stringResource(id = R.string.calcular))


            if (imc != 0.0){
                Text(text = imc.toString(),  fontSize = 50.sp, fontWeight = FontWeight.SemiBold)
            }}
    }
}
fun calcularIMC(peso: Double, altura: Double): Double {
    val imc = peso / (altura * altura)
    val df = DecimalFormat("#.##")
    return df.format(imc).toDouble()
}
