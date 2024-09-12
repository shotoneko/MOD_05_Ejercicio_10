package modulo_05.ejercicio_10


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import modulo_05.ejercicio_10.components.MyButton
import modulo_05.ejercicio_10.components.MySegmentedButton
import modulo_05.ejercicio_10.components.MyText
import modulo_05.ejercicio_10.components.MyTextField


@Composable
fun MainScreen(paddingValues: PaddingValues) {

    val bottomPadding = WindowInsets.systemBars
        .asPaddingValues()
        .calculateBottomPadding()
    Column(
        modifier = Modifier

            .fillMaxWidth()
            .padding(paddingValues)
            .padding(top = 16.dp),// Padding del Scaffold

        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var edad by remember { mutableStateOf("") }
        var peso by remember { mutableStateOf("") }
        var altura by remember { mutableStateOf("") }
        MyText(text = stringResource(id=R.string.tituloApp))
        MySegmentedButton()
        MyTextField(text = "", onValueChange = {edad = it}, label = stringResource(id = R.string.edad) )
        MyTextField(text = "", onValueChange = {peso = it }, label = stringResource(id = R.string.peso))
        MyTextField(text = "", onValueChange = {altura = it }, label = stringResource(id = R.string.altura))
        MyButton(text = stringResource(id = R.string.calcular))


    }
}

