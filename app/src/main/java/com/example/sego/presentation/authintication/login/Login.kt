package com.example.sego.presentation.authintication.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sego.presentation.compoasble.CustomButton
import com.example.sego.presentation.compoasble.CustomTextFieldWithIcon
import com.example.sego.presentation.compoasble.HeaderImage

@Composable
fun Login(
    context: Context,
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    var dialogVisibility by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        HeaderImage()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.W700)
        CustomTextFieldWithIcon(
            value = loginViewModel._email.value,
            onValueChanged = { newEmail ->
                loginViewModel.setEmail(newEmail)
            },
            icon = Icons.TwoTone.Email,
            label = "Email"
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextFieldWithIcon(
            value = loginViewModel._password.value,
            onValueChanged = { newPassword -> loginViewModel.setPassword(newPassword)},
            icon = Icons.TwoTone.Lock,
            label = "Password"
        )
        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(text = "Login") {
            Toast.makeText(context, "you are logged in", Toast.LENGTH_SHORT).show()
        }

        Text(text = "Forgot Password?")
        Divider(
            Modifier
                .height(2.dp)
                .width(135.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Divider(
                Modifier
                    .padding(top = 10.dp)
                    .height(2.dp)
                    .width(130.dp)
            )
            Text(text = "OR", modifier = Modifier.padding(start = 20.dp, end = 20.dp))
            Divider(
                Modifier
                    .padding(top = 10.dp)
                    .height(2.dp)
                    .width(130.dp)
            )
        }

        OutlinedButton(
            onClick = { dialogVisibility = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 50.dp, bottom = 50.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            Text(text = "Signup")
        }

        CheckDialog(navController = navController, visable = dialogVisibility) {
            dialogVisibility.not()
        }
    }
}

