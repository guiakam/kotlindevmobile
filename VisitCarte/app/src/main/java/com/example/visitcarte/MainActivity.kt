package com.example.visitcarte

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcarte.ui.theme.VisitCarteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCarteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xFFA680E2)
                ) {
                    CarteVisit()
                }
            }
        }
    }
}



@Composable
fun CarteVisit() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Logo Image
            Row(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(Color.Black),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.t_l_charg___12_),
                    contentDescription = " Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                        .background(Color.Black)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Name and Function
            Text("Guiakam TAMO Audrey", fontSize = 24.sp, color = Color.Black)
            Text("Developpeur Android", fontSize = 18.sp, color = Color.Green)
        }
        Spacer(modifier = Modifier.height(150.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            // Phone Contact
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_local_phone_24),
                    contentDescription = "Phone Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Green
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "+237 655 028 052", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Email Contact
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_email_24),
                    contentDescription = "Email Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Green
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "guiakamaudrey3@gmail.com", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Address Contact
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_location_on_24),
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Green
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Douala, Cameroun", fontSize = 16.sp)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitCarteTheme {
        CarteVisit()
    }
}