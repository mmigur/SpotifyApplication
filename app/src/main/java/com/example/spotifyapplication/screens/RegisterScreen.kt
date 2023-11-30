package com.example.spotifyapplication.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import androidx.navigation.NavController
import com.example.spotifyapplication.R
import com.example.spotifyapplication.Screen
import com.example.spotifyapplication.ui.theme.DividerGrayColor
import com.example.spotifyapplication.ui.theme.ExtraLightGray
import com.example.spotifyapplication.ui.theme.GreenSpotify
import com.example.spotifyapplication.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController
) {
    val mContext = LocalContext.current
    var fullNameText by remember { mutableStateOf(TextFieldValue("")) }
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordText by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.padding(start = 27.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FilledIconButton(
                onClick = {
                    navController.navigateUp()
                },
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = ExtraLightGray)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.arrow_left),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.spotify_logo_mini),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(2f))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Register",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(22.dp))
        Row {
            Text(
                text = "If You Need Any Support ",
                color = Color.Black,
                fontSize = 12.sp)
            Text(
                text = "Click Here",
                color = GreenSpotify,
                fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            modifier = Modifier
                .testTag("fullNameTextField")
                .height(80.dp)
                .width(334.dp),
            value = fullNameText,
            onValueChange = {fullNameText = it},
            placeholder = { Text(text = "Full Name") },
            shape = RoundedCornerShape(30.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .testTag("emailTextField")
                .height(80.dp)
                .width(334.dp),
            value = emailText,
            onValueChange = {emailText = it},
            placeholder = { Text(text = "Enter Email") },
            shape = RoundedCornerShape(30.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .testTag("passwordTextField")
                .height(80.dp)
                .width(334.dp),
            value = passwordText,
            onValueChange = {passwordText = it},
            placeholder = { Text(text = "Password") },
            shape = RoundedCornerShape(30.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icon(
                        imageVector = ImageVector.vectorResource(
                                id = R.drawable.visible_off,
                            ),
                        contentDescription = null)
                else Icon( imageVector = ImageVector.vectorResource( id = R.drawable.visible_on,), contentDescription = null)

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    image
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .height(80.dp)
                .width(325.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(GreenSpotify),
            onClick = {
                if (fullNameText.text.isNullOrEmpty()){
                    Toast.makeText(
                        mContext,
                        "Input name field is null",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else {
                    if(fullNameText.text.length > 2){
                        // shared
                    }
                }

                if (emailText.text.isNullOrEmpty()){
                    Toast.makeText(
                        mContext,
                        "Input email field is null",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else{
                    if (isEmailValid(emailText.text)) {
                        // shared
                    } else {
                        Toast.makeText(
                            mContext,
                            "Input email field is not correct",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                if (passwordText.isNullOrEmpty()){
                    Toast.makeText(
                        mContext,
                        "Input password field is null",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else{
                    if(passwordText.length >= 8){
                        if(containsOnlyDigitsAndSpecialCharacters(passwordText)){
                            // shared
                        }
                        else{
                            Toast.makeText(
                                mContext,
                                "Input password field is not correct",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    else{
                        Toast.makeText(
                            mContext,
                            "Input password field is short",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }) {
            Text(
                text = "Creat Account",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(21.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Divider(
                modifier = Modifier.width(140.dp),
                thickness = 1.dp,
                color = DividerGrayColor
            )
            Spacer(modifier = Modifier.width(11.dp))
            Text(text = "OR")
            Spacer(modifier = Modifier.width(11.dp))
            Divider(
                modifier = Modifier.width(140.dp),
                thickness = 1.dp,
                color = DividerGrayColor
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(58.dp))
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.apple_logo),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Text(
                text = "Do You Have An Account? ",
                color = Color.Black,
                fontSize = 14.sp)
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignIn.route)
                },
                text = "Sign In",
                color = LightBlue,
                fontSize = 14.sp)
        }
    }
}

fun isEmailValid(email: String): Boolean {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return email.matches(emailPattern.toRegex())
}

fun containsOnlyDigitsAndSpecialCharacters(input: String): Boolean {
    val pattern = "[\\d!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+"
    return input.matches(pattern.toRegex())
}

